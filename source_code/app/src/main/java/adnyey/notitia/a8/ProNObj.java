package adnyey.notitia.a8;

import adnyey.notitia.a8.objects.upgrades.MaxUpgrades;

/**
 * Created by Mahajan-PC on 26-01-2017.
 */

public class ProNObj {

    int accel1,top1,nos1,han1;
    int accel2,top2,nos2,han2;
    int accel3,top3,nos3,han3;
    int accel4,top4,nos4,han4;
    int accel5,top5,nos5,han5;

    int part1,tech11,tech12,techn1,engn1,tire1,susp1,drive1,exha1;
    int part2,tech21,tech22,techn2,engn2,tire2,susp2,drive2,exha2;
    int part3,tech31,tech32,techn3,engn3,tire3,susp3,drive3,exha3;
    int part4,tech41,tech42,techn4,engn4,tire4,susp4,drive4,exha4;
    int part5,tech51,tech52,techn5,engn5,tire5,susp5,drive5,exha5;

    MaxUpgrades maxUpgrades;

    public MaxUpgrades getMaxUpgrades() {
        return maxUpgrades;
    }

    public void setMaxUpgrades(MaxUpgrades maxUpgrades) {
        this.maxUpgrades = maxUpgrades;
    }

    ProNObj(

            int accel1,int top1,int han1,int nos1,
            int accel2,int top2,int han2,int nos2,
                    int accel3,int top3,int han3,int nos3,
                    int accel4,int top4,int han4,int nos4,
                    int accel5,int top5,int han5,int nos5, int[][] max_table,

            int part1,int tech11,int tech12,int techn1,int engn1,int tire1,int susp1,int drive1,int exha1,
                    int part2,int tech21,int tech22,int techn2,int engn2,int tire2,int susp2,int drive2,int exha2,
                    int part3,int tech31,int tech32,int techn3,int engn3,int tire3,int susp3,int drive3,int exha3,
                    int part4,int tech41,int tech42,int techn4,int engn4,int tire4,int susp4,int drive4,int exha4,
                    int part5,int tech51,int tech52,int techn5,int engn5,int tire5,int susp5,int drive5,int exha5
    )
    {
        maxUpgrades = new MaxUpgrades(max_table);

        this.accel1=accel1;this.top1=top1;this.nos1=nos1;this.han1=han1;
        this.accel2=accel2;this.top2=top2;this.nos2=nos2;this.han2=han2;
        this.accel3=accel3;this.top3=top3;this.nos3=nos3;this.han3=han3;
        this.accel4=accel4;this.top4=top4;this.nos4=nos4;this.han4=han4;
        this.accel5=accel5;this.top5=top5;this.nos5=nos5;this.han5=han5;

        this.part1=part1;this.tech11=tech11;this.tech12=tech12;this.techn1=techn1;this.engn1=engn1;this.tire1=tire1;this.susp1=susp1;this.drive1=drive1;this.exha1=exha1;
        this.part2=part2;this.tech21=tech21;this.tech22=tech22;this.techn2=techn2;this.engn2=engn2;this.tire2=tire2;this.susp2=susp2;this.drive2=drive2;this.exha2=exha2;
        this.part3=part3;this.tech31=tech31;this.tech32=tech32;this.techn3=techn3;this.engn3=engn3;this.tire3=tire3;this.susp3=susp3;this.drive3=drive3;this.exha3=exha3;
        this.part4=part4;this.tech41=tech41;this.tech42=tech42;this.techn4=techn4;this.engn4=engn4;this.tire4=tire4;this.susp4=susp4;this.drive4=drive4;this.exha4=exha4;
        this.part5=part5;this.tech51=tech51;this.tech52=tech52;this.techn5=techn5;this.engn5=engn5;this.tire5=tire5;this.susp5=susp5;this.drive5=drive5;this.exha5=exha5;


    }

    ProNObj()
    {}

    public int getAccel1() {
        return accel1;
    }

    public int getAccel2() {
        return accel2;
    }

    public int getAccel3() {
        return accel3;
    }

    public int getTop1() {
        return top1;
    }

    public int getNos1() {
        return nos1;
    }

    public int getHan1() {
        return han1;
    }

    public int getTop2() {
        return top2;
    }

    public int getNos2() {
        return nos2;
    }

    public int getHan2() {
        return han2;
    }

    public int getTop3() {
        return top3;
    }

    public int getNos3() {
        return nos3;
    }

    public int getHan3() {
        return han3;
    }

    public int getAccel4() {
        return accel4;
    }

    public int getTop4() {
        return top4;
    }

    public int getNos4() {
        return nos4;
    }

    public int getHan4() {
        return han4;
    }

    public int getAccel5() {
        return accel5;
    }

    public int getTop5() {
        return top5;
    }

    public int getNos5() {
        return nos5;
    }

    public int getHan5() {
        return han5;
    }

    public int getPart1() {
        return part1;
    }

    public int getTech11() {
        return tech11;
    }

    public int getTech12() {
        return tech12;
    }

    public int getTechn1() {
        return techn1;
    }

    public int getEngn1() {
        return engn1;
    }

    public int getTire1() {
        return tire1;
    }

    public int getSusp1() {
        return susp1;
    }

    public int getDrive1() {
        return drive1;
    }

    public int getExha1() {
        return exha1;
    }

    public int getPart2() {
        return part2;
    }

    public int getTech21() {
        return tech21;
    }

    public int getTech22() {
        return tech22;
    }

    public int getTechn2() {
        return techn2;
    }

    public int getEngn2() {
        return engn2;
    }

    public int getTire2() {
        return tire2;
    }

    public int getSusp2() {
        return susp2;
    }

    public int getDrive2() {
        return drive2;
    }

    public int getExha2() {
        return exha2;
    }

    public int getPart3() {
        return part3;
    }

    public int getTech31() {
        return tech31;
    }

    public int getTech32() {
        return tech32;
    }

    public int getTechn3() {
        return techn3;
    }

    public int getEngn3() {
        return engn3;
    }

    public int getTire3() {
        return tire3;
    }

    public int getSusp3() {
        return susp3;
    }

    public int getDrive3() {
        return drive3;
    }

    public int getExha3() {
        return exha3;
    }

    public int getPart4() {
        return part4;
    }

    public int getTech41() {
        return tech41;
    }

    public int getTech42() {
        return tech42;
    }

    public int getTechn4() {
        return techn4;
    }

    public int getEngn4() {
        return engn4;
    }

    public int getTire4() {
        return tire4;
    }

    public int getSusp4() {
        return susp4;
    }

    public int getDrive4() {
        return drive4;
    }

    public int getExha4() {
        return exha4;
    }

    public int getPart5() {
        return part5;
    }

    public int getTech51() {
        return tech51;
    }

    public int getTech52() {
        return tech52;
    }

    public int getTechn5() {
        return techn5;
    }

    public int getEngn5() {
        return engn5;
    }

    public int getTire5() {
        return tire5;
    }

    public int getSusp5() {
        return susp5;
    }

    public int getDrive5() {
        return drive5;
    }

    public int getExha5() {
        return exha5;
    }
}
