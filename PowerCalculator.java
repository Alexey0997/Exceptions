import java.util.InputMismatchException;
import java.util.Scanner;

/*
Задача1. Напишите программу-калькулятор, которая запрашивает у пользователя два числа и выполняет операцию
возведения первого числа в степень второго числа. Если введены некорректные числа или происходит деление на ноль,
необходимо обработать соответствующие исключения и вывести информативное сообщение об ошибке.
*/
public class PowerCalculator {
    public static void main(String[] args) {
        double degreeBasis;
        double degreeIndicator;
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {                                                                   // Ввод основания степени.
                try {
                    System.out.print("Введите основание степени: ");
                    degreeBasis = scanner.nextDouble();
                    calculatePower(degreeBasis, 1);
                    break;
                } catch (InvalidInputException e) {
                    System.out.println("Ошибка: " + e.getMessage() + "\n");
                    scanner.nextLine();
                } catch (InputMismatchException ex) {
                    System.out.println("Ошибка: введенные данные не являются цифрой.\n");
                    scanner.nextLine();
                }
            }

            while (true) {                                                                   // Ввод показателя степени.
                try {
                    System.out.print("Введите показатель степени: ");
                    degreeIndicator = scanner.nextInt();
                    calculatePower(1, degreeIndicator);
                    break;
                } catch (InvalidInputException e) {
                    System.out.println("Ошибка: " + e.getMessage() + "\n");
                    scanner.nextLine();
                } catch (InputMismatchException ex) {
                    System.out.println("Ошибка: введенные данные не являются цифрой.\n");
                    scanner.nextLine();
                }
            }
            System.out.printf("Решение: %s ** %s = %s", degreeBasis, degreeIndicator,        // Вывод результата.
                    String.format("%.2f", calculatePower(degreeBasis, degreeIndicator)));
        } catch (Exception ex) {
            System.out.println("Ошибка.\n");
            scanner.nextLine();
        } finally {
            scanner.close();                                                                 // Закрытие сканера.
        }
    }

    /**
     * calculatePower - функция, осуществляющая провекру ввода основания и показателя степени.
     *
     * @param a - основание степени.
     * @param b - показатель степени.
     * @return - возврат числа "а" в степени "b".
     * @throws InvalidInputException - исключение, сообщающее о некорректном вводе данных.
     */
    public static double calculatePower(double a, double b) throws InvalidInputException {
        if (a == 0) {
            throw new InvalidInputException("введено некорректное основание (ноль).");
        }
        if (b < 0) {
            throw new InvalidInputException("введен некорректный показатель (отрицательная степень).");
        }
        return Math.pow(a, b);
    }
}

/**
 * InvalidInputException - конструктор, наследующий класс Exception и имеющий метод вывода сообщения на консоль.
 */
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
