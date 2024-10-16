package edu.unimagdalena.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unimagdalena.booking.entities.Booking;

@Repository
public interface BookingRepository  extends JpaRepository<Booking,Long>{

}