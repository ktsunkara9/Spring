package com.example.springdemo.json;

import java.util.List;

public class AstroResult {

    private String message;
    private int number;
    private List<Astronaut> people;

    public AstroResult() {
    }

    public AstroResult(String message, int number, List<Astronaut> people) {
        this.message = message;
        this.number = number;
        this.people = people;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Astronaut> getPeople() {
        return people;
    }

    public void setPeople(List<Astronaut> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "AstroResult{" +
                "message='" + message + '\'' +
                ", number=" + number +
                ", people=" + people +
                '}';
    }
}
