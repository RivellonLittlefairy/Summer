package Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    List<ObserverInterface> observers=new ArrayList<>();
    public void addObserver(ObserverInterface o){
        observers.add(o);
    }
    public void delete(ObserverInterface o){
        observers.remove(o);
    }
    public void notifyObservers(){
        for(ObserverInterface o:observers){
            o.update(this);
        }
    }
    public abstract void execute();
    public abstract int getnum();
}
class NumberGenerator extends Subject{
    int begin;
    int step;
    int end;
    int num;

    public NumberGenerator(int begin, int step, int end) {
        this.begin = begin;
        this.step = step;
        this.end = end;
    }

    @Override
    public int getnum() {
        return num;
    }

    @Override
    public void execute() {
        for(int i=begin;i<=end;i+=step){
            num=i;
            notifyObservers();
        }
    }
}
