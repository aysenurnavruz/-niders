import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Polindromunu bulmak istediğiniz kelimeyi giriniz: ");
        String text = input.nextLine();

        if (isPalindrome(text)) {
            System.out.println(text + " is a palindrome.");
        } else {
            System.out.println(text + " is not a palindrome.");
        }

    }
    public static boolean isPalindrome(String str) {
        // boşlukları ve büyük-küçük harf farklarını göz ardı eder
        String cleanedStr = str.replaceAll("\\s", "").toLowerCase();
        return checkPalindrome(cleanedStr, 0, cleanedStr.length() - 1);
    }

    private static boolean checkPalindrome(String str, int start, int end) {
        // Temel durum: başlangıç ve bitiş indeksleri birbirine eşit veya geçmişse
        if (start >= end) {
            return true;
        }

        // Karakterler eşleşiyorsa, recursive olarak devam et
        if (str.charAt(start) == str.charAt(end)) {
            return checkPalindrome(str, start + 1, end - 1);
        } else {
            return false;
        }
    }
}