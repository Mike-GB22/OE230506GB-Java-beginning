/*
2023/05/06

Задание №2

Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1.

*/

class t02_ArrayCountOf1{
    public static void main(String[] args) {
        int [] myArray = new int[] {1,1,1,1,1,0,1,1,1};
        int max1 = 0;
        int count = 0;
        for (int i =0; i < myArray.length; i++){
            int currentElement = myArray[i];
            if (currentElement == 1) count ++;
            else {
                count = 0;
            }
            if(max1 < count) max1 = count;

        }
        System.out.println("Maximum '1' in row: " + max1);
    }
}
