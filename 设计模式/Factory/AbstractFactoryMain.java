package Factory;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/*
 抽象工厂模式与工厂方法模式不同点
 工厂方法模式中的也从所有具体的工厂中抽象出了一个工厂接口/抽象类
 但是在工厂方法模式中只需要有一个方法也就是creat生产产品方法就可以了
 与其不同的是在抽象工厂模式中，抽象出的抽象工厂规定了具体工厂能生产哪些零件
 这样设计可以反映不同的产品之间的联系，例如生产电脑的工厂生产了许多种电脑的零件，这些零件组装才能成为电脑
 如果以工厂方法模式来做则会出现生产戴尔显示器，戴尔鼠标，雷蛇鼠标，雷蛇显示器等等诸多厂商
 利用抽象工厂模式可以直接抽象为雷蛇工厂，戴尔工厂这两种
*/
/*
抽象工厂模式增加新的工厂十分简单只需要创建新的具体的工厂和其相应的产品就可以了
但是增加新的组件十分麻烦，例如vr成为刚需，顶层的抽象工厂接口就需要增加生产vr的方法，导致实现了该接口的所有厂商都需要改变
 */
public class AbstractFactoryMain {
    public static void main(String[] args) {
        AbstractFactory dell=new DellFactory();
        dell.createDisplay().play();
        dell.createMouth().click();

        AbstractFactory snake=new SnakeFactory();
        snake.createDisplay().play();
        snake.createMouth().click();
    }
}
//下面三个接口抽象出了工厂和产品
interface AbstractFactory{
    Mouth createMouth();
    Display createDisplay();
}
interface Mouth{
    void click();
}
interface Display{
    void play();
}
//下面两个具体的工厂
class DellFactory implements AbstractFactory{
    @Override
    public Mouth createMouth() {
        return new DellMouth();
    }

    @Override
    public Display createDisplay() {
        return new DellDisplay();
    }
}
class SnakeFactory implements AbstractFactory{
    @Override
    public Mouth createMouth() {
        return new SnakeMouth();
    }

    @Override
    public Display createDisplay() {
        return new SnakeDisplay();
    }
}

//下面四个类分别代表了具体的产品
class DellMouth implements Mouth {
    @Override
    public void click() {
        System.out.println("戴尔鼠标被使用了");
    }
}
class DellDisplay implements Display{
    @Override
    public void play() {
        System.out.println("戴尔显示器开启了");
    }
}
class SnakeMouth implements Mouth {
    @Override
    public void click() {
        System.out.println("雷蛇鼠标被使用了");
    }
}
class SnakeDisplay implements Display{
    @Override
    public void play() {
        System.out.println("雷蛇显示器开启了");
    }
}

