import controller.ControllerClass;
import controller.interfaces.iGetModel;
import controller.interfaces.iGetView;
import model.ModelClassFile;
import model.domain.Student;
import model.ModelClass;
import view.ViewClass;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // Создание студентов
        Student student1 = new Student("Ivan", 19);
        Student student2 = new Student("Sergey", 20);
        Student student3 = new Student("Petr", 19);
        Student student4 = new Student("Lena", 25);
        Student student5 = new Student("Alina", 19);
        Student student6 = new Student("Alex", 20);
        Student student7 = new Student("Vova", 19);
        Student student8 = new Student("Sveta", 25);
        Student student9 = new Student("Dima", 19);
        Student student10 = new Student("Masha", 20);

        // Создание списка студентов
        List<Student> listStudents = new ArrayList<>();

        // Добавление студентов в список
        listStudents.add(student1);
        listStudents.add(student2);
        listStudents.add(student3);
        listStudents.add(student4);
        listStudents.add(student5);
        listStudents.add(student6);
        listStudents.add(student7);
        listStudents.add(student8);
        listStudents.add(student9);
        listStudents.add(student10);

        // Создание модели(#1) и заполнение её данными
        iGetModel model = new ModelClass(listStudents);

        // Создание представления
        iGetView view = new ViewClass();

        // Создание модели(#2) и заполнение её данными из файла
        iGetModel fileModel = new ModelClassFile("StudentDB.csv");

        // Создание контроллера и передача ему модели и представления
        ControllerClass controller = new ControllerClass(fileModel, view);

//        // Запуск логики
//        controller.update("Запрос от клиента");

        // Запуск программы в итеративном режиме консоли
        controller.run();

    }
}