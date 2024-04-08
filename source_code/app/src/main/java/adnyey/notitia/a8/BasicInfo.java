package adnyey.notitia.a8;

/**
 * Created by Mahajan-PC on 04-01-2017.
 */

public class BasicInfo {
    int id, rank, carclass, type, win, pric, prit, prib, engn, tkbonus;
    String name, img, eng;
    double modi;

    public BasicInfo() {

    }

    public BasicInfo(int id, int rank, int carclass, int type, int win, int pric, int prit, int prib, String name, String img, double modi, String eng, int engn, int tkbonus) {
        this.id = id;
        this.rank = rank;
        this.carclass = carclass;
        this.type = type;
        this.win = win;
        this.pric = pric;
        this.prit = prit;
        this.name = name;
        this.img = img;
        this.modi = modi;
        this.eng = eng;
        this.engn = engn;
        this.prib = prib;
        this.tkbonus = tkbonus;
    }

    public int getTkbonus() {
        return tkbonus;
    }

    public void setTkbonus(int tkbonus) {
        this.tkbonus = tkbonus;
    }

    public int getPrib() {
        return prib;
    }

    public void setPrib(int prib) {
        this.prib = prib;
    }

    int getId() {
        return this.id;
    }

    int getEngn() {
        return this.engn;
    }

    void setId(int id) {
        this.id = id;
    }

    int getRank() {
        return this.rank;
    }

    void setRank(int rank) {
        this.rank = rank;
    }

    int getCarclass() {
        return this.carclass;
    }

    void setCarclass(int carclass) {
        this.carclass = carclass;
    }

    int getType() {
        return this.type;
    }

    void setType(int type) {
        this.type = type;
    }

    int getWin() {
        return this.win;
    }

    void setWin(int win) {
        this.win = win;
    }

    int getPric() {
        return this.pric;
    }

    void setPric(int pric) {
        this.pric = pric;
    }

    int getPrit() {
        return this.prit;
    }

    void setPrit(int prit) {
        this.prit = prit;
    }

    String getName() {
        return this.name;
    }

    String getEng() {
        return this.eng;
    }

    void setName(String name) {
        this.name = name;
    }

    String getImg() {
        return this.img;
    }

    void setImg(String img) {
        this.img = img;
    }

    Double getModi() {
        return this.modi;
    }

    void setModi(double modi) {
        this.modi = modi;
    }
}
