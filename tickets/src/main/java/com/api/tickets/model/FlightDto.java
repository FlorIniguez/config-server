package com.api.tickets.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightDto {
    private Long id;
    private String origin;
    private String destiny;
    private String departureTime;
    private String arrivingTime;
    private double convertedPrice;
    private Long companyId; // ID de la compañía
    // Otros campos de la compañía que puedas necesitar
    private String companyName;

}
