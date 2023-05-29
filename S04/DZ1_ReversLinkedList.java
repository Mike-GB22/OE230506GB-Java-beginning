import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DZ1_ReversLinkedList<E> extends LinkedList {
    public static final String TASK = """
            2023/05/29 mip
            Семинар 4. Домашняя Задача №1

            Пусть дан LinkedList с несколькими элементами.
            Реализуйте метод, который вернет “перевернутый” список.
            """;

    public DZ1_ReversLinkedList(List<E> asList) {
        super(asList);
    }

    public DZ1_ReversLinkedList() {
        super();
    }

    public static void main(String[] args) {
        System.out.println(TASK);

        //LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1 ,2 ,3 , 4 ,5 , 6, 7, 8, 9, 10));

        DZ1_ReversLinkedList<Integer> list = new DZ1_ReversLinkedList<>(Arrays.asList(1 ,2 ,3 , 4 ,5 , 6, 7, 8, 9, 10));
        System.out.println("Создали список:                            " + list);
        System.out.println("Вызываем метот возврощающий реверс списка: " + list.reversList());
    }

    public DZ1_ReversLinkedList<E> reversList(){
        DZ1_ReversLinkedList<E> newList = new DZ1_ReversLinkedList<>();
        while (this.size() > 0) {
            newList.add((E) this.pollLast());
        }
        return newList;
    }
}
