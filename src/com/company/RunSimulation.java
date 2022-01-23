package com.company;

import java.util.ArrayList;

public class RunSimulation {

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
