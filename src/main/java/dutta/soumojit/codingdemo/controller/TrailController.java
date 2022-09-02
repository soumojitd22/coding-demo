package dutta.soumojit.codingdemo.controller;

import dutta.soumojit.codingdemo.entity.Trail;
import dutta.soumojit.codingdemo.service.TrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class TrailController {

    @Autowired
    private TrailService trailService;

    @GetMapping(path = "/trails", produces = APPLICATION_JSON_VALUE)
    public List<Trail> getAllTrails() {
        return trailService.getAllTrails();
    }

    @GetMapping(path = "/trail/{id}", produces = APPLICATION_JSON_VALUE)
    public Trail getTrail(@PathVariable("id") int id) {
        return trailService.getTrail(id);
    }
}
