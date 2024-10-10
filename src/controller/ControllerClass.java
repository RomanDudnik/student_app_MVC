package controller;

import model.ModelClass;
import model.domain.Student;
import view.ViewClass;

import java.util.List;

/**
 * Класс контроллера
 * Связь между моделью и представлением
 * Выполняет выстроенную логику
 */
public class ControllerClass {

    /**
     * Поля контроллера
     * Для связи между моделью и представлением
     */
    private ModelClass model;
    private ViewClass view;

    /**
     * Конструктор
     * Для получения ссылок на модель и представление
     * @param model
     * @param view
     */
    public ControllerClass(ModelClass model, ViewClass view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Метод запуска логики
     */
    public void update() {
        //MVC
        view.printAllStudents(model.getStudents());

    }

}
