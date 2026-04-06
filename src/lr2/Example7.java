package lr2;

public class Example7 {
    public static void main(String[] args) {
        // Создание двух счетов
        BankAccount account1 = new BankAccount("123456", "Иван Петров", 1000.0);
        BankAccount account2 = new BankAccount("789012", "Мария Сидорова", 500.0);

        // Вывод информации о счетах
        System.out.println("Информация о счетах:");
        System.out.println(account1);
        System.out.println(account2);
        System.out.println();

        // Операции с первым счетом
        System.out.println("Операции по счету Ивана Петрова:");
        account1.deposit(250.0);
        account1.withdraw(100.0);
        account1.withdraw(2000.0); // попытка снять больше, чем есть
        System.out.println();

        // Операции со вторым счетом
        System.out.println("Операции по счету Марии Сидоровой:");
        account2.withdraw(50.0);
        account2.deposit(300.0);
        System.out.println();

        // Финальные балансы
        System.out.println("Итоговые балансы:");
        System.out.printf("Счет Ивана Петрова: %.2f%n", account1.getBalance());
        System.out.printf("Счет Марии Сидоровой: %.2f%n", account2.getBalance());
    }
}

// Интерфейс, определяющий методы для работы со счетом
interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

// Класс банковского счета, реализующий интерфейс
class BankAccount implements Account {
    private String accountNumber;
    private String ownerName;
    private double balance;

    // Конструктор для создания нового счета
    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        this.balance = initialBalance;
    }

    // Метод для пополнения счета
    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Ошибка: сумма депозита должна быть положительной");
            return;
        }
        balance += amount;
        System.out.printf("Счет %s пополнен на %.2f. Текущий баланс: %.2f%n", accountNumber, amount, balance);
    }

    // Метод для снятия денег
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Ошибка: сумма снятия должна быть положительной");
            return;
        }
        if (amount > balance) {
            System.out.printf("Ошибка: недостаточно средств на счете %s. Доступно: %.2f%n", accountNumber, balance);
            return;
        }
        balance -= amount;
        System.out.printf("Со счета %s снято %.2f. Текущий баланс: %.2f%n", accountNumber, amount, balance);
    }

    // Метод для получения текущего баланса
    @Override
    public double getBalance() {
        return balance;
    }

    // Дополнительные геттеры для информации о счете (не требуются интерфейсом)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        return String.format("Счет №%s, Владелец: %s, Баланс: %.2f", accountNumber, ownerName, balance);
    }
}
