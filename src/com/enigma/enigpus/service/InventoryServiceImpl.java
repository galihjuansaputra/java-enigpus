package com.enigma.enigpus.service;

import com.enigma.enigpus.entity.Book;
import com.enigma.enigpus.util.FileUtility;

import java.util.ArrayList;
import java.util.List;

public class InventoryServiceImpl implements InventoryService {

    @Override
    public void addBook(Book book) {
        List<Object> books = getAllBook();
        books.add(book);
        FileUtility.saveObject(books);
    }

    @Override
    public ArrayList<Object> getAllBook() {
        Object object = FileUtility.readObject();

        if (object == null) {
            return new ArrayList<>();
        }

        return (ArrayList<Object>) object;
    }


    @Override
    public void searchBookByTitle() {

    }

    @Override
    public void searchBookByCode() {

    }

    @Override
    public void deleteBookByCode() {

    }


}
