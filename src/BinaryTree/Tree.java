package BinaryTree;

import java.util.Stack;

public class Tree {
    private Node root;

    public Tree() {
        root=null; //başlangıçta elemanı yok
    }

    public void insert(long data){  //SINAVDA KESİN ÇIKAR
        Node newNode = new Node();   //yeni düğüm
        newNode.data = data;         //veriyi ekle

        if(root==null)             //rootta hiç düğüm yoksa, başlangıç noktamı ekledim
            root=newNode;
        else {                    //root doluysa
            Node current = root;  //roottan başla (arada bağlantı kurdu)
            Node parent;          //parent değişkenini kaybetmemek için bu değişkeni oluşturduk
            while(true){
                parent = current;                   //parent = şu an dikkate alınan "konum
                if (data < current.data){           //sola?
                    current = current.leftChild;
                    //bunun aşağısındaki if e girmezse currenti sola geçirip tekrar başa dönmüş oluruz. tekrar kontrol ederiz
                    if (current == null){           //son düğüme gelinmişse
                        parent.leftChild = newNode; //sola ekle
                        return; //burda return dediğinde while(true) şartı sağlanmış olur ve döngüden çıkar, ekleme biter
                    }
                }  //end if sola?
                else {                                //ya da sağa?
                    current = current.rightChild;
                    if (current == null){             //son düğüme gelinmişse
                        parent.rightChild = newNode;  //sağa ekle
                        return;
                    }
                }  //end else sağa?
            }  //end while
        }  //end else root doluysa
    } //end insert

    public Node find(long data){              // ağaç yapısnın boş olmadığını farzedelim
        Node current = root;                 //root ile başla
        while(current.data != data){         // anahatar değerle eşleşme yoksa
            if (data < current.data)         //Sola mı gitmeliyiz?
                current = current.leftChild;
            else current = current.rightChild;  // ya da sağa mı gitmeliyiz?
            if (current == null)                //çocuk düğümler yoksa yani boşsa
                return null;                    //sayı bulunamadı
        }
        return current;                        //sayı bulundu
    }

