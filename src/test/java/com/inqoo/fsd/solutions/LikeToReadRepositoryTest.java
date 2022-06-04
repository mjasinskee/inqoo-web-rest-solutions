package com.inqoo.fsd.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LikeToReadRepositoryTest {

    @Autowired
    private LikeToReadService service;
    @Autowired
    private LikeToReadRepository repository;

    @BeforeEach
    void setup() {
        repository.clear();
    }

    @Test
    public void shouldFindCertainBook() {
        //given
        initialize();

        //when
        Book book = repository.findBook("someTitle1").get();

        //then
        assertThat(book.getTitle()).isEqualTo("someTitle1");
    }

    @Test
    public void shouldAddReviewToBook() {
        //given
        initialize();

        //when
        service.addReview("someTitle2", new Review("nick1", Score.GOOD, "content1"));

        //then
        Book book = repository.findBook("someTitle2").get();
        assertThat(book.getReviews()).hasSize(1);
    }

    private void initialize() {
        service.addAuthor(new Author("someFirstName1", "someLastName1"));
        service.addAuthor(new Author("someFirstName2", "someLastName2"));
        service.addBook("someFirstName1", "someLastName1", new Book("someTitle1", "someId1"));
        service.addBook("someFirstName1", "someLastName1", new Book("someTitle2", "someId2"));
        service.addBook("someFirstName2", "someLastName2", new Book("someTitle3", "someId3"));
        service.addBook("someFirstName2", "someLastName2", new Book("someTitle4", "someId4"));
        service.addBook("someFirstName2", "someLastName2", new Book("someTitle5", "someId5"));
    }

}
