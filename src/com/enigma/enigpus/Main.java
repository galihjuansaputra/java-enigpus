package com.enigma.enigpus;

import com.enigma.enigpus.service.InventoryService;
import com.enigma.enigpus.service.InventoryServiceImpl;
import com.enigma.enigpus.view.BookView;

public class Main {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryServiceImpl();
        BookView bookView = new BookView(inventoryService);
        bookView.mainMenu();
    }
}
