import java.util.Scanner;

public class DZ3_SimpleCalc {
    static final String TASK = """
        2023/05/07
        Семинар 1. Домашнее задание №3
        
        Реализовать простой калькулятор
        
        """;
    public static void main(String[] args) {
        printResults(TASK);
        String prompt = """
        Введите выражение типа 1+2-3/4+5
        Поддерживаются +, -, *, /.
        Скобки не поддерживаются. 
        Если в результате будет деление на 0, вылетит ошибка.
        Количество операторов и операндов ограниченно размером переменной String""";
        String frageOrigin = inputStringFromConsole(prompt);
        String frageKurz = frageOrigin;
        
        //Обрезаем строку до знака равно
        int whereIsEqual = frageOrigin.indexOf("=");
        if (whereIsEqual >= 0) frageKurz = frageOrigin.substring(0,whereIsEqual);

        //Отсалвяем только разрешенные цифры и знаки
        String frageOnlyNumericAndSigns = onlyNumericAndSigns(frageKurz);
        printResults("Строка запроса: " + frageOnlyNumericAndSigns); 

        //String text = firstOperation(frageOnlyNumericAndSigns,'/');
        printResults("\nРезультат выполнения обработки строки:",
            frageOnlyNumericAndSigns + " = " + calculate(frageOnlyNumericAndSigns)
            );
        
    }

    //Отсалвяем только разрешенные цифры и знаки
    public static String onlyNumericAndSigns(String frage){
        char[] allowedChars = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '*', '/','.'};
        
        String frageProcessed = "";
        frage = frage.replace(":", "/");
        frage = frage.replace(",", ".");
        
        //Проверяем каждый символ, если он не в списке разрешенных, просто удаляем его
        for(int i = 0; i < frage.length(); i++){
            char iChar = frage.charAt(i);
            boolean flagWeNeedThisChar = false;
            for (int j = 0; j < allowedChars.length; j++){
                if (iChar == allowedChars[j]){
                    flagWeNeedThisChar = true;
                    break;
                }
            }
            if (flagWeNeedThisChar) frageProcessed += iChar;
        }
        
        //Если первый символ деление или умножение, обрезаем его
        if(frageProcessed.charAt(0) == '/' || frageProcessed.charAt(0) == '*'){
            frageProcessed = frageProcessed.substring(1, frageProcessed.length());
        }
        return frageProcessed;
    }

    //Главный вход в калькуляцию
    public static String calculate(String frage){
        int count = 0;
        char[] operatorsArray = new char[] {'/','*','-','+'};

        //По каждому оператору полностью обрабатываем строку, в порядке представления операторов в массиве
        for(int i = 0; i < operatorsArray.length; i++){
            char operator = operatorsArray[i];
            while(frage.indexOf(operator,1)>=0){
                System.out.print("[ " + (++count) + " ]: ");
                frage = firstOperation(frage, operator);
            }
        }
        return frage;
    }
    
    //Выполняем одну указанную операцию, в порядке с лева на право
    //Находим нужный оператор, обрезаем строку до ее аргументов, считаем, вовзращем результат в строку
    public static String firstOperation(String frage, char operator){
        //Служебная строка запроса, где все символы операций заменены на +,
        //чтоб проще было ориентироваться где операнды, где операторы
        String frageTmp = frage;
        frageTmp = frageTmp.replace('-','+');
        frageTmp = frageTmp.replace('/','+');
        frageTmp = frageTmp.replace('*','+');

        //Ищем где первый раз встречается нужны нам оператор
        int wereIsSing = frage.indexOf(operator, 1);
        //Находим начало 1го операнда
        int beginFirstArgement = frageTmp.substring(0, wereIsSing).lastIndexOf('+');
            if(beginFirstArgement < 0) beginFirstArgement = 0;
        //Находим конец 2го операнда            
        int endSecondArgement = frageTmp.substring(wereIsSing+2, frage.length()).indexOf('+');
            if(endSecondArgement < 0) endSecondArgement = frage.length();
            else endSecondArgement += wereIsSing + 2;
        
        //Выводим кусок строки запроса, которую мы тут будем обрабатывать
        String currentFrage = frage.substring(beginFirstArgement, endSecondArgement);
        System.out.print(currentFrage);

        //System.out.println("\n" + wereIsSing);
        //System.out.println(endSecondArgement);
        //System.out.println(frageTmp.substring(wereIsSing+1, frage.length()));
        

        //Извлекаем операнды и выполняем вычисление
        double firstArgument = Double.parseDouble(frage.substring(beginFirstArgement, wereIsSing));
        double secondArgument = Double.parseDouble(frage.substring(wereIsSing+1, endSecondArgement));
        double result = firstArgument;
            if(operator == '/') result /= secondArgument;
            else if(operator == '*') result *= secondArgument;
            else if(operator == '+') result += secondArgument;
            else if (operator == '-') result -= secondArgument;
        
        //Преобразовываем результат в текст
        String resultString = Double.toString(result);
            if(result >= 0) resultString = "+"+resultString;

        //Выводим его на экран
        System.out.print(" = "+ result);

        //Формируем новую строку запроса
        String newFrage = frage.substring(0, beginFirstArgement)+
            resultString
            + frage.substring(endSecondArgement, frage.length());

        //Выводим новую строку запроса
        System.out.println(" -> "+ newFrage);            

        return newFrage;
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

