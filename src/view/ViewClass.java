package view;

import controller.interfaces.iGetController;
import controller.interfaces.iGetView;
import model.domain.Student;

import java.util.List;
import java.util.Scanner;

/**
 * Класс для представления (отображения данных)
 */
public class ViewClass implements iGetView {

    /**
     * Поле
     * Ссылка для связи между контроллером и представлением
     * Через интерфейс iGetController
     */
    private iGetController controller;

    /**
     * Сеттер для установки связи между контроллером и представлением
     * @param controller
     */
    public void setController(iGetController controller) {
        this.controller = controller;
    }

    /**
     * Метод для вывода списка студентов
     * @param students
     */
    public void printAllStudents(List<Student> students) {
        System.out.println("----------------------------------");
        System.out.println("Список студентов:");
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

    /**
     * Метод запуска представления
     */
    public void ViewRun() {
        controller.run();
    }
}
