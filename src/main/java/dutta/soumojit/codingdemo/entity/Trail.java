package dutta.soumojit.codingdemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
