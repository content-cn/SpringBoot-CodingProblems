package com.CN.LibraryApplication;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyBookList implements BookList {

    List<Book> bookList = new ArrayList<>();

    @PostConstruct
    public void init(){
        this.bookList.add(new MyBook("The Martian"));
        this.bookList.add(new MyBook("Sapiens"));
        this.bookList.add(new MyBook("Introduction to Algorithms"));
    }

    @Override
    public void addBook(Book book) {
        this.bookList.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookList;
    }
}
