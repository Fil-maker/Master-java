package lr2;

public class Example9 {
    public static void main(String[] args) {
        // Создание объектов подклассов
        Circle1 circle = new Circle1(5.0);
        Square1 square = new Square1(4.0);
        Triangle1 triangle = new Triangle1(3.0, 4.0, 5.0);

        // Вывод информации о фигурах (использует toString из Shape)
        System.out.println("Информация о геометрических фигурах:");
        System.out.println(circle);
        System.out.println(square);
        System.out.println(triangle);

        // Дополнительно: вызов уникальных методов
        System.out.println("\nДетальная информация:");
        System.out.printf("Круг: радиус = %.2f%n", circle.getRadius());
        System.out.printf("Квадрат: сторона = %.2f%n", square.getSide());
        System.out.printf("Треугольник: стороны = %.2f, %.2f, %.2f%n",
                triangle.getSideA(), triangle.getSideB(), triangle.getSideC());
    }
}

// Абстрактный базовый класс Shape
abstract class Shape1 {
    // Абстрактные методы для вычисления площади и периметра
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": площадь=" + getArea() + ", периметр=" + getPerimeter();
    }
}

// Подкласс Circle (круг)
class Circle1 extends Shape1 {
    private double radius;

    public Circle1(double radius) {
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

    // Уникальный метод для получения радиуса
    public double getRadius() {
        return radius;
    }
}

// Подкласс Square (квадрат)
class Square1 extends Shape1 {
    private double side;

    public Square1(double side) {
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

    public double getSide() {
        return side;
    }
}

// Подкласс Triangle (треугольник)
class Triangle1 extends Shape1 {
    private double a, b, c; // стороны

    public Triangle1(double a, double b, double c) {
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

    // Уникальные методы для получения сторон
    public double getSideA() { return a; }
    public double getSideB() { return b; }
    public double getSideC() { return c; }
}
