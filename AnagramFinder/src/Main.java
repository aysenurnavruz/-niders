import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Anagramını bulmak istediğiniz kelimeyi giriniz: ");
        String word = input.nextLine();
        findAnagrams(word, "");

    }
    public static void findAnagrams(String remaining, String current) {
        if (remaining.length() == 0) {
            System.out.println(current);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            char chosenChar = remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            findAnagrams(newRemaining, current + chosenChar);
        }
    }
}