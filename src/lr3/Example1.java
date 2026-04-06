package lr3;


class Recursion {
    public static void m(int x) {
        System.out.println("x=" + x);
        if ((2 * x + 1) < 20) {
            m(2 * x + 1);
        }
    }
}
public class Example1 {
    public static void main(String[] args) {
        Recursion.m(1);
    }
}
