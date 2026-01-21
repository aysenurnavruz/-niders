
public class Main {
    public static void main(String[] args) {
        int[] array = {12,11,13,5,6,7};
        System.out.println("Başlangıctaki dizi: ");
        printArray(array);

        quickSort(array, 0,array.length-1);

        System.out.println("\nSıralanmış dizi: ");
        printArray(array);
    }
    //quicksort algoritması
    static void quickSort(int[] array, int low , int high){
        if (low<high){
            //pivot elemanını seç
            int pivotIndex = partition(array , low, high);

            //pivotun etrafındaki alt dizileri sırala
            quickSort(array, low, pivotIndex-1);
            quickSort(array, pivotIndex+1, high);
        }
    }
    //pivot elemanını seçme ve diziyi bölme

    static int partition(int[] array, int low, int high){
        int pivot = array[high];
        int i =(low-1);

        for (int j = low; j <high ; j++) {
            //pivottan küçük elemanları sol tarafa yerleştir
            if (array[j]<pivot){
                i++;
                swap(array,i,j);
            }
        }
        //pivotu doğru konuma yerleştir
        swap(array,i+1,high);
        return i+1;
    }
    //dizideki iki elemanı yer değiştirme
    static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i]= array[j];
        array[j]= temp;
    }
    //diziyi ekrana yazdırma
    static void printArray(int[] array){
        for (int value:array) {
            System.out.print(value+ " ");


        }
        System.out.println();
    }
}