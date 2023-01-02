package com.example.transportationapp.ds;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Integer id;

    private String title;

    private String authorName;

    private double price;

    private String publisher;

    private LocalDate yearPublished;

    private String categoryName;

    private String genre;

    private String imageUrl;

    private Integer itemCount;
    @ManyToOne
    private TransportInfo transportInfo;


    public Book() {
    }

    public Book(String title, String authorName, double price, String publisher, LocalDate yearPublished, String genre, String imageUrl,Integer itemCount) {
        this.title = title;
        this.authorName = authorName;
        this.price = price;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.genre = genre;
        this.imageUrl = imageUrl;
        this.itemCount=itemCount;
    }

    public Book(String title, String authorName, double price, String publisher, LocalDate yearPublished, String genre, String imageUrl) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
