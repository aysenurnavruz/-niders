public class Main {

    public static void main(String[] args) {
        long[] dizi={5,4,8,2,1};
        for (int i = 0; i < dizi.length-1 ; i++)
            for (int j = 0; j < dizi.length-i-1; j++)
                if (dizi[j]>dizi[j+1]){
                    long temp;
                    temp=dizi[j];
                    dizi[j]=dizi[j+1];
                    dizi[j+1]= temp;
                }
        for (int i = 0; i < dizi.length ; i++) {
            System.out.println(dizi[i]+ " ");

        }

    }


}
