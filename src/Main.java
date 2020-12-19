import java.util.Scanner;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.Random;

public class Main {


    static int spf[];
    //static Random random = new Random();


    public static int zeroOneSeq(int a, int b) {
        if (a > b+1)
            return 0;
        if (a==0 || b==0)
            return 1;
        return zeroOneSeq(a,b-1)+zeroOneSeq(a-1,b-1);
    }


    public static boolean isPalindrome(String str, int left) {
        int right = str.length() - left - 1;
        if (str.charAt(left) != str.charAt(right))
            return false;
        if (left == right)
            return true;
        else
            return isPalindrome(str, left+1);
    }


    public static void sieve(int x) {

        spf = new int[x+1];

        spf[1] = 1;

        for (int i = 2; i < x+1; i++)
            spf[i] = i;
        for (int i = 4; i < x+1; i+=2)
            spf[i] = 2;

        for (int i = 3; i*i < x+1; i++) {
            if (spf[i] == i) {
                for (int j = i*i; j < x+1; j += i) {
                    if (spf[j] == j)
                        spf[j] = i;
                }
            }
        }

    }



    public static void printPrimeFactors(int x) {

        sieve(x);

        while (x != 1) {
            System.out.print(spf[x] + " ");
            x = x / spf[x];
        }

    }



    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите число для разбиения на простые множители: ");
        int factorizeNum = in.nextInt();

        in = new Scanner(System.in);

        System.out.print("Введите строку для проверки на палиндром: ");
        String palCandidate = in.nextLine();

        System.out.println("Введите числа a и b: ");
        int a = in.nextInt();
        int b = in.nextInt();

        in.close();

        System.out.print("Простые множители числа " + factorizeNum + " : ");
        printPrimeFactors(factorizeNum);

        System.out.print("\nЯвляется ли слово '" + palCandidate + "' палиндромом: ");


        if (isPalindrome(palCandidate, 0))
            System.out.println("Да");
        else
            System.out.println("Нет");

        System.out.println("Количество последовательностей 0 и 1: " + zeroOneSeq(a,b));

    }

}