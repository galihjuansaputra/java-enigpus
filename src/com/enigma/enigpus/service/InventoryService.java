package com.enigma.enigpus.service;

import com.enigma.enigpus.entity.Book;

import java.util.ArrayList;

public interface InventoryService {

    void addBook(Book book);

    void searchBookByTitle();
    void searchBookByCode();
    void deleteBookByCode();
    ArrayList<Object> getAllBook();
}
