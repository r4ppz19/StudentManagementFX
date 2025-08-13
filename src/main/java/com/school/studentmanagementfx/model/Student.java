package com.school.studentmanagementfx.model;

import javafx.beans.property.SimpleStringProperty;

public class Student {
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty age;
    private SimpleStringProperty birthday;
    private SimpleStringProperty address;
    private SimpleStringProperty course;
    private SimpleStringProperty year;
    private SimpleStringProperty email;

    public Student(String id, String name, String age, String birthday, String address, String course, String year,
                   String email) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleStringProperty(age);
        this.birthday = new SimpleStringProperty(birthday);
        this.address = new SimpleStringProperty(address);
        this.course = new SimpleStringProperty(course);
        this.year = new SimpleStringProperty(year);
        this.email = new SimpleStringProperty(email);
    }

    // Getters
    public SimpleStringProperty getId() {
        return this.id;
    }

    // Setters
    public void setId(SimpleStringProperty id) {
        this.id = id;
    }

    public SimpleStringProperty getName() {
        return this.name;
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public SimpleStringProperty getAge() {
        return this.age;
    }

    public void setAge(SimpleStringProperty age) {
        this.age = age;
    }

    public SimpleStringProperty getBirthday() {
        return this.birthday;
    }

    public void setBirthday(SimpleStringProperty birthday) {
        this.birthday = birthday;
    }

    public SimpleStringProperty getAddress() {
        return this.address;
    }

    public void setAddress(SimpleStringProperty address) {
        this.address = address;
    }

    public SimpleStringProperty getCourse() {
        return this.course;
    }

    public void setCourse(SimpleStringProperty course) {
        this.course = course;
    }

    public SimpleStringProperty getYear() {
        return this.year;
    }

    public void setYear(SimpleStringProperty year) {
        this.year = year;
    }

    public SimpleStringProperty getEmail() {
        return this.email;
    }

    public void setEmail(SimpleStringProperty email) {
        this.email = email;
    }

}
