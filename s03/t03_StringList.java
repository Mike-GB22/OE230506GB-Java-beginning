package S03;

import java.util.List;
import java.util.ArrayList;

public class t03_StringList {
    public static final String TASK = """
        2023/05/20 mip
        Семинар 3. Задача №3
    
        Создать список типа ArrayList<String>.
        Поместить в него как строки, так и целые числа. 
        Пройти по списку, найти и удалить целые числа.
        """;
    
    public static void main(String[] args) {
        System.out.println(TASK);  

        ArrayList list = new ArrayList<String>();

        list.add("str1");
        list.add("str2");
        list.add("str3");
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3.14);
        list.add(2.17);
        list.add(0.123);
        
        System.out.println("Имеем лист:");
        System.out.println(list);
        
        System.out.println("\nТип каждого элемента:");
        for(int i = 0; i < list.size(); i++){
            String classNameOfElement = list.get(i).getClass().getName();
            System.out.println(list.get(i) + ", class: " + classNameOfElement);
            if(classNameOfElement.equals("java.lang.Integer") ||
                classNameOfElement.equals("java.lang.Long") ||
                classNameOfElement.equals("java.lang.Short") ||
                classNameOfElement.equals("java.lang.Byte")
                ){
                list.remove(i);
                i--;
            }
        }

        System.out.println("\nУдалили все Integerы и другие целочисленные типы данных:");
        System.out.println(list);
    }  
}
