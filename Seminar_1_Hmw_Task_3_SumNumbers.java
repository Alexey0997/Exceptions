import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
Сложная задача: Чтение файла и подсчет суммы чисел
Напишите программу, которая считывает содержимое текстового файла, в котором каждая строка содержит одно число.
Программа должна подсчитать сумму всех чисел в файле.
Если встретится строка, которая не может быть преобразована в число, выбросите исключение NumberFormatException
с сообщением "Некорректное значение числа в файле".
 */
public class Seminar_1_Hmw_Task_3_SumNumbers {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            String line;
            int numbersSum = 0;
            try {
                while ((line = br.readLine()) != null) {
                    try {
                        numbersSum += Integer.parseInt(line);
                    } catch (NumberFormatException ex) {
                        System.out.println("Некорректное значение числа в файле.");
                    }
                } System.out.println("Сумма чисел: " + numbersSum);
            } catch (IOException ex) {
                System.out.println("Ошибка чтения файла.");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден.");
        }
    }
}

