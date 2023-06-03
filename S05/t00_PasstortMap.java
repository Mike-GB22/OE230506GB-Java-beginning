package S05;

import java.util.HashMap;
import java.util.Map;

public class t00_PasstortMap {
    public static final String TASK = """
            2023/06/03 mip
            Семинар 5. Задача №0

            Создать структуру для хранения Номеров паспортов и Фамилий сотрудников организации.
            123456 Иванов
            321456 Васильев
            234561 Петрова
            234432 Иванов
            654321 Петрова
            345678 Иванов
            Вывести данные по сотрудникам с фамилией Иванов.
            """;
  

    public static void main(String[] args) {
        System.out.println(TASK);

        String lastNameToFind = "Ivanov";
        Map<Integer, String> passportToLastName = new HashMap<>();
        passportToLastName.put(1234567,"Ivanov");
        passportToLastName.put(1234517,"Ivanov");
        passportToLastName.put(1234527,"Ivanova");
        passportToLastName.put(1234537,"Ivanova");
        passportToLastName.put(1234547,"Ivanova");
        passportToLastName.put(1234557,"Ivanovi");
        passportToLastName.put(1234577,"Ivanovi");
        passportToLastName.put(1234587,"Petrov");
        passportToLastName.put(2234517,"Ivanov");
                        
        System.out.println(passportToLastName);

        int count = 0;
        for(Map.Entry<Integer, String> pairNumberName : passportToLastName.entrySet()){
            if(pairNumberName.getValue().equals(lastNameToFind)){
                System.out.println(++count + ": " + pairNumberName);
            }
        }

    }
}
