package Proxy;

public class ProxyPrinter implements Printable{
    private String name;
    Printer real;
    public ProxyPrinter(String name) {
        this.name = name;
    }

    @Override
    //这里的set方法是设置打印机的名字，当real已经有值，也就是这个代理人已经指向了一个打印机，就需要抛弃上一个名字改为新name了
    public void setPrinterName(String name) {
        if(real!=null) real.setPrinterName(name);
        this.name=name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    //这个打印类需要加锁，否则在多线程下可能生成多个打印机实例，但是对print方法直接加锁会导致难以并发，因此剥离出实例化操作进行加锁
    public void print(String str) {
        realize();
        real.print(str);
    }

    private synchronized void realize() {
        if(real==null){
            real=new Printer(name);
        }
    }
}
