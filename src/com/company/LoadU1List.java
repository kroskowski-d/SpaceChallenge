package com.company;

import java.util.ArrayList;

public class LoadU1List {

    //Create U1 rockets list
    public ArrayList<Rocket> loadU1List(ArrayList<Item> loadItems){
        Rocket rocket = new U1(); // create new rocket
        ArrayList<Rocket> rocketList = new ArrayList<>(); // created rocket list


        for (Item item : loadItems){
            while (!rocket.canCarry(item)) { // check if rocket can carry items
                rocketList.add(rocket); // add rocket to list
                rocket = new U1(); //create new rocket
            }
            rocket.carry(item); //add item to rocket
        }
        return rocketList;
    }
}
