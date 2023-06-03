package S05;

import java.text.ParseException;
import java.util.Scanner;

public class t04_Indisky2Rimsky {
    public static final String TASK = """
            2023/06/03 mip
            Семинар 5. Задача №4

            Написать метод, который переведёт данное целое число в римский формат.
            2023 => MMXXIII

            http://graecolatini.bsu.by/htm-different/num-converter-roman.htm 
            Принципы римской с/с
            """;
    public static void main(String[] args) {
        System.out.println(TASK);  

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение, для выхода - пустрая срока или слово exit: ");
        while(true){
            System.out.print("\nИндийское (арабское) число (от 1 до 9 999 999): ");
            String str = scanner.nextLine();
            if(str.length() == 0 || str.equals("exit")) break;
            int indNum = 0;
            try{
                indNum = Integer.parseInt(str);
            } catch (Exception e){
                continue;
            }

            System.out.println("Римскими цифрами это: " + 
                convertIndisky2Rimsky(indNum));

        }
    }

    public static String convertIndisky2Rimsky(int indNum){
        String rimNum = "";
        int weUnderstend = 10_000_000;
        indNum %= weUnderstend;
        for(int razrad = 0; indNum > 0; razrad++){

            int oneDigit = indNum % (int)(Math.pow(10.0, razrad+1));
            //System.out.printf("===> indNum: %d, razrad: %d, oneDigit: %d ---\n", indNum, razrad, oneDigit);            
                indNum -= oneDigit;
            
            if(razrad != 0) oneDigit /= (int)(Math.pow(10.0, razrad));
            
            //System.out.printf("---> indNum: %d, razrad: %d, oneDigit: %d ---\n", indNum, razrad, oneDigit);

            String convertedDigit = convertOneDigitIndisky2Rimsky(oneDigit, razrad);
            rimNum = convertedDigit + rimNum;
        }
        return rimNum;
    }
    public static String convertOneDigitIndisky2Rimsky(int indDigit, int razrad){
        razrad %= 7;
        String[] eins = new String[]{"i", "x", "c", "m", "X", "C", "M", "X="};
        String[] funf = new String[]{"v", "l", "d", "V", "L", "D", "V="};
        if (indDigit == 1) return ""+eins[razrad];
        if (indDigit == 2) return ""+eins[razrad].repeat(2);
        if (indDigit == 3) return ""+eins[razrad].repeat(3);
        if (indDigit == 4) return ""+eins[razrad]+funf[razrad];
        if (indDigit == 5) return ""+funf[razrad];
        if (indDigit == 6) return ""+funf[razrad]+eins[razrad];        
        if (indDigit == 7) return ""+funf[razrad]+eins[razrad].repeat(2);
        if (indDigit == 8) return ""+funf[razrad]+eins[razrad].repeat(3);
        if (indDigit == 9) return ""+eins[razrad]+eins[razrad + 1];
        return "";
    }

    
}
