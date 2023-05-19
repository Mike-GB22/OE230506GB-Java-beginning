package S02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class t05_ReadDir {
    
    public static final String TASK = """
        2023/05/14
        Семинар 2. Задача №5

        * Напишите метод, который вернет содержимое текущей папки в виде массива строк. 
        * Напишите метод, который запишет массив, возвращенный предыдущим методом в файл. 
        * Обработайте ошибки с помощью try-catch конструкции. В случае возникновения исключения, оно должно записаться в лог-файл.
        """;

    public static void main(String[] args) {
        printResults(TASK,"");
        
        String pathName = "c:\\!temp\\";
        StringBuilder result = new StringBuilder();

        File[] files = new File(pathName).listFiles();
        for (File file : files) {
            result.append("ext: ");
                       
            result.append(getExtOfFileName(file));

            result.append(" - ");
            result.append(file);
            result.append(", size: ");
            result.append(file.length());
            result.append("\n");
        }
        printResults("Результат", result.toString());


       
        String fileName = "c:\\!temp\\20230514_s02_t05.txt";
        String resultWriteToFile = "Запись в файл НЕ произведена";
        if(writeToNewFile(fileName, result.toString()) == true) 
            resultWriteToFile = "Запись в файл произведена успешно!";
        
        printResults("Результат записи в файл " + fileName, resultWriteToFile);
        
    }

    //Извлекаем расширение из объекта Файл
    public static String getExtOfFileName (File file){
        String fileName = file.getName();
        int index = fileName.lastIndexOf(".");
            if(index <0) return "";
        return fileName.substring(index +1);
        // file.length() размер файла
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

