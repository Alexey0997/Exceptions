import java.util.InputMismatchException;
import java.util.Scanner;

/*
Задача 2:
Напишите программу, которая запрашивает у пользователя два числа и выполняет их деление.
Если второе число равно нулю, программа должна выбрасывать исключение DivisionByZeroException
с сообщением "Деление на ноль недопустимо".
В противном случае, программа должна выводить результат деления.
 */
public class Seminar_2_Hmw_Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            double divisible;
            double divider;
            while (true) {
                try {
                    System.out.print("Введите делимое: ");
                    divisible = scanner.nextDouble();
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Ошибка: введенные данные не являются цифрой.\n");
                    scanner.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.print("Введите делитель: ");
                    divider = scanner.nextInt();
                    checkInput(divider);
                    break;
                } catch (DivisionByZeroException ex) {
                    System.out.println("Ошибка: " + ex.getMessage() + "\n");
                    scanner.nextLine();
                } catch (InputMismatchException ex){
                    System.out.println("Ошибка: введенные данные не являются цифрой.\n");
                    scanner.nextLine();
                }
            }
            System.out.printf("Решение: %s / %s = %s", divisible, divider, String.format("%.2f", divisible / divider));
        } catch (Exception ex) {
            System.out.println("Ошибка.\n");
            scanner.nextLine();
        }
    }


    /**
     * checkInput - метод объявляет, что может выкинуть исключение типа DivisionByZeroException.
     * Внутри метода происходит проверка значения value. Если оно равно нулю,
     * то выбрасывается исключение.
     *
     * @param value - проверяемое значение.
     * @throws DivisionByZeroException - новый объект-исключение.
     */
    public static void checkInput(double value) throws DivisionByZeroException {
        if (value == 0) {
            throw new DivisionByZeroException("деление на ноль недопустимо.");
        }
    }
}

/**
 * InvalidNumberException - конструктор, который наследуется от класса Exception.
 * Имеет один метод для вывода сообщений на консоль.
 */
class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}
