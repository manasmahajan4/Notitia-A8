package adnyey.notitia.a8;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mahajan-PC on 12-02-2017.
 */

public class GridViewEngNum extends TextView {

    public GridViewEngNum(Context context) {
        super(context);
    }

    public GridViewEngNum(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridViewEngNum(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec); // This is the key that will make the height equivalent to its width
    }
}