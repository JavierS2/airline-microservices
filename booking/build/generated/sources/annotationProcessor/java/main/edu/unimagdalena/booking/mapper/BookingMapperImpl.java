package edu.unimagdalena.booking.mapper;

import edu.unimagdalena.booking.dto.BookingDTO;
import edu.unimagdalena.booking.entities.Booking;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-09T15:17:48-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.12 (JetBrains s.r.o.)"
)
public class BookingMapperImpl implements BookingMapper {

    @Override
    public BookingDTO bookingToBookingDto(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        BookingDTO bookingDTO = new BookingDTO();

        bookingDTO.setId( booking.getId() );
        bookingDTO.setFlightNumber( booking.getFlightNumber() );
        bookingDTO.setPassengerName( booking.getPassengerName() );

        return bookingDTO;
    }

    @Override
    public Booking bookingDtoToBooking(BookingDTO bookingDto) {
        if ( bookingDto == null ) {
            return null;
        }

        Booking booking = new Booking();

        booking.setId( bookingDto.getId() );
        booking.setFlightNumber( bookingDto.getFlightNumber() );
        booking.setPassengerName( bookingDto.getPassengerName() );

        return booking;
    }
}
