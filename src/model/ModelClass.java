package model;

import model.domain.Student;

import java.util.List;

/**
 * Класс модели (источник данных)
 * Для хранения данных
 * Список студентов
 */
public class ModelClass {
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
}
