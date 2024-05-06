package com.api.tickets.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private Long id;
    private String passengerName;
    private String passengerEmail;
    private String passengerPassport;
    private FlightDto flight;
}
