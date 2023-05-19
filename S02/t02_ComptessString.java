package S02;

import java.util.Scanner;

public class t02_ComptessString {
    public static final String TASK = """
        2023/05/14
        Семинар 2. Задача №2

        Напишите метод, который сжимает строку. 
        Пример: aaaabbbcdd → a4b3cd2

        """;

    public static void main(String[] args) {
        printResults(TASK,"");
        String string = inputStringMinXSymbolsFromConsole("Введите строку",1);

        printResults("Результат",
            compressString(string));
        
    }

    public static String compressString(String origin){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < origin.length(); i++) {
            char currentChar = origin.charAt(i);
            int count = 1;

            for (int j = i + 1; j < origin.length(); j++) {
                if(currentChar == origin.charAt(j)) count++;
                else break;
            }
            i += count -1; // переставляем указатель на символ последний который мы проверили.
            result.append(currentChar);
            if(count > 1) result.append(count);
        }
        return result.toString();
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
