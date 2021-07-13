package Proxy;

public class Printer implements Printable{
    private String name;

    //为了模拟大型系统初始化需要很长时间，这里在构造方法中让printer类休眠五秒
    public Printer(String name) {
        heavyJob();
        this.name = name;
    }

    private void heavyJob(){
        System.out.print("do heavy job  ");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void setPrinterName(String name) {
        this.name=name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }
}