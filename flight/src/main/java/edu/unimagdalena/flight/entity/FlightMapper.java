package edu.unimagdalena.flight.entity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FlightMapper {

    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    public FlightDTO flightToDTO(Flight flight);

    public Flight flightDtoToEntity(FlightDTO flightDTO);

}