package edu.unimagdalena.booking_microservice.service;

import edu.unimagdalena.booking_microservice.dto.BookingDTO;

public interface BookingService {
    BookingDTO getBooking(Long id);
    BookingDTO saveBooking(BookingDTO bookingSave);
    BookingDTO updateBooking(Long id, BookingDTO bookingUpdate);
    void deleteBookingById(Long id);
}
