package com.pariyajafari.todolistproject.test;

import com.pariyajafari.todolistproject.model.Mantra;
import com.pariyajafari.todolistproject.repository.MantraRepository;
import com.pariyajafari.todolistproject.service.MantraService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MantraServiceTest {

    @MockBean
    private RestTemplate restTemplate;
    @MockBean
    private MantraRepository mantraRepository;
    @Autowired
    private MantraService mantraService;

    @Test
    public void testFetchAndSaveMantra_Success() {

        List<Map<String, String>> mockApiResponse = List.of(
                Map.of("q", "Man is affected not by events but by the view he takes of them.", "a", "Seneca")
        );

        ResponseEntity<List<Map<String, String>>> responseEntity =
                new ResponseEntity<>(mockApiResponse, HttpStatus.OK);
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                eq(null),
                any(ParameterizedTypeReference.class))
        ).thenReturn(responseEntity);

        Mantra mockMantra = new Mantra();
        mockMantra.setId(1L);
        mockMantra.setText("Man is affected not by events but by the view he takes of them.");
        mockMantra.setAuthor("Seneca");
        when(mantraRepository.save(any(Mantra.class))).thenReturn(mockMantra);

        Mantra savedMantra = mantraService.fetchAndSaveMantra();

        assertNotNull(savedMantra);
        assertEquals("Man is affected not by events but by the view he takes of them.", savedMantra.getText());
        assertEquals("Seneca", savedMantra.getAuthor());

        verify(restTemplate, times(1)).exchange(
                anyString(),
                eq(HttpMethod.GET),
                eq(null),
                any(ParameterizedTypeReference.class)
        );
        verify(mantraRepository, times(1)).save(any(Mantra.class));
    }
}
