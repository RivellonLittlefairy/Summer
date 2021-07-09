package Factory;

import javax.xml.stream.FactoryConfigurationError;

public class FactoryMain {
    public static void main(String[] args) {
        //简单工厂模式调用
        SimpleFactory factory1=new SimpleFactory();
        Product p1=factory1.creatProduct("IDCard");
        p1.use();

        //工厂方法模式调用
        Factory factory2=new IDCardFactory();
        Product p2=factory2.creat();
        p2.use();
    }
}
//先写一个简单工厂模式，在这个模式中只有一个工厂负责生产所有的实例
class SimpleFactory{
    public Product creatProduct(String name){
        //这里体现了简单工厂模式的缺点，每次增加产品都要对工厂类进行修改，不符合开闭原则
        if(name=="IDCard") return new IDCard("simple factory card");


        throw new FactoryConfigurationError("产品名输入错误");
    }
    //也可以为每个产品写一个生产的方法，而不是集成到一个方法中进行判断
}
//接下来实现工厂方法模式，这种策略通过为每一个产品设置一个独有的工厂，从而避免了修改代码的情况出现
//这种方法的缺点是每有一个产品，就要为其设计一个工厂类，导致系统冗杂类太多
abstract class Factory{
    abstract Product creat();
}
class IDCardFactory extends Factory{
    @Override
    Product creat() {
        return new IDCard("factory method card");
    }
}
//定义产品的抽象类，所有产品均要继承此抽象类
abstract class Product{
    abstract void use();
}
class IDCard extends Product{
    String name;

    public IDCard(String name) {
        this.name = name;
    }

    @Override
    void use() {
        System.out.println("IDCard "+name+" be used");
    }
}

