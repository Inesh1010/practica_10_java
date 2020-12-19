import java.util.Scanner;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.Random;

public class Main {


    static Random random = new Random();



    public static int amountOfNumbers(int k, int s) {

        int max_power = 1;

        for (int i = 1; i <= k; ++i) {
            max_power *= 10;
        }

        int result = 0;

        for (int i = max_power/10; i <= max_power-1; ++i) {
            if (digitsSum(i) == s)
                result++;
        }

        return result;

    }



    public static int digitsSum(int x) {
        if (x == 0)
            return x;
        return x%10 + digitsSum(x/10);

    }




    public static int gcd(int a, int b) {
        int max = max(a,b);
        int min = min(a,b);
        if (max % min == 0)
            return min;
        return gcd(min, max % min);
    }



    public static int power(int a, int n, int m) {

        int result = 1;

        a = a % m;

        while (n > 0) {
            if (n % 2 == 1)
                result = (result * a) % m;
            n = n / 2;
            a = (a * a) % m;
        }

        return result;

    }



    public static boolean isPrime(int p) {
        int a = 2 + random.nextInt(p-2);
        if (gcd(a,p) != 1)
            return false;
        return power(a,p-1, p) == 1;
    }




    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите числа k и s: ");
        int k = in.nextInt();
        int s = in.nextInt();

        System.out.print("Введите число для получения суммы цифр: ");
        int numToSum = in.nextInt();

        System.out.print("Введите число для проверки его простоты: ");
        int checkPrimeNum = in.nextInt();

        in.close();


        int amount = amountOfNumbers(k,s);
        int sumOfDigits = digitsSum(numToSum);
        boolean isPrimeNum = isPrime(checkPrimeNum);


        System.out.println("Количество чисел: " + amount);

        System.out.println("сумма цифр: " + sumOfDigits);


        System.out.print("Является ли " + checkPrimeNum + " простым числом: ");

        if (isPrimeNum)
            System.out.println("YES");
        else
            System.out.println("NO");

    }

}
