package de.htwberlin.webtech.Healthtracker.ControllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.htwberlin.webtech.Healthtracker.Controller.StepCountController;
import de.htwberlin.webtech.Healthtracker.Entitäsklassen.StepCount;
import de.htwberlin.webtech.Healthtracker.Serviceklassen.StepCountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StepCountController.class)
public class StepCountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StepCountService stepCountService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetStepCounts() throws Exception {
        // Test data and service mock
        StepCount sc1 = new StepCount(LocalDateTime.of(2023, 1, 1, 10, 0, 0), 10000, 12000);
        sc1.setId(1L);

        StepCount sc2 = new StepCount(LocalDateTime.of(2023, 1, 2, 10, 0, 0), 15000, 17000);
        sc2.setId(2L);

        List<StepCount> stepCounts = Arrays.asList(sc1, sc2);
        when(stepCountService.getAllStepCounts()).thenReturn(stepCounts);

        // Convert the expected result to a JSON string
        String expected = objectMapper.writeValueAsString(stepCounts);

        this.mockMvc.perform(get("/StepCounts/stepcount"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }
}
