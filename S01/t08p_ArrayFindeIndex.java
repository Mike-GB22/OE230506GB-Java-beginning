import java.util.Scanner;

import javax.management.relation.Relation;


class t08p_ArrayFindeIndex{

static final String TASK = """
2023/05/07
Задание №8 (доп)

Задан массив, например, nums = [1,7,3,6,5,6]. 
Написать программу, которая найдет индекс i для этого массива такой,
что сумма элементов с индексами < i равна сумме элементов с индексами > i.

""";
    public static void main(String[] args) {
        int[] myArray = new int[] {1,7,3,6,5,6};

        printResults(
            TASK+intArrayToString(myArray,"Дан массив"),
            "Результат:\n" + findeAntwort(myArray)
            );
        


    }

    // ----------    Поиск элемента массива, вывод текстового ответа
    public static String findeAntwort(int[] myArray){
        int result = findeIndex(myArray);
        if(result <0 ) return "Нет такого элемента";
        return "Элемент массива [" + myArray[result] +"] под индексом: "+ result;
    }

    public static int findeIndex(int[] myArray){
        int length = myArray.length;
        for(int i = 1; i < length - 1; i++){
            int sumLeft = 0;
                for(int j = 0; j < i; j++){
                    sumLeft += myArray[j];
                }
            int sumRight = 0;
                for(int k = i + 1; k < length; k++){
                    sumRight += myArray[k];
                }
            if (sumLeft == sumRight) return i;
        }

        return -1;
    }


    // ----------    Вывод массива
    public static String intArrayToString(int[] myArray){
        String text = "[";
        String separator = ",";
        for (int i = 0; i < myArray.length; i++){
            text += " " + myArray[i];
            if(i < myArray.length - 1) text += separator;
        }
        text += "]";
        return text;
    }

    public static String intArrayToString(int[] myArray, String promt){
        String text = promt+":\n";
        text += intArrayToString(myArray);
        return text;
    }

    //Вывод результата
    public static void printResults(String task, String result){
        System.out.println("\n"+task+" ");
        System.out.println("\n"+result);
    }
    
 }
