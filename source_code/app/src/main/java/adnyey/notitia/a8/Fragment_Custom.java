package adnyey.notitia.a8;

import android.content.Context;

import android.content.SharedPreferences;

import android.os.Bundle;

import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.CompoundButton;

import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by Admin on 14-03-2016.
 */
public class Fragment_Custom extends Fragment {
    ToggleButton units;
    TextView current_language;
    CardView language;
    public static final String UNITS_PREF = "EN_UNITS";
    SharedPreferences sharedpreferences, shared_lang;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings, container, false);

        units = (ToggleButton) view.findViewById(R.id.units);
        language = (CardView) view.findViewById(R.id.langer);
        current_language = (TextView) view.findViewById(R.id.current_language);

        current_language.setText(getString(R.string.current));

        units.setTextOff(getString(R.string.unit_kmph));
        units.setTextOn(getString(R.string.unit_mph));
        sharedpreferences = this.getActivity().getSharedPreferences(UNITS_PREF, Context.MODE_PRIVATE);
        shared_lang = this.getActivity().getSharedPreferences("LANG", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();
        if (sharedpreferences.getBoolean("EN_UNITS", false)) {
            units.setChecked(true);
        } else {
            units.setChecked(false);
        }

        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Diag_language lang_select = new Diag_language(getContext());
                lang_select.show();
                lang_select.setDialogResult(new Diag_language.OnMyDialogResult() {
                    public void finish(int result) {
                        if (result == 1) {
                            getActivity().finish();
                        }
                    }
                });
            }
        });

        units.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    editor.putBoolean("EN_UNITS", true);
                } else {
                    editor.putBoolean("EN_UNITS", false);
                }
                editor.apply();
            }
        });
        return view;
    }
}