package com.example.transactionservice.CreateCSV;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadCSV {
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String[] array = new String[200];
        List<String> listOfStrings = new ArrayList<>();
        String[] value = new String[100];
//        System.out.printf("----------\tReading %s\t-------", file.getFileName());
        BufferedReader bufferedReader = Files.newBufferedReader(file);
        String line = bufferedReader.readLine();
        while (line!= null) {
            System.out.println(line);
            line = bufferedReader.readLine();
//            i++;
        }
      System.out.println("Finished");
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("C:\\Transactions\\"), new ReadFile());
    }

}
