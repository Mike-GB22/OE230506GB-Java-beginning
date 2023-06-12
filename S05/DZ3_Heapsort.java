package S05;

import java.util.Arrays;

public class DZ3_Heapsort {
    public static final String TASK = """
            2023/06/11 mip
            Семинар 5. Домашняя Задача №3

            Реализовать алгоритм пирамидальной сортировки (HeapSort).
            """;

    public static int[] array = null;
    public static int arrayLengtToSort = 0;

    
    public static void main(String[] args) {
        System.out.println(TASK);

        array = new int[]{8,1,9,0,2,7,3,9,6,4,5,9,8};
        //array = new int[]{0,1,1,2,2,2,2,3,3,3,3,3,3};
        //array = new int[] { 8, 1, 2 };
        arrayLengtToSort = array.length;

        if (arrayLengtToSort < 1)
            return;

        System.out.println("Не отсортированный массив:");
        System.out.println(Arrays.toString(array));
        System.out.println(new DZ3_PrintHeap(array));

        while (arrayLengtToSort > 0) {
            sortWholeHeapInArray(0);
            shortArrayAndMaxToEnd();
        }

        System.out.println("\nОтсортированный массив:");
        System.out.println(Arrays.toString(array));
        System.out.println(new DZ3_PrintHeap(array));

    }

    // Сейчас верх кучи (0й элемент массива) это максимум кучи,
    // Перемещаем его в конец, и обрезаем (логически) массив до это найденных
    // максимумов
    public static void shortArrayAndMaxToEnd() {
        if (arrayLengtToSort < 1)
            return;
        arrayLengtToSort--;
        int max = array[0];
        array[0] = array[arrayLengtToSort];
        array[arrayLengtToSort] = max;
    }

    public static void sortWholeHeapInArray(int indexOfHead) {
        int left = indexOfHead * 2 + 1;
        // Если нет левого ребенка, то и правого точно нет, выходим
        if (left >= arrayLengtToSort)
            return;
        sortWholeHeapInArray(left);

        int right = left + 1;
        // Есть ли правый ребенок?
        if (right < arrayLengtToSort)
            sortWholeHeapInArray(right);

        // Сортируем эту маленькую кучку из 3х
        if(sortSmallHeapInArray(indexOfHead)){
            //Так как мы сделали изменения, нужно отсортировать все нижние кучки заного
            //sortWholeHeapInArray(indexOfHead);
        }
            
    }

    public static boolean sortSmallHeapInArray(int indexOfHead) {
        int left = indexOfHead * 2 + 1;
        if (left >= arrayLengtToSort)
            return false;

        // Может самый большй элемент кучи с лева?
        int flagWhatWeHaveToPutToHead = 0;
        if (array[left] > array[indexOfHead])
            flagWhatWeHaveToPutToHead = 1;

        // Может самый большй элемент кучи с права?
        int right = left + 1;
            
            //System.out.println("Имеем кучку, с вершиной в массиве под индексом: " + indexOfHead);
            //System.out.println(new DZ3_PrintHeap(new int[]{array[indexOfHead], array[left], array[right]}));        

        if (right < arrayLengtToSort) {
            if (flagWhatWeHaveToPutToHead == 0)
                if (array[right] > array[indexOfHead])
                    flagWhatWeHaveToPutToHead = 2;
            if (flagWhatWeHaveToPutToHead == 1)                    
                if (array[right] > array[left])
                    flagWhatWeHaveToPutToHead = 2;
        }
                        
            //System.out.println("На верх идет элемент: " + flagWhatWeHaveToPutToHead);

        // Ставим максимальный элемент кучи на ее верх
        if (flagWhatWeHaveToPutToHead == 0)
            return false;
        if (flagWhatWeHaveToPutToHead == 1) {
            int tmp = array[left];
            array[left] = array[indexOfHead];
            array[indexOfHead] = tmp;
        } else {
            int tmp = array[right];
            array[right] = array[indexOfHead];
            array[indexOfHead] = tmp;
        }
            //System.out.println("Получили мини кучку:");
            //System.out.println(new DZ3_PrintHeap(new int[]{array[indexOfHead], array[left], array[right]}));        
        return true;
    }

    

}
