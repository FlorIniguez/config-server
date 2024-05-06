package com.api.tickets.controller;

import com.api.tickets.model.FlightDto;
import com.api.tickets.model.Ticket;
import com.api.tickets.service.FlightClient;
import com.api.tickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private FlightClient flightClient;

    @GetMapping("")
    public List<Ticket> getAllTicketsController() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/flights")
    public List<FlightDto> getAllFlights() {
        return flightClient.getAllFlights();
    }
    @GetMapping("/{ticketId}")
    public Optional<Ticket> findTicketById(@PathVariable Long ticketId) {
        return ticketService.findById(ticketId);
    }
    @GetMapping("/passport/{passport}")
    public List<FlightDto>  findTicketById(@PathVariable String passport) {
        return ticketService.findFlightsByPassport(passport);
    }
    @PostMapping("/add/{flightId}")
    public Optional<Ticket> addTicketController(@PathVariable Long flightId, @RequestBody Ticket ticket) {
        return ticketService.addTicket(flightId,ticket);
    }

}
