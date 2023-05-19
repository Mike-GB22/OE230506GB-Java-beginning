package S02;

import java.util.Scanner;

public class t01_StringFromC1andC2 {

    public static final String TASK = """
        2023/05/14
        Семинар 2. Задача №1

        Дано число N (>0) и символы c1 и c2. (убрал значение четное, пусть программа работает с любыми числами)
        Написать метод, который вернет строку длины N, которая состоит из чередующихся символов c1 и c2, начиная с c1.
        """;

    public static void main(String[] args) {
        printResults(TASK,"");
        int n = inputIntFromConsoleInDiapason(
                        "Введите число N", 1, 100);

        char c1 = inputStringMinXSymbolsFromConsole("Введите символ 1",1).charAt(0);
        char c2 = inputStringMinXSymbolsFromConsole("Введите символ 2",1).charAt(0);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(i%2 == 0) result.append(c1);
            else result.append(c2);
        }

        printResults("Результат", result.toString());
    }

    // ----------    Считываем из консоли одно значение
    //Cчитываем int число из консоли в диапазоне
    public static int inputIntFromConsoleInDiapason(String prompt, int min, int max){
        int result = Integer.MIN_VALUE;
        String attention = " [в диапазоне от "+ min +" до "+ max +"]";
        String attentionFlag = "";

        while (true){
            result = inputIntFromConsole(prompt+attentionFlag);
            if(result >= min && result <= max) return result;
            attentionFlag = attention;
        }
    }

    //Считываем int число из консоли
    public static int inputIntFromConsole(String prompt){
        return Integer.parseInt(inputStringFromConsole(prompt));
    }

    //Считываем double число из консоли
    public static double inputDoubleFromConsole(String prompt){
        return Double.parseDouble(inputStringFromConsole(prompt));
    }

    //Считываем строку из консоли, но хотя бы минимум X символ!
    public static String inputStringMinXSymbolsFromConsole(String prompt, int min){
        String attention = " [миниумм "+ min +" символов]";
        int count = 0;

        String string = "";
        while (string.length() < min){
            string = inputStringFromConsole(prompt);
            count ++;
            if(count == 1){prompt += attention;}
        }
        return string;
    }

    //Считываем строку из консоли
    public static String inputStringFromConsole(String prompt){
        System.out.print(prompt+": ");
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        //scan.close();

        return text;
    }   
    // ----------
    //Вывод результата
    public static void printResults(String task, String result){
        System.out.println("\n"+task+": ");
        System.out.println(result);
    }
    public static void printResults(String result){
        System.out.println(result);
    }

}
