package dutta.soumojit.codingdemo.service;

import dutta.soumojit.codingdemo.entity.Trail;
import dutta.soumojit.codingdemo.exception.IdNotFoundException;
import dutta.soumojit.codingdemo.repository.TrailRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TrailServiceTest {
    @InjectMocks
    private TrailService trailService;
    @Mock
    private TrailRepository trailRepository;

    @Test
    void getAllTrails() {
        Trail t1 = new Trail();
        t1.setId(1);
        t1.setName("Name1");
        t1.setStartAt("start1");
        t1.setEndAt("end1");
        t1.setUnitPrice(20.00f);

        Trail t2 = new Trail();
        t2.setId(2);
        t2.setName("Name2");
        t2.setStartAt("start2");
        t2.setEndAt("end2");
        t2.setUnitPrice(22.00f);

        List<Trail> trails = List.of(t1, t2);
        when(trailRepository.findAll()).thenReturn(trails);
        List<Trail> allTrails = trailService.getAllTrails();
        assertEquals(2, allTrails.size());
        assertEquals(t1.getId(), allTrails.get(0).getId());
        verify(trailRepository, times(1)).findAll();
    }

    @Test
    void getTrail() {
        Trail t1 = new Trail();
        t1.setId(1);
        t1.setName("Name1");
        t1.setStartAt("start1");
        t1.setEndAt("end1");
        t1.setUnitPrice(20.00f);

        when(trailRepository.findById(1)).thenReturn(Optional.of(t1));
        Trail trail = trailService.getTrail(1);
        assertEquals(t1.getName(), trail.getName());
        assertEquals(t1.getUnitPrice(), trail.getUnitPrice());
        verify(trailRepository, times(1)).findById(1);
    }
    @Test
    void getTrailNotFound() {
        when(trailRepository.findById(1)).thenReturn(Optional.empty());
        IdNotFoundException ex = assertThrows(IdNotFoundException.class, () -> trailService.getTrail(1));
        assertEquals("Invalid trail id provided", ex.getMessage());
    }
}