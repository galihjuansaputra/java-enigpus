package com.enigma.enigpus.service;

import com.enigma.enigpus.entity.Book;
import com.enigma.enigpus.entity.Magazine;
import com.enigma.enigpus.entity.Novel;
import com.enigma.enigpus.util.FileUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        ArrayList<Object> booksFiltered = new ArrayList<>();

        for (Object book : books) {
            Book magazine = new Magazine();
            Book novel = new Novel();

            if (book instanceof Magazine){
                magazine = (Magazine) book;
            }

            if (book instanceof Novel){
                novel = (Novel) book;
            }

            String filteredMagazine = magazine.getTitle();
            String filteredString = novel.getTitle();

            if (Objects.equals(filteredMagazine, searchBook) || Objects.equals(filteredString, searchBook)){
                booksFiltered.add(book);
            }
        }

        return booksFiltered;
    }

    public ArrayList<Object> searchBookByCode(String bookCode) {
        ArrayList<Object> books = getAllBook();
        ArrayList<Object> booksFiltered = new ArrayList<>();

        for (Object book : books) {
            Book magazine = new Magazine();
            Book novel = new Novel();

            if (book instanceof Magazine){
                magazine = (Magazine) book;
            }

            if (book instanceof Novel){
                novel = (Novel) book;
            }

            String filteredMagazine = magazine.getCode();
            String filteredString = novel.getCode();

            if (Objects.equals(filteredMagazine, bookCode) || Objects.equals(filteredString, bookCode)){
                booksFiltered.add(book);
            }
        }

        return booksFiltered;
    }

    @Override
    public void deleteBookByCode() {

    }


}
