package S02;

import java.util.Scanner;

public class t03_IsStringPolindrom {
    
    public static final String TASK = """
        2023/05/14
        Семинар 2. Задача №3

        Напишите метод, который принимает на вход строку (String) и определяет
        является ли строка палиндромом (возвращает boolean значение).
        """;

    public static void main(String[] args) {
        printResults(TASK,"");
        String string = inputStringMinXSymbolsFromConsole("Введите строку",1);

        printResults("Результат",
            isStringPolindrom(string));
        
    }

    public static String isStringPolindrom(String origin){
        for (int i = 0; i < origin.length()/2; i++) {
            if(origin.charAt(i) != origin.charAt(origin.length()-i-1))
            return "Нет, строка не полиндром.";
        }
        return "Да, строка полиндром.";
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
