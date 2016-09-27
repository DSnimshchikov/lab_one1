package ru.bstu.iitus.vt41.gibkinyuriy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        int count;//количество человек
        String Name;//имя и фамилия человека
        Scanner in = new Scanner(System.in);
        System.out.println("Input Count member:");
        count = in.nextInt();//ввод членов Person
        Person[] pr = new Person[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Input Name and Surname:");
            Name = in.nextLine();
            Name = in.nextLine();//ввод фам имя
            System.out.println("Input age:");
            int age = in.nextInt();//ввод возраста
            System.out.println("Input type:");
            System.out.println("1-teacher, 2-manager, 3-schoolkid, 4-student");
            int type = in.nextInt();//ввод типа
            switch (type) {
                case 1: {
                    pr[i] = new Teacher(age);
                    pr[i].Name = Name;
                    pr[i].init(in);
                    break;
                }
                case 2: {
                    pr[i] = new Manager(age);
                    pr[i].Name = Name;
                    pr[i].init(in);
                    break;
                }
                case 3: {
                    pr[i] = new Schoolkid(age);
                    pr[i].Name = Name;
                    pr[i].init(in);
                    break;
                }
                case 4: {
                    pr[i] = new Student(age);
                    pr[i].Name = Name;
                    pr[i].init(in);
                    break;
                }
                default:
                    break;
            }
        }
        int minAge = pr[0].getAge();//принимаем нач мин возраст
        int id = 0;
        for (int i = 1; i < count; i++)//находим мин возраст и запоминаем номер этого члена
            if (minAge > pr[i].getAge()) {
                minAge = pr[i].getAge();
                id = i;
            }
        System.out.println(pr[id].toString());
    }
}
