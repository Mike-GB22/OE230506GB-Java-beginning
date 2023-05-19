package S02;

import java.io.BufferedReader;
import java.io.FileReader;

public class DZ1_ParsingTxtToSQL {
    public static final String TASK = """
        2023/05/14
        Семинар 2. Домашняя Задача №1
    
        В файле содержится строка с исходными данными в такой форме:
        {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
        
        Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
        SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
        
        Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.
        """;
    
    public static void main(String[] args) {
        printResults(TASK,"");
        
        String fileName = "S02\\DZ1_file2task.txt";
        String strings = readStringsFromFile(fileName);
        
        String[] stringsArray = parseStrings(strings);
        
        String ask = "SELECT * FROM students WHERE";
        //Обрабатываем строку из файла
        for (String string : stringsArray) {
            int beginIndex = string.indexOf("{");
            int endIndex = string.indexOf("}");

            if(beginIndex >= endIndex) continue;

            string = string.substring(beginIndex, endIndex);


            String prompt = "";
            //Тут у нас уже пары имя = значение
            for (String pair : parsePairsNameValue(string)) {
                String[] element = parseNameValue(pair);
                
                String name = element[0];
                String val = element[1];
                    if(val.equals("null") || val.equals("\"null\"")) continue;

                if (prompt.length() > 0) prompt += " AND";                    
                prompt += " " + name + " = "+val;
            }
            StringBuilder sql = new StringBuilder();
            sql.append(ask);
            sql.append(prompt);
            sql.append(";");
            System.out.println(sql);

        }
    }

    //Режим строку на подстроки, по знаку ","
    public static String[] parseNameValue(String string){
        String[] element = string.split(":");
        String name = element[0];
        int beginIndex = name.indexOf("\"");
        int endIndex = name.lastIndexOf("\"");
        
        if(beginIndex >= endIndex) name.trim();
        else name = name.substring(beginIndex+1,endIndex);

        element[0] = name;
        //System.out.println(element[0] + "=" + element[1]);
        return element;
    }

    //Режим строку на подстроки, по знаку ","
    public static String[] parsePairsNameValue(String string){
        return string.split(",");
    }

    //Режим поток строк из файла на массив строк
    public static String[] parseStrings(String strings){
        return strings.split("\n");
    }

    //Читаем Весь файл в строку
    public static String readStringsFromFile(String fileName){
        String strings = new String();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = reader.readLine()) != null){
                strings += line;
                strings += "\n";
            }
        } catch (Exception ex) {
            System.out.println("Вылетела какая то ошибка, при чтении файла: " + fileName);
            System.out.println(ex.getMessage());
        }
        return strings;
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
