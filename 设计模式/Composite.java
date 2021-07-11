import java.util.ArrayList;

//composite意为组合，目的是解决组件递归问题
/*
组合模式解决了容器与内容物体的一致性问题，通过抽象出他们所具有的共同特点，也就是编写抽象类的方法来实现他们的递归放置问题
文件夹和文件系统是最典型的应用，文件夹中包含着文件和文件夹，两者有共同点也有不同点
 */
/*
处理共同点的方法很简单只需要在抽象出来的父类中写明抽象方法交给子类实现具体即可
处理不同点的策略有很多种，这里采用了在抽象类中写明但是抛出异常的策略，也可以不抛出异常什么都不做，或者同样定义为抽象方法
也可以不定义交给子类取舍
 */
public class Composite {
    public static void main(String[] args) {
        Entry root=new Directory("root");
        Entry bin=new Directory("bin");
        root.add(new File("tmp",10));
        root.add(bin);
        root.add(new File("usr",20));
        bin.add(new File("vi",300));
        bin.add(new File("latex",500));
        System.out.println(root.getSize());
    }
}
//抽象类Entry用于描述文件和文件夹共同的特征
abstract class Entry{
    //这些抽象方法是文件和目录共有的特征
    abstract String getName();
    abstract int getSize();
    abstract void PrintList();

    //add方法仅仅是目录可以使用的，可以通过在抽象类中抛出异常的方法来进行规范处理
    void add(Entry entry)throws FileTreatmentException{
        throw new FileTreatmentException();
    }

}
//编写异常类进行错误处理，当调用add方法的子类没有重写add方法就会抛出这个异常
class FileTreatmentException extends RuntimeException{
    public FileTreatmentException() {
    }

    public FileTreatmentException(String message) {
        super(message);
    }
}
//编写文件类
class File extends Entry{
    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    private String name;
    private int size;
    @Override
    String getName() {
        return name;
    }

    @Override
    int getSize() {
        return size;
    }

    @Override
    void PrintList() {
        System.out.println("this file name is "+name+" size is "+size);
    }
}
//编写目录类
class Directory extends Entry{
    private String name;
    private ArrayList<Entry> dir;

    public Directory(String name) {
        this.name = name;
        dir=new ArrayList<>();
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    int getSize(){
        int sum=0;
        for(Entry e:dir){
            sum+=e.getSize();
        }
        return sum;
    }

    @Override
    void PrintList() {
        System.out.println("this is a directory");
    }
    //在此重写add方法
    @Override
    void add(Entry entry) throws FileTreatmentException {
        dir.add(entry);
    }
}
