package com.example.transactionservice.CreateCSV;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class ConsoleItemWriter<T> implements ItemWriter<T>{
    @Override
    public void write(List<? extends T> items) throws Exception {
        String[] array = new String[0];
        for (T item : items) {
            System.out.println("----------"+item);
            array = items.toArray(new String[0]);
//            System.out.println(array);
        }
        for (String eachString : array) {
            System.out.println(eachString);
        }
    }
}
