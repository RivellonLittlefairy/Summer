

import java.io.*;
//题目要求深拷贝个带随机指针的链表，用哈希表做可以，这样序列化会出错因为node没实现Serializable接口所以不行

public class deepClone {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Node head=new Node(1);
        ByteArrayOutputStream BOS=new ByteArrayOutputStream();
        ObjectOutputStream OOS=new ObjectOutputStream(BOS);
        OOS.writeObject(head);

        ByteArrayInputStream BIS=new ByteArrayInputStream(BOS.toByteArray());
        ObjectInputStream OIS=new ObjectInputStream(BIS);
        Node a= (Node) OIS.readObject();
    }
}
class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}