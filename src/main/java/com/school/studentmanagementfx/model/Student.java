package com.school.studentmanagementfx.model;

import javafx.beans.property.SimpleStringProperty;

public class Student {
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty age;
    private final SimpleStringProperty birthday;
    private final SimpleStringProperty address;
    private final SimpleStringProperty course;
    private final SimpleStringProperty year;
    private final SimpleStringProperty email;

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

    public SimpleStringProperty getName() {
        return this.name;
    }

    public SimpleStringProperty getAge() {
        return this.age;
    }

    public SimpleStringProperty getBirthday() {
        return this.birthday;
    }

    public SimpleStringProperty getAddress() {
        return this.address;
    }


    public SimpleStringProperty getCourse() {
        return this.course;
    }

    public SimpleStringProperty getYear() {
        return this.year;
    }

    public SimpleStringProperty getEmail() {
        return this.email;
    }
}
