package HashChain;
//Sıralı Linked List
//Küçükten büyüğe sıralı
class SortedList {
    private Link head;

    public SortedList() {
        head = null;
    }

    public void insert(int value) {
        Link theLink = new Link(value);
        Link previous = null;
        Link current = head;

        while (current != null && value > current.getKey()) { //value=100 currenttan büyük mü? uygun konum bul  0 10 200 -->0 10 100 200 thelink=100 previous=10 current=200; 10-200 arasına 100 geldi
            previous = current; //
            current = current.next; //value için uygun konum ara, bir sonraki değere geç
        } // value için uygun konum bulundu
        if (previous == null) //sayı ilk sayıdan büyükse
            head = theLink;
        else
            previous.next = theLink;
        theLink.next = current;
    }

    public void delete(int key) {
        Link previous = null;
        Link current = head;

        while (current != null && key != current.getKey()) {
            previous = current;
            current = current.next;
        }

        if (previous == null) //siliniecek sayı head, head=sonraki;
            head = head.next;
        else
            previous.next = current.next; //silincecek sayı aradaysa öncekinin nexti silinecek sayının nexti olacak
    }

    public Link find(int key) {
        Link current = head;

        while (current != null && current.getKey() <= key) { //aranan sayı bulunandan büyük olduğu sürece aramaya devam et
            if (current.getKey() == key)
                return current;
            current = current.next; // sonraki sayıya geç
        }
        return null;
    }

    public void displayList() {
        System.out.print("List (head-->tail): ");
        Link current = head; //en baştan başla
        while (current != null) {
            current.displayLink();
            current = current.next; //bir sonrakini göster
        }
        System.out.println("");
    }
}