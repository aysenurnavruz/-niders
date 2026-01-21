import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arraySizes =new int [1000]; // Dizi boyutları

            int[] array = generateRandomArray(arraySizes);


            measureAndPrintTime("Selection Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Quick Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Merge Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Heap Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Counting Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Bubble Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Coctail Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Radix Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Insertion Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Shaker Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Shell Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Bogo Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Bozo Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Goro Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Lucky Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Stooge Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Partial Flash Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Perm Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Several Unique Sort", Arrays.copyOf(array, array.length));
            measureAndPrintTime("Comb Sort", Arrays.copyOf(array, array.length));

            System.out.println("-------------------------------");
        }



    public static void measureAndPrintTime(String algorithm, int[] array) {
        long startTime = System.currentTimeMillis();

        switch (algorithm) {
            case "Selection Sort":
                SiralamaAlgoritmalari.selectionSort(array);
                break;
            case "Quick Sort":
                SiralamaAlgoritmalari.quickSort(array, 0, array.length - 1);
                break;
            case "Merge Sort":
                SiralamaAlgoritmalari.mergeSort(array, 0, array.length - 1);
                break;
            case "Heap Sort":
               SiralamaAlgoritmalari.heapSort(array);
                break;
            case "Counting Sort":
                SiralamaAlgoritmalari.countingSort(array);
                break;
            case "Bubble Sort":
                SiralamaAlgoritmalari.bubbleSort(array);
                break;
            case "Coctail Sort":
                SiralamaAlgoritmalari.coctailSort(array);
                break;
            case "Radix Sort":
                SiralamaAlgoritmalari.radixSort(array);
                break;
            case "Insertion Sort":
                SiralamaAlgoritmalari.insertionSort(array);
                break;
            case "Shaker Sort":
                SiralamaAlgoritmalari.shakerSort(array);
                break;
            case "Shell Sort":
                SiralamaAlgoritmalari.shellSort(array);
                break;
            case "Bogo Sort":
                SiralamaAlgoritmalari.bogoSort(array);
                break;
            case "Bozo Sort":
                SiralamaAlgoritmalari.bozoSort(array);
                break;
            case "Goro Sort":
                SiralamaAlgoritmalari.goroSort(array);
                break;
            case "Lucky Sort":
               SiralamaAlgoritmalari.luckySort(array);
                break;
            case "Stooge Sort":
               SiralamaAlgoritmalari.stoogeSort(array, 0, array.length - 1);
                break;
            case "Partial Flash Sort":
                SiralamaAlgoritmalari.partialFlashSort(array);
                break;
            case "Perm Sort":
                SiralamaAlgoritmalari.permSort(array);
                break;
            case "Several Unique Sort":
                SiralamaAlgoritmalari.severalUniqueSort(array);
                break;
            case "Comb Sort":
                SiralamaAlgoritmalari.combSort(array);
                break;

            default:
                System.out.println("Geçersiz algoritma adı!");
                break;
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println(algorithm + " Süresi: " + elapsedTime + " milisaniye");
    }


    private static int[] generateRandomArray(int[] dizi) {
        Random random = new Random();
        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = random.nextInt(1000); // Dizinin elemanları 0-999 arasında rastgele sayılar
        }
        return dizi;
    }

}




