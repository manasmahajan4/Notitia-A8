package adnyey.notitia.a8;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by Admin on 01-04-2016.
 */
public class Fragment_cmp extends Fragment {
    private HorizontalBarChart Chart_TotalSpeed, Chart_TopSpeed, Chart_Handling, Chart_Accel, Chart_Nitro;
    String rankl, rankr, tsl, tsr, acr, acl, har, hal, nir, nil, tosr, tosl;
    StatsObj obj1, obj2;
    BasicInfo bobj1, bobj2;
    ProCObj cInfo1, cInfo2;
    ProNObj nInfo1, nInfo2;
    //EliteObj eliteStats1, eliteStats2;
    ImageView imgPartA, imgInitialA, imgEarlyA, imgMidA, imgAdvA, imgEngA, imgCommA, imgBkMidA, imgBkAdvA;
    TextView numPartA, numInitialA, numEarlyA, numMidA, numAdvA, numCommA, numEngA, numBkMidA, numBkAdvA;
    ImageView imgPartB, imgInitialB, imgEarlyB, imgMidB, imgAdvB, imgEngB, imgCommB, imgBkMidB, imgBkAdvB;
    TextView numPartB, numInitialB, numEarlyB, numMidB, numAdvB, numCommB, numEngB, numBkMidB, numBkAdvB;
    int PartA = 0, MidA = 0, AdvA = 0, EngA = 0, PriA = 0, maxA = 0, proA = 0, maxcA = 0, maxtA = 0, procA = 0, protA = 0,CommA = 0, bk_proA = 0, bk_advA = 0;
    int PartB = 0, MidB = 0, AdvB = 0, EngB = 0, PriB = 0, maxB = 0, proB = 0, maxcB = 0, maxtB = 0, procB = 0, protB = 0,CommB = 0, bk_proB = 0, bk_advB = 0;
    TableRow row_a_c, row_a_t, row_b_c, row_b_t;
    LinearLayout select1, select2;
    float nitro1, top1, han1, total1, accel1;
    float nitro2, top2, han2, total2, accel2;
    int value1, value2;
    SharedPreferences sharedpreferences, sharedpreferences1;
    ArrayList<GItem> data = new ArrayList<GItem>();
    TextView NameCar1, NameCar2, NameCost1, NameCost2, NameCards1, NameCards2, CostAC, CostACT, CostBC, CostBCT, CostACC, CostBCC;
    CarsSelector dialog1, dialog2;
    Button tutorial;
    CardView tutorial_card;
    CarDBAccess myDbHelper;
    String cmp;

