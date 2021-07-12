package Iterator;
//迭代器模式，通过hasNext方法和next方法遍历集合
public class IteratorMain {
    public static void main(String[] args) {
        Book b1=new Book("b1");
        Book b2=new Book("b2");
        Bookshelf bs=new Bookshelf();
        Iterator iterator=bs.iterator();
        while(iterator.hasNext()){
            System.out.println("第一次"+iterator.next());
        }
        bs.add(b1);
        bs.add(b2);
        iterator=bs.iterator();
        while(iterator.hasNext()){
            System.out.println("第二次"+iterator.next());
        }
    }
}
//编写迭代器接口，规范了迭代器要实现的所有功能
interface Iterator{
    boolean hasNext();
    Object next();
}
