/*
2023/05/07

Задание №5 (доп)

Во фразе "Добро пожаловать на курс по Java" переставить слова в обратном порядке.


*/

class t05p_ReversWordInSatz{
    public static void main(String[] args) {
        String text = "Добро пожаловать на курс по Java:";
        String[] textInArray = text.split(" ");

        System.out.printf("Данна строка:\n%s\nРезультат\n",text);

        for(int i = textInArray.length - 1; i >= 0 ; i--){
            System.out.print(textInArray[i]+" ");
        }
    }
}
