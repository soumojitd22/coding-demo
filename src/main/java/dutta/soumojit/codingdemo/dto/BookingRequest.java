package dutta.soumojit.codingdemo.dto;

import dutta.soumojit.codingdemo.entity.Hiker;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class BookingRequest {
    private int trailId;

    @Valid
    @NotEmpty(message = "At least one hiker is required")
    private List<Hiker> hikers;
}
