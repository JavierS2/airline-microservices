package edu.unimagdalena.booking_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unimagdalena.booking_microservice.entities.Booking;

@Repository
public interface BookingRepository  extends JpaRepository<Booking,Long>{

}
