package adnyey.notitia.a8;

import android.graphics.drawable.Drawable;

/**
 * Created by Mahajan-PC on 25-12-2016.
 */

public class GItem {

    String title;
    Drawable image;
    int id,type,win;

    // Empty Constructor
    public GItem()
    {

    }

    // Constructor
    public GItem(String title, Drawable image, int id, int type, int win)
    {
        super();
        this.title = title;
        this.image = image;
        this.id = id;
        this.type = type;
        this.win=win;
    }

    // Getter and Setter Method
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Drawable getImage()
    {
        return image;
    }

    public int getId()
    {
        return id;
    }

    public int getWin()
    {
        return win;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public void setImage(Drawable image)
    {
        this.image = image;
    }

}
