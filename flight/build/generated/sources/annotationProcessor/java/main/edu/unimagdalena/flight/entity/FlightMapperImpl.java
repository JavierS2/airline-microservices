package edu.unimagdalena.flight.entity;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-09T15:36:36-0500",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.12 (JetBrains s.r.o.)"
)
public class FlightMapperImpl implements FlightMapper {

    @Override
    public FlightDTO flightToDTO(Flight flight) {
        if ( flight == null ) {
            return null;
        }

        Long id = null;
        String flightNumber = null;
        String origin = null;
        String destination = null;
        String departureTime = null;

        id = flight.getId();
        flightNumber = flight.getFlightNumber();
        origin = flight.getOrigin();
        destination = flight.getDestination();
        departureTime = flight.getDepartureTime();

        FlightDTO flightDTO = new FlightDTO( id, flightNumber, origin, destination, departureTime );

        return flightDTO;
    }

    @Override
    public Flight flightDtoToEntity(FlightDTO flightDTO) {
        if ( flightDTO == null ) {
            return null;
        }

        Flight flight = new Flight();

        flight.setId( flightDTO.id() );
        flight.setFlightNumber( flightDTO.flightNumber() );
        flight.setOrigin( flightDTO.origin() );
        flight.setDestination( flightDTO.destination() );
        flight.setDepartureTime( flightDTO.departureTime() );

        return flight;
    }
}
