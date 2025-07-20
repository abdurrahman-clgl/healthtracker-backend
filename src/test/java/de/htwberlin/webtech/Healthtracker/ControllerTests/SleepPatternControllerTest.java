package de.htwberlin.webtech.Healthtracker.ControllerTests;

import de.htwberlin.webtech.Healthtracker.Controller.SleepPatternController;
import de.htwberlin.webtech.Healthtracker.Entitäsklassen.SleepPattern;
import de.htwberlin.webtech.Healthtracker.Serviceklassen.SleepPatternService;
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

@WebMvcTest(SleepPatternController.class)
public class SleepPatternControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SleepPatternService sleepPatternService;

    @Test
    public void testGetSleepPatterns() throws Exception {
        // Test data and service mock
        SleepPattern sp1 = new SleepPattern(LocalDateTime.of(2023, 1, 1, 10, 0, 0), 8, 3, 5, 2);
        sp1.setId(1L);
        double sp1Quality = sp1.calculateSleepQuality();

        SleepPattern sp2 = new SleepPattern(LocalDateTime.of(2023, 1, 2, 10, 0, 0), 7, 2, 5, 3);
        sp2.setId(2L);
        double sp2Quality = sp2.calculateSleepQuality();

        List<SleepPattern> sleepPatterns = Arrays.asList(sp1, sp2);
        when(sleepPatternService.getAllSleepPatterns()).thenReturn(sleepPatterns);

        // Expected result
        String expected = "[{\"id\":1,\"dateRecorded\":\"2023-01-01T10:00:00\",\"sleepDuration\":8.0,\"lightSleepDuration\":3.0,\"deepSleepDuration\":5.0,\"interruptions\":2,\"sleepQuality\":" + sp1Quality + "}," +
                "{\"id\":2,\"dateRecorded\":\"2023-01-02T10:00:00\",\"sleepDuration\":7.0,\"lightSleepDuration\":2.0,\"deepSleepDuration\":5.0,\"interruptions\":3,\"sleepQuality\":" + sp2Quality + "}]";

        // Perform the request and compare
        this.mockMvc.perform(get("/SleepPattern/sleeppattern"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }
}
