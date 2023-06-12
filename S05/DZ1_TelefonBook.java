package S05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DZ1_TelefonBook {
    public static final String TASK = """
            2023/06/11 mip
            Семинар 5. Домашняя Задача №1

            Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
            """;
  

    public static void main(String[] args) {
        System.out.println(TASK);

        Map<String, List<String>> telefonDictionary = new HashMap<>();
        
        telefonDictionary.put("Ivanov", new ArrayList<String>());
        telefonDictionary.get("Ivanov").addAll(Arrays.asList("+7 123 4567333", "+7 0123 1234567"));


        telefonDictionary.put("Petrov", new ArrayList<String>(Arrays.asList("+0 123 4567890")));
        telefonDictionary.put("Sidorov", new ArrayList<String>(Arrays.asList("+0 333 4567890", "+49 333 44477755")));
                        
        System.out.println(telefonDictionary);

        System.out.println("\n-------------------------------------");
        System.out.print ("Введите фамилию, для запроса: ");
        Scanner scanner = new Scanner(System.in);
        String query = scanner.nextLine();

        System.out.println("\nОтвет на запрос: [ "+ query +" ]");
        List <String> weFoundThis = telefonDictionary.get(query.trim());
        if(weFoundThis == null) System.out.println("Фамилия не найденна");
        else {
            System.out.println(weFoundThis);
        }
    }
}
