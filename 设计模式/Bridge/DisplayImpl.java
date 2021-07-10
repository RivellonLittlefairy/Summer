package Bridge;
//DisplayImpl类是实现层次的抽象父类，规定了实现功能层次委托要求的具体类需要做什么
public abstract class DisplayImpl {
    public abstract void rawOpen();

    public abstract void rawPrint() ;

    public abstract void rawClose() ;
}
class StringDisplayImpl extends DisplayImpl{
    String str;

    public StringDisplayImpl(String str) {
        this.str = str;
    }

    @Override
    public void rawOpen() {
        System.out.print("+");
        for (int i = 0; i < str.length(); i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    @Override
    public void rawPrint() {
        System.out.println("|"+str+"|");
    }

    @Override
    public void rawClose() {
        System.out.print("+");
        for (int i = 0; i < str.length(); i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}