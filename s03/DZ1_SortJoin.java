package S03;

import java.util.Arrays;
import java.util.Random;

public class DZ1_SortJoin {
    public static final String TASK = """
        2023/05/20 mip
        Семинар 3. Домашняя Задача №1
    
        Реализовать алгоритм сортировки слиянием
        """;
    
    public static void main(String[] args) {
        System.out.println(TASK); 

        int[] array = new int[10];
        Random rnd = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = rnd.nextInt(10);
        }
        System.out.println("Иммем массив чисел:");
        System.out.println(Arrays.toString(array));


        System.out.println("\nЛогирование и изучение, как работает алгоритм:");
        int[] arraySorted = sortMerge(array);

        System.out.println("\nОтсортировали массив чисел, методом слияния:");
        System.out.println(Arrays.toString(arraySorted));
        
    }

    public static int[] sortMerge(int[] array){
        return  sortMerge(array, 0);
    }

    public static int[] sortMerge(int[] array, int deepth){
        int lengthAll = array.length;
        System.out.println(" ".repeat(deepth) + "- " + lengthAll + ":" + Arrays.toString(array));

        //Если массив меньше 2х элементов, значит это конец, возвращаем его как есть
        //Условие прекращение рекурсии
        if(lengthAll < 2) return array;

        int lengthPart1 = (lengthAll+1)/2;
        int lengthPart2 = lengthAll - lengthPart1;

        int[] part1 = new int[lengthPart1];
        int[] part2 = new int[lengthPart2];

        for(int i = 0; i < lengthPart1; i++){
            part1[i] = array[i];
        }
        part1 = sortMerge(part1, deepth + 1);        

        for(int i = 0; i < lengthPart2; i++){
            part2[i] = array[lengthPart1 + i];
        }
        part2 = sortMerge(part2, deepth + 1);

        int i = 0;
        int j = 0;
        int jMax = part1.length;
        int k = 0;
        int kMax = part2.length;
        while (j < jMax || k < kMax){
            if(j >= jMax) {
                array[i] = part2[k];
                k++;
            } else if (k >= kMax){
                array[i] = part1[j];
                j++;
            } else {
                if(part1[j] <= part2[k]){
                    array[i] = part1[j];
                    j++;
                } else { 
                    array[i] = part2[k];
                    k++;
                }
            }
            i++;
        }
        
        System.out.println(" ".repeat(deepth) + "= " + lengthAll + ":" + Arrays.toString(array));        
        return array;
    }
}
