package model;

import controller.interfaces.iGetModel;
import model.domain.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс модели (источник данных) #2
 * Для хранения данных и сохранения их в файл
 * Список студентов
 */
public class ModelClassFile implements iGetModel {

    /**
     * Поле
     * Файл для сохранения
     */
    private String fileName;

    /**
     * Конструктор
     * Для создания файла
     * @param fileName
     */
    public ModelClassFile(String fileName) {
        this.fileName = fileName;
        // создаем пустой файл
        try (FileWriter fw = new FileWriter(fileName, true)) {
            // Закрытие потока
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Переопределение метода getStudents интерфейса iGetModel
     * Для получения списка студентов из файла
     * @return
     */
    @Override
    public List<Student> getStudents() {
        // Список студентов
        List<Student> students  = new ArrayList<Student>();
        try
        {
            // Чтение из файла
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            // Чтение построчно
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line!=null)
            {
                // Парсинг
                String[] param = line.split(" ");
                Student pars = new Student(param[0], Integer.parseInt(param[1]));
                students.add(pars);
                line = reader.readLine();
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return students;
    }

    /**
     * Метод для сохранения списка студентов в файл
     * @param students
     */
    public void saveAllStudentToFile(List<Student> students)
    {
        // Запись в файл
        try(FileWriter fw = new FileWriter(fileName, true))
        {
            // Запись построчно
            for(Student pars : students)
            {
                fw.write(pars.getName()+" "+pars.getAge()+" "+pars.getId());
                fw.append('\n');
            }
            // Закрытие потока
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
