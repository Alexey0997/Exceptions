import java.util.InputMismatchException;
import java.util.Scanner;

/*
Задача3: - по желанию
Напишите программу, которая запрашивает у пользователя три числа и выполняет следующие проверки:
Если первое число больше 100, выбросить исключение NumberOutOfRangeException с сообщением
"Первое число вне допустимого диапазона".
Если второе число меньше 0, выбросить исключение NumberOutOfRangeException с сообщением
"Второе число вне допустимого диапазона".
Если сумма первого и второго чисел меньше 10, выбросить исключение NumberSumException с сообщением
"Сумма первого и второго чисел слишком мала".
Если третье число равно 0, выбросить исключение DivisionByZeroException с сообщением "Деление на ноль недопустимо".
В противном случае, программа должна выводить сообщение "Проверка пройдена успешно".
- необходимо создать 3 класса собвстенных исключений
 */
public class Seminar_2_Hmw_Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            double number1;
            double number2;
            double number3;
            while (true) {                                                          // Проверка первого числа.
                try {
                    System.out.print("Введите первое число N1 <= 100: ");
                    number1 = scanner.nextDouble();
                    checkInput(number1, 1);
                    break;
                } catch (NumberOutOfRangeException ex1) {
                    System.out.println("Ошибка: " + ex1.getMessage() + "\n");
                    scanner.nextLine();
                }
            }

            while (true) {                                                          // Проверка второго числа,
                try {                                                               // а также суммы двух первых чисел.
                    System.out.print("Введите второе число N2 > 0: ");
                    number2 = scanner.nextInt();
                    checkInput(1, number2);
                    checkSum(number1, number2);
                    break;
                } catch (NumberOutOfRangeException | NumberSumException ex2) {
                    System.out.println("Ошибка: " + ex2.getMessage() + "\n");
                    scanner.nextLine();
                }
            }

            while (true) {
                try {                                                              // Проверка третьего числа.
                    System.out.print("Введите третье число N3 != 0: ");
                    number3 = scanner.nextInt();
                    checkZero(number3);
                    break;
                } catch (DivisionByZeroException1 ex3 ) {
                    System.out.println("Ошибка: " + ex3.getMessage() + "\n");
                    scanner.nextLine();
                }
            }

            System.out.println("Проверка пройдена успешно.");                    // Информирование об успешно пройденной
        } catch (Exception ex) {                                                 // проверке.
            System.out.println("Ошибка.\n");
            scanner.nextLine();
        }
    }

    /**
     * checkInput - фунция, осуществляющая проверку первого и второго чисел.
     * @param number1 - первое число.
     * @param number2 - второе число.
     * @throws NumberOutOfRangeException - исключение, уведомляющее о выходе за пределы диапазона.
     */
    public static void checkInput(double number1, double number2) throws NumberOutOfRangeException {
        if (number1 > 100) {
            throw new NumberOutOfRangeException("первое число вне допустимого диапазона.");
        }
        if (number2 < 0) {
            throw new NumberOutOfRangeException("второе число вне допустимого диапазона.");
        }
    }

    /**
     * checkSum - функция, проверяющая соответствие суммы двух чисел минимальному значению.
     * @param number1 - первое число.
     * @param number2 - второе число.
     * @throws NumberSumException - исключение, уведомляющее о слишком малой сумме первых двух чисел.
     */
    public static void checkSum(double number1, double number2) throws NumberSumException {
        if (number1 + number2 < 10) {
            throw new NumberSumException("сумма первого и второго чисел слишком мала.");
        }
    }

    /**
     * checkZero - функция, осуществляющая проверку делителя на ноль.
     * @param number3 - проверяемое число.
     * @throws DivisionByZeroException1 - исключение, сообщающее, что деление на ноль недопустимо.
     */
    public static void checkZero(double number3) throws DivisionByZeroException1 {
        if (number3 == 0) {
            throw new DivisionByZeroException1 ("деление на ноль недопустимо.");
        }
    }
}

class NumberOutOfRangeException extends Exception {            // Конструкторы, выводящие соответствующие сообщения.
    public NumberOutOfRangeException(String message) {
        super(message);
    }
}
class NumberSumException extends Exception {
    public NumberSumException(String message) {
        super(message);
    }
}
class DivisionByZeroException1 extends Exception {
    public DivisionByZeroException1 (String message) {
        super(message);
    }
}