package com.inqoo.fsd.solutions;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InqooWebRestSolutionsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(InqooWebRestSolutionsApplication.class, args);
    }

    private final LikeToReadService service;

    public InqooWebRestSolutionsApplication(LikeToReadService service) {
        this.service = service;
    }

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Override
    public void run(String... args) throws Exception {
        service.addAuthor(new Author("firstName1", "lastName1"));
        service.addAuthor(new Author("firstName2", "lastName2"));
        service.addBook("firstName1", "lastName1", new Book("title1", "id1"));
        service.addBook("firstName1", "lastName1", new Book("title2", "id2"));
        service.addBook("firstName2", "lastName2", new Book("title3", "id3"));
        service.addBook("firstName2", "lastName2", new Book("title4", "id4"));
        service.addBook("firstName2", "lastName2", new Book("title5", "id5"));
    }
}
