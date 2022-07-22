package com.example.transactionservice.CreateCSV;

import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.SQLOutput;
import java.util.*;

public class ReadFile extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String[] array = new String[200];
        List<String> listOfStrings = new ArrayList<>();
        String[] value = new String[100];
//        System.out.printf("----------\tReading %s\t-------", file.getFileName());
        BufferedReader bufferedReader = Files.newBufferedReader(file);
        String line = bufferedReader.readLine();
        String line2=null;
        while ((line2 = bufferedReader.readLine())!= null) {
            System.out.println("record:"+line2);
            listOfStrings.add(line2);
        }
        System.out.println("Finished");
        System.out.println("list:=="+listOfStrings);
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("C:\\Transactions\\"), new ReadFile());
    }

}
