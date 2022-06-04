package com.inqoo.fsd.solutions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LikeToReadServiceTest {

    @Autowired
    private LikeToReadService service;

    @Test
    public void shouldAddReviewToExistingBookForExistingAuthor() {
        //given
        thereIsAuthorWithBooks();

        //when
        Review review = new Review("nick1", Score.GOOD, "content1");
        service.addReview("title1", review);

        //then
        List<Review> reviews = service.getReviews("title1");
        assertThat(reviews.size()).isEqualTo(1);
        assertThat(reviews).contains(review);
    }

    private void thereIsAuthorWithBooks() {
        List<Book> books = Arrays.asList(new Book("title1", "id1"), new Book("title2", "id2"));
        Author author = new Author("firstName", "lastName");
        books.forEach(author::add);
        service.addAuthor(author);
    }

}
