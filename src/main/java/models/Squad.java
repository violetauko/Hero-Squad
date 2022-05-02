package models;

import java.util.ArrayList;

public class Squad {

    private String name;
    private String cause;
    private int size;
    private int SquadId;
    private static ArrayList<Squad> instances = new ArrayList<>();
    private static ArrayList<Hero> member = new ArrayList<>();

    public Squad(String name, String cause, int size) {
        this.name = name;
        this.cause = cause;
        this.size = size;
        this.member = new ArrayList<>();
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
        member.add(newMember);
    }

    public static ArrayList<Hero> getMember() {
        return member;
    }
    public static void clearAllSquad(){
        instances.clear();
    }
    public static Squad findById(int id){
        return instances.get(id-1);
    }
    public void clearAllMember(){
        getMember().clear();
    }

    public static Squad setUpNewSquad(){
        return new Squad("Justice","Justice",10);
    }

    }
