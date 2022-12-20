package Stack;

import java.util.Scanner;
//import ile Scanner sınıfını programımıza dahil ettik
// artık onun methodlarını kullanabilir ve kullanıcıdan değerler alabiliriz.

public class BracketChecekerApp {
    public static void main(String[] args){
        String input;
        while(true){
            System.out.println("Parantez içeren metin giriniz");
            input = getString();
            if (input.equals(""))
                break;
            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check();;
        }

    }
    public static String getString(){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        // nextline geçerli satırı döndürdükten sonra tarayıcıyı otomatik olarak aşağı kaydırır.
        return s;
    }
}
