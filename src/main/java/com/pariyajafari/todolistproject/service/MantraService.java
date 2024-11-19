package com.pariyajafari.todolistproject.service;

import com.pariyajafari.todolistproject.model.Mantra;
import com.pariyajafari.todolistproject.repository.MantraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class MantraService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MantraRepository mantraRepository;

    public MantraService(RestTemplate restTemplate, MantraRepository mantraRepository) {
        this.restTemplate = restTemplate;
        this.mantraRepository = mantraRepository;
    }

    public Mantra fetchAndSaveMantra() {
        String url = "https://zenquotes.io/api/random";
        Mantra mantra = new Mantra();
        ResponseEntity<List<Map<String, String>>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
        if (response.getBody() != null && !response.getBody().isEmpty()) {
            Map<String, String> quoteData = response.getBody().get(0);
            String text = quoteData.get("q");
            String author = quoteData.get("a");
            mantra.setText(text);
            mantra.setAuthor(author);
        }
        return mantraRepository.save(mantra);
    }
}
