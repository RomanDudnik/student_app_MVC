package model;

import controller.interfaces.iGetModel;
import model.domain.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Класс модели (источник данных) #3
 * Для хранения данных и сохранения их в HashMap
 * Список студентов
 */
public class ModelClassHash implements iGetModel {
    /**
     * Поле для хранения списка студентов
     * Хранилище в виде HashMap
     */
    private HashMap<Integer, Student> students;

    /**
     * Конструктор
     * Для инициализации (получение данных из вне)
     */
    public ModelClassHash() {
        this.students = new HashMap<>();
    }

    /**
     * Метод для добавления студента в хранилище
     * @param student
     */
    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    /**
     * Метод для получения списка студентов
     * @return
     */
    @Override
    public List<Student> getStudents() {
        return new ArrayList<>(students.values());
    }

    /**
     * Метод для удаления студента
     * по ID
     * @param i
     */
    @Override
    public void deleteStudent(int i) {
        students.remove(i);
    }
}
