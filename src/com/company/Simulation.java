package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public static void main(String[] args) throws FileNotFoundException {
        Simulation simulation = new Simulation();
        ArrayList<Item> phase1 = simulation.loadItems("phase-1.txt");
        ArrayList<Item> phase2 = simulation.loadItems("phase-2.txt");

        System.out.println("----------------------------------------------");

        System.out.println("Rockets U1 phase 1:");
        ArrayList<Rocket> u1ListP1 = simulation.loadU1List(phase1);
        int totalBudgetP1 = simulation.runSimulation(u1ListP1);
        System.out.println("Total budget for rockets U1: "+totalBudgetP1+ " milions");

        System.out.println("----------------------------------------------");

        System.out.println("Rockets U1 phase 2:");
        ArrayList<Rocket> u1ListP2 = simulation.loadU1List(phase2);
        int totalBudgetP2 = simulation.runSimulation(u1ListP2);
        System.out.println("Total budget for rockets U1: "+totalBudgetP2+ " milions");

        System.out.println("----------------------------------------------");

        System.out.println("Rockets U2 phase 1:");
        ArrayList<Rocket> u2ListP1 = simulation.loadU1List(phase1);
        totalBudgetP1 = simulation.runSimulation(u2ListP1);
        System.out.println("Total budget for rockets U2: "+totalBudgetP1+ " milions");

        System.out.println("----------------------------------------------");

        System.out.println("Rockets U2 phase 2:");
        ArrayList<Rocket> u2ListP2 = simulation.loadU1List(phase2);
        totalBudgetP2 = simulation.runSimulation(u2ListP2);
        System.out.println("Total budget for rockets U2: "+totalBudgetP2+ " milions");

    }

    //Read file
    ArrayList<Item> loadItems(String filePath) throws FileNotFoundException {
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

    //Create U1 rockets list
    ArrayList<Rocket> loadU1List(ArrayList<Item> loadItems){
        Rocket rocket = new U1(); // create new rocket
        ArrayList<Rocket> rocketList = new ArrayList<>(); // created rocket list

        System.out.println("U1 Rocket weight = " + rocket.weight + "; maxWeight = " + rocket.maxWeight);


        for (Item item : loadItems){
            while (!rocket.canCarry(item)) { // check if rocket can carry items
                rocketList.add(rocket); // add rocket to list
                rocket = new U1(); //create new rocket
            }
            rocket.carry(item); //add item to rocket
            //System.out.println("Item: "+item.name +" "+item.weight +" added to rocket list");

        }
        return rocketList;
    }

    //Create U1 rockets list
    ArrayList<Rocket> loadU2List(ArrayList<Item> loadItems){
        Rocket rocket = new U1(); // create new rocket
        ArrayList<Rocket> rocketList = new ArrayList<>(); // created rocket list


        for (Item item : loadItems){
            while (!rocket.canCarry(item)){ // check if rocket can carry items
                rocketList.add(rocket); // add rocket to list
                rocket = new U2();
            }
            rocket.carry(item);
            //System.out.println("Item: "+item.name +" "+item.weight +" added to rocket list");

        }
        return rocketList;
    }

    int runSimulation(ArrayList<Rocket> rocketList){
        int totalBudget;
        int crushesCount = 0;
        for (Rocket rocket : rocketList){
            while (!rocket.launch()){
                rocket.launch();
                crushesCount++;
            }

            while (!rocket.land()){
                rocket.land();
                crushesCount++;
            }
        }
        totalBudget = rocketList.get(0).cost * (rocketList.size()+crushesCount);
        System.out.println("Sent rockets: " + (rocketList.size()+crushesCount) + " Crushes: "+crushesCount);
        return totalBudget;
    }
}
