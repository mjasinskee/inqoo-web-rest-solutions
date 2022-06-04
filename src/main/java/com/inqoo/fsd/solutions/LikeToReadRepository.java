package com.inqoo.fsd.solutions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
class LikeToReadRepository {

    private static final Logger log = LoggerFactory.getLogger(LikeToReadService.class);

    private final List<Author> authors = new ArrayList<>();

    void addAuthor(Author author) {
        authors.add(author);
    }

    Optional<Author> findAuthor(String firstName, String lastName) {
        return authors.stream().filter(author -> matchByFirstAndLastName(firstName, lastName, author)).findFirst();
    }

    void addBook(Author author, Book book) {
        authors.stream()
                .filter(author1 -> author1.equals(author))
                .findFirst()
                .ifPresentOrElse(author1 -> author1.add(book), () -> log.warn("Could not add book for for not existing author {}", author));
    }

    void addReview(String title, Review review) {
        log.info("Adding review for {}: {}", title, review);
        findBook(title).ifPresentOrElse(book -> book.addReview(review), () -> log.warn("Could not add review for not existing book {}", title));
    }

    Optional<Book> findBook(String title) {
        return authors.stream()
                .map(Author::books)
                .collect(Collectors.toList())
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList())
                .stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst();
    }

    List<Author> getAuthors() {
        return Collections.unmodifiableList(authors);
    }

    List<Book> getBooks() {
        return authors.stream()
                .map(Author::books)
                .collect(Collectors.toList())
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    void clear() {
        authors.clear();
    }

    private boolean matchByFirstAndLastName(String firstName, String lastName, Author author) {
        return author.getFirstName().equals(firstName) && author.getLastName().equals(lastName);
    }
}
