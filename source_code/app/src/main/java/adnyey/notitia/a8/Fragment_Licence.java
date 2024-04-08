package adnyey.notitia.a8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Admin on 09-02-2016.
 */
public class Fragment_Licence extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.licences, container, false);
        Button aosp,suport,cc, chart,glide;
        aosp=(Button)view.findViewById(R.id.button2);
        chart=(Button)view.findViewById(R.id.button4);

        aosp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("http://source.android.com/");
            }
        });
        suport=(Button)view.findViewById(R.id.button);
        suport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("http://developer.android.com/intl/ru/tools/support-library/index.html");
            }
        });
        cc=(Button)view.findViewById(R.id.button3);
        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("http://creativecommons.org/licenses/by-sa/4.0/");
            }
        });


        glide=(Button)view.findViewById(R.id.button5);
        glide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://github.com/bumptech/glide");
            }
        });

        chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://github.com/PhilJay/MPAndroidChart");
            }
        });
        return view;
    }
    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }


}