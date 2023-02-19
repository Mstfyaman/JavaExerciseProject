package day4_IntQuestions_String;

import java.util.Arrays;
import java.util.Comparator;

public class Question_3_SortingString {
    public static void main(String[] args) {

        String str = "128 2 3693 65 89 25 10";

        System.out.println("sumOfString(str) = " + sumOfString(str));

        System.out.println("sumOfString2(str) = " + sumOfString2(str));


    }
    /*

String str="128 2 3693 65 89 25 10"; str içerisindeki boşlukla ayrılmış sayıların sayı değerleri
toplanarak küçükten büyüğe dizili olarak yeniden bir stringe tanımlayan metod nedir? Bu soru
için cevap String result="1 2 7 11 11 17 21"; şeklinde olmalıdır.
     */

    public static String sumOfString(String str) {
        String result = "";
        int valueOfSteps = 0;
        String[] strArr = str.split(" ");
        int[] intOfStrArr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            intOfStrArr[i] = Integer.parseInt(strArr[i]);
        }
        for (int i = 0; i < intOfStrArr.length; i++) {
            do {
                valueOfSteps += intOfStrArr[i] % 10;
                intOfStrArr[i] /= 10;
            } while ((intOfStrArr[i] != 0));
            intOfStrArr[i] += valueOfSteps;
            valueOfSteps = 0;
        }
        Arrays.sort(intOfStrArr);

        for (int i : intOfStrArr) {
            result += Integer.toString(i) + " ";
        }
        return result;
    }

    public static String sumOfString2(String str) {
        String result = "";
        String[] strArr = str.split(" ");
        int[] intArr = new int[strArr.length];
        int sum = 0;

        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[i].length(); j++) {
                sum += Integer.parseInt(strArr[i].substring(j, j + 1));
            }
            intArr[i] = sum;
            sum = 0;
        }
        Arrays.sort(intArr);

        for (int i : intArr) {
            result += Integer.toString(i) + " ";
        }
        return result;
    }
}

