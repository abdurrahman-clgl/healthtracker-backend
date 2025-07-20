package de.htwberlin.webtech.Healthtracker.ServiceTests;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.Weight;
import de.htwberlin.webtech.Healthtracker.Interface.WeightRepository;
import de.htwberlin.webtech.Healthtracker.Serviceklassen.WeightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class WeightServiceTest {

    @Autowired
    private WeightService weightService;

    @MockBean
    private WeightRepository weightRepository;

    private Weight testWeight;

    @BeforeEach
    void setUp() {
        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        testWeight = new Weight(dateRecorded, 70.5, 1.75, 68.0, 0.5);
        testWeight.setId(1L);
    }

    @Test
    @DisplayName("should save a weight")
    void testSaveWeight() {
        // Mocking repository save method
        when(weightRepository.save(any(Weight.class))).thenReturn(testWeight);

        // Actual result
        Weight savedWeight = weightService.save(testWeight);

        // Verify repository method was called once
        verify(weightRepository, times(1)).save(testWeight);

        // Comparison
        assertEquals(testWeight, savedWeight);
    }

    @Test
    @DisplayName("should find a weight by its id")
    void testGetWeightById() {
        // Mocking repository findById method
        when(weightRepository.findById(1L)).thenReturn(Optional.of(testWeight));

        // Actual result
        Weight foundWeight = weightService.get(1L);

        // Verify repository method was called once
        verify(weightRepository, times(1)).findById(1L);

        // Comparison
        assertEquals(testWeight, foundWeight);
    }

    @Test
    @DisplayName("should return all weights")
    void testGetAllWeights() {
        // Mocking repository findAll method
        List<Weight> weightList = Arrays.asList(testWeight);
        when(weightRepository.findAll()).thenReturn(weightList);

        // Actual result
        List<Weight> allWeights = weightService.getAllWeights();

        // Verify repository method was called once
        verify(weightRepository, times(1)).findAll();

        // Comparison
        assertEquals(weightList.size(), allWeights.size());
        assertEquals(weightList.get(0), allWeights.get(0));
    }

    @Test
    @DisplayName("should delete a weight")
    void testDeleteWeight() {
        // Mocking repository deleteById method
        doNothing().when(weightRepository).deleteById(1L);

        // Calling service method
        weightService.deleteWeight(1L);

        // Verify repository method was called once
        verify(weightRepository, times(1)).deleteById(1L);
    }
}
