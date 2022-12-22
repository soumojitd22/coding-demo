package dutta.soumojit.codingdemo.service;

import dutta.soumojit.codingdemo.entity.Booking;
import dutta.soumojit.codingdemo.entity.Trail;
import dutta.soumojit.codingdemo.exception.IdNotFoundException;
import dutta.soumojit.codingdemo.dto.BookingRequest;
import dutta.soumojit.codingdemo.repository.BookingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    private final TrailService trailService;

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

    @Transactional
    public void deleteBooking(long bookingId) {
        bookingRepository.delete(viewBooking(bookingId));
    }
}
