package LinkList;

public class LinkListApp {
    public static void main(String[] args){

        LinkList theList = new LinkList();

        theList.insertToHead(22);
        theList.insertToHead(44);
        theList.insertToHead(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayList();

        theList.deleteFromHead();
        theList.deleteFromHead();



        theList.displayList();

    }
}
