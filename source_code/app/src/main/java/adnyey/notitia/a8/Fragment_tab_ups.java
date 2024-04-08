package adnyey.notitia.a8;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.NumberFormat;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by Mahajan-PC on 14-01-2017.
 */

public class Fragment_tab_ups extends Fragment {
    CarDBAccess myDbHelper;
    TableRow cost_m, cost_p, cost_mp, cost_mx, cost_px, cost_mpx;
    ImageView imgPart, imgInitial, imgEarly, imgMid, imgAdv, imgComm, imgEng, imgBkMid, imgBkAdv;
    TextView numPart, numInitial, numEarly, numMid, numAdv, numComm, numEng, numMax, numPro, numMaxPro, numTMaxC, numTMaxT, numTMPC, numTMPT, numBkMid, numBkAdv;
    int Part = 0, Mid = 0, Adv = 0, Eng = 0, Pri = 0, max = 0, pro = 0, maxc = 0, maxt = 0, proc = 0, prot = 0, Comm = 0, bk_pro = 0, bk_adv = 0;
    Button Maxer, Proer;
    ProCObj cInfo;
    BasicInfo basic;
    ProNObj nInfo;
    ProNBObj bInfo;
    LinearLayout max_pro_chunk;

    private Disper myActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_ups, container, false);

        basic = new BasicInfo();
        basic = myActivity.getMyInfo();
        myDbHelper = CarDBAccess.getInstance(getContext());
        imgPart = (ImageView) view.findViewById(R.id.imgPart);
        imgInitial = (ImageView) view.findViewById(R.id.imgTechInitial);
        imgEarly = (ImageView) view.findViewById(R.id.imgTechEarly);
        imgMid = (ImageView) view.findViewById(R.id.imgTechMid);
        imgAdv = (ImageView) view.findViewById(R.id.imgTechAdv);
        imgComm = (ImageView) view.findViewById(R.id.imgTechComm);
        imgBkAdv = (ImageView) view.findViewById(R.id.imgTechLeg);
        imgBkMid = (ImageView) view.findViewById(R.id.imgTechPro);

        imgEng = (ImageView) view.findViewById(R.id.imgEng);

        Maxer = (Button) view.findViewById(R.id.maxButt);
        Proer = (Button) view.findViewById(R.id.proButt);

        max_pro_chunk = (LinearLayout) view.findViewById(R.id.max_pro_chunk);

        cost_m = (TableRow) view.findViewById(R.id.cost_m_row);
        cost_p = (TableRow) view.findViewById(R.id.cost_p_row);
        cost_mp = (TableRow) view.findViewById(R.id.cost_mp_row);
        cost_mx = (TableRow) view.findViewById(R.id.cost_mx_row);
        cost_px = (TableRow) view.findViewById(R.id.cost_px_row);
        cost_mpx = (TableRow) view.findViewById(R.id.cost_mpx_row);

        cost_mx.setVisibility(GONE);
        cost_px.setVisibility(GONE);
        cost_mpx.setVisibility(GONE);

        numPart = (TextView) view.findViewById(R.id.numPart);
        numInitial = (TextView) view.findViewById(R.id.numTechInitial);
        numEarly = (TextView) view.findViewById(R.id.numTechEarly);
        numMid = (TextView) view.findViewById(R.id.numTechMid);
        numAdv = (TextView) view.findViewById(R.id.numTechAdv);
        numComm = (TextView) view.findViewById(R.id.numTechComm);
        numEng = (TextView) view.findViewById(R.id.numEng);
        numBkAdv = (TextView) view.findViewById(R.id.numTechLeg);
        numBkMid = (TextView) view.findViewById(R.id.numTechPro);

        numTMaxC = (TextView) view.findViewById(R.id.cost_mc);
        numTMaxT = (TextView) view.findViewById(R.id.cost_mt);
        numTMPC = (TextView) view.findViewById(R.id.cost_mpc);
        numTMPT = (TextView) view.findViewById(R.id.cost_mpt);

        numMax = (TextView) view.findViewById(R.id.cost_m);
        numPro = (TextView) view.findViewById(R.id.cost_p);
        numMaxPro = (TextView) view.findViewById(R.id.cost_mp);

        if (basic.getWin() == 3 || basic.getWin() == 9) {
            cInfo = new ProCObj();
            cost_m.setVisibility(GONE);
            cost_mp.setVisibility(GONE);
            Maxer.setVisibility(GONE);
            cInfo = myDbHelper.getProCInfo(basic.getId());
        } else {
            nInfo = new ProNObj();
            cost_m.setVisibility(VISIBLE);
            cost_mp.setVisibility(VISIBLE);
            Maxer.setVisibility(VISIBLE);
            if (basic.getType() == 3)
                bInfo = myDbHelper.getProNBInfo(basic.getId());
            else
                nInfo = myDbHelper.getProNInfo(basic.getId());
        }

        if(basic.getType() != 5) {
            max_pro_chunk.setVisibility(VISIBLE);
            refresher();
/*        if (basic.getId() == 145 || basic.getId() == 146) {
            CardBuilderT();
            CardSetterT();
        } else if (basic.getId() == 217) {
            CardBuilderT_1();
            CardSetterT_1();
        } else if (basic.getId() == 219 || basic.getId() == 227) {
            CardBuilderT_2();
            CardSetterT_2();
        } else if (basic.getId() == 220) {
            CardBuilderT_3();
            CardSetterT_3();
        } else if (basic.getId() == 228) {
            CardBuilderT_4();
            CardSetterT_4();
        } else if (basic.getId() == 225) {
            CardBuilderT_5();
            CardSetterT_5();
        } else if (basic.getId() == 232 || basic.getId() == 238) {
            CardBuilderT_6();
            CardSetterT_6();
        } else if (basic.getId() == 240) {
            CardBuilderT_7();
            CardSetterT_7();
        } else if (basic.getId() == 241 || basic.getId() == 248 || basic.getId() == 245 || basic.getId() == 252) {
            CardBuilderT_8();
            CardSetterT_8();
        } else if (basic.getId() == 243) {
            CardBuilderT_9();
            CardSetterT_9();
        } else if (basic.getId() == 244) {
            CardBuilderT_10();
            CardSetterT_10();
        } else {*/
            CardBuilder();
            CardSetter();
            //}
        }
        else
        {
            max_pro_chunk.setVisibility(GONE);
        }


        Maxer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (basic.getType() == 3)
                    new MaxerBD(getContext(), basic, bInfo);
                else
                    new MaxerD(getContext(), basic, nInfo);
            }
        });

        Proer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // custom dialog
                if (basic.getWin() == 3 || basic.getWin() == 9)
                    new ProerCD(getContext(), basic, cInfo);
                else {
                    if (basic.getType() == 3)
                        new ProerBD(getContext(), basic, bInfo);
                    else
                        new ProerD(getContext(), basic, nInfo);
                }
            }
        });


        return view;
    }

    void refresher() {
        imgPart.setVisibility(GONE);
        numPart.setVisibility(GONE);
        imgInitial.setVisibility(GONE);
        numInitial.setVisibility(GONE);
        imgEarly.setVisibility(GONE);
        numEarly.setVisibility(GONE);
        imgMid.setVisibility(GONE);
        numMid.setVisibility(GONE);
        imgAdv.setVisibility(GONE);
        numAdv.setVisibility(GONE);
        numComm.setVisibility(GONE);
        imgComm.setVisibility(GONE);
        numBkMid.setVisibility(GONE);
        imgBkMid.setVisibility(GONE);
        numBkAdv.setVisibility(GONE);
        imgBkAdv.setVisibility(GONE);
        Part = 0;
        Comm = 0;
        Mid = 0;
        Adv = 0;
        Comm = 0;
        Eng = 0;
        Pri = 0;
        max = 0;
        pro = 0;
        bk_adv = 0;
        bk_pro = 0;
    }

    void CardSetter() {
        if (Part == 0) {
            imgPart.setVisibility(GONE);
            numPart.setVisibility(GONE);
        }
        else if(basic.getWin()==9){

            imgPart.setVisibility(VISIBLE);
            numPart.setVisibility(VISIBLE);

            imgPart.setImageResource(R.drawable.part_bp);
            numPart.setText(NumberFormat.getIntegerInstance().format(Part*4));

            imgEng.setVisibility(GONE);
            numEng.setVisibility(GONE);

            imgInitial.setVisibility(GONE);
            numInitial.setVisibility(GONE);
            imgEarly.setVisibility(GONE);
            numEarly.setVisibility(GONE);

            imgMid.setVisibility(GONE);
            numMid.setVisibility(GONE);
            imgAdv.setVisibility(GONE);
            numAdv.setVisibility(GONE);

            imgComm.setVisibility(GONE);
            numComm.setVisibility(GONE);

            imgBkAdv.setVisibility(GONE);
            numBkAdv.setVisibility(GONE);

            numBkMid.setVisibility(GONE);
            imgBkMid.setVisibility(GONE);
        }
        else {
            imgPart.setVisibility(VISIBLE);
            numPart.setVisibility(VISIBLE);
            if (basic.getType() == 3 || basic.getType() == 4) {
                if (basic.getCarclass() == 1)
                    imgPart.setImageResource(R.drawable.part_d_bk);
                if (basic.getCarclass() == 2)
                    imgPart.setImageResource(R.drawable.part_c_bk);
                if (basic.getCarclass() == 3)
                    imgPart.setImageResource(R.drawable.part_b_bk);
                if (basic.getCarclass() == 4)
                    imgPart.setImageResource(R.drawable.part_a_bk);
                if (basic.getCarclass() == 5)
                    imgPart.setImageResource(R.drawable.part_s_bk);
            } else {
                if (CommonStuff.partsFinder(basic.getCarclass()) != -1)
                    imgPart.setImageResource(CommonStuff.partsFinder(basic.getCarclass()));
            }
            numPart.setText(NumberFormat.getIntegerInstance().format(Part));
        }

        if (Eng == 0) {
            imgEng.setVisibility(GONE);
            numEng.setVisibility(GONE);
        } else {
            imgEng.setVisibility(VISIBLE);
            numEng.setVisibility(VISIBLE);
            if (CommonStuff.engineFinder(basic.getEng()) != -1)
                imgEng.setImageResource(CommonStuff.engineFinder(basic.getEng()));
            if (basic.getId() == 215) {
                numEng.setText(NumberFormat.getIntegerInstance().format(Eng - 2));
            } else {
                numEng.setText(NumberFormat.getIntegerInstance().format(Eng));
            }
        }

        if (Pri == 0) {
            imgInitial.setVisibility(GONE);
            numInitial.setVisibility(GONE);
            imgEarly.setVisibility(GONE);
            numEarly.setVisibility(GONE);
        } else {
            imgInitial.setVisibility(VISIBLE);
            numInitial.setVisibility(VISIBLE);
            imgEarly.setVisibility(VISIBLE);
            numEarly.setVisibility(VISIBLE);

            numInitial.setText(NumberFormat.getIntegerInstance().format(Pri));
            numEarly.setText(NumberFormat.getIntegerInstance().format(Pri));
        }

        if (Mid == 0) {
            imgMid.setVisibility(GONE);
            numMid.setVisibility(GONE);
        } else {
            imgMid.setVisibility(VISIBLE);
            numMid.setVisibility(VISIBLE);
            numMid.setText(NumberFormat.getIntegerInstance().format(Mid));
        }

        if (Adv == 0) {
            imgAdv.setVisibility(GONE);
            numAdv.setVisibility(GONE);
        } else {
            imgAdv.setVisibility(VISIBLE);
            numAdv.setVisibility(VISIBLE);
            numAdv.setText(NumberFormat.getIntegerInstance().format(Adv));
        }

        if (Comm == 0) {
            imgComm.setVisibility(GONE);
            numComm.setVisibility(GONE);
        } else {
            imgComm.setVisibility(VISIBLE);
            numComm.setVisibility(VISIBLE);
            numComm.setText(NumberFormat.getIntegerInstance().format(Comm));
        }

        if (bk_adv == 0) {
            imgBkAdv.setVisibility(GONE);
            numBkAdv.setVisibility(GONE);
        } else {
            imgBkAdv.setVisibility(VISIBLE);
            numBkAdv.setVisibility(VISIBLE);
            numBkAdv.setText(NumberFormat.getIntegerInstance().format(bk_adv));
        }

        if (bk_pro == 0) {
            numBkMid.setVisibility(GONE);
            imgBkMid.setVisibility(GONE);
        } else {
            imgBkMid.setVisibility(VISIBLE);
            numBkMid.setVisibility(VISIBLE);
            numBkMid.setText(NumberFormat.getIntegerInstance().format(bk_pro));
        }

        if (basic.getWin() == 3 || basic.getWin() == 9) {
            numMax.setVisibility(GONE);
            numPro.setText(NumberFormat.getIntegerInstance().format(pro));
            numMaxPro.setVisibility(GONE);
        } else
            {

            if(basic.getType() ==3) {
                numMax.setText(NumberFormat.getIntegerInstance().format(max));
                numPro.setText(NumberFormat.getIntegerInstance().format(pro));
                numMaxPro.setText(NumberFormat.getIntegerInstance().format((max + pro)));
            }
            else {
                if (maxt > 0) {
                    cost_mx.setVisibility(VISIBLE);
                    cost_mpx.setVisibility(VISIBLE);
                    cost_m.setVisibility(GONE);
                    cost_mp.setVisibility(GONE);
                    numTMaxC.setText(NumberFormat.getIntegerInstance().format(maxc));
                    numTMaxT.setText(NumberFormat.getIntegerInstance().format(maxt));
                    numPro.setText(NumberFormat.getIntegerInstance().format(pro));
                    numTMPC.setText(NumberFormat.getIntegerInstance().format(pro + maxc));
                    numTMPT.setText(NumberFormat.getIntegerInstance().format(maxt));
                } else {
                    cost_mx.setVisibility(GONE);
                    cost_mpx.setVisibility(GONE);
                    cost_m.setVisibility(VISIBLE);
                    cost_mp.setVisibility(VISIBLE);
                    numMax.setText(NumberFormat.getIntegerInstance().format(maxc));
                    numPro.setText(NumberFormat.getIntegerInstance().format(pro));
                    numMaxPro.setText(NumberFormat.getIntegerInstance().format((maxc + pro)));
                }
            }
        }

    }

    void costcalculator() {
        pro = max = maxc = maxt = 0;
        if (basic.getWin() == 3 || basic.getWin() == 9) {
            pro += cInfo.getTire1() + cInfo.getSusp1() + cInfo.getDrive1() + cInfo.getExha1() +
                    cInfo.getTire2() + cInfo.getSusp2() + cInfo.getDrive2() + cInfo.getExha2() +
                    cInfo.getTire3() + cInfo.getSusp3() + cInfo.getDrive3() + cInfo.getExha3() +
                    cInfo.getTire4() + cInfo.getSusp4() + cInfo.getDrive4() + cInfo.getExha4() +
                    cInfo.getTire5() + cInfo.getSusp5() + cInfo.getDrive5() + cInfo.getExha5() +
                    cInfo.getTire6() + cInfo.getSusp6() + cInfo.getDrive6() + cInfo.getExha6() +
                    cInfo.getTire7() + cInfo.getSusp7() + cInfo.getDrive7() + cInfo.getExha7() +
                    cInfo.getTire8() + cInfo.getSusp8() + cInfo.getDrive8() + cInfo.getExha8() +
                    cInfo.getTire9() + cInfo.getSusp9() + cInfo.getDrive9() + cInfo.getExha9() +
                    cInfo.getTire10() + cInfo.getSusp10() + cInfo.getDrive10() + cInfo.getExha10();
        } else {

            if (basic.getType() == 3) {
                max += bInfo.getAccel1() + bInfo.getTop1() + bInfo.getHan1() + bInfo.getNos1() +
                        bInfo.getAccel2() + bInfo.getTop2() + bInfo.getHan2() + bInfo.getNos2() +
                        bInfo.getAccel3() + bInfo.getTop3() + bInfo.getHan3() + bInfo.getNos3() +
                        bInfo.getAccel4() + bInfo.getTop4() + bInfo.getHan4() + bInfo.getNos4() +
                        bInfo.getAccel5() + bInfo.getTop5() + bInfo.getHan5() + bInfo.getNos5() +
                        bInfo.getAccel6() + bInfo.getTop6() + bInfo.getHan6() + bInfo.getNos6() +
                        bInfo.getAccel7() + bInfo.getTop7() + bInfo.getHan7() + bInfo.getNos7() +
                        bInfo.getAccel8() + bInfo.getTop8() + bInfo.getHan8() + bInfo.getNos8() +
                        bInfo.getAccel9() + bInfo.getTop9() + bInfo.getHan9() + bInfo.getNos9() +
                        bInfo.getAccel10() + bInfo.getTop10() + bInfo.getHan10() + bInfo.getNos10();

                pro += bInfo.getTire1() + bInfo.getSusp1() + bInfo.getDrive1() + bInfo.getExha1() +
                        bInfo.getTire2() + bInfo.getSusp2() + bInfo.getDrive2() + bInfo.getExha2() +
                        bInfo.getTire3() + bInfo.getSusp3() + bInfo.getDrive3() + bInfo.getExha3() +
                        bInfo.getTire4() + bInfo.getSusp4() + bInfo.getDrive4() + bInfo.getExha4() +
                        bInfo.getTire5() + bInfo.getSusp5() + bInfo.getDrive5() + bInfo.getExha5();
            } else {
                maxc += nInfo.getMaxUpgrades().getTotalCredits();
                maxt += nInfo.getMaxUpgrades().getTotalTokens();

                pro += nInfo.getTire1() + nInfo.getSusp1() + nInfo.getDrive1() + nInfo.getExha1() +
                        nInfo.getTire2() + nInfo.getSusp2() + nInfo.getDrive2() + nInfo.getExha2() +
                        nInfo.getTire3() + nInfo.getSusp3() + nInfo.getDrive3() + nInfo.getExha3() +
                        nInfo.getTire4() + nInfo.getSusp4() + nInfo.getDrive4() + nInfo.getExha4() +
                        nInfo.getTire5() + nInfo.getSusp5() + nInfo.getDrive5() + nInfo.getExha5();
            }


        }
    }

    void CardBuilder() {
        Part = Eng = 0;
        costcalculator();
        if (basic.getWin() == 3 || basic.getWin() == 9) {
            if(cInfo.getPart1() == cInfo.getEngn1() && cInfo.getTechn1() == cInfo.getPart1())
            {
                Part = cInfo.getPart1() + cInfo.getPart2() + cInfo.getPart3() + cInfo.getPart4() + cInfo.getPart5() + cInfo.getPart6() + cInfo.getPart7() + cInfo.getPart8() + cInfo.getPart9() + cInfo.getPart10();
                Eng = 0;
            }
            else {
                Part = cInfo.getPart1() + cInfo.getPart2() + cInfo.getPart3() + cInfo.getPart4() + cInfo.getPart5() + cInfo.getPart6() + cInfo.getPart7() + cInfo.getPart8() + cInfo.getPart9() + cInfo.getPart10();
                Eng = cInfo.getEngn1() + cInfo.getEngn2() + cInfo.getEngn3() + cInfo.getEngn4() + cInfo.getEngn5() + cInfo.getEngn6() + cInfo.getEngn7() + cInfo.getEngn8() + cInfo.getEngn9() + cInfo.getEngn10();
                Eng = Eng * 4;
                procardsetC();
            }
        } else {
            if (basic.getType() == 3) {
                Part = bInfo.getPart1() + bInfo.getPart2() + bInfo.getPart3() + bInfo.getPart4() + bInfo.getPart5();
                Eng = bInfo.getEngn1() + bInfo.getEngn2() + bInfo.getEngn3() + bInfo.getEngn4() + bInfo.getEngn5();
            } else {
                Part = nInfo.getPart1() + nInfo.getPart2() + nInfo.getPart3() + nInfo.getPart4() + nInfo.getPart5();
                Eng = nInfo.getEngn1() + nInfo.getEngn2() + nInfo.getEngn3() + nInfo.getEngn4() + nInfo.getEngn5();
            }

            Eng = Eng * 4;
            procardset();
        }
    }

    private void procardsetC() {
        Pri = Mid = Adv = bk_adv = bk_pro = 0;

        if(cInfo.getPart1() == cInfo.getEngn1() && cInfo.getTechn1() == cInfo.getPart1())
        {
            Pri = Mid = Adv = bk_adv = bk_pro = 0;
        }
        else {
            if ((cInfo.getTech11() == 1 && cInfo.getTech21() == 2) || (cInfo.getTech11() == 2 && cInfo.getTech21() == 1)) {
                Pri = Pri + cInfo.getTechn1();
            }
            if ((cInfo.getTech12() == 1 && cInfo.getTech22() == 2) || (cInfo.getTech21() == 2 && cInfo.getTech22() == 1)) {
                Pri = Pri + cInfo.getTechn2();
            }
            if ((cInfo.getTech13() == 1 && cInfo.getTech23() == 2) || (cInfo.getTech13() == 2 && cInfo.getTech23() == 1)) {
                Pri = Pri + cInfo.getTechn3();
            }
            if ((cInfo.getTech14() == 1 && cInfo.getTech24() == 2) || (cInfo.getTech14() == 2 && cInfo.getTech24() == 1)) {
                Pri = Pri + cInfo.getTechn4();
            }
            if ((cInfo.getTech15() == 1 && cInfo.getTech25() == 2) || (cInfo.getTech15() == 2 && cInfo.getTech25() == 1)) {
                Pri = Pri + cInfo.getTechn5();
            }
            if ((cInfo.getTech16() == 1 && cInfo.getTech26() == 2) || (cInfo.getTech16() == 2 && cInfo.getTech26() == 1)) {
                Pri = Pri + cInfo.getTechn6();
            }
            if ((cInfo.getTech17() == 1 && cInfo.getTech27() == 2) || (cInfo.getTech27() == 2 && cInfo.getTech27() == 1)) {
                Pri = Pri + cInfo.getTechn7();
            }
            if ((cInfo.getTech18() == 1 && cInfo.getTech28() == 2) || (cInfo.getTech18() == 2 && cInfo.getTech28() == 1)) {
                Pri = Pri + cInfo.getTechn8();
            }
            if ((cInfo.getTech19() == 1 && cInfo.getTech29() == 2) || (cInfo.getTech19() == 2 && cInfo.getTech29() == 1)) {
                Pri = Pri + cInfo.getTechn9();
            }
            if ((cInfo.getTech110() == 1 && cInfo.getTech210() == 2) || (cInfo.getTech110() == 2 && cInfo.getTech210() == 1)) {
                Pri = Pri + cInfo.getTechn10();
            }

            if ((cInfo.getTech11() == 3 && cInfo.getTech21() == 3)) {
                Mid = Mid + cInfo.getTechn1();
            }
            if ((cInfo.getTech12() == 3 && cInfo.getTech22() == 3)) {
                Mid = Mid + cInfo.getTechn2();
            }
            if ((cInfo.getTech13() == 3 && cInfo.getTech23() == 3)) {
                Mid = Mid + cInfo.getTechn3();
            }
            if ((cInfo.getTech14() == 3 && cInfo.getTech24() == 3)) {
                Mid = Mid + cInfo.getTechn4();
            }
            if ((cInfo.getTech15() == 3 && cInfo.getTech25() == 3)) {
                Mid = Mid + cInfo.getTechn5();
            }
            if ((cInfo.getTech16() == 3 && cInfo.getTech26() == 3)) {
                Mid = Mid + cInfo.getTechn6();
            }
            if ((cInfo.getTech17() == 3 && cInfo.getTech27() == 3)) {
                Mid = Mid + cInfo.getTechn7();
            }
            if ((cInfo.getTech18() == 3 && cInfo.getTech28() == 3)) {
                Mid = Mid + cInfo.getTechn8();
            }
            if ((cInfo.getTech19() == 3 && cInfo.getTech29() == 3)) {
                Mid = Mid + cInfo.getTechn9();
            }
            if ((cInfo.getTech110() == 3 && cInfo.getTech210() == 3)) {
                Mid = Mid + cInfo.getTechn10();
            }


            if ((cInfo.getTech11() == 4 && cInfo.getTech21() == 4)) {
                Adv = Adv + cInfo.getTechn1();
            }
            if ((cInfo.getTech12() == 4 && cInfo.getTech22() == 4)) {
                Adv = Adv + cInfo.getTechn2();
            }
            if ((cInfo.getTech13() == 4 && cInfo.getTech23() == 4)) {
                Adv = Adv + cInfo.getTechn3();
            }
            if ((cInfo.getTech14() == 4 && cInfo.getTech24() == 4)) {
                Adv = Adv + cInfo.getTechn4();
            }
            if ((cInfo.getTech15() == 4 && cInfo.getTech25() == 4)) {
                Adv = Adv + cInfo.getTechn5();
            }
            if ((cInfo.getTech16() == 4 && cInfo.getTech26() == 4)) {
                Adv = Adv + cInfo.getTechn6();
            }
            if ((cInfo.getTech17() == 4 && cInfo.getTech27() == 4)) {
                Adv = Adv + cInfo.getTechn7();
            }
            if ((cInfo.getTech18() == 4 && cInfo.getTech28() == 4)) {
                Adv = Adv + cInfo.getTechn8();
            }
            if ((cInfo.getTech19() == 4 && cInfo.getTech29() == 4)) {
                Adv = Adv + cInfo.getTechn9();
            }
            if ((cInfo.getTech110() == 4 && cInfo.getTech210() == 4)) {
                Adv = Adv + cInfo.getTechn10();
            }
        }

        Pri = Pri * 2;
        Mid = Mid * 4;
        Adv = Adv * 4;
    }

    private void procardset() {
        Pri = Mid = Adv = Comm = bk_adv = bk_pro = 0;

        if (basic.getType() == 3) {
            if ((bInfo.getTech11() == 1 && bInfo.getTech12() == 2) || (bInfo.getTech11() == 2 && bInfo.getTech12() == 1)) {
                Pri = Pri + bInfo.getTechn1();
            }
            if ((bInfo.getTech21() == 1 && bInfo.getTech22() == 2) || (bInfo.getTech21() == 2 && bInfo.getTech22() == 1)) {
                Pri = Pri + bInfo.getTechn2();
            }
            if ((bInfo.getTech31() == 1 && bInfo.getTech32() == 2) || (bInfo.getTech31() == 2 && bInfo.getTech32() == 1)) {
                Pri = Pri + bInfo.getTechn3();
            }
            if ((bInfo.getTech41() == 1 && bInfo.getTech42() == 2) || (bInfo.getTech41() == 2 && bInfo.getTech42() == 1)) {
                Pri = Pri + bInfo.getTechn4();
            }
            if ((bInfo.getTech51() == 1 && bInfo.getTech52() == 2) || (bInfo.getTech51() == 2 && bInfo.getTech52() == 1)) {
                Pri = Pri + bInfo.getTechn5();
            }

            if ((bInfo.getTech11() == 3 && bInfo.getTech12() == 3)) {
                Mid = Mid + bInfo.getTechn1();
            }
            if ((bInfo.getTech21() == 3 && bInfo.getTech22() == 3)) {
                Mid = Mid + bInfo.getTechn2();
            }
            if ((bInfo.getTech31() == 3 && bInfo.getTech32() == 3)) {
                Mid = Mid + bInfo.getTechn3();
            }
            if ((bInfo.getTech41() == 3 && bInfo.getTech42() == 3)) {
                Mid = Mid + bInfo.getTechn4();
            }
            if ((bInfo.getTech51() == 3 && bInfo.getTech52() == 3)) {
                Mid = Mid + bInfo.getTechn5();
            }


            if ((bInfo.getTech11() == 4 && bInfo.getTech12() == 4)) {
                Adv = Adv + bInfo.getTechn1();
            }
            if ((bInfo.getTech21() == 4 && bInfo.getTech22() == 4)) {
                Adv = Adv + bInfo.getTechn2();
            }
            if ((bInfo.getTech31() == 4 && bInfo.getTech32() == 4)) {
                Adv = Adv + bInfo.getTechn3();
            }
            if ((bInfo.getTech41() == 4 && bInfo.getTech42() == 4)) {
                Adv = Adv + bInfo.getTechn4();
            }
            if ((bInfo.getTech51() == 4 && bInfo.getTech52() == 4)) {
                Adv = Adv + bInfo.getTechn5();
            }

            if ((bInfo.getTech11() == 5 && bInfo.getTech12() == 5)) {
                Comm = Comm + bInfo.getTechn1();
            }
            if ((bInfo.getTech21() == 5 && bInfo.getTech22() == 5)) {
                Comm = Comm + bInfo.getTechn2();
            }
            if ((bInfo.getTech31() == 5 && bInfo.getTech32() == 5)) {
                Comm = Comm + bInfo.getTechn3();
            }
            if ((bInfo.getTech41() == 5 && bInfo.getTech42() == 5)) {
                Comm = Comm + bInfo.getTechn4();
            }
            if ((bInfo.getTech51() == 5 && bInfo.getTech52() == 5)) {
                Comm = Comm + bInfo.getTechn5();
            }

            if ((bInfo.getTech11() == 6 && bInfo.getTech12() == 6)) {
                bk_pro = bk_pro + bInfo.getTechn1();
            }
            if ((bInfo.getTech21() == 6 && bInfo.getTech22() == 6)) {
                bk_pro = bk_pro + bInfo.getTechn2();
            }
            if ((bInfo.getTech31() == 6 && bInfo.getTech32() == 6)) {
                bk_pro = bk_pro + bInfo.getTechn3();
            }
            if ((bInfo.getTech41() == 6 && bInfo.getTech42() == 6)) {
                bk_pro = bk_pro + bInfo.getTechn4();
            }
            if ((bInfo.getTech51() == 6 && bInfo.getTech52() == 6)) {
                bk_pro = bk_pro + bInfo.getTechn5();
            }

            if ((bInfo.getTech11() == 7 && bInfo.getTech12() == 7)) {
                bk_adv = bk_adv + bInfo.getTechn1();
            }
            if ((bInfo.getTech21() == 7 && bInfo.getTech22() == 7)) {
                bk_adv = bk_adv + bInfo.getTechn2();
            }
            if ((bInfo.getTech31() == 7 && bInfo.getTech32() == 7)) {
                bk_adv = bk_adv + bInfo.getTechn3();
            }
            if ((bInfo.getTech41() == 7 && bInfo.getTech42() == 7)) {
                bk_adv = bk_adv + bInfo.getTechn4();
            }
            if ((bInfo.getTech51() == 7 && bInfo.getTech52() == 7)) {
                bk_adv = bk_adv + bInfo.getTechn5();
            }
        } else {

            if ((nInfo.getTech11() == 1 && nInfo.getTech12() == 2) || (nInfo.getTech11() == 2 && nInfo.getTech12() == 1)) {
                Pri = Pri + nInfo.getTechn1();
            }
            if ((nInfo.getTech21() == 1 && nInfo.getTech22() == 2) || (nInfo.getTech21() == 2 && nInfo.getTech22() == 1)) {
                Pri = Pri + nInfo.getTechn2();
            }
            if ((nInfo.getTech31() == 1 && nInfo.getTech32() == 2) || (nInfo.getTech31() == 2 && nInfo.getTech32() == 1)) {
                Pri = Pri + nInfo.getTechn3();
            }
            if ((nInfo.getTech41() == 1 && nInfo.getTech42() == 2) || (nInfo.getTech41() == 2 && nInfo.getTech42() == 1)) {
                Pri = Pri + nInfo.getTechn4();
            }
            if ((nInfo.getTech51() == 1 && nInfo.getTech52() == 2) || (nInfo.getTech51() == 2 && nInfo.getTech52() == 1)) {
                Pri = Pri + nInfo.getTechn5();
            }

            if ((nInfo.getTech11() == 3 && nInfo.getTech12() == 3)) {
                Mid = Mid + nInfo.getTechn1();
            }
            if ((nInfo.getTech21() == 3 && nInfo.getTech22() == 3)) {
                Mid = Mid + nInfo.getTechn2();
            }
            if ((nInfo.getTech31() == 3 && nInfo.getTech32() == 3)) {
                Mid = Mid + nInfo.getTechn3();
            }
            if ((nInfo.getTech41() == 3 && nInfo.getTech42() == 3)) {
                Mid = Mid + nInfo.getTechn4();
            }
            if ((nInfo.getTech51() == 3 && nInfo.getTech52() == 3)) {
                Mid = Mid + nInfo.getTechn5();
            }


            if ((nInfo.getTech11() == 4 && nInfo.getTech12() == 4)) {
                Adv = Adv + nInfo.getTechn1();
            }
            if ((nInfo.getTech21() == 4 && nInfo.getTech22() == 4)) {
                Adv = Adv + nInfo.getTechn2();
            }
            if ((nInfo.getTech31() == 4 && nInfo.getTech32() == 4)) {
                Adv = Adv + nInfo.getTechn3();
            }
            if ((nInfo.getTech41() == 4 && nInfo.getTech42() == 4)) {
                Adv = Adv + nInfo.getTechn4();
            }
            if ((nInfo.getTech51() == 4 && nInfo.getTech52() == 4)) {
                Adv = Adv + nInfo.getTechn5();
            }

            if ((nInfo.getTech11() == 5 && nInfo.getTech12() == 5)) {
                Comm = Comm + nInfo.getTechn1();
            }
            if ((nInfo.getTech21() == 5 && nInfo.getTech22() == 5)) {
                Comm = Comm + nInfo.getTechn2();
            }
            if ((nInfo.getTech31() == 5 && nInfo.getTech32() == 5)) {
                Comm = Comm + nInfo.getTechn3();
            }
            if ((nInfo.getTech41() == 5 && nInfo.getTech42() == 5)) {
                Comm = Comm + nInfo.getTechn4();
            }
            if ((nInfo.getTech51() == 5 && nInfo.getTech52() == 5)) {
                Comm = Comm + nInfo.getTechn5();
            }

            if ((nInfo.getTech11() == 6 && nInfo.getTech12() == 6)) {
                bk_pro = bk_pro + nInfo.getTechn1();
            }
            if ((nInfo.getTech21() == 6 && nInfo.getTech22() == 6)) {
                bk_pro = bk_pro + nInfo.getTechn2();
            }
            if ((nInfo.getTech31() == 6 && nInfo.getTech32() == 6)) {
                bk_pro = bk_pro + nInfo.getTechn3();
            }
            if ((nInfo.getTech41() == 6 && nInfo.getTech42() == 6)) {
                bk_pro = bk_pro + nInfo.getTechn4();
            }
            if ((nInfo.getTech51() == 6 && nInfo.getTech52() == 6)) {
                bk_pro = bk_pro + nInfo.getTechn5();
            }

            if ((nInfo.getTech11() == 7 && nInfo.getTech12() == 7)) {
                bk_adv = bk_adv + nInfo.getTechn1();
            }
            if ((nInfo.getTech21() == 7 && nInfo.getTech22() == 7)) {
                bk_adv = bk_adv + nInfo.getTechn2();
            }
            if ((nInfo.getTech31() == 7 && nInfo.getTech32() == 7)) {
                bk_adv = bk_adv + nInfo.getTechn3();
            }
            if ((nInfo.getTech41() == 7 && nInfo.getTech42() == 7)) {
                bk_adv = bk_adv + nInfo.getTechn4();
            }
            if ((nInfo.getTech51() == 7 && nInfo.getTech52() == 7)) {
                bk_adv = bk_adv + nInfo.getTechn5();
            }


        }

        Pri = Pri * 2;
        Mid = Mid * 4;
        Adv = Adv * 4;
        Comm = Comm * 4;
        bk_pro = bk_pro * 4;
        bk_adv = bk_adv * 4;
    }
    // TODO: Generalize the card calculator, pro cost. Also for bikes, F1 cars and Cars. Done disabled all conditional cars. GNeed to make gen functions
