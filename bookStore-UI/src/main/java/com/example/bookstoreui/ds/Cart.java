package com.example.bookstoreui.ds;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Getter
@Setter
@ToString
public class Cart {

    private Set<Book> bookSet = new HashSet<>();

    public void addToCart(Book book) {
        bookSet.add(book);
    }

    public void removeBookFromCart(Book book) {
        bookSet.remove(book);
    }

    public int cartSize() {
        return bookSet.size();
    }

    public void clearCart(){
        bookSet.clear();
    }
}
