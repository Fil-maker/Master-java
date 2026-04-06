package lr2;

public class Example6 {
    public static void main(String[] args) {
        // Создание объектов фигур
        Circle circle = new Circle(5.0);
        Square square = new Square(4.0);
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);

        // Вывод результатов
        System.out.println("Круг радиусом 5.0:");
        System.out.printf("Площадь: %.2f%n", circle.getArea());
        System.out.printf("Периметр (длина окружности): %.2f%n%n", circle.getPerimeter());

        System.out.println("Квадрат со стороной 4.0:");
        System.out.printf("Площадь: %.2f%n", square.getArea());
        System.out.printf("Периметр: %.2f%n%n", square.getPerimeter());

        System.out.println("Треугольник со сторонами 3.0, 4.0, 5.0:");
        System.out.printf("Площадь: %.2f%n", triangle.getArea());
        System.out.printf("Периметр: %.2f%n", triangle.getPerimeter());
    }
}

// Интерфейс, определяющий методы для вычисления площади и периметра
interface Shape {
    double getArea();
    double getPerimeter();

}

// Класс Круг
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом");
        }
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Класс Квадрат
class Square implements Shape {
    private double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона должна быть положительным числом");
        }
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }
}

// Класс Треугольник
class Triangle implements Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны должны быть положительными числами");
        }
        // Проверка неравенства треугольника
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2; // полупериметр
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }
}
