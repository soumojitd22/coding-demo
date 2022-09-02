package dutta.soumojit.codingdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Getter
@Setter
public class Hiker {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "booking_seq")
    @SequenceGenerator(name = "booking_seq", sequenceName = "BOOKING_SEQ", allocationSize = 1)
    @JsonIgnore
    private long id;

    @Column(nullable = false)
    @NotEmpty(message = "First name is required")
    private String firstName;

    @Column(nullable = false)
    @NotEmpty(message = "Last name is required")
    private String lastName;

    @Column(nullable = false)
    @Min(value = 1, message = "Age is invalid")
    @Max(value = 110, message = "Age is invalid")
    private int age;

    @ManyToOne(fetch = LAZY, optional = false)
    @JoinColumn(name = "booking_id", nullable = false)
    @JsonIgnore
    private Booking booking;
}
