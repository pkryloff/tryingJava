package ru.hse.edu.sc.y2020.Students;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner input = new Scanner(System.in);
    static final String OPTIONS = "Введите номер нужного действия:\n" +
            "1. Просмотреть список студентов\n" +
            "2. Выбрать студента для ответа случайно\n" +
            "3. Выбрать студента для ответа по фамилии\n" +
            "4. Добавить студента в группу\n" +
            "5. Исключить студента из группы\n" +
            "6. Завершить выполнение программы";
    static final String CHOICE_ERROR_HINT = "Недоступная опция. Выберите один из предложенных вариантов.";

    final static ArrayList<Student> bpi199Students = new ArrayList<>() {{
        add(new Student("Павел", "Крылов"));
        add(new Student("Лев", "Поляков"));
        add(new Student("Екатерина", "Голикова"));
        add(new Student("Сардор", "Шарипов"));
        add(new Student("Софья", "Волкова"));
        add(new Student("Полина", "Точилина"));
        add(new Student("Егор", "Скрыпников"));
        add(new Student("Амина", "Ризоева"));
        add(new Student("Тигран", "Кочарян"));
        add(new Student("Дмитрий", "Кочик"));
        add(new Student("Диана", "Вахитова"));
    }};

    public static void showAllStudents(GroupOfStudents group){
        System.out.println(group.toString());
    }

    public static void askStudent(Student student){
        System.out.println("Отвечает студент " + student.getSurname());
        System.out.println("Введите оценку:");
        int mark = 0;
        if (input.hasNextInt())
            mark = input.nextInt();
        student.addMark(mark);
    }

    public static void chooseBySurname(GroupOfStudents group){
        System.out.println("Введите фамилию студента для поиска:");
        String surnameForSearch = input.next();
        ArrayList<Student> foundedStudents = group.selectStudentBySurname(surnameForSearch);

        if (foundedStudents.size() == 1) {
            askStudent(foundedStudents.get(0));
            return;
        }

        if (foundedStudents.size() > 1) {
            System.out.println("В группе есть несколько студентов с данной фамилией ");
            for (int i = 0; i < foundedStudents.size(); i++)
                System.out.printf("%d %s%n", i + 1, foundedStudents.get(i));
            System.out.println("Выберите нужного студента, введя его номер");
            int studentIndex = input.nextInt();
            if (studentIndex > 0 && studentIndex <= foundedStudents.size())
                askStudent(foundedStudents.get(studentIndex - 1));
            else
                System.out.println("Вы ввели что-то не то.");
            return;
        }

        System.out.println("Студент не найден.");
    }

    public static void addStudent(GroupOfStudents group){
        System.out.println("Введите фамилию:");
        String secondName = input.next();
        System.out.println("Введите имя:");
        String name = input.next();
        group.addStudent(new Student(name, secondName));

        System.out.println("Студент добавлен.");
    }

    public static void deleteStudent(GroupOfStudents group){
        System.out.println("Введите фамилию студента, которого нужно исключить:");
        String surnameForSearch = input.next();
        ArrayList<Student> foundedStudents = group.selectStudentBySurname(surnameForSearch);

        if (foundedStudents.size() == 1) {
            group.deleteStudent(foundedStudents.get(0));
            System.out.println("Студент исключен.");
            return;
        }

        if( foundedStudents.size() > 1) {
            System.out.println("В группе есть несколько студентов с данной фамилией ");
            for (int i = 0; i < foundedStudents.size(); i++)
                System.out.printf("%d %s%n", i + 1, foundedStudents.get(i));
            System.out.println("Выберите нужного студента, введя его номер");
            int studentIndex = input.nextInt();
            if (studentIndex > 0 && studentIndex <= foundedStudents.size()){
                group.deleteStudent(foundedStudents.get(0));
                System.out.println("Студент исключен.");
            }
            else
                System.out.println("Вы ввели что-то не то.");
            return;
        }

        System.out.println("Студент не найден.");
    }

    public static void main(String[] args) {
        GroupOfStudents group = new GroupOfStudents("БПИ199", bpi199Students);

        boolean exit = false;
        do {
            System.out.println(OPTIONS);
            String choice = input.next();
            switch (choice) {
                case "1":
                    showAllStudents(group);
                    break;
                case "2":
                    askStudent(group.selectRandomStudent());
                    break;
                case "3":
                    chooseBySurname(group);
                    break;
                case "4":
                    addStudent(group);
                    break;
                case "5":
                    deleteStudent(group);
                    break;
                case "6":
                    exit = true;
                    break;
                default:
                    System.out.println(CHOICE_ERROR_HINT);
                    break;
            }
        } while (!exit);
    }
}