    public void traverse(int traverseType){ //SINAVDA KESİN!! GELİR
        switch (traverseType) {
            case 1 -> {
                System.out.print("\n Preorder:");
                preOrder(root);
            }
            case 2 -> {
                System.out.print("\n InOrder:");
                inOrder(root);
            }
            case 3 -> {
                System.out.print("\n PostOrder:");
                postOrder(root);
            }
        }
        System.out.println("");
    }
    public void preOrder(Node localRoot){
        if (localRoot != null){
            System.out.print(localRoot.data + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    public void inOrder(Node localRoot){ //çağırımın nerden yapıldığı önemli /last in first out
        if (localRoot != null){
            inOrder(localRoot.leftChild); //kendini çağırıp left ine gidicek sürekli
            System.out.print(localRoot.data + " "); //leftine gittikten sonra visit yaptık
            inOrder(localRoot.rightChild); //şimdi de artık right ına gidicek
        }
    }

    public void postOrder(Node localRoot){
        if (localRoot != null){
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.data + " ");
        }
    }

    public Node minimum(){
        Node current = root;                //roottan başla
        Node last = null;
        while(current != null){             //sona kadar git
            last = current;                 //düğümü hatırla
            current = current.leftChild;    //sol çocuğa git
        }
        return last;
    }

    public boolean delete(long key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true; // booelan varsayılan=false olduğu için true yaptık

        //----Silinecek düğüm konumunu bulunuyor----//
        while (current.data != key) {
            parent = current; //silinecek düğümün parentı
            if (key < current.data) { //aranan değer curren.data dan küçük sola git
                isLeftChild = true; //silinecek sol çocuk
                current = current.leftChild;
            } else { //aranan değer curren.data dan büyük ya da eşit sağa git
                isLeftChild = false; //silinecek sağ çocuk
                current = current.rightChild;
            }
            if (current == null) //yeni sol ya da sağ çocuk boş mu dolu mu
                return false; //boşsa döngüden çık silincek düğüm current
        } //while
        // ***Silinecek düğüm bulundu***

        //-------durum1: Child Yoksa sadece sil--------------
        if (current.leftChild == null && current.rightChild == null) {
            //silinecek düğümün  sağ ve sol child düğümleri boşsa
            if (current == root) //düğüm kökse
                root = null;
            else if (isLeftChild) //silinecek sol çocuksa
                parent.leftChild = null; //parentın sol çocuğu silindiği için null, silinecek current=parent.leftChild
            else
                parent.rightChild = null; //parentın sağ çocuğu silindiği için null, silinecek current=parent.rightChild
        }

        //-------durum 2: Sağ Child yok Sol Child varsa  ------------------
        // *** Sağ child yoksa sol alt ağaçla yer değiştir ***
        //silinecek düğümün  sağ child düğümü boşsa
        else if (current.rightChild == null)
            if (current == root) //düğüm kökse
                root = current.leftChild;  //root=sol çocuk
            else if (isLeftChild)    //silincek parentın sol çocuğuysa
                parent.leftChild = current.leftChild;//parent sol çocuğuna silinecek düğümün sol çocuğunu ata
            else //silinecek parentın sağ çocuğuysa
                parent.rightChild = current.leftChild; //parent sağ çocuğuna silinecek düğümün sol çocuğunu ata

            // --------durum 2: Sol Child yok sağ child varsa -----------------
            // *** Sol Child yoksa sağ alt ağaçla yer değiştir ***
        else if (current.leftChild == null)
            if (current == root) //düğüm kökse
                root = current.rightChild; //root=sağ çocuk
            else if (isLeftChild) //silinecek parentın sol çocuğuysa
                parent.leftChild = current.rightChild; //parent sol çocuğuna silinecek düğümün sağ çocuğunu ata
            else
                parent.rightChild = current.rightChild; //parent sağ çocuğuna silinecek düğümün sağ çocuğunu ata

            //------------durum 3 -----------------------------
            // *** Silinecek düğümün hem sol hem sağ çocuğu da varsa ***
        else {
            Node successor = getSuccessor(current); // current silincek düğüm, silinecek düğüm yerine geçecek successor bul
            if (current == root)
                root = successor;
            else if (isLeftChild) //silinecek parentın sol çocuğuysa
                parent.leftChild = successor; //parentın leftchildına successsor ata
            else parent.rightChild = successor; //silinecek sağ çocuğuysa parentın rightchildına succesor ata
            successor.leftChild = current.leftChild; //successor ın sol çocuğu silinen düğümün sol çocuğu yap
        }
        return true;
    }

    private Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild; //önce silinecek düğümün sağ çocuğuna git

        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild; //sonra sürekli sol çocuğa git
        } //sol çocouk null olunca dur successor bulundu

        if (successor != delNode.rightChild) { //successor sağ alt çocuk değil, sağ çocuğun sol torunuysa
            successorParent.leftChild = successor.rightChild; //successor parent sol çocuğunu, successor sağ çocuğu yap
            successor.rightChild = delNode.rightChild; //successor sağ çocuğunu, silinecek düğümün sağ çocuğu yap
        }
        return successor;
    }

    public void displayTree() {
        Stack<Node> globalStack = new Stack<Node>(); // Global Stack Nesne Tipi Node
        globalStack.push(root); //global stack başlangıcı olarak root yerleştir
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (!isRowEmpty) { //satır boştan farklıysa çalış
            Stack<Node> localStack = new Stack<Node>(); // Local Stack
            isRowEmpty = true; //varsayılan değer olarak satır boş diye ata

            for (int j = 0; j < nBlanks; j++)
                System.out.print(' '); //32 karakter boşluk koy

            while (!globalStack.isEmpty()) { //global stack boş değilse
                Node temp = (Node) globalStack.pop(); //globalstackten Node Tipinde getir
                if (temp != null) { //temp doluysa stackten root-sol ç.-sağ ç. şeklinde veri çekilir.
                    System.out.print(temp.data); // root - sol çocuk -sağ çocuk şeklinde verileri yaz...
                    localStack.push(temp.leftChild); //locakstack e önce sol çocuğu yerleştir
                    localStack.push(temp.rightChild);// sonra sağ çocuğu yerleştir

                    if (temp.leftChild != null || temp.rightChild != null) //sağ ya da sol çocuk varsa isrowempty=false
                        isRowEmpty = false; //satır dolu
                }
                else { //temp nullsa
                    System.out.print("--");//boşsa  2 tire ata
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) //32 boşluk vardı sayılar arası şimdi 2 katı oldu
                    System.out.print(' ');
            } // end while globalStack boş değil
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop()); //global stacke local stackten gelenleri yerleştir(önce sağ düğm sonra sol düğüm)
        } // end while isRowEmpty false
        System.out.println("......................................................");
    }
}
