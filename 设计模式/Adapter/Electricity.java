package Adapter;

//电力类，用来表示电的电压和类型
public class Electricity {
    public boolean isAC() {
        return isAC;
    }

    public int getV() {
        return V;
    }

    public void setAC(boolean AC) {
        isAC = AC;
    }

    public void setV(int v) {
        V = v;
    }

    //true代表直流电，false代表交流电
    private boolean isAC;
    //v代表电压
    private int V;

    public Electricity(boolean isAC, int v) {
        this.isAC = isAC;
        V = v;
    }
}
