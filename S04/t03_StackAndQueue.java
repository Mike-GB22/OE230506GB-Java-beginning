import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.util.Arrays.*;

public class t03_StackAndQueue {
    public static final String TASK = """
            2023/05/29 mip
            Семинар 4. Задача №3

            1) Написать метод, который принимает массив элементов, помещает их в стэк и выводит содержимое стэка, доставая его содержимое по одному.
            2) Написать метод, который принимает массив элементов, помещает их в очередь и выводит на консоль содержимое очереди, доставая её содержимое по одному.\s
            """;

    public static void main(String[] args) {
        System.out.println(TASK);

        String[] string = new String[]{"1", "2", "3", "4", "5", "6", "7"};
        System.out.println("Имеем массив элементов: " + Arrays.toString(string));

        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < string.length; i++) {
            stack.push(string[i]);
            queue.add(string[i]);
        }

        System.out.println("Извлекаем данные по очереди из стека:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("Извлекаем данные по очереди из очереди:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}
