kontrolery lab
- napiszemy lubimyczytac.pl - dodajemy książki i wystawiamy ich recenzje
- utwórz nowy projekt dodając jako jedną z zależności Spring Web
- tam gdzie jest ...  wstaw własny kod ;)
- utwórz wymagane klasy:
  class Book {

  private final String title;
  private final String identifier;
  private final List<Review> reviews = new ArrayList<>();
  ...
  }

class Author {

    private final String firstName;
    private final String lastName;
    private final List<Book> books = new ArrayList<>();
...
}

class Review {

    private final String nickName;
    private final Score score;
    private final String content;
...
}

- utwórz repozytorium pozwalające przechowywać nasze dane:
  ...
  class LikeToReadRepository {

  ...

  void addAuthor(Author author) {
  ...
  }

  Optional<Author> findAuthor(String firstName, String lastName) {
  ...
  }

  void addBook(Author author, Book book) {
  ...
  }

  void addReview(String title, Review review) {
  ...
  }

  Optional<Book> findBook(String title) {
  ...
  }

  List<Author> getAuthors() {
  ...
  }

  List<Book> getBooks() {
  ...
  }

  void clear() {
  authors.clear();;
  }

}

-utwórz serwis będący punktem wejścia do naszego systemu:
...
class LikeToReadService {


    private final LikeToReadRepository repository;

    ...

    void addAuthor(Author author) {
      ...
    }

    void addBook(String firstName, String lastName, Book book) {
      ...
    }

    void addReview(String title, Review review) {
        ...
    }

    List<Review> getReviews(String title) {
        ...
    }

    List<Author> getAuthors() {
        ...
    }

    List<Book> getBooks() {
        ...
    }
}

- utwórz kontroler umożliwiający:
    - dodanie książki
    - dodanie recenzji dla danej książki
    - pobranie recensji dla książki o danym tytule
    - pobranie wszystkich książek
    - pobranie wszytkich autorów
      ...
      class LikeToReadController {

      ...

      ...
      void addBook(@PathVariable String firstName, @PathVariable String lastName, @RequestBody Book book) {
      ...
      }

      ...
      void addReview(@PathVariable String title, @RequestBody Review review) {
      ...

      ...
      List<Review> getReviews(@RequestParam String title) {
      r...
      }

      ...
      List<Book> getBooks() {
      ...
      }

      ...
      List<Author> getAuthors() {
      ...
      }

  }
