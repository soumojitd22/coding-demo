package dutta.soumojit.codingdemo.controller;

import dutta.soumojit.codingdemo.entity.Booking;
import dutta.soumojit.codingdemo.model.BookingRequest;
import dutta.soumojit.codingdemo.model.BookingResponse;
import dutta.soumojit.codingdemo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping(path = "/book-trail", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public BookingResponse bookTrail(@RequestBody @Valid BookingRequest bookingRequest) {
        return new BookingResponse(bookingService.bookTrail(bookingRequest), "Booking is successful");
    }

    @GetMapping(path = "/view-booking/{id}", produces = APPLICATION_JSON_VALUE)
    public Booking viewBooking(@PathVariable("id") long bookingId) {
        return bookingService.viewBooking(bookingId);
    }

    @DeleteMapping(path = "/delete-booking/{id}", produces = APPLICATION_JSON_VALUE)
    public BookingResponse deleteBooking(@PathVariable("id") long bookingId) {
        bookingService.deleteBooking(bookingId);
        return new BookingResponse(bookingId, "Booking is deleted");
    }
}
