package com.enigma.enigpus.util;

import com.enigma.enigpus.entity.Book;
import com.enigma.enigpus.entity.Magazine;
import com.enigma.enigpus.entity.Novel;
import com.enigma.enigpus.service.InventoryServiceImpl;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class Utility {
    static Scanner scanner = new Scanner(System.in);
    static Book novel = new Novel();
    static Book magazine = new Magazine();

    static InventoryServiceImpl inventoryService = new InventoryServiceImpl();


    public static String incrementNovelCode() {
        ArrayList<Object> books = inventoryService.getAllBook();
        int code = 0;

        for (Object book : books) {
            if (book instanceof Novel) {
                Novel novel = (Novel) book;
                String novelRawCode = novel.getCode();
                int lastindex =  novelRawCode.length()-1;
                int novelCode = Integer.parseInt(String.valueOf(novelRawCode.charAt(lastindex)));
                if (novelCode >= code) {
                    code = novelCode;
                }
            }
        }

        return String.valueOf(code+1);

    }

    public static String incrementMagazineCode() {
        ArrayList<Object> books = inventoryService.getAllBook();
        int code = 0;

        for (Object book : books) {
            if (book instanceof Magazine) {
                Magazine magazine = (Magazine) book;
                String novelRawCode = magazine.getCode();
                int lastindex =  novelRawCode.length()-1;
                int magazineCode = Integer.parseInt(String.valueOf(novelRawCode.charAt(lastindex)));
                if (magazineCode >= code) {
                    code = magazineCode;
                }
            }
        }

        return String.valueOf(code+1);

    }

    public static String inputStr() {
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty() || input.isBlank()) {
                continue;
            }
            return input;
        }
    }

    public static int inputInt() {
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty() || input.isBlank()) {
                continue;
            }
            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Input Tidak Valid");
            }

        }
    }
}
