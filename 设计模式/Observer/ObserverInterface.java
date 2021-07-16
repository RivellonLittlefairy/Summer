package Observer;

public interface ObserverInterface {
    public abstract void update(Subject subject);
}
class GraphObserver implements ObserverInterface{
    @Override
    public void update(Subject subject) {
        int num=subject.getnum();
        for (int i = 0; i < num; i++) {
            System.out.print("*");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
