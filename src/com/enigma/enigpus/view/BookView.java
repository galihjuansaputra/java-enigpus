package com.enigma.enigpus.view;

import com.enigma.enigpus.entity.Book;
import com.enigma.enigpus.entity.Magazine;
import com.enigma.enigpus.entity.Novel;
import com.enigma.enigpus.service.InventoryService;
import com.enigma.enigpus.util.Utility;

import java.time.Year;
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
            System.out.println("-".repeat(120));
            System.out.println("Enigma Perpustakaan");
            System.out.println("-".repeat(120));
            System.out.print("""
                    1. Tambah Data Buku
                    2. Lihat Semua Data Buku
                    3. Cari Data Buku
                    4. Hapus Data Buku
                    X. Keluar
                    """);
            System.out.println("-".repeat(120));
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
                    searchBookMenu();
                    break;
                case "4":
                    break;
                case "x", "X":
                    isValid = false;
            }
        }
    }

    private void searchBookMenu() {
        while (isValid) {
            System.out.println("Cari Buku: ");
            System.out.print("""
                    1. Cari Buku Berdasarkan Judul
                    2. Cari Buku Berdasarkan Kode Buku
                    0. Kembali
                    """);
            System.out.println("-".repeat(120));
            System.out.print("Input Menu: ");
            String searchType = Utility.inputStr();
            System.out.println();

            switch (searchType) {
                case "1":
                    searchByTitleView();
                    mainMenu();
                    return;
                case "2":
                    searchByCodeView();
                    mainMenu();
                    return;
                case "0":
                    mainMenu();
                    isValid = false;
            }
        }
    }

    private void searchByTitleView(){
        System.out.println("Input Judul Buku: ");
        String searchBook = Utility.inputStr();
        ArrayList<Object> booksFiltered = inventoryService.searchBookByTitle(searchBook);
        System.out.println(booksFiltered);
    }

    private void searchByCodeView(){
        System.out.println("Input Kode Buku: ");
        String searchBook = Utility.inputStr();
        ArrayList<Object> booksFiltered = inventoryService.searchBookByCode(searchBook);
        System.out.println(booksFiltered);
    }

    private void viewAllBook() {
        List books = inventoryService.getAllBook();

        if (books.isEmpty()) {
            System.out.println("Data Kosong");
            System.out.println();
            return;
        }

        System.out.println("Data Buku Novel: ");

        String formatNovel = String.format("%-10s %-30s %-30s %-30s %-30s", "Kode", "Judul", "Penulis", "Penerbit", "Tahun Terbit");

        System.out.println(formatNovel);
        for (Object book : books) {
            if (book instanceof Novel) {
                Novel novel = (Novel) book;
                System.out.printf("%-10s %-30s %-30s %-30s %-30s", novel.getCode(), novel.getTitle(), novel.getWriter(), novel.getPublisher(), novel.getReleaseYear());
            }
            System.out.println();
        }

        System.out.println("Data Majalah: ");
        String formatMagazine = String.format("%-10s %-30s %-30s %-30s", "Kode", "Judul", "Penerbit", "Tahun Terbit");

        System.out.print(formatMagazine);
        for (Object book : books) {
            if (book instanceof Magazine) {
                Magazine magazine = (Magazine) book;
                System.out.printf("%-10s %-30s %-30s %-30s", magazine.getCode(), magazine.getTitle(), magazine.getReleasePer(), magazine.getReleaseYear());
            }
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
            System.out.println("-".repeat(120));
            System.out.print("Input Menu: ");
            String bookType = Utility.inputStr();
            System.out.println();

            switch (bookType) {
                case "1":
                    saveNovelView();
                    mainMenu();
                    return;
                case "2":
                    saveMagazineView();
                    mainMenu();
                    return;
                case "0":
                    mainMenu();
                    isValid = false;
            }
        }
    }

    private void saveMagazineView() {
        String code = Utility.incrementMagazineCode();

        System.out.print("Input Judul: ");
        String title = Utility.inputStr();
        System.out.print("Input Periode Terbit (Monthly/Yearly): ");
        String releasePer = Utility.inputStr();
        System.out.print("Input Tahun Terbit: ");
        int year = Utility.inputInt();

        String codeFormat = year + "-B-" + code;

        Book magazine = new Magazine(codeFormat, title, releasePer, year);
        inventoryService.addBook(magazine);
        System.out.println(magazine);

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

        String codeFormat = year + "-A-" + code;

        Book novel = new Novel(codeFormat, title, publisher, year, penulis);
        inventoryService.addBook(novel);
        System.out.println(novel);

    }
}
