package dutta.soumojit.codingdemo.dto;

import dutta.soumojit.codingdemo.entity.Hiker;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
public class BookingRequest {
    private int trailId;

    @Valid
    @NotEmpty(message = "At least one hiker is required")
    private List<Hiker> hikers;
}
