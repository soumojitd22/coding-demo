package dutta.soumojit.codingdemo.repository;

import dutta.soumojit.codingdemo.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