/*    void CardSetterT() {
        if (Part == 0) {
            imgPart.setVisibility(GONE);
            numPart.setVisibility(GONE);
        } else {
            imgPart.setVisibility(VISIBLE);
            numPart.setVisibility(VISIBLE);
            if (CommonStuff.partsFinder(basic.getCarclass()) != -1)
                imgPart.setImageResource(CommonStuff.partsFinder(basic.getCarclass()));
            numPart.setText(NumberFormat.getIntegerInstance().format(Part));
        }

        if (Eng == 0) {
            imgEng.setVisibility(GONE);
            numEng.setVisibility(GONE);
        } else {
            imgEng.setVisibility(VISIBLE);
            numEng.setVisibility(VISIBLE);
            if (CommonStuff.engineFinder(basic.getEng()) != -1)
                imgEng.setImageResource(CommonStuff.engineFinder(basic.getEng()));
            numEng.setText(NumberFormat.getIntegerInstance().format(Eng));
        }

        if (Pri == 0) {
            imgInitial.setVisibility(GONE);
            numInitial.setVisibility(GONE);
            imgEarly.setVisibility(GONE);
            numEarly.setVisibility(GONE);
        } else {
            imgInitial.setVisibility(VISIBLE);
            numInitial.setVisibility(VISIBLE);
            imgEarly.setVisibility(VISIBLE);
            numEarly.setVisibility(VISIBLE);

            numInitial.setText(NumberFormat.getIntegerInstance().format(Pri));
            numEarly.setText(NumberFormat.getIntegerInstance().format(Pri));
        }

        if (Mid == 0) {
            imgMid.setVisibility(GONE);
            numMid.setVisibility(GONE);
        } else {
            imgMid.setVisibility(VISIBLE);
            numMid.setVisibility(VISIBLE);
            numMid.setText(NumberFormat.getIntegerInstance().format(Mid));
        }

        if (Adv == 0) {
            imgAdv.setVisibility(GONE);
            numAdv.setVisibility(GONE);
        } else {
            imgAdv.setVisibility(VISIBLE);
            numAdv.setVisibility(VISIBLE);
            numAdv.setText(NumberFormat.getIntegerInstance().format(Adv));
        }

        cost_mx.setVisibility(VISIBLE);
        cost_mpx.setVisibility(VISIBLE);
        cost_m.setVisibility(GONE);
        cost_mp.setVisibility(GONE);
        proc = maxc + pro;
        prot = maxt;
        numTMaxC.setText(NumberFormat.getIntegerInstance().format(maxc));
        numTMaxT.setText(NumberFormat.getIntegerInstance().format(maxt));
        numPro.setText(NumberFormat.getIntegerInstance().format(pro));
        numTMPC.setText(NumberFormat.getIntegerInstance().format(proc));
        numTMPT.setText(NumberFormat.getIntegerInstance().format(prot));

    }

    void costcalculatorT() {
        maxc = maxt = 0;
        maxc += nInfo.getMaxUpgrades().getTotalCredits();

        maxt +=  nInfo.getMaxUpgrades().getTotalTokens();

        pro += nInfo.getTire1() + nInfo.getSusp1() + nInfo.getDrive1() + nInfo.getExha1() +
                nInfo.getTire2() + nInfo.getSusp2() + nInfo.getDrive2() + nInfo.getExha2() +
                nInfo.getTire3() + nInfo.getSusp3() + nInfo.getDrive3() + nInfo.getExha3() +
                nInfo.getTire4() + nInfo.getSusp4() + nInfo.getDrive4() + nInfo.getExha4() +
                nInfo.getTire5() + nInfo.getSusp5() + nInfo.getDrive5() + nInfo.getExha5();
    }

    void CardBuilderT() {
        Part = Eng = 0;
        costcalculatorT();
        Part = nInfo.getPart1() + nInfo.getPart2() + nInfo.getPart3() + nInfo.getPart4() + nInfo.getPart5();
        Eng = nInfo.getEngn1() + nInfo.getEngn2() + nInfo.getEngn3() + nInfo.getEngn4() + nInfo.getEngn5();
        Eng = Eng * 4;
        procardset();
    }

    void CardSetterT_1() {
        if (Part == 0) {
            imgPart.setVisibility(GONE);
            numPart.setVisibility(GONE);
        } else {
            imgPart.setVisibility(VISIBLE);
            numPart.setVisibility(VISIBLE);
            if (CommonStuff.partsFinder(basic.getCarclass()) != -1)
                imgPart.setImageResource(CommonStuff.partsFinder(basic.getCarclass()));
            numPart.setText(NumberFormat.getIntegerInstance().format(Part));
        }

        if (Eng == 0) {
            imgEng.setVisibility(GONE);
            numEng.setVisibility(GONE);
        } else {
            imgEng.setVisibility(VISIBLE);
            numEng.setVisibility(VISIBLE);
            if (CommonStuff.engineFinder(basic.getEng()) != -1)
                imgEng.setImageResource(CommonStuff.engineFinder(basic.getEng()));
            numEng.setText(NumberFormat.getIntegerInstance().format(Eng));
        }

        if (Pri == 0) {
            imgInitial.setVisibility(GONE);
            numInitial.setVisibility(GONE);
            imgEarly.setVisibility(GONE);
            numEarly.setVisibility(GONE);
        } else {
            imgInitial.setVisibility(VISIBLE);
            numInitial.setVisibility(VISIBLE);
            imgEarly.setVisibility(VISIBLE);
            numEarly.setVisibility(VISIBLE);

            numInitial.setText(NumberFormat.getIntegerInstance().format(Pri));
            numEarly.setText(NumberFormat.getIntegerInstance().format(Pri));
        }

        if (Mid == 0) {
            imgMid.setVisibility(GONE);
            numMid.setVisibility(GONE);
        } else {
            imgMid.setVisibility(VISIBLE);
            numMid.setVisibility(VISIBLE);
            numMid.setText(NumberFormat.getIntegerInstance().format(Mid));
        }

        if (Adv == 0) {
            imgAdv.setVisibility(GONE);
            numAdv.setVisibility(GONE);
        } else {
            imgAdv.setVisibility(VISIBLE);
            numAdv.setVisibility(VISIBLE);
            numAdv.setText(NumberFormat.getIntegerInstance().format(Adv));
        }

        cost_mx.setVisibility(VISIBLE);
        cost_mpx.setVisibility(VISIBLE);
        cost_m.setVisibility(GONE);
        cost_mp.setVisibility(GONE);
        proc = maxc + pro;
        prot = maxt;
        numTMaxC.setText(NumberFormat.getIntegerInstance().format(maxc));
        numTMaxT.setText(NumberFormat.getIntegerInstance().format(maxt));
        numPro.setText(NumberFormat.getIntegerInstance().format(pro));
        numTMPC.setText(NumberFormat.getIntegerInstance().format(proc));
        numTMPT.setText(NumberFormat.getIntegerInstance().format(prot));

    }

    void costcalculatorT_1() {
        maxc = maxt = 0;
        maxc += nInfo.getAccel1() + nInfo.getTop1() + nInfo.getHan1() + nInfo.getNos1() +
                nInfo.getAccel2() + nInfo.getHan2() + nInfo.getNos2() +
                nInfo.getAccel3() + nInfo.getTop3() +
                nInfo.getHan4() + nInfo.getNos4() +
                nInfo.getAccel5() + nInfo.getTop5() + nInfo.getHan5();

        maxt += nInfo.getTop2() +
                nInfo.getHan3() + nInfo.getNos3() +
                nInfo.getAccel4() + nInfo.getTop4() +
                nInfo.getNos5();

        pro += nInfo.getTire1() + nInfo.getSusp1() + nInfo.getDrive1() + nInfo.getExha1() +
                nInfo.getTire2() + nInfo.getSusp2() + nInfo.getDrive2() + nInfo.getExha2() +
                nInfo.getTire3() + nInfo.getSusp3() + nInfo.getDrive3() + nInfo.getExha3() +
                nInfo.getTire4() + nInfo.getSusp4() + nInfo.getDrive4() + nInfo.getExha4() +
                nInfo.getTire5() + nInfo.getSusp5() + nInfo.getDrive5() + nInfo.getExha5();
    }

    void CardBuilderT_1() {
        Part = Eng = 0;
        costcalculatorT_1();
        Part = nInfo.getPart1() + nInfo.getPart2() + nInfo.getPart3() + nInfo.getPart4() + nInfo.getPart5();
        Eng = nInfo.getEngn1() + nInfo.getEngn2() + nInfo.getEngn3() + nInfo.getEngn4() + nInfo.getEngn5();
        Eng = Eng * 4;
        procardset();
    }

    void CardSetterT_2() {
        if (Part == 0) {
            imgPart.setVisibility(GONE);
            numPart.setVisibility(GONE);
        } else {
            imgPart.setVisibility(VISIBLE);
            numPart.setVisibility(VISIBLE);
            if (CommonStuff.partsFinder(basic.getCarclass()) != -1)
                imgPart.setImageResource(CommonStuff.partsFinder(basic.getCarclass()));
            numPart.setText(NumberFormat.getIntegerInstance().format(Part));
        }

        if (Eng == 0) {
            imgEng.setVisibility(GONE);
            numEng.setVisibility(GONE);
        } else {
            imgEng.setVisibility(VISIBLE);
            numEng.setVisibility(VISIBLE);
            if (CommonStuff.engineFinder(basic.getEng()) != -1)
                imgEng.setImageResource(CommonStuff.engineFinder(basic.getEng()));
            numEng.setText(NumberFormat.getIntegerInstance().format(Eng));
        }

        if (Pri == 0) {
            imgInitial.setVisibility(GONE);
            numInitial.setVisibility(GONE);
            imgEarly.setVisibility(GONE);
            numEarly.setVisibility(GONE);
        } else {
            imgInitial.setVisibility(VISIBLE);
            numInitial.setVisibility(VISIBLE);
            imgEarly.setVisibility(VISIBLE);
            numEarly.setVisibility(VISIBLE);

            numInitial.setText(NumberFormat.getIntegerInstance().format(Pri));
            numEarly.setText(NumberFormat.getIntegerInstance().format(Pri));
        }

        if (Mid == 0) {
            imgMid.setVisibility(GONE);
            numMid.setVisibility(GONE);
        } else {
            imgMid.setVisibility(VISIBLE);
            numMid.setVisibility(VISIBLE);
            numMid.setText(NumberFormat.getIntegerInstance().format(Mid));
        }

        if (Adv == 0) {
            imgAdv.setVisibility(GONE);
            numAdv.setVisibility(GONE);
        } else {
            imgAdv.setVisibility(VISIBLE);
            numAdv.setVisibility(VISIBLE);
            numAdv.setText(NumberFormat.getIntegerInstance().format(Adv));
        }

        cost_mx.setVisibility(VISIBLE);
        cost_mpx.setVisibility(VISIBLE);
        cost_m.setVisibility(GONE);
        cost_mp.setVisibility(GONE);
        proc = maxc + pro;
        prot = maxt;
        numTMaxC.setText(NumberFormat.getIntegerInstance().format(maxc));
        numTMaxT.setText(NumberFormat.getIntegerInstance().format(maxt));
        numPro.setText(NumberFormat.getIntegerInstance().format(pro));
        numTMPC.setText(NumberFormat.getIntegerInstance().format(proc));
        numTMPT.setText(NumberFormat.getIntegerInstance().format(prot));

    }

    void costcalculatorT_2() {
        maxc = maxt = 0;
        maxc += nInfo.getAccel1() + nInfo.getTop1() + nInfo.getHan1() + nInfo.getNos1() +
                nInfo.getAccel2() + nInfo.getTop2() + nInfo.getHan2() + nInfo.getNos2() +
                nInfo.getAccel3() + nInfo.getTop3() + nInfo.getHan3() + nInfo.getNos3() +
                nInfo.getAccel4() + nInfo.getHan4() +
                nInfo.getAccel5() + nInfo.getTop5() + nInfo.getHan5() + nInfo.getNos5();

        maxt += nInfo.getTop4() + nInfo.getNos4();

        pro += nInfo.getTire1() + nInfo.getSusp1() + nInfo.getDrive1() + nInfo.getExha1() +
                nInfo.getTire2() + nInfo.getSusp2() + nInfo.getDrive2() + nInfo.getExha2() +
                nInfo.getTire3() + nInfo.getSusp3() + nInfo.getDrive3() + nInfo.getExha3() +
                nInfo.getTire4() + nInfo.getSusp4() + nInfo.getDrive4() + nInfo.getExha4() +
                nInfo.getTire5() + nInfo.getSusp5() + nInfo.getDrive5() + nInfo.getExha5();
    }

    void CardBuilderT_2() {
        Part = Eng = 0;
        costcalculatorT_2();
        Part = nInfo.getPart1() + nInfo.getPart2() + nInfo.getPart3() + nInfo.getPart4() + nInfo.getPart5();
        Eng = nInfo.getEngn1() + nInfo.getEngn2() + nInfo.getEngn3() + nInfo.getEngn4() + nInfo.getEngn5();
        Eng = Eng * 4;
        procardset();
    }

    void CardSetterT_3() {
        if (Part == 0) {
            imgPart.setVisibility(GONE);
            numPart.setVisibility(GONE);
        } else {
            imgPart.setVisibility(VISIBLE);
            numPart.setVisibility(VISIBLE);
            if (CommonStuff.partsFinder(basic.getCarclass()) != -1)
                imgPart.setImageResource(CommonStuff.partsFinder(basic.getCarclass()));
            numPart.setText(NumberFormat.getIntegerInstance().format(Part));
        }

        if (Eng == 0) {
            imgEng.setVisibility(GONE);
            numEng.setVisibility(GONE);
        } else {
            imgEng.setVisibility(VISIBLE);
            numEng.setVisibility(VISIBLE);
            if (CommonStuff.engineFinder(basic.getEng()) != -1)
                imgEng.setImageResource(CommonStuff.engineFinder(basic.getEng()));
            numEng.setText(NumberFormat.getIntegerInstance().format(Eng));
        }

        if (Pri == 0) {
            imgInitial.setVisibility(GONE);
            numInitial.setVisibility(GONE);
            imgEarly.setVisibility(GONE);
            numEarly.setVisibility(GONE);
        } else {
            imgInitial.setVisibility(VISIBLE);
            numInitial.setVisibility(VISIBLE);
            imgEarly.setVisibility(VISIBLE);
            numEarly.setVisibility(VISIBLE);

            numInitial.setText(NumberFormat.getIntegerInstance().format(Pri));
            numEarly.setText(NumberFormat.getIntegerInstance().format(Pri));
        }

        if (Mid == 0) {
            imgMid.setVisibility(GONE);
            numMid.setVisibility(GONE);
        } else {
            imgMid.setVisibility(VISIBLE);
            numMid.setVisibility(VISIBLE);
            numMid.setText(NumberFormat.getIntegerInstance().format(Mid));
        }

        if (Adv == 0) {
            imgAdv.setVisibility(GONE);
            numAdv.setVisibility(GONE);
        } else {
            imgAdv.setVisibility(VISIBLE);
            numAdv.setVisibility(VISIBLE);
            numAdv.setText(NumberFormat.getIntegerInstance().format(Adv));
        }

        cost_mx.setVisibility(VISIBLE);
        cost_mpx.setVisibility(VISIBLE);
        cost_m.setVisibility(GONE);
        cost_mp.setVisibility(GONE);
        proc = maxc + pro;
        prot = maxt;
        numTMaxC.setText(NumberFormat.getIntegerInstance().format(maxc));
        numTMaxT.setText(NumberFormat.getIntegerInstance().format(maxt));
        numPro.setText(NumberFormat.getIntegerInstance().format(pro));
        numTMPC.setText(NumberFormat.getIntegerInstance().format(proc));
        numTMPT.setText(NumberFormat.getIntegerInstance().format(prot));

    }

    void costcalculatorT_3() {
        maxc = maxt = 0;
        maxc += nInfo.getAccel1() + nInfo.getTop1() + nInfo.getHan1() + nInfo.getNos1() +
                nInfo.getAccel2() + nInfo.getTop2() + nInfo.getHan2() + nInfo.getNos2() +
                nInfo.getAccel3() +
                nInfo.getTop4() + nInfo.getNos4() +
                +nInfo.getHan5();

        maxt += nInfo.getTop3() + nInfo.getHan3() + nInfo.getNos3() +
                nInfo.getAccel4() + nInfo.getHan4() +
                nInfo.getAccel5() + nInfo.getTop5() + nInfo.getNos5();

        pro += nInfo.getTire1() + nInfo.getSusp1() + nInfo.getDrive1() + nInfo.getExha1() +
                nInfo.getTire2() + nInfo.getSusp2() + nInfo.getDrive2() + nInfo.getExha2() +
                nInfo.getTire3() + nInfo.getSusp3() + nInfo.getDrive3() + nInfo.getExha3() +
                nInfo.getTire4() + nInfo.getSusp4() + nInfo.getDrive4() + nInfo.getExha4() +
                nInfo.getTire5() + nInfo.getSusp5() + nInfo.getDrive5() + nInfo.getExha5();
    }

    void CardBuilderT_3() {
        Part = Eng = 0;
        costcalculatorT_3();
        Part = nInfo.getPart1() + nInfo.getPart2() + nInfo.getPart3() + nInfo.getPart4() + nInfo.getPart5();
        Eng = nInfo.getEngn1() + nInfo.getEngn2() + nInfo.getEngn3() + nInfo.getEngn4() + nInfo.getEngn5();
        Eng = Eng * 4;
        procardset();
    }

    void CardSetterT_4() {
        if (Part == 0) {
            imgPart.setVisibility(GONE);
            numPart.setVisibility(GONE);
        } else {
            imgPart.setVisibility(VISIBLE);
            numPart.setVisibility(VISIBLE);
            if (CommonStuff.partsFinder(basic.getCarclass()) != -1)
                imgPart.setImageResource(CommonStuff.partsFinder(basic.getCarclass()));
            numPart.setText(NumberFormat.getIntegerInstance().format(Part));
        }

        if (Eng == 0) {
            imgEng.setVisibility(GONE);
            numEng.setVisibility(GONE);
        } else {
            imgEng.setVisibility(VISIBLE);
            numEng.setVisibility(VISIBLE);
            if (CommonStuff.engineFinder(basic.getEng()) != -1)
                imgEng.setImageResource(CommonStuff.engineFinder(basic.getEng()));
            numEng.setText(NumberFormat.getIntegerInstance().format(Eng));
        }

        if (Pri == 0) {
            imgInitial.setVisibility(GONE);
            numInitial.setVisibility(GONE);
            imgEarly.setVisibility(GONE);
            numEarly.setVisibility(GONE);
        } else {
            imgInitial.setVisibility(VISIBLE);
            numInitial.setVisibility(VISIBLE);
            imgEarly.setVisibility(VISIBLE);
            numEarly.setVisibility(VISIBLE);

            numInitial.setText(NumberFormat.getIntegerInstance().format(Pri));
            numEarly.setText(NumberFormat.getIntegerInstance().format(Pri));
        }

        if (Mid == 0) {
            imgMid.setVisibility(GONE);
            numMid.setVisibility(GONE);
        } else {
            imgMid.setVisibility(VISIBLE);
            numMid.setVisibility(VISIBLE);
            numMid.setText(NumberFormat.getIntegerInstance().format(Mid));
        }

        if (Adv == 0) {
            imgAdv.setVisibility(GONE);
            numAdv.setVisibility(GONE);
        } else {
            imgAdv.setVisibility(VISIBLE);
            numAdv.setVisibility(VISIBLE);
            numAdv.setText(NumberFormat.getIntegerInstance().format(Adv));
        }

        cost_mx.setVisibility(VISIBLE);
        cost_mpx.setVisibility(VISIBLE);
        cost_m.setVisibility(GONE);
        cost_mp.setVisibility(GONE);
        proc = maxc + pro;
        prot = maxt;
        numTMaxC.setText(NumberFormat.getIntegerInstance().format(maxc));
        numTMaxT.setText(NumberFormat.getIntegerInstance().format(maxt));
        numPro.setText(NumberFormat.getIntegerInstance().format(pro));
        numTMPC.setText(NumberFormat.getIntegerInstance().format(proc));
        numTMPT.setText(NumberFormat.getIntegerInstance().format(prot));

    }

    void costcalculatorT_4() {
        maxc = maxt = 0;
        maxc += nInfo.getAccel1() + nInfo.getTop1() + nInfo.getHan1() + nInfo.getNos1() +
                nInfo.getAccel2() + nInfo.getTop2() + nInfo.getHan2() + nInfo.getNos2() +
                nInfo.getAccel3() + nInfo.getHan3() +
                nInfo.getTop4() + nInfo.getNos4() +
                nInfo.getAccel5() + nInfo.getTop5() + nInfo.getHan5() + nInfo.getNos5();

        maxt += nInfo.getTop3() + nInfo.getNos3() +
                nInfo.getAccel4() + nInfo.getHan4();

        pro += nInfo.getTire1() + nInfo.getSusp1() + nInfo.getDrive1() + nInfo.getExha1() +
                nInfo.getTire2() + nInfo.getSusp2() + nInfo.getDrive2() + nInfo.getExha2() +
                nInfo.getTire3() + nInfo.getSusp3() + nInfo.getDrive3() + nInfo.getExha3() +
                nInfo.getTire4() + nInfo.getSusp4() + nInfo.getDrive4() + nInfo.getExha4() +
                nInfo.getTire5() + nInfo.getSusp5() + nInfo.getDrive5() + nInfo.getExha5();
    }

    void CardBuilderT_4() {
        Part = Eng = 0;
        costcalculatorT_4();
        Part = nInfo.getPart1() + nInfo.getPart2() + nInfo.getPart3() + nInfo.getPart4() + nInfo.getPart5();
        Eng = nInfo.getEngn1() + nInfo.getEngn2() + nInfo.getEngn3() + nInfo.getEngn4() + nInfo.getEngn5();
        Eng = Eng * 4;
        procardset();
    }

    void CardSetterT_5() {
        if (Part == 0) {
            imgPart.setVisibility(GONE);
            numPart.setVisibility(GONE);
        } else {
            imgPart.setVisibility(VISIBLE);
            numPart.setVisibility(VISIBLE);
            if (CommonStuff.partsFinder(basic.getCarclass()) != -1)
                imgPart.setImageResource(CommonStuff.partsFinder(basic.getCarclass()));
            numPart.setText(NumberFormat.getIntegerInstance().format(Part));
        }

        if (Eng == 0) {
            imgEng.setVisibility(GONE);
            numEng.setVisibility(GONE);
        } else {
            imgEng.setVisibility(VISIBLE);
            numEng.setVisibility(VISIBLE);
            if (CommonStuff.engineFinder(basic.getEng()) != -1)
                imgEng.setImageResource(CommonStuff.engineFinder(basic.getEng()));
            numEng.setText(NumberFormat.getIntegerInstance().format(Eng));
        }

        if (Pri == 0) {
            imgInitial.setVisibility(GONE);
            numInitial.setVisibility(GONE);
            imgEarly.setVisibility(GONE);
            numEarly.setVisibility(GONE);
        } else {
            imgInitial.setVisibility(VISIBLE);
            numInitial.setVisibility(VISIBLE);
            imgEarly.setVisibility(VISIBLE);
            numEarly.setVisibility(VISIBLE);

            numInitial.setText(NumberFormat.getIntegerInstance().format(Pri));
            numEarly.setText(NumberFormat.getIntegerInstance().format(Pri));
        }

        if (Mid == 0) {
            imgMid.setVisibility(GONE);
            numMid.setVisibility(GONE);
        } else {
            imgMid.setVisibility(VISIBLE);
            numMid.setVisibility(VISIBLE);
            numMid.setText(NumberFormat.getIntegerInstance().format(Mid));
        }

        if (Adv == 0) {
            imgAdv.setVisibility(GONE);
            numAdv.setVisibility(GONE);
        } else {
            imgAdv.setVisibility(VISIBLE);
            numAdv.setVisibility(VISIBLE);
            numAdv.setText(NumberFormat.getIntegerInstance().format(Adv));
        }

        cost_mx.setVisibility(VISIBLE);
        cost_mpx.setVisibility(VISIBLE);
        cost_m.setVisibility(GONE);
        cost_mp.setVisibility(GONE);
        proc = maxc + pro;
        prot = maxt;
        numTMaxC.setText(NumberFormat.getIntegerInstance().format(maxc));
        numTMaxT.setText(NumberFormat.getIntegerInstance().format(maxt));
        numPro.setText(NumberFormat.getIntegerInstance().format(pro));
        numTMPC.setText(NumberFormat.getIntegerInstance().format(proc));
        numTMPT.setText(NumberFormat.getIntegerInstance().format(prot));

    }

    void costcalculatorT_5() {
        maxc = maxt = 0;
        maxc += nInfo.getAccel1() + nInfo.getTop1() + nInfo.getHan1() + nInfo.getNos1() +
                nInfo.getAccel2() + nInfo.getTop2() + nInfo.getHan2() + nInfo.getNos2() +
                nInfo.getAccel3() + nInfo.getHan3() + nInfo.getNos3() +
                nInfo.getAccel4() + nInfo.getTop4() + nInfo.getHan4() +
                nInfo.getAccel5() + nInfo.getTop5() + nInfo.getHan5() + nInfo.getNos5();

        maxt += nInfo.getTop3()+
        nInfo.getNos4();

        pro += nInfo.getTire1() + nInfo.getSusp1() + nInfo.getDrive1() + nInfo.getExha1() +
                nInfo.getTire2() + nInfo.getSusp2() + nInfo.getDrive2() + nInfo.getExha2() +
                nInfo.getTire3() + nInfo.getSusp3() + nInfo.getDrive3() + nInfo.getExha3() +
                nInfo.getTire4() + nInfo.getSusp4() + nInfo.getDrive4() + nInfo.getExha4() +
                nInfo.getTire5() + nInfo.getSusp5() + nInfo.getDrive5() + nInfo.getExha5();
    }

    void CardBuilderT_5() {
        Part = Eng = 0;
        costcalculatorT_5();
        Part = nInfo.getPart1() + nInfo.getPart2() + nInfo.getPart3() + nInfo.getPart4() + nInfo.getPart5();
        Eng = nInfo.getEngn1() + nInfo.getEngn2() + nInfo.getEngn3() + nInfo.getEngn4() + nInfo.getEngn5();
        Eng = Eng * 4;
        procardset();
    }


    void CardSetterT_6() {
        if (Part == 0) {
            imgPart.setVisibility(GONE);
            numPart.setVisibility(GONE);
        } else {
            imgPart.setVisibility(VISIBLE);
            numPart.setVisibility(VISIBLE);
            if (CommonStuff.partsFinder(basic.getCarclass()) != -1)
                imgPart.setImageResource(CommonStuff.partsFinder(basic.getCarclass()));
            numPart.setText(NumberFormat.getIntegerInstance().format(Part));
        }

        if (Eng == 0) {
            imgEng.setVisibility(GONE);
            numEng.setVisibility(GONE);
        } else {
            imgEng.setVisibility(VISIBLE);
            numEng.setVisibility(VISIBLE);
            if (CommonStuff.engineFinder(basic.getEng()) != -1)
                imgEng.setImageResource(CommonStuff.engineFinder(basic.getEng()));
            numEng.setText(NumberFormat.getIntegerInstance().format(Eng));
        }

        if (Pri == 0) {
            imgInitial.setVisibility(GONE);
            numInitial.setVisibility(GONE);
            imgEarly.setVisibility(GONE);
            numEarly.setVisibility(GONE);
        } else {
            imgInitial.setVisibility(VISIBLE);
            numInitial.setVisibility(VISIBLE);
            imgEarly.setVisibility(VISIBLE);
            numEarly.setVisibility(VISIBLE);

            numInitial.setText(NumberFormat.getIntegerInstance().format(Pri));
            numEarly.setText(NumberFormat.getIntegerInstance().format(Pri));
        }

        if (Mid == 0) {
            imgMid.setVisibility(GONE);
            numMid.setVisibility(GONE);
        } else {
            imgMid.setVisibility(VISIBLE);
            numMid.setVisibility(VISIBLE);
            numMid.setText(NumberFormat.getIntegerInstance().format(Mid));
        }

        if (Adv == 0) {
            imgAdv.setVisibility(GONE);
            numAdv.setVisibility(GONE);
        } else {
            imgAdv.setVisibility(VISIBLE);
            numAdv.setVisibility(VISIBLE);
            numAdv.setText(NumberFormat.getIntegerInstance().format(Adv));
        }

        cost_mx.setVisibility(VISIBLE);
        cost_mpx.setVisibility(VISIBLE);
        cost_m.setVisibility(GONE);
        cost_mp.setVisibility(GONE);
        proc = maxc + pro;
        prot = maxt;
        numTMaxC.setText(NumberFormat.getIntegerInstance().format(maxc));
        numTMaxT.setText(NumberFormat.getIntegerInstance().format(maxt));
        numPro.setText(NumberFormat.getIntegerInstance().format(pro));
        numTMPC.setText(NumberFormat.getIntegerInstance().format(proc));
        numTMPT.setText(NumberFormat.getIntegerInstance().format(prot));

    }

    void costcalculatorT_6() {
        maxc = maxt = 0;
        maxc += nInfo.getAccel1() + nInfo.getTop1() + nInfo.getHan1() + nInfo.getNos1() +
                nInfo.getAccel2() + nInfo.getTop2() + nInfo.getHan2() + nInfo.getNos2() +
                nInfo.getAccel3() + nInfo.getTop3() + nInfo.getHan3() + nInfo.getNos3() +
                nInfo.getAccel4() + nInfo.getTop4() + nInfo.getHan4() + nInfo.getNos4() +
                nInfo.getAccel5() + nInfo.getHan5();

        maxt += nInfo.getTop5()+
                nInfo.getNos5();

        pro += nInfo.getTire1() + nInfo.getSusp1() + nInfo.getDrive1() + nInfo.getExha1() +
                nInfo.getTire2() + nInfo.getSusp2() + nInfo.getDrive2() + nInfo.getExha2() +
                nInfo.getTire3() + nInfo.getSusp3() + nInfo.getDrive3() + nInfo.getExha3() +
                nInfo.getTire4() + nInfo.getSusp4() + nInfo.getDrive4() + nInfo.getExha4() +
                nInfo.getTire5() + nInfo.getSusp5() + nInfo.getDrive5() + nInfo.getExha5();
    }

    void CardBuilderT_6() {
        Part = Eng = 0;
        costcalculatorT_6();
        Part = nInfo.getPart1() + nInfo.getPart2() + nInfo.getPart3() + nInfo.getPart4() + nInfo.getPart5();
        Eng = nInfo.getEngn1() + nInfo.getEngn2() + nInfo.getEngn3() + nInfo.getEngn4() + nInfo.getEngn5();
        Eng = Eng * 4;
        procardset();
    }

    void CardSetterT_7() {
        if (Part == 0) {
            imgPart.setVisibility(GONE);
            numPart.setVisibility(GONE);
        } else {
            imgPart.setVisibility(VISIBLE);
            numPart.setVisibility(VISIBLE);
            if (CommonStuff.partsFinder(basic.getCarclass()) != -1)
                imgPart.setImageResource(CommonStuff.partsFinder(basic.getCarclass()));
            numPart.setText(NumberFormat.getIntegerInstance().format(Part));
        }

        if (Eng == 0) {
            imgEng.setVisibility(GONE);
            numEng.setVisibility(GONE);
        } else {
            imgEng.setVisibility(VISIBLE);
            numEng.setVisibility(VISIBLE);
            if (CommonStuff.engineFinder(basic.getEng()) != -1)
                imgEng.setImageResource(CommonStuff.engineFinder(basic.getEng()));
            numEng.setText(NumberFormat.getIntegerInstance().format(Eng));
        }

        if (Pri == 0) {
            imgInitial.setVisibility(GONE);
            numInitial.setVisibility(GONE);
            imgEarly.setVisibility(GONE);
            numEarly.setVisibility(GONE);
        } else {
            imgInitial.setVisibility(VISIBLE);
            numInitial.setVisibility(VISIBLE);
            imgEarly.setVisibility(VISIBLE);
            numEarly.setVisibility(VISIBLE);

            numInitial.setText(NumberFormat.getIntegerInstance().format(Pri));
            numEarly.setText(NumberFormat.getIntegerInstance().format(Pri));
        }

        if (Mid == 0) {
            imgMid.setVisibility(GONE);
            numMid.setVisibility(GONE);
        } else {
            imgMid.setVisibility(VISIBLE);
            numMid.setVisibility(VISIBLE);
            numMid.setText(NumberFormat.getIntegerInstance().format(Mid));
        }

        if (Adv == 0) {
            imgAdv.setVisibility(GONE);
            numAdv.setVisibility(GONE);
        } else {
            imgAdv.setVisibility(VISIBLE);
            numAdv.setVisibility(VISIBLE);
            numAdv.setText(NumberFormat.getIntegerInstance().format(Adv));
        }

        cost_mx.setVisibility(VISIBLE);
        cost_mpx.setVisibility(VISIBLE);
        cost_m.setVisibility(GONE);
        cost_mp.setVisibility(GONE);
        proc = maxc + pro;
        prot = maxt;
        numTMaxC.setText(NumberFormat.getIntegerInstance().format(maxc));
        numTMaxT.setText(NumberFormat.getIntegerInstance().format(maxt));
        numPro.setText(NumberFormat.getIntegerInstance().format(pro));
        numTMPC.setText(NumberFormat.getIntegerInstance().format(proc));
        numTMPT.setText(NumberFormat.getIntegerInstance().format(prot));

    }

    void costcalculatorT_7() {
        maxc = maxt = 0;
        maxc += nInfo.getAccel1() + nInfo.getTop1() + nInfo.getHan1() + nInfo.getNos1() +
                nInfo.getAccel2() + nInfo.getTop2() + nInfo.getHan2() + nInfo.getNos2() +
                nInfo.getAccel3() + nInfo.getHan3() +
                nInfo.getAccel4() + nInfo.getTop4() + nInfo.getHan4() + nInfo.getNos4() +
                nInfo.getAccel5() + nInfo.getHan5();


        maxt += nInfo.getTop3()+ nInfo.getNos3()+
                nInfo.getTop5()+ nInfo.getNos5();

        pro += nInfo.getTire1() + nInfo.getSusp1() + nInfo.getDrive1() + nInfo.getExha1() +
                nInfo.getTire2() + nInfo.getSusp2() + nInfo.getDrive2() + nInfo.getExha2() +
                nInfo.getTire3() + nInfo.getSusp3() + nInfo.getDrive3() + nInfo.getExha3() +
                nInfo.getTire4() + nInfo.getSusp4() + nInfo.getDrive4() + nInfo.getExha4() +
                nInfo.getTire5() + nInfo.getSusp5() + nInfo.getDrive5() + nInfo.getExha5();
    }

    void CardBuilderT_7() {
        Part = Eng = 0;
        costcalculatorT_7();
        Part = nInfo.getPart1() + nInfo.getPart2() + nInfo.getPart3() + nInfo.getPart4() + nInfo.getPart5();
        Eng = nInfo.getEngn1() + nInfo.getEngn2() + nInfo.getEngn3() + nInfo.getEngn4() + nInfo.getEngn5();
        Eng = Eng * 4;
        procardset();
    }

    void CardSetterT_8() {
        if (Part == 0) {
            imgPart.setVisibility(GONE);
            numPart.setVisibility(GONE);
        } else {
            imgPart.setVisibility(VISIBLE);
            numPart.setVisibility(VISIBLE);
            if (CommonStuff.partsFinder(basic.getCarclass()) != -1)
                imgPart.setImageResource(CommonStuff.partsFinder(basic.getCarclass()));
            numPart.setText(NumberFormat.getIntegerInstance().format(Part));
        }

        if (Eng == 0) {
            imgEng.setVisibility(GONE);
            numEng.setVisibility(GONE);
        } else {
            imgEng.setVisibility(VISIBLE);
            numEng.setVisibility(VISIBLE);
            if (CommonStuff.engineFinder(basic.getEng()) != -1)
                imgEng.setImageResource(CommonStuff.engineFinder(basic.getEng()));
            numEng.setText(NumberFormat.getIntegerInstance().format(Eng));
        }

        if (Pri == 0) {
            imgInitial.setVisibility(GONE);
            numInitial.setVisibility(GONE);
            imgEarly.setVisibility(GONE);
            numEarly.setVisibility(GONE);
        } else {
            imgInitial.setVisibility(VISIBLE);
            numInitial.setVisibility(VISIBLE);
            imgEarly.setVisibility(VISIBLE);
            numEarly.setVisibility(VISIBLE);

            numInitial.setText(NumberFormat.getIntegerInstance().format(Pri));
            numEarly.setText(NumberFormat.getIntegerInstance().format(Pri));
        }

        if (Mid == 0) {
            imgMid.setVisibility(GONE);
            numMid.setVisibility(GONE);
        } else {
            imgMid.setVisibility(VISIBLE);
            numMid.setVisibility(VISIBLE);
            numMid.setText(NumberFormat.getIntegerInstance().format(Mid));
        }

        if (Adv == 0) {
            imgAdv.setVisibility(GONE);
            numAdv.setVisibility(GONE);
        } else {
            imgAdv.setVisibility(VISIBLE);
            numAdv.setVisibility(VISIBLE);
            numAdv.setText(NumberFormat.getIntegerInstance().format(Adv));
        }

        cost_mx.setVisibility(VISIBLE);
        cost_mpx.setVisibility(VISIBLE);
        cost_m.setVisibility(GONE);
        cost_mp.setVisibility(GONE);
        proc = maxc + pro;
        prot = maxt;
        numTMaxC.setText(NumberFormat.getIntegerInstance().format(maxc));
        numTMaxT.setText(NumberFormat.getIntegerInstance().format(maxt));
        numPro.setText(NumberFormat.getIntegerInstance().format(pro));
        numTMPC.setText(NumberFormat.getIntegerInstance().format(proc));
        numTMPT.setText(NumberFormat.getIntegerInstance().format(prot));

    }

    void costcalculatorT_8() {
        maxc = maxt = 0;
        maxc += nInfo.getAccel1() + nInfo.getTop1() + nInfo.getHan1() + nInfo.getNos1() +
                nInfo.getAccel2() + nInfo.getTop2() + nInfo.getHan2() + nInfo.getNos2() +
                nInfo.getAccel3() + nInfo.getTop3()+ nInfo.getHan3() + nInfo.getNos3() +
                nInfo.getAccel4() + nInfo.getTop4() + nInfo.getHan4() + nInfo.getNos4()
                ;


        maxt += nInfo.getAccel5() + nInfo.getHan5() +
                nInfo.getTop5()+ nInfo.getNos5();

        pro += nInfo.getTire1() + nInfo.getSusp1() + nInfo.getDrive1() + nInfo.getExha1() +
                nInfo.getTire2() + nInfo.getSusp2() + nInfo.getDrive2() + nInfo.getExha2() +
                nInfo.getTire3() + nInfo.getSusp3() + nInfo.getDrive3() + nInfo.getExha3() +
                nInfo.getTire4() + nInfo.getSusp4() + nInfo.getDrive4() + nInfo.getExha4() +
                nInfo.getTire5() + nInfo.getSusp5() + nInfo.getDrive5() + nInfo.getExha5();
    }

    void CardBuilderT_8() {
        Part = Eng = 0;
        costcalculatorT_8();
        Part = nInfo.getPart1() + nInfo.getPart2() + nInfo.getPart3() + nInfo.getPart4() + nInfo.getPart5();
        Eng = nInfo.getEngn1() + nInfo.getEngn2() + nInfo.getEngn3() + nInfo.getEngn4() + nInfo.getEngn5();
        Eng = Eng * 4;
        procardset();
    }

    void CardSetterT_9() {
        if (Part == 0) {
            imgPart.setVisibility(GONE);
            numPart.setVisibility(GONE);
        } else {
            imgPart.setVisibility(VISIBLE);
            numPart.setVisibility(VISIBLE);
            if (CommonStuff.partsFinder(basic.getCarclass()) != -1)
                imgPart.setImageResource(CommonStuff.partsFinder(basic.getCarclass()));
            numPart.setText(NumberFormat.getIntegerInstance().format(Part));
        }

        if (Eng == 0) {
            imgEng.setVisibility(GONE);
            numEng.setVisibility(GONE);
        } else {
            imgEng.setVisibility(VISIBLE);
            numEng.setVisibility(VISIBLE);
            if (CommonStuff.engineFinder(basic.getEng()) != -1)
                imgEng.setImageResource(CommonStuff.engineFinder(basic.getEng()));
            numEng.setText(NumberFormat.getIntegerInstance().format(Eng));
        }

        if (Pri == 0) {
            imgInitial.setVisibility(GONE);
            numInitial.setVisibility(GONE);
            imgEarly.setVisibility(GONE);
            numEarly.setVisibility(GONE);
        } else {
            imgInitial.setVisibility(VISIBLE);
            numInitial.setVisibility(VISIBLE);
            imgEarly.setVisibility(VISIBLE);
            numEarly.setVisibility(VISIBLE);

            numInitial.setText(NumberFormat.getIntegerInstance().format(Pri));
            numEarly.setText(NumberFormat.getIntegerInstance().format(Pri));
        }

        if (Mid == 0) {
            imgMid.setVisibility(GONE);
            numMid.setVisibility(GONE);
        } else {
            imgMid.setVisibility(VISIBLE);
            numMid.setVisibility(VISIBLE);
            numMid.setText(NumberFormat.getIntegerInstance().format(Mid));
        }

        if (Adv == 0) {
            imgAdv.setVisibility(GONE);
            numAdv.setVisibility(GONE);
        } else {
            imgAdv.setVisibility(VISIBLE);
            numAdv.setVisibility(VISIBLE);
            numAdv.setText(NumberFormat.getIntegerInstance().format(Adv));
        }

        cost_mx.setVisibility(VISIBLE);
        cost_mpx.setVisibility(VISIBLE);
        cost_m.setVisibility(GONE);
        cost_mp.setVisibility(GONE);
        proc = maxc + pro;
        prot = maxt;
        numTMaxC.setText(NumberFormat.getIntegerInstance().format(maxc));
        numTMaxT.setText(NumberFormat.getIntegerInstance().format(maxt));
        numPro.setText(NumberFormat.getIntegerInstance().format(pro));
        numTMPC.setText(NumberFormat.getIntegerInstance().format(proc));
        numTMPT.setText(NumberFormat.getIntegerInstance().format(prot));

    }

    void costcalculatorT_9() {
        maxc = maxt = 0;
        maxc += nInfo.getAccel1() + nInfo.getTop1() + nInfo.getHan1() + nInfo.getNos1() +
                nInfo.getAccel2() + nInfo.getTop2() + nInfo.getHan2() + nInfo.getNos2() +
                nInfo.getAccel3() + nInfo.getTop3()+ nInfo.getHan3() + nInfo.getNos3()

        ;


        maxt += nInfo.getAccel5() + nInfo.getHan5() + nInfo.getAccel4() + nInfo.getTop4() + nInfo.getHan4() + nInfo.getNos4() +
                nInfo.getTop5()+ nInfo.getNos5();

        pro += nInfo.getTire1() + nInfo.getSusp1() + nInfo.getDrive1() + nInfo.getExha1() +
                nInfo.getTire2() + nInfo.getSusp2() + nInfo.getDrive2() + nInfo.getExha2() +
                nInfo.getTire3() + nInfo.getSusp3() + nInfo.getDrive3() + nInfo.getExha3() +
                nInfo.getTire4() + nInfo.getSusp4() + nInfo.getDrive4() + nInfo.getExha4() +
                nInfo.getTire5() + nInfo.getSusp5() + nInfo.getDrive5() + nInfo.getExha5();
    }

    void CardBuilderT_9() {
        Part = Eng = 0;
        costcalculatorT_9();
        Part = nInfo.getPart1() + nInfo.getPart2() + nInfo.getPart3() + nInfo.getPart4() + nInfo.getPart5();
        Eng = nInfo.getEngn1() + nInfo.getEngn2() + nInfo.getEngn3() + nInfo.getEngn4() + nInfo.getEngn5();
        Eng = Eng * 4;
        procardset();
    }

    void CardSetterT_10() {
        if (Part == 0) {
            imgPart.setVisibility(GONE);
            numPart.setVisibility(GONE);
        } else {
            imgPart.setVisibility(VISIBLE);
            numPart.setVisibility(VISIBLE);
            if (CommonStuff.partsFinder(basic.getCarclass()) != -1)
                imgPart.setImageResource(CommonStuff.partsFinder(basic.getCarclass()));
            numPart.setText(NumberFormat.getIntegerInstance().format(Part));
        }

        if (Eng == 0) {
            imgEng.setVisibility(GONE);
            numEng.setVisibility(GONE);
        } else {
            imgEng.setVisibility(VISIBLE);
            numEng.setVisibility(VISIBLE);
            if (CommonStuff.engineFinder(basic.getEng()) != -1)
                imgEng.setImageResource(CommonStuff.engineFinder(basic.getEng()));
            numEng.setText(NumberFormat.getIntegerInstance().format(Eng));
        }

        if (Pri == 0) {
            imgInitial.setVisibility(GONE);
            numInitial.setVisibility(GONE);
            imgEarly.setVisibility(GONE);
            numEarly.setVisibility(GONE);
        } else {
            imgInitial.setVisibility(VISIBLE);
            numInitial.setVisibility(VISIBLE);
            imgEarly.setVisibility(VISIBLE);
            numEarly.setVisibility(VISIBLE);

            numInitial.setText(NumberFormat.getIntegerInstance().format(Pri));
            numEarly.setText(NumberFormat.getIntegerInstance().format(Pri));
        }

        if (Mid == 0) {
            imgMid.setVisibility(GONE);
            numMid.setVisibility(GONE);
        } else {
            imgMid.setVisibility(VISIBLE);
            numMid.setVisibility(VISIBLE);
            numMid.setText(NumberFormat.getIntegerInstance().format(Mid));
        }

        if (Adv == 0) {
            imgAdv.setVisibility(GONE);
            numAdv.setVisibility(GONE);
        } else {
            imgAdv.setVisibility(VISIBLE);
            numAdv.setVisibility(VISIBLE);
            numAdv.setText(NumberFormat.getIntegerInstance().format(Adv));
        }

        cost_mx.setVisibility(VISIBLE);
        cost_mpx.setVisibility(VISIBLE);
        cost_m.setVisibility(GONE);
        cost_mp.setVisibility(GONE);
        proc = maxc + pro;
        prot = maxt;
        numTMaxC.setText(NumberFormat.getIntegerInstance().format(maxc));
        numTMaxT.setText(NumberFormat.getIntegerInstance().format(maxt));
        numPro.setText(NumberFormat.getIntegerInstance().format(pro));
        numTMPC.setText(NumberFormat.getIntegerInstance().format(proc));
        numTMPT.setText(NumberFormat.getIntegerInstance().format(prot));

    }

    void costcalculatorT_10() {
        maxc = maxt = 0;
        maxc += nInfo.getAccel1() + nInfo.getTop1() + nInfo.getHan1() + nInfo.getNos1() +
                nInfo.getAccel2() + nInfo.getTop2() + nInfo.getHan2() + nInfo.getNos2() +
                nInfo.getAccel3() + nInfo.getTop3()+ nInfo.getHan3() + nInfo.getNos3() +
                nInfo.getAccel5() + nInfo.getTop5() + nInfo.getHan5() + nInfo.getNos5();

        maxt += nInfo.getAccel4() + nInfo.getTop4() + nInfo.getHan4() + nInfo.getNos4();

        pro += nInfo.getTire1() + nInfo.getSusp1() + nInfo.getDrive1() + nInfo.getExha1() +
                nInfo.getTire2() + nInfo.getSusp2() + nInfo.getDrive2() + nInfo.getExha2() +
                nInfo.getTire3() + nInfo.getSusp3() + nInfo.getDrive3() + nInfo.getExha3() +
                nInfo.getTire4() + nInfo.getSusp4() + nInfo.getDrive4() + nInfo.getExha4() +
                nInfo.getTire5() + nInfo.getSusp5() + nInfo.getDrive5() + nInfo.getExha5();
    }

    void CardBuilderT_10() {
        Part = Eng = 0;
        costcalculatorT_10();
        Part = nInfo.getPart1() + nInfo.getPart2() + nInfo.getPart3() + nInfo.getPart4() + nInfo.getPart5();
        Eng = nInfo.getEngn1() + nInfo.getEngn2() + nInfo.getEngn3() + nInfo.getEngn4() + nInfo.getEngn5();
        Eng = Eng * 4;
        procardset();
    }*/

    @Override
    public void onAttach(Activity myActivity) {
        super.onAttach(myActivity);
        this.myActivity = (Disper) myActivity;
    }

}