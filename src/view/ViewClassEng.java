package view;

import model.domain.Student;

import java.util.List;
import java.util.Scanner;

public class ViewClassEng extends ViewClass {
    @Override
    public void printAllStudents(List<Student> students) {
        System.out.println("-------------------------------");
        System.out.println("List of students:");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("-------------------------------");
    }

    @Override
    public String prompt(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter " + msg + ":");
        return in.nextLine();
    }
}
