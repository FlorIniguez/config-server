package com.api.tickets.service;

import com.api.tickets.model.CompanyDto;
import com.api.tickets.model.FlightDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//esto va a llamar a flight api
@FeignClient(name = "flight-service")
public interface FlightClient {
    //como va a trabajar

    //establece la firma pero no como se implementa, va a ir a buscar
    //a flight-api la info
    @GetMapping("/flights")
    List<FlightDto> getAllFlights();
    @GetMapping("/flights/{flightId}")
    FlightDto getFlightById(@PathVariable("flightId") Long flightId);
    //companies
    @GetMapping("/companies/{id}")
    CompanyDto getCompanyById(@PathVariable("id") Long id);


}
