package Singleton;
public class SingletonMain {
    public static void main(String[] args) {
        TripleExam();
    }
    public static void TicketMakerExam(){
        TicketMaker t=TicketMaker.getTicketMaker();
        while(true){
            System.out.println(t.getNextTicketNumber());
        }
    }
    public static void TripleExam(){
        for (int i = 0; i < 6; i++) {
            Triple t1=Triple.getTriple();
            System.out.println(t1.getInstance());
        }
        Triple t2=Triple.getTriple(2);
        System.out.println(t2.getInstance());
    }
}
