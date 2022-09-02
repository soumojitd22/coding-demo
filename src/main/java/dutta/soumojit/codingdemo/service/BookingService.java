package dutta.soumojit.codingdemo.service;

import dutta.soumojit.codingdemo.entity.Booking;
import dutta.soumojit.codingdemo.entity.Trail;
import dutta.soumojit.codingdemo.exception.IdNotFoundException;
import dutta.soumojit.codingdemo.model.BookingRequest;
import dutta.soumojit.codingdemo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TrailService trailService;

    @Transactional
    public long bookTrail(BookingRequest bookingRequest) {
        Booking booking = new Booking();
        Trail trail = trailService.getTrail(bookingRequest.getTrailId());
        booking.setTrail(trail);
        booking.setHikers(bookingRequest.getHikers()
                .stream()
                .peek(h -> h.setBooking(booking))
                .collect(Collectors.toList()));

        Booking bookedTrail = bookingRepository.save(booking);
        return bookedTrail.getId();
    }

    public Booking viewBooking(long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IdNotFoundException("Invalid booking id"));

    }

    public void deleteBooking(long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
