package edu.unimagdalena.flights_microservice.repository;

import edu.unimagdalena.flights_microservice.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Optional<Flight> findById(Long id);

}
