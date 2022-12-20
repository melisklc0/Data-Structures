package HashChain;

import HashTable.DataItem;

class HashTable {
    private SortedList[] hashArray; //HashArray SortedList dizisi tipinde
    private int arraySize;

    public HashTable(int size)
    {
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for (int j = 0; j < arraySize; j++)
            hashArray[j] = new SortedList(); // Tüm dizi indisleri için head değerleri null atadık.
    }

    public void displayTable() {
        for (int j = 0; j < arraySize; j++)
        {
            System.out.print(j + ". ");
            hashArray[j].displayList();
        }
    }

    public int hashFunc(int key)
    {
        return key % arraySize;
    } //dizi boyutuna göre modunu aldık

    public void insert(int value)
    {
        DataItem theLink= new DataItem(value);
        int hashVal = hashFunc(value);
        hashArray[hashVal].insert(value);
    }

    public void delete(int key)
    {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key)
    {
        int hashVal = hashFunc(key);
        Link theLink = hashArray[hashVal].find(key);
        return theLink;
    }
}
