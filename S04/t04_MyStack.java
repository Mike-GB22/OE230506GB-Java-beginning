//2023/05/29 mip Мой стек

import java.util.Arrays;

public class t04_MyStack {
    private int sizeMax = 10;
    private int sizeMin = sizeMax;
    private int size = 0;
    private int[] myStack = new int[0];

    public t04_MyStack(){
        myStack = new int [sizeMax];
        System.out.println("Мы создали новый стек, подготовили массив максимальным размером: " + sizeMax);
    }

    public int size(){
        return size;
    }

    public int sizePreparedArray(){
        return sizeMax;
    }

    public void empty(){
        size = 0;
        System.out.println("Обнулили стек. По факту мы обнулили только счетчик, добавленных элементов");
    }

    public boolean isEmpty(){
        if(size == 0) return true;
        return false;
    }

    public void push(int value){
        if(size >= sizeMax - 1) makeBigger();

        myStack[size] = value;
        size++;
    }

    public int pop(){
        if (size <= 0) throw new IndexOutOfBoundsException();
        if (size > sizeMin && (size < (sizeMax/2 - 1))) makeSmaller();
        return myStack[size--];
    }

    public int peek(){
        if (size <= 0) throw new IndexOutOfBoundsException();
        return myStack[size];
    }

    private void makeBigger(){
        int increment = size + 1;
        if (increment > 1000) increment = 1000;
        int sizeNewMax = size + increment + 1;
        int[] myNewStack = new int[sizeNewMax];

        for (int i = 0; i < size; i++) {
            myNewStack[i] = myStack[i];
        }
        myStack = myNewStack;
        sizeMax = sizeNewMax;
        System.out.println("Увеличили подготовленный массив для стека до: " + sizeMax + ", текущее количество элементов: " + size);
    }

    private void makeSmaller(){
        int sizeNewMax = sizeMax / 2;
        if (sizeNewMax < sizeMin) sizeNewMax = sizeMin;
        int[] myNewStack = new int[sizeNewMax];

        for (int i = 0; i < size; i++) {
            myNewStack[i] = myStack[i];
        }
        myStack = myNewStack;
        sizeMax = sizeNewMax;

        System.out.println("Уменьшили подготовленный массив для стека до: " + sizeMax + ", текущее количество элементов: " + size);
    }

    @Override
    public String toString() {
        return Arrays.toString(myStack);
    }
}