    TextView cmp_disp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_compare, container, false);
        myDbHelper = CarDBAccess.getInstance(getContext());

        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        value1 = 1;
        value2 = 1;
        obj1 = new StatsObj();
        obj2 = new StatsObj();
        bobj1 = new BasicInfo();
        bobj2 = new BasicInfo();
        //eliteStats1 = new EliteObj();


        tutorial_card = (CardView) view.findViewById(R.id.help_compare_box);
        cmp_disp = (TextView) view.findViewById(R.id.cmp_help);
        cmp =
                getString(R.string.normal_cars) + ": MAX + PRO + " + getString(R.string.stats_tk) +
                        "\nELITE " + getString(R.string.menu_cars) + ": MAX + PRO + ELITE + " + getString(R.string.stats_tk) +
                        "\n" + getString(R.string.car_race) + ": PRO + " + getString(R.string.stats_tk)
        ;
        cmp_disp.setText(cmp);
        tutorial = (Button) view.findViewById(R.id.help_compare);
        sharedpreferences = this.getActivity().getSharedPreferences("EN_UNITS", Context.MODE_PRIVATE);
        sharedpreferences1 = this.getActivity().getSharedPreferences("EN_HELP_COMPARE", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences1.edit();
        if (sharedpreferences1.getBoolean("EN_HELP_COMPARE", false)) {
            tutorial_card.setVisibility(GONE);
        } else {
            tutorial_card.setVisibility(VISIBLE);
        }


        //eliteStats2 = new EliteObj();
        Starter();

        imgPartB = (ImageView) view.findViewById(R.id.imgPart_a);
        imgInitialB = (ImageView) view.findViewById(R.id.imgTechInitial_a);
        imgEarlyB = (ImageView) view.findViewById(R.id.imgTechEarly_a);
        imgMidB = (ImageView) view.findViewById(R.id.imgTechMid_a);
        imgAdvB = (ImageView) view.findViewById(R.id.imgTechAdv_a);
        imgEngB = (ImageView) view.findViewById(R.id.imgEng_a);
        imgCommB = (ImageView) view.findViewById(R.id.imgTechComm_a);
        imgBkAdvB = (ImageView) view.findViewById(R.id.imgTechLeg_a);
        imgBkMidB = (ImageView) view.findViewById(R.id.imgTechPro_a);

        imgPartA = (ImageView) view.findViewById(R.id.imgPart_b);
        imgInitialA = (ImageView) view.findViewById(R.id.imgTechInitial_b);
        imgEarlyA = (ImageView) view.findViewById(R.id.imgTechEarly_b);
        imgMidA = (ImageView) view.findViewById(R.id.imgTechMid_b);
        imgAdvA = (ImageView) view.findViewById(R.id.imgTechAdv_b);
        imgEngA = (ImageView) view.findViewById(R.id.imgEng_b);
        imgCommA = (ImageView) view.findViewById(R.id.imgTechComm_b);
        imgBkAdvA = (ImageView) view.findViewById(R.id.imgTechLeg_b);
        imgBkMidA = (ImageView) view.findViewById(R.id.imgTechPro_b);


        numPartB = (TextView) view.findViewById(R.id.numPart_a);
        numInitialB = (TextView) view.findViewById(R.id.numTechInitial_a);
        numEarlyB = (TextView) view.findViewById(R.id.numTechEarly_a);
        numMidB = (TextView) view.findViewById(R.id.numTechMid_a);
        numAdvB = (TextView) view.findViewById(R.id.numTechAdv_a);
        numEngB = (TextView) view.findViewById(R.id.numEng_a);
        numCommB = (TextView) view.findViewById(R.id.numTechComm_a);
        numBkAdvB = (TextView) view.findViewById(R.id.numTechLeg_a);
        numBkMidB = (TextView) view.findViewById(R.id.numTechPro_a);

        numPartA = (TextView) view.findViewById(R.id.numPart_b);
        numInitialA = (TextView) view.findViewById(R.id.numTechInitial_b);
        numEarlyA = (TextView) view.findViewById(R.id.numTechEarly_b);
        numMidA = (TextView) view.findViewById(R.id.numTechMid_b);
        numAdvA = (TextView) view.findViewById(R.id.numTechAdv_b);
        numEngA = (TextView) view.findViewById(R.id.numEng_b);
        numCommA = (TextView) view.findViewById(R.id.numTechComm_b);
        numBkAdvA = (TextView) view.findViewById(R.id.numTechLeg_b);
        numBkMidA = (TextView) view.findViewById(R.id.numTechPro_b);

        row_a_c = (TableRow) view.findViewById(R.id.cost_b_row);
        row_b_c = (TableRow) view.findViewById(R.id.cost_a_row);

        row_a_t = (TableRow) view.findViewById(R.id.cost_bt_row);
        row_b_t = (TableRow) view.findViewById(R.id.cost_at_row);

        row_a_t.setVisibility(GONE);
        row_b_t.setVisibility(GONE);

        CostAC = (TextView) view.findViewById(R.id.cost_b_row_val);
        CostBC = (TextView) view.findViewById(R.id.cost_a_row_val);

        CostACC = (TextView) view.findViewById(R.id.cost_bt_row_val);
        CostBCC = (TextView) view.findViewById(R.id.cost_at_row_val);

        CostACT = (TextView) view.findViewById(R.id.cost_btt_row_val);
        CostBCT = (TextView) view.findViewById(R.id.cost_att_row_val);

        NameCar1 = (TextView) view.findViewById(R.id.txtItem1);
        NameCar2 = (TextView) view.findViewById(R.id.txtItem2);

        NameCards1 = (TextView) view.findViewById(R.id.name_b_cards);
        NameCards2 = (TextView) view.findViewById(R.id.name_a_cards);

        NameCost1 = (TextView) view.findViewById(R.id.name_b_cost);
        NameCost2 = (TextView) view.findViewById(R.id.name_a_cost);

        select1 = (LinearLayout) view.findViewById(R.id.select_car1);
        select2 = (LinearLayout) view.findViewById(R.id.select_car2);

        refresher();


        rankl = rankr = tsl = tsr = acr = acl = har = hal = nir = nil = tosr = tosl = "#757575";
        Chart_TotalSpeed = (HorizontalBarChart) view.findViewById(R.id.chart_total_speed);
        Chart_Accel = (HorizontalBarChart) view.findViewById(R.id.chart_accel);
        Chart_Handling = (HorizontalBarChart) view.findViewById(R.id.chart_handling);
        Chart_Nitro = (HorizontalBarChart) view.findViewById(R.id.chart_nitro);
        Chart_TopSpeed = (HorizontalBarChart) view.findViewById(R.id.chart_top_speed);
        Finaler();

        dialog1 = new CarsSelector(getContext());
        dialog2 = new CarsSelector(getContext());

        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("EN_HELP_COMPARE", true);
                editor.apply();
                tutorial_card.setVisibility(GONE);
            }
        });

        select1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.show();
            }
        });

        select2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.show();
            }
        });

        dialog1.setDialogResult(new CarsSelector.OnMyDialogResult() {
            public void finish(int result) {
                value1 = result;
                Starter();
                Finaler1();
            }
        });

        dialog2.setDialogResult(new CarsSelector.OnMyDialogResult() {
            public void finish(int result) {
                value2 = result;
                Starter();
                Finaler1();
            }
        });


        return view;
    }

    void CardSetterTA() {
        if (PartA == 0) {
            imgPartA.setVisibility(GONE);
            numPartA.setVisibility(GONE);
        } else {
            imgPartA.setVisibility(VISIBLE);
            numPartA.setVisibility(VISIBLE);
            if (bobj1.getType() == 3 || bobj1.getType() == 4) {
                if (bobj1.getCarclass() == 1)
                    imgPartA.setImageResource(R.drawable.part_d_bk);
                if (bobj1.getCarclass() == 2)
                    imgPartA.setImageResource(R.drawable.part_c_bk);
                if (bobj1.getCarclass() == 3)
                    imgPartA.setImageResource(R.drawable.part_b_bk);
                if (bobj1.getCarclass() == 4)
                    imgPartA.setImageResource(R.drawable.part_a_bk);
                if (bobj1.getCarclass() == 5)
                    imgPartA.setImageResource(R.drawable.part_s_bk);
            } else {
                if (bobj1.getCarclass() == 1)
                    imgPartA.setImageResource(R.drawable.part_d);
                if (bobj1.getCarclass() == 2)
                    imgPartA.setImageResource(R.drawable.part_c);
                if (bobj1.getCarclass() == 3)
                    imgPartA.setImageResource(R.drawable.part_b);
                if (bobj1.getCarclass() == 4)
                    imgPartA.setImageResource(R.drawable.part_a);
                if (bobj1.getCarclass() == 5)
                    imgPartA.setImageResource(R.drawable.part_s);

            }
            numPartA.setText(NumberFormat.getIntegerInstance().format(PartA));
        }

        if (EngA == 0) {
            imgEngA.setVisibility(GONE);
            numEngA.setVisibility(GONE);
        } else {
            imgEngA.setVisibility(VISIBLE);
            numEngA.setVisibility(VISIBLE);
            if (bobj1.getEng().equals("cre"))
                imgEngA.setImageResource(R.drawable.eng_cre);
            if (bobj1.getEng().equals("electric"))
                imgEngA.setImageResource(R.drawable.eng_electric);
            if (bobj1.getEng().equals("f12"))
                imgEngA.setImageResource(R.drawable.eng_f12);
            if (bobj1.getEng().equals("f6"))
                imgEngA.setImageResource(R.drawable.eng_f6);
            if (bobj1.getEng().equals("fiv8"))
                imgEngA.setImageResource(R.drawable.eng_fiv8);
            if (bobj1.getEng().equals("hybrid"))
                imgEngA.setImageResource(R.drawable.eng_hybrid);
            if (bobj1.getEng().equals("i4"))
                imgEngA.setImageResource(R.drawable.eng_i4);
            if (bobj1.getEng().equals("i5"))
                imgEngA.setImageResource(R.drawable.eng_i5);
            if (bobj1.getEng().equals("i6"))
                imgEngA.setImageResource(R.drawable.eng_i6);
            if (bobj1.getEng().equals("rotary"))
                imgEngA.setImageResource(R.drawable.eng_rotary);
            if (bobj1.getEng().equals("sre"))
                imgEngA.setImageResource(R.drawable.eng_sre);
            if (bobj1.getEng().equals("v10"))
                imgEngA.setImageResource(R.drawable.eng_v10);
            if (bobj1.getEng().equals("v12"))
                imgEngA.setImageResource(R.drawable.eng_v12);
            if (bobj1.getEng().equals("v16"))
                imgEngA.setImageResource(R.drawable.eng_v16);
            if (bobj1.getEng().equals("v6"))
                imgEngA.setImageResource(R.drawable.eng_v6);
            if (bobj1.getEng().equals("v8"))
                imgEngA.setImageResource(R.drawable.eng_v8);
            if (bobj1.getEng().equals("w16"))
                imgEngA.setImageResource(R.drawable.eng_w16);
            if (bobj1.getEng().equals("rare"))
                imgEngA.setImageResource(R.drawable.eng_rare);
            if (bobj1.getEng().equals("legend"))
                imgEngA.setImageResource(R.drawable.eng_legend);
            if (bobj1.getEng().equals("fse"))
                imgEngA.setImageResource(R.drawable.eng_fse);
            if (bobj1.getEng().equals("vte"))
                imgEngA.setImageResource(R.drawable.eng_vte);
            if (bobj1.getEng().equals("ffse"))
                imgEngA.setImageResource(R.drawable.eng_ffse);
            if (bobj1.getEng().equals("hot"))
                imgEngA.setImageResource(R.drawable.eng_hot);
            numEngA.setText(NumberFormat.getIntegerInstance().format(EngA));
        }

        if (PriA == 0) {
            imgInitialA.setVisibility(GONE);
            numInitialA.setVisibility(GONE);
            imgEarlyA.setVisibility(GONE);
            numEarlyA.setVisibility(GONE);
        } else {
            imgInitialA.setVisibility(VISIBLE);
            numInitialA.setVisibility(VISIBLE);
            imgEarlyA.setVisibility(VISIBLE);
            numEarlyA.setVisibility(VISIBLE);

            numInitialA.setText(NumberFormat.getIntegerInstance().format(PriA));
            numEarlyA.setText(NumberFormat.getIntegerInstance().format(PriA));
        }

        if (MidA == 0) {
            imgMidA.setVisibility(GONE);
            numMidA.setVisibility(GONE);
        } else {
            imgMidA.setVisibility(VISIBLE);
            numMidA.setVisibility(VISIBLE);
            numMidA.setText(NumberFormat.getIntegerInstance().format(MidA));
        }

        if (AdvA == 0) {
            imgAdvA.setVisibility(GONE);
            numAdvA.setVisibility(GONE);
        } else {
            imgAdvA.setVisibility(VISIBLE);
            numAdvA.setVisibility(VISIBLE);
            numAdvA.setText(NumberFormat.getIntegerInstance().format(AdvA));
        }

        if (CommA == 0) {
            imgCommA.setVisibility(GONE);
            numCommA.setVisibility(GONE);
        } else {
            imgCommA.setVisibility(VISIBLE);
            numCommA.setVisibility(VISIBLE);
            numCommA.setText(NumberFormat.getIntegerInstance().format(CommA));
        }

        if (bk_advA == 0) {
            imgBkAdvA.setVisibility(GONE);
            numBkAdvA.setVisibility(GONE);
        } else {
            imgBkAdvA.setVisibility(VISIBLE);
            numBkAdvA.setVisibility(VISIBLE);
            numBkAdvA.setText(NumberFormat.getIntegerInstance().format(bk_advA));
        }

        if (bk_proA == 0) {
            numBkMidA.setVisibility(GONE);
            imgBkMidA.setVisibility(GONE);
        } else {
            imgBkMidA.setVisibility(VISIBLE);
            numBkMidA.setVisibility(VISIBLE);
            numBkMidA.setText(NumberFormat.getIntegerInstance().format(bk_proA));
        }

        row_a_t.setVisibility(VISIBLE);
        row_a_c.setVisibility(GONE);
        procA = maxcA + proA;
        protA = maxtA;
        CostACC.setText(NumberFormat.getIntegerInstance().format(procA));
        CostACT.setText(NumberFormat.getIntegerInstance().format(protA));

    }

    void costcalculatorTA() {
        maxcA = maxtA = 0;
        maxcA += nInfo1.getAccel1() + nInfo1.getTop1() + nInfo1.getHan1() + nInfo1.getNos1() +
                nInfo1.getAccel2() + nInfo1.getTop2() + nInfo1.getHan2() + nInfo1.getNos2() +
                nInfo1.getAccel3() + nInfo1.getHan3() +
                nInfo1.getTop4() + nInfo1.getNos4();

        maxtA += nInfo1.getTop3() + nInfo1.getNos3() +
                nInfo1.getAccel4() + nInfo1.getHan4() +
                nInfo1.getAccel5() + nInfo1.getTop5() + nInfo1.getHan5() + nInfo1.getNos5();

        proA += nInfo1.getTire1() + nInfo1.getSusp1() + nInfo1.getDrive1() + nInfo1.getExha1() +
                nInfo1.getTire2() + nInfo1.getSusp2() + nInfo1.getDrive2() + nInfo1.getExha2() +
                nInfo1.getTire3() + nInfo1.getSusp3() + nInfo1.getDrive3() + nInfo1.getExha3() +
                nInfo1.getTire4() + nInfo1.getSusp4() + nInfo1.getDrive4() + nInfo1.getExha4() +
                nInfo1.getTire5() + nInfo1.getSusp5() + nInfo1.getDrive5() + nInfo1.getExha5();
    }

    void CardBuilderTA() {
        PartA = EngA = 0;
        costcalculatorTA();
        PartA = nInfo1.getPart1() + nInfo1.getPart2() + nInfo1.getPart3() + nInfo1.getPart4() + nInfo1.getPart5();
        EngA = nInfo1.getEngn1() + nInfo1.getEngn2() + nInfo1.getEngn3() + nInfo1.getEngn4() + nInfo1.getEngn5();
        EngA = EngA * 4;
        procardsetA();
    }


    void CardSetterTB() {
        if (PartB == 0) {
            imgPartB.setVisibility(GONE);
            numPartB.setVisibility(GONE);
        } else {
            imgPartB.setVisibility(VISIBLE);
            numPartB.setVisibility(VISIBLE);
            if (bobj2.getType() == 3 || bobj2.getType() == 4) {
                if (bobj2.getCarclass() == 1)
                    imgPartB.setImageResource(R.drawable.part_d_bk);
                if (bobj2.getCarclass() == 2)
                    imgPartB.setImageResource(R.drawable.part_c_bk);
                if (bobj2.getCarclass() == 3)
                    imgPartB.setImageResource(R.drawable.part_b_bk);
                if (bobj2.getCarclass() == 4)
                    imgPartB.setImageResource(R.drawable.part_a_bk);
                if (bobj2.getCarclass() == 5)
                    imgPartB.setImageResource(R.drawable.part_s_bk);
            } else {
                if (bobj2.getCarclass() == 1)
                    imgPartB.setImageResource(R.drawable.part_d);
                if (bobj2.getCarclass() == 2)
                    imgPartB.setImageResource(R.drawable.part_c);
                if (bobj2.getCarclass() == 3)
                    imgPartB.setImageResource(R.drawable.part_b);
                if (bobj2.getCarclass() == 4)
                    imgPartB.setImageResource(R.drawable.part_a);
                if (bobj2.getCarclass() == 5)
                    imgPartB.setImageResource(R.drawable.part_s);
            }
            numPartB.setText(NumberFormat.getIntegerInstance().format(PartB));
        }

        if (EngB == 0) {
            imgEngB.setVisibility(GONE);
            numEngB.setVisibility(GONE);
        } else {
            imgEngB.setVisibility(VISIBLE);
            numEngB.setVisibility(VISIBLE);
            if (bobj2.getEng().equals("cre"))
                imgEngB.setImageResource(R.drawable.eng_cre);
            if (bobj2.getEng().equals("electric"))
                imgEngB.setImageResource(R.drawable.eng_electric);
            if (bobj2.getEng().equals("f12"))
                imgEngB.setImageResource(R.drawable.eng_f12);
            if (bobj2.getEng().equals("f6"))
                imgEngB.setImageResource(R.drawable.eng_f6);
            if (bobj2.getEng().equals("fiv8"))
                imgEngB.setImageResource(R.drawable.eng_fiv8);
            if (bobj2.getEng().equals("hybrid"))
                imgEngB.setImageResource(R.drawable.eng_hybrid);
            if (bobj2.getEng().equals("i4"))
                imgEngB.setImageResource(R.drawable.eng_i4);
            if (bobj2.getEng().equals("i5"))
                imgEngB.setImageResource(R.drawable.eng_i5);
            if (bobj2.getEng().equals("i6"))
                imgEngB.setImageResource(R.drawable.eng_i6);
            if (bobj2.getEng().equals("rotary"))
                imgEngB.setImageResource(R.drawable.eng_rotary);
            if (bobj2.getEng().equals("sre"))
                imgEngB.setImageResource(R.drawable.eng_sre);
            if (bobj2.getEng().equals("v10"))
                imgEngB.setImageResource(R.drawable.eng_v10);
            if (bobj2.getEng().equals("v12"))
                imgEngB.setImageResource(R.drawable.eng_v12);
            if (bobj2.getEng().equals("v16"))
                imgEngB.setImageResource(R.drawable.eng_v16);
            if (bobj2.getEng().equals("v6"))
                imgEngB.setImageResource(R.drawable.eng_v6);
            if (bobj2.getEng().equals("v8"))
                imgEngB.setImageResource(R.drawable.eng_v8);
            if (bobj2.getEng().equals("w16"))
                imgEngB.setImageResource(R.drawable.eng_w16);
            if (bobj2.getEng().equals("rare"))
                imgEngB.setImageResource(R.drawable.eng_rare);
            if (bobj2.getEng().equals("legend"))
                imgEngB.setImageResource(R.drawable.eng_legend);
            if (bobj2.getEng().equals("fse"))
                imgEngB.setImageResource(R.drawable.eng_fse);
            if (bobj2.getEng().equals("vte"))
                imgEngB.setImageResource(R.drawable.eng_vte);
            if (bobj2.getEng().equals("ffse"))
                imgEngB.setImageResource(R.drawable.eng_ffse);
            if (bobj2.getEng().equals("hot"))
                imgEngB.setImageResource(R.drawable.eng_hot);
            numEngB.setText(NumberFormat.getIntegerInstance().format(EngB));
        }

        if (PriB == 0) {
            imgInitialB.setVisibility(GONE);
            numInitialB.setVisibility(GONE);
            imgEarlyB.setVisibility(GONE);
            numEarlyB.setVisibility(GONE);
        } else {
            imgInitialB.setVisibility(VISIBLE);
            numInitialB.setVisibility(VISIBLE);
            imgEarlyB.setVisibility(VISIBLE);
            numEarlyB.setVisibility(VISIBLE);

            numInitialB.setText(NumberFormat.getIntegerInstance().format(PriB));
            numEarlyB.setText(NumberFormat.getIntegerInstance().format(PriB));
        }

        if (MidB == 0) {
            imgMidB.setVisibility(GONE);
            numMidB.setVisibility(GONE);
        } else {
            imgMidB.setVisibility(VISIBLE);
            numMidB.setVisibility(VISIBLE);
            numMidB.setText(NumberFormat.getIntegerInstance().format(MidB));
        }

        if (AdvB == 0) {
            imgAdvB.setVisibility(GONE);
            numAdvB.setVisibility(GONE);
        } else {
            imgAdvB.setVisibility(VISIBLE);
            numAdvB.setVisibility(VISIBLE);
            numAdvB.setText(NumberFormat.getIntegerInstance().format(AdvB));
        }

        if (CommB == 0) {
            imgCommB.setVisibility(GONE);
            numCommB.setVisibility(GONE);
        } else {
            imgCommB.setVisibility(VISIBLE);
            numCommB.setVisibility(VISIBLE);
            numCommB.setText(NumberFormat.getIntegerInstance().format(CommB));
        }

        if (bk_advB == 0) {
            imgBkAdvB.setVisibility(GONE);
            numBkAdvB.setVisibility(GONE);
        } else {
            imgBkAdvB.setVisibility(VISIBLE);
            numBkAdvB.setVisibility(VISIBLE);
            numBkAdvB.setText(NumberFormat.getIntegerInstance().format(bk_advB));
        }

        if (bk_proB == 0) {
            numBkMidB.setVisibility(GONE);
            imgBkMidB.setVisibility(GONE);
        } else {
            imgBkMidB.setVisibility(VISIBLE);
            numBkMidB.setVisibility(VISIBLE);
            numBkMidB.setText(NumberFormat.getIntegerInstance().format(bk_proB));
        }

        row_b_t.setVisibility(VISIBLE);
        row_b_c.setVisibility(GONE);
        procB = maxcB + proB;
        protB = maxtB;
        CostBCC.setText(NumberFormat.getIntegerInstance().format(procB));
        CostBCT.setText(NumberFormat.getIntegerInstance().format(protB));

    }

    void costcalculatorTB() {
        maxcB = maxtB = 0;
        maxcB += nInfo2.getAccel1() + nInfo2.getTop1() + nInfo2.getHan1() + nInfo2.getNos1() +
                nInfo2.getAccel2() + nInfo2.getTop2() + nInfo2.getHan2() + nInfo2.getNos2() +
                nInfo2.getAccel3() + nInfo2.getHan3() +
                nInfo2.getTop4() + nInfo2.getNos4();

        maxtB += nInfo2.getTop3() + nInfo2.getNos3() +
                nInfo2.getAccel4() + nInfo2.getHan4() +
                nInfo2.getAccel5() + nInfo2.getTop5() + nInfo2.getHan5() + nInfo2.getNos5();

        proB += nInfo2.getTire1() + nInfo2.getSusp1() + nInfo2.getDrive1() + nInfo2.getExha1() +
                nInfo2.getTire2() + nInfo2.getSusp2() + nInfo2.getDrive2() + nInfo2.getExha2() +
                nInfo2.getTire3() + nInfo2.getSusp3() + nInfo2.getDrive3() + nInfo2.getExha3() +
                nInfo2.getTire4() + nInfo2.getSusp4() + nInfo2.getDrive4() + nInfo2.getExha4() +
                nInfo2.getTire5() + nInfo2.getSusp5() + nInfo2.getDrive5() + nInfo2.getExha5();
    }

    void CardBuilderTB() {
        PartB = EngB = 0;
        costcalculatorTB();
        PartB = nInfo2.getPart1() + nInfo2.getPart2() + nInfo2.getPart3() + nInfo2.getPart4() + nInfo2.getPart5();
        EngB = nInfo2.getEngn1() + nInfo2.getEngn2() + nInfo2.getEngn3() + nInfo2.getEngn4() + nInfo2.getEngn5();
        EngB = EngB * 4;
        procardsetB();
    }


    void CardSetterA() {
        if (PartA == 0) {
            imgPartA.setVisibility(GONE);
            numPartA.setVisibility(GONE);
        } else {
            imgPartA.setVisibility(VISIBLE);
            numPartA.setVisibility(VISIBLE);
            if (bobj1.getType() == 3 || bobj1.getType() == 4) {
                if (bobj1.getCarclass() == 1)
                    imgPartA.setImageResource(R.drawable.part_d_bk);
                if (bobj1.getCarclass() == 2)
                    imgPartA.setImageResource(R.drawable.part_c_bk);
                if (bobj1.getCarclass() == 3)
                    imgPartA.setImageResource(R.drawable.part_b_bk);
                if (bobj1.getCarclass() == 4)
                    imgPartA.setImageResource(R.drawable.part_a_bk);
                if (bobj1.getCarclass() == 5)
                    imgPartA.setImageResource(R.drawable.part_s_bk);
            } else {
                if (bobj1.getCarclass() == 1)
                    imgPartA.setImageResource(R.drawable.part_d);
                if (bobj1.getCarclass() == 2)
                    imgPartA.setImageResource(R.drawable.part_c);
                if (bobj1.getCarclass() == 3)
                    imgPartA.setImageResource(R.drawable.part_b);
                if (bobj1.getCarclass() == 4)
                    imgPartA.setImageResource(R.drawable.part_a);
                if (bobj1.getCarclass() == 5)
                    imgPartA.setImageResource(R.drawable.part_s);
            }
            numPartA.setText(NumberFormat.getIntegerInstance().format(PartA));
        }

        if (EngA == 0) {
            imgEngA.setVisibility(GONE);
            numEngA.setVisibility(GONE);
        } else {
            imgEngA.setVisibility(VISIBLE);
            numEngA.setVisibility(VISIBLE);
            if(CommonStuff.engineFinder(bobj1.getEng())!=-1)
                imgEngA.setImageResource(CommonStuff.engineFinder(bobj1.getEng()));
            numEngA.setText(NumberFormat.getIntegerInstance().format(EngA));
        }

        if (PriA == 0) {
            imgInitialA.setVisibility(GONE);
            numInitialA.setVisibility(GONE);
            imgEarlyA.setVisibility(GONE);
            numEarlyA.setVisibility(GONE);
        } else {
            imgInitialA.setVisibility(VISIBLE);
            numInitialA.setVisibility(VISIBLE);
            imgEarlyA.setVisibility(VISIBLE);
            numEarlyA.setVisibility(VISIBLE);

            numInitialA.setText(NumberFormat.getIntegerInstance().format(PriA));
            numEarlyA.setText(NumberFormat.getIntegerInstance().format(PriA));
        }

        if (MidA == 0) {
            imgMidA.setVisibility(GONE);
            numMidA.setVisibility(GONE);
        } else {
            imgMidA.setVisibility(VISIBLE);
            numMidA.setVisibility(VISIBLE);
            numMidA.setText(NumberFormat.getIntegerInstance().format(MidA));
        }

        if (AdvA == 0) {
            imgAdvA.setVisibility(GONE);
            numAdvA.setVisibility(GONE);
        } else {
            imgAdvA.setVisibility(VISIBLE);
            numAdvA.setVisibility(VISIBLE);
            numAdvA.setText(NumberFormat.getIntegerInstance().format(AdvA));
        }

        row_a_t.setVisibility(GONE);
        row_a_c.setVisibility(VISIBLE);
        if (bobj1.getWin() == 3) {
            CostAC.setText(NumberFormat.getIntegerInstance().format(proA));
        } else {
            CostAC.setText(NumberFormat.getIntegerInstance().format((maxA + proA)));
        }
    }

    void CardSetterB() {
        if (PartB == 0) {
            imgPartB.setVisibility(GONE);
            numPartB.setVisibility(GONE);
        } else {
            imgPartB.setVisibility(VISIBLE);
            numPartB.setVisibility(VISIBLE);
            if (bobj2.getCarclass() == 1)
                imgPartB.setImageResource(R.drawable.part_d);
            if (bobj2.getCarclass() == 2)
                imgPartB.setImageResource(R.drawable.part_c);
            if (bobj2.getCarclass() == 3)
                imgPartB.setImageResource(R.drawable.part_b);
            if (bobj2.getCarclass() == 4)
                imgPartB.setImageResource(R.drawable.part_a);
            if (bobj2.getCarclass() == 5)
                imgPartB.setImageResource(R.drawable.part_s);
            numPartB.setText(NumberFormat.getIntegerInstance().format(PartB));
        }

        if (EngB == 0) {
            imgEngB.setVisibility(GONE);
            numEngB.setVisibility(GONE);
        } else {
            imgEngB.setVisibility(VISIBLE);
            numEngB.setVisibility(VISIBLE);
            if (bobj2.getEng().equals("cre"))
                imgEngB.setImageResource(R.drawable.eng_cre);
            if (bobj2.getEng().equals("electric"))
                imgEngB.setImageResource(R.drawable.eng_electric);
            if (bobj2.getEng().equals("f12"))
                imgEngB.setImageResource(R.drawable.eng_f12);
            if (bobj2.getEng().equals("f6"))
                imgEngB.setImageResource(R.drawable.eng_f6);
            if (bobj2.getEng().equals("fiv8"))
                imgEngB.setImageResource(R.drawable.eng_fiv8);
            if (bobj2.getEng().equals("hybrid"))
                imgEngB.setImageResource(R.drawable.eng_hybrid);
            if (bobj2.getEng().equals("i4"))
                imgEngB.setImageResource(R.drawable.eng_i4);
            if (bobj2.getEng().equals("i5"))
                imgEngB.setImageResource(R.drawable.eng_i5);
            if (bobj2.getEng().equals("i6"))
                imgEngB.setImageResource(R.drawable.eng_i6);
            if (bobj2.getEng().equals("rotary"))
                imgEngB.setImageResource(R.drawable.eng_rotary);
            if (bobj2.getEng().equals("sre"))
                imgEngB.setImageResource(R.drawable.eng_sre);
            if (bobj2.getEng().equals("v10"))
                imgEngB.setImageResource(R.drawable.eng_v10);
            if (bobj2.getEng().equals("v12"))
                imgEngB.setImageResource(R.drawable.eng_v12);
            if (bobj2.getEng().equals("v16"))
                imgEngB.setImageResource(R.drawable.eng_v16);
            if (bobj2.getEng().equals("v6"))
                imgEngB.setImageResource(R.drawable.eng_v6);
            if (bobj2.getEng().equals("v8"))
                imgEngB.setImageResource(R.drawable.eng_v8);
            if (bobj2.getEng().equals("w16"))
                imgEngB.setImageResource(R.drawable.eng_w16);
            if (bobj2.getEng().equals("rare"))
                imgEngB.setImageResource(R.drawable.eng_rare);
            if (bobj2.getEng().equals("legend"))
                imgEngB.setImageResource(R.drawable.eng_legend);
            numEngB.setText(NumberFormat.getIntegerInstance().format(EngB));
        }

        if (PriB == 0) {
            imgInitialB.setVisibility(GONE);
            numInitialB.setVisibility(GONE);
            imgEarlyB.setVisibility(GONE);
            numEarlyB.setVisibility(GONE);
        } else {
            imgInitialB.setVisibility(VISIBLE);
            numInitialB.setVisibility(VISIBLE);
            imgEarlyB.setVisibility(VISIBLE);
            numEarlyB.setVisibility(VISIBLE);

            numInitialB.setText(NumberFormat.getIntegerInstance().format(PriB));
            numEarlyB.setText(NumberFormat.getIntegerInstance().format(PriB));
        }

        if (MidB == 0) {
            imgMidB.setVisibility(GONE);
            numMidB.setVisibility(GONE);
        } else {
            imgMidB.setVisibility(VISIBLE);
            numMidB.setVisibility(VISIBLE);
            numMidB.setText(NumberFormat.getIntegerInstance().format(MidB));
        }

        if (AdvB == 0) {
            imgAdvB.setVisibility(GONE);
            numAdvB.setVisibility(GONE);
        } else {
            imgAdvB.setVisibility(VISIBLE);
            numAdvB.setVisibility(VISIBLE);
            numAdvB.setText(NumberFormat.getIntegerInstance().format(AdvB));
        }

        row_b_t.setVisibility(GONE);
        row_b_c.setVisibility(VISIBLE);
        if (bobj2.getWin() == 3) {
            CostBC.setText(NumberFormat.getIntegerInstance().format(proB));
        } else {
            CostBC.setText(NumberFormat.getIntegerInstance().format((maxB + proB)));
        }
    }

    void costcalculatorA() {
        proA = maxA = 0;
        if (bobj1.getWin() == 3) {
            proA += cInfo1.getTire1() + cInfo1.getSusp1() + cInfo1.getDrive1() + cInfo1.getExha1() +
                    cInfo1.getTire2() + cInfo1.getSusp2() + cInfo1.getDrive2() + cInfo1.getExha2() +
                    cInfo1.getTire3() + cInfo1.getSusp3() + cInfo1.getDrive3() + cInfo1.getExha3() +
                    cInfo1.getTire4() + cInfo1.getSusp4() + cInfo1.getDrive4() + cInfo1.getExha4() +
                    cInfo1.getTire5() + cInfo1.getSusp5() + cInfo1.getDrive5() + cInfo1.getExha5() +
                    cInfo1.getTire6() + cInfo1.getSusp6() + cInfo1.getDrive6() + cInfo1.getExha6() +
                    cInfo1.getTire7() + cInfo1.getSusp7() + cInfo1.getDrive7() + cInfo1.getExha7() +
                    cInfo1.getTire8() + cInfo1.getSusp8() + cInfo1.getDrive8() + cInfo1.getExha8() +
                    cInfo1.getTire9() + cInfo1.getSusp9() + cInfo1.getDrive9() + cInfo1.getExha9() +
                    cInfo1.getTire10() + cInfo1.getSusp10() + cInfo1.getDrive10() + cInfo1.getExha10();
        } else {
            maxA += nInfo1.getAccel1() + nInfo1.getTop1() + nInfo1.getHan1() + nInfo1.getNos1() +
                    nInfo1.getAccel2() + nInfo1.getTop2() + nInfo1.getHan2() + nInfo1.getNos2() +
                    nInfo1.getAccel3() + nInfo1.getTop3() + nInfo1.getHan3() + nInfo1.getNos3() +
                    nInfo1.getAccel4() + nInfo1.getTop4() + nInfo1.getHan4() + nInfo1.getNos4() +
                    nInfo1.getAccel5() + nInfo1.getTop5() + nInfo1.getHan5() + nInfo1.getNos5();

            proA += nInfo1.getTire1() + nInfo1.getSusp1() + nInfo1.getDrive1() + nInfo1.getExha1() +
                    nInfo1.getTire2() + nInfo1.getSusp2() + nInfo1.getDrive2() + nInfo1.getExha2() +
                    nInfo1.getTire3() + nInfo1.getSusp3() + nInfo1.getDrive3() + nInfo1.getExha3() +
                    nInfo1.getTire4() + nInfo1.getSusp4() + nInfo1.getDrive4() + nInfo1.getExha4() +
                    nInfo1.getTire5() + nInfo1.getSusp5() + nInfo1.getDrive5() + nInfo1.getExha5();
        }
    }

    void costcalculatorB() {
        proB = maxB = 0;
        if (bobj2.getWin() == 3) {
            proB += cInfo2.getTire1() + cInfo2.getSusp1() + cInfo2.getDrive1() + cInfo2.getExha1() +
                    cInfo2.getTire2() + cInfo2.getSusp2() + cInfo2.getDrive2() + cInfo2.getExha2() +
                    cInfo2.getTire3() + cInfo2.getSusp3() + cInfo2.getDrive3() + cInfo2.getExha3() +
                    cInfo2.getTire4() + cInfo2.getSusp4() + cInfo2.getDrive4() + cInfo2.getExha4() +
                    cInfo2.getTire5() + cInfo2.getSusp5() + cInfo2.getDrive5() + cInfo2.getExha5() +
                    cInfo2.getTire6() + cInfo2.getSusp6() + cInfo2.getDrive6() + cInfo2.getExha6() +
                    cInfo2.getTire7() + cInfo2.getSusp7() + cInfo2.getDrive7() + cInfo2.getExha7() +
                    cInfo2.getTire8() + cInfo2.getSusp8() + cInfo2.getDrive8() + cInfo2.getExha8() +
                    cInfo2.getTire9() + cInfo2.getSusp9() + cInfo2.getDrive9() + cInfo2.getExha9() +
                    cInfo2.getTire10() + cInfo2.getSusp10() + cInfo2.getDrive10() + cInfo2.getExha10();

        } else {
            maxB += nInfo2.getAccel1() + nInfo2.getTop1() + nInfo2.getHan1() + nInfo2.getNos1() +
                    nInfo2.getAccel2() + nInfo2.getTop2() + nInfo2.getHan2() + nInfo2.getNos2() +
                    nInfo2.getAccel3() + nInfo2.getTop3() + nInfo2.getHan3() + nInfo2.getNos3() +
                    nInfo2.getAccel4() + nInfo2.getTop4() + nInfo2.getHan4() + nInfo2.getNos4() +
                    nInfo2.getAccel5() + nInfo2.getTop5() + nInfo2.getHan5() + nInfo2.getNos5();

            proB += nInfo2.getTire1() + nInfo2.getSusp1() + nInfo2.getDrive1() + nInfo2.getExha1() +
                    nInfo2.getTire2() + nInfo2.getSusp2() + nInfo2.getDrive2() + nInfo2.getExha2() +
                    nInfo2.getTire3() + nInfo2.getSusp3() + nInfo2.getDrive3() + nInfo2.getExha3() +
                    nInfo2.getTire4() + nInfo2.getSusp4() + nInfo2.getDrive4() + nInfo2.getExha4() +
                    nInfo2.getTire5() + nInfo2.getSusp5() + nInfo2.getDrive5() + nInfo2.getExha5();
        }
    }

    void CardBuilderA() {
        PartA = EngA = 0;
        costcalculatorA();
        if (bobj1.getWin() == 3) {
            PartA = cInfo1.getPart1() + cInfo1.getPart2() + cInfo1.getPart3() + cInfo1.getPart4() + cInfo1.getPart5() + cInfo1.getPart6() + cInfo1.getPart7() + cInfo1.getPart8() + cInfo1.getPart9() + cInfo1.getPart10();
            EngA = cInfo1.getEngn1() + cInfo1.getEngn2() + cInfo1.getEngn3() + cInfo1.getEngn4() + cInfo1.getEngn5() + cInfo1.getEngn6() + cInfo1.getEngn7() + cInfo1.getEngn8() + cInfo1.getEngn9() + cInfo1.getEngn10();
            EngA = EngA * 4;
            procardsetCA();
        } else {
            PartA = nInfo1.getPart1() + nInfo1.getPart2() + nInfo1.getPart3() + nInfo1.getPart4() + nInfo1.getPart5();
            EngA = nInfo1.getEngn1() + nInfo1.getEngn2() + nInfo1.getEngn3() + nInfo1.getEngn4() + nInfo1.getEngn5();
            EngA = EngA * 4;
            procardsetA();
        }
    }

    void CardBuilderB() {
        PartB = EngB = 0;
        costcalculatorB();
        if (bobj2.getWin() == 3) {
            PartB = cInfo2.getPart1() + cInfo2.getPart2() + cInfo2.getPart3() + cInfo2.getPart4() + cInfo2.getPart5() + cInfo2.getPart6() + cInfo2.getPart7() + cInfo2.getPart8() + cInfo2.getPart9() + cInfo2.getPart10();
            EngB = cInfo2.getEngn1() + cInfo2.getEngn2() + cInfo2.getEngn3() + cInfo2.getEngn4() + cInfo2.getEngn5() + cInfo2.getEngn6() + cInfo2.getEngn7() + cInfo2.getEngn8() + cInfo2.getEngn9() + cInfo2.getEngn10();
            EngB = EngB * 4;
            procardsetCB();
        } else {
            PartB = nInfo2.getPart1() + nInfo2.getPart2() + nInfo2.getPart3() + nInfo2.getPart4() + nInfo2.getPart5();
            EngB = nInfo2.getEngn1() + nInfo2.getEngn2() + nInfo2.getEngn3() + nInfo2.getEngn4() + nInfo2.getEngn5();
            EngB = EngB * 4;
            procardsetB();
        }
    }

    private void procardsetCA() {
        PriA = MidA = AdvA = 0;

        if ((cInfo1.getTech11() == 1 && cInfo1.getTech21() == 2) || (cInfo1.getTech11() == 2 && cInfo1.getTech21() == 1)) {
            PriA = PriA + cInfo1.getTechn1();
        }
        if ((cInfo1.getTech12() == 1 && cInfo1.getTech22() == 2) || (cInfo1.getTech21() == 2 && cInfo1.getTech22() == 1)) {
            PriA = PriA + cInfo1.getTechn2();
        }
        if ((cInfo1.getTech13() == 1 && cInfo1.getTech23() == 2) || (cInfo1.getTech13() == 2 && cInfo1.getTech23() == 1)) {
            PriA = PriA + cInfo1.getTechn3();
        }
        if ((cInfo1.getTech14() == 1 && cInfo1.getTech24() == 2) || (cInfo1.getTech14() == 2 && cInfo1.getTech24() == 1)) {
            PriA = PriA + cInfo1.getTechn4();
        }
        if ((cInfo1.getTech15() == 1 && cInfo1.getTech25() == 2) || (cInfo1.getTech15() == 2 && cInfo1.getTech25() == 1)) {
            PriA = PriA + cInfo1.getTechn5();
        }
        if ((cInfo1.getTech16() == 1 && cInfo1.getTech26() == 2) || (cInfo1.getTech16() == 2 && cInfo1.getTech26() == 1)) {
            PriA = PriA + cInfo1.getTechn6();
        }
        if ((cInfo1.getTech17() == 1 && cInfo1.getTech27() == 2) || (cInfo1.getTech27() == 2 && cInfo1.getTech27() == 1)) {
            PriA = PriA + cInfo1.getTechn7();
        }
        if ((cInfo1.getTech18() == 1 && cInfo1.getTech28() == 2) || (cInfo1.getTech18() == 2 && cInfo1.getTech28() == 1)) {
            PriA = PriA + cInfo1.getTechn8();
        }
        if ((cInfo1.getTech19() == 1 && cInfo1.getTech29() == 2) || (cInfo1.getTech19() == 2 && cInfo1.getTech29() == 1)) {
            PriA = PriA + cInfo1.getTechn9();
        }
        if ((cInfo1.getTech110() == 1 && cInfo1.getTech210() == 2) || (cInfo1.getTech110() == 2 && cInfo1.getTech210() == 1)) {
            PriA = PriA + cInfo1.getTechn10();
        }

        if ((cInfo1.getTech11() == 3 && cInfo1.getTech21() == 3)) {
            MidA = MidA + cInfo1.getTechn1();
        }
        if ((cInfo1.getTech12() == 3 && cInfo1.getTech22() == 3)) {
            MidA = MidA + cInfo1.getTechn2();
        }
        if ((cInfo1.getTech13() == 3 && cInfo1.getTech23() == 3)) {
            MidA = MidA + cInfo1.getTechn3();
        }
        if ((cInfo1.getTech14() == 3 && cInfo1.getTech24() == 3)) {
            MidA = MidA + cInfo1.getTechn4();
        }
        if ((cInfo1.getTech15() == 3 && cInfo1.getTech25() == 3)) {
            MidA = MidA + cInfo1.getTechn5();
        }
        if ((cInfo1.getTech16() == 3 && cInfo1.getTech26() == 3)) {
            MidA = MidA + cInfo1.getTechn6();
        }
        if ((cInfo1.getTech17() == 3 && cInfo1.getTech27() == 3)) {
            MidA = MidA + cInfo1.getTechn7();
        }
        if ((cInfo1.getTech18() == 3 && cInfo1.getTech28() == 3)) {
            MidA = MidA + cInfo1.getTechn8();
        }
        if ((cInfo1.getTech19() == 3 && cInfo1.getTech29() == 3)) {
            MidA = MidA + cInfo1.getTechn9();
        }
        if ((cInfo1.getTech110() == 3 && cInfo1.getTech210() == 3)) {
            MidA = MidA + cInfo1.getTechn10();
        }


        if ((cInfo1.getTech11() == 4 && cInfo1.getTech21() == 4)) {
            AdvA = AdvA + cInfo1.getTechn1();
        }
        if ((cInfo1.getTech12() == 4 && cInfo1.getTech22() == 4)) {
            AdvA = AdvA + cInfo1.getTechn2();
        }
        if ((cInfo1.getTech13() == 4 && cInfo1.getTech23() == 4)) {
            AdvA = AdvA + cInfo1.getTechn3();
        }
        if ((cInfo1.getTech14() == 4 && cInfo1.getTech24() == 4)) {
            AdvA = AdvA + cInfo1.getTechn4();
        }
        if ((cInfo1.getTech15() == 4 && cInfo1.getTech25() == 4)) {
            AdvA = AdvA + cInfo1.getTechn5();
        }
        if ((cInfo1.getTech16() == 4 && cInfo1.getTech26() == 4)) {
            AdvA = AdvA + cInfo1.getTechn6();
        }
        if ((cInfo1.getTech17() == 4 && cInfo1.getTech27() == 4)) {
            AdvA = AdvA + cInfo1.getTechn7();
        }
        if ((cInfo1.getTech18() == 4 && cInfo1.getTech28() == 4)) {
            AdvA = AdvA + cInfo1.getTechn8();
        }
        if ((cInfo1.getTech19() == 4 && cInfo1.getTech29() == 4)) {
            AdvA = AdvA + cInfo1.getTechn9();
        }
        if ((cInfo1.getTech110() == 4 && cInfo1.getTech210() == 4)) {
            AdvA = AdvA + cInfo1.getTechn10();
        }

        PriA = PriA * 2;
        MidA = MidA * 4;
        AdvA = AdvA * 4;
    }

    private void procardsetA() {
        PriA = MidA = AdvA = 0;

        if ((nInfo1.getTech11() == 1 && nInfo1.getTech12() == 2) || (nInfo1.getTech11() == 2 && nInfo1.getTech12() == 1)) {
            PriA = PriA + nInfo1.getTechn1();
        }
        if ((nInfo1.getTech21() == 1 && nInfo1.getTech22() == 2) || (nInfo1.getTech21() == 2 && nInfo1.getTech22() == 1)) {
            PriA = PriA + nInfo1.getTechn2();
        }
        if ((nInfo1.getTech31() == 1 && nInfo1.getTech32() == 2) || (nInfo1.getTech31() == 2 && nInfo1.getTech32() == 1)) {
            PriA = PriA + nInfo1.getTechn3();
        }
        if ((nInfo1.getTech41() == 1 && nInfo1.getTech42() == 2) || (nInfo1.getTech41() == 2 && nInfo1.getTech42() == 1)) {
            PriA = PriA + nInfo1.getTechn4();
        }
        if ((nInfo1.getTech51() == 1 && nInfo1.getTech52() == 2) || (nInfo1.getTech51() == 2 && nInfo1.getTech52() == 1)) {
            PriA = PriA + nInfo1.getTechn5();
        }

        if ((nInfo1.getTech11() == 3 && nInfo1.getTech12() == 3)) {
            MidA = MidA + nInfo1.getTechn1();
        }
        if ((nInfo1.getTech21() == 3 && nInfo1.getTech22() == 3)) {
            MidA = MidA + nInfo1.getTechn2();
        }
        if ((nInfo1.getTech31() == 3 && nInfo1.getTech32() == 3)) {
            MidA = MidA + nInfo1.getTechn3();
        }
        if ((nInfo1.getTech41() == 3 && nInfo1.getTech42() == 3)) {
            MidA = MidA + nInfo1.getTechn4();
        }
        if ((nInfo1.getTech51() == 3 && nInfo1.getTech52() == 3)) {
            MidA = MidA + nInfo1.getTechn5();
        }


        if ((nInfo1.getTech11() == 4 && nInfo1.getTech12() == 4)) {
            AdvA = AdvA + nInfo1.getTechn1();
        }
        if ((nInfo1.getTech21() == 4 && nInfo1.getTech22() == 4)) {
            AdvA = AdvA + nInfo1.getTechn2();
        }
        if ((nInfo1.getTech31() == 4 && nInfo1.getTech32() == 4)) {
            AdvA = AdvA + nInfo1.getTechn3();
        }
        if ((nInfo1.getTech41() == 4 && nInfo1.getTech42() == 4)) {
            AdvA = AdvA + nInfo1.getTechn4();
        }
        if ((nInfo1.getTech51() == 4 && nInfo1.getTech52() == 4)) {
            AdvA = AdvA + nInfo1.getTechn5();
        }

        PriA = PriA * 2;
        MidA = MidA * 4;
        AdvA = AdvA * 4;
    }

    private void procardsetCB() {
        PriB = MidB = AdvB = 0;

        if ((cInfo2.getTech11() == 1 && cInfo2.getTech21() == 2) || (cInfo2.getTech11() == 2 && cInfo2.getTech21() == 1)) {
            PriB = PriB + cInfo2.getTechn1();
        }
        if ((cInfo2.getTech12() == 1 && cInfo2.getTech22() == 2) || (cInfo2.getTech21() == 2 && cInfo2.getTech22() == 1)) {
            PriB = PriB + cInfo2.getTechn2();
        }
        if ((cInfo2.getTech13() == 1 && cInfo2.getTech23() == 2) || (cInfo2.getTech13() == 2 && cInfo2.getTech23() == 1)) {
            PriB = PriB + cInfo2.getTechn3();
        }
        if ((cInfo2.getTech14() == 1 && cInfo2.getTech24() == 2) || (cInfo2.getTech14() == 2 && cInfo2.getTech24() == 1)) {
            PriB = PriB + cInfo2.getTechn4();
        }
        if ((cInfo2.getTech15() == 1 && cInfo2.getTech25() == 2) || (cInfo2.getTech15() == 2 && cInfo2.getTech25() == 1)) {
            PriB = PriB + cInfo2.getTechn5();
        }
        if ((cInfo2.getTech16() == 1 && cInfo2.getTech26() == 2) || (cInfo2.getTech16() == 2 && cInfo2.getTech26() == 1)) {
            PriB = PriB + cInfo2.getTechn6();
        }
        if ((cInfo2.getTech17() == 1 && cInfo2.getTech27() == 2) || (cInfo2.getTech27() == 2 && cInfo2.getTech27() == 1)) {
            PriB = PriB + cInfo2.getTechn7();
        }
        if ((cInfo2.getTech18() == 1 && cInfo2.getTech28() == 2) || (cInfo2.getTech18() == 2 && cInfo2.getTech28() == 1)) {
            PriB = PriB + cInfo2.getTechn8();
        }
        if ((cInfo2.getTech19() == 1 && cInfo2.getTech29() == 2) || (cInfo2.getTech19() == 2 && cInfo2.getTech29() == 1)) {
            PriB = PriB + cInfo2.getTechn9();
        }
        if ((cInfo2.getTech110() == 1 && cInfo2.getTech210() == 2) || (cInfo2.getTech110() == 2 && cInfo2.getTech210() == 1)) {
            PriB = PriB + cInfo2.getTechn10();
        }

        if ((cInfo2.getTech11() == 3 && cInfo2.getTech21() == 3)) {
            MidB = MidB + cInfo2.getTechn1();
        }
        if ((cInfo2.getTech12() == 3 && cInfo2.getTech22() == 3)) {
            MidB = MidB + cInfo2.getTechn2();
        }
        if ((cInfo2.getTech13() == 3 && cInfo2.getTech23() == 3)) {
            MidB = MidB + cInfo2.getTechn3();
        }
        if ((cInfo2.getTech14() == 3 && cInfo2.getTech24() == 3)) {
            MidB = MidB + cInfo2.getTechn4();
        }
        if ((cInfo2.getTech15() == 3 && cInfo2.getTech25() == 3)) {
            MidB = MidB + cInfo2.getTechn5();
        }
        if ((cInfo2.getTech16() == 3 && cInfo2.getTech26() == 3)) {
            MidB = MidB + cInfo2.getTechn6();
        }
        if ((cInfo2.getTech17() == 3 && cInfo2.getTech27() == 3)) {
            MidB = MidB + cInfo2.getTechn7();
        }
        if ((cInfo2.getTech18() == 3 && cInfo2.getTech28() == 3)) {
            MidB = MidB + cInfo2.getTechn8();
        }
        if ((cInfo2.getTech19() == 3 && cInfo2.getTech29() == 3)) {
            MidB = MidB + cInfo2.getTechn9();
        }
        if ((cInfo2.getTech110() == 3 && cInfo2.getTech210() == 3)) {
            MidB = MidB + cInfo2.getTechn10();
        }


        if ((cInfo2.getTech11() == 4 && cInfo2.getTech21() == 4)) {
            AdvB = AdvB + cInfo2.getTechn1();
        }
        if ((cInfo2.getTech12() == 4 && cInfo2.getTech22() == 4)) {
            AdvB = AdvB + cInfo2.getTechn2();
        }
        if ((cInfo2.getTech13() == 4 && cInfo2.getTech23() == 4)) {
            AdvB = AdvB + cInfo2.getTechn3();
        }
        if ((cInfo2.getTech14() == 4 && cInfo2.getTech24() == 4)) {
            AdvB = AdvB + cInfo2.getTechn4();
        }
        if ((cInfo2.getTech15() == 4 && cInfo2.getTech25() == 4)) {
            AdvB = AdvB + cInfo2.getTechn5();
        }
        if ((cInfo2.getTech16() == 4 && cInfo2.getTech26() == 4)) {
            AdvB = AdvB + cInfo2.getTechn6();
        }
        if ((cInfo2.getTech17() == 4 && cInfo2.getTech27() == 4)) {
            AdvB = AdvB + cInfo2.getTechn7();
        }
        if ((cInfo2.getTech18() == 4 && cInfo2.getTech28() == 4)) {
            AdvB = AdvB + cInfo2.getTechn8();
        }
        if ((cInfo2.getTech19() == 4 && cInfo2.getTech29() == 4)) {
            AdvB = AdvB + cInfo2.getTechn9();
        }
        if ((cInfo2.getTech110() == 4 && cInfo2.getTech210() == 4)) {
            AdvB = AdvB + cInfo2.getTechn10();
        }

        PriB = PriB * 2;
        MidB = MidB * 4;
        AdvB = AdvB * 4;
    }

    private void procardsetB() {
        PriB = MidB = AdvB = 0;

        if ((nInfo2.getTech11() == 1 && nInfo2.getTech12() == 2) || (nInfo2.getTech11() == 2 && nInfo2.getTech12() == 1)) {
            PriB = PriB + nInfo2.getTechn1();
        }
        if ((nInfo2.getTech21() == 1 && nInfo2.getTech22() == 2) || (nInfo2.getTech21() == 2 && nInfo2.getTech22() == 1)) {
            PriB = PriB + nInfo2.getTechn2();
        }
        if ((nInfo2.getTech31() == 1 && nInfo2.getTech32() == 2) || (nInfo2.getTech31() == 2 && nInfo2.getTech32() == 1)) {
            PriB = PriB + nInfo2.getTechn3();
        }
        if ((nInfo2.getTech41() == 1 && nInfo2.getTech42() == 2) || (nInfo2.getTech41() == 2 && nInfo2.getTech42() == 1)) {
            PriB = PriB + nInfo2.getTechn4();
        }
        if ((nInfo2.getTech51() == 1 && nInfo2.getTech52() == 2) || (nInfo2.getTech51() == 2 && nInfo2.getTech52() == 1)) {
            PriB = PriB + nInfo2.getTechn5();
        }

        if ((nInfo2.getTech11() == 3 && nInfo2.getTech12() == 3)) {
            MidB = MidB + nInfo2.getTechn1();
        }
        if ((nInfo2.getTech21() == 3 && nInfo2.getTech22() == 3)) {
            MidB = MidB + nInfo2.getTechn2();
        }
        if ((nInfo2.getTech31() == 3 && nInfo2.getTech32() == 3)) {
            MidB = MidB + nInfo2.getTechn3();
        }
        if ((nInfo2.getTech41() == 3 && nInfo2.getTech42() == 3)) {
            MidB = MidB + nInfo2.getTechn4();
        }
        if ((nInfo2.getTech51() == 3 && nInfo2.getTech52() == 3)) {
            MidB = MidB + nInfo2.getTechn5();
        }


        if ((nInfo2.getTech11() == 4 && nInfo2.getTech12() == 4)) {
            AdvB = AdvB + nInfo2.getTechn1();
        }
        if ((nInfo2.getTech21() == 4 && nInfo2.getTech22() == 4)) {
            AdvB = AdvB + nInfo2.getTechn2();
        }
        if ((nInfo2.getTech31() == 4 && nInfo2.getTech32() == 4)) {
            AdvB = AdvB + nInfo2.getTechn3();
        }
        if ((nInfo2.getTech41() == 4 && nInfo2.getTech42() == 4)) {
            AdvB = AdvB + nInfo2.getTechn4();
        }
        if ((nInfo2.getTech51() == 4 && nInfo2.getTech52() == 4)) {
            AdvB = AdvB + nInfo2.getTechn5();
        }

        PriB = PriB * 2;
        MidB = MidB * 4;
        AdvB = AdvB * 4;
    }

    void refresher() {
        imgPartA.setVisibility(GONE);
        numPartA.setVisibility(GONE);
        imgInitialA.setVisibility(GONE);
        numInitialA.setVisibility(GONE);
        imgEarlyA.setVisibility(GONE);
        numEarlyA.setVisibility(GONE);
        imgMidA.setVisibility(GONE);
        numMidA.setVisibility(GONE);
        imgAdvA.setVisibility(GONE);
        numAdvA.setVisibility(GONE);
        numCommA.setVisibility(GONE);
        imgCommA.setVisibility(GONE);
        numBkMidA.setVisibility(GONE);
        imgBkMidA.setVisibility(GONE);
        numBkAdvA.setVisibility(GONE);
        imgBkAdvA.setVisibility(GONE);
        PartA = 0;
        MidA = 0;
        AdvA = 0;
        EngA = 0;
        PriA = 0;
        maxA = 0;
        proA = 0;
        procA = 0;
        maxcA = 0;
        maxtA = 0;
        bk_advA = 0;
        bk_proA = 0;
        CommA =0;

        imgPartB.setVisibility(GONE);
        numPartB.setVisibility(GONE);
        imgInitialB.setVisibility(GONE);
        numInitialB.setVisibility(GONE);
        imgEarlyB.setVisibility(GONE);
        numEarlyB.setVisibility(GONE);
        imgMidB.setVisibility(GONE);
        numMidB.setVisibility(GONE);
        imgAdvB.setVisibility(GONE);
        numAdvB.setVisibility(GONE);
        numCommB.setVisibility(GONE);
        imgCommB.setVisibility(GONE);
        numBkMidB.setVisibility(GONE);
        imgBkMidB.setVisibility(GONE);
        numBkAdvB.setVisibility(GONE);
        imgBkAdvB.setVisibility(GONE);
        PartB = 0;
        MidB = 0;
        AdvB = 0;
        EngB = 0;
        PriB = 0;
        maxB = 0;
        proB = 0;
        procB = 0;
        maxcB = 0;
        maxtB = 0;
        bk_advB = 0;
        bk_proB = 0;
        CommB =0;
    }

    void Finaler() {
        Initializer();
        DataMakers();
        Chart_TotalSpeed.invalidate();
        Chart_Accel.invalidate();
        Chart_Handling.invalidate();
        Chart_Nitro.invalidate();
        Chart_TopSpeed.invalidate();
    }

    void Finaler1() {
        DataMakers();
        Chart_TotalSpeed.invalidate();
        Chart_Accel.invalidate();
        Chart_Handling.invalidate();
        Chart_Nitro.invalidate();
        Chart_TopSpeed.invalidate();
    }

    void Starter() {
        database(value1, value2);
        bobj1 = myDbHelper.getBasic(value1);
        bobj2 = myDbHelper.getBasic(value2);

        if (bobj1.getWin() == 3) {
            cInfo1 = new ProCObj();
            cInfo1 = myDbHelper.getProCInfo(bobj1.getId());
        } else {
            nInfo1 = new ProNObj();
            nInfo1 = myDbHelper.getProNInfo(bobj1.getId());
        }

        if (bobj2.getWin() == 3) {
            cInfo2 = new ProCObj();
            cInfo2 = myDbHelper.getProCInfo(bobj2.getId());
        } else {
            nInfo2 = new ProNObj();
            nInfo2 = myDbHelper.getProNInfo(bobj2.getId());
        }

/*        if (bobj1.getType() == 1) {
            eliteStats1 = myDbHelper.getEliteInfo(bobj1.getId());
            total1 = reals1(kmph2mph(eliteStats1.getT() + eliteStats1.getN()));
            nitro1 = reals1(kmph2mph(eliteStats1.getN()));
            han1 = eliteStats1.getH();
            top1 = reals1(kmph2mph(eliteStats1.getT()));
            accel1 = eliteStats1.getA();
        } else {*/
            total1 = reals1(kmph2mph(obj1.getT4() + obj1.getN4()));
            nitro1 = reals1(kmph2mph(obj1.getN4()));
            han1 = obj1.getH4();
            top1 = reals1(kmph2mph(obj1.getT4()));
            accel1 = obj1.getA4();
        //}

/*        if (bobj2.getType() == 1) {
            eliteStats2 = myDbHelper.getEliteInfo(bobj2.getId());
            total2 = reals2(kmph2mph(eliteStats2.getT() + eliteStats2.getN()));
            nitro2 = reals2(kmph2mph(eliteStats2.getN()));
            han2 = eliteStats2.getH();
            top2 = reals2(kmph2mph(eliteStats2.getT()));
            accel2 = eliteStats2.getA();
        } else {*/
            total2 = reals2(kmph2mph(obj2.getT4() + obj2.getN4()));
            nitro2 = reals2(kmph2mph(obj2.getN4()));
            han2 = obj2.getH4();
            top2 = reals2(kmph2mph(obj2.getT4()));
            accel2 = obj2.getA4();
        //}

    }

    void DataMakers() {
        ArrayList<BarEntry> yValues1, yValues2, yValues3, yValues4, yValues5, yValues6;
        BarDataSet set1, set2, set3, set4, set5, set6;
        BarData data1, data2, data3, data4, data5, data6;
        NameCar1.setText(bobj1.getName());

        NameCar2.setText(bobj2.getName());

        NameCost1.setText(bobj1.getName());
        NameCost2.setText(bobj2.getName());

        NameCards1.setText(bobj1.getName());
        NameCards2.setText(bobj2.getName());

        refresher();

        if (bobj1.getId() == 145 || bobj1.getId() == 146) {
            CardBuilderTA();
            CardSetterTA();
        } else {
            CardBuilderA();
            CardSetterA();
        }

        if (bobj2.getId() == 145 || bobj2.getId() == 146) {
            CardBuilderTB();
            CardSetterTB();
        } else {
            CardBuilderB();
            CardSetterB();
        }
        // TOTALSPEED

        yValues1 = new ArrayList<BarEntry>();
        yValues1.add(new BarEntry(5, new float[]{total1}));
        yValues1.add(new BarEntry(15, new float[]{total2}));

        if (total1 > total2) {
            nil = "#8BC34A";
            nir = "#F44336";
        } else if (total1 < total2) {
            nil = "#F44336";
            nir = "#8BC34A";
        } else {
            nil = "#757575";
            nir = "#757575";
        }
        set1 = new BarDataSet(yValues1, "");
        set1.setValueTextColor(Color.parseColor("#FFFFFF"));
        set1.setValueTextSize(16f);
        //set.setAxisDependency(YAxis.AxisDependency.RIGHT);
        set1.setColors(new int[]{Color.parseColor(nil), Color.parseColor(nir)});


        data1 = new BarData(set1);
        data1.setBarWidth(9f);
        data1.setValueFormatter(new MyTopFormatter());
        Chart_TotalSpeed.setData(data1);

        //ACCELERATION
        yValues2 = new ArrayList<BarEntry>();
        yValues2.add(new BarEntry(5, new float[]{accel1}));
        yValues2.add(new BarEntry(15, new float[]{accel2}));

        if (accel1 < accel2) {
            nil = "#8BC34A";
            nir = "#F44336";
        } else if (accel1 > accel2) {
            nil = "#F44336";
            nir = "#8BC34A";
        } else {
            nil = "#757575";
            nir = "#757575";
        }
        set2 = new BarDataSet(yValues2, "");
        set2.setValueTextColor(Color.parseColor("#FFFFFF"));
        set2.setValueTextSize(16f);
        //set.setAxisDependency(YAxis.AxisDependency.RIGHT);
        set2.setColors(new int[]{Color.parseColor(nil), Color.parseColor(nir)});

        data2 = new BarData(set2);
        data2.setBarWidth(9f);
        data2.setValueFormatter(new MyAccelFormatter());
        Chart_Accel.setData(data2);

        //HANDLING
        yValues3 = new ArrayList<BarEntry>();
        yValues3.add(new BarEntry(5, new float[]{han1}));
        yValues3.add(new BarEntry(15, new float[]{han2}));

        if (han1 > han2) {
            nil = "#8BC34A";
            nir = "#F44336";
        } else if (han1 < han2) {
            nil = "#F44336";
            nir = "#8BC34A";
        } else {
            nil = "#757575";
            nir = "#757575";
        }
        set3 = new BarDataSet(yValues3, "");
        set3.setValueTextColor(Color.parseColor("#FFFFFF"));
        set3.setValueTextSize(16f);
        //set.setAxisDependency(YAxis.AxisDependency.RIGHT);
        set3.setColors(new int[]{Color.parseColor(nil), Color.parseColor(nir)});

        data3 = new BarData(set3);
        data3.setBarWidth(9f);
        data3.setValueFormatter(new MyHandFormatter());
        Chart_Handling.setData(data3);

        //NITRO
        yValues4 = new ArrayList<BarEntry>();
        yValues4.add(new BarEntry(5, new float[]{nitro1}));
        yValues4.add(new BarEntry(15, new float[]{nitro2}));

        if (nitro1 > nitro2) {
            nil = "#8BC34A";
            nir = "#F44336";
        } else if (nitro1 < nitro2) {
            nil = "#F44336";
            nir = "#8BC34A";
        } else {
            nil = "#757575";
            nir = "#757575";
        }
        set4 = new BarDataSet(yValues4, "");
        set4.setValueTextColor(Color.parseColor("#FFFFFF"));
        set4.setValueTextSize(16f);
        //set.setAxisDependency(YAxis.AxisDependency.RIGHT);
        set4.setColors(new int[]{Color.parseColor(nil), Color.parseColor(nir)});

        data4 = new BarData(set4);
        data4.setBarWidth(9f);
        data4.setValueFormatter(new MyTopFormatter());
        Chart_Nitro.setData(data4);

        //Top SPEED
        yValues5 = new ArrayList<BarEntry>();
        yValues5.add(new BarEntry(5, new float[]{top1}));
        yValues5.add(new BarEntry(15, new float[]{top2}));

        if (top1 > top2) {
            nil = "#8BC34A";
            nir = "#F44336";
        } else if (top1 < top2) {
            nil = "#F44336";
            nir = "#8BC34A";
        } else {
            nil = "#757575";
            nir = "#757575";
        }
        set5 = new BarDataSet(yValues5, "");
        set5.setValueTextColor(Color.parseColor("#FFFFFF"));
        set5.setValueTextSize(16f);
        //set.setAxisDependency(YAxis.AxisDependency.RIGHT);
        set5.setColors(new int[]{Color.parseColor(nil), Color.parseColor(nir)});

        data5 = new BarData(set5);
        data5.setBarWidth(9f);
        data5.setValueFormatter(new MyTopFormatter());
        Chart_TopSpeed.setData(data5);
    }

    void Initializer() {

        NameCost1.setText(bobj1.getName());
        NameCost2.setText(bobj2.getName());

        NameCards1.setText(bobj1.getName());
        NameCards2.setText(bobj2.getName());

        Chart_TopSpeed.getDescription().setEnabled(false);
        Chart_TopSpeed.setBackgroundColor(Color.parseColor("#263238"));
        Chart_TopSpeed.setDrawGridBackground(false);
        Chart_TopSpeed.setDrawBarShadow(false);
        Chart_TopSpeed.setDrawValueAboveBar(false);
        Chart_TopSpeed.setTouchEnabled(false);
        Chart_TopSpeed.setHighlightFullBarEnabled(false);


        Chart_TopSpeed.getAxisLeft().setEnabled(false);
        Chart_TopSpeed.getAxisRight().setEnabled(false);

        Chart_TopSpeed.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        Chart_TopSpeed.getXAxis().setDrawGridLines(false);
        Chart_TopSpeed.getXAxis().setTextSize(16f);
        Chart_TopSpeed.getXAxis().setDrawAxisLine(false);
        Chart_TopSpeed.getXAxis().setAxisMinimum(0f);
        Chart_TopSpeed.getXAxis().setAxisMaximum(20f);
        Chart_TopSpeed.getXAxis().setGranularity(10f);

        Chart_TopSpeed.getXAxis().setTextColor(Color.parseColor("#FFFFFF"));
        Chart_TopSpeed.getXAxis().setCenterAxisLabels(true);

        Chart_TopSpeed.getXAxis().setValueFormatter(new IAxisValueFormatter() {

            private DecimalFormat format = new DecimalFormat("###");

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if (value == 0) {
                    return bobj1.getName();
                } else if (value == 10) {
                    return bobj2.getName();
                } else {
                    return "";
                }
                //return format.format(value) + "-" + format.format(value + 10);
            }
        });
        Chart_TopSpeed.getLegend().setEnabled(false);


        Chart_TotalSpeed.getDescription().setEnabled(false);
        Chart_TotalSpeed.setBackgroundColor(Color.parseColor("#263238"));
        Chart_TotalSpeed.setDrawGridBackground(false);
        Chart_TotalSpeed.setDrawBarShadow(false);
        Chart_TotalSpeed.setDrawValueAboveBar(false);
        Chart_TotalSpeed.setTouchEnabled(false);
        Chart_TotalSpeed.setHighlightFullBarEnabled(false);


        Chart_TotalSpeed.getAxisLeft().setEnabled(false);
        Chart_TotalSpeed.getAxisRight().setEnabled(false);

        Chart_TotalSpeed.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        Chart_TotalSpeed.getXAxis().setDrawGridLines(false);
        Chart_TotalSpeed.getXAxis().setTextSize(16f);
        Chart_TotalSpeed.getXAxis().setDrawAxisLine(false);
        Chart_TotalSpeed.getXAxis().setAxisMinimum(0f);
        Chart_TotalSpeed.getXAxis().setAxisMaximum(20f);
        Chart_TotalSpeed.getXAxis().setGranularity(10f);

        Chart_TotalSpeed.getXAxis().setTextColor(Color.parseColor("#FFFFFF"));
        Chart_TotalSpeed.getXAxis().setCenterAxisLabels(true);

        Chart_TotalSpeed.getXAxis().setValueFormatter(new IAxisValueFormatter() {

            private DecimalFormat format = new DecimalFormat("###");

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if (value == 0) {
                    return bobj1.getName();
                } else if (value == 10) {
                    return bobj2.getName();
                } else {
                    return "";
                }
                //return format.format(value) + "-" + format.format(value + 10);
            }
        });
        Chart_TotalSpeed.getLegend().setEnabled(false);

        Chart_Accel.getDescription().setEnabled(false);
        Chart_Accel.setBackgroundColor(Color.parseColor("#263238"));
        Chart_Accel.setDrawGridBackground(false);
        Chart_Accel.setDrawBarShadow(false);
        Chart_Accel.setDrawValueAboveBar(false);
        Chart_Accel.setTouchEnabled(false);
        Chart_Accel.setHighlightFullBarEnabled(false);


        Chart_Accel.getAxisLeft().setEnabled(false);
        Chart_Accel.getAxisRight().setEnabled(false);

        Chart_Accel.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        Chart_Accel.getXAxis().setDrawGridLines(false);
        Chart_Accel.getXAxis().setTextSize(16f);
        Chart_Accel.getXAxis().setDrawAxisLine(false);
        Chart_Accel.getXAxis().setAxisMinimum(0f);
        Chart_Accel.getXAxis().setAxisMaximum(20f);
        Chart_Accel.getXAxis().setGranularity(10f);

        Chart_Accel.getXAxis().setTextColor(Color.parseColor("#FFFFFF"));
        Chart_Accel.getXAxis().setCenterAxisLabels(true);

        Chart_Accel.getXAxis().setValueFormatter(new IAxisValueFormatter() {

            private DecimalFormat format = new DecimalFormat("###");

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if (value == 0) {
                    return bobj1.getName();
                } else if (value == 10) {
                    return bobj2.getName();
                } else {
                    return "";
                }
                //return format.format(value) + "-" + format.format(value + 10);
            }
        });
        Chart_Accel.getLegend().setEnabled(false);

        Chart_TopSpeed.getDescription().setEnabled(false);
        Chart_TopSpeed.setBackgroundColor(Color.parseColor("#263238"));
        Chart_TopSpeed.setDrawGridBackground(false);
        Chart_TopSpeed.setDrawBarShadow(false);
        Chart_TopSpeed.setDrawValueAboveBar(false);
        Chart_TopSpeed.setTouchEnabled(false);
        Chart_TopSpeed.setHighlightFullBarEnabled(false);


        Chart_TopSpeed.getAxisLeft().setEnabled(false);
        Chart_TopSpeed.getAxisRight().setEnabled(false);

        Chart_TopSpeed.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        Chart_TopSpeed.getXAxis().setDrawGridLines(false);
        Chart_TopSpeed.getXAxis().setTextSize(16f);
        Chart_TopSpeed.getXAxis().setDrawAxisLine(false);
        Chart_TopSpeed.getXAxis().setAxisMinimum(0f);
        Chart_TopSpeed.getXAxis().setAxisMaximum(20f);
        Chart_TopSpeed.getXAxis().setGranularity(10f);

        Chart_TopSpeed.getXAxis().setTextColor(Color.parseColor("#FFFFFF"));
        Chart_TopSpeed.getXAxis().setCenterAxisLabels(true);

        Chart_TopSpeed.getXAxis().setValueFormatter(new IAxisValueFormatter() {

            private DecimalFormat format = new DecimalFormat("###");

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if (value == 0) {
                    return bobj1.getName();
                } else if (value == 10) {
                    return bobj2.getName();
                } else {
                    return "";
                }
                //return format.format(value) + "-" + format.format(value + 10);
            }
        });
        Chart_TopSpeed.getLegend().setEnabled(false);

        Chart_Handling.getDescription().setEnabled(false);
        Chart_Handling.setBackgroundColor(Color.parseColor("#263238"));
        Chart_Handling.setDrawGridBackground(false);
        Chart_Handling.setDrawBarShadow(false);
        Chart_Handling.setDrawValueAboveBar(false);
        Chart_Handling.setTouchEnabled(false);
        Chart_Handling.setHighlightFullBarEnabled(false);


        Chart_Handling.getAxisLeft().setEnabled(false);
        Chart_Handling.getAxisRight().setEnabled(false);

        Chart_Handling.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        Chart_Handling.getXAxis().setDrawGridLines(false);
        Chart_Handling.getXAxis().setTextSize(16f);
        Chart_Handling.getXAxis().setDrawAxisLine(false);
        Chart_Handling.getXAxis().setAxisMinimum(0f);
        Chart_Handling.getXAxis().setAxisMaximum(20f);
        Chart_Handling.getXAxis().setGranularity(10f);

        Chart_Handling.getXAxis().setTextColor(Color.parseColor("#FFFFFF"));
        Chart_Handling.getXAxis().setCenterAxisLabels(true);

        Chart_Handling.getXAxis().setValueFormatter(new IAxisValueFormatter() {

            private DecimalFormat format = new DecimalFormat("###");

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if (value == 0) {
                    return bobj1.getName();
                } else if (value == 10) {
                    return bobj2.getName();
                } else {
                    return "";
                }
                //return format.format(value) + "-" + format.format(value + 10);
            }
        });
        Chart_Handling.getLegend().setEnabled(false);

        Chart_Nitro.getDescription().setEnabled(false);
        Chart_Nitro.setBackgroundColor(Color.parseColor("#263238"));
        Chart_Nitro.setDrawGridBackground(false);
        Chart_Nitro.setDrawBarShadow(false);
        Chart_Nitro.setDrawValueAboveBar(false);
        Chart_Nitro.setTouchEnabled(false);
        Chart_Nitro.setHighlightFullBarEnabled(false);


        Chart_Nitro.getAxisLeft().setEnabled(false);
        Chart_Nitro.getAxisRight().setEnabled(false);

        Chart_Nitro.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        Chart_Nitro.getXAxis().setDrawGridLines(false);
        Chart_Nitro.getXAxis().setTextSize(16f);
        Chart_Nitro.getXAxis().setDrawAxisLine(false);
        Chart_Nitro.getXAxis().setAxisMinimum(0f);
        Chart_Nitro.getXAxis().setAxisMaximum(20f);
        Chart_Nitro.getXAxis().setGranularity(10f);

        Chart_Nitro.getXAxis().setTextColor(Color.parseColor("#FFFFFF"));
        Chart_Nitro.getXAxis().setCenterAxisLabels(true);

        Chart_Nitro.getXAxis().setValueFormatter(new IAxisValueFormatter() {

            private DecimalFormat format = new DecimalFormat("###");

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if (value == 0) {
                    return bobj1.getName();
                } else if (value == 10) {
                    return bobj2.getName();
                } else {
                    return "";
                }
                //return format.format(value) + "-" + format.format(value + 10);
            }
        });
        Chart_Nitro.getLegend().setEnabled(false);
    }

    float reals1(double speed) {
        double modi = bobj1.getModi();
        float mph;
        if (modi == 0)
            mph = (float) speed;
        else
            mph = (float) (speed * modi * 0.01);
        return mph;
    }

    float reals2(double speed) {
        double modi = bobj2.getModi();
        float mph;
        if (modi == 0)
            mph = (float) speed;
        else
            mph = (float) (speed * modi * 0.01);
        return mph;
    }

    float kmph2mph(double kmph) {
        if (sharedpreferences.getBoolean("EN_UNITS", false)) {
            float mph = (float) (kmph * 0.621371192);
            return mph;
        } else
            return (float) kmph;
    }

    private void database(int i, int j) {
        try {
            myDbHelper = CarDBAccess.getInstance(getContext());
        } catch (Exception ioe) {
            throw new Error("Unable to create database");
        }

        try {
            myDbHelper = CarDBAccess.getInstance(getContext());
            obj1 = myDbHelper.getStats(i);
            obj2 = myDbHelper.getStats(j);
        } catch (SQLException sqle) {
            throw sqle;
        }
    }

    public class MyAccelFormatter implements IValueFormatter {

        protected DecimalFormat Format;

        public MyAccelFormatter() {
            Format = new DecimalFormat("#0.00");
        }

        // IValueFormatter
        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return Format.format(value);
        }


        public int getDecimalDigits() {
            return 1;
        }
    }

    public class MyTopFormatter implements IValueFormatter {

        protected DecimalFormat Format;

        public MyTopFormatter() {
            Format = new DecimalFormat("#0.0");
        }

        // IValueFormatter
        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return Format.format(value);
        }


        public int getDecimalDigits() {
            return 1;
        }
    }

    public class MyHandFormatter implements IValueFormatter {

        protected DecimalFormat Format;

        public MyHandFormatter() {
            Format = new DecimalFormat("#0.000");
        }

        // IValueFormatter
        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return Format.format(value);
        }


        public int getDecimalDigits() {
            return 1;
        }
    }



}