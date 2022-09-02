package dutta.soumojit.codingdemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

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
