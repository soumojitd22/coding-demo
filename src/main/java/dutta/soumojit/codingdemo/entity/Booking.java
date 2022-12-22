package dutta.soumojit.codingdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.SEQUENCE;


@Entity
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "booking_seq")
    @SequenceGenerator(name = "booking_seq", sequenceName = "BOOKING_SEQ", allocationSize = 1)
    private long id;

    @ManyToOne
    @JoinColumn(name = "TRAIL_ID", referencedColumnName = "ID")
    private Trail trail;

    @OneToMany(cascade = ALL, fetch = LAZY, mappedBy = "booking", targetEntity = Hiker.class)
    private List<Hiker> hikers;
}
