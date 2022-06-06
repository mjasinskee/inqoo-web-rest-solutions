package com.inqoo.fsd.solutions;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
class LikeToReadClientService {

    private final RestTemplate restTemplate;

    LikeToReadClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    void addReview(String title, Review review) {
        System.out.println("Adding new review " + title + ": " + review);
        HttpEntity<Review> entity = new HttpEntity<>(review);
        restTemplate
                .postForEntity("http://localhost:8090/liketoread/addreview/" + title,
                        entity,
                        Void.class,
                        new HashMap<>());
    }

    public List<Review> getReviews(String title) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("title", title);
        System.out.println("Getting reviews for " + title);
        ResponseEntity<Review[]> entity = restTemplate
                .getForEntity(
                        "http://localhost:8090/liketoread/getreviews?title={title}",
                        Review[].class,
                        parameters);
        return Arrays.asList(entity.getBody());
    }

    public List<Book> getBooks() {
        URI uri = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8090/liketoread/getBooks")
                .build()
                .toUri();
        ResponseEntity<Book[]> response = restTemplate.getForEntity(uri, Book[].class);
        return Arrays.asList(response.getBody());
    }
}
