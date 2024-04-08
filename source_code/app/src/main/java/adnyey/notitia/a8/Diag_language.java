package adnyey.notitia.a8;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Locale;

/**
 * Created by Mahajan-PC on 08-05-2017.
 */

public class Diag_language extends Dialog {

    ListView languages;
    String languageToLoad;
    OnMyDialogResult mDialogResult;
    String[] values = new String[]{"English", "Deutsch", "Español", "Bahasa Indonesia", "Italiano", "日本語", "한국어", "Português", "Pусский", "Türkçe", "简体中文"
    };

    public Diag_language(Context context) {
        super(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // same you have
        setContentView(R.layout.diag_language);
        setTitle(R.string.select_language);

        languages = (ListView) findViewById(R.id.lang_list);
        final SharedPreferences shared_lang = getContext().getSharedPreferences("LANG", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor_lang = shared_lang.edit();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        languages.setAdapter(adapter);

        languages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        languageToLoad = "en";
                        break;
                    case 1:
                        languageToLoad = "de";
                        break;
                    case 2:
                        languageToLoad = "es";
                        break;
                    case 3:
                        languageToLoad = "in";
                        break;
                    case 4:
                        languageToLoad = "it";
                        break;
                    case 5:
                        languageToLoad = "ja";
                        break;
                    case 6:
                        languageToLoad = "ko";
                        break;
                    case 7:
                        languageToLoad = "pt";
                        break;
                    case 8:
                        languageToLoad = "ru";
                        break;
                    case 9:
                        languageToLoad = "tr";
                        break;
                    case 10:
                        languageToLoad = "zh";
                        break;
                }

                try{
                if (shared_lang.getString("language", null).equals(languageToLoad)) {
                    mDialogResult.finish(0);
                    dismiss();
                } else {
                    Locale locale = new Locale(languageToLoad);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    getContext().getResources().updateConfiguration(config,
                            getContext().getResources().getDisplayMetrics());
                    editor_lang.putString("language", languageToLoad);
                    editor_lang.commit();

                    Intent refresh = new Intent(getContext(), MainActivity.class);
                    getContext().startActivity(refresh);
                    mDialogResult.finish(1);
                    dismiss();
                }}catch(NullPointerException e){
                    Locale locale = new Locale(languageToLoad);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    getContext().getResources().updateConfiguration(config,
                            getContext().getResources().getDisplayMetrics());
                    editor_lang.putString("language", languageToLoad);
                    editor_lang.commit();

                    Intent refresh = new Intent(getContext(), MainActivity.class);
                    getContext().startActivity(refresh);
                    mDialogResult.finish(1);
                    dismiss();
                }
            }
        });

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = getWindow();
        lp.copyFrom(window.getAttributes());

        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);


    }

    public void setDialogResult(OnMyDialogResult dialogResult) {
        mDialogResult = dialogResult;
    }

    public interface OnMyDialogResult {
        void finish(int result);
    }

}
