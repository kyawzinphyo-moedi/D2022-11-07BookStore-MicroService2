package com.example.bookstoreui.service;

import com.example.bookstoreui.ds.Book;
import com.example.bookstoreui.ds.Books;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Service
public class BookService {
    @Value("${api.url}")
    private String backendUrl;
    private List<Book> books = new LinkedList<>();

    private void showAllBooks() {
        this.books = template.getForEntity(backendUrl + " api/books", Books.class).getBody().getBooks();
    }

    @PostConstruct
    public void postConstruct() {
        showAllBooks();
    }

    public List<Book> findAllBooks() {
        return books;
    }

    public Book findBooksByID(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(id + " not Found!"));
    }


    private RestTemplate template = new RestTemplate();


}
