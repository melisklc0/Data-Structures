package HashTable;

public class HashTable {
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem; // Silinen konumu belirtiyor. 5 sayı kümelenmiş olsun. 3. silindi geriye kalan 2 sayıyı aramaya devam etsin diye 3. sayı -1 yapılır
    private int elemanSayisi = 0;

    public HashTable(int size){
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1); //silinen sayı -1 yapılır böylece null olmadığı için aramaya devam edilir.
    }

    public void displayTable(){
        System.out.print("Tablo");
        for(int i = 0; i < arraySize; i++){
            if(hashArray[i] != null)
                System.out.print(hashArray[i].getKey() + " ");
            else
                System.out.print("** "); //boş yerleri ** olarak göster
        }
        System.out.println("");
    }

    public int hashFunction(int key){
        return key % arraySize;
    }

    public void insert(DataItem item){
        boyutkontrol();
        int key = item.getKey();
        int hashVal = hashFunction(key);

        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
            ++hashVal; // Linear Probing +1 +1 şeklinde...
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
        elemanSayisi++;
    }

    public void boyutkontrol(){
        int hashVal;
        int tempElemanSayisi = 0;
        if (elemanSayisi >= (arraySize * 2 / 3)){ //REHASHING
            int tempSize = asalGetir(arraySize * 2); //dizi boyutu 2 katına en yakın asal sayı değerine göre artırıldı tempSize değişkeni
            DataItem[] tempHash = new DataItem[tempSize];
            for (int i = 0; i<arraySize; i++){
                if(hashArray[i] != null && hashArray[i].getKey() != -1){//önceki dizide boş olmayan değeri bul
                    hashVal = hashArray[i].getKey() % tempSize; // yeni boyuta göre konum bulunuyor
                    while (tempHash[hashVal] != null && tempHash[hashVal].getKey()!= -1){//yeni dizide atanacak konum dolu ya da silinmi değer varsa
                        ++hashVal; //hash değerini 1 artır
                        hashVal %= tempSize; //yeni dizi boyutuna göre modunu al konumu belirle
                    }//while
                    //yeni atanacak dizi konumu bulundu değer atanıyor...
                    tempHash[hashVal]=hashArray[i]; //yeni diziye eski dizi değerlerini ata.
                    tempElemanSayisi++;
                }//if
            }//for
            hashArray = tempHash; // hasArray yeni dizi olan tempHash gösteriyor
            elemanSayisi = tempElemanSayisi; //elemansayısı güncellendi
            arraySize = tempSize; //dizi boyutu iki katına en yakın asal sayı değeri olarak güncellendi
        }//if rehashing
    }

    private int asalGetir(int min){
        for (int j=min; true; j++) //sürekli çalış return parametresiyle çık. dizi boyutundan daha büyük asal sayı bul
            if(asalMi(j))
                return  j;
    }
    private boolean asalMi(int n){
        for (int j =2 ;(j*j <=n);j++) //j<=karekök(n) değerleri için kontrol et
            if(n%j == 0)
                return false;
        return true;
    }

    public  DataItem delete(int key){
        int hashVal = hashFunction(key);

        while (hashArray[hashVal]!=null){
            if (hashArray[hashVal].getKey()==key){
                DataItem temp = hashArray[hashVal]; //silinecek konum
                hashArray[hashVal]=nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key){
        int hashVal = hashFunction(key);
        while(hashArray[hashVal]!=null){
            if (hashArray[hashVal].getKey()==key)
                return hashArray[hashVal];
            ++hashVal;//sonraki konuma bak
            hashVal %= arraySize;
        }
        return null;
    }

}
