import java.time.LocalTime;
import java.util.Scanner;

/*
2023/05/06

Задание №1+
В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида 
"Доброе утро, <Имя>!", если время от 05:00 до 11:59
"Добрый день, <Имя>!", если время от 12:00 до 17:59;
"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
"Доброй ночи, <Имя>!", если время от 23:00 до 4:59

*/

public class t01p_TimeOfDay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "866");        
        System.out.println("Input your name: ");
        String name = scan.nextLine();

        LocalTime timeNow = LocalTime.now();
        int hours = timeNow.getHour();

        String partOfTheDay = "Добрый день";
        if (hours< 5 || hours >= 23) partOfTheDay = "Доброй ночи";
        else if (hours>= 5 && hours < 12) partOfTheDay = "Доброе утро";
        else if (hours>= 18 && hours < 23) partOfTheDay = "Доброго вечера";

        System.out.printf("%s, %s!", partOfTheDay, name);
    }
}
