package controller.interfaces;

import model.domain.Student;

import java.util.List;

/**
 * Интерфейс для получения представления
 * Определяем архитектурные границы
 */
public interface iGetView {
    public void printAllStudents(List<Student> students);
    public String prompt(String msg);
}
