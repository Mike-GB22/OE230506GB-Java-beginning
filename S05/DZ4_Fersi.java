package S05;

import java.util.ArrayList;
import java.util.List;

public class DZ4_Fersi {
        public static final String TASK = """
            2023/06/11 mip
            Семинар 5. Домашняя Задача №4

            На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.   
            """;

    public static void main(String[] args) {
        System.out.println(TASK);

        List<String> sucsess = new ArrayList<>();

        String[][] doska = new String[8][8];
        
        int f = 0;
        int fMaxFinded = 0;

        int fMax = 8;
        int deltaX = 0;
        int deltaY = 0;
        int tryCount = 0;
        int tryMax = 64;

        for(tryCount = 1; tryCount <= tryMax ; tryCount++){
            //if(f >= fMax) break;    
            int delta = tryCount - 1;
            deltaX = delta/doska[0].length;
            deltaY = delta%doska[0].length;
            
            clearDesk(doska);
            if (f > fMaxFinded) fMaxFinded = f;
            f = 0;

            for(int i = 0; i < doska.length; i++){
                for(int j = 0; j < doska[i].length; j++){
                    if(f >= fMax) break;
                    int x = i + deltaX;
                        if (x >= doska.length) x -= doska.length;
                    int y = j + deltaY;
                        if (y >= doska[i].length) y -= doska[i].length;
                    if(doska[x][y].equals(" ")){
                        doska[x][y]="F";
                        f++;                    
                        fillDotes(x, y, doska);
                        
                    }
                }
            }
            String total = printDesk(doska);
            total +="Попытка: " + tryCount + " [из запрощенных: " + tryMax + " ]\n";
            total +="Начальные условия, место первого ферзя (х, у): (" + (deltaY+1) + ", " + (deltaX+1) + ")\n";
            total +="Размещенно ферзей: " + f + " [из запрощенных: " + fMax + " ]";
            if(f >= fMax) {
                total +="\n!!! УСПЕХ !!!";
                sucsess.add(total);
            }
            System.out.println(total+ "\n");
        }

        System.out.println("\n-------------------------------------");
        System.out.printf("Условие задачи: проставить %d ферзей, за %d попыток, на доске размером %d х %d", fMax, tryMax, doska.length, doska[0].length);
        System.out.println("\n-------------------------------------");
        if(sucsess.size() > 0){
            System.out.printf("Мы нашли решение поставленной задачи: %d раз(а)", sucsess.size());
            int count = 0;
            for (String total : sucsess) {
                System.out.println("\nНайденное решение № "+ ++count);
                System.out.println(total);
            }
         
        } else {
            System.out.printf("Мы НЕ нашли решение поставленной задачи, максимально возможное количество было %d:", fMaxFinded);
        }
    }

    public static void fillDotes(int x, int y, String[][] doska){
        for(int i = 1; (x + i) < doska.length; i++){
            fillOneDot((x + i), y, doska);
            if((y + i) >= 0 && (y + i) < doska[x].length) fillOneDot(x + i, y + i, doska);
            if((y - i) >= 0 && (y - i) < doska[x].length) fillOneDot(x + i, y - i, doska);
        }
        for(int i = - 1; (x + i) >= 0; i--){
            fillOneDot((x + i), y, doska);
            if((y + i) >= 0 && (y + i) < doska[x].length) fillOneDot(x + i, y + i, doska);
            if((y - i) >= 0 && (y - i) < doska[x].length) fillOneDot(x + i, y - i, doska);
        }

        for(int j = y + 1; j < doska[x].length; j++) fillOneDot(x, j, doska);;
        for(int j = y - 1; j >= 0; j--) fillOneDot(x, j, doska);
    }

    public static void fillOneDot(int x, int y, String[][] doska){
        fillOneDot(x, y, doska, ".");
    }

    public static void fillOneDot(int x, int y, String[][] doska, String filling){
        if (x > doska.length || x < 0) return;
        if (y > doska[x].length || y < 0) return;        
        if(doska[x][y].equals(" ")){
            doska[x][y] = filling;
        }
    }

    public static String printDesk(String[][] doska){
        String toReturn="";
        toReturn += "------------------------------------\n";
        toReturn += "Шахматная доска:\n";
        toReturn += "------------------------------------\n";
        for(int i = -1; i < doska.length; i++){

            toReturn += String.format("%c : ", ('A'+i));

            int length = doska[(i < 0 ? 0 : i)].length;
            for (int j = 0; j < length; j++){
                if(i < 0){
                    toReturn += String.format(" %d ", (j+1));
                } else {
                    String current = doska[i][j];
                    if (current == null) current ="";
                    toReturn += String.format(" %s ", current);
                }
            }
            toReturn += "\n";
        }
        return toReturn;
    }

    public static void clearDesk(String[][] doska){
        for(int i = 0; i < doska.length; i++){
            for(int j = 0; j < doska[i].length; j++){
                doska[i][j] = " ";
            }
        }
    }
}
