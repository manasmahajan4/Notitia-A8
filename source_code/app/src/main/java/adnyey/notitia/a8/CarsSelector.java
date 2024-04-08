package adnyey.notitia.a8;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import com.codewaves.stickyheadergrid.StickyHeaderGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class CarsSelector extends Dialog {

    List<List<GItem>> data, tempp;
    CarDBAccess myDbHelper;

    private RecyclerView mRecycler;
    private StickyHeaderGridLayoutManager mLayoutManager;

    OnMyDialogResult mDialogResult;

    public CarsSelector(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_updates);
        Window window = getWindow();
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(window.getAttributes());

        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);
        mRecycler = (RecyclerView) findViewById(R.id.updateRecycler);
        mRecycler.setLayoutManager(new StickyHeaderGridLayoutManager(2));
       // mRecycler.setAdapter(new CarSelectorAdapter(tempp, this, mDialogResult));

        myDbHelper = CarDBAccess.getInstance(getContext());
        data = new ArrayList<List<GItem>>();
        data.add(myDbHelper.getListerInput(1));
        data.add(myDbHelper.getListerInput(2));
        data.add(myDbHelper.getListerInput(3));
        data.add(myDbHelper.getListerInput(4));
        data.add(myDbHelper.getListerInput(5));

        float scalefactor = getContext().getResources().getDisplayMetrics().density * 100;
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenWidth = displaymetrics.widthPixels;
        int columns = (int) ((float) screenWidth / (float) scalefactor);
        if (columns > 1 && columns < 7) {
            mLayoutManager = new StickyHeaderGridLayoutManager(columns - 1);
        } else if (columns >= 7) {
            mLayoutManager = new StickyHeaderGridLayoutManager(7);
        } else {
            mLayoutManager = new StickyHeaderGridLayoutManager(columns);
        }
        mLayoutManager.setHeaderBottomOverlapMargin(getContext().getResources().getDimensionPixelSize(R.dimen.header_shadow_size));
        mLayoutManager.setSpanSizeLookup(new StickyHeaderGridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int section, int position) {
                switch (section) {
                    default:
                        return 1;
                }
            }
        });

        // Workaround RecyclerView limitation when playing remove animations. RecyclerView always
        // puts the removed item on the top of other views and it will be drawn above sticky header.
        // The only way to fix this, abandon remove animations :(
        mRecycler.setItemAnimator(new DefaultItemAnimator() {
            @Override
            public boolean animateRemove(RecyclerView.ViewHolder holder) {
                dispatchRemoveFinished(holder);
                return false;
            }
        });

        mRecycler.setLayoutManager(mLayoutManager);
        //CarSelectorAdapter adaptc = new CarSelectorAdapter(data, this, mDialogResult);
        //mRecycler.setAdapter(adaptc);



    }

    @Override
    public void setOnDismissListener(@Nullable OnDismissListener listener) {
        super.setOnDismissListener(listener);

    }

    public void setDialogResult(OnMyDialogResult dialogResult){
        mDialogResult = dialogResult;
    }

    public interface OnMyDialogResult{
        void finish(int result);
    }
}
