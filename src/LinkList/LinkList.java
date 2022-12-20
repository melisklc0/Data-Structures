package LinkList;

public class LinkList {
    private Link head;
    private Link tail;

    public LinkList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
        //head == null ise true gönder
    }

    public void insertToHead(long d) {
        Link newLink = new Link(d);
        if (isEmpty())
            tail = newLink;
        newLink.next = head; //mevcut head yeni kaydın nexti
        head = newLink; //yeni head newLinki gösterir
    }

    //yeni gelecek linkin sonraki elemanı head olacak
    //yeni head bu oldu
    /*public void insertFirst(long d){
        Stack.Link newLink = new Stack.Link(d);
        newLink.next = head;
        head = newLink;
    }*/

    public void insertLast(long d) {
        Link newLink = new Link(d);
        if (isEmpty())
            head = newLink;
        else
            tail.next = newLink; //mevuct tail nexti yeni linki gösterecek
        tail = newLink; //tail artık yeni link olacak
    }


    public void deleteFromHead() { //long dönderiyodu hocanınkinde
        //long temp = head.data;
        if (head.next == null)//Listede tek eleman varsa
            tail = null;
        head = head.next;
        //return temp;
    }
    /*public long deleteFirst(){
        Link temp = head;
        head = head.next;
        return temp.data;
    }*/


    public void displayList() {
        System.out.print("Liste (head-->tail): ");
        Link current = head;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
