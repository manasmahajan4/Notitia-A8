package adnyey.notitia.a8;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mahajan-PC on 12-02-2017.
 */

public class Fragment_Enger extends Fragment {
    CarDBAccess myDbHelper;
    int size1, size2, size3, size4, size5, size6, size7, size8, size9, size10;
    int size11, size12, size13, size14, size15, size16, size17,size18,size19, size20,size21,size22,size23, size24, size25, size26;
    private int pointer1[], pointer2[], pointer3[], pointer4[], pointer5[], pointer6[], pointer7[], pointer8[], pointer9[], pointer10[];
    private int pointer11[], pointer12[], pointer13[], pointer14[], pointer15[], pointer16[], pointer17[],pointer18[],pointer19[], pointer20[],pointer21[],
            pointer22[],pointer23[], pointer24[], pointer25[], pointer26[];
    private List<EngObj> carList1, carList2, carList3, carList4, carList5, carList6, carList7, carList8, carList9, carList10;
    private List<EngObj> carList11, carList12, carList13, carList14, carList15, carList16, carList17,carList18,carList19, carList20, carList21, carList22,carList23, carList24, carList25, carList26;
    ExpandableHeightGridView upd1, upd2, upd3, upd4, upd5, upd6, upd7, upd8, upd9, upd10;
    ExpandableHeightGridView upd11, upd12, upd13, upd14, upd15, upd16, upd17,upd18,upd19, upd20,upd21, upd22,upd23, upd24, upd25, upd26;
    GridVIewAdapterEng GridVIewAdapterEng;
    ArrayList<EngObj> data1 = new ArrayList<EngObj>();
    ArrayList<EngObj> data2 = new ArrayList<EngObj>();
    ArrayList<EngObj> data3 = new ArrayList<EngObj>();
    ArrayList<EngObj> data4 = new ArrayList<EngObj>();
    ArrayList<EngObj> data5 = new ArrayList<EngObj>();
    ArrayList<EngObj> data6 = new ArrayList<EngObj>();
    ArrayList<EngObj> data7 = new ArrayList<EngObj>();
    ArrayList<EngObj> data8 = new ArrayList<EngObj>();
    ArrayList<EngObj> data9 = new ArrayList<EngObj>();
    ArrayList<EngObj> data10 = new ArrayList<EngObj>();
    ArrayList<EngObj> data11 = new ArrayList<EngObj>();
    ArrayList<EngObj> data12 = new ArrayList<EngObj>();
    ArrayList<EngObj> data13 = new ArrayList<EngObj>();
    ArrayList<EngObj> data14 = new ArrayList<EngObj>();
    ArrayList<EngObj> data15 = new ArrayList<EngObj>();
    ArrayList<EngObj> data16 = new ArrayList<EngObj>();
    ArrayList<EngObj> data17 = new ArrayList<EngObj>();
    ArrayList<EngObj> data18 = new ArrayList<EngObj>();
    ArrayList<EngObj> data19 = new ArrayList<EngObj>();
    ArrayList<EngObj> data20 = new ArrayList<EngObj>();
    ArrayList<EngObj> data21 = new ArrayList<EngObj>();
    ArrayList<EngObj> data22 = new ArrayList<EngObj>();
    ArrayList<EngObj> data23 = new ArrayList<EngObj>();
    ArrayList<EngObj> data24 = new ArrayList<EngObj>();
    ArrayList<EngObj> data25 = new ArrayList<EngObj>();
    ArrayList<EngObj> data26 = new ArrayList<EngObj>();
    int columns = 4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.layout_enger, container, false);
        final ProgressDialog mProgressDialog = new ProgressDialog(getContext(), R.style.LoadingTheme);
        mProgressDialog.show();
        mProgressDialog.setCancelable(false);
        float scalefactor = getResources().getDisplayMetrics().density * 100;
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenWidth = displaymetrics.widthPixels;
        columns = (int) ((float) screenWidth / (float) scalefactor);
        if (columns > 1 && columns < 5) {
            columns = columns - 1;
        } else if (columns >= 5) {
            columns = 3;
        }
        //columns=4;
        new Thread() {
            @Override
            public void run() {
                myDbHelper = CarDBAccess.getInstance(getContext());

                carList1 = myDbHelper.getEListerInput("cre");
                carList2 = myDbHelper.getEListerInput("sre");
                carList3 = myDbHelper.getEListerInput("v6");
                carList4 = myDbHelper.getEListerInput("hybrid");
                carList5 = myDbHelper.getEListerInput("v12");
                carList6 = myDbHelper.getEListerInput("i5");
                carList7 = myDbHelper.getEListerInput("v16");
                carList8 = myDbHelper.getEListerInput("f12");
                carList9 = myDbHelper.getEListerInput("electric");
                carList10 = myDbHelper.getEListerInput("rotary");
                carList11 = myDbHelper.getEListerInput("f6");
                carList12 = myDbHelper.getEListerInput("w16");
                carList13 = myDbHelper.getEListerInput("v10");
                carList14 = myDbHelper.getEListerInput("i4");
                carList15 = myDbHelper.getEListerInput("i6");
                carList16 = myDbHelper.getEListerInput("fiv8");
                carList17 = myDbHelper.getEListerInput("v8");
                carList18 = myDbHelper.getEListerInput("rare");
                carList19 = myDbHelper.getEListerInput("legend");
                carList20 = myDbHelper.getEListerInput("fse");
                carList21 = myDbHelper.getEListerInput("vte");
                carList22 = myDbHelper.getEListerInput("ffse");
                carList23 = myDbHelper.getEListerInput("hot");
                carList24 = myDbHelper.getEListerInput("electricl");
                carList25 = myDbHelper.getEListerInput("v12mpi");
                carList26 = myDbHelper.getEListerInput("i3");

                size1 = carList1.size();
                pointer1 = new int[size1];
                data1.clear();
                for (int i = 0; i < size1; i++) {
                    data1.add(new EngObj(carList1.get(i).getId(), carList1.get(i).getName(), carList1.get(i).getEngn(), carList1.get(i).getEng()));
                }
                for (int i = 0; i < size1; i++) {
                    pointer1[i] = carList1.get(i).getId();
                }

                size2 = carList2.size();
                pointer2 = new int[size2];
                data2.clear();
                for (int i = 0; i < size2; i++) {
                    data2.add(new EngObj(carList2.get(i).getId(), carList2.get(i).getName(), carList2.get(i).getEngn(), carList2.get(i).getEng()));
                }
                for (int i = 0; i < size2; i++) {
                    pointer2[i] = carList2.get(i).getId();
                }

                size3 = carList3.size();
                pointer3 = new int[size3];
                data3.clear();
                for (int i = 0; i < size3; i++) {
                    data3.add(new EngObj(carList3.get(i).getId(), carList3.get(i).getName(), carList3.get(i).getEngn(), carList3.get(i).getEng()));
                }
                for (int i = 0; i < size3; i++) {
                    pointer3[i] = carList3.get(i).getId();
                }

                size4 = carList4.size();
                pointer4 = new int[size4];
                data4.clear();
                for (int i = 0; i < size4; i++) {
                    data4.add(new EngObj(carList4.get(i).getId(), carList4.get(i).getName(), carList4.get(i).getEngn(), carList4.get(i).getEng()));
                }
                for (int i = 0; i < size4; i++) {
                    pointer4[i] = carList4.get(i).getId();
                }

                size5 = carList5.size();
                pointer5 = new int[size5];
                data5.clear();
                for (int i = 0; i < size5; i++) {
                    data5.add(new EngObj(carList5.get(i).getId(), carList5.get(i).getName(), carList5.get(i).getEngn(), carList5.get(i).getEng()));
                }
                for (int i = 0; i < size5; i++) {
                    pointer5[i] = carList5.get(i).getId();
                }

                size6 = carList6.size();
                pointer6 = new int[size6];
                data6.clear();
                for (int i = 0; i < size6; i++) {
                    data6.add(new EngObj(carList6.get(i).getId(), carList6.get(i).getName(), carList6.get(i).getEngn(), carList6.get(i).getEng()));
                }
                for (int i = 0; i < size6; i++) {
                    pointer6[i] = carList6.get(i).getId();
                }

                size7 = carList7.size();
                pointer7 = new int[size7];
                data7.clear();
                for (int i = 0; i < size7; i++) {
                    data7.add(new EngObj(carList7.get(i).getId(), carList7.get(i).getName(), carList7.get(i).getEngn(), carList7.get(i).getEng()));
                }
                for (int i = 0; i < size7; i++) {
                    pointer7[i] = carList7.get(i).getId();
                }

                size8 = carList8.size();
                pointer8 = new int[size8];
                data8.clear();
                for (int i = 0; i < size8; i++) {
                    data8.add(new EngObj(carList8.get(i).getId(), carList8.get(i).getName(), carList8.get(i).getEngn(), carList8.get(i).getEng()));
                }
                for (int i = 0; i < size8; i++) {
                    pointer8[i] = carList8.get(i).getId();
                }

                size9 = carList9.size();
                pointer9 = new int[size9];
                data9.clear();
                for (int i = 0; i < size9; i++) {
                    data9.add(new EngObj(carList9.get(i).getId(), carList9.get(i).getName(), carList9.get(i).getEngn(), carList9.get(i).getEng()));
                }
                for (int i = 0; i < size9; i++) {
                    pointer9[i] = carList9.get(i).getId();
                }

                size10 = carList10.size();
                pointer10 = new int[size10];
                data10.clear();
                for (int i = 0; i < size10; i++) {
                    data10.add(new EngObj(carList10.get(i).getId(), carList10.get(i).getName(), carList10.get(i).getEngn(), carList10.get(i).getEng()));
                }
                for (int i = 0; i < size10; i++) {
                    pointer10[i] = carList10.get(i).getId();
                }

                size11 = carList11.size();
                pointer11 = new int[size11];
                data11.clear();
                for (int i = 0; i < size11; i++) {
                    data11.add(new EngObj(carList11.get(i).getId(), carList11.get(i).getName(), carList11.get(i).getEngn(), carList11.get(i).getEng()));
                }
                for (int i = 0; i < size11; i++) {
                    pointer11[i] = carList11.get(i).getId();
                }

                size12 = carList12.size();
                pointer12 = new int[size12];
                data12.clear();
                for (int i = 0; i < size12; i++) {
                    data12.add(new EngObj(carList12.get(i).getId(), carList12.get(i).getName(), carList12.get(i).getEngn(), carList12.get(i).getEng()));
                }
                for (int i = 0; i < size12; i++) {
                    pointer12[i] = carList12.get(i).getId();
                }

                size13 = carList13.size();
                pointer13 = new int[size13];
                data13.clear();
                for (int i = 0; i < size13; i++) {
                    data13.add(new EngObj(carList13.get(i).getId(), carList13.get(i).getName(), carList13.get(i).getEngn(), carList13.get(i).getEng()));
                }
                for (int i = 0; i < size13; i++) {
                    pointer13[i] = carList13.get(i).getId();
                }

                size14 = carList14.size();
                pointer14 = new int[size14];
                data14.clear();
                for (int i = 0; i < size14; i++) {
                    data14.add(new EngObj(carList14.get(i).getId(), carList14.get(i).getName(), carList14.get(i).getEngn(), carList14.get(i).getEng()));
                }
                for (int i = 0; i < size14; i++) {
                    pointer14[i] = carList14.get(i).getId();
                }

                size15 = carList15.size();
                pointer15 = new int[size15];
                data15.clear();
                for (int i = 0; i < size15; i++) {
                    data15.add(new EngObj(carList15.get(i).getId(), carList15.get(i).getName(), carList15.get(i).getEngn(), carList15.get(i).getEng()));
                }
                for (int i = 0; i < size15; i++) {
                    pointer15[i] = carList15.get(i).getId();
                }

                size17 = carList17.size();
                pointer17 = new int[size17];
                data17.clear();
                for (int i = 0; i < size17; i++) {
                    data17.add(new EngObj(carList17.get(i).getId(), carList17.get(i).getName(), carList17.get(i).getEngn(), carList17.get(i).getEng()));
                }
                for (int i = 0; i < size17; i++) {
                    pointer17[i] = carList17.get(i).getId();
                }

                size16 = carList16.size();
                pointer16 = new int[size16];
                data16.clear();
                for (int i = 0; i < size16; i++) {
                    data16.add(new EngObj(carList16.get(i).getId(), carList16.get(i).getName(), carList16.get(i).getEngn(), carList16.get(i).getEng()));
                }
                for (int i = 0; i < size16; i++) {
                    pointer16[i] = carList16.get(i).getId();
                }

                size18 = carList18.size();
                pointer18 = new int[size18];
                data18.clear();
                for (int i = 0; i < size18; i++) {
                    data18.add(new EngObj(carList18.get(i).getId(), carList18.get(i).getName(), carList18.get(i).getEngn(), carList18.get(i).getEng()));
                }
                for (int i = 0; i < size18; i++) {
                    pointer18[i] = carList18.get(i).getId();
                }

                size19 = carList19.size();
                pointer19 = new int[size19];
                data19.clear();
                for (int i = 0; i < size19; i++) {
                    data19.add(new EngObj(carList19.get(i).getId(), carList19.get(i).getName(), carList19.get(i).getEngn(), carList19.get(i).getEng()));
                }
                for (int i = 0; i < size19; i++) {
                    pointer19[i] = carList19.get(i).getId();
                }

                size20 = carList20.size();
                pointer20 = new int[size20];
                data20.clear();
                for (int i = 0; i < size20; i++) {
                    data20.add(new EngObj(carList20.get(i).getId(), carList20.get(i).getName(), carList20.get(i).getEngn(), carList20.get(i).getEng()));
                }
                for (int i = 0; i < size20; i++) {
                    pointer20[i] = carList20.get(i).getId();
                }

                size21 = carList21.size();
                pointer21 = new int[size21];
                data21.clear();
                for (int i = 0; i < size21; i++) {
                    data21.add(new EngObj(carList21.get(i).getId(), carList21.get(i).getName(), carList21.get(i).getEngn(), carList21.get(i).getEng()));
                }
                for (int i = 0; i < size21; i++) {
                    pointer21[i] = carList21.get(i).getId();
                }

                size22 = carList22.size();
                pointer22 = new int[size22];
                data22.clear();
                for (int i = 0; i < size22; i++) {
                    data22.add(new EngObj(carList22.get(i).getId(), carList22.get(i).getName(), carList22.get(i).getEngn(), carList22.get(i).getEng()));
                }
                for (int i = 0; i < size22; i++) {
                    pointer22[i] = carList22.get(i).getId();
                }

                size23 = carList23.size();
                pointer23 = new int[size23];
                data23.clear();
                for (int i = 0; i < size23; i++) {
                    data23.add(new EngObj(carList23.get(i).getId(), carList23.get(i).getName(), carList23.get(i).getEngn(), carList23.get(i).getEng()));
                }
                for (int i = 0; i < size23; i++) {
                    pointer23[i] = carList23.get(i).getId();
                }


                size24 = carList24.size();
                pointer24 = new int[size24];
                data24.clear();
                for (int i = 0; i < size24; i++) {
                    data24.add(new EngObj(carList24.get(i).getId(), carList24.get(i).getName(), carList24.get(i).getEngn(), carList24.get(i).getEng()));
                }
                for (int i = 0; i < size24; i++) {
                    pointer24[i] = carList24.get(i).getId();
                }

                size25 = carList25.size();
                pointer25 = new int[size25];
                data25.clear();
                for (int i = 0; i < size25; i++) {
                    data25.add(new EngObj(carList25.get(i).getId(), carList25.get(i).getName(), carList25.get(i).getEngn(), carList25.get(i).getEng()));
                }
                for (int i = 0; i < size25; i++) {
                    pointer25[i] = carList25.get(i).getId();
                }

                size26 = carList26.size();
                pointer26 = new int[size26];
                data26.clear();
                for (int i = 0; i < size26; i++) {
                    data26.add(new EngObj(carList26.get(i).getId(), carList26.get(i).getName(), carList26.get(i).getEngn(), carList26.get(i).getEng()));
                }
                for (int i = 0; i < size26; i++) {
                    pointer26[i] = carList26.get(i).getId();
                }



                try {

                    // code runs in a thread
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            upd1 = (ExpandableHeightGridView) view.findViewById(R.id.upd1);
                            upd2 = (ExpandableHeightGridView) view.findViewById(R.id.upd2);
                            upd3 = (ExpandableHeightGridView) view.findViewById(R.id.upd3);
                            upd4 = (ExpandableHeightGridView) view.findViewById(R.id.upd4);
                            upd5 = (ExpandableHeightGridView) view.findViewById(R.id.upd5);
                            upd6 = (ExpandableHeightGridView) view.findViewById(R.id.upd6);
                            upd7 = (ExpandableHeightGridView) view.findViewById(R.id.upd7);
                            upd8 = (ExpandableHeightGridView) view.findViewById(R.id.upd8);
                            upd9 = (ExpandableHeightGridView) view.findViewById(R.id.upd9);
                            upd10 = (ExpandableHeightGridView) view.findViewById(R.id.upd10);
                            upd11 = (ExpandableHeightGridView) view.findViewById(R.id.upd11);
                            upd12 = (ExpandableHeightGridView) view.findViewById(R.id.upd12);
                            upd13 = (ExpandableHeightGridView) view.findViewById(R.id.upd13);
                            upd14 = (ExpandableHeightGridView) view.findViewById(R.id.upd14);
                            upd15 = (ExpandableHeightGridView) view.findViewById(R.id.upd15);
                            upd16 = (ExpandableHeightGridView) view.findViewById(R.id.upd16);
                            upd17 = (ExpandableHeightGridView) view.findViewById(R.id.upd17);
                            upd18 = (ExpandableHeightGridView) view.findViewById(R.id.upd18);
                            upd19 = (ExpandableHeightGridView) view.findViewById(R.id.upd19);
                            upd20 = (ExpandableHeightGridView) view.findViewById(R.id.upd20);
                            upd21 = (ExpandableHeightGridView) view.findViewById(R.id.upd21);
                            upd22 = (ExpandableHeightGridView) view.findViewById(R.id.upd22);
                            upd23 = (ExpandableHeightGridView) view.findViewById(R.id.upd23);
                            upd24 = (ExpandableHeightGridView) view.findViewById(R.id.upd24);
                            upd25 = (ExpandableHeightGridView) view.findViewById(R.id.upd25);
                            upd26 = (ExpandableHeightGridView) view.findViewById(R.id.upd26);

                            upd1.setExpanded(true);
                            upd2.setExpanded(true);
                            upd3.setExpanded(true);
                            upd4.setExpanded(true);
                            upd5.setExpanded(true);
                            upd6.setExpanded(true);
                            upd7.setExpanded(true);
                            upd8.setExpanded(true);
                            upd9.setExpanded(true);
                            upd10.setExpanded(true);
                            upd11.setExpanded(true);
                            upd12.setExpanded(true);
                            upd13.setExpanded(true);
                            upd14.setExpanded(true);
                            upd15.setExpanded(true);
                            upd16.setExpanded(true);
                            upd17.setExpanded(true);
                            upd18.setExpanded(true);
                            upd19.setExpanded(true);
                            upd20.setExpanded(true);
                            upd21.setExpanded(true);
                            upd22.setExpanded(true);
                            upd23.setExpanded(true);
                            upd24.setExpanded(true);
                            upd25.setExpanded(true);
                            upd26.setExpanded(true);

                            upd1.setNumColumns(columns);
                            upd2.setNumColumns(columns);
                            upd3.setNumColumns(columns);
                            upd4.setNumColumns(columns);
                            upd5.setNumColumns(columns);
                            upd6.setNumColumns(columns);
                            upd7.setNumColumns(columns);
                            upd8.setNumColumns(columns);
                            upd9.setNumColumns(columns);
                            upd10.setNumColumns(columns);
                            upd11.setNumColumns(columns);
                            upd12.setNumColumns(columns);
                            upd13.setNumColumns(columns);
                            upd14.setNumColumns(columns);
                            upd15.setNumColumns(columns);
                            upd16.setNumColumns(columns);
                            upd17.setNumColumns(columns);
                            upd18.setNumColumns(columns);
                            upd19.setNumColumns(columns);
                            upd20.setNumColumns(columns);
                            upd21.setNumColumns(columns);
                            upd22.setNumColumns(columns);
                            upd23.setNumColumns(columns);
                            upd24.setNumColumns(columns);
                            upd25.setNumColumns(columns);
                            upd26.setNumColumns(columns);

                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data1);
                            upd1.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data2);
                            upd2.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data3);
                            upd3.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data4);
                            upd4.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data5);
                            upd5.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data6);
                            upd6.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data7);
                            upd7.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data8);
                            upd8.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data9);
                            upd9.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data10);
                            upd10.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data11);
                            upd11.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data12);
                            upd12.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data13);
                            upd13.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data14);
                            upd14.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data15);
                            upd15.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data16);
                            upd16.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data17);
                            upd17.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data18);
                            upd18.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data19);
                            upd19.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data20);
                            upd20.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data21);
                            upd21.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data22);
                            upd22.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data23);
                            upd23.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data24);
                            upd24.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data25);
                            upd25.setAdapter(GridVIewAdapterEng);
                            GridVIewAdapterEng = new GridVIewAdapterEng(getActivity().getApplicationContext(), R.layout.grid_eng, data26);
                            upd26.setAdapter(GridVIewAdapterEng);

                            upd1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer1[position]);
                                    intent.putExtra("carlist", pointer1);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size1);
                                    startActivity(intent);
                                }
                            });

                            upd2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer2[position]);
                                    intent.putExtra("carlist", pointer2);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size2);
                                    startActivity(intent);
                                }
                            });

                            upd3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer3[position]);
                                    intent.putExtra("carlist", pointer3);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size3);
                                    startActivity(intent);
                                }
                            });

                            upd4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer4[position]);
                                    intent.putExtra("carlist", pointer4);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size4);
                                    startActivity(intent);
                                }
                            });

                            upd5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer5[position]);
                                    intent.putExtra("carlist", pointer5);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size5);
                                    startActivity(intent);
                                }
                            });

                            upd6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer6[position]);
                                    intent.putExtra("carlist", pointer6);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size6);
                                    startActivity(intent);
                                }
                            });

                            upd7.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer7[position]);
                                    intent.putExtra("carlist", pointer7);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size7);
                                    startActivity(intent);
                                }
                            });

                            upd8.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer8[position]);
                                    intent.putExtra("carlist", pointer8);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size8);
                                    startActivity(intent);
                                }
                            });

                            upd9.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer9[position]);
                                    intent.putExtra("carlist", pointer9);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size9);
                                    startActivity(intent);
                                }
                            });

                            upd10.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer10[position]);
                                    intent.putExtra("carlist", pointer10);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size10);
                                    startActivity(intent);
                                }
                            });
                            upd11.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer11[position]);
                                    intent.putExtra("carlist", pointer11);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size11);
                                    startActivity(intent);
                                }
                            });
                            upd12.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer12[position]);
                                    intent.putExtra("carlist", pointer12);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size12);
                                    startActivity(intent);
                                }
                            });
                            upd13.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer13[position]);
                                    intent.putExtra("carlist", pointer13);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size13);
                                    startActivity(intent);
                                }
                            });

                            upd14.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer14[position]);
                                    intent.putExtra("carlist", pointer14);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size14);
                                    startActivity(intent);
                                }
                            });

                            upd15.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer15[position]);
                                    intent.putExtra("carlist", pointer15);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size15);
                                    startActivity(intent);
                                }
                            });

                            upd16.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer16[position]);
                                    intent.putExtra("carlist", pointer16);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size16);
                                    startActivity(intent);
                                }
                            });
                            upd17.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer17[position]);
                                    intent.putExtra("carlist", pointer17);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size17);
                                    startActivity(intent);
                                }
                            });
                            upd18.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer18[position]);
                                    intent.putExtra("carlist", pointer18);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size18);
                                    startActivity(intent);
                                }
                            });
                            upd19.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer19[position]);
                                    intent.putExtra("carlist", pointer19);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size19);
                                    startActivity(intent);
                                }
                            });
                            upd20.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer20[position]);
                                    intent.putExtra("carlist", pointer20);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size20);
                                    startActivity(intent);
                                }
                            });
                            upd21.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer21[position]);
                                    intent.putExtra("carlist", pointer21);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size21);
                                    startActivity(intent);
                                }
                            });
                            upd22.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer22[position]);
                                    intent.putExtra("carlist", pointer22);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size22);
                                    startActivity(intent);
                                }
                            });
                            upd23.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer23[position]);
                                    intent.putExtra("carlist", pointer23);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size23);
                                    startActivity(intent);
                                }
                            });
                            upd24.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer24[position]);
                                    intent.putExtra("carlist", pointer24);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size24);
                                    startActivity(intent);
                                }
                            });
                            upd25.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer25[position]);
                                    intent.putExtra("carlist", pointer25);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size25);
                                    startActivity(intent);
                                }
                            });
                            upd26.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getContext(), Disper.class);
                                    intent.putExtra("carid", pointer26[position]);
                                    intent.putExtra("carlist", pointer26);
                                    intent.putExtra("listposition", position);
                                    intent.putExtra("listsize", size26);
                                    startActivity(intent);
                                }
                            });
                            mProgressDialog.dismiss();
                        }
                    });
                } catch (final Exception ex) {

                }
            }
        }.start();
        return view;
    }


}