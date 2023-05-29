import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class t01_ScanAndPrintFromList1 {
    public static final String TASK = """
            2023/05/29 mip
            Семинар 4. Задача №1

            Реализовать консольное приложение, которое в цикле:
            Принимает от пользователя строку вида    text~num
            Нужно разделить строку по ~, сохранить text в связный список на позицию num.
            Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
            """;

    public static int NUMBERS = 10_000_000;

    public static void main(String[] args) {
        System.out.println(TASK);
        Scanner scanner = new Scanner(System.in, "866");
        String input = null;
        int count = 0;

        List<String> list = new LinkedList<>();

        System.out.println("Введите строку вида: text~num, для вывод на экран print~num:");
        System.out.println("Пустая строка или слово exit для выхода.");
        while (true) {
            System.out.printf("[ %d ]: ", ++count);
            input = scanner.nextLine();
            //Условие выхода
            if (input == null || input.length() == 0 || input.indexOf("exit") == 0) break;

            if (!input.contains("~")) {
                System.out.println("Ошибка, строка должна содержать символ: ~");
                continue;
            }
            String[] numberValue = input.split("~");

            //Проверяем, ввели ли после тильды число
            try {
                int listSize = list.size();
                int i = Integer.parseInt(numberValue[1]);
                if (i < 0) i = 0;
                String text = numberValue[0];

                if (text.toLowerCase().equals("print")) {
                    if (i > listSize - 1) {
                        System.out.printf("Элемент под номер [%d], не существует, так как выходит за пределы коллекции %d\n", i, listSize);

                    } else {
                        System.out.printf("Элемент под номер [%d] в коллекции содержит текст: %s\n", i, list.get(i));
                        list.remove(i);
                        System.out.println("Элемент мы удалили, теперь коллекция выглдит nак: " + list.toString());
                    }
                } else {
                    if (i > listSize) {
                        System.out.println(
                                String.format("Запрощенный Вами элемент %d выходит за пределы размера коллекции %d\nУстанавливаем курсор на конец коллекции.", i, listSize));
                        i = listSize;
                    }
                    list.add(i, text);
                    System.out.println("Коллекция выглядит так: " + list.toString());
                }
            } catch (Exception e) {
                System.out.println("После символа ~, должно идти число. " +
                        e.getClass().getName() + " " + e.getMessage());
                continue;
            }
        }
        ;
    }
}
