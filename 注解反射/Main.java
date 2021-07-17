public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //Class的forName方法可以根据传入类名获取类的Class对象
        Class CA1=Class.forName("A");
        //Class实例中newInstance方法可以创建一个该类的实例
        A a1=new A();
        System.out.println(a1.equals(CA1.newInstance()));

        //一个类在内存中的Class对象只能有一个
        System.out.println(a1.getClass().equals(CA1));
    }
}
class A{
    int num=10;
    static {
        System.out.println("静态代码块执行");
    }

    public A() {
        System.out.println("构造方法执行");
    }
}
