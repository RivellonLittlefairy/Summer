package ChainOfResponsibillty;
//职责链模式

//处理事务的时候如果有多种处理方法，可以采用中心话的处理模式即创造一个选择处理问题类的类，但是这样会导致需要一直修改中心处理类来适应新的处理方法
//于是采用职责链模式，优点是避免中心处理类的出现，可以动态的改变处理的顺序，使得处理方法类更加专注自己的工作易于修改
//缺点是会导致延迟，增加程序处理的时间

public class CORMain {
    public static void main(String[] args) {
        Support s1=new LimitSupport("s1",3);
        Support s3=new LimitSupport("s2",10);
        Support s2=new OddSupport("s3");
        s1.setNext(s2);
        s2.setNext(s3);
        Trouble t10=new Trouble(10);
        Trouble t1=new Trouble(1);
        Trouble t5=new Trouble(5);
        Trouble t50=new Trouble(50);
        s1.support(t10);
        s1.support(t1);
        s1.support(t5);
        s1.support(t50);


    }
}
//问题描述类，其中问题编号是决定谁处理问题的条件
class Trouble{
    private int number;

    public Trouble(int number) {
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    @Override
    public String toString() {
        return "Trouble{" +
                "number=" + number +
                '}';
    }
}
//Support类是用来解决问题的，它是职责链上的对象，写成抽象类是为了让子类来实现具体的对象解决怎样的问题
//这是模板方法的范例
abstract class Support{
    private String name;
    private Support next;
    public Support(String name){
        this.name=name;
    }
    public void setNext(Support next){
        this.next=next;
    }
    //在这里不直接输出是否处理成功，而是制作了done和fail方法是方便子类修改提示信息，符合开闭原则
    protected final void support(Trouble tr){
        if(resolve(tr)){
            done(tr);
        }else if(next!=null){
            next.support(tr);
        }else{
            fail(tr);
        }
    }
    protected abstract boolean resolve(Trouble tr);
    protected void done(Trouble tr){
        System.out.println(name+" resolve trouble "+tr.getNumber());
    }
    protected void fail(Trouble tr){
        System.out.println("can`t resolve trouble "+tr.getNumber());
    }
}
//第一个具体Support类用来解决问题编号小于某个数的问题
class LimitSupport extends Support{
    private int limit;
    public LimitSupport(String name,int limit) {
        super(name);
        this.limit=limit;
    }
    @Override
    protected boolean resolve(Trouble tr) {
        if(tr.getNumber()<=limit){
            return true;
        }
        return false;
    }
}
//第二个处理类用来解决问题编号为奇数的类
class OddSupport extends Support{
    public OddSupport(String name) {
        super(name);
    }
    @Override
    protected boolean resolve(Trouble tr) {
        if(tr.getNumber()%2==1){
            return true;
        }
        return false;
    }
}