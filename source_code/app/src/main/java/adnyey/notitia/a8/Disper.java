package adnyey.notitia.a8;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.core.view.GravityCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.text.NumberFormat;
import java.util.Locale;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

/**
 * Created by Mahajan-PC on 02-01-2017.
 */

public class Disper extends AppCompatActivity {
    RequestOptions options = new RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static final String ModiPREF = "EN_MODI";
    public static int int_items = 2, current = 0, adcount = 5;
    CarDBAccess myDbHelper;
    SharedPreferences sharedpreferences;
    BasicInfo basic;
    MastObj mastery;
    ToggleButton Butt_modi;
    Button prev, next;
    RelativeLayout butter;

    TextView cname, ctype, cclass, cprice, rw1, rw2, rw3;
    ImageView caricon, priceicon, winicon, rw1img, rw2img, rw3img;
    int id, list[], size, position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            SharedPreferences shared_lang = this.getSharedPreferences("LANG", Context.MODE_PRIVATE);
            String languageToLoad = shared_lang.getString("language", "en");
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            this.getResources().updateConfiguration(config, this.getResources().getDisplayMetrics());
        }catch(Exception e){}
        setContentView(R.layout.layout_details);
        savedInstanceState = getIntent().getExtras();
        id = savedInstanceState.getInt("carid");
        size = savedInstanceState.getInt("listsize");
        position = savedInstanceState.getInt("listposition");
        list = new int[size];
        list = savedInstanceState.getIntArray("carlist");
        myDbHelper = CarDBAccess.getInstance(getApplicationContext());
        mastery = new MastObj();
        mastery = myDbHelper.getMastInfo(id);
        basic = new BasicInfo();
        try {
            basic = myDbHelper.getBasic(id);
        } catch (Exception e) {
            e.printStackTrace();
        }


        butter = (RelativeLayout) findViewById(R.id.prev_next);
        sharedpreferences = getSharedPreferences(ModiPREF, Context.MODE_PRIVATE);

        prev = (Button) findViewById(R.id.prevButton);
        next = (Button) findViewById(R.id.nextButton);
        Butt_modi = (ToggleButton) findViewById(R.id.toggleButton2);
        caricon = (ImageView) findViewById(R.id.carIcon);
        winicon = (ImageView) findViewById(R.id.carWin);
        rw1img = (ImageView) findViewById(R.id.rew1IMG);
        rw2img = (ImageView) findViewById(R.id.rew2IMG);
        rw3img = (ImageView) findViewById(R.id.rew3IMG);
        priceicon = (ImageView) findViewById(R.id.pricIcon);
        cname = (TextView) findViewById(R.id.carName);
        rw1 = (TextView) findViewById(R.id.rew1);
        rw2 = (TextView) findViewById(R.id.rew2);
        rw3 = (TextView) findViewById(R.id.rew3);
        ctype = (TextView) findViewById(R.id.carType);
        cclass = (TextView) findViewById(R.id.carClass);
        cprice = (TextView) findViewById(R.id.carPrice);

        if (position == 0) {
            next.setEnabled(true);
            prev.setEnabled(false);
        }
        if (position == size - 1) {
            prev.setEnabled(true);
            next.setEnabled(false);
        }

        /**
         *Inflate tab_layout and setup Views.
         */

        tabLayout = (TabLayout) findViewById(R.id.info_tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager_infos);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new Disper.MyAdapter(getSupportFragmentManager()));

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

        final SharedPreferences.Editor editor = sharedpreferences.edit();


        try {
            setInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (viewPager.getCurrentItem() == 0) {
                    if (basic.getModi() == 0)
                        Butt_modi.setVisibility(GONE);
                    else
                        Butt_modi.setVisibility(VISIBLE);
                } else
                    Butt_modi.setVisibility(GONE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Butt_modi.setTextOff(getString(R.string.but_dis));
        Butt_modi.setTextOn(getString(R.string.but_real));

        if (basic.getModi() == 0)
            Butt_modi.setVisibility(GONE);
        else
            Butt_modi.setVisibility(VISIBLE);

        if (sharedpreferences.getBoolean("EN_MODI", false)) {
            Butt_modi.setChecked(true);
        } else {
            Butt_modi.setChecked(false);
        }


        Butt_modi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    editor.putBoolean("EN_MODI", true);
                } else {
                    editor.putBoolean("EN_MODI", false);
                }
                editor.apply();
                viewPager.setAdapter(new Disper.MyAdapter(getSupportFragmentManager()));
                tabLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        tabLayout.setupWithViewPager(viewPager);
                    }
                });
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position == 0) {
                    position = 0;
                    prev.setEnabled(false);
                } else {
                    next.setEnabled(true);
                    position--;
                    current = viewPager.getCurrentItem();
                    basic = myDbHelper.getBasic(list[position]);
                    mastery = myDbHelper.getMastInfo(list[position]);
                    try {
                        setInfo();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    viewPager.setAdapter(new Disper.MyAdapter(getSupportFragmentManager()));
                    tabLayout.post(new Runnable() {
                        @Override
                        public void run() {
                            tabLayout.setupWithViewPager(viewPager);
                        }
                    });
                    if (position == 0)
                        prev.setEnabled(false);
                    viewPager.setCurrentItem(current);
                    if (viewPager.getCurrentItem() == 0) {
                        if (basic.getModi() == 0) {
                            Butt_modi.setVisibility(GONE);
                        } else {
                            Butt_modi.setVisibility(VISIBLE);
                        }
                    }
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position < size - 1) {
                    prev.setEnabled(true);
                    position++;
                    current = viewPager.getCurrentItem();
                    basic = myDbHelper.getBasic(list[position]);
                    mastery = myDbHelper.getMastInfo(list[position]);
                    try {
                        setInfo();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    viewPager.setAdapter(new Disper.MyAdapter(getSupportFragmentManager()));
                    tabLayout.post(new Runnable() {
                        @Override
                        public void run() {
                            tabLayout.setupWithViewPager(viewPager);
                        }
                    });
                    if (position >= size - 1)
                        next.setEnabled(false);
                } else
                    next.setEnabled(false);
                viewPager.setCurrentItem(current);
                if (viewPager.getCurrentItem() == 0) {
                    if (basic.getModi() == 0) {
                        Butt_modi.setVisibility(GONE);
                    } else {
                        Butt_modi.setVisibility(VISIBLE);
                    }
                } else
                    Butt_modi.setVisibility(GONE);
            }
        });


    }

    public BasicInfo getMyInfo() {
        return basic;
    }

    void setInfo() {
        if (basic.getModi() == 0) {
            Butt_modi.setVisibility(VISIBLE);
        } else
            Butt_modi.setVisibility(VISIBLE);

        if (basic.getType() == 0)
            ctype.setVisibility(GONE);
/*        else if (basic.getType() == 1) {
            ctype.setVisibility(VISIBLE);
            ctype.setText("ELITE");
        } */else
            ctype.setVisibility(GONE);

        if (basic.getCarclass() > 0) {
            cclass.setVisibility(VISIBLE);
            if (basic.getCarclass() == 1)
                cclass.setText("D");
            if (basic.getCarclass() == 2)
                cclass.setText("C");
            if (basic.getCarclass() == 3)
                cclass.setText("B");
            if (basic.getCarclass() == 4)
                cclass.setText("A");
            if (basic.getCarclass() == 5)
                cclass.setText("S");
        }

        if (basic.getWin() > 0) {
            winicon.setVisibility(View.VISIBLE);
            if (basic.getWin() == 1)
                winicon.setImageResource(R.drawable.tic_rnd);
            if (basic.getWin() == 2)
                winicon.setImageResource(R.drawable.tic_edd);
            if (basic.getWin() == 3)
                winicon.setImageResource(R.drawable.tic_champ);
            if (basic.getWin() == 4)
                winicon.setImageResource(R.drawable.tic_vip);
            if (basic.getWin() == 5)
                winicon.setImageResource(R.drawable.tic_mast);
            if (basic.getWin() == 6)
                winicon.setImageResource(R.drawable.tic_mp);
            if (basic.getWin() == 7)
                winicon.setImageResource(R.drawable.tic_por);
            if (basic.getWin() == 8)
                winicon.setImageResource(R.drawable.tic_fob);
            if (basic.getWin() == 9)
                winicon.setImageResource(R.drawable.tic_fest);
        } else
            winicon.setVisibility(View.GONE);


        if (basic.getPrib() > 0) {
            cprice.setVisibility(VISIBLE);
            cprice.setTypeface(null, Typeface.BOLD);
            {
                cprice.setText(NumberFormat.getIntegerInstance().format(basic.getPrib()));
                priceicon.setImageResource(R.drawable.a8b);
            }
        } else {
            if (basic.getPric() > 0) {
                cprice.setVisibility(VISIBLE);
                cprice.setTypeface(null, Typeface.BOLD);
                if (basic.getWin() == 5) {
                    cprice.setText(NumberFormat.getIntegerInstance().format(basic.getPric()));
                    priceicon.setImageResource(R.drawable.mast_lice);
                } else {
                    cprice.setText(NumberFormat.getIntegerInstance().format(basic.getPric()));
                    priceicon.setImageResource(R.drawable.a8c);
                }
            }

            if (basic.getPric() == 0 && basic.getPrit() > 0) {
                cprice.setVisibility(VISIBLE);
                cprice.setTypeface(null, Typeface.BOLD);
                {
                    cprice.setText(NumberFormat.getIntegerInstance().format(basic.getPrit()));
                    priceicon.setImageResource(R.drawable.a8t);
                }
            }

            if (basic.getPric() == 0 && basic.getPrit() == 0) {
                cprice.setVisibility(VISIBLE);
                cprice.setTypeface(null, Typeface.BOLD);
                {
                    cprice.setText("?");
                    priceicon.setImageResource(R.drawable.a8b);
                }
            }
        }





        /*if (basic.getPric() > 0 && basic.getPrit() > 0) {
            cprice.setVisibility(VISIBLE);
            cprice.setText(basic.getPric() + " Credits or " + basic.getPrit() + " Tokens");
        }*/
        try {
            int id = getResources().getIdentifier(basic.getImg(), "drawable", getPackageName());

//            Glide.with(this).load(id)
//                    .apply(options)
//                    .thumbnail(0.1f)
//                    .into(caricon);
            caricon.setImageResource(id);
        }catch(Exception e){}

        cname.setText(basic.getName());

        if (mastery.getRew2() != 0) {
            if (mastery.getRew3() != 0) {
                rw1.setVisibility(VISIBLE);
                rw1img.setVisibility(VISIBLE);
                rw2.setVisibility(VISIBLE);
                rw2img.setVisibility(VISIBLE);
                rw3.setVisibility(VISIBLE);
                rw3img.setVisibility(VISIBLE);
            } else {
                rw1.setVisibility(VISIBLE);
                rw1img.setVisibility(VISIBLE);
                rw2.setVisibility(VISIBLE);
                rw2img.setVisibility(VISIBLE);
                rw3.setVisibility(INVISIBLE);
                rw3img.setVisibility(INVISIBLE);
            }
        } else {
            rw1.setVisibility(VISIBLE);
            rw1img.setVisibility(VISIBLE);
            rw2.setVisibility(INVISIBLE);
            rw2img.setVisibility(INVISIBLE);
            rw3.setVisibility(INVISIBLE);
            rw3img.setVisibility(INVISIBLE);
        }

        if (mastery.getRew1() > 9000)//LICENCES
        {
            rw1.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew1() - 9000));
            rw1img.setImageResource(R.drawable.mast_lice);
        } else {
            if (mastery.getRew1() > 6000)//TOKENS
            {
                rw1.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew1() - 6000));
                rw1img.setImageResource(R.drawable.a8t);
            } else {
                if (mastery.getRew1() > 5000)//S UPGRADES
                {
                    rw1.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew1() - 5000));
                    rw1img.setImageResource(R.drawable.mast_ups);
                } else {
                    if (mastery.getRew1() > 4000)//A UPGRADES
                    {
                        rw1.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew1() - 4000));
                        rw1img.setImageResource(R.drawable.mast_upa);
                    } else {
                        if (mastery.getRew1() > 3000)//B UPGRADES
                        {
                            rw1.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew1() - 3000));
                            rw1img.setImageResource(R.drawable.mast_upb);
                        } else {
                            if (mastery.getRew1() > 2000)//C UPGRADES
                            {
                                rw1.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew1() - 2000));
                                rw1img.setImageResource(R.drawable.mast_upc);
                            } else {
                                if (mastery.getRew1() > 1000)//D UPGRADES
                                {
                                    rw1.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew1() - 1000));
                                    rw1img.setImageResource(R.drawable.mast_upd);
                                } else {
                                    if (mastery.getRew1() > 600)//CARDS
                                    {
                                        rw1.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew1() - 600));
                                        rw1img.setImageResource(R.drawable.mast_cards);
                                    } else {
                                        if (mastery.getRew1() > 400)//EXTRATANK
                                        {
                                            rw1.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew1() - 400));
                                            rw1img.setImageResource(R.drawable.mast_et);
                                        } else {
                                            if (mastery.getRew1() > 300)//NITROSTARTER
                                            {
                                                rw1.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew1() - 300));
                                                rw1img.setImageResource(R.drawable.mast_ns);
                                            } else {
                                                if (mastery.getRew1() > 200)//TUNING KIT
                                                {
                                                    rw1.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew1() - 200));
                                                    rw1img.setImageResource(R.drawable.mast_tk);
                                                } else {
                                                    if (mastery.getRew1() > 100)//DOUBLE CREDITS
                                                    {
                                                        rw1.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew1() - 100));
                                                        rw1img.setImageResource(R.drawable.mast_dc);
                                                    } else {
                                                        rw1.setText("?");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (mastery.getRew2() > 9000)//LICENCES
        {
            rw2.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew2() - 9000));
            rw2img.setImageResource(R.drawable.mast_lice);
        } else {
            if (mastery.getRew2() > 6000)//TOKENS
            {
                rw2.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew2() - 6000));
                rw2img.setImageResource(R.drawable.a8t);
            } else {
                if (mastery.getRew2() > 5000)//S UPGRADES
                {
                    rw2.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew2() - 5000));
                    rw2img.setImageResource(R.drawable.mast_ups);
                } else {
                    if (mastery.getRew2() > 4000)//A UPGRADES
                    {
                        rw2.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew2() - 4000));
                        rw2img.setImageResource(R.drawable.mast_upa);
                    } else {
                        if (mastery.getRew2() > 3000)//B UPGRADES
                        {
                            rw2.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew2() - 3000));
                            rw2img.setImageResource(R.drawable.mast_upb);
                        } else {
                            if (mastery.getRew2() > 2000)//C UPGRADES
                            {
                                rw2.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew2() - 2000));
                                rw2img.setImageResource(R.drawable.mast_upc);
                            } else {
                                if (mastery.getRew2() > 1000)//D UPGRADES
                                {
                                    rw2.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew2() - 1000));
                                    rw2img.setImageResource(R.drawable.mast_upd);
                                } else {
                                    if (mastery.getRew2() > 600)//CARDS
                                    {
                                        rw2.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew2() - 600));
                                        rw2img.setImageResource(R.drawable.mast_cards);
                                    } else {
                                        if (mastery.getRew2() > 400)//EXTRATANK
                                        {
                                            rw2.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew2() - 400));
                                            rw2img.setImageResource(R.drawable.mast_et);
                                        } else {
                                            if (mastery.getRew2() > 300)//NITROSTARTER
                                            {
                                                rw2.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew2() - 300));
                                                rw2img.setImageResource(R.drawable.mast_ns);
                                            } else {
                                                if (mastery.getRew2() > 200)//TUNING KIT
                                                {
                                                    rw2.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew2() - 200));
                                                    rw2img.setImageResource(R.drawable.mast_tk);
                                                } else {
                                                    if (mastery.getRew2() > 100)//DOUBLE CREDITS
                                                    {
                                                        rw2.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew2() - 100));
                                                        rw2img.setImageResource(R.drawable.mast_dc);
                                                    } else {
                                                        rw2.setText("?");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (mastery.getRew3() > 9000)//LICENCES
        {
            rw3.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew3() - 9000));
            rw3img.setImageResource(R.drawable.mast_lice);
        } else {
            if (mastery.getRew3() > 6000)//TOKENS
            {
                rw3.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew3() - 6000));
                rw3img.setImageResource(R.drawable.a8t);
            } else {
                if (mastery.getRew3() > 5000)//S UPGRADES
                {
                    rw3.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew3() - 5000));
                    rw3img.setImageResource(R.drawable.mast_ups);
                } else {
                    if (mastery.getRew3() > 4000)//A UPGRADES
                    {
                        rw3.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew3() - 4000));
                        rw3img.setImageResource(R.drawable.mast_upa);
                    } else {
                        if (mastery.getRew3() > 3000)//B UPGRADES
                        {
                            rw3.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew3() - 3000));
                            rw3img.setImageResource(R.drawable.mast_upb);
                        } else {
                            if (mastery.getRew3() > 2000)//C UPGRADES
                            {
                                rw3.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew3() - 2000));
                                rw3img.setImageResource(R.drawable.mast_upc);
                            } else {
                                if (mastery.getRew3() > 1000)//D UPGRADES
                                {
                                    rw3.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew3() - 1000));
                                    rw3img.setImageResource(R.drawable.mast_upd);
                                } else {
                                    if (mastery.getRew3() > 600)//CARDS
                                    {
                                        rw3.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew3() - 600));
                                        rw3img.setImageResource(R.drawable.mast_cards);
                                    } else {
                                        if (mastery.getRew3() > 400)//EXTRATANK
                                        {
                                            rw3.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew3() - 400));
                                            rw3img.setImageResource(R.drawable.mast_et);
                                        } else {
                                            if (mastery.getRew3() > 300)//NITROSTARTER
                                            {
                                                rw3.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew3() - 300));
                                                rw3img.setImageResource(R.drawable.mast_ns);
                                            } else {
                                                if (mastery.getRew3() > 200)//TUNING KIT
                                                {
                                                    rw3.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew3() - 200));
                                                    rw3img.setImageResource(R.drawable.mast_tk);
                                                } else {
                                                    if (mastery.getRew3() > 100)//DOUBLE CREDITS
                                                    {
                                                        rw3.setText("X" + NumberFormat.getIntegerInstance().format(mastery.getRew3() - 100));
                                                        rw3img.setImageResource(R.drawable.mast_dc);
                                                    } else {
                                                        rw3.setText("?");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment_tab_info();
                case 1:
                    return new Fragment_tab_ups();
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

            switch (position) {
                case 0:
                    return getString(R.string.stats_perf).toUpperCase();
                case 1:
                    return getString(R.string.stats_ups).toUpperCase();
            }
            return null;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
