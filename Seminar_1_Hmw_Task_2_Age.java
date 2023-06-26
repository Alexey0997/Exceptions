import java.util.Scanner;

/*
Простая задача 2: Обработка некорректного ввода
Напишите программу, которая запрашивает у пользователя его возраст.
Если введенное значение не является числом, выбросите исключение NumberFormatException с сообщением "Некорректный ввод".
Иначе выведите возраст на экран.

 */
public class Seminar_1_Hmw_Task_2_Age {
    public static void main(String[] args) {
        while (true) {
            Scanner aScanner = new Scanner(System.in);
            try {
                System.out.print("Введите ваш возраст (количество полных лет): ");
                String userInput = aScanner.nextLine();
                int age = Integer.parseInt(userInput);
                if (age >= 0) {
                    System.out.printf("Ваш возраст: %s", age);
                    break;
                } else {
                    System.out.println("Введите, пожалуйста, положительное число.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Некорректный ввод.");
            }
            System.out.println();
            aScanner.close();
        }
    }
}

