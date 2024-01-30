package com.enigma.enigpus.view;

import com.enigma.enigpus.entity.Book;
import com.enigma.enigpus.entity.Novel;
import com.enigma.enigpus.service.InventoryService;
import com.enigma.enigpus.util.Utility;

import java.util.ArrayList;
import java.util.List;

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
                    2. Lihat Semua Data Buku
                    3. Edit Data Buku
                    4. Hapus Data Buku
                    X. Keluar
                    """);
            System.out.println("-".repeat(100));
            System.out.print("Input Menu: ");
            String inputMenu = Utility.inputStr();
            System.out.println();
            switch (inputMenu) {
                case "1":
                    addBookMenu();
                    return;
                case "2":
                    viewAllBook();
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

    private void viewAllBook() {
        List books = inventoryService.getAllBook();
        System.out.println("Buku Novel");
        String format = String.format("%-10s %-30s %-30s %-30s", "Kode", "Judul", "Penerbit", "Tahun Terbit");

        System.out.println(format);
        for (Object book : books) {
            Novel novel = (Novel) book;
            System.out.printf("%-10s %-30s %-30s %-30s", novel.getCode(), novel.getTitle(), novel.getPublisher(), novel.getPublisher());
            System.out.println();
        }
        System.out.println();
    }


    private void addBookMenu() {
        while (isValid) {
            System.out.println("Tambah Data Buku");
            System.out.print("""
                    1. Tambah Novel
                    2. Tambah Majalah
                    0. Kembali
                    """);
            System.out.println("-".repeat(100));
            System.out.print("Input Menu: ");
            String bookType = Utility.inputStr();
            System.out.println();
            switch (bookType) {
                case "1":
                    saveNovelView();
                    mainMenu();
                    return;
                case "2":
                    return;
                case "0":
                    mainMenu();
                    isValid = false;
            }
        }
    }

    private void saveNovelView() {
        String code = Utility.incrementNovelCode();
        System.out.print("Input Judul: ");
        String title = Utility.inputStr();
        System.out.print("Input Penerbit: ");
        String publisher = Utility.inputStr();
        System.out.print("Input Tahun Terbit: ");
        int year = Utility.inputInt();
        System.out.print("Input Penulis: ");
        String penulis = Utility.inputStr();

        Book novel = new Novel(code, title, publisher, year, penulis);
        inventoryService.addBook(novel);
        System.out.println(novel);

    }
}
