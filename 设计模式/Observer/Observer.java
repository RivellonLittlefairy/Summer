package Observer;
//观察者模式
//定义对象间一种一对多的依赖关系，使得当每一个对象改变状态，则所有依赖于它的对象都会得到通知并自动更新。
//设想一个简单的游戏地图里有主角和一个陷阱，当主角踩到陷阱就会对主角造成伤害，要实现这个功能可以让陷阱不断检测主角的位置，重合之后就触发事件
//但这样的缺点是会造成程序不断空转浪费时间，解决策略就是设计成观察者模式主角踩到陷阱才触发相应的事件
//spring中的mvc模型中模型与视图的关系就属于观察者模式
//定义一个抽象事件源Subject和观察者接口Observer，通过继承和实现就能实现观察者模式
public class Observer {
    public static void main(String[] args) {
        Subject subject=new NumberGenerator(10,10,50);
        ObserverInterface observer1=new GraphObserver();
        ObserverInterface observer2=new GraphObserver();
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.execute();
    }
}
