package adnyey.notitia.a8;

/**
 * Created by Mahajan-PC on 15-01-2017.
 */

public class StatsObj {
    private float a1, a2, a3, a4;
    private float t1, t2, t3, t4;
    private float h1, h2, h3, h4;
    private float n1, n2, n3, n4;
    private int r1, r2, r3, r4;

    StatsObj(){}

    StatsObj(float a1,float a2,float a3,float a4,
            float t1,float t2,float t3,float t4,
                     float h1,float h2,float h3,float h4,
                     float n1,float n2,float n3,float n4,
                     int r1,int r2,int r3,int r4)
    {

        this.a1=a1; this.a2=a2; this.a3=a3; this.a4=a4;
        this.t1=t1; this.t2=t2; this.t3=t3; this.t4=t4;
        this.h1=h1; this.h2=h2; this.h3=h3; this.h4=h4;
        this.n1=n1; this.n2=n2; this.n3=n3; this.n4=n4;
        this.r1=r1; this.r2=r2; this.r3=r3; this.r4=r4;

    }

    public float getA1() {
        return a1;
    }

    public float getA2() {
        return a2;
    }

    public float getA3() {
        return a3;
    }

    public float getA4() {
        return a4;
    }

    public float getT1() {
        return t1;
    }

    public float getT2() {
        return t2;
    }

    public float getT3() {
        return t3;
    }

    public float getT4() {
        return t4;
    }

    public float getH1() {
        return h1;
    }

    public float getH2() {
        return h2;
    }

    public float getH3() {
        return h3;
    }

    public float getH4() {
        return h4;
    }


    public float getN1() {
        return n1;
    }

    public float getN2() {
        return n2;
    }

    public float getN3() {
        return n3;
    }

    public float getN4() {
        return n4;
    }


    public int getR1() {
        return r1;
    }

    public int getR2() {
        return r2;
    }

    public int getR3() {
        return r3;
    }

    public int getR4() {
        return r4;
    }

}
