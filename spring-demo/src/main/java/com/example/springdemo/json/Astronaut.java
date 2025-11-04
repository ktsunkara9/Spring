package com.example.springdemo.json;

public class Astronaut {

    private String craft;
    private String name;

    public Astronaut() {
    }

    public Astronaut(String craft, String name) {
        this.craft = craft;
        this.name = name;
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Astronaut{" +
                "craft='" + craft + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
