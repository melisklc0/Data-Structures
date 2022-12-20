package Arrays;

public class ArrayApp {

    public static void main(String[] args) {
        long[] dizi = new long[100];
        int ElemanSayisi = 0;
        int j; // döngüde kullanıcaz, şimdiden tanımladık
        long SearchKey; //arama yapmak için kullanıcaz

//---------------------------------- Ekleme
        dizi[0]=77;
        dizi[1]=99;
        dizi[2]=44;
        dizi[3]=55;
        dizi[4]=22;
        dizi[5]=88;
        dizi[6]=11;
        dizi[7]=20;
        dizi[8]=66;
        dizi[9]=33;

        ElemanSayisi=10;
//---------------------------------- Yazdırma
        for (j = 0; j < ElemanSayisi; j++)
            System.out.print(dizi[j]+" ");

        System.out.println("");
//---------------------------------- Arama ve Silme
        SearchKey=22;
        for (j = 0; j <ElemanSayisi ; j++)
            if (dizi[j]==SearchKey)
                break;

        for (int k = j; k < ElemanSayisi; k++)
            dizi[k]=dizi[k+1]; //dizi boyutu 100 olduğu için burda out of bounds hatası almadık
        //sola kaydırma işlemi
        ElemanSayisi--;
//---------------------------------- Yeni diziyi yazdırma
        for (j = 0; j < ElemanSayisi; j++)
            System.out.print(dizi[j] + " ");

        System.out.println("");
        System.out.println(dizi.length);


    }
}
