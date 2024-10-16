package edu.unimagdalena.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;

import edu.unimagdalena.booking.dto.BookingDTO;
import edu.unimagdalena.booking.service.BookingServiceImpl;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingServiceImpl bookingService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookingService.getBooking(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error inesperado.");
        }
    }

    @PostMapping
    public ResponseEntity<?> postProduct(@RequestBody BookingDTO booking) {
        try {
            bookingService.saveBooking(booking);
            return ResponseEntity.status(HttpStatus.CREATED).body("La reserva ha sido guardada.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage()); // error 422
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putProductById(@PathVariable("id") Long id, @RequestBody BookingDTO bookingUpdate) {
        try {
            bookingService.updateBooking(id, bookingUpdate);
            return ResponseEntity.status(HttpStatus.OK).body("Se ha podido actualizar la reserva con la ID: " + id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
        } catch (Exception EntityNotFoundException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(EntityNotFoundException.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") long id) { // ya funciona (202)
        try {
            bookingService.deleteBookingById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Se ha podido eliminar la reserva con la ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

}
