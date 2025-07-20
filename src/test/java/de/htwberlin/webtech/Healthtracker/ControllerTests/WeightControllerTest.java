package de.htwberlin.webtech.Healthtracker.ControllerTests;

import de.htwberlin.webtech.Healthtracker.Controller.WeightController;
import de.htwberlin.webtech.Healthtracker.Entitäsklassen.Weight;
import de.htwberlin.webtech.Healthtracker.Serviceklassen.WeightService;
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

@WebMvcTest(WeightController.class)
public class WeightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeightService weightService;

    @Test
    public void testGetWeights() throws Exception {
        // Test data and service mock
        Weight w1 = new Weight(LocalDateTime.of(2023, 1, 1, 10, 0, 0), 70.5, 1.75, 68.0, 0.5);
        w1.setId(1L);

        Weight w2 = new Weight(LocalDateTime.of(2023, 1, 2, 10, 0, 0), 72.0, 1.80, 70.0, 0.4);
        w2.setId(2L);

        List<Weight> weights = Arrays.asList(w1, w2);
        when(weightService.getAllWeights()).thenReturn(weights);

        // Expected result
        String expected = "[{\"id\":1,\"dateRecorded\":\"2023-01-01T10:00:00\",\"weight\":70.5," +
                "\"height\":1.75,\"weightGoal\":68.0,\"weeklyGoal\":0.5}," +
                "{\"id\":2,\"dateRecorded\":\"2023-01-02T10:00:00\",\"weight\":72.0," +
                "\"height\":1.8,\"weightGoal\":70.0,\"weeklyGoal\":0.4}]";

        // Perform the request and compare
        this.mockMvc.perform(get("/Weight/weights"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }
}
