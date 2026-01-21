public class OrderedArray {
    private long[] dizi;

    private int elemanSayisi;
    public OrderedArray(int max){
        dizi = new long[max];
        elemanSayisi=0;
    }

    public int size(){return elemanSayisi;}
    public void insert(long value){
        int j;
        for (j=0;j<elemanSayisi;j++)
            if (dizi[j]>value)
                break;
        for (int k =elemanSayisi; k>j ; k--)
            dizi[k]=dizi[k-1];
        dizi[j]=value;
        elemanSayisi++;
    }
    public int find(long searchKey){
        int lowerBound=0;
        int upperBound=elemanSayisi-1;
        int curIn;

        while(true) {
            curIn = (lowerBound + upperBound) / 2;
            if (dizi[curIn] == searchKey)
                return curIn;
            else if (lowerBound > upperBound)
                return elemanSayisi;
            else {
                if (dizi[curIn] < searchKey)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }
    public boolean delete(long value){
        int j=find(value);//önce ara ve bul
        if (j==elemanSayisi)
            return false;
        else {//bulundu
            for (int k = j; k <elemanSayisi; k++)
                dizi[k]=dizi[k+1];
            elemanSayisi--;
            return true;
        }
    }

    public void display(){
        for (int i=0;i<elemanSayisi;i++)
            System.out.print(dizi[i]+" ");
        System.out.println(" ");
    }

}
