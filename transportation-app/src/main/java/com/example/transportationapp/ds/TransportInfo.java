package com.example.transportationapp.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class TransportInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String orderId;
    @OneToMany(mappedBy = "transportInfo",cascade = CascadeType.PERSIST)
    private Set<Book> books=new HashSet<>();
    private double total;

    public TransportInfo() {
    }

    public void addBooks(Book book){
        book.setTransportInfo(this);
        books.add(book);
    }

    public TransportInfo(String name, String orderId, double total) {
        this.name = name;
        this.orderId = orderId;
        this.total = total;
    }
}
