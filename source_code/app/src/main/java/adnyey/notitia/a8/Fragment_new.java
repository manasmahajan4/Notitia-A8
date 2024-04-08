package adnyey.notitia.a8;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Admin on 12-03-2016.
 */
public class Fragment_new extends Fragment {
    WebView survey;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.events, container, false);
        survey= (WebView) view.findViewById(R.id.webView);
        survey.setWebViewClient(new WebViewClient());
        WebSettings webSettings = survey.getSettings();
        survey.loadUrl("http://in-game-news.gameloft.com/game-selector/?from=A8HM");
        webSettings.setJavaScriptEnabled(true);
        return view;
    }
    @Override
    public void onPause() {
        super.onPause();
        survey.loadUrl("about:blank");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!DetectConnection.checkInternetConnection(getContext())) {
            Snackbar.make(getView(), getString(R.string.notif_internet), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            survey.loadUrl("about:blank");
        }
        else
            Snackbar.make(getView(), getString(R.string.notif_load)+" . . . ", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
    }


}