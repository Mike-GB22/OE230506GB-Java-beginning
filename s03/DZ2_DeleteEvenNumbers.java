package S03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DZ2_DeleteEvenNumbers {
    public static final String TASK = """
        2023/05/20 mip
        Семинар 3. Домашняя Задача №2
    
        Пусть дан произвольный список целых чисел, удалить из него чётные числа
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

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }

        System.out.println("\nУдалили все честные числа:");
        System.out.println(list);
    }
}
