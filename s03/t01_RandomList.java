package S03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class t01_RandomList {
    public static final String TASK = """
        2023/05/20
        Семинар 3. Задача №1
    
        Заполнить список десятью случайными числами.
        Отсортировать список методом sort() и вывести его на экран.
        """;
    
    
    public static void main(String[] args) {
        System.out.println(TASK);

        List<Integer> list = new ArrayList<>();
        Random rnd = new Random();

        for(int i = 0; i < 10; i++){
            list.add(rnd.nextInt(1000));
        }

        list.sort(null);
        System.out.println(list);
    }
}
