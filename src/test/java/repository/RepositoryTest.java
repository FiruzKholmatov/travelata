package repository;

import Exceptions.NotFoundException;
import domain.Ticket;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    Ticket ticket1 = new Ticket(111,13500,"LBD", "DME", 3400);
    Ticket ticket2 = new Ticket(112,10500,"SVO", "TAS", 3500);
    Ticket ticket3 = new Ticket(113,16500,"VKO", "OSH", 3900);
    Ticket ticket4 = new Ticket(114, 9500, "LBD", "DME", 3400);
    Ticket ticket5 = new Ticket(115, 10000, "LBD", "DME", 3400);
    Ticket ticket6 = new Ticket(116, 11500, "LBD", "DME", 3400);

    public Repository repo = new Repository();


    @Test
    public void shouldFindAllTickets () {

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindOneTicket () {


        repo.add(ticket1);


        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket1};

        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldRemoveByIdNonEmpty () {

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        Ticket[] actual = repo.removeById(111);
        Ticket[] expected = {ticket2, ticket3, ticket4, ticket5, ticket6};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveSoleId () {

        repo.add(ticket1);


        Ticket[] actual = repo.removeById(111);
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldThrowException () {

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        assertThrows(NotFoundException.class, () ->{
            repo.removeById(95);
        });



    }












}