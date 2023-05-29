public class t04_main {
    public static final String TASK = """
            2023/05/29 mip
            Семинар 4. Задача №4

            Реализовать стэк с помощью массива.
            Нужно реализовать методы:
            size(), empty(), push(), peek(), pop().
            """;

    public static void main(String[] args) {
        System.out.println(TASK);

        t04_MyStack stack = new t04_MyStack();
        System.out.println(stack);

        for (int i = 0; i < 1000; i++) {
            stack.push(i);
        }
        System.out.println(String.format("Размер подготовленного массива: %d, используется элементов: %d\n", stack.sizePreparedArray(), stack.size()));

        for (int i = 0; i < 991; i++) {
            stack.pop();
        }
        System.out.println(String.format("Размер подготовленного массива: %d, используется элементов: %d\n", stack.sizePreparedArray(), stack.size()));
        System.out.println(stack);
    }

}
