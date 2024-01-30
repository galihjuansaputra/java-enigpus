package com.enigma.enigpus.service;

import com.enigma.enigpus.entity.Book;
import com.enigma.enigpus.entity.Magazine;
import com.enigma.enigpus.entity.Novel;
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

    public ArrayList<Object> searchBookByTitle(String searchBook) {
        ArrayList<Object> books = getAllBook();
        Book magazine = new Magazine();
        Book novel = new Novel();

        ArrayList<Object> booksFiltered = new ArrayList<>();

        for (Object book : books) {
            if (magazine.getTitle().contains(searchBook) || novel.getTitle().contains(searchBook)){
                booksFiltered.add(book);
            }
        }

        return booksFiltered;
    }

    @Override
    public void searchBookByCode() {

    }

    @Override
    public void deleteBookByCode() {

    }


}
