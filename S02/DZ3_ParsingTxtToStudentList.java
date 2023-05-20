package S02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DZ3_ParsingTxtToStudentList {
    public static final String TASK = """
            2023/05/19+20 mip
            Семинар 2. Домашняя Задача №3

            * Дана строка json:
            [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

            Написать метод, который распарсит этот текст и, используя StringBuilder, создаст строки вида:
            Студент [фамилия] получил [оценка] по предмету [предмет]. Например:
            Студент Иванов получил 5 по предмету Математика.
            Студент Петрова получил 4 по предмету Информатика.
            Студент Краснов получил 5 по предмету Физика.
            """;

    public static void main(String[] args) {
        printResults(TASK, "");

        String fileName = "S02\\DZ3_file2task.txt";
        String file = readStringsFromFile(fileName);

        //Для каждой записи формируем Мап, и ложим его в Сет.
        Set<Map<String, String>> set = new HashSet<>();
        for (String element : parseFile(file)) {
            Map<String, String> map = parseElement(element);
            set.add(map);
        }

        //Теперь обрабатываем каждый элемент сета, обрабатываем и выводим на экран
        // String prompt = String.format("Студент %s получил %d по предмету %s");
        for (Map<String,String> map : set) {
            String prompt = String.format(
                "Студент %s получил %s по предмету %s",
                map.get("фамилия"),map.get("оценка"), map.get("предмет")  
                );

            System.out.println(prompt);
        }
    }

    //Каждую запись разбираем на составные ключ=значение
    public static Map<String, String> parseElement(String element){
        Map<String, String> map = new HashMap<>();
            while(true){
                if(element.length() < 2) break;

                int coma = element.indexOf(",");
                if(coma < 0) coma = element.length();
                
                String keyValue = element.substring(0, coma);
                String[] keyValues = keyValue.split(":");

                String key = keyValues[0].replace("\"", "");
                String value = keyValues[1].replace("\"", "");

                map.put(key, value);

                if(element.length() <= coma) break;
                element = element.substring(coma + 1);
            }
        return map;
    }

    //Разбираем файл за написи
    public static ArrayList<String> parseFile(String file) {
        ArrayList<String> list = new ArrayList<>();

        while (true) {
            int beginIndex = file.indexOf("{");
            int endIndex = file.indexOf("}");
            if (beginIndex < 0 || endIndex < 0)
                break;
            if (endIndex < beginIndex) {
                file = file.substring(beginIndex);
                continue;
            }
            list.add(file.substring(beginIndex + 1, endIndex));
            file = file.substring(endIndex + 1);
        }
        return list;
    }

    // Вывод результата
    public static void printResults(String task, String result) {
        System.out.println("\n" + task + ": ");
        System.out.println(result);
    }

    public static void printResults(String result) {
        System.out.println(result);
    }

    // Читаем Весь файл в строку
    public static String readStringsFromFile(String fileName) {
        String strings = new String();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                strings += line;
                strings += "\n";
            }
        } catch (Exception ex) {
            System.out.println("Вылетела какая то ошибка, при чтении файла: " + fileName);
            System.out.println(ex.getMessage());
        }
        return strings;
    }

}
