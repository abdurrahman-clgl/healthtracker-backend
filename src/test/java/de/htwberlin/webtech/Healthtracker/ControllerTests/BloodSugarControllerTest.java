package de.htwberlin.webtech.Healthtracker.ControllerTests;

import de.htwberlin.webtech.Healthtracker.Controller.BloodSugarController;
import de.htwberlin.webtech.Healthtracker.Entitäsklassen.BloodSugar;
import de.htwberlin.webtech.Healthtracker.Serviceklassen.BloodSugarService;
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

@WebMvcTest(BloodSugarController.class)
public class BloodSugarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BloodSugarService bloodSugarService;

    @Test
    public void testGetBloodSugars() throws Exception {
        // Test data and service mock
        BloodSugar bs1 = new BloodSugar(LocalDateTime.of(2023, 1, 1, 10, 0, 0), 90);
        bs1.setId(1L);

        BloodSugar bs2 = new BloodSugar(LocalDateTime.of(2023, 1, 2, 10, 0, 0), 95);
        bs2.setId(2L);

        List<BloodSugar> bloodSugars = Arrays.asList(bs1, bs2);
        when(bloodSugarService.getAllBloodSugars()).thenReturn(bloodSugars);

        // Expected result
        String expected = "[{\"id\":1,\"dateRecorded\":\"2023-01-01T10:00:00\",\"bloodSugarLevel\":90}," +
                "{\"id\":2,\"dateRecorded\":\"2023-01-02T10:00:00\",\"bloodSugarLevel\":95}]";

        // Perform the request and compare
        this.mockMvc.perform(get("/BloodSugar/bloodsugar"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }
}
