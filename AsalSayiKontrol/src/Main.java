import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Asallık kontrolü için sayıyı giriniz: ");
        int number = input.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " asal sayıdır.");
        } else {
            System.out.println(number + " asal sayı değildir.");
        }

    }

    public static boolean isPrime(int num) {
        return isPrimeRecursive(num, 2);
    }

    private static boolean isPrimeRecursive(int num, int divisor) {
        // bölen, sayının karekökünden büyükse asal
        if (divisor > Math.sqrt(num)) {
            return true;
        }

        // Sayı bölenlere bölünüyorsa asal değildir
        if (num % divisor == 0) {
            return false;
        }

        // Recursive olarak devam et
        return isPrimeRecursive(num, divisor + 1);
    }
}