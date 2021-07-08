package Template;
/*
模板方法模式
处理具体事务的时候有些算法和逻辑并不知道怎么处理，可以交给子类
范例是io种的inputstream和outputstream
*/

//设计
public class TemplateMain {
    public static void main(String[] args) {
        AbstractDisplay play1=new StringDisplay("hello,world");
        AbstractDisplay play2=new CharDisplay('a');
        play1.display();
        play2.display();
    }
}
abstract class AbstractDisplay{
    abstract void open();
    abstract void print();
    abstract void close();
    final void display(){
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
class StringDisplay extends AbstractDisplay{
    private final String str;

    public StringDisplay(String str) {
        this.str = str;
    }

    @Override
    void open() {
        printLine();
    }

    @Override
    void print() {
        System.out.println("|"+str+"|");
    }

    @Override
    void close() {
        printLine();
    }
    void printLine(){
        for(int i=0;i<str.length();i++){
            if(i==0||i==str.length()-1) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
    }
}
class CharDisplay extends AbstractDisplay{
    final private char ar;

    @Override
    void open() {
        System.out.println("<<<<<<<");
    }

    @Override
    void print() {
        System.out.println(ar);
    }

    @Override
    void close() {
        System.out.println(">>>>>>>");
    }

    public CharDisplay(char ar) {
        this.ar = ar;
    }
}
