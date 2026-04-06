package lr2;

public class Example4 {
    // Пример использования класса
    public static void main(String[] args) {
        // Создание объекта с помощью конструктора
        Person person1 = new Person("Анна", 25, "женский");
        System.out.println(person1);

        // Изменение полей через сеттеры
        person1.setAge(26);
        person1.setName("Анна Петрова");
        System.out.println("После изменений: " + person1);

        // Получение значений через геттеры
        System.out.println("Имя: " + person1.getName());
        System.out.println("Возраст: " + person1.getAge());
        System.out.println("Пол: " + person1.getGender());
    }
}

class Person {
    // Поля класса
    private String name;
    private int age;
    private String gender; // можно использовать char ('M'/'F') или boolean, но String универсальнее

    // Конструктор с параметрами
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Геттеры и сеттеры для каждого поля
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Необязательный метод для вывода информации об объекте
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}