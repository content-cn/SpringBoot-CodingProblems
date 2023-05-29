package com.CN.LibraryApplication;

import java.util.List;

public interface User {

    void setDetails(String name);

    List<Book> getAllBooks();

    void issueOrAddBook(Book book);
}
