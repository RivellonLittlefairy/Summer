package Adapter;
//适配器模式，多加一层来实现适配
//这里的样例采用电源提供220v交流电，但是电脑要20v直流电示例


//电源类
class Power{
    Electricity electricity;

    //这里的电源只提供220v交流电
    public Power() {
        electricity = new Electricity(false,220);
    }

    public Electricity supply(){
        return electricity;
    }
}
//电脑供电接口
class Computer implements user{
    //这里意思是只有传入20v直流电才能开机
    Electricity electricity;
    public Computer(Electricity electricity) {
        this.electricity=electricity;
    }
     public void check(){
        if(electricity.getV()==20&&electricity.isAC()) System.out.println("开启成功");
        else System.out.println("开机失败");
    }
}

interface user{
     void check();
}
//该模式的核心适配器
class ComputerAdapter extends Power implements user{
    public ComputerAdapter() {
        electricity = new Electricity(true,20);
    }

    @Override
    public void check() {
        if(electricity.getV()==20&&electricity.isAC()) System.out.println("开启成功");
        else System.out.println("开机失败");
    }
}
public class Adapter {
    public static void main(String[] args) {
        Power p=new Power();
        //先直接创建个电脑，观察是否成功开机
        user u1=new Computer(p.electricity);
        u1.check();
        //通过适配器来制造电脑
        user u2=new Computer(new ComputerAdapter().electricity);
        u2.check();


    }
}
