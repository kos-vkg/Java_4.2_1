package ru.netology.manager;


import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {

    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket item) {
        repository.save(item);
    }


    public boolean matches(Ticket ticket, String from, String to) {
        if (!ticket.getArrivalAirport().equalsIgnoreCase(to)) {
            return false;
        }
        return ticket.getDepartAirport().equalsIgnoreCase(from);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] items = repository.findAll();
        Ticket[] result = new Ticket[0];
        for (Ticket item : items) {
            if (matches(item, from, to)) {
                // создаём новый массив размером на единицу больше
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item; // кладём последним  элемент
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Ticket[] getAll() {
        Ticket[] items = repository.findAll();
        Ticket[] result = new Ticket[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Ticket findById(int id) {
        return repository.findById(id);
    }

}
