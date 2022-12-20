package AdvancedSort;

public class ArraySort {
    private long[] dizi;
    private int elemanSayisi;

    public ArraySort(int max){
        dizi = new long[max];
        elemanSayisi = 0;
    }

    public void insert(long d){
        dizi[elemanSayisi] = d;
        elemanSayisi++;
    }

    public void display() {
        for (int i = 0; i < elemanSayisi; i++)
            System.out.print(dizi[i] + " ");
        System.out.println();
    }


//-----------------------------------------------------------------------------------------------------------------
    

    private void recMergeSort(long[] workSpace, int lowerBound, int upperBound){
        if (lowerBound == upperBound)
            return; //1 eleman varsa sıralama yapma alt satırları çalıştırma (geldiğin yere geri dön)
        else {
            int mid = (lowerBound + upperBound) /2;
            recMergeSort(workSpace, lowerBound, mid); //ilk yarıyı sırala
            recMergeSort(workSpace,mid+1,upperBound); //son yarıyı sırala
            merge(workSpace, lowerBound,mid+1,upperBound); //birleştir

            //rekürsif stack mantığı ile çalışır, yani if durumuna kadar devamlı ikiye bölecek,
            // ona ulaştığında ise merge işlemlerinerine geçecek
        }
    }

    public void mergeSort() {
        long[] workSpace = new long[elemanSayisi];
        recMergeSort(workSpace,0,elemanSayisi - 1);
    }

    private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
        //birleştirme işlemlerini workSpace de yapıyoruz, bunu kullanmazsak değerler kaybolur

        int i = 0; //workspace dizisinin indis değeri
        int lowerBound =lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1; //eleman sayısı

        while (lowPtr <= mid && highPtr <= upperBound) //burası A+B nin sıralamasını yaptı
            if (dizi[lowPtr] < dizi[highPtr])
                workSpace[i++] = dizi[lowPtr++];
            else
                workSpace[i++] = dizi[highPtr++];

        //burdaki ++ lar bir sonraki konuma geçiş yapmak için kullanılır
        // atamaları yaptıktan sonra arttırıp sonraki değere geçeriz.

        while (lowPtr <= mid) //A da eleman kaldı mı?
            //sayılar karşılaştırılmasına rağmen dizinin sol tarafında eleman kalmış olabilir
            workSpace[i++] = dizi[lowPtr++];

        while (highPtr <= upperBound) //B de eleman kaldı mı?
            //sayılar karşılaştırılmasına rağmen dizinin sol tarafında eleman kalmış olabilir
            workSpace[i++] = dizi[highPtr++];

        //bu kısım kalan elemanları direkt dizinin geri kalanına geçiriyor, hocanın kırmızı yazdığı son kısım

        for (i = 0; i < n; i++)
            dizi[lowerBound + i] = workSpace[i]; //hangi konumda birleştirilecekse lowerBound ...
        //biz workspace i geçici olarak sıralama yapmak için kullandık, asıl dizimiz "dizi"
        //burda workspace i diziye geçiriyoruz.
        //neden lowerbound + i dedik? çünkü biz diziyi sürekli ikiye böldüğümüz için (sabit bişey değil) o lowerbound a göre yazmamız gerekir,
        //öbür türlü her seferinde sıfırdan başlarız ve yanlış yere atamış oluruz.
    }

//-----------------------------------------------------------------------------------------------------------------

   
    public void shellSort() {
        int i, j;
        long temp;
        int h = 1;
        while (h <= elemanSayisi / 3)
            h = h * 3 + 1; //1 4 13 40 121 .....
        while (h > 0) { //aralık değeri belirttiği için bu sıfır olduğu zaman kendisi olur o yüzden 1 e kadar kıyaslarız
            for (i = h; i < elemanSayisi; i++) {
                temp = dizi[i];
                j = i;

                while (j > h - 1 && dizi[j - h] >= temp) {
                    dizi[j] = dizi[j - h]; //j den h kadar önceki değer daha büyük j konumuna ata
                    j -= h;
                }
                dizi[j] = temp; // üstteki while döngüsü çalışmışsa dizi[i] daha küçüktür.
                // dizi[j] konumuna daha küçük değer atanır.
            }
            h = (h - 1) / 3; // h değerini azalt.
            // yeni h aralığına göre sayıları karşılaştır.
        }
    } //h 1 e geldiğinde bubble sort gibi çalışıyo


//-----------------------------------------------------------------------------------------------------------------


    private int partitionIt(int left, int right, long pivot){ //bölmeleme işlemi
        int leftPtr = left-1; //++leftPtr sonrası left olacak
        int rightPtr = right; //--rightPtr sonrası right -1 olacak
        while (true){
            //aşağıdaki while lar devamlı buluyor ve durmuyor
            while (dizi[++leftPtr]<pivot); //en büyük sayıyı bul
            while (rightPtr > 0 && dizi[--rightPtr] > pivot); //en küçük sayıyı bul
            if (leftPtr > rightPtr)
                break;
            else
                swap(leftPtr, right); //en büyük en küçük sayı yer değiştir
        }
        swap(leftPtr, right); //right (pivot u yerine yerleştir)
        return leftPtr;
    }

    private void swap(int index1, int index2){
        long temp = dizi[index1];
        dizi[index1] = dizi[index2];
        dizi[index2] = temp;
    }

    public void quickSort(){
        recQuickSort(0,elemanSayisi-1);
    }

    private void recQuickSort(int left, int right){
        if (right-left <=0) // boyut 1 ise
            return;         //zaten sıralıdır
        else{               // boyut 2 veya daha fazlaysa
            long pivot = dizi[right];
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition-1);
            recQuickSort(partition+1, right);
        }
    }

}
