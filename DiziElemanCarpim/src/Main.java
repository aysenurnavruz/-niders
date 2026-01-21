import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dizinin uzunluğunu girin: ");
        int length = scanner.nextInt();
        int[] arr = new int[length];

        System.out.println("Dizinin elemanlarını girin: ");
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Elemanların çarpımı: " + DiziCarpim(arr));


    }
    public static int DiziCarpim(int[] arr) {
        if (arr.length == 0) {
            return 1;
        }

        int sonEleman = arr[arr.length - 1];
        int[] subArray = Arrays.copyOf(arr, arr.length - 1);

        return sonEleman * DiziCarpim(subArray);
    }
}