package Bridge;
/*
首先需要清楚类的两种层次结构  分别是类的功能层次结构和类的实现层次结构
属于功能层次结构的类是指规定了要做什么事情的类
属于实现层次结构的类是实现了所规定的功能的类
功能层次结构的扩展可以通过创建子类来实现，这样就能在不修改原有代码的情况下进行功能的增加
实现层次结构的扩展通过对接口或者抽象父类的实现来进行扩展
*/
/*
所谓bridge即桥梁模式是指通过委托和继承分别来将这两个层次以及层次间的扩展实现
委托即是指这个功能层次结构的实例知道要做什么，但是不知道怎么做，将具体的任务委托给实现层次结构的类来实现
例如Display类要实现显示的功能，它并不关心具体怎么实现，而是将实现的任务交给了自己的私有变量DisplayImpl实例
通过这个实例来进行显示的操作
继承即是对原有功能的扩展，要符合里氏替换原则
例如要想增加输出五边的功能，可以通过新建Display子类来实现
 */
public class BridgeMain {
    public static void main(String[] args) {
        Display d1=new Display(new StringDisplayImpl("hello china"));
        Display d2=new CountDisplay(new StringDisplayImpl("hello world"));
        CountDisplay d3=new CountDisplay(new StringDisplayImpl("hello earth"));

        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay();
    }
}
