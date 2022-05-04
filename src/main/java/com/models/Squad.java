package com.models;

import java.util.ArrayList;

public class Squad {

    private String name;
    private String cause;
    private int size;
    private int SquadId;
    private static ArrayList<Squad> instances = new ArrayList<>();
    private static ArrayList<Hero> members = new ArrayList<>();

    public Squad(String name, String cause, int size) {
        this.name = name;
        this.cause = cause;
        this.size = size;
        this.members = new ArrayList<>();
        instances.add(this);
        this.SquadId = instances.size();
    }

    public String getName() {
        return name;
    }

    public String getCause() {
        return cause;
    }

    public int getSize() {
        return size;
    }

    public int getSquadId() {
        return SquadId;
    }

    public static ArrayList<Squad> getInstances() {
        return instances;
    }

    public static void setMember(Hero newMember) {
        members.add(newMember);
    }

    public static ArrayList<Hero> getMembers() {
        return members;
    }
    public static void clearAllSquad(){
        instances.clear();
    }
    public static Squad findBySquadId(int id){
        return instances.get(id-1);
    }
    public void clearAllMember(){
        getMembers().clear();
    }

    public static Squad setUpNewSquad(){
        return new Squad("Justice","Justice",10);
    }

    }
