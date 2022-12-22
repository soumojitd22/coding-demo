package dutta.soumojit.codingdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Trail {

    @Id
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String startAt;

    @Column(nullable = false)
    private String endAt;

    @Column(nullable = false)
    private float unitPrice;
}
