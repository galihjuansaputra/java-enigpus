package com.enigma.enigpus.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileUtility {

    private static final Path bookPath = Path.of("book");

    public static void saveObject(Object object) {
        try (OutputStream os = Files.newOutputStream(bookPath)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
                oos.writeObject(object);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readObject() {
        if (!Files.exists(bookPath)) {
            saveObject(new ArrayList<>());
        }
        try (InputStream is = Files.newInputStream(bookPath)) {
            try (ObjectInputStream oos = new ObjectInputStream(is)) {
                return oos.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
