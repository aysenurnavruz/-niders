import java.util.*;

public class SiralamaAlgoritmalari {
    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);

            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

   public static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);

            merge(array, low, mid, high);
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = array[low + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = low;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    public static void heapSort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }

    }
    public static void countingSort(int[] array) {
        int n = array.length;
        int max = Arrays.stream(array).max().orElse(0);

        int[] count = new int[max + 1];
        int[] output = new int[n];

        for (int value : array) {
            count[value]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        System.arraycopy(output, 0, array, 0, n);
    }
    public static void bubbleSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    public static void coctailSort(int[] array) {
        boolean swapped = true;
        int start = 0;
        int end = array.length;

        while (swapped) {
            swapped = false;

            for (int i = start; i < end - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            swapped = false;
            end--;

            for (int i = end - 1; i >= start; i--) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }

            start++;
        }
    }
    public static void radixSort(int[] array) {
        int max = Arrays.stream(array).max().orElse(0);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortForRadix(array, exp);
        }
    }

    private static void countingSortForRadix(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, array, 0, n);
    }
    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }
    public static void shakerSort(int[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i <= array.length - 2; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            swapped = false;
            for (int i = array.length - 2; i >= 0; i--) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
    public static void shellSort(int[] array) {
        int n = array.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }
    public static void bogoSort(int[] array) {
        while (!isSorted(array)) {
            shuffleArray(array);
        }
    }

    private static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }

    private static void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    public static void bozoSort(int[] array) {
        while (!isSorted(array)) {
            shuffleArray(array);
        }
    }
    public static void stoogeSort(int[] array, int l, int h) {
        if (l >= h) {
            return;
        }

        if (array[l] > array[h]) {
            int temp = array[l];
            array[l] = array[h];
            array[h] = temp;
        }

        if (h - l + 1 > 2) {
            int t = (h - l + 1) / 3;

            stoogeSort(array, l, h - t);
            stoogeSort(array, l + t, h);
            stoogeSort(array, l, h - t);
        }
    }
    public static void combSort(int[] array) {
        int n = array.length;
        int gap = n;

        boolean swapped = true;

        while (gap != 1 || swapped) {
            gap = getNextGap(gap);

            swapped = false;

            for (int i = 0; i < n - gap; i++) {
                if (array[i] > array[i + gap]) {
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }

    private static int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        return (gap < 1) ? 1 : gap;
    }
    public static void goroSort(int[] array) {
        int n = array.length;

        boolean swapped;

        do {
            swapped = false;

            // Çift elemanları sırala
            for (int i = 0; i < n - 1; i += 2) {
                if (array[i] > array[i + 1]) {
                    // Çift elemanları doğru sırala
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }

            // Tek elemanları sırala
            for (int i = 1; i < n - 1; i += 2) {
                if (array[i] > array[i + 1]) {
                    // Tek elemanları doğru sırala
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }

        } while (swapped);
    }
    public static void luckySort(int[] array) {
        Random random = new Random();

        while (!isSorted(array)) {
            // Diziyi karıştır
            for (int i = array.length - 1; i > 0; i--) {
                int index = random.nextInt(i + 1);
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }
    }
    public static void partialFlashSort(int[] array) {
        int n = array.length;
        int k = (int) (0.2 * n); // Parametre, dilediğiniz gibi ayarlanabilir

        int minValue = array[0];
        int maxValue = array[0];

        for (int i = 1; i < n; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        double interval = (double) (maxValue - minValue) / k;

        List<List<Integer>> buckets = new ArrayList<>(k);

        for (int i = 0; i < k; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int index = (int) ((array[i] - minValue) / interval);
            buckets.get(index).add(array[i]);
        }

        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                array[index++] = value;
            }
        }
    }
    public static void permSort(int[] array) {
        int n = array.length;

        do {
            for (int i = 0; i < n; i++) {
                int j = (int) (Math.random() * n);
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        } while (!isSorted(array));
    }
    public static void severalUniqueSort(int[] array) {
        int n = array.length;

        Set<Integer> uniqueValues = new HashSet<>();
        for (int value : array) {
            uniqueValues.add(value);
        }

        List<Integer> sortedUniqueValues = new ArrayList<>(uniqueValues);
        Collections.sort(sortedUniqueValues);

        int index = 0;
        for (int uniqueValue : sortedUniqueValues) {
            Arrays.fill(array, index, index + Collections.frequency(uniqueValues, uniqueValue), uniqueValue);
            index += Collections.frequency(uniqueValues, uniqueValue);
        }
    }












}
