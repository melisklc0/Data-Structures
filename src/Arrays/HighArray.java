package Arrays;

public class HighArray {
    private long [] dizi;
    private int elemanSayisi;

    public HighArray(int max){
        dizi=new long[max];
        elemanSayisi=0;
    }

    public boolean find(long searchKey){
        int i;
        for (i = 0; i < elemanSayisi; i++)
            if (dizi[i]==searchKey)
                break;
        if (i==elemanSayisi)
            return false;
        else return true;
    }

    public void insert(long value){
        dizi[elemanSayisi]=value;
        elemanSayisi++;
    }

    public boolean delete(long value){
        int i;
        for (i = 0; i < elemanSayisi ; i++)
            if (value==dizi[i])
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
            System.out.print(dizi[i]+" ");
        System.out.println();
    }

}
