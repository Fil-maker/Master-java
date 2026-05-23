package lr7;

import java.io.*;

class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String name;
    private final int age;
    private final transient String password;

    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + ", password='" + password + '\'' + '}';
    }
}

public class Task8 {
    public static void main(String[] args) {
        Person person = new Person("Владимир Александров", 28, "pass1234");
        System.out.println("Объект до сериализации: " + person);

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("person.dat"))) {
            oos.writeObject(person);
            System.out.println("Объект записан в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("person.dat"))) {
            Person restoredPerson = (Person) ois.readObject();
            System.out.println("Объект восстановлен из файла: " + restoredPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
