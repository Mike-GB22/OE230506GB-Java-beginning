package S05;

import java.util.HashMap;
import java.util.Map;

public class t01_Isomorfi {
    public static final String TASK = """
            2023/06/03 mip
            Семинар 5. Задача №1

            Даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными и false, если нет. Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву во втором слове, при этом
            повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением порядка следования. (Например, add - egg изоморфны)
            буква может не меняться, а остаться такой же. (Например, note - code)
            Пример 1:
            Input: s = "foo", t = "bar"
            Output: false
            Пример 2:
            Input: s = "paper", t = "title"
            Output: true
            """;
  

    public static void main(String[] args) {
        System.out.println(TASK);

        Map<String, String> listOfWords = new HashMap<>();
            listOfWords.put("paper", "title");
            listOfWords.put("paperi", "tirlei");            
            listOfWords.put("paperj", "rirlej");
            listOfWords.put("paperk", "titl");
            listOfWords.put("foo", "bar");            

        for (Map.Entry<String, String> pair : listOfWords.entrySet()) {

            String str1 = pair.getKey();
            String str2 = pair.getValue();
    
            System.out.printf("Является ли строка: %s изоморфом строки: %s?\nОтвет: %s.\n\n",
            str1, str2, isIsomorf(str1, str2) ? "да" : "нет");
    
        }
    }

    public static boolean isIsomorf(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        Map<Character, Character> dictionary = new HashMap<>();
        for (int i = 0; i < str1.length(); i++){
            char key = str1.charAt(i);
            char value = str2.charAt(i);
            if (!dictionary.containsKey(key)){
                dictionary.put(key, value);
            } else {
                if(dictionary.get(key) != value) return false;
            }
        }
        return true;
    }
    
}
