//2023/06/12 mip
package S05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Класс для печати кучи
public class DZ3_PrintHeap {
    public static final int SIZE_OF_FIELD = 3;

    // public static int deepMax = 0;
    public static Map<Integer, List<String>> mapToPrint = null;
    public static int[] array = null;
    
    public DZ3_PrintHeap(int[] heap){
        array = heap;
        mapToPrint = new HashMap<>();
        makeMapToPrintWholeHeapInArray();
    }

        

    //Формирует КАРТУ кучи для печати
    public static void makeMapToPrintWholeHeapInArray() {
        makeMapToPrintWholeHeapInArray(0, 0);
    }
    public static void makeMapToPrintWholeHeapInArray(int indexOfHead) {
        makeMapToPrintWholeHeapInArray(indexOfHead, 0);
    }
    public static void makeMapToPrintWholeHeapInArray(int indexOfHead, int deep){
        if(mapToPrint.get(deep) == null){
            mapToPrint.put(deep, new LinkedList<String>());
        }
        if(deep == 0) {
            mapToPrint.get(0).add("" + array[0]);
            makeMapToPrintWholeHeapInArray(0, 1);

            return; 
        } 
        int left = indexOfHead * 2 + 1;
            //Если нет левого ребенка, то и правого точно нет, выходим
            if (left >= array.length) {
                //System.out.println(integerToCenterOfString(array[indexOfHead]));   
                return;
            }
            makeMapToPrintWholeHeapInArray(left, deep+1);

        int right = left + 1;
            //Есть ли правый ребенок?
            if(right < array.length) makeMapToPrintWholeHeapInArray(right, deep+1);

        //Печатаем детей, главного элемента маленкой кучки
        makeMapToPrintSmallHeapInArray(indexOfHead, deep);
        
    }

    // Добавляем на нужный уровень глубины элементы кучки
    public static void makeMapToPrintSmallHeapInArray(int indexOfHead, int deep) {
        int left = indexOfHead * 2 + 1;
        if (left >= array.length)
            return;
        String leftValue = "" + array[left];
        String rightValue = "*";

        int right = left + 1;
        if (right < array.length) {
            rightValue = "" + array[right];
        }
        mapToPrint.get(deep).add(leftValue);
        mapToPrint.get(deep).add(rightValue);
    }

    public static void deleteEmptyDeeps(){
        //Iterator<Map.Entry<Integer,List<String>>> iterator =  mapToPrint.entrySet().iterator();
    }

    // Ставим число в центр поля, строки
    public static String integerToCenterOfString(int i) {
        return integerToCenterOfString(i, SIZE_OF_FIELD);
    }

    public static String integerToCenterOfString(int i, int countOfSymbols) {
        return integerToCenterOfString("" + i, countOfSymbols);
    }

    public static String integerToCenterOfString(String i) {
        return integerToCenterOfString(i, SIZE_OF_FIELD);
    }

    public static String integerToCenterOfString(String i, int countOfSymbols) {
        int countOfFillers = (countOfSymbols - i.length()) / 2;
        String toReturn = " ".repeat(countOfFillers) + i;
        toReturn += " ".repeat(countOfSymbols);
        return toReturn.substring(0, countOfSymbols);
    }

    @Override
    public String toString() {
        String toReturn = "";
        int deep = mapToPrint.size();
        int countOfSymbols = SIZE_OF_FIELD;
        for(int i = deep-1; i>=0; i--){
            List<String> list = mapToPrint.get(i);
            String row = "";
            for(int j = 0; j < list.size(); j++){
                String element = list.get(j);
                row += integerToCenterOfString(element, countOfSymbols);
                
            }
            countOfSymbols *= 2;
            toReturn = row + "\n" + toReturn;
        }
        
        return "\n" + toReturn;
    }
}
