package adnyey.notitia.a8;

/**
 * Created by Mahajan-PC on 12-02-2017.
 */

public class EngObj {

    int id;
    String name;
    int engn;
    String eng;

    EngObj() {
    }

    EngObj(int id, String name, int engn, String eng) {
        this.id = id;
        this.name = name;
        this.engn = engn;
        this.eng = eng;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEngn() {
        return engn;
    }

    public void setEngn(int engn) {
        this.engn = engn;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }
}
