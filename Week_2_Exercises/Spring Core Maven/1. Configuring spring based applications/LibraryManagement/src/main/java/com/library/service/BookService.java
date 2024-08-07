package com.library.service;

//import com.library.repository.BookRepository;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printMessage() {
        System.out.println("Hello from BookService!");
        // Use the bookRepository instance here
    }
}