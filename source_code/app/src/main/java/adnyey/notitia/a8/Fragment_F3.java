package adnyey.notitia.a8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Admin on 14-02-2016.
 */
public class Fragment_F3 extends Fragment {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.temp, container, false);
        expListView = (ExpandableListView) view.findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getActivity().getApplicationContext(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {


            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                if(groupPosition==0)
                {
                    if(childPosition==0)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=dxN5UfWQBKQ")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==1)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=d-EB36SR7tE")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==2)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=yzvtxEnBYmk")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==3)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=RhVW2aWqmw4")));
                        Log.i("Video", "Video Playing....");
                    }
                }
                if(groupPosition==1)
                {
                    if(childPosition==0)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=nnS5AiHjoME")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==1)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=2kkfFvSLIKQ")));
                        Log.i("Video", "Video Playing....");
                    }
                }
                if(groupPosition==2)
                {
                    if(childPosition==0)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=UF0Vr8NXuxk")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==1)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=HxuICIaRkFg")));
                        Log.i("Video", "Video Playing....");
                    }
                }
                if(groupPosition==3)
                {
                    if(childPosition==0)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=llML-eWYsWU")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==1)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=NIrbxHztMS8")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==2)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=qaKQUpMB_LI")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==3)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=XA8_QTDTuFU")));
                        Log.i("Video", "Video Playing....");
                    }
                }
                if(groupPosition==4)
                {
                    if(childPosition==0)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=5AblmIjoVE4")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==1)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=uBc82HkQviE")));
                        Log.i("Video", "Video Playing....");
                    }
                }
                if(groupPosition==5)
                {
                    if(childPosition==0)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=BXH-1XrLz14")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==1)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=B3J2EkBAQ_A")));
                        Log.i("Video", "Video Playing....");
                    }
                }
                if(groupPosition==6)
                {
                    if(childPosition==0)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=q4S6nXP_JoM")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==1)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=tmX7suVXixc")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==2)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=4tvKYQkeCKo")));
                        Log.i("Video", "Video Playing....");
                    }
                }
                if(groupPosition==7)
                {
                    if(childPosition==0)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=hJaKSyFH4SA")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==1)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=OE1HYJ6qSA0")));
                        Log.i("Video", "Video Playing....");
                    }
                }
                if(groupPosition==8)
                {
                    if(childPosition==0)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Hh1cYGrgTgc")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==1)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=zC49fdxOgzE")));
                        Log.i("Video", "Video Playing....");
                    }
                }
                if(groupPosition==9)
                {
                    if(childPosition==0)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=7tl55aS4FBs")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==1)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=o_kiaTgsfCk")));
                        Log.i("Video", "Video Playing....");
                    }
                }
                if(groupPosition==10)
                {
                    if(childPosition==0)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=5La5Bpmg0iY")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==1)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=rvfEke-KHAE")));
                        Log.i("Video", "Video Playing....");
                    }
                }
                if(groupPosition==11)
                {
                    if(childPosition==0)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=J53_MiLb2PU")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==1)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=YxwyX0KZw18")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==2)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=poqk9wbVrbM")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==3)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=n9Zwks01nH4")));
                        Log.i("Video", "Video Playing....");
                    }
                }
                if(groupPosition==12)
                {
                    if(childPosition==0)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=tF1RWKZPxCs")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==1)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=IpGtihX-p3E")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==2)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=BnVE5pX3Yvw")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==3)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=6V0Pt_bmCiU")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==4)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=kUNQKvW220s")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==5)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Z_s5o6rnYuk")));
                        Log.i("Video", "Video Playing....");
                    }
                }
                if(groupPosition==13)
                {
                    if(childPosition==0)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=qtBOa2Ilnnk")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==1)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=66lI4HW0j1g")));
                        Log.i("Video", "Video Playing....");
                    }
                }
                if(groupPosition==14)
                {
                    if(childPosition==0)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=FdncoDowxoI")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==1)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=JLOPbIbLG1E")));
                        Log.i("Video", "Video Playing....");
                    }
                }
                if(groupPosition==15)
                {
                    if(childPosition==0)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=5GnGTZ3xfog")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==1)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=DFlrooyXigM")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==2)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=3UT48m70ono")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==3)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=HK7wNELuvOM")));
                        Log.i("Video", "Video Playing....");
                    }
                }
                if(groupPosition==16)
                {
                    if(childPosition==0)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=9A9HI70m9Zs")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==1)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=_4rXfv_wfRc")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==2)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=_5q6LOu7r_o")));
                        Log.i("Video", "Video Playing....");
                    }
                    if(childPosition==3)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=TFp8QOR-SNE")));
                        Log.i("Video", "Video Playing....");
                    }
                }
                return false;
            }
        });

        return view;
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding group data
        listDataHeader.add("AREA 51");
        listDataHeader.add("ALPS");
        listDataHeader.add("BARCELONA");
        listDataHeader.add("DUBAI");
        listDataHeader.add("FRENCH GUIANA");
        listDataHeader.add("ICELAND");
        listDataHeader.add("LONDON");
        listDataHeader.add("AZURE COAST");
        listDataHeader.add("NEVADA");
        listDataHeader.add("SAN DIEGO HARBOUR");
        listDataHeader.add("SECTOR 8");
        listDataHeader.add("TENERIFE");
        listDataHeader.add("THE GREAT WALL");
        listDataHeader.add("TOKYO");
        listDataHeader.add("VENICE");
        listDataHeader.add("PATAGONIA");
        listDataHeader.add("RIO DE JANERIO");

        List<String> Rio = new ArrayList<String>();
        Rio.add("IPANEMA SHOWDOWN");
        Rio.add("RAPIDO PARK");
        Rio.add("HIGHLAND VIEW");
        Rio.add("OCEANVIEW DERBY");
        // Adding child data
        List<String> FiV8 = new ArrayList<String>();
        FiV8.add("CLASSIFIED");
        FiV8.add("ROUTE 375-1");
        FiV8.add("TEST SITE: OMEGA");
        FiV8.add("THE SECRET LAB");

        List<String> V8 = new ArrayList<String>();
        V8.add("ALPS");
        V8.add("ALPS REVERSE");

        List<String> V12 = new ArrayList<String>();
        V12.add("BARCELONA");
        V12.add("BARCELONA REVERSE");

        List<String> V6 = new ArrayList<String>();
        V6.add("DUBAI");
        V6.add("DUBAI REVERSE");
        V6.add("THE ROSE OF THE DESERT");
        V6.add("THE MIRAJE");

        List<String> Hybrid = new ArrayList<String>();
        Hybrid.add("FRENCE GUIANA");
        Hybrid.add("FRENCH GUIANA REVERSE");

        List<String> F6 = new ArrayList<String>();
        F6.add("ICELAND");
        F6.add("ICELAND REVERSE");

        List<String> W16 = new ArrayList<String>();
        W16.add("LONDON");
        W16.add("WESTMINSTER BRIDGE");
        W16.add("THE LONDON EYE");

        List<String> V10 = new ArrayList<String>();
        V10.add("AZURE COAST");
        V10.add("AZURE COAST REVERSE");

        List<String> i4 = new ArrayList<String>();
        i4.add("NEVADA");
        i4.add("NEVADA REVERSE");

        List<String> i6 = new ArrayList<String>();
        i6.add("SAN DIEGO HARBOUR");
        i6.add("SAN DIEGO HARBOUR REVERSE");

        List<String> V16 = new ArrayList<String>();
        V16.add("SECTOR 8");
        V16.add("SECTOR 8 REVERSE");

        List<String> F12 = new ArrayList<String>();
        F12.add("MOUNT TEIDE");
        F12.add("SKY DROP");
        F12.add("CLOUD NINE");
        F12.add("DRAGON TREE");

        List<String> Electric = new ArrayList<String>();
        Electric.add("THE DRAGON'S DEN");
        Electric.add("TEMPLE DRIVE");
        Electric.add("THE GREAT WALL");
        Electric.add("THE GREAT WALL REVERSE");
        Electric.add("BUDDHA'S TEACHINGS");
        Electric.add("WALL ASCENT");

        List<String> Rotary = new ArrayList<String>();
        Rotary.add("TOKYO");
        Rotary.add("TOKYO REVERSE");

        List<String> Venice = new ArrayList<String>();
        Venice.add("VENICE");
        Venice.add("VENICE REVERSE");

        List<String> Patagonia = new ArrayList<String>();
        Patagonia.add("AVALANCHE ALLEY");
        Patagonia.add("CRYSTAL LAKE");
        Patagonia.add("ICE CAVE");
        Patagonia.add("THE RIVER FORT");


        listDataChild.put(listDataHeader.get(0), FiV8); // Header, Child data
        listDataChild.put(listDataHeader.get(1), V8);
        listDataChild.put(listDataHeader.get(2), V12);
        listDataChild.put(listDataHeader.get(3), V6);
        listDataChild.put(listDataHeader.get(4), Hybrid);
        listDataChild.put(listDataHeader.get(5), F6);
        listDataChild.put(listDataHeader.get(6), W16);
        listDataChild.put(listDataHeader.get(7), V10);
        listDataChild.put(listDataHeader.get(8), i4);
        listDataChild.put(listDataHeader.get(9), i6);
        listDataChild.put(listDataHeader.get(10), V16);
        listDataChild.put(listDataHeader.get(11), F12);
        listDataChild.put(listDataHeader.get(12), Electric);
        listDataChild.put(listDataHeader.get(13), Rotary);
        listDataChild.put(listDataHeader.get(14), Venice);
        listDataChild.put(listDataHeader.get(15), Patagonia);
        listDataChild.put(listDataHeader.get(16), Rio);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!DetectConnection.checkInternetConnection(getContext())) {
            Snackbar.make(getView(), getString(R.string.notif_internet), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

}