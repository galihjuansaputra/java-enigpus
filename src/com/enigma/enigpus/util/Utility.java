package com.enigma.enigpus.util;

import java.util.Scanner;

public class Utility {
    static Scanner scanner = new Scanner(System.in);

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
            try{
                return Integer.parseInt(input);
            } catch (Exception e){
                System.out.println("Input Tidak Valid, Coba lagi...");
            }

        }
    }
}
