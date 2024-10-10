package model.domain;

/**
 * Класс студент
 * Имплементирует интерфейс Comparable
 * Для сортировки студентов
 */
public class Student extends Person implements Comparable<Student> {

    /**
     * Поля
     */
    // Поле идентификатора
    private int id;
    // Статическое поле присваивания идентификатора
    static int generalId;

    /**
     * Конструктор
     * @param name
     * @param age
     */
    public Student(String name, int age) {
        super(name, age);
        this.id = generalId;
        generalId++;
    }

    /**
     * Геттеры и сеттеры
     * @return
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Переопределение метода toString
     * @return
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}' + super.toString();
    }

    /**
     * Переопределение метода compareTo
     * Для сортировки
     * по возрасту и идентификатору
     * @param o
     * @return
     */
    @Override
    public int compareTo(Student o) {
//        // Вывод работы метода (лог в консоль)
//        System.out.println(super.getName() + " - " + o.getName());

        // Сортировка по возрасту
        if (o.getAge() > super.getAge()) {
            return -1;
        }

        if (o.getAge() < super.getAge()) {
            return 1;
        }
        // Сортировка по идентификатору
        return Integer.compare(id, o.getId());

    }
}
