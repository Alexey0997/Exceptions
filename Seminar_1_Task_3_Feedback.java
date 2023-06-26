import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Seminar_1_Task_3_Feedback {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            int numbersSum = 0;
            while ((line = br.readLine()) != null) {
                try {
                    numbersSum += Integer.parseInt(line);
                } catch (NumberFormatException ex) {
                    System.out.println("Некорректное значение числа в файле: " + line);
                }
            }
            System.out.println("Сумма чисел: " + numbersSum);
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден.");
        } catch (IOException ex) {
            System.out.println("Ошибка чтения файла.");
        }
    }
}


