package edu.unimagdalena.flights_microservice.service;

import edu.unimagdalena.flights_microservice.entity.FlightDTO;

import java.util.List;

public interface FlightService {

    FlightDTO create(FlightDTO flightDTO);
    FlightDTO getById(Long id);
    FlightDTO update(FlightDTO flightDTO, Long id);
    void delete(Long id);

    List<FlightDTO> getAll();
}
