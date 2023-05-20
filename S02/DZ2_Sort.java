package S02;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class DZ2_Sort {
    public static final String TASK = """
        2023/05/19
        Семинар 2. Домашняя Задача №2
    
        Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
        """;

    public static final String logFile = "S02\\DZ2_Sort.log";

    public static void main(String[] args) {
        printResults(TASK,"");
        
        int[] array = new int[] {10,9,8,7,6,5,4,3,2,1};

        System.out.println(Arrays.toString(sortIntArray(array)));
    }

    //Сортировка пузырьком, по возрастанию
    public static int[] sortIntArray (int[] array){
    String logText = (new Date()).toString() + " - Imeem array:" + Arrays.toString(array) + "\n";
    writeToNewFile(logFile, logText);
        int arrayLengthToSort = array.length;
        for(int i = 0; i < arrayLengthToSort; i++){
            for(int j = 1; j < arrayLengthToSort - i; j++){
                if(array[j-1] > array[j]){
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }    
            }
        String lotTextCycle = (new Date()).toString() + " - After [" + i + "] :" + Arrays.toString(array) + "\n";  
        writeToNewFile(logFile, lotTextCycle);        
        }

        return array;
    }

    //Вывод результата
    public static void printResults(String task, String result){
        System.out.println("\n"+task+": ");
        System.out.println(result);
    }

    public static void printResults(String result){
        System.out.println(result);
    }    
    
    //Запись данных в новый файл
    public static boolean writeToNewFile(String fileName, String string){
        System.out.print(string);
        try (FileWriter writer = new FileWriter(fileName, true)){
            writer.append(string);
        } catch (IOException ex){
            System.out.println("Ошибка работы с файлом: " + fileName + "\n" + ex.getMessage());
            return false;
        }
        return true;
    }

    
}
