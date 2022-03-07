package com.example.exception.model;

public class Applicant {
    private String uuid;
    private int age;
    private String name;

    public Applicant(String uuid, int age, String name) {
        this.uuid = uuid;
        this.age = age;
        this.name = name;
    }

    public Applicant() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
