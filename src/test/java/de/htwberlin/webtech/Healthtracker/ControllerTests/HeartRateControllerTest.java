package de.htwberlin.webtech.Healthtracker.ControllerTests;

import de.htwberlin.webtech.Healthtracker.Controller.HeartRateController;
import de.htwberlin.webtech.Healthtracker.Entitäsklassen.HeartRate;
import de.htwberlin.webtech.Healthtracker.Serviceklassen.HeartRateService;
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

@WebMvcTest(HeartRateController.class)
public class HeartRateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    
    @MockBean
    private HeartRateService heartRateService;

    @Test
    public void testGetHeartRates() throws Exception {
        // Test data and service mock
        HeartRate hr1 = new HeartRate(LocalDateTime.of(2023, 1, 1, 10, 0, 0), 70);
        hr1.setId(1L);

        HeartRate hr2 = new HeartRate(LocalDateTime.of(2023, 1, 2, 10, 0, 0), 75);
        hr2.setId(2L);

        List<HeartRate> heartRates = Arrays.asList(hr1, hr2);
        when(heartRateService.getAllHeartRates()).thenReturn(heartRates);

        // Expected result
        String expected = "[{\"id\":1,\"dateRecorded\":\"2023-01-01T10:00:00\",\"heartRateValue\":70}," +
                "{\"id\":2,\"dateRecorded\":\"2023-01-02T10:00:00\",\"heartRateValue\":75}]";

        // Perform the request and compare
        this.mockMvc.perform(get("/HeartRates"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }
}
