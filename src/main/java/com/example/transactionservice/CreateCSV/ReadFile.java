package com.example.transactionservice.CreateCSV;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ReadFile {
    public static void main (String[] args) throws Exception{

//        CSVReader reader = new CSVReader(new FileReader("C:\\Transactions\\2000\\Jan-Mar\\2000-01-15.csv"));
//        //Reading the contents of the csv file
//        StringBuffer buffer = new StringBuffer();
//        String line[];
//        while ((line = reader.readNext()) != null) {
//            for(int i = 0; i<line.length; i++) {
//                System.out.print(line[i]+" ");
//            }
//            System.out.println(" ");
//        }

        List<String> listOfStrings
                = new ArrayList<String>();
        List<String> listOfStrings1
                = new ArrayList<String>();


        // load the data from file
        listOfStrings
                = Files.readAllLines(Paths.get("C:\\Transactions\\2000\\Jan-Mar\\2000-01-15.csv"));
        listOfStrings1
                = Files.readAllLines(Paths.get("C:\\Transactions\\2000\\Jan-Mar\\2000-02-25.csv"));

        // convert arraylist to array
        String[] array
                = listOfStrings.toArray(new String[0]);
        String[] array1
                = listOfStrings1.toArray(new String[0]);

        // print each line of string in array
        for (String eachString : array) {
            System.out.println(eachString);
        }
        for (String eachString1 : array1) {
            System.out.println(eachString1);
        }
    }
}
