package Arrays;

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
        for (j = 0; j <elemanSayisi ; j++)
            if (dizi[j]>value)
            break;   //ekleme işleminden önce eklenecek yeri bulduk.
        for (int k = elemanSayisi; k > j; k--)
            dizi[k]=dizi[k-1];  //burda dizide yer açıyoruz. sağa kaydırdık. (5. indisi'i 6 yaptık gibi)

        dizi[j]=value;   //açtığımız yere ekleme yaptık. dizi slaytı 15. sayfa
        elemanSayisi++;
    }

    public boolean delete(long value) {
        int j = find(value); //önce aradı
        if (j == elemanSayisi) //bulunamadı
            return false;
        else { //bulundu
            for (int k = j; k < elemanSayisi; k++)
                dizi[k] = dizi[k + 1]; //silinen elemandan dolayı sola kaydırıyoruz.
            elemanSayisi--;
            return true;
        }
    }

    public int find(long searchKey){
        int lowerBound=0; //sol
        int upperBound=elemanSayisi-1; //sağ
        int curIn; //ortadaki değer
        //bunlar indis değerleri (sayısal değer değil)

        while (true){
            curIn=(lowerBound + upperBound) / 2;
            if (dizi[curIn] == searchKey)
                return curIn;
            else if (lowerBound > upperBound)
                return elemanSayisi;
            else {
                if (dizi[curIn] < searchKey)
                    lowerBound= curIn + 1;
                else
                    upperBound= curIn - 1;
                //buralarda aralığı daraltıyoruz
            }
        }
    }

    public void display(){
        for (int j = 0; j < elemanSayisi; j++)
            System.out.print(dizi[j]+" ");
        System.out.println();
    }

}

//app kısmını gelecek ders yapacak