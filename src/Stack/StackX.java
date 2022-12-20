package Stack;

public class StackX {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackX(int s){
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j){ //ekleme
        stackArray[++top]=j;
        //top değerini önce artır sonra kullan
    }

    public char pop(){ //silme
        return stackArray[top--];
        // top değerini kullan sonra azalt
    }

    public char peek(){ // top da ne olduğunu görme
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top==-1);
    }

    public boolean isFull(){
        return (top==maxSize-1);
    }
}
