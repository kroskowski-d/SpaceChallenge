package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    public ArrayList<Item> loadItems(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        ArrayList<Item> items = new ArrayList<Item>();

        while (scanner.hasNextLine()){
            String[] item = scanner.nextLine().split("="); // Split item for name and value
            items.add(new Item(item[0], Integer.valueOf(item[1])));//Create
        }

        System.out.println("Count of items: "+ items.size());
        return items;
    }
}
