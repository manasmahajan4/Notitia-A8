package adnyey.notitia.a8;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codewaves.stickyheadergrid.StickyHeaderGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mahajan-PC on 2017-11-05.
 */

public class Fragment_GameUpdates extends Fragment {

    List<List<GItem>> data, tempp;
    CarDBAccess myDbHelper;

    private RecyclerView mRecycler;
    private StickyHeaderGridLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_updates, container, false);
        mRecycler = (RecyclerView) view.findViewById(R.id.updateRecycler);
        mRecycler.setLayoutManager(new StickyHeaderGridLayoutManager(2));
        mRecycler.setAdapter(new GameUpdatesAdapter(tempp, getContext()));
        new Thread() {
            @Override
            public void run() {
                myDbHelper = CarDBAccess.getInstance(getContext());
                data = new ArrayList<List<GItem>>();
                try {
                    data.add(myDbHelper.getOListerInput(270, 272));
                    data.add(myDbHelper.getOListerInput(265, 269));
                    data.add(myDbHelper.getOListerInput(260, 264));
                    data.add(myDbHelper.getOListerInput(258, 259));
                    data.add(myDbHelper.getOListerInput(254, 257));
                    data.add(myDbHelper.getOListerInput(249, 253));
                    data.add(myDbHelper.getOListerInput(245, 248));
                    data.add(myDbHelper.getOListerInput(239, 244));
                    data.add(myDbHelper.getOListerInput(237, 238));
                    data.add(myDbHelper.getOListerInput(231, 236));
                    data.add(myDbHelper.getOListerInput(225, 230));
                    data.add(myDbHelper.getOListerInput(219, 224));
                    data.add(myDbHelper.getOListerInput(212, 218));
                    data.add(myDbHelper.getOListerInput(206, 211));
                    data.add(myDbHelper.getOListerInput(201, 205));
                    data.add(myDbHelper.getOListerInput(194, 200));
                    data.add(myDbHelper.getOListerInput(189, 193));
                    data.add(myDbHelper.getOListerInput(183, 188));
                    data.add(myDbHelper.getOListerInput(178, 182));
                    data.add(myDbHelper.getOListerInput(170, 177));
                    data.add(myDbHelper.getOListerInput(163, 169));
                    data.add(myDbHelper.getOListerInput(156, 162));
                    data.add(myDbHelper.getOListerInput(148, 155));
                    data.add(myDbHelper.getOListerInput(141, 147));
                    data.add(myDbHelper.getOListerInput(132, 140));
                    data.add(myDbHelper.getOListerInput(118, 131));
                    data.add(myDbHelper.getOListerInput(112, 117));
                    data.add(myDbHelper.getOListerInput(104, 111));
                    data.add(myDbHelper.getOListerInput(96, 103));
                    data.add(myDbHelper.getOListerInput(91, 95));
                    data.add(myDbHelper.getOListerInput(80, 90));
                    data.add(myDbHelper.getOListerInput(75, 79));
                    data.add(myDbHelper.getOListerInput(70, 74));
                    data.add(myDbHelper.getOListerInput(62, 69));
                    data.add(myDbHelper.getOListerInput(57, 61));
                    data.add(myDbHelper.getOListerInput(51, 56));
                    data.add(myDbHelper.getOListerInput(48, 50));
                    data.add(myDbHelper.getOListerInput(1, 47));
                }catch (NullPointerException e){e.printStackTrace(); Toast.makeText(getContext(),"Opps! Something went wrong!", Toast.LENGTH_SHORT).show();}


                // code runs in a thread
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

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

                        try {

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
                            mRecycler.setAdapter(new GameUpdatesAdapter(data, getContext()));
                        }catch(NullPointerException e){e.printStackTrace(); Toast.makeText(getContext(),"Opps! Something went wrong!", Toast.LENGTH_SHORT).show();}
                    }
                });
            }
        }.start();
        return view;
    }
}
