package edu.unimagdalena.flight.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record FlightDTO (
        Long id,

        @NotNull(message = "Flight number cannot be null")
        @NotEmpty(message = "Flight number cannot be empty")
        String flightNumber,

        @NotNull(message = "Origin number cannot be null")
        @NotEmpty(message = "Origin number cannot be empty")
        String origin,

        @NotNull(message = "Destination number cannot be null")
        @NotEmpty(message = "Destination number cannot be empty")
        String destination,

        @NotNull(message = "Departure time number cannot be null")
        @NotEmpty(message = "Departure time number cannot be empty")
        String departureTime
) { }