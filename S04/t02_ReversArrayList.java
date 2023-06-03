import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class t02_ReversArrayList {
    public static final String TASK = """
            2023/05/29 mip
            Семинар 4. Задача №2

            Реализовать консольное приложение, которое:
            Принимает от пользователя и “запоминает” строки.
            Если введено print, выводит строки в обратном порядке (первая введённая окажется последней выведенной).
            Если введено revert, удаляет предыдущую введенную строку из памяти.
            """;

    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(TASK);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Вводим строки, [понимаем команды print, revert, exit]:");
        while (true) {
            String string = scanner.nextLine();
            String stringLow = string.toLowerCase();
            if (stringLow.equals("exit")) break;
            if (stringLow.equals("revert")) {
                if (list.size() == 0)
                    System.out.println("Нет строк для удаления.");
                else {
                    list.remove(list.size() - 1);
                    System.out.println("Строка удалена.");
                }
                continue;
            }
            if (stringLow.equals("print")) {
                printList();
                break;
            }
            list.add(string);
        }

    }

    public static void printList(){
        for (int i = 0; i < list.size() ; i++) {
            System.out.println(i + " : " + list.get(list.size() - 1 - i));
        }
    }
}
