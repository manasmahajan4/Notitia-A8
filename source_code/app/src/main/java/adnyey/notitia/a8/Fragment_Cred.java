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
 * Created by Admin on 11-03-2016.
 */
public class Fragment_Cred extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.credits, container, false);
        Button wiki,flatpic,hec,elebut,hambut,asphbut,complus,wikibut;

        wiki=(Button)view.findViewById(R.id.wikibut);
        wikibut=(Button)view.findViewById(R.id.wikiabut);
        wiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://plus.google.com/+MartinKneip");
            }
        });
        wikibut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("http://asphalt.wikia.com/wiki/Asphalt_Wiki");
            }
        });
        hec=(Button)view.findViewById(R.id.hectorbut);
        hec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.youtube.com/user/mghectorx");
            }
        });
        flatpic=(Button)view.findViewById(R.id.flaticonbut);
        flatpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("http://www.flaticon.com/authors/freepik");
            }
        });
        elebut=(Button)view.findViewById(R.id.elebut);
        elebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("http://www.flaticon.com/authors/elegant-themes");
            }
        });

        complus=(Button)view.findViewById(R.id.pluscom);
        complus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://plus.google.com/communities/112010654504584136859");
            }
        });

        hambut=(Button)view.findViewById(R.id.hambut);
        hambut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("http://www.flaticon.com/authors/hanan");
            }
        });
        asphbut=(Button)view.findViewById(R.id.asphbut);
        asphbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("http://www.gameloft.com/asphalt8/");
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