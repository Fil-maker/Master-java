package lr2;

public class Example5 {
    // Пример использования класса
    public static void main(String[] args) {
        // Создание объекта прямоугольника
        Rectangle rect = new Rectangle(5.0, 3.0);
        System.out.println(rect);

        // Вывод площади и периметра
        System.out.printf("Площадь: %.2f%n", rect.getArea());
        System.out.printf("Периметр: %.2f%n", rect.getPerimeter());

        // Изменение размеров через сеттеры
        rect.setLength(7.5);
        rect.setWidth(4.2);
        System.out.println("После изменения размеров:");
        System.out.println(rect);
        System.out.printf("Площадь: %.2f%n", rect.getArea());
        System.out.printf("Периметр: %.2f%n", rect.getPerimeter());
    }
}
class Rectangle {
    // Поля класса для длины и ширины
    private double length;
    private double width;

    // Конструктор с параметрами
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Геттеры и сеттеры
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // Метод для вычисления площади
    public double getArea() {
        return length * width;
    }

    // Метод для вычисления периметра
    public double getPerimeter() {
        return 2 * (length + width);
    }

    // Метод для строкового представления объекта (необязательный)
    @Override
    public String toString() {
        return "Прямоугольник [длина=" + length + ", ширина=" + width + "]";
    }
}

