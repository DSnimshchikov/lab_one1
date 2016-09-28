package ru.bstu.iitus.vt41.gibkinyuriy;

import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_TYPE = "Input type: \n 1-teacher, 2-manager, 3-schoolkid, 4-student";

    public static void main(String[] args) {
        int countPerson = readInt("Input Count member:");
        Person[] pr = initPersons(countPerson);
        findMinAgePerson(countPerson, pr);
    }

    private static void findMinAgePerson(int countPerson, Person[] pr) {
        Person minAgePerson = pr[0];
        for (int i = 1; i < countPerson; i++) {
            if (minAgePerson.compareTo(pr[i]) > 0) {
                minAgePerson = pr[i];
            }
        }
        System.out.println(minAgePerson.toString());
    }

    private static Person[] initPersons(int countPerson) {
        Person[] pr = new Person[countPerson];
        for (int i = 0; i < countPerson; i++) {
            pr[i] = buildPerson();
            pr[i].init(SCANNER);
        }
        return pr;
    }

    private static Person buildPerson() {
        int type = readInt(INPUT_TYPE);
        switch (type) {
            case 1:
                return new Teacher(); //Person.PersonType.TEACHER
            case 2:
                return new Manager();
            case 3:
                return new Schoolkid();
            case 4:
                return new Student();
            default:
                throw new IllegalStateException("Введен не верный тип");
        }
    }

    public static int readInt(String informText) {
        System.out.println(informText);
        return SCANNER.nextInt();
    }

    public static String readString(String informText) {
        System.out.println(informText);
        return SCANNER.nextLine();
    }
}
