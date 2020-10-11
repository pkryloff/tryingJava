package ru.hse.edu.sc.y2020.Students;

import java.util.ArrayList;
import java.util.Objects;

public class Student {
    private final String name;
    private final String surname;
    private ArrayList<Integer> marksList;

    public String getSurname() {
        return surname;
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        marksList = new ArrayList<>();
    }

    public void addMark(int mark) {
        marksList.add(mark);
    }

    @Override
    public String toString() {
        StringBuilder studentInfo = new StringBuilder(String.format("Фамилия: " + surname + "; Имя: " + name));
        if (!marksList.isEmpty())
            studentInfo.append("; Оценки: ");
        for (int i = 0; i < marksList.size(); i++) {
            studentInfo.append(marksList.get(i));
            studentInfo.append(" ");
        }

        return studentInfo.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(marksList, student.marksList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, marksList);
    }
}
