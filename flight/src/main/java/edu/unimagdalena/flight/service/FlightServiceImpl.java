package edu.unimagdalena.flight.service;

import edu.unimagdalena.flight.entity.Flight;
import edu.unimagdalena.flight.entity.FlightDTO;
import edu.unimagdalena.flight.entity.FlightMapper;
import edu.unimagdalena.flight.repository.FlightRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public FlightDTO create(FlightDTO flightDTO) {
        Flight flightToSave = FlightMapper.INSTANCE.flightDtoToEntity(flightDTO);
        return (FlightMapper.INSTANCE.flightToDTO(flightRepository.save(flightToSave)));
    }

    @Override
    public FlightDTO getById(Long id) {
        if (id == null) throw new IllegalArgumentException("Invalid ID");
        return FlightMapper.INSTANCE.flightToDTO(
                flightRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Flight not found")));
    }

    @Override
    public FlightDTO update(FlightDTO flightDTO, Long id) {
        if (id == null) throw new IllegalArgumentException("Invalid ID");
        Flight flightToUpdate = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        flightToUpdate.setFlightNumber(flightDTO.flightNumber());
        flightToUpdate.setOrigin(flightDTO.origin());
        flightToUpdate.setDestination(flightDTO.destination());
        flightToUpdate.setDepartureTime(flightDTO.departureTime());

        return FlightMapper.INSTANCE.flightToDTO(flightRepository.save(flightToUpdate));
    }

    @Override
    public void delete(Long id) {
        if (id == null) throw new IllegalArgumentException("Invalid ID");
        Flight flightToDelete = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
        flightRepository.delete(flightToDelete);
    }

    @Override
    public List<FlightDTO> getAll() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream()
                .map(FlightMapper.INSTANCE::flightToDTO)
                .toList();
    }
}