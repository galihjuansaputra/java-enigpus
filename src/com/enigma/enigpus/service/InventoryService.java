package com.enigma.enigpus.service;

import com.enigma.enigpus.entity.Book;

import java.util.ArrayList;
import java.util.List;

public interface InventoryService {

    void addBook(Book book);

    ArrayList<Object> searchBookByTitle(String book);

    ArrayList searchBookByCode(String book);
    List<Book> getAllBook();

    List<Book> deleteBookByCode(String bookCode);
}
