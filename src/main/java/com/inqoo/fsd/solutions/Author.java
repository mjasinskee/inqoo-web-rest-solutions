package com.inqoo.fsd.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Author {

    private final String firstName;
    private final String lastName;
    private final List<Book> books = new ArrayList<>();

    Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void add(Book book) {
        books.add(book);
    }

    public List<Book> books() {
        return Collections.unmodifiableList(books);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName) && Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, books);
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }
}
