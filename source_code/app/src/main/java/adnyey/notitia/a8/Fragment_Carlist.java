package adnyey.notitia.a8;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codewaves.stickyheadergrid.StickyHeaderGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mahajan-PC on 2017-11-05.
 */

public class Fragment_Carlist extends Fragment {
    CarDBAccess myDbHelper;
    private List<List<GItem>> carList, tempList;
    private RecyclerView mRecycler;
    private StickyHeaderGridLayoutManager mLayoutManager;
    ArrayList<GItem> data = new ArrayList<GItem>();

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.layout_carlist, container, false);
        mRecycler = (RecyclerView) view.findViewById(R.id.carlistRecycler);
        mRecycler.setLayoutManager(new StickyHeaderGridLayoutManager(2));
        tempList = new ArrayList<List<GItem>>();
        mRecycler.setAdapter(new CarGridAdapter(tempList, getContext()));
        new Thread() {
            @Override
            public void run() {
                tempList = new ArrayList<List<GItem>>();
                myDbHelper = CarDBAccess.getInstance(getContext());
                Bundle b = getArguments();
                int s = b.getInt("class");
                carList = new ArrayList<List<GItem>>();
                carList.add(myDbHelper.getListerInput(s));

                try {

                    // code runs in a thread
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if (!isAdded()) {
                                return;
                            } else {

                                float scalefactor = getResources().getDisplayMetrics().density * 100;
                                DisplayMetrics displaymetrics = new DisplayMetrics();
                                getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
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
                                mRecycler.setAdapter(new CarGridAdapter(carList, getContext()));
                            }
                        }
                    });
                } catch (final Exception ex) {

                }
            }
        }.start();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!isAdded()) {
            return;
        }
    }
}