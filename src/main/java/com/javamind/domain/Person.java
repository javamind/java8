package com.javamind.domain;

/**
 * @author EHRET_G
 */
public class Person {
    public int age;
    public String name;
    public String mail;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public Person setMail(String mail) {
        this.mail = mail;
        return this;
    }
}
