package S06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class t01_Random1000Numbers {
    public static final String TASK = """
            2023/05/19
            Семинар 6. Задача №1

            1. Напишите метод, который заполнит массив из 1000 элементов случайными числами от 0 до 24.
            2. Создайте метод, в который передайте заполненный выше массив, и с помощью Set вычислите процент уникальных значений в данном массиве, и верните его в виде числа с плавающей запятой.
            Для вычисления процента используйте формулу:
            процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве.
            """;

    public static void main(String[] args) {

        int numbers = 1000;
        int[] arr = fillArrayRandom(numbers);

        System.out.println(Arrays.toString(arr));
        System.out.println(findRationUnique(arr, numbers) + "%");

    }

    private static int[] fillArrayRandom(int numbers) {
        int[] array = new int[numbers];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(0, 25);
        }

        return array;
    }

    private static double findRationUnique(int[] arr, int max) {
        Set<Integer> set = new HashSet<>();
        for (int integer : arr) {
            set.add(integer);
        }

        int size = set.size();
        return (100.0 * size) / max;
    }
}
