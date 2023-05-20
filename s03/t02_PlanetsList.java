package S03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class t02_PlanetsList {
    public static final String TASK = """
        2023/05/20
        Семинар 3. Задача №2
        Задание состоит из двух блоков

        Задание №2.1
        Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями. 
        Вывести название каждой планеты и количество его повторений в списке.

        Задание №2.2 (если выполнено первое задание)
        Пройти по списку из предыдущего задания и удалить повторяющиеся элементы.
        """;
    
    
    public static void main(String[] args) {
        System.out.println(TASK);

        List<String> planets = new ArrayList<>();
        planets.add("Меркурий");
        planets.add("Венера");
        planets.add("Земля");        
        planets.add("Марс");
        planets.add("Юпитер");
        planets.add("Сатурн");
        planets.add("Уран");
        planets.add("Нептун");
        planets.add("Земля");                         
        planets.add("Марс");        
        planets.add("Меркурий");
        planets.add("Венера");
        planets.add("Земля");        
        planets.add("Марс");
        planets.add("Юпитер");
        planets.add("Сатурн");
        planets.add("Уран");
        planets.add("Нептун");
        planets.add("Земля");                         
        planets.add("Марс");        

        System.out.println("Список планет:");
        System.out.println(planets);

        System.out.println("\nСписок повторений планет:");
        System.out.println(countRepeats(planets));

        System.out.println("\nВ ручную почистили список:");
        System.out.println(deleteRepeats(planets));

    }    

    //Считаем количество повторов, через Мапу
    public static Map<String, Integer> countRepeats(List<String> list){
        Map<String, Integer> map = new HashMap<>();
        for (String key : list) {
            if(!map.containsKey(key)) map.put(key, 1);
            else {
                int value = map.get(key);
                map.put(key, ++value);
            }
        }
        return map;
    }

    //Идем по списку в перед, ищем повторы тоже в переди.
    public static List<String> deleteRepeats(List<String> listOrigin){
        List<String> list = new ArrayList<>(listOrigin);
        for (int i = 0; i < list.size(); i++) {
            String origin = list.get(i);
            for (int j = i + 1; j < list.size(); j++){
                if (origin.equals(list.get(j))){
                    list.remove(j);
                    j--;
                }
            }
        }
        return list;
    }
}
