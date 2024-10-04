package edu.unimagdalena.booking_microservice.dto;

import lombok.Data;

@Data
public class BookingDTO {
    private Long id;
    private String flightNumber;
    private String passengerName;
}
