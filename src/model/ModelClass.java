package model;

import controller.interfaces.iGetModel;
import model.domain.Student;

import java.util.List;

/**
 * Класс модели (источник данных) #1
 * Для хранения данных
 * Список студентов
 */
public class ModelClass implements iGetModel {
    /**
     * Поле для хранения списка студентов
     * Хранилище в виде списка
     */
    private List<Student> students;

    /**
     * Конструктор
     * Для инициализации (получение данных из вне)
     * @param students
     */
    public ModelClass(List<Student> students) {
        this.students = students;
    }

    /**
     * Метод для получения списка студентов
     * @return
     */
    public  List<Student> getStudents() {
        return students;
    }

    /**
     * Метод для удаления студента
     * по индексу
     * @param i
     */
    @Override
    public void deleteStudent(int i) {
        // Проход по списку студентов
        for (Student student : students) {
            // Если индекс совпадает
            if (student.getId() == i) {
                // Удаляем студента
                students.remove(student);
                // Выход из цикла
                // т.к. студент был удален
                break;
            }
        }
    }
}
