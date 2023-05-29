package com.CN.LibraryApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("Admin")
public class Admin implements User{

    private String name;

    @Autowired
    BookList bookList;

    @Override
    public void setDetails(String name) {
        this.name = name;
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookList.getAllBooks();
    }

    @Override
    public void issueOrAddBook(Book book) {
        this.bookList.addBook(book);
    }
}
