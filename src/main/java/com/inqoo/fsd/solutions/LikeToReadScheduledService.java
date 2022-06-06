package com.inqoo.fsd.solutions;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Component
class LikeToReadScheduledService {

    private final LikeToReadClientService service;

    LikeToReadScheduledService(LikeToReadClientService service) {
        this.service = service;
    }

    @Scheduled(fixedDelay = 1000)
    void addSomeReview() {
        List<Book> books = service.getBooks();
        Random random = new Random();
        Book book = books.get(random.nextInt(books.size()));
        String randomNickName = randomAlphabetic(8);
        String randomContent = randomAlphabetic(16);
        List<Score> scores = stream(Score.values()).collect(toList());
        Score randomScore = scores.get(random.nextInt(scores.size()));
        Review review = new Review(randomNickName, randomScore, randomContent);
        service.addReview(book.getTitle(), review);
    }

    @Scheduled(fixedDelay = 10000)
    void findReviews() {
        List<Book> books = service.getBooks();
        Book book = books.get(new Random().nextInt(books.size()));
        List<Review> reviews = service.getReviews(book.getTitle());
        System.out.println("Reviews for " + book + ": " + reviews);
    }
}
