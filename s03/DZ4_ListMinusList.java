package S03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DZ4_ListMinusList {
    public static final String TASK = """
        2023/05/20 mip
        Семинар 3. Домашняя Задача №4
    
        *Реализовать разность массивов (список ArrayList) и симметрическую разность.
        """;
    
    public static void main(String[] args) {
        System.out.println(TASK);    

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();        
        Random rnd = new Random();
        for (int i = 0; i < 10; i++){
            list1.add(rnd.nextInt(0, 7));
            list2.add(rnd.nextInt(3, 10));
        }

        System.out.println("У нас есть два списка чисел:");
        System.out.println("Список 1: " + list1);
        System.out.println("Список 2: " + list2);
        
        System.out.println("\nВычитаем из списка 1, список 2:");
        System.out.println(listMinusList(list1, list2));

        System.out.println("\nВычитаем из списка 2, список 1:");
        System.out.println(listMinusList(list2, list1));

        System.out.println("\nСиметричная разность списков 1 и 2:");
        System.out.println(listXORList(list2, list1));

    }

    public static List<Integer> listMinusList(List<Integer> list1, List<Integer> list2){
        List<Integer> listNew = new ArrayList<>(list1);
            for (Integer intList2 : list2) {
                for (int i = 0; i < listNew.size(); i++) {
                    if(listNew.get(i).equals(intList2)){
                        listNew.remove(i);
                        i--;
                    }
                }
                
            }
        return listNew;
    }

    public static List<Integer> listXORList(List<Integer> list1, List<Integer> list2){
        List<Integer> listNew = new ArrayList<>(listMinusList(list1, list2));
            listNew.addAll(listMinusList(list2, list1));
        return listNew;
    }    
}
