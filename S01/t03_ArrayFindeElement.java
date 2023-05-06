/*
2023/05/06

Задание №2

Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1.

*/

class t03_ArrayFindeElement{
    public static void main(String[] args) {
        int[] myArray = new int[] {3,2,1,2,3,3};
        int weAreLookingFor = 3;
        System.out.println(intArrayToString(myArray, "Begin, we are looking for " + weAreLookingFor));                

        int weHaveFound = 0;
        for(int i = 0; i < myArray.length - weHaveFound; i++){

            int currentElement = myArray[i];
            if (currentElement == weAreLookingFor){
                weHaveFound++;
                int indexLastElementOfArrayForReaplace = myArray.length - weHaveFound;
                myArray[i] = myArray[indexLastElementOfArrayForReaplace];
                myArray[indexLastElementOfArrayForReaplace] = currentElement;
                i--;
            }
            System.out.println(intArrayToString(myArray) + ", i: " + (i+1) + ", we are looking for in myArray bis index: " + (myArray.length - weHaveFound));

        }
        System.out.println(intArrayToString(myArray, "Result"));
    }

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

}
