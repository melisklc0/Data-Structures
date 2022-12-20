package Stack;

public class BracketChecker {
    private String input;

    public BracketChecker(String in){
        input=in;
    }

    public void check(){
        int stackSize = input.length();
        StackX theStack = new StackX(stackSize);

        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            switch (ch){
                case '{':
                case '[':
                case '(':
                    theStack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!theStack.isEmpty()) {
                        char popped = theStack.pop();
                        if ((ch == '}' && popped !='{') || (ch == ']' && popped !='[') ||(ch == ')' && popped !='(') )
                            System.out.println("Hata Yanlış Parantez: "+ ch + " İndis:" + i);
                    }
                    else
                        System.out.println("Hata Fazla Parantez Kapatılmış: "+ ch + " İndis:" + i);
                    break;
            }
        }
        if (!theStack.isEmpty())
            System.out.println("Hata: Sağ parantez eksik");
        //Açılan parantez kadar kapatılmalı
        //stackten pop ile açılan prantez sayısı çekildi
        //bu sayı kadar parantez kapanmış olmalı
        //kapatılmamışsa sağ parantez eksik kalır.
    }
}
