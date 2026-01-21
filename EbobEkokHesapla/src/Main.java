import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1.sayıyı giriniz: ");
        int num1 = input.nextInt();
        System.out.println("2.sayıyı giriniz: ");
        int num2 = input.nextInt();

        int ebob = findebob(num1, num2);
        int ekok = findekok(num1, num2);

        System.out.println("EBOB(" + num1 + ", " + num2 + ") = " + ebob);
        System.out.println("EKOK(" + num1 + ", " + num2 + ") = " + ekok);
    }
    public static int findebob(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findebob(b, a % b);
        }
    }

    public static int findekok(int a, int b) {
        return (a * b) / findebob(a, b);
    }
}