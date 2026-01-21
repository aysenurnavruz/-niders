
public class Main {
    public static void main(String[] args) {
    int[] array={7,11,6,5,13,12};
        System.out.println("Başlangıçtaki dizi: ");
        printArray(array);
        mergeSort(array,0,array.length-1);

        System.out.println("\nSıralanmış dizi:");
        printArray(array);
    }
    //merge sort algoritması
    static void mergeSort(int[] array,int left, int right){
        if (left < right){
            //diziyi ortaya bölelim
            int middle = (left+right)/2;
            //sol tarafı sırala
            mergeSort(array,left,middle);
            //sağ tarafı sırala
            mergeSort(array,middle+1,right);
            //iki alt diziyi birleştir
            merge(array,left,middle,right);
        }
    }
    //iki alt diziyi birlşetirme
    static void merge(int[] array, int left, int middle,int right){
        //alt dizilerin boyutlarını hesapla
        int n1 = middle - left+1;
        int n2 = right-middle;
        //geçici diziler oluştur
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        //verileri geçici dizilere kopyala
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left+i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j]=array[middle+1+j];
        }
        //geçici dizileri birleştir
        int i =0 ,j=0,k=left;
        while (i<n1 && j<n2){
            if (leftArray[i]<= rightArray[j]){
                array[k]=leftArray[i];
                i++;
            }else{
                array[k]=rightArray[j];
                j++;
            }
            k++;
        }
        //geriye kalan elemanları kopyala
        while (i<n1){
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j<n2){
            array[k]=rightArray[j];
            j++;
            k++;
        }

    }
    //diziyi ekrana yazdırma
    static void printArray(int[] array){
        for (int value:array) {
            System.out.print(value+ " ");


        }
        System.out.println();
    }
}