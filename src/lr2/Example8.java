package lr2;

public class Example8 {
    public static void main(String[] args) {
        // Создание объектов подклассов
        Dog dog = new Dog("Бобик", 3, "Такса");
        Cat cat = new Cat("Мурка", 2, "Сиамская");
        Bird bird = new Bird("Кеша", 1, true, "зерно");

        // Вывод информации и звуков
        System.out.println("Информация о животных:");
        System.out.println(dog);
        dog.makeSound();

        System.out.println(cat);
        cat.makeSound();

        System.out.println(bird);
        bird.makeSound();

        // Дополнительно: вызов уникальных методов
        System.out.println("Порода собаки: " + dog.getBreed());
        System.out.println("Птица умеет летать? " + (bird.canFly() ? "да" : "нет"));
        System.out.println("Тип корма птицы: " + bird.getFoodType());
    }
}

// Базовый класс Animal
abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Абстрактный метод издания звука
    public abstract void makeSound();

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": имя=" + name + ", возраст=" + age;
    }
}

// Подкласс Dog
class Dog extends Animal {
    private String breed; // порода

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Гав-гав!");
    }

    @Override
    public String toString() {
        return super.toString() + ", порода=" + breed;
    }
}

// Подкласс Cat
class Cat extends Animal {
    private String breed;

    public Cat(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Мяу-мяу!");
    }

    @Override
    public String toString() {
        return super.toString() + ", порода=" + breed;
    }
}

// Подкласс Bird
class Bird extends Animal {
    private boolean canFly; // способность летать
    private String foodType; // тип корма (например, зерно, насекомые)

    public Bird(String name, int age, boolean canFly, String foodType) {
        super(name, age);
        this.canFly = canFly;
        this.foodType = foodType;
    }

    public boolean canFly() {
        return canFly;
    }

    public String getFoodType() {
        return foodType;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Чирик-чирик!");
    }

    @Override
    public String toString() {
        return super.toString() + ", умеет летать=" + (canFly ? "да" : "нет") + ", тип корма=" + foodType;
    }
}
