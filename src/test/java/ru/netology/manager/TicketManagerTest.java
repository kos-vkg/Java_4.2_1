package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket t1 = new Ticket(1, 1005, "x1", "a1", 101);
    Ticket t2 = new Ticket(2, 1004, "x1", "y1", 102);
    Ticket t3 = new Ticket(3, 1003, "d3", "a3", 103);
    Ticket t4 = new Ticket(4, 1002, "x1", "y1", 104);
    Ticket t5 = new Ticket(5, 1001, "d3", "y1", 105);
    Ticket t6 = new Ticket(6, 1001, "d3", "y1", 105);


    @Test
    void shouldSearchBy() {
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);

        Ticket[] actual = manager.searchBy("x1", "y1");
        Ticket[] expected = new Ticket[]{t4, t2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchEquivalentValues() {

        manager.add(t6);
        manager.add(t5);

        Ticket[] actual = manager.searchBy("d3", "y1");
        Ticket[] expected = new Ticket[]{t6, t5};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchOnlyResult() {

        manager.add(t1);
        manager.add(t5);

        Ticket[] actual = manager.searchBy("d3", "y1");
        Ticket[] expected = new Ticket[]{t5};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchEmptyResult() {

        manager.add(t1);
        manager.add(t5);

        Ticket[] actual = manager.searchBy("x1", "y1");
        Ticket[] expected = new Ticket[0];

        assertArrayEquals(expected, actual);
    }

}