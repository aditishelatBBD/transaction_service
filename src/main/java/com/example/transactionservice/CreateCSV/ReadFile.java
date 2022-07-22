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

        HashMap<String,List<List<String>>> mapOfFile = new HashMap<>();

        List<String> listOfString = new ArrayList<>();

        List<List<String>> listOfList = new ArrayList<>();

        String line2 = null;

//        System.out.println(mapOfFile);


//        System.out.println(line + "whole line");
        Integer i=0;
        while ((line2 = bufferedReader.readLine()) != null) {

            listOfList = new ArrayList<>();
            array = line2.split(",");

            for(String arr : array) {
//                System.out.println(arr);
                listOfString.add(arr);
            }
            listOfList.add(listOfString);

            mapOfFile.put(file.getFileName().toString(),listOfList);

            System.out.println(line2);

//            array = new String[200];
//
//            listOfStrings.add(array);
//
//            System.out.println(listOfList.get(0));
//
//             String newArray =  Arrays.toString(listOfStrings.get(0));
//
//            System.out.println(newArray.split(",")[3]);
//            System.out.println(listOfList);

//            listOfStrings.add(listOfList);

//            mapOfFile.put(file.getFileName().toString(),listOfStrings);

//            System.out.println(listOfStrings);


//            if (!line.contains("I")) {
//
//            } else {
//                array = line.split(",");
//                listOfStrings.add(line);
////              array[i] = listOfStrings.toArray(new String[0]);
//            }
//            System.out.println(line);
//            System.out.println("array: "+listOfStrings);
//            line = bufferedReader.readLine();
//            i++;

        }
//        System.out.println(listOfList.get(0).get(0));
        String date = new String();
        date = listOfList.get(0).get(0);
        System.out.println(date);
//        System.out.println(mapOfFile.get("2001-01-15.csv").get(0));
        for(Map.Entry m : mapOfFile.entrySet()){
//            System.out.println(m.getKey()+" "+m.getValue());
            listOfStrings = (List<String>) m.getValue();
//            System.out.println(listOfStrings);
        }
//      System.out.println("Finished");
//      System.out.println(array[2]);
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("C:\\Transactions\\"), new ReadFile());
    }

}
