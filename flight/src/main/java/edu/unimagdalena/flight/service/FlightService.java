package edu.unimagdalena.flight.service;

import edu.unimagdalena.flight.entity.FlightDTO;

import java.util.List;

public interface FlightService {

    FlightDTO create(FlightDTO flightDTO);
    FlightDTO getById(Long id);
    FlightDTO update(FlightDTO flightDTO, Long id);
    void delete(Long id);

    List<FlightDTO> getAll();
}