package ru.bstu.iitus.vt41.gibkinyuriy;

import java.util.Scanner;

/**
 * Created by yuriy on 20.09.2016.
 */
public class Person implements Comparable {
    public String Name; //fixme to camelCase
    public String Member; //fixme
    public int Number; //fixme
    private int Age;  //fixme

    public Person() {
    }

    public void init(Scanner scanner) {
        Name = Main.readString("Input Name and Surname:");
        Age = Main.readInt("Input age:");
    }

    public int getAge() {
        return Age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        if (Age != person.Age) return false;
        return Name != null && Name.equals(person.Name);

    }

    @Override
    public int hashCode() {
        int result = Name.hashCode();
        result = 31 * result + Age;
        return result;
    }

    @Override
    public String toString() {
        return "Name: " + this.Name + " Age: " + this.Age + " Member: " + this.Member + " Number: " + this.Number;
    }

    @Override
    public int compareTo(Object o) {
        return getAge() - ((Person) o).getAge();
    }

    enum PersonType {
        TEACHER(1), STUDENT(2);

        int value;

        PersonType(int i) {
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }


}

class Student extends Person//класс студент
{
    public Student() {
        super();
    }

    @Override
    public void init(Scanner scanner) {
        System.out.println("Input Student ID card:");
        this.Number = scanner.nextInt();

    }
}

class Schoolkid extends Person//класс Школьники
{
    public Schoolkid() {
        super();
    }

    @Override
    public void init(Scanner scanner) {
        System.out.println("Input number school:");
        this.Number = scanner.nextInt();
    }
}

class Cooperator extends Person//класс сотрудники
{
    public Cooperator() {
    }

    @Override
    public void init(Scanner scanner) {
        super.init(scanner);
    }
}

class Teacher extends Cooperator {
    public Teacher() {
        super();
    }

    @Override
    public void init(Scanner scanner) {
        super.init(scanner);
        System.out.println("Input number sertificate:");
        this.Number = scanner.nextInt();
    }
}

class Manager extends Cooperator//класс директор
{
    public Manager() {
        super();
    }

    @Override
    public void init(Scanner scanner) {
        System.out.println("Input manager number:");
        this.Number = scanner.nextInt();
    }
}