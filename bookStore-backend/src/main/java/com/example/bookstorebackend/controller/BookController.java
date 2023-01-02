package com.example.bookstorebackend.controller;

import com.example.bookstorebackend.dao.BookDao;
import com.example.bookstorebackend.ds.Book;
import com.example.bookstorebackend.ds.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    public BookDao bookDao;


    @Transactional//database operation ta ku htae mhr aload load say chin lo htae tar
    @GetMapping("/creation")
    public String init() {
        Book book1 = new Book("Before the coffee gets cold", "Yamagaki", 5000, "Maroon",
                LocalDate.of(2000, 3, 8), "Si-Fic", "https://source.unsplash.com/random/400*300/?coffee");

        Book book2 = new Book("The tale of two cities", "Thomas Hardy", 5500, "Newon",
                LocalDate.of(1958, 7, 17), "Romance", "https://source.unsplash.com/random/400*300/?rose");

        Book book3 = new Book("Sons and Lovers", "DH Lawrence", 6900, "Thwon",
                LocalDate.of(1999, 2, 12), "Novel", "https://source.unsplash.com/random/400*300/?nature");

        Book book4 = new Book("The Birds", "MinLu", 6000, "SateKuuChoCho",
                LocalDate.of(2011, 12, 22), "Novel", "https://source.unsplash.com/random/400*300/?bird");

        Book book5 = new Book("Memories", "Juu", 2000, "Thwon",
                LocalDate.of(1999, 2, 12), "Novel", "https://source.unsplash.com/random/400*300/?memory");


        bookDao.save(book1);
        bookDao.save(book2);
        bookDao.save(book3);
        bookDao.save(book4);
        bookDao.save(book5);

        return "Successfully Created!";
    }

    @GetMapping("/books")
    public Books ListAllBooks() {
        return new Books(bookDao.findAll());
    }

    record BookDto(int id, String title, String authorName, double price, String publisher, LocalDate yearPublished,
                   String genre, String imageUrl){}

    @GetMapping("/books/{id}")
    public ResponseEntity findBookById(@PathVariable("id") int id) {
        Optional<com.example.bookstorebackend.ds.Book>
                bookOptional = bookDao.findById(id);

        if (bookOptional.isPresent()) {
            com.example.bookstorebackend.ds.Book book = bookOptional.get();
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new BookDto(
                            book.getId(),
                            book.getTitle(),
                            book.getAuthorName(),
                            book.getPrice(),
                            book.getPublisher(),
                            book.getYearPublished(),
                            book.getGenre(),
                            book.getImageUrl()
                    ));
        } else {
            return ResponseEntity.notFound().build();
        }

    }


}
