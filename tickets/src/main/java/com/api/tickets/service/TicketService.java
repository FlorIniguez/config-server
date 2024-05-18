package com.api.tickets.service;

import com.api.tickets.model.FlightDto;
import com.api.tickets.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {
    @Autowired
    private FlightClient flightClient;
    //como no me conecto a bdd, no uso repository
    //uso una lista de tickets para agregarlos, imprimirlos,etc
    private final List<Ticket> tickets = new ArrayList<>();

    public List<Ticket> getAllTickets() {
        return tickets;
    }

    public Optional<Ticket> findById(Long ticketId) {
        return tickets.stream()
                .filter(ticket -> ticket.getId().equals(ticketId))
                .findFirst();

    }

    public List<FlightDto> findFlightsByPassport(String passport) {
        //flujo de tickets, filtro por passport y de cada ticket saco e lvuelo
        return tickets.stream()
                .filter(ticket -> ticket.getPassengerPassport().equalsIgnoreCase(passport))
                .map(ticket -> ticket.getFlight())
                .collect(Collectors.toList());
    }

    public Optional<Ticket> addTicket(Long flightId, Ticket addedTicket) {
        //de flightClient con el metodo getById buscar el vuelo
        FlightDto flight = flightClient.getFlightById(flightId);
        //seteo el flight por el Id al ticket
        addedTicket.setFlight(flight);
        //creo el ticket
        tickets.add(addedTicket);
        return Optional.of(addedTicket);
    }

    public void deleteTicket(Long ticketId) {
        tickets.removeIf(ticket -> ticket.getId() == ticketId);

    }

    public Optional<Ticket> updateTicket(Long ticketId, Ticket updatedTicket) {
        return tickets.stream()
                .filter(ticket -> ticket.getId().equals(ticketId))
                .findFirst()
                .map(ticket -> {
                    // Actualizar el ticket con los datos de updatedTicket
                    //cree metodo updateFrom en modelo de ticket
                    ticket.updateFrom(updatedTicket);
                    ;
                    return ticket;
                });
    }
}
