package lr4;


public class Example12 {
    public static void m(String str, double chislo) {
        if (str == null) {
            System.out.println(1);
            throw new IllegalArgumentException("Строка введена неверно");
        }
        if (chislo > 0.001) {
            System.out.println(2);
            throw new IllegalArgumentException("Неверное число");
        }
    }

    public static void main(String[] args) {
        try {
            m(null, 0.000001);
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }

}
