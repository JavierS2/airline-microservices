package edu.unimagdalena.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unimagdalena.booking.entities.Booking;
import edu.unimagdalena.booking.dto.BookingDTO;
import edu.unimagdalena.booking.mapper.BookingMapper;
import edu.unimagdalena.booking.repository.BookingRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Override
    public BookingDTO getBooking(Long id) {
        // TODO Auto-generated method stub
        try {
            if (id == null) {
                throw new IllegalArgumentException("La ID no puede ser nula.");
            }
            Booking booking = bookingRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("No se encontró la reserva."));
            return BookingMapper.INSTANCE.bookingToBookingDto(booking);
        } catch (Exception e) {
            // TODO: handle exception
            throw new EntityNotFoundException("Ha ocurrido un error al obtener la reserva con la ID: " + id);
        }

    }

    @Override
    public BookingDTO saveBooking(BookingDTO bookingSave) {
        try {
            if (bookingSave == null) {
                throw new IllegalArgumentException("La RESERVA no puede ser nula.");
            }
            Booking bookingDB = BookingMapper.INSTANCE.bookingDtoToBooking(bookingSave);
            bookingRepository.save(bookingDB);
            return BookingMapper.INSTANCE.bookingToBookingDto(bookingDB);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException("Ha ocurrido un error al crear una nueva reserva.", e);
        }

    }

    @Override
    public BookingDTO updateBooking(Long id, BookingDTO bookingUpdate) {
        // TODO Auto-generated method stub
        try {
            if (bookingUpdate == null) {
                throw new IllegalArgumentException("La reserva no puede ser nula.");
            }
            if (id == null) {
                throw new IllegalArgumentException("La ID no puede ser nula.");
            }
            Booking booking = bookingRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("No se encontro el reserva con la ID: " + id));
            booking.setFlightNumber(bookingUpdate.getFlightNumber());
            booking.setPassengerName(bookingUpdate.getPassengerName());
            Booking bookingFromDB = bookingRepository.save(booking);
            return BookingMapper.INSTANCE.bookingToBookingDto(bookingFromDB);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException("Ha ocurrido un error al actualizar el reserva con la ID: " + id);
        }
    }

    @Override
    public void deleteBookingById(Long id) {
        // TODO Auto-generated method stub
        try {
            if (id == null) {
                throw new IllegalArgumentException("El bookingUpdate no puede ser nulo.");
            }
            if (!bookingRepository.existsById(id)) {
                throw new EntityNotFoundException("No se encontro la reserva con la ID: " + id);
            }
            bookingRepository.deleteById(id);

        } catch (Exception e) {
            // TODO: handle exception
            throw new EntityNotFoundException("Ha ocurrido un error al eliminar la reserva con la ID: " + id);
        }
    }

}

