package edu.unimagdalena.flight.controller;

import edu.unimagdalena.flight.entity.FlightDTO;
import edu.unimagdalena.flight.service.FlightServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private final FlightServiceImpl flightService;

    public FlightController(FlightServiceImpl flightService) {
        this.flightService = flightService;
    }

    @GetMapping("")
    public ResponseEntity<List<FlightDTO>> getAll() {
        List<FlightDTO> flights = flightService.getAll();
        return ResponseEntity.ok().body(flights);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> getById(@PathVariable Long id) {
        try {
            FlightDTO flightDTO = flightService.getById(id);
            return ResponseEntity.ok().body(flightDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    private ResponseEntity<FlightDTO> create(@Valid @RequestBody FlightDTO flightDTO) {
        FlightDTO flightCreated = flightService.create(flightDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(flightCreated);
    }

    @PutMapping("/{id}")
    private ResponseEntity<FlightDTO> update(@PathVariable Long id, @Valid @RequestBody FlightDTO flightDTO) {
        try {
            FlightDTO flightUpdated = flightService.update(flightDTO, id);
            return ResponseEntity.ok().body(flightUpdated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<FlightDTO> delete(@PathVariable Long id) {
        try {
            flightService.delete(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}