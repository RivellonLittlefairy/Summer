package Proxy;
/*
proxy意思是代理，代理模式设计的初衷是为了让类在非必要时不必初始化，通过代理人完成它的工作就行
特别注意调用者并不知道自己调用的是代理人还是本体
这里采用了打印机打印一串字符为例子，打印机初始化需要很长时间，为了使只在必须要打印时候再初始化，采用了代理模式



复习要点
1.代理思想
2.代理人实例本体的加锁方案
3.利用反射在代理类不知道本体是谁的情况下调用他
*/

//抽象出实际执行者和代理人的共同点写成接口，用以规范和主类调用
interface Printable{
    void setPrinterName(String name);
    String getPrinterName();
    //这个print方法用于打印字符串，代理类也要有这个方法，原因是要客户端会使用这个方法，但是不能让他直接用本体
    void print(String str);
}


//主方法作为测试类
public class ProxyMain {
    public static void main(String[] args) {
        //客户端直接调用代理人
        Printable p1=new ProxyPrinter("Alice");
        System.out.println("打印机名字是"+p1.getPrinterName());
        p1.setPrinterName("bob");
        System.out.println("打印机名字是"+p1.getPrinterName());
        p1.print("hello world");
    }
}
