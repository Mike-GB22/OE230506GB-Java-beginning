package S05;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class t02_Skobki {
    public static final String TASK = """
            2023/06/03 mip
            Семинар 5. Задача №1

            Написать программу, определяющую правильность расстановки скобок в выражении.
            Пример 1: a+(d*3) - истина
            Пример 2: [a+(1*3) - ложь
            Пример 3: [6+(3*3)] - истина
            Пример 4: {a}[+]{(d*3)} - истина
            Пример 5: <{a}+{(d*3)}> - истина
            Пример 6: {a+]}{(d*3)} - ложь
            """;
  

    public static void main(String[] args) {
        System.out.println(TASK);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение со скобками, для выхода - пустрая срока или слово exit: ");
        while(true){
            System.out.print("\nВыражение: ");
            String textString = scanner.nextLine();

            if (textString.equals("exit") || textString.length() == 0) break;

            System.out.println("Все скобки имеют пару? " + 
                (haveAllPairs(textString) ? "Да" : "Нет") + ".");
            System.out.println("Порядок раставление скобок - " + 
                (isCorrect(textString) ? "верный" : "неверный") + ".");

        }

    }

    public static boolean haveAllPairs(String str){
        Map<Character, Integer> countSkobkos = new HashMap<>();

        for (int i = 0; i < str.length(); i++){
            char symbol = str.charAt(i);
            if (countSkobkos.containsKey(symbol)) countSkobkos.put(symbol, countSkobkos.get(symbol) + 1);
            else countSkobkos.put(symbol, 1);
        }
        //System.out.println("Разобрали выражение по словарю: " + countSkobkos);
        
        if (countSkobkos.get('<') != countSkobkos.get('>')) return false;
        if (countSkobkos.get('[') != countSkobkos.get(']')) return false;
        if (countSkobkos.get('(') != countSkobkos.get(')')) return false;
        if (countSkobkos.get('{') != countSkobkos.get('}')) return false;
        return true;
    }

    public static boolean isCorrect(String str){
        Map<Character, Character> skobki = new HashMap<>();
        Stack <Character> stackSkobok = new Stack<>();

        skobki.put('>', '<');
        skobki.put('}', '{');
        skobki.put(']', '[');
        skobki.put(')', '(');

        for (int i = 0; i < str.length(); i++){
            char symbol = str.charAt(i);
            //Если текущий символ закрыающаяся скобка, проверяем, открывали ли мы ее сейчас,
            //для этого она должна быть последний в стеке
            for (char weLookinFor : skobki.keySet()){
                if (symbol == weLookinFor){
                    try{
                        if( stackSkobok.pop() != skobki.get(weLookinFor)) return false;
                        else break;
                    } catch (EmptyStackException e) {
                        return false;
                    }
                }
            }

            //Если текущий символ открывающаяся скобка, ложим ее в стек
            for (char weLookinFor : skobki.values()){
                if (symbol == weLookinFor){
                    stackSkobok.push(weLookinFor);
                    break;
                }
            }
        }

        //Если мы не разу не вылетели, значит все скобки закрываютс в правльной последовательности
        //Но все ли открытые сбоки закрылись?
        if (stackSkobok.size() > 0 ) return false;
        return true;
    }


    
}
