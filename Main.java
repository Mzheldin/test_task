package testTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер элемента поледовательности");
        int numFib = scanner.nextInt();
        long start = System.currentTimeMillis();
        long result = calcFib(numFib);
        long end = System.currentTimeMillis() - start;
        System.out.println("Число " + result + " " + numFib + "-го элемента вычислено за " + (end / 1000) + " секунд");

        System.out.println("Введите число");
        int numPaly = scanner.nextInt();
        System.out.println("Соответствие числа " + numPaly + " палиному: " + isPalyndrom(numPaly));
    }

    static long calcFib(int n) {
        long first = 0;
        long second = 1;
        for (int i = 0; i < n; i++){
            long temp = second;
            second = first + second;
            first = temp;
        }
        return first;
    }

    static boolean isPalyndrom(int num) {
        int numLength = 0;
        int a = 1;
        while (num / a >= 1){
            numLength++;
            a *= 10;
        }

        if (numLength == 1 || num == 0)
            return true;
        if (num < 1)
            return false;

        int[] digits = new int[numLength];
        int temp = num;
        for (int i = 0; i < numLength; i++){
            digits[i] = temp % 10;
            temp /= 10;
        }

        for (int i = 0; i < digits.length; i++)
            if (digits[i] != digits[digits.length - 1 - i])
                return false;

        return true;
    }
}
