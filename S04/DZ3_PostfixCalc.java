import java.text.ParseException;
import java.util.Scanner;
import java.util.Stack;

public class DZ3_PostfixCalc {
    public static final String TASK = """
            2023/05/28 mip
            Семинар 4. Домашняя Задача №3*

            * Напишите постфиксный калькулятор.
            Пользователь вводит данные и операции в обратной польской записи.
            Калькулятор вычисляет результат и проверяет, что в стэке получилось единственное число.
            Например:        5 4 3 − +       =>     5 1 +     =>      6
            """;

    private static Stack<Double> stackToCalc = new Stack<>();

    public static void main(String[] args) {
        System.out.println(TASK);

        System.out.println("Введите выражение в обратной польской записи, разделяя числа и знаки операций пробелами. Для выхода пустая строка или слово exit.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            stackToCalc.clear();
            System.out.print("Введите выражение:");
            String string = scanner.nextLine();
            if (string.toLowerCase().equals("exit") || string == null || string.length() == 0) break;

            String[] stringArray = string.split(" ");

            for (int i = 0; i < stringArray.length; i++) {
                String current = stringArray[i];
                try {
                    if (current.equals("+")) doPlus();
                    else if (current.equals("-")) doMinus();
                    else if (current.equals("*")) doMulti();
                    else if (current.equals("/")) doDevide();
                    else if (current.equals(":")) doDevide();

                    double number = Double.parseDouble(current);
                    stackToCalc.push(number);
                } catch (Exception e) {

                }
            }
            System.out.println("Ответ:  " + stackToCalc);
            if (stackToCalc.size() != 1)
                System.out.println("(если в ответов несколько, или ни одного, то скорее всего изначальное выражение было написанно с ошибкой)");
            System.out.println("");
        }
    }

    public static void doPlus() {
        double b = stackToCalc.pop();
        double a = stackToCalc.pop();
        stackToCalc.push(a + b);
    }

    public static void doMinus() {
        double b = stackToCalc.pop();
        double a = stackToCalc.pop();
        stackToCalc.push(a - b);
    }

    public static void doMulti() {
        double b = stackToCalc.pop();
        double a = stackToCalc.pop();
        stackToCalc.push(a * b);
    }

    public static void doDevide() {
        double b = stackToCalc.pop();
        double a = stackToCalc.pop();
        stackToCalc.push(a / b);
    }
}
