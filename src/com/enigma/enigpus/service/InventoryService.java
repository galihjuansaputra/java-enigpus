package com.enigma.enigpus.service;

import com.enigma.enigpus.entity.Book;

import java.util.ArrayList;

public interface InventoryService {

    void addBook(Book book);

    ArrayList<Object> searchBookByTitle(String book);

    void searchBookByCode();
    void deleteBookByCode();
    ArrayList<Object> getAllBook();
}
