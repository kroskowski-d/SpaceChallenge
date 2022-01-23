package com.company;

public class U2 extends Rocket{

    public U2(){
        cost = 120; //milions
        weight = 18000; // kg
        maxWeight = 29000;
        launchExplosion = 0.0;
        landingCrash = 0.0;
        currentWeight = weight;

    }

    @Override
    public boolean launch() {
        int randomExlposionChance = (int) (Math.random() * 100 + 1);
        this.launchExplosion = 0.04 * (this.currentWeight-this.weight) / (this.maxWeight - this.weight)*1000;
        return this.launchExplosion <= randomExlposionChance;
    }

    @Override
    public boolean land() {
        int randomCrashChance = (int)(Math.random() * 100 + 1);
        this.landingCrash = 0.08 * (this.currentWeight-this.weight) / (this.maxWeight - this.weight)*1000;
        return this.landingCrash <= randomCrashChance;
    }
}
