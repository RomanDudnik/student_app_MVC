package controller;

import controller.interfaces.iGetController;
import controller.interfaces.iGetModel;
import controller.interfaces.iGetView;
import model.domain.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс контроллера
 * Связь между моделью и представлением
 * Выполняет выстроенную логику
 */
public class ControllerClass implements iGetController {

    /**
     * Поля контроллера
     * Для связи между моделью и представлением
     * Через интерфейсы для разграничения моодулей (архитектурные границы)
     */
    private iGetModel model;
    private iGetView view;
    /**
     * Буфер для хранения списка студентов
     * Для возврата данных через контроллер
     * (для их последующей обработки и передачи в представление)
     */
    private List<Student> studentsBuffer = new ArrayList<>();

    /**
     * Конструктор
     * Для получения ссылок на модель и представление
     * @param model
     * @param view
     */
    public ControllerClass(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Метод для условного тестирования
     * Для модели MVP
     * @return
     */
    private boolean testData(List<Student> students) {
        if (students.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод запуска логики
     */
    public void update(String Request) {
//        // MVC (Model View Controller)
//        // Получение списка студентов на прямую из модели (источника данных)
//        view.printAllStudents(model.getStudents());

        // MVP (Model View Presenter)
        // Получение списка студентов через контроллер
        studentsBuffer = model.getStudents();
        // Тестирование до вызова представления
        if (testData(studentsBuffer)) {
            // Вывод списка студентов представлением
            view.printAllStudents(studentsBuffer);
        } else {
            System.out.println("Нет данных");
        }

    }

    /**
     * Метод для запуска программы в итеративном режиме консоли
     */
    public void run()
    {
        // Переменная для хранения команды
        Command com = (Command)Command.NONE;
        // Переменная для выхода из цикла
        boolean getNewIter = true;
        // Запуск цикла ввода команд
        while(getNewIter)
        {
            String command = view.prompt("Введите команду:");
            try {
                com = Command.valueOf(command.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: неверная команда. Доступные команды: EXIT, LIST, DELETE");
                continue;
            }
            switch(com)
            {
                case EXIT:
                    getNewIter = false;
                    System.out.println("Выход из программы");
                    break;
                case LIST:
                    view.printAllStudents(model.getStudents());
                    break;
                case DELETE:
                    System.out.println("введите номер студента для удаления:");
                    String input = view.prompt("");
                    try {
                        int id = Integer.parseInt(input);
                        if (model.getStudents().stream().anyMatch(s -> s.getId() == id)) {
                            model.deleteStudent(id);
                        } else {
                            System.out.println("Ошибка: студент не найден");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: неверный формат ввода");
                    }
                    break;
            }
        }
    }
}
