package dutta.soumojit.codingdemo.controller;

import dutta.soumojit.codingdemo.entity.Trail;
import dutta.soumojit.codingdemo.exception.IdNotFoundException;
import dutta.soumojit.codingdemo.exception.handler.ErrorHandler;
import dutta.soumojit.codingdemo.service.TrailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({TrailController.class, ErrorHandler.class})
class TrailControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private TrailService trailService;

    @Test
    void getAllTrails() throws Exception {
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
        when(trailService.getAllTrails()).thenReturn(trails);
        mvc.perform(MockMvcRequestBuilders
                        .get("/trails")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*].id").exists())
                .andExpect(jsonPath("$.[0].id").value(1));
    }

    @Test
    void getTrail() throws Exception {
        Trail t1 = new Trail();
        t1.setId(1);
        t1.setName("Name1");
        t1.setStartAt("start1");
        t1.setEndAt("end1");
        t1.setUnitPrice(20.00f);

        when(trailService.getTrail(1)).thenReturn(t1);
        mvc.perform(MockMvcRequestBuilders
                        .get("/trail/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Name1"));
    }

    @Test
    void getTrailNotFound() throws Exception {
        when(trailService.getTrail(4)).thenThrow(new IdNotFoundException("Invalid trail id provided"));
        mvc.perform(MockMvcRequestBuilders
                        .get("/trail/4")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorMessage").value("Invalid trail id provided"));
    }
}