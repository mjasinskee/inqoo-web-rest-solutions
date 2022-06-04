package com.inqoo.fsd.solutions;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class LikeToReadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LikeToReadRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldAddReviewToExistingBookForExistingAuthor() throws Exception {
        //given
        Book book = new Book("title", "id");
        Review review = new Review("nick", Score.GOOD, "content");
        book.addReview(review);
        Mockito.when(repository.findBook(Mockito.anyString())).thenReturn(Optional.of(book));

        //when
        MvcResult mvcResult = mockMvc.perform(get("/liketoread/getreviews?title=title")).andReturn();

        //then
        List<Review> reviews = Arrays.asList(objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Review[].class));
        assertThat(reviews.size()).isEqualTo(1);
        assertThat(reviews).contains(review);
    }

}
