package adnyey.notitia.a8;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Mahajan-PC on 13-03-2017.
 */

public class Fragment_Help extends Fragment {

    String cmp;

    TextView cmp_disp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_help, container, false);

        cmp_disp=(TextView)view.findViewById(R.id.cmp_help);
        cmp =
        getString(R.string.normal_cars) +": MAX + PRO + "+getString(R.string.stats_tk)+
        "\nELITE "+getString(R.string.menu_cars)+": MAX + PRO + ELITE + "+getString(R.string.stats_tk)+
        "\n"+getString(R.string.car_race) +": PRO + "+getString(R.string.stats_tk)
        ;
        cmp_disp.setText(cmp);

        return view;
    }


}