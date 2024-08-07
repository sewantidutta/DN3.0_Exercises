package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter for BookRepository
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printService() {
        System.out.println("Book Service is working...");
        if (bookRepository != null) {
            bookRepository.printRepository();
        } else {
            System.out.println("Book Repository is not set.");
        }
    }
}