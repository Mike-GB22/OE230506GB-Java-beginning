import java.util.Scanner;

public class DZ2_ProstieChisla {
    static final String TASK = """
        2023/05/07
        Семинар 1. Домашнее задание №2
        
        Вывести все простые числа от 1 до 1000
        * тут модификация, запрашиваем у пользователя до какого числа мы ищем простые числа
        """;
    public static void main(String[] args) {
        printResults(TASK);
        int n = inputIntFromConsoleInDiapason(
                        "Введите число N", 2, 1000);
        
        printResults("Простые числа от 1 до " + n + ": ");
        printSimpleNumbers(1, n);
    }

    public static void printSimpleNumbers(int min, int max){
        int count = 0;
        for(int i = min; i<=max; i++){
            boolean flag = true;
            for(int devisor = 2; devisor*devisor <= i; devisor ++){
                if (i % devisor == 0){
                    flag = false;
                    break;
                }
            }
            if(flag == true) System.out.println("[ " + (++count) + " ]: "+i);
        }
    }

    //Вывод результата
    public static void printResults(String task, String result){
        System.out.println(task+" ");
        System.out.println(result);
    }
    public static void printResults(String result){
        System.out.println(result);
    }

    // ----------    Считываем из консоли одно значение
    //Cчитываем int число из консоли в диапазоне
    public static int inputIntFromConsoleInDiapason(String prompt, int min, int max){
        int result = Integer.MIN_VALUE;
        String attention = " [в диапазоне от "+ min +" до "+ max +"]";
        String attentionFlag = "";

        while (true){
            result = inputIntFromConsole(prompt+attentionFlag);
            if(result >= min && result <= max) return result;
            attentionFlag = attention;
        }
    }

    //Считываем int число из консоли
    public static int inputIntFromConsole(String prompt){
        return Integer.parseInt(inputStringFromConsole(prompt));
    }

    //Считываем строку из консоли
    public static String inputStringFromConsole(String prompt){
        System.out.print(prompt+": ");
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        //scan.close();

        return text;
    }
    // ----------

    
                
}

