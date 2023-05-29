import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class t00_ArrayListVSLinkList{
    public static final String TASK = """
        2023/05/28 mip
        Семинар 4. Задача №0
    
        Сравнить коллекции ArrayList и LinkedList
        """;

    public static int NUMBERS = 10_000_000;

    public static void main(String[] args) {
        System.out.println(TASK);
        
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(new ArrayList<Integer>());
        listOfLists.add(new LinkedList<Integer>());

        System.out.printf("\nЗаполняем коллекции (добавлением в конец, количество эллементов [%d]):", NUMBERS);
        for (int i = 0; i < listOfLists.size(); i++) {
            System.out.println("\nМы начали заполнять коллекцию: " + listOfLists.get(i).getClass().getName());
            long start = System.nanoTime();

            for (int j = 0; j < NUMBERS; j++) {
                listOfLists.get(i).add(j);
            }
            long stop = System.nanoTime();
            System.out.println("Мы закончили заполнять коллекцию: " + listOfLists.get(i).getClass().getName());
            System.out.println("Затречено времени в миллисекундах: " + (stop - start)/1e+6);
        }
    }
}