package S03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DZ3_ListsMinMaxAverage {
    public static final String TASK = """
        2023/05/20 mip
        Семинар 3. Домашняя Задача №3
    
        Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое этого списка.
        """;
    
    public static void main(String[] args) {
        System.out.println(TASK); 
             
        List<Integer> list = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 1000; i++){
            list.add(rnd.nextInt(1000));
        }

        System.out.println("У нас есть список чисел:");
        System.out.println(list);

        System.out.println("\nНайдем Мин, Макс и Среднее число:");
        int element0 = list.get(0);
        long summ = element0;
        int min = element0;
        int max = element0;
        int size = list.size();

        for (int i = 1; i < size; i++) {
            int current = list.get(i);
            if (current < min) min = current;
            if (current > max) max = current;
            summ += current;
        }
        double average = ((1.0*summ)/size);

        System.out.printf("Total elelemets: %d,\nMin: %d, Max: %d,\nAverage: %f, Summ: %d.",
                                size, min, max, average, summ);
    }
}
