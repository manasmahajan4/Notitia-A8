package adnyey.notitia.a8;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class TabFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public Fragment_Carlist fragmentD;
    public static int int_items = 6 ;
    SharedPreferences sharedpreferences1;
    Button tutorial;
    CardView tutorial_card;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */

        View x =  inflater.inflate(R.layout.tab_cars,null);
        tutorial_card=(CardView)x.findViewById(R.id.help_compare_box);
        tutorial=(Button) x.findViewById(R.id.help_compare);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        sharedpreferences1 = this.getActivity().getSharedPreferences("EN_HELP_ALLCARS", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences1.edit();
        if(sharedpreferences1.getBoolean("EN_HELP_ALLCARS", false))
        {
            tutorial_card.setVisibility(GONE);
        }
        else
        {
            tutorial_card.setVisibility(VISIBLE);
        }
        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("EN_HELP_ALLCARS", true);
                editor.apply();
                tutorial_card.setVisibility(GONE);
            }
        });
        /**
         *Set an Apater for the View Pager
         */
        final Handler handler12 = new Handler();
        handler12.postDelayed(new Runnable() {
            @Override
            public void run() {
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
            }
        }, 0);
        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return x;

    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */



        @Override
        public Fragment getItem(int position)
        {
            Bundle args = new Bundle();
            switch (position){
                case 0 :
                    args.putInt("class",1);
                    fragmentD = new Fragment_Carlist ();
                    fragmentD.setArguments(args);
                    return fragmentD;
                case 1 : args.putInt("class",2);
                    fragmentD = new Fragment_Carlist ();
                    fragmentD.setArguments(args);
                    return fragmentD;
                case 2 : args.putInt("class",3);
                    fragmentD = new Fragment_Carlist ();
                    fragmentD.setArguments(args);
                    return fragmentD;
                case 3 : args.putInt("class",4);
                    fragmentD = new Fragment_Carlist ();
                    fragmentD.setArguments(args);
                    return fragmentD;
                case 4 : args.putInt("class",5);
                    fragmentD = new Fragment_Carlist ();
                    fragmentD.setArguments(args);
                    return fragmentD;
                case 5 :
                    return new Fragment_GameUpdates();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0:
                    return getString(R.string.class_d).toUpperCase();
                case 1:
                    return getString(R.string.class_c).toUpperCase();
                case 2:
                    return getString(R.string.class_b).toUpperCase();
                case 3:
                    return getString(R.string.class_a).toUpperCase();
                case 4:
                    return getString(R.string.class_s).toUpperCase();
                case 5:
                    return getString(R.string.tab_updates).toUpperCase();
            }
            return null;
        }
    }


}