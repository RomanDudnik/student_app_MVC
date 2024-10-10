package view;

import controller.interfaces.iGetView;
import model.domain.Student;

import java.util.List;

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
}
