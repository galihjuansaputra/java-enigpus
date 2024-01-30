package com.enigma.enigpus.service;

public interface InventoryService {

    void addBook();
    void searchBookByTitle();
    void searchBookByCode();
    void deleteBookByCode();
    void getAllBook();
}
