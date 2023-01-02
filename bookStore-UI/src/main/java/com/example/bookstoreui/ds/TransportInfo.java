package com.example.bookstoreui.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class TransportInfo {

    private String name;
    private String orderId;
    private Set<Book> books;
    private double total;

    public TransportInfo() {
    }
}
