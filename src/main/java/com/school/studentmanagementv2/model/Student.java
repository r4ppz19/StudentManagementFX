package com.school.studentmanagementv2.model;

public class Student {
    private String id;
    private String name;
    private int age;
    private String birthday;
    private String address;
    private String course;
    private int year;
    private String email;

    public Student(String id, String name, int age, String birthday, String address, String course, int year,
            String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.address = address;
        this.course = course;
        this.year = year;
        this.email = email;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
