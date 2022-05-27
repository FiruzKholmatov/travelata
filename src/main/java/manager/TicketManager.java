package manager;

import domain.Ticket;
import repository.Repository;

public class TicketManager {

    protected Repository repository;

    public TicketManager() {
        this.repository = new Repository();
    }

    public void add(Ticket ticket) {
        repository.add(ticket);
    }


    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        return ticket.getDeparturePort().contains(from) && ticket.getArrivingPort().contains(to);
    }


}









