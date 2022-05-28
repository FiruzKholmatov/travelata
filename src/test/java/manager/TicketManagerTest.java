package manager;

import domain.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {

    Ticket ticket1 = new Ticket(111, 13500, "LBD", "DME", 3400);
    Ticket ticket2 = new Ticket(112, 10500, "SVO", "TAS", 3500);
    Ticket ticket3 = new Ticket(113, 16500, "VKO", "OSH", 3900);
    Ticket ticket4 = new Ticket(114, 9500, "LBD", "DME", 3400);
    Ticket ticket5 = new Ticket(115, 10000, "LBD", "DME", 3400);
    Ticket ticket6 = new Ticket(116, 11500, "LBD", "DME", 3400);

    public TicketManager manager = new TicketManager();

    @Test
    public void shouldFindByPriceAscendingNonEmpty() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] expected = {ticket4, ticket5, ticket6, ticket1};

        assertArrayEquals(expected, manager.findAll("LBD", "DME"));

    }

    @Test
    public void shouldFindFlightByPriceAscendingEmpty() {


        Ticket[] expected = {};

        assertArrayEquals(expected, manager.findAll("LBD", "DME"));

    }

    @Test
    public void shouldFindByPriceAscendingSole() {

        manager.add(ticket1);

        Ticket[] expected = {ticket1};

        assertArrayEquals(expected, manager.findAll("LBD", "DME"));

    }

    @Test
    public void shouldSearchUnexistedFlightNonEmpty() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] expected = {};

        assertArrayEquals(expected, manager.findAll("LBD", "TAS"));

    }

}