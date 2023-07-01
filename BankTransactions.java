import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

/*
Задача2. По желанию
Вы разрабатываете систему банковских транзакций. Необходимо написать программу, которая позволяет пользователям
осуществлять переводы средств со своего банковского счета на другие счета.
Однако, в системе существуют некоторые ограничения и возможные ошибки, которые нужно обрабатывать.
Требования:
При переводе средств, сумма должна быть положительной и не превышать доступный баланс на счете.
Если сумма перевода отрицательная или равна нулю, выбрасывается исключение
InvalidAmountException с сообщением "Некорректная сумма перевода".
Если на балансе недостаточно средств для перевода, выбрасывается исключение
InsufficientFundsException с сообщением "Недостаточно средств на счете".
При успешном переводе, сумма должна списываться с текущего счета и зачисляться на целевой счет.

 */
public class BankTransactions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scoreNumber1;
        int scoreNumber2;
        int transferAmount;
        LinkedList<Integer> myScore = new LinkedList<>();
        myScore.add(0, 100000);                                        // № счета, сумма.
        myScore.add(1, 10000);
        myScore.add(2, 200000);

        try {
            while (true) {                                                          // Проверка первого числа.
                try {
                    System.out.println("""
                            Уважаемый пользователь,
                            добро пожаловать в службу баноковских перводов!
                            \nВАШИ СЧЕТА:""");
                    for (int i = 0; i < myScore.size(); i++) {
                        System.out.println("№ " + i + " = " + myScore.get(i) + " рублей.");
                    }

                    System.out.print("\nВведите номер счета, с которого хотите Вы хотите перевести деньги: ");
                    scoreNumber1 = scanner.nextInt();
                    checkScoreNumber(scoreNumber1);
                    break;
                } catch (InvalidScoreNumberException ex1) {
                    System.out.println("Ошибка: " + ex1.getMessage() + "\n");
                    scanner.nextLine();
                } catch (InputMismatchException ex2) {
                    System.out.println("Ошибка: введенные данные не являются цифрой.\n");
                    scanner.nextLine();
                }
            }

            while (true) {                                                          // Проверка второго числа,
                try {                                                               // а также суммы двух первых чисел.
                    System.out.print("Введите номер счета, на который Вы хотите перевести деньги: ");
                    scoreNumber2 = scanner.nextInt();
                    checkScoreNumber(scoreNumber2);
                    break;
                } catch (InvalidScoreNumberException ex1) {
                    System.out.println("Ошибка: " + ex1.getMessage() + "\n");
                    scanner.nextLine();
                } catch (InputMismatchException ex2) {
                    System.out.println("Ошибка: введенные данные не являются цифрой.\n");
                    scanner.nextLine();
                }
            }
            while (true) {
                try {                                                              // Проверка третьего числа.
                    System.out.print("Введите сумму перевода > 0: ");
                    transferAmount = scanner.nextInt();
                    checkTransferNumber(transferAmount);
                    checkTransferAmount(myScore, scoreNumber1, transferAmount);
                    break;
                } catch (InvalidAmountException | InsufficientFundsException ex3) {
                    System.out.println("Ошибка: " + ex3.getMessage() + "\n");
                    scanner.nextLine();
                }
            }
            transfer(myScore, scoreNumber1, scoreNumber2, transferAmount);
        } catch (
                Exception ex4) {
            System.out.println("Ошибка.\n");
            scanner.nextLine();
        } finally {
            scanner.close();                                                                 // Закрытие сканера.
        }
    }

    /**
     * checkScoreNumber - функция, осуществляющая проверку правильности ввода номера счета.
     * @param scoreNumber1 - № счета, с которого нужно списать деньги.
     * @throws InvalidScoreNumberException - исключение, указывающее на ошибку ввода номера счета.
     */
    public static void checkScoreNumber(int scoreNumber1) throws InvalidScoreNumberException {
        if (scoreNumber1 < 0 || scoreNumber1 > 2) {
            throw new InvalidScoreNumberException("введен некорректный номер счета.");
        }
    }

    /**
     * checkTransferAmount - функция, проверяющая достаточность денежных средств на счету для осуществления перевода.
     * @param myScore - данные о счетах и находящихся на них денежных средствах.
     * @param scoreNumber1 - № счета, с которого планируется списание денежных средств.
     * @param transferAmount - сумма, подлежащая списанию.
     * @throws InsufficientFundsException - исключение, выдающее ошибку транзакции.
     */
    public static void checkTransferAmount(LinkedList<Integer> myScore, int scoreNumber1, int transferAmount)
            throws InsufficientFundsException {
        for (int i = 0; i < myScore.size(); i++) {
            if (i == scoreNumber1) {
                if (myScore.element() < transferAmount) {
                    throw new InsufficientFundsException("на счету недостаточно средств.");
                }
            }
        }
    }

    /**
     * transfer - функция, осуществляющая перевод средств с одного счета на другой.
     * @param myScore - перечень счетов и находящихся на них средств.
     * @param scoreNumber1 - номер счета, с которого планируется списание средств.
     * @param scoreNumber2 - номе счета, на который планируется зачисление средств.
     * @param transferAmount - сумма перевода.
     */

    public static void transfer(LinkedList<Integer> myScore, int scoreNumber1, int scoreNumber2, int transferAmount) {
        System.out.println("\nСовершена тразакция:\n" +
                "со счета № " + scoreNumber1 + " списано " + transferAmount +
                " рублей, которые зачислены на счет № " + scoreNumber2);
        System.out.println("\nСОСТОЯНИЕ ВАШИХ СЧЕТОВ:");
        for (int i = 0; i < myScore.size(); i++) {
            if (i == scoreNumber1) {
                myScore.set(i, myScore.get(i) - transferAmount);
            }
            if (i == scoreNumber2) {
                myScore.set(i, myScore.get(i) + transferAmount);
            }
            System.out.println("№ " + i + " = " + myScore.get(i) + " рублей.");
        }
    }

    /**
     * checkTransferNumber - функция, проверяющая правильность ввода суммы перевода.
     * @param transferAmount - сумма перевода.
     * @throws InvalidAmountException - исключение, уведомляющее об ошибке ввода данных.
     */

    public static void checkTransferNumber(int transferAmount) throws InvalidAmountException {
        if (transferAmount <= 0) {
            throw new InvalidAmountException("введите положительное число.");
        }
    }
}

class InvalidScoreNumberException extends Exception {            // Конструкторы, выводящие соответствующие сообщения.
    public InvalidScoreNumberException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
