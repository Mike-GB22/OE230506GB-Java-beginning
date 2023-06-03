package S05;

import java.util.Scanner;

public class t03_Rimsky2Indisky {
    public static final String TASK = """
            2023/06/03 mip
            Семинар 5. Задача №3

            Написать метод, который переводит число из римского формата записи в арабский. 
            Например, MMXXII = 2022

            http://graecolatini.bsu.by/htm-different/num-converter-roman.htm 
            Принципы римской с/с
            """;
    public static void main(String[] args) {
        System.out.println(TASK);  
    
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение, для выхода - пустрая срока или слово exit: ");
        while(true){
            System.out.print("\nРимское число: ");
            String str = scanner.nextLine();
            if(str.length() == 0 || str.equals("exit")) break;

            System.out.println("Индийскими цифрами это: " + 
                convertRimsky2Indisky(str));

        }
    }

    public static int convertRimsky2Indisky(String rimNum){
        int indNum = 0;
        
        for (int i = 0; i < rimNum.length(); i ++){
            int kleineSum  = 0;

            char thisSymbol = rimNum.charAt(i);
            int thisSymbolValue = convertOneDigitRimsky2Indisky(thisSymbol);
        
            for (; i < rimNum.length(); i ++){
                kleineSum += thisSymbolValue;

                if (i == rimNum.length() - 1){
                    indNum += kleineSum ;
                    continue;
                }

                char nextSymbol = rimNum.charAt(i + 1);
                int nextSymbolValue = convertOneDigitRimsky2Indisky(nextSymbol);
                if (thisSymbol != nextSymbol){
                    if(thisSymbolValue < nextSymbolValue) kleineSum *= -1;
                    indNum += kleineSum ;
                    break;
                } 
            }            

        }

        return indNum;
    }

    public static int convertOneDigitRimsky2Indisky(char rimDigit){
        rimDigit = Character.toLowerCase(rimDigit);

        if (rimDigit == 'i') return 1;
        if (rimDigit == 'v') return 5;
        if (rimDigit == 'x') return 10;
        if (rimDigit == 'l') return 50;        
        if (rimDigit == 'c') return 100;
        if (rimDigit == 'd') return 500;        
        if (rimDigit == 'm') return 1000;

        return 0;
    }
}
