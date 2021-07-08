import java.io.*;
import java.util.HashMap;

//原型模式，通过clone方法复制实例而不是new 实例类名（）创建。
interface Product extends Cloneable{
    public abstract void use(String str);
    public abstract Product createClone();
    /*
     实现该接口的两个类一个采用了clone方法进行浅克隆，另一个采用序列化深克隆，
     浅克隆是将被复制的实例字段值直接复制到了新的实例中
     字段值是地址的话，会复制地址而不是创建新的对象，例如字段值是一个Map，则新旧实例指向同一个map
     解决方案是用IO方法进行深克隆,需要实现Serializable接口。
    */
}
public class PrototypeMain {
    public static void main(String[] args) {
        Manager manager=new Manager();
        Product p1=new ShowDouble();
        Product p2=new ShowUp();
        manager.registeer("p1",p1);
        manager.registeer("p2",p2);

        Product p3=manager.create("p1");
        Product p4=manager.create("p2");

        p3.use("msf");
        p4.use("msf");
    }
}
class Manager{
    HashMap map=new HashMap();
    public void registeer(String name,Product product){
        map.put(name, product);
    }
    public Product create(String name){
        Product p = (Product) map.get(name);
        return p.createClone();
    }
}
class ShowUp implements Product{
    @Override
    public void use(String str) {
        System.out.println(str.toUpperCase());
    }
    @Override
    public Product createClone() {
        Product p=null;
        try {
            p=(Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }finally {
            return p;
        }
    }
}
class ShowDouble implements Product,Serializable{
    @Override
    public void use(String str) {
        System.out.println(str+str);
    }

    @Override
    public Product createClone() {
        Product p=null;
        try {
            ByteArrayOutputStream BOS=new ByteArrayOutputStream();
            ObjectOutputStream OOS=new ObjectOutputStream(BOS);
            OOS.writeObject(this);

            ByteArrayInputStream BIS=new ByteArrayInputStream(BOS.toByteArray());
            ObjectInputStream OIS=new ObjectInputStream(BIS);
            p= (Product) OIS.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}
