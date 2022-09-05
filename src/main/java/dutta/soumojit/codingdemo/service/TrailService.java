package dutta.soumojit.codingdemo.service;

import dutta.soumojit.codingdemo.entity.Trail;
import dutta.soumojit.codingdemo.exception.IdNotFoundException;
import dutta.soumojit.codingdemo.repository.TrailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrailService {
    private final TrailRepository trailRepository;

    public List<Trail> getAllTrails() {
        return trailRepository.findAll();
    }

    public Trail getTrail(int id) {
        return trailRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Invalid trail id provided"));

    }
}
