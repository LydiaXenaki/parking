package com.example.skatoules;

public class TicketManager {
    private static TicketManager instance;
    private Ticket ticket;

    private TicketManager() {}

    public static synchronized TicketManager getInstance() {
        if (instance == null) {
            instance = new TicketManager();
        }
        return instance;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
