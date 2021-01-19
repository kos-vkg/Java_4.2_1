package ru.netology.repository;

import ru.netology.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();

    Ticket ticket1 = new Ticket(1, 1001, "d1", "a1", 101);
    Ticket ticket2 = new Ticket(2, 1002, "d2", "a2", 102);
    Ticket ticket3 = new Ticket(3, 1003, "d3", "a3", 103);

    @Test
    public void shouldAdd() {
        repository.save(ticket1);

        Ticket[] expected = new Ticket[]{ticket1};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repository.save(ticket1);

        repository.removeById(1);

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByMissingId() {
        repository.save(ticket1);
        assertThrows(NotFoundException.class, () -> repository.removeById(2));
    }

}
