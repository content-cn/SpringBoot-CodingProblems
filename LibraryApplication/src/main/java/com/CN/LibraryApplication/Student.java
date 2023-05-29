package com.CN.LibraryApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("Student")
@Scope("prototype")
public class Student implements User{

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
    public void issueOrAddBook(Book mybook) throws IndexOutOfBoundsException {
        for(Book book : this.bookList.getAllBooks()){
            if(book.getBookName().equals(mybook.getBookName()) && book.isIssued() == false){
                System.out.println("Book: " + book.getBookName() + " is issued to " +  this.name);
                book.issue();
                break;
            }
        }
    }
}
