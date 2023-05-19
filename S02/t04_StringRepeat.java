package S02;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class t04_StringRepeat {
    
    public static final String TASK = """
        2023/05/14
        Семинар 2. Задача №4

        Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод,
        который запишет эту строку в простой текстовый файл, обработайте исключения.
        """;

    public static void main(String[] args) {
        printResults(TASK,"");
        String string = inputStringMinXSymbolsFromConsole("Введите строку",1);
        int count = inputIntFromConsoleInDiapason("Введите количество повторов строки", 1, 200);

        String result = string.repeat(count);
        printResults("Результат", result);

        String fileName = "c:\\!temp\\20230514_s02_t04.txt";
        String resultWriteToFile = "Запись в файл НЕ произведена";
        if(writeToNewFile(fileName, result) == true) 
            resultWriteToFile = "Запись в файл произведена успешно!";
        
        printResults("Результат записи в файл " + fileName, resultWriteToFile);
        
    }

    //Запись данных в новый файл
    public static boolean writeToNewFile(String fileName, String string){
        try (FileWriter writer = new FileWriter(fileName)){
            writer.append(string);
        } catch (IOException ex){
            System.out.println("Ошибка работы с файлом: " + fileName + "\n" + ex.getMessage());
            return false;
        }
        return true;
    }

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

