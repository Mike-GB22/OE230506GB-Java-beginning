package S05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DZ2_CountName {
    public static final String TASK = """
            2023/06/11 mip
            Семинар 5. Домашняя Задача №2

            Пусть дан список сотрудников:
            Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
            Отсортировать по убыванию популярности.
            """;

    public static final String NAMES = """
            Иван Иванов
            Светлана Петрова
            Кристина Белова
            Анна Мусина
            Анна Крутова
            Иван Юрин
            Петр Лыков
            Павел Чернов
            Петр Чернышов
            Мария Федорова
            Марина Светлова
            Мария Савина
            Мария Рыкова
            Марина Лугова
            Анна Владимирова
            Иван Мечников
            Петр Петин
            Иван Ежов
            """;
  
    public static void main(String[] args) {
        System.out.println(TASK);

        HashMap<String, Integer> dictionary = new HashMap<>();

        Scanner scanner = new Scanner(NAMES);
        
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String name = line.split(" ", 2)[0].trim();
            
            Integer count;
            if((count = dictionary.get(name)) == null) dictionary.put(name, 1);
            else {
                dictionary.put(name, ++count);
            }
        }

        HashMap.Entry<String, Integer>[] entrySet = dictionary.entrySet().toArray(new HashMap.Entry[dictionary.size()]);
        
        System.out.println("------------------------------------ ");
        System.out.println("Служебная информация: ");
        System.out.println(Arrays.toString(entrySet));
        System.out.println("------------------------------------ ");

        Arrays.sort(entrySet, new DictionaryComporator());
        for (int i = 0; i < entrySet.length; i++){
            HashMap.Entry<String, Integer> entry = entrySet[i];
            System.out.println("Имя " + entry.getKey() + " встерчается " + entry.getValue() + " раз.");
        }
    }
}

class DictionaryComporator implements Comparator<HashMap.Entry<String, Integer>>{

    @Override
    public int compare(HashMap.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2) {
        int val1 = o1.getValue();
        int val2 = o2.getValue();
        if (val1 == val2) return 0;
        if (val1  > val2) return -1;
        return 1;
    }
}


