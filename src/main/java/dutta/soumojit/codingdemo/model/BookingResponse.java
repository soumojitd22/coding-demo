package dutta.soumojit.codingdemo.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookingResponse {
    private long bookingNumber;
    private String message;
}
