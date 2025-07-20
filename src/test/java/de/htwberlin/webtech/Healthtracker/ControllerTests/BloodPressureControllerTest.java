package de.htwberlin.webtech.Healthtracker.ControllerTests;

import de.htwberlin.webtech.Healthtracker.Controller.BloodPressureController;
import de.htwberlin.webtech.Healthtracker.Entitäsklassen.BloodPressure;
import de.htwberlin.webtech.Healthtracker.Serviceklassen.BloodPressureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BloodPressureController.class)
public class BloodPressureControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BloodPressureService bloodPressureService;

    @Test
    public void testGetBloodPressures() throws Exception {
        // Testdaten und Mock des Service
        BloodPressure bp1 = new BloodPressure(LocalDateTime.of(2023, 1, 1, 10, 0, 0), 120, 80);
        bp1.setId(1L);

        BloodPressure bp2 = new BloodPressure(LocalDateTime.of(2023, 1, 2, 10, 0, 0), 130, 85);
        bp2.setId(2L);

        List<BloodPressure> bloodPressures = Arrays.asList(bp1, bp2);
        when(bloodPressureService.getAllBloodPressures()).thenReturn(bloodPressures);

        // Anfrage ausführen und vergleichen
        this.mockMvc.perform(get("/BloodPressures/bloodpressure"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].dateRecorded").value("2023-01-01T10:00:00"))
                .andExpect(jsonPath("$[0].systolicPressure").value(120))
                .andExpect(jsonPath("$[0].diastolicPressure").value(80))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].dateRecorded").value("2023-01-02T10:00:00"))
                .andExpect(jsonPath("$[1].systolicPressure").value(130))
                .andExpect(jsonPath("$[1].diastolicPressure").value(85));
    }
}
