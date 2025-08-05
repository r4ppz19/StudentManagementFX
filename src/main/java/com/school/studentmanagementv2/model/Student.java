package com.school.studentmanagementv2.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleIntegerProperty age;
    private SimpleStringProperty birthday;
    private SimpleStringProperty address;
    private SimpleStringProperty course;
    private SimpleIntegerProperty year;
    private SimpleStringProperty email;

    public Student(int id, String name, int age, String birthday, String address, String course, int year,
            String email) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleIntegerProperty(age);
        this.birthday = new SimpleStringProperty(birthday);
        this.address = new SimpleStringProperty(address);
        this.course = new SimpleStringProperty(course);
        this.year = new SimpleIntegerProperty(year);
        this.email = new SimpleStringProperty(email);
    }

    public SimpleIntegerProperty getId() {
        return this.id;
    }

    public void setId(SimpleIntegerProperty id) {
        this.id = id;
    }

    public SimpleStringProperty getName() {
        return this.name;
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public SimpleIntegerProperty getAge() {
        return this.age;
    }

    public void setAge(SimpleIntegerProperty age) {
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

    public SimpleIntegerProperty getYear() {
        return this.year;
    }

    public void setYear(SimpleIntegerProperty year) {
        this.year = year;
    }

    public SimpleStringProperty getEmail() {
        return this.email;
    }

    public void setEmail(SimpleStringProperty email) {
        this.email = email;
    }
}
