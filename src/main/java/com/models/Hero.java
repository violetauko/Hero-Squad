package com.models;

import java.util.ArrayList;

public class Hero {

    private String name;
    private int age;
    private String specialPower;
    private String weakness;
    private int id;
    private static ArrayList<Hero> instances = new ArrayList<>();

    public Hero(String name, Integer age, String specialPower, String weakness) {
        this.name = name;
        this.age = age;
        this.specialPower = specialPower;
        this.weakness = weakness;
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public String getWeakness() {
        return weakness;
    }

    public int getId() {
        return id;
    }

    public static ArrayList<Hero> getAll() {
        return instances;
    }
    public static void clearAllHeroes(){
        instances.clear();
    }
    public static Hero findById(int id){
        return instances.get(id-1);
    }

    public void deleteHero(){
        instances.remove(id-1);
    }
     public static Hero setUpNewHero() {
    return new Hero("SuperMan",34,"Speed","Magic");
     }
}
