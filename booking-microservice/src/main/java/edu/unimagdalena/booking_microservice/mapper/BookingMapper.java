package edu.unimagdalena.booking_microservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import edu.unimagdalena.booking_microservice.dto.BookingDTO;
import edu.unimagdalena.booking_microservice.entities.Booking;

@Mapper
public interface BookingMapper {

    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    public BookingDTO bookingToBookingDto(Booking booking);

    public Booking bookingDtoToBooking(BookingDTO bookingDto);

}
