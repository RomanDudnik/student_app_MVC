package controller.interfaces;

import model.domain.Student;

import java.util.List;

/**
 * Интерфейс для получения модели
 * Определяем архитектурные границы
 */
public interface iGetModel {
    public List<Student> getStudents();

    public void deleteStudent(int i);

    public void addStudent(Student student);
}
