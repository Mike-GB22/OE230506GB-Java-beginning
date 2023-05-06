import java.util.Scanner;
/*
2023/05/06
Task #01
Запросить имя пользователя, и вывести в консоль "Привет, <Имя>!"
*/

public class t01_Scan {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "866");
        System.out.print("Input your name: ");
        String name = scan.nextLine();

        System.out.printf("Privet, %s!", name);

    }
}
