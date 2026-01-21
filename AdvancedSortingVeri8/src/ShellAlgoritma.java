public class ShellAlgoritma {
    public static void main(String[] args) {

        int[] array = {12,11,13,5,6,7};
        System.out.println("Başlangıctaki dizi: ");
        printArray(array);

        shellSort(array);

        System.out.println("\nSıralanmış dizi: ");
        printArray(array);
    }
    static void shellSort(int[] array){
        int n = array.length;

        for (int gap = n/2; gap >0 ; gap/=2) {
            //alt dizileri sırala (insertion sort)
            for (int i = gap; i <n ; i++) {
                int temp = array[i];
                int j;
                for (j=i;j>=gap && array[j-gap]>temp;j-=gap){
                    array[j]=array[j-gap];
                }
                array[j]=temp;


            }

        }
    }
    static void printArray(int[] array){
        for (int value:array) {
            System.out.print(value+ " ");


        }
        System.out.println();
    }

}
