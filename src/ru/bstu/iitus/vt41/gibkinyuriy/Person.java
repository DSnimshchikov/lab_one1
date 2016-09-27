package ru.bstu.iitus.vt41.gibkinyuriy;

import java.util.Scanner;

/**
 * Created by yuriy on 20.09.2016.
 */
public abstract class Person {
    public String Name;
    public String Member;
    public int Number;
    private int Age;

    public Person(int age, String member) {
        this.Age = age;
        this.Member = member;
    }

    public abstract void init(Scanner scanner);

    public int getAge() {
        return Age;
    }

    @Override
    public String toString() {
        return "Name: " + this.Name + " Age: " + this.Age + " Member: " + this.Member + " Number: " + this.Number;
    }


}

class Student extends Person//класс студент
{
    public Student(int age) {
        super(age, "Student");
    }

    @Override
    public void init(Scanner scanner) {
        System.out.println("Input Student ID card:");
        this.Number = scanner.nextInt();

    }
}

class Schoolkid extends Person//класс Школьники
{
    public Schoolkid(int age) {
        super(age, "Schoolkid");
    }

    @Override
    public void init(Scanner scanner) {
        System.out.println("Input number school:");
        this.Number = scanner.nextInt();
    }
}

class Cooperator extends Person//класс сотрудники
{
    public Cooperator(int age, String member) {
        super(age, member);
    }

    @Override
    public void init(Scanner scanner) {
    }
}

class Teacher extends Cooperator//класс учитель
{
    public Teacher(int age) {
        super(age, "Teacher");
    }

    @Override
    public void init(Scanner scanner) {
        System.out.println("Input number sertificate:");
        this.Number = scanner.nextInt();
    }
}

class Manager extends Cooperator//класс директор
{
    public Manager(int age) {
        super(age, "Manager");
    }

    @Override
    public void init(Scanner scanner) {
        System.out.println("Input manager number:");
        this.Number = scanner.nextInt();
    }
}