package com.example.transactionservice.Service;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class TransactionService {
    public void generateCSV(String filename)
    {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename);
            writer.append("Init_date");
            writer.append(',');
            writer.append("Conclusion_date");
            writer.append(',');
            writer.append("Product_id");
            writer.append(',');
            writer.append("Values");
            writer.append('\n');

            writer.append("2001-01-15");
            writer.append(',');
            writer.append("2001-01-16");
            writer.append(',');
            writer.append("2");
            writer.append(',');
            writer.append("$6200");
            writer.append('\n');

            writer.append("2001-01-15");
            writer.append(',');
            writer.append("2001-01-17");
            writer.append(',');
            writer.append("1");
            writer.append(',');
            writer.append("$3000");
            writer.append('\n');

            writer.append("2001-01-15");
            writer.append(',');
            writer.append("2001-01-17");
            writer.append(',');
            writer.append("3");
            writer.append(',');
            writer.append("$3900");
            writer.append('\n');

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
}
