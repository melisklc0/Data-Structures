package Arrays;

public class HighArrayApp {
    public static void main(String[] args) {
        int maxSize=100;
        HighArray dizi=new HighArray(maxSize);

        dizi.insert(77);
        dizi.insert(99);
        dizi.insert(44);
        dizi.insert(55);
        dizi.insert(88);
        dizi.insert(22);
        dizi.insert(81);
        dizi.insert(11);
        dizi.insert(66);
        dizi.insert(33);
        //arka planda dizi oluşturup elemanları ekledi, eleman sayısını belirledi

        dizi.display();

        int searchKey=55;
        if (dizi.find(searchKey))
            System.out.println(searchKey + " Bulundu.");
        else
            System.out.println(searchKey + " Bulunamadı.");

        dizi.delete(88);
        dizi.delete(66);
        dizi.delete(99);
        dizi.display();

    }
}
