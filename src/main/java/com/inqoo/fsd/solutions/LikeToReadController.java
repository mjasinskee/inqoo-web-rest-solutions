package com.inqoo.fsd.solutions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("liketoread")
class LikeToReadController {

    private final LikeToReadService service;

    LikeToReadController(LikeToReadService service) {
        this.service = service;
    }

    @PostMapping("/addbook/{firstName}/{lastName}")
    void addBook(@PathVariable String firstName, @PathVariable String lastName, @RequestBody Book book) {
        service.addBook(firstName, lastName, book);
    }

    @PostMapping("/addreview/{title}")
    void addReview(@PathVariable String title, @RequestBody Review review) {
        service.addReview(title, review);
    }

    @GetMapping("/getreviews")
    @ResponseBody
    List<Review> getReviews(@RequestParam String title) {
        return service.getReviews(title);
    }

    @GetMapping("getBooks")
    List<Book> getBooks() {
        return service.getBooks();
    }

    @GetMapping("getAuthors")
    List<Author> getAuthors() {
        return service.getAuthors();
    }

}
