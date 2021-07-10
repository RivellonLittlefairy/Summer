package Bridge;
//Display为功能层次结构的父类
public class Display {
    //委托实现类DisplayImpl来进行操作
    private DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    protected void open(){
        impl.rawOpen();
    }

    protected void print(){
        impl.rawPrint();
    }

    protected void close(){
        impl.rawClose();
    }

    public void display(){
        open();
        print();
        close();
    }
}
//假如要增加新的功能，可以通过创建Display的子类来添加，这样就实现了开闭原则
class CountDisplay extends Display{
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }
    public void multiDisplay(){
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}

