package repository;

import Exceptions.NotFoundException;
import domain.Ticket;

import java.util.Objects;

public class Repository {

    protected Ticket[] tickets = new Ticket[0];

    public void add(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {

        Ticket[] result = new Ticket[tickets.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = tickets[i];
        }
        return result;
    }


    public Ticket[] removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        if (findById(id) == null)
            throw new NotFoundException(
                    "Element with id:"  + id +  "not found"
            );
        int index = 0;
        for (Ticket ticket : tickets)
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;

            }
        tickets = tmp;

        return tickets;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }


}


