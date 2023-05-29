package com.CN.LibraryApplication;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Book")
@Scope("prototype")
public class MyBook implements Book{

    private String name;
    private boolean isIssued = false;

    public MyBook(String name) {
        this.name = name;
    }

    public MyBook(){}

    @Override
    public String getBookName() {
        return this.name;
    }

    @Override
    public void setBookName(String name) {
        this.name = name;
    }

    @Override
    public boolean isIssued() {
        return this.isIssued;
    }

    @Override
    public void issue() {
        this.isIssued = true;
    }
}
