package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public static void main(String[] args) throws FileNotFoundException {
        Simulation simulation = new Simulation();
        RunSimulation runSimulation = new RunSimulation();
        LoadU1List loadU1List = new LoadU1List();
        LoadU2List loadU2List = new LoadU2List();
        ReadFile readFile = new ReadFile();

        ArrayList<Item> phase1 = readFile.loadItems("phase-1.txt");
        ArrayList<Item> phase2 = readFile.loadItems("phase-2.txt");

        System.out.println("----------------------------------------------");

        System.out.println("Rockets U1 phase 1:");
        ArrayList<Rocket> u1ListP1 = loadU1List.loadU1List(phase1);
        int totalBudgetP1 = runSimulation.runSimulation(u1ListP1);
        System.out.println("Total budget for rockets U1: "+totalBudgetP1+ " milions");

        System.out.println("----------------------------------------------");

        System.out.println("Rockets U1 phase 2:");
        ArrayList<Rocket> u1ListP2 = loadU1List.loadU1List(phase2);
        int totalBudgetP2 = runSimulation.runSimulation(u1ListP2);
        System.out.println("Total budget for rockets U1: "+totalBudgetP2+ " milions");

        System.out.println("----------------------------------------------");

        System.out.println("Rockets U2 phase 1:");
        ArrayList<Rocket> u2ListP1 = loadU2List.loadU2List(phase1);
        totalBudgetP1 = runSimulation.runSimulation(u2ListP1);
        System.out.println("Total budget for rockets U2: "+totalBudgetP1+ " milions");

        System.out.println("----------------------------------------------");

        System.out.println("Rockets U2 phase 2:");
        ArrayList<Rocket> u2ListP2 = loadU2List.loadU2List(phase2);
        totalBudgetP2 = runSimulation.runSimulation(u2ListP2);
        System.out.println("Total budget for rockets U2: "+totalBudgetP2+ " milions");

    }
}
