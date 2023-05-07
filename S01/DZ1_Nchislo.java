import java.util.Scanner;

public class DZ1_Nchislo {
    static final String TASK = """
        2023/05/07
        Семинар 1. Домашнее задание №1
        
        Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
        """;
    public static void main(String[] args) {
        printResults(TASK,"");
        int n = inputIntFromConsoleInDiapason(
                        "Введите число N", 1, 100);

        printResults(
            "Треугольное число от N: " + Integer.toString(
                numberTriangel(n)
                )
            );
        printResults(
            "Факториал от N: " + Double.toString(
                numberFaktorial(n)
                )
            );

    }

    public static int numberTriangel(int n){
        int result=0;
        for(int i = 1; i<=n; i++){
            result += i;
        }
        return result;
    }

    public static double numberFaktorial(int n){
        double result=1;
        for(int i = 1; i<=n; i++){
            result *= i;
        }
        return result;
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
