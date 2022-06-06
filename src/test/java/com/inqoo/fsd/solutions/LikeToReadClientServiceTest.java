package com.inqoo.fsd.solutions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LikeToReadClientServiceTest {

    @Autowired
    private LikeToReadClientService service;

    @Test
    public void shouldAddNewReview() {
        //given
        Review review = new Review("somenick1", Score.GOOD, "somedescription1");

        //when
        service.addReview("title2", review);

        //then
        List<Review> reviews = service.getReviews("title2");
        assertThat(reviews.size()).isEqualTo(1);
    }

}
