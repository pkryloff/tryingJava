package ru.hse.edu.sc.y2020.Students;

import java.util.ArrayList;
import java.util.Random;

public class GroupOfStudents {
    private final String groupName;
    private final ArrayList<Student> students;

    final Random random = new Random();

    public GroupOfStudents(String groupName, ArrayList<Student> students){
        this.groupName = groupName;
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(Student student) {
        if (students.contains(student))
            students.remove(student);
        else
            System.out.println("Такого студента в группе нет.");
    }

    public Student selectRandomStudent() {
        return students.get(random.nextInt(students.size()));
    }

    public ArrayList<Student> selectStudentBySurname(String surname){
        ArrayList<Student> founded = new ArrayList<Student>();
        for (Student s: students) {
            if (s.getSurname().toLowerCase().equals(surname.toLowerCase())) {
                founded.add(s);
            }
        }
        return founded;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder(String.format("Группа: " + groupName));

        if (!students.isEmpty())
            info.append("\n");

        for (int i = 0; i < students.size(); i++) {
            info.append(students.get(i));
            info.append("\n");
        }

        return info.toString();
    }
}
