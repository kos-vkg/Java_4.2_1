package ru.netology.domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String departAirport;
    private String arrivalAirport;
    private int flightTime;


    @Override
    public int compareTo(Ticket o) {
        return this.price - o.price;
    }

    public Ticket() {
    }

    public Ticket(int id, int price, String departAirport, String arrivalAirport, int flightTime) {
        this.id = id;
        this.price = price;
        this.departAirport = departAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightTime = flightTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDepartAirport() {
        return departAirport;
    }

    public void setDepartAirport(String departAirport) {
        this.departAirport = departAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                price == ticket.price &&
                Objects.equals(departAirport, ticket.departAirport) &&
                Objects.equals(arrivalAirport, ticket.arrivalAirport) &&
                Objects.equals(flightTime, ticket.flightTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, departAirport, arrivalAirport, flightTime);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", departAirport='" + departAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", flightTime='" + flightTime + '\'' +
                '}';
    }


}
