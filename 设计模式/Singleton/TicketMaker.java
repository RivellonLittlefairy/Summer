package Singleton;
//设计一个售票机单例类，getNextTicketNumber方法会返回1000，1001，1002.....的数列
/*
不懂的地方
1.synchronized加锁关键字具体细节
2.volatile关键字的含义
3.DCL方法失效的情况
*/
public class TicketMaker {
    static TicketMaker ticketMaker=new TicketMaker();
    //饿汉式，类加载阶段即生成了单例实例，浪费了内存
    //优点是线程安全，并且不用上锁
    int ticket=1000;
    private TicketMaker(){}
    public static TicketMaker getTicketMaker(){
        return ticketMaker;
    }
    public int getNextTicketNumber(){
        return ticket++;
    }
}
class LazyLoadingTicketMaker { static LazyLoadingTicketMaker ticketMaker;
    //懒汉式，第一次调用生产实例的时候才会new一个tickerMaker
    //优点是避免了饿汉式的内存浪费
    // 缺点是需要synchronized对get方法加锁，在多线程情况下每次调用方法都需要等待上一次释放锁，时间效率下降
    int ticket=1000;
    private LazyLoadingTicketMaker(){}
    public static synchronized LazyLoadingTicketMaker getTicketMaker(){
        if(ticketMaker==null){
            ticketMaker=new LazyLoadingTicketMaker();
        }
        return ticketMaker;
    }
    public int getNextTicketNumber(){
        return ticket++;
    }
}
class InnerClassTicketMaker{
    //内部类/登记式实现单例模式
    //懒汉式创建实例，但是具有饿汉式时间效率高的优点
    //实现方法是通过内部类产生实例，当第一次调用get方法时候才对内部类进行加载操作
    private InnerClassTicketMaker(){}
    private static class Inner{
        public static final InnerClassTicketMaker ticketMaker=new InnerClassTicketMaker();
    }
    public static InnerClassTicketMaker getTicketMaker(){
        return Inner.ticketMaker;
    }
}
class DCLTicketMaker{
    //DCL 意即为 Double-chock-locking 双重校验锁
    //懒汉式枷锁方式，避免内存浪费的同时，提升了get实例方法的效率
    //实现方法是只有在没有ticketMaker实例的时候，才对对象加锁
    static volatile DCLTicketMaker ticketMaker;
    int ticket=1000;
    private DCLTicketMaker(){}
    public static synchronized DCLTicketMaker getTicketMaker(){
        if(ticketMaker==null){
            synchronized (DCLTicketMaker.class){
                if(ticketMaker==null) ticketMaker=new DCLTicketMaker();
            }
        }
        return ticketMaker;
    }
    /*
    DCL是完美的解决了单例模式中性能和资源浪费的问题，但是DCL在并发情下也会存在一个问题，因为Jvm指令是乱序的；
     情况如下：
     线程1调用getInstance 获取对象实例，因为对象还是空未进行初始化，此时线程1会执行new Singleton()进行对象实例化，而当线程1的进行new Singleton()的时候JVM会生成三个指令。
     指令1:分配对象内存。
     指令2:调用构造器，初始化对象属性。
     指令3:构建对象引用指向内存。
     因为编译器会自作聪明的对指令进行优化， 指令优化后顺序会变成这样:
     1、执行指令1：分配对象内存，
     2、执行指令3：构建对象引用指向内存。
     3、然后正好这个时候CPU 切到了线程2工作，而线程2此时也调用getInstance获取对象，那么线程2将执行下面这个代码 if (singleton == null)，
     此时线程2发现对象不为空（因为线程1已经创建对象引用并分配对象内存了），那么线程2会得到一个没有初始化属性的对象（因为线程1还没有执行指令2）。
     所以在这种情况下，双检测锁定的方式会出现DCL失效的问题。
    */
}