/*
Простая задача 1: Проверка деления на ноль
Напишите программу, которая запрашивает у пользователя два целых числа и выполняет их деление.
Если второе число равно нулю, выбросите исключение ArithmeticException с сообщением
"Деление на ноль недопустимо".
Иначе выведите результат деления на экран.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Seminar_1_Hmw_Task_1_DivideByZero {
    public static void main(String[] args) {
        Scanner aScanner = new Scanner(System.in);
        try {
            System.out.print("Уважаемый пользователь,\nВведите делимое (целое число): ");
            int divisible = aScanner.nextInt();
            System.out.print("Введите делитель (целое число): ");
            int divider = aScanner.nextInt();
            System.out.printf("Решение: %s / %s = %s", divisible, divider, divisible / divider);
        } catch (InputMismatchException ex1) {
            System.out.println("Некорректный ввод. Введите, пожалуйста, целое число.");
        } catch (ArithmeticException ex2) {
            System.out.println("Некорректный ввод. Деление на ноль недопустимо.");
        }
        aScanner.close();
    }
}


