package com.example.transactionservice.CreateCSV;

import java.io.FileWriter;
import java.io.IOException;

public class CreateCSV {
    private static void generateCsvFile(String fileName) {

        FileWriter writer = null;
        try {

            writer = new FileWriter(fileName);
            writer.append("Init_date");
            writer.append(',');
            writer.append("Conclusion_date");
            writer.append(',');
            writer.append("Product_id");
            writer.append(',');
            writer.append("Values");
            writer.append('\n');

            writer.append("2000-07-15");
            writer.append(',');
            writer.append("2000-07-16");
            writer.append(',');
            writer.append("2");
            writer.append(',');
            writer.append("$2200");
            writer.append('\n');

//            writer.append("2000-02-25");
//            writer.append(',');
//            writer.append("");
//            writer.append(',');
//            writer.append("");
//            writer.append(',');
//            writer.append("");
//            writer.append('\n');

            System.out.println("CSV file is created...");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        String location = "C:\\Transactions\\2000\\Jan-Mar\\2000-02-25.csv";
        generateCsvFile(location);

    }
}
