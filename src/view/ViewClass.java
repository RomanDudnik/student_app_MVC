package view;

import controller.interfaces.iGetView;
import model.domain.Student;

import java.util.List;
import java.util.Scanner;

/**
 * Класс для представления (отображения данных)
 */
public class ViewClass implements iGetView {

    /**
     * Метод для вывода списка студентов
     * @param students
     */
    public void printAllStudents(List<Student> students) {
        System.out.println("----------------------------------");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("----------------------------------");
    }

    /**
     * Метод запроса данных с консоли
     * @param msg
     * @return
     */
    public String prompt(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }

//    public void ViewRun()
//    {
//        contr.run();
//    }
}
