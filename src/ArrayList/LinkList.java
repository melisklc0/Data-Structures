package ArrayList;

public class LinkList {
    private Link head;

    public LinkList() {
        head = null;
    }

    public void insertToHead(int id, double dd){
        Link newLink = new Link(id,dd);
        newLink.next = head;
        head = newLink;
    }
    // 8 Nolu Slayt Uygulama
    // Başa Link Ekleme Bitti

    public Link deleteFirst(){
        Link temp = head;
        head = head.next;
        return temp;
    }
    // 10 Nolu Slayt Uygulama
    // Baştan Link Silme Bitti

    public void displayList(){
        System.out.println("Liste");
        Link current = head;
        while ( current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public boolean isEmpty(){
       /* boolean durum=false;
        if (head == null) durum=true;
        return durum; */
        return (head == null);
        //head null olunca true gönder
    }
}
