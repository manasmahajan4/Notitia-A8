package adnyey.notitia.a8;

/**
 * Created by Mahajan-PC on 03-03-2017.
 */

public class EliteObj {
    private float a,t,h,n;
    private int r;

    EliteObj(){}

    EliteObj(float a, float t, float h, float n, int r)
    {
        this.a=a;
        this.n=n;
        this.h=h;
        this.t=t;
        this.r=r;
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getT() {
        return t;
    }

    public void setT(float t) {
        this.t = t;
    }

    public float getH() {
        return h;
    }

    public void setH(float h) {
        this.h = h;
    }

    public float getN() {
        return n;
    }

    public void setN(float n) {
        this.n = n;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
}
