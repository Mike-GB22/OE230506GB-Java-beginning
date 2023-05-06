import java.util.Scanner;

/*
2023/05/07

Задание №6 (доп)

Реализовать функцию возведения числа а в степень b. a, b из Z. Сводя количество выполняемых действий к минимуму.
Пример 1: а = 3, b = 2, ответ: 9
Пример 2: а = 2, b = -2, ответ: 0.25
Пример 3: а = 3, b = 0, ответ: 1


*/

class t06p_APowB{
    public static void main(String[] args) {
        printResults("Возводим число A в степень B",
            aPowB(
                inputDoubleFromConsole("Input A"),
                inputIntFromConsole("Input B (только целые числа)")
            ).toString()
        );
    }

    //
    public static Double aPowB(double a, int b){
        if (a == 0 || a == 1) return a;
        if (b == 0) return 1.0;

        //Умеем работать только с целочисленной положительной степенью
        if (b < 0){
            a = 1/a;
            b = -b;
        }

        double result=1;
        while(b > 0){
            if(b % 2 == 1){
                result *= a;
            }

            b /= 2;
            a *= a;
        }

        return result;
    }
    
    //Считываем int число из консоли
    public static int inputIntFromConsole(String prompt){
        return Integer.parseInt(inputStringFromConsole(prompt));
    }

    //Считываем double число из консоли
    public static double inputDoubleFromConsole(String prompt){
        return Double.parseDouble(inputStringFromConsole(prompt));
    }
    
    //Считываем строку из консоли
    public static String inputStringFromConsole(String prompt){
        System.out.print(prompt+": ");
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        //scan.close();

        return text;
    }

    //Вывод результата
    public static void printResults(String task, String result){
        System.out.println("\n"+task+": ");
        System.out.println(result);
    }

}
