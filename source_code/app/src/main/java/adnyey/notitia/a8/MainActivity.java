package adnyey.notitia.a8;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.UpdateFrom;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private FragmentManager mFragmentManager;
    private CarDBAccess myDbHelper;
    private FragmentTransaction mFragmentTransaction;
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedpreferences;
    private androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myDbHelper = CarDBAccess.getInstance(MainActivity.this);
        myDbHelper.open();

        try {
            SharedPreferences shared_lang = this.getSharedPreferences("LANG", Context.MODE_PRIVATE);
            String languageToLoad = shared_lang.getString("language", "en");
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            this.getResources().updateConfiguration(config, this.getResources().getDisplayMetrics());
        } catch (Exception e) {
        }

        setContentView(R.layout.activity_main);

        AppUpdater appUpdater = new AppUpdater(this);
        appUpdater.setUpdateFrom(UpdateFrom.JSON)
                .setButtonDoNotShowAgain(null)
                .setUpdateJSON("https://raw.githubusercontent.com/adnyey/Notitia-A8/master/update_changelog.json")
                .start();

        new Thread() {
            @Override
            public void run() {


                try {

                    // code runs in a thread
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            try {
                                SharedPreferences shared_lang = getApplicationContext().getSharedPreferences("LANG", Context.MODE_PRIVATE);
                                String languageToLoad = shared_lang.getString("language", "en");
                                Locale locale = new Locale(languageToLoad);
                                Locale.setDefault(locale);
                                Configuration config = new Configuration();
                                config.locale = locale;
                                getApplicationContext().getResources().updateConfiguration(config, getApplicationContext().getResources().getDisplayMetrics());
                            } catch (Exception e) {
                            }

                            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
                            mNavigationView = (NavigationView) findViewById(R.id.shitstuff);
                            mDrawerLayout.setStatusBarBackgroundColor(Color.parseColor("#99000000"));
                            /**
                             * Lets inflate the very first fragment
                             * Here , we are inflating the TabFragment as the first Fragment
                             */

                            mFragmentManager = getSupportFragmentManager();
                            mFragmentTransaction = mFragmentManager.beginTransaction();

                            if (mFragmentManager.isStateSaved())
                                mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commitAllowingStateLoss();
                            else
                                mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();


                            toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
                            setSupportActionBar(toolbar);
                            invalidateOptionsMenu();

                            ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout, toolbar, R.string.app_name,
                                    R.string.app_name);

                            /**
                             * Setup click events on the Navigation View Items.
                             */
                            mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                                @Override
                                public boolean onNavigationItemSelected(MenuItem menuItem) {
                                    mDrawerLayout.closeDrawers();

                                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                                    try {
                                        SharedPreferences shared_lang = getApplicationContext().getSharedPreferences("LANG", Context.MODE_PRIVATE);
                                        String languageToLoad = shared_lang.getString("language", "en");
                                        Locale locale = new Locale(languageToLoad);
                                        Locale.setDefault(locale);
                                        Configuration config = new Configuration();
                                        config.locale = locale;
                                        getApplicationContext().getResources().updateConfiguration(config, getApplicationContext().getResources().getDisplayMetrics());
                                    } catch (Exception e) {
                                    }
                                    if (menuItem.getItemId() == R.id.nav_camera) {

                                        fragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
                                        toolbar.setTitle(getString(R.string.menu_cars));
                                        try {
                                            toolbar.setElevation(0);
                                        } catch (NoSuchMethodError e) {
                                        }
                                    }

                                    if (menuItem.getItemId() == R.id.nav_manage) {
                                        toolbar.setTitle(getString(R.string.menu_fast));
                                        fragmentTransaction.replace(R.id.containerView, new Fragment_F3()).commit();
                                        try {
                                            toolbar.setElevation(6);
                                        } catch (NoSuchMethodError e) {
                                        }
                                    }
                                    if (menuItem.getItemId() == R.id.news) {
                                        toolbar.setTitle(getString(R.string.menu_news));
                                        fragmentTransaction.replace(R.id.containerView, new Fragment_new()).commit();
                                        try {
                                            toolbar.setElevation(6);
                                        } catch (NoSuchMethodError e) {
                                        }
                                    }
                                    if (menuItem.getItemId() == R.id.dev_name) {
                                        toolbar.setTitle(getString(R.string.info_about));
                                        fragmentTransaction.replace(R.id.containerView, new ATabFragment()).commit();
                                        try {
                                            toolbar.setElevation(0);
                                        } catch (NoSuchMethodError e) {
                                        }
                                    }
                                    if (menuItem.getItemId() == R.id.eng) {
                                        fragmentTransaction.replace(R.id.containerView, new Fragment_Enger()).commit();
                                        toolbar.setTitle(getString(R.string.menu_engine));
                                        try {
                                            toolbar.setElevation(6);
                                        } catch (NoSuchMethodError e) {
                                        }
                                    }
                                    if (menuItem.getItemId() == R.id.pref) {
                                        fragmentTransaction.replace(R.id.containerView, new Fragment_Custom()).commit();
                                        toolbar.setTitle(getString(R.string.menu_custo));
                                        try {
                                            toolbar.setElevation(6);
                                        } catch (NoSuchMethodError e) {
                                        }
                                    }
                                    /*if (menuItem.getItemId() == R.id.nav_cmp) {
                                        //Toast.makeText(getApplicationContext(), "Will be Available Soon!", Toast.LENGTH_SHORT).show();
                                        fragmentTransaction.replace(R.id.containerView, new Fragment_cmp()).commit();
                                        toolbar.setTitle(getString(R.string.menu_cmp));
                                    }*/

                                    if (menuItem.getItemId() == R.id.help) {
                                        fragmentTransaction.replace(R.id.containerView, new Fragment_Help()).commit();
                                        toolbar.setTitle(getString(R.string.menu_help));
                                    }

                                    if (menuItem.getItemId() == R.id.a8tuner) {
                                        PackageManager manager = getApplicationContext().getPackageManager();
                                        try {
                                            Intent i = manager.getLaunchIntentForPackage("adnyey.a8tuner");
                                            if (i == null) {
                                                throw new ActivityNotFoundException();
                                            }
                                            i.addCategory(Intent.CATEGORY_LAUNCHER);
                                            getApplicationContext().startActivity(i);
                                        } catch (ActivityNotFoundException e) {
                                            if (DetectConnection.checkInternetConnection(MainActivity.this)) {
                                                new GetJsonFromUrl(MainActivity.this).execute("https://raw.githubusercontent.com/adnyey/A8-Tuner/master/update_changelog.json");
                                            } else
                                                Toast.makeText(MainActivity.this, getString(R.string.notif_internet), Toast.LENGTH_LONG).show();

                                        }

                                    }

                                    if (menuItem.getItemId() == R.id.mail_me) {
                                        Intent intent = new Intent(Intent.ACTION_SEND);
                                        intent.setType("plain/text");
                                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"adnyey.mail@gmail.com"});
                                        Toast.makeText(getApplicationContext(), getString(R.string.please_type), Toast.LENGTH_LONG).show();
                                        Toast.makeText(getApplicationContext(), getString(R.string.please_type), Toast.LENGTH_LONG).show();
                                        startActivity(Intent.createChooser(intent, ""));
                                    }

                                    if (menuItem.getItemId() == R.id.donate) {

                                        new Diag_Donate(MainActivity.this).show();

                                    }

                                    if (menuItem.getItemId() == R.id.a9dex) {
                                        PackageManager manager = getApplicationContext().getPackageManager();
                                        final String appPackageName = "adnyey.notitia.a9"; // getPackageName() from Context or Activity object
                                        try {
                                            Intent i = manager.getLaunchIntentForPackage(appPackageName);
                                            if (i == null) {
                                                throw new ActivityNotFoundException();
                                            }
                                            i.addCategory(Intent.CATEGORY_LAUNCHER);
                                            getApplicationContext().startActivity(i);
                                        } catch (ActivityNotFoundException e) {
                                            if (DetectConnection.checkInternetConnection(MainActivity.this)) {
                                                new GetJsonFromUrl(MainActivity.this).execute("https://raw.githubusercontent.com/adnyey/A9Dex/master/update_changelog.json");
                                            } else
                                                Toast.makeText(MainActivity.this, getString(R.string.notif_internet), Toast.LENGTH_LONG).show();
                                        }
                                    }


                                    return false;
                                }

                            });

                            mDrawerLayout.setDrawerListener(mDrawerToggle);

                            mDrawerToggle.syncState();

                            try {
                                SharedPreferences shared_lang = getApplicationContext().getSharedPreferences("LANG", Context.MODE_PRIVATE);
                                String languageToLoad = shared_lang.getString("language", "en");
                                Locale locale = new Locale(languageToLoad);
                                Locale.setDefault(locale);
                                Configuration config = new Configuration();
                                config.locale = locale;
                                getApplicationContext().getResources().updateConfiguration(config, getApplicationContext().getResources().getDisplayMetrics());
                            } catch (Exception e) {
                            }


                        }
                    });
                } catch (final Exception ex) {

                }
            }
        }.start();
        /**
         *Setup the DrawerLayout and NavigationView
         */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        try {
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
//            if (id == R.id.action_ad) {
//                buyAdFree();
//                return true;
//            }

            if (id == R.id.action_play) {
                PackageManager manager = getApplicationContext().getPackageManager();
                try {
                    Intent i = manager.getLaunchIntentForPackage("com.gameloft.android.ANMP.GloftA8HM");
                    if (i == null) {
                        throw new ActivityNotFoundException();
                    }
                    i.addCategory(Intent.CATEGORY_LAUNCHER);
                    getApplicationContext().startActivity(i);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), getString(R.string.launch_error), Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Opps! Something went wrong!", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean doubleBackToExitPressedOnce;
    private Handler mHandler = new Handler();

    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            doubleBackToExitPressedOnce = false;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mHandler != null) {
            mHandler.removeCallbacks(mRunnable);
        }
    }

    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            //drawer is open
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, getString(R.string.notif_exit), Toast.LENGTH_SHORT).show();

            mHandler.postDelayed(mRunnable, 2000);
        }

    }

}
