package com.enigma.enigpus.view;

import com.enigma.enigpus.service.InventoryService;
import com.enigma.enigpus.util.Utility;

public class BookView {
private final InventoryService inventoryService;

boolean isValid = true;

    public BookView(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void mainMenu() {
        while (isValid) {
            System.out.println("-".repeat(100));
            System.out.println("Enigma Perpustakaan");
            System.out.println("-".repeat(100));
            System.out.print("""
                    1. Tambah Data Buku
                    2. Lihat Data Buku
                    3. Edit Data Buku
                    4. Hapus Data Buku
                    X. Keluar
                    """);
            System.out.println("-".repeat(100));
            System.out.print("Input Menu: ");
            String inputMenu = Utility.inputStr();
            switch (inputMenu) {
                case "1":
                    addBookMenu();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "x", "X":
                    isValid = false;
            }
        }
    }

    public void addBookMenu() {
        System.out.println();
        System.out.println("Tambah Data Buku");
        System.out.print("""
                    1. Tambah Novel
                    2. Tambah Majalah
                    0. Kembali
                    """);
        System.out.println("-".repeat(100));
        System.out.print("Input Menu: ");
        String bookType = Utility.inputStr();
        while (isValid) {
            switch (bookType) {
                case "1":


                    break;
                case "2":
                    break;
                case "0":
                    mainMenu();
                    isValid = false;
            }
        }
    }


}
