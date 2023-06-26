import java.util.InputMismatchException;
import java.util.Scanner;

public class Seminar_1_Task_1_Feedback {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int divisible = 0;
            int divider = 0;
            while (true) {
                try {
                    System.out.print("Уважаемый пользователь,\nВведите делимое (целое число): ");
                    divisible = scanner.nextInt();
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Некорректный ввод. Введите, пожалуйста, целое число.");
                    scanner.nextLine(); // Очистить буфер ввода
                }
            }

            while (true) {
                try {
                    System.out.print("Введите делитель (целое число): ");
                    divider = scanner.nextInt();

                    if (divider == 0) {
                        System.out.println("Некорректный ввод. Деление на ноль недопустимо.");
                        continue;
                    }

                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Некорректный ввод. Введите, пожалуйста, целое число.");
                    scanner.nextLine(); // Очистить буфер ввода
                }
            }

            System.out.printf("Решение: %s / %s = %s", divisible, divider, divisible / divider);
        } catch (InputMismatchException ex) {
            System.out.println("Некорректный ввод. Введите, пожалуйста, целое число.");
        }
    }
}


