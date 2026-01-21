public class Higharray {
    private long[] dizi;
    private int elemanSayisi;

    public Higharray(int maxSize){
        dizi=new long[maxSize];
        elemanSayisi=0;
    }

    public void insert(long value){
        dizi[elemanSayisi]=value;
        elemanSayisi++;
    }

    public boolean find(long searchKey){
        int i;
        for (i=0;i<elemanSayisi;i++)
            if (dizi[i]==searchKey)
                break;
        if (i==elemanSayisi)
            return false;
        else
            return true;
    }
    public boolean delete(long value){
        int i;
        for (i=0;i<elemanSayisi;i++)
            if (dizi[i]==value)
                break;
        if (i==elemanSayisi)
            return false;
        else{
            for (int j = i; j <elemanSayisi ; j++)
                dizi[j]=dizi[j+1];
            elemanSayisi--;
            return true;
        }
    }

    public void display(){
        for (int i = 0; i < elemanSayisi; i++)
            System.out.print(dizi[i]+ " ");
        System.out.println(" ");

    }
}
