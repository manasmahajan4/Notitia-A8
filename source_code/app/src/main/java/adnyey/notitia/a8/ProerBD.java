package adnyey.notitia.a8;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by Mahajan-PC on 04-02-2017.
 */

public class ProerBD {
    TextView partnumt1, engnumt1, technumt1, prict1;
    ImageView partimgt1, engimgt1, techimgt1;
    TextView partnumt2, engnumt2, technumt2, prict2;
    ImageView partimgt2, engimgt2, techimgt2;
    TextView partnumt3, engnumt3, technumt3, prict3;
    ImageView partimgt3, engimgt3, techimgt3;
    TextView partnumt4, engnumt4, technumt4, prict4;
    ImageView partimgt4, engimgt4, techimgt4;
    TextView partnumt5, engnumt5, technumt5, prict5;
    ImageView partimgt5, engimgt5, techimgt5;

    TextView partnums1, engnums1, technums1, prics1;
    ImageView partimgs1, engimgs1, techimgs1;
    TextView partnums2, engnums2, technums2, prics2;
    ImageView partimgs2, engimgs2, techimgs2;
    TextView partnums3, engnums3, technums3, prics3;
    ImageView partimgs3, engimgs3, techimgs3;
    TextView partnums4, engnums4, technums4, prics4;
    ImageView partimgs4, engimgs4, techimgs4;
    TextView partnums5, engnums5, technums5, prics5;
    ImageView partimgs5, engimgs5, techimgs5;

    TextView partnumd1, engnumd1, technumd1, pricd1;
    ImageView partimgd1, engimgd1, techimgd1;
    TextView partnumd2, engnumd2, technumd2, pricd2;
    ImageView partimgd2, engimgd2, techimgd2;
    TextView partnumd3, engnumd3, technumd3, pricd3;
    ImageView partimgd3, engimgd3, techimgd3;
    TextView partnumd4, engnumd4, technumd4, pricd4;
    ImageView partimgd4, engimgd4, techimgd4;
    TextView partnumd5, engnumd5, technumd5, pricd5;
    ImageView partimgd5, engimgd5, techimgd5;

    TextView partnume1, engnume1, technume1, price1;
    ImageView partimge1, engimge1, techimge1;
    TextView partnume2, engnume2, technume2, price2;
    ImageView partimge2, engimge2, techimge2;
    TextView partnume3, engnume3, technume3, price3;
    ImageView partimge3, engimge3, techimge3;
    TextView partnume4, engnume4, technume4, price4;
    ImageView partimge4, engimge4, techimge4;
    TextView partnume5, engnume5, technume5, price5;
    ImageView partimge5, engimge5, techimge5;

    TableRow row1, row2, row3, row4, row5;

    RequestOptions options = new RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);

    int eng = 0, tire = 0, susp = 0, drive = 0, exha = 0;

    ProerBD(Context conti, BasicInfo basic, ProNBObj Info) {
        final Dialog dialog = new Dialog(conti);
        dialog.setContentView(R.layout.table_pro_normal);
        partnumt1 = (TextView) dialog.findViewById(R.id.partNumt1);
        engnumt1 = (TextView) dialog.findViewById(R.id.engNumt1);
        technumt1 = (TextView) dialog.findViewById(R.id.techNumt1);
        prict1 = (TextView) dialog.findViewById(R.id.proPricet1);
        partnumt2 = (TextView) dialog.findViewById(R.id.partNumt2);
        engnumt2 = (TextView) dialog.findViewById(R.id.engNumt2);
        technumt2 = (TextView) dialog.findViewById(R.id.techNumt2);
        prict2 = (TextView) dialog.findViewById(R.id.proPricet2);
        partnumt3 = (TextView) dialog.findViewById(R.id.partNumt3);
        engnumt3 = (TextView) dialog.findViewById(R.id.engNumt3);
        technumt3 = (TextView) dialog.findViewById(R.id.techNumt3);
        prict3 = (TextView) dialog.findViewById(R.id.proPricet3);
        partnumt4 = (TextView) dialog.findViewById(R.id.partNumt4);
        engnumt4 = (TextView) dialog.findViewById(R.id.engNumt4);
        technumt4 = (TextView) dialog.findViewById(R.id.techNumt4);
        prict4 = (TextView) dialog.findViewById(R.id.proPricet4);
        partnumt5 = (TextView) dialog.findViewById(R.id.partNumt5);
        engnumt5 = (TextView) dialog.findViewById(R.id.engNumt5);
        technumt5 = (TextView) dialog.findViewById(R.id.techNumt5);
        prict5 = (TextView) dialog.findViewById(R.id.proPricet5);

        partnums1 = (TextView) dialog.findViewById(R.id.partNums1);
        engnums1 = (TextView) dialog.findViewById(R.id.engNums1);
        technums1 = (TextView) dialog.findViewById(R.id.techNums1);
        prics1 = (TextView) dialog.findViewById(R.id.proPrices1);
        partnums2 = (TextView) dialog.findViewById(R.id.partNums2);
        engnums2 = (TextView) dialog.findViewById(R.id.engNums2);
        technums2 = (TextView) dialog.findViewById(R.id.techNums2);
        prics2 = (TextView) dialog.findViewById(R.id.proPrices2);
        partnums3 = (TextView) dialog.findViewById(R.id.partNums3);
        engnums3 = (TextView) dialog.findViewById(R.id.engNums3);
        technums3 = (TextView) dialog.findViewById(R.id.techNums3);
        prics3 = (TextView) dialog.findViewById(R.id.proPrices3);
        partnums4 = (TextView) dialog.findViewById(R.id.partNums4);
        engnums4 = (TextView) dialog.findViewById(R.id.engNums4);
        technums4 = (TextView) dialog.findViewById(R.id.techNums4);
        prics4 = (TextView) dialog.findViewById(R.id.proPrices4);
        partnums5 = (TextView) dialog.findViewById(R.id.partNums5);
        engnums5 = (TextView) dialog.findViewById(R.id.engNums5);
        technums5 = (TextView) dialog.findViewById(R.id.techNums5);
        prics5 = (TextView) dialog.findViewById(R.id.proPrices5);

        partnumd1 = (TextView) dialog.findViewById(R.id.partNumd1);
        engnumd1 = (TextView) dialog.findViewById(R.id.engNumd1);
        technumd1 = (TextView) dialog.findViewById(R.id.techNumd1);
        pricd1 = (TextView) dialog.findViewById(R.id.proPriced1);
        partnumd2 = (TextView) dialog.findViewById(R.id.partNumd2);
        engnumd2 = (TextView) dialog.findViewById(R.id.engNumd2);
        technumd2 = (TextView) dialog.findViewById(R.id.techNumd2);
        pricd2 = (TextView) dialog.findViewById(R.id.proPriced2);
        partnumd3 = (TextView) dialog.findViewById(R.id.partNumd3);
        engnumd3 = (TextView) dialog.findViewById(R.id.engNumd3);
        technumd3 = (TextView) dialog.findViewById(R.id.techNumd3);
        pricd3 = (TextView) dialog.findViewById(R.id.proPriced3);
        partnumd4 = (TextView) dialog.findViewById(R.id.partNumd4);
        engnumd4 = (TextView) dialog.findViewById(R.id.engNumd4);
        technumd4 = (TextView) dialog.findViewById(R.id.techNumd4);
        pricd4 = (TextView) dialog.findViewById(R.id.proPriced4);
        partnumd5 = (TextView) dialog.findViewById(R.id.partNumd5);
        engnumd5 = (TextView) dialog.findViewById(R.id.engNumd5);
        technumd5 = (TextView) dialog.findViewById(R.id.techNumd5);
        pricd5 = (TextView) dialog.findViewById(R.id.proPriced5);

        partnume1 = (TextView) dialog.findViewById(R.id.partNume1);
        engnume1 = (TextView) dialog.findViewById(R.id.engNume1);
        technume1 = (TextView) dialog.findViewById(R.id.techNume1);
        price1 = (TextView) dialog.findViewById(R.id.proPricee1);
        partnume2 = (TextView) dialog.findViewById(R.id.partNume2);
        engnume2 = (TextView) dialog.findViewById(R.id.engNume2);
        technume2 = (TextView) dialog.findViewById(R.id.techNume2);
        price2 = (TextView) dialog.findViewById(R.id.proPricee2);
        partnume3 = (TextView) dialog.findViewById(R.id.partNume3);
        engnume3 = (TextView) dialog.findViewById(R.id.engNume3);
        technume3 = (TextView) dialog.findViewById(R.id.techNume3);
        price3 = (TextView) dialog.findViewById(R.id.proPricee3);
        partnume4 = (TextView) dialog.findViewById(R.id.partNume4);
        engnume4 = (TextView) dialog.findViewById(R.id.engNume4);
        technume4 = (TextView) dialog.findViewById(R.id.techNume4);
        price4 = (TextView) dialog.findViewById(R.id.proPricee4);
        partnume5 = (TextView) dialog.findViewById(R.id.partNume5);
        engnume5 = (TextView) dialog.findViewById(R.id.engNume5);
        technume5 = (TextView) dialog.findViewById(R.id.techNume5);
        price5 = (TextView) dialog.findViewById(R.id.proPricee5);

        partimge1 = (ImageView) dialog.findViewById(R.id.partImge1);
        engimge1 = (ImageView) dialog.findViewById(R.id.engImge1);
        techimge1 = (ImageView) dialog.findViewById(R.id.techImge1);
        partimge2 = (ImageView) dialog.findViewById(R.id.partImge2);
        engimge2 = (ImageView) dialog.findViewById(R.id.engImge2);
        techimge2 = (ImageView) dialog.findViewById(R.id.techImge2);
        partimge3 = (ImageView) dialog.findViewById(R.id.partImge3);
        engimge3 = (ImageView) dialog.findViewById(R.id.engImge3);
        techimge3 = (ImageView) dialog.findViewById(R.id.techImge3);
        partimge4 = (ImageView) dialog.findViewById(R.id.partImge4);
        engimge4 = (ImageView) dialog.findViewById(R.id.engImge4);
        techimge4 = (ImageView) dialog.findViewById(R.id.techImge4);
        partimge5 = (ImageView) dialog.findViewById(R.id.partImge5);
        engimge5 = (ImageView) dialog.findViewById(R.id.engImge5);
        techimge5 = (ImageView) dialog.findViewById(R.id.techImge5);

        partimgt1 = (ImageView) dialog.findViewById(R.id.partImgt1);
        engimgt1 = (ImageView) dialog.findViewById(R.id.engImgt1);
        techimgt1 = (ImageView) dialog.findViewById(R.id.techImgt1);
        partimgt2 = (ImageView) dialog.findViewById(R.id.partImgt2);
        engimgt2 = (ImageView) dialog.findViewById(R.id.engImgt2);
        techimgt2 = (ImageView) dialog.findViewById(R.id.techImgt2);
        partimgt3 = (ImageView) dialog.findViewById(R.id.partImgt3);
        engimgt3 = (ImageView) dialog.findViewById(R.id.engImgt3);
        techimgt3 = (ImageView) dialog.findViewById(R.id.techImgt3);
        partimgt4 = (ImageView) dialog.findViewById(R.id.partImgt4);
        engimgt4 = (ImageView) dialog.findViewById(R.id.engImgt4);
        techimgt4 = (ImageView) dialog.findViewById(R.id.techImgt4);
        partimgt5 = (ImageView) dialog.findViewById(R.id.partImgt5);
        engimgt5 = (ImageView) dialog.findViewById(R.id.engImgt5);
        techimgt5 = (ImageView) dialog.findViewById(R.id.techImgt5);

        partimgs1 = (ImageView) dialog.findViewById(R.id.partImgs1);
        engimgs1 = (ImageView) dialog.findViewById(R.id.engImgs1);
        techimgs1 = (ImageView) dialog.findViewById(R.id.techImgs1);
        partimgs2 = (ImageView) dialog.findViewById(R.id.partImgs2);
        engimgs2 = (ImageView) dialog.findViewById(R.id.engImgs2);
        techimgs2 = (ImageView) dialog.findViewById(R.id.techImgs2);
        partimgs3 = (ImageView) dialog.findViewById(R.id.partImgs3);
        engimgs3 = (ImageView) dialog.findViewById(R.id.engImgs3);
        techimgs3 = (ImageView) dialog.findViewById(R.id.techImgs3);
        partimgs4 = (ImageView) dialog.findViewById(R.id.partImgs4);
        engimgs4 = (ImageView) dialog.findViewById(R.id.engImgs4);
        techimgs4 = (ImageView) dialog.findViewById(R.id.techImgs4);
        partimgs5 = (ImageView) dialog.findViewById(R.id.partImgs5);
        engimgs5 = (ImageView) dialog.findViewById(R.id.engImgs5);
        techimgs5 = (ImageView) dialog.findViewById(R.id.techImgs5);

        partimgd1 = (ImageView) dialog.findViewById(R.id.partImgd1);
        engimgd1 = (ImageView) dialog.findViewById(R.id.engImgd1);
        techimgd1 = (ImageView) dialog.findViewById(R.id.techImgd1);
        partimgd2 = (ImageView) dialog.findViewById(R.id.partImgd2);
        engimgd2 = (ImageView) dialog.findViewById(R.id.engImgd2);
        techimgd2 = (ImageView) dialog.findViewById(R.id.techImgd2);
        partimgd3 = (ImageView) dialog.findViewById(R.id.partImgd3);
        engimgd3 = (ImageView) dialog.findViewById(R.id.engImgd3);
        techimgd3 = (ImageView) dialog.findViewById(R.id.techImgd3);
        partimgd4 = (ImageView) dialog.findViewById(R.id.partImgd4);
        engimgd4 = (ImageView) dialog.findViewById(R.id.engImgd4);
        techimgd4 = (ImageView) dialog.findViewById(R.id.techImgd4);
        partimgd5 = (ImageView) dialog.findViewById(R.id.partImgd5);
        engimgd5 = (ImageView) dialog.findViewById(R.id.engImgd5);
        techimgd5 = (ImageView) dialog.findViewById(R.id.techImgd5);

        row1 = (TableRow) dialog.findViewById(R.id.pro_row1);
        row2 = (TableRow) dialog.findViewById(R.id.pro_row2);
        row3 = (TableRow) dialog.findViewById(R.id.pro_row3);
        row4 = (TableRow) dialog.findViewById(R.id.pro_row4);
        row5 = (TableRow) dialog.findViewById(R.id.pro_row5);

        try {
            if (basic.getEng().equals("cre"))
                eng = R.drawable.eng_cre;
            if (basic.getEng().equals("electric"))
                eng = R.drawable.eng_electric;
            if (basic.getEng().equals("f12"))
                eng = R.drawable.eng_f12;
            if (basic.getEng().equals("f6"))
                eng = R.drawable.eng_f6;
            if (basic.getEng().equals("fiv8"))
                eng = R.drawable.eng_fiv8;
            if (basic.getEng().equals("hybrid"))
                eng = R.drawable.eng_hybrid;
            if (basic.getEng().equals("i4"))
                eng = R.drawable.eng_i4;
            if (basic.getEng().equals("i5"))
                eng = R.drawable.eng_i5;
            if (basic.getEng().equals("i6"))
                eng = R.drawable.eng_i6;
            if (basic.getEng().equals("rotary"))
                eng = R.drawable.eng_rotary;
            if (basic.getEng().equals("sre"))
                eng = R.drawable.eng_sre;
            if (basic.getEng().equals("v10"))
                eng = R.drawable.eng_v10;
            if (basic.getEng().equals("v12"))
                eng = R.drawable.eng_v12;
            if (basic.getEng().equals("v16"))
                eng = R.drawable.eng_v16;
            if (basic.getEng().equals("v6"))
                eng = R.drawable.eng_v6;
            if (basic.getEng().equals("v8"))
                eng = R.drawable.eng_v8;
            if (basic.getEng().equals("w16"))
                eng = R.drawable.eng_w16;
            if (basic.getEng().equals("rare"))
                eng = R.drawable.eng_rare;
            if (basic.getEng().equals("legend"))
                eng = R.drawable.eng_legend;
            if (basic.getEng().equals("fse"))
                eng = R.drawable.eng_fse;
            if (basic.getEng().equals("vte"))
                eng = R.drawable.eng_vte;
            if (basic.getEng().equals("ffse"))
                eng = R.drawable.eng_ffse;
            if (basic.getEng().equals("v12mpi"))
                eng = R.drawable.eng_v12mpi;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        if (basic.getCarclass() == 1) {
            tire = R.drawable.part_d_bk_tire;
            susp = R.drawable.part_d_bk_susp;
            drive = R.drawable.part_d_bk_drive;
            exha = R.drawable.part_d_bk_exha;
        } else if (basic.getCarclass() == 2) {
            tire = R.drawable.part_c_bk_tire;
            susp = R.drawable.part_c_bk_susp;
            drive = R.drawable.part_c_bk_drive;
            exha = R.drawable.part_c_bk_exha;
        } else if (basic.getCarclass() == 3) {
            tire = R.drawable.part_b_bk_tire;
            susp = R.drawable.part_b_bk_susp;
            drive = R.drawable.part_b_bk_drive;
            exha = R.drawable.part_b_bk_exha;
        } else if (basic.getCarclass() == 4) {
            tire = R.drawable.part_a_bk_tire;
            susp = R.drawable.part_a_bk_susp;
            drive = R.drawable.part_a_bk_drive;
            exha = R.drawable.part_a_bk_exha;
        } else if (basic.getCarclass() == 5) {
            tire = R.drawable.part_s_bk_tire;
            susp = R.drawable.part_s_bk_susp;
            drive = R.drawable.part_s_bk_drive;
            exha = R.drawable.part_s_bk_exha;
        }

        try {
            prict1.setText(NumberFormat.getIntegerInstance().format(Info.getTire1()));
            prics1.setText(NumberFormat.getIntegerInstance().format(Info.getSusp1()));
            pricd1.setText(NumberFormat.getIntegerInstance().format(Info.getDrive1()));
            price1.setText(NumberFormat.getIntegerInstance().format(Info.getExha1()));
            prict2.setText(NumberFormat.getIntegerInstance().format(Info.getTire2()));
            prics2.setText(NumberFormat.getIntegerInstance().format(Info.getSusp2()));
            pricd2.setText(NumberFormat.getIntegerInstance().format(Info.getDrive2()));
            price2.setText(NumberFormat.getIntegerInstance().format(Info.getExha2()));
            prict3.setText(NumberFormat.getIntegerInstance().format(Info.getTire3()));
            prics3.setText(NumberFormat.getIntegerInstance().format(Info.getSusp3()));
            pricd3.setText(NumberFormat.getIntegerInstance().format(Info.getDrive3()));
            price3.setText(NumberFormat.getIntegerInstance().format(Info.getExha3()));
            prict4.setText(NumberFormat.getIntegerInstance().format(Info.getTire4()));
            prics4.setText(NumberFormat.getIntegerInstance().format(Info.getSusp4()));
            pricd4.setText(NumberFormat.getIntegerInstance().format(Info.getDrive4()));
            price4.setText(NumberFormat.getIntegerInstance().format(Info.getExha4()));
            prict5.setText(NumberFormat.getIntegerInstance().format(Info.getTire5()));
            prics5.setText(NumberFormat.getIntegerInstance().format(Info.getSusp5()));
            pricd5.setText(NumberFormat.getIntegerInstance().format(Info.getDrive5()));
            price5.setText(NumberFormat.getIntegerInstance().format(Info.getExha5()));

            prict1.setTypeface(null, Typeface.BOLD);
            prics1.setTypeface(null, Typeface.BOLD);
            pricd1.setTypeface(null, Typeface.BOLD);
            price1.setTypeface(null, Typeface.BOLD);
            prict2.setTypeface(null, Typeface.BOLD);
            prics2.setTypeface(null, Typeface.BOLD);
            pricd2.setTypeface(null, Typeface.BOLD);
            price2.setTypeface(null, Typeface.BOLD);
            prict3.setTypeface(null, Typeface.BOLD);
            prics3.setTypeface(null, Typeface.BOLD);
            pricd3.setTypeface(null, Typeface.BOLD);
            price3.setTypeface(null, Typeface.BOLD);
            prict4.setTypeface(null, Typeface.BOLD);
            prics4.setTypeface(null, Typeface.BOLD);
            pricd4.setTypeface(null, Typeface.BOLD);
            price4.setTypeface(null, Typeface.BOLD);
            prict5.setTypeface(null, Typeface.BOLD);
            prics5.setTypeface(null, Typeface.BOLD);
            pricd5.setTypeface(null, Typeface.BOLD);
            price5.setTypeface(null, Typeface.BOLD);

            technumt1.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn1()));
            technums1.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn1()));
            technumd1.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn1()));
            technume1.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn1()));
            technumt2.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn2()));
            technums2.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn2()));
            technumd2.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn2()));
            technume2.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn2()));
            technumt3.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn3()));
            technums3.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn3()));
            technumd3.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn3()));
            technume3.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn3()));
            technumt4.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn4()));
            technums4.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn4()));
            technumd4.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn4()));
            technume4.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn4()));
            technumt5.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn5()));
            technums5.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn5()));
            technumd5.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn5()));
            technume5.setText("X" + NumberFormat.getIntegerInstance().format(Info.getTechn5()));

            partnumt1.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart1()));
            partnums1.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart1()));
            partnumd1.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart1()));
            partnume1.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart1()));
            partnumt2.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart2()));
            partnums2.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart2()));
            partnumd2.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart2()));
            partnume2.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart2()));
            partnumt3.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart3()));
            partnums3.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart3()));
            partnumd3.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart3()));
            partnume3.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart3()));
            partnumt4.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart4()));
            partnums4.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart4()));
            partnumd4.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart4()));
            partnume4.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart4()));
            partnumt5.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart5()));
            partnums5.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart5()));
            partnumd5.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart5()));
            partnume5.setText("X" + NumberFormat.getIntegerInstance().format(Info.getPart5()));

            engnumt1.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn1()));
            engnums1.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn1()));
            engnumd1.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn1()));
            engnume1.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn1()));
            engnumt2.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn2()));
            engnums2.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn2()));
            engnumd2.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn2()));
            engnume2.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn2()));
            engnumt3.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn3()));
            engnums3.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn3()));
            engnumd3.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn3()));
            engnume3.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn3()));
            engnumt4.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn4()));
            engnums4.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn4()));
            engnumd4.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn4()));
            engnume4.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn4()));
            engnumt5.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn5()));
            engnums5.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn5()));
            engnumd5.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn5()));
            engnume5.setText("X" + NumberFormat.getIntegerInstance().format(Info.getEngn5()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        techimager(Info, conti);
        engimager(Info, conti);
        partimager(Info, conti);
        rowdis(Info);
        dialog.setTitle("PRO");
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        lp.copyFrom(window.getAttributes());

        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);
        dialog.show();


    }

    void rowdis(ProNBObj Info) {
        if (!(Info.getPart1() > 0)) {
            if (!(Info.getEngn1() > 0)) {
                row1.setVisibility(GONE);
            }
        }

        if (!(Info.getPart2() > 0)) {
            if (!(Info.getEngn2() > 0)) {
                row2.setVisibility(GONE);
            }
        }

        if (!(Info.getPart3() > 0)) {
            if (!(Info.getEngn3() > 0)) {
                row3.setVisibility(GONE);
            }
        }

        if (!(Info.getPart4() > 0)) {
            if (!(Info.getEngn4() > 0)) {
                row4.setVisibility(GONE);
            }
        }

        if (!(Info.getPart5() > 0)) {
            if (!(Info.getEngn5() > 0)) {
                row5.setVisibility(GONE);
            }
        }
    }

    void partimager(ProNBObj Info, Context conti) {
        partimgt1.setVisibility(GONE);
        partimgs1.setVisibility(GONE);
        partimgd1.setVisibility(GONE);
        partimge1.setVisibility(GONE);
        partimgt2.setVisibility(GONE);
        partimgs2.setVisibility(GONE);
        partimgd2.setVisibility(GONE);
        partimge2.setVisibility(GONE);
        partimgt3.setVisibility(GONE);
        partimgs3.setVisibility(GONE);
        partimgd3.setVisibility(GONE);
        partimge3.setVisibility(GONE);
        partimgt4.setVisibility(GONE);
        partimgs4.setVisibility(GONE);
        partimgd4.setVisibility(GONE);
        partimge4.setVisibility(GONE);
        partimgt5.setVisibility(GONE);
        partimgs5.setVisibility(GONE);
        partimgd5.setVisibility(GONE);
        partimge5.setVisibility(GONE);

        partnumt1.setVisibility(GONE);
        partnums1.setVisibility(GONE);
        partnumd1.setVisibility(GONE);
        partnume1.setVisibility(GONE);
        partnumt2.setVisibility(GONE);
        partnums2.setVisibility(GONE);
        partnumd2.setVisibility(GONE);
        partnume2.setVisibility(GONE);
        partnumt3.setVisibility(GONE);
        partnums3.setVisibility(GONE);
        partnumd3.setVisibility(GONE);
        partnume3.setVisibility(GONE);
        partnumt4.setVisibility(GONE);
        partnums4.setVisibility(GONE);
        partnumd4.setVisibility(GONE);
        partnume4.setVisibility(GONE);
        partnumt5.setVisibility(GONE);
        partnums5.setVisibility(GONE);
        partnumd5.setVisibility(GONE);
        partnume5.setVisibility(GONE);

        try {
            if (Info.getPart1() > 0) {
                partimgt1.setVisibility(VISIBLE);
                partimgs1.setVisibility(VISIBLE);
                partimgd1.setVisibility(VISIBLE);
                partimge1.setVisibility(VISIBLE);
                partnumt1.setVisibility(VISIBLE);
                partnums1.setVisibility(VISIBLE);
                partnumd1.setVisibility(VISIBLE);
                partnume1.setVisibility(VISIBLE);
                Glide.with(conti).load(tire)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimgt1);
                //partimgt1.setImageResource(tire);
                Glide.with(conti).load(susp)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimgs1);
                //partimgs1.setImageResource(susp);
                Glide.with(conti).load(drive)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimgd1);
                //partimgd1.setImageResource(drive);
                Glide.with(conti).load(exha)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimge1);
                //partimge1.setImageResource(exha);
            }
            if (Info.getPart2() > 0) {
                partimgt2.setVisibility(VISIBLE);
                partimgs2.setVisibility(VISIBLE);
                partimgd2.setVisibility(VISIBLE);
                partimge2.setVisibility(VISIBLE);
                partnumt2.setVisibility(VISIBLE);
                partnums2.setVisibility(VISIBLE);
                partnumd2.setVisibility(VISIBLE);
                partnume2.setVisibility(VISIBLE);
                Glide.with(conti).load(tire)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimgt2);
                //partimgt2.setImageResource(tire);
                Glide.with(conti).load(susp)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimgs2);
                //partimgs2.setImageResource(susp);
                Glide.with(conti).load(drive)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimgd2);
                //partimgd2.setImageResource(drive);
                Glide.with(conti).load(exha)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimge2);
                //partimge2.setImageResource(exha);
            }
            if (Info.getPart3() > 0) {
                partimgt3.setVisibility(VISIBLE);
                partimgs3.setVisibility(VISIBLE);
                partimgd3.setVisibility(VISIBLE);
                partimge3.setVisibility(VISIBLE);
                partnumt3.setVisibility(VISIBLE);
                partnums3.setVisibility(VISIBLE);
                partnumd3.setVisibility(VISIBLE);
                partnume3.setVisibility(VISIBLE);
                Glide.with(conti).load(tire)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimgt3);
                //partimgt3.setImageResource(tire);
                Glide.with(conti).load(susp)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimgs3);
                //partimgs3.setImageResource(susp);
                Glide.with(conti).load(drive)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimgd3);
                //partimgd3.setImageResource(drive);
                Glide.with(conti).load(exha)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimge3);
                //partimge3.setImageResource(exha);
            }
            if (Info.getPart4() > 0) {
                partimgt4.setVisibility(VISIBLE);
                partimgs4.setVisibility(VISIBLE);
                partimgd4.setVisibility(VISIBLE);
                partimge4.setVisibility(VISIBLE);
                partnumt4.setVisibility(VISIBLE);
                partnums4.setVisibility(VISIBLE);
                partnumd4.setVisibility(VISIBLE);
                partnume4.setVisibility(VISIBLE);
                Glide.with(conti).load(tire)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimgt4);
                //partimgt4.setImageResource(tire);
                Glide.with(conti).load(susp)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimgs4);
                //partimgs4.setImageResource(susp);
                Glide.with(conti).load(drive)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimgd4);
                //partimgd4.setImageResource(drive);
                Glide.with(conti).load(exha)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimge4);
                //partimge4.setImageResource(exha);
            }
            if (Info.getPart5() > 0) {
                partimgt5.setVisibility(VISIBLE);
                partimgs5.setVisibility(VISIBLE);
                partimgd5.setVisibility(VISIBLE);
                partimge5.setVisibility(VISIBLE);
                partnumt5.setVisibility(VISIBLE);
                partnums5.setVisibility(VISIBLE);
                partnumd5.setVisibility(VISIBLE);
                partnume5.setVisibility(VISIBLE);
                Glide.with(conti).load(tire)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimgt5);
                //partimgt5.setImageResource(tire);
                Glide.with(conti).load(susp)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimgs5);
                //partimgs5.setImageResource(susp);
                Glide.with(conti).load(drive)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimgd5);
                //partimgd5.setImageResource(drive);
                Glide.with(conti).load(exha)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(partimge5);
                //partimge5.setImageResource(exha);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    void engimager(ProNBObj Info, Context conti) {
        engimgt1.setVisibility(GONE);
        engimgs1.setVisibility(GONE);
        engimgd1.setVisibility(GONE);
        engimge1.setVisibility(GONE);
        engimgt2.setVisibility(GONE);
        engimgs2.setVisibility(GONE);
        engimgd2.setVisibility(GONE);
        engimge2.setVisibility(GONE);
        engimgt3.setVisibility(GONE);
        engimgs3.setVisibility(GONE);
        engimgd3.setVisibility(GONE);
        engimge3.setVisibility(GONE);
        engimgt4.setVisibility(GONE);
        engimgs4.setVisibility(GONE);
        engimgd4.setVisibility(GONE);
        engimge4.setVisibility(GONE);
        engimgt5.setVisibility(GONE);
        engimgs5.setVisibility(GONE);
        engimgd5.setVisibility(GONE);
        engimge5.setVisibility(GONE);

        engnumt1.setVisibility(GONE);
        engnums1.setVisibility(GONE);
        engnumd1.setVisibility(GONE);
        engnume1.setVisibility(GONE);
        engnumt2.setVisibility(GONE);
        engnums2.setVisibility(GONE);
        engnumd2.setVisibility(GONE);
        engnume2.setVisibility(GONE);
        engnumt3.setVisibility(GONE);
        engnums3.setVisibility(GONE);
        engnumd3.setVisibility(GONE);
        engnume3.setVisibility(GONE);
        engnumt4.setVisibility(GONE);
        engnums4.setVisibility(GONE);
        engnumd4.setVisibility(GONE);
        engnume4.setVisibility(GONE);
        engnumt5.setVisibility(GONE);
        engnums5.setVisibility(GONE);
        engnumd5.setVisibility(GONE);
        engnume5.setVisibility(GONE);

        try {
            if (Info.getEngn1() > 0) {
                engimgt1.setVisibility(VISIBLE);
                engimgs1.setVisibility(VISIBLE);
                engimgd1.setVisibility(VISIBLE);
                engimge1.setVisibility(VISIBLE);
                engnumt1.setVisibility(VISIBLE);
                engnums1.setVisibility(VISIBLE);
                engnumd1.setVisibility(VISIBLE);
                engnume1.setVisibility(VISIBLE);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimgt1);
                //engimgt1.setImageResource(eng);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimgs1);
                //engimgs1.setImageResource(eng);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimgd1);
                //engimgd1.setImageResource(eng);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimge1);
                //engimge1.setImageResource(eng);
            }
            if (Info.getEngn2() > 0) {
                engimgt2.setVisibility(VISIBLE);
                engimgs2.setVisibility(VISIBLE);
                engimgd2.setVisibility(VISIBLE);
                engimge2.setVisibility(VISIBLE);
                engnumt2.setVisibility(VISIBLE);
                engnums2.setVisibility(VISIBLE);
                engnumd2.setVisibility(VISIBLE);
                engnume2.setVisibility(VISIBLE);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimgt2);
                //engimgt2.setImageResource(eng);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimgs2);
                //engimgs2.setImageResource(eng);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimgd2);
                //engimgd2.setImageResource(eng);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimge2);
                //engimge2.setImageResource(eng);
            }
            if (Info.getEngn3() > 0) {
                engimgt3.setVisibility(VISIBLE);
                engimgs3.setVisibility(VISIBLE);
                engimgd3.setVisibility(VISIBLE);
                engimge3.setVisibility(VISIBLE);
                engnumt3.setVisibility(VISIBLE);
                engnums3.setVisibility(VISIBLE);
                engnumd3.setVisibility(VISIBLE);
                engnume3.setVisibility(VISIBLE);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimgt3);
                //engimgt3.setImageResource(eng);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimgs3);
                //engimgs3.setImageResource(eng);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimgd3);
                //engimgd3.setImageResource(eng);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimge3);
                //engimge3.setImageResource(eng);
            }
            if (Info.getEngn4() > 0) {
                engimgt4.setVisibility(VISIBLE);
                engimgs4.setVisibility(VISIBLE);
                engimgd4.setVisibility(VISIBLE);
                engimge4.setVisibility(VISIBLE);
                engnumt4.setVisibility(VISIBLE);
                engnums4.setVisibility(VISIBLE);
                engnumd4.setVisibility(VISIBLE);
                engnume4.setVisibility(VISIBLE);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimgt4);
                //engimgt4.setImageResource(eng);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimgs4);
                //engimgs4.setImageResource(eng);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimgd4);
                //engimgd4.setImageResource(eng);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimge4);
                //engimge4.setImageResource(eng);
            }
            if (Info.getEngn5() > 0) {
                engimgt5.setVisibility(VISIBLE);
                engimgs5.setVisibility(VISIBLE);
                engimgd5.setVisibility(VISIBLE);
                engimge5.setVisibility(VISIBLE);
                engnumt5.setVisibility(VISIBLE);
                engnums5.setVisibility(VISIBLE);
                engnumd5.setVisibility(VISIBLE);
                engnume5.setVisibility(VISIBLE);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimgt5);
                //engimgt5.setImageResource(eng);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimgs5);
                //engimgs5.setImageResource(eng);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimgd5);
                //engimgd5.setImageResource(eng);
                Glide.with(conti).load(eng)

                        .apply(options)
                        .thumbnail(0.1f)
                        .into(engimge5);
                //engimge5.setImageResource(eng);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    void techimager(ProNBObj Info, Context conti) {

        techimgt1.setVisibility(GONE);
        techimgs1.setVisibility(GONE);
        techimgd1.setVisibility(GONE);
        techimge1.setVisibility(GONE);
        techimgt2.setVisibility(GONE);
        techimgs2.setVisibility(GONE);
        techimgd2.setVisibility(GONE);
        techimge2.setVisibility(GONE);
        techimgt3.setVisibility(GONE);
        techimgs3.setVisibility(GONE);
        techimgd3.setVisibility(GONE);
        techimge3.setVisibility(GONE);
        techimgt4.setVisibility(GONE);
        techimgs4.setVisibility(GONE);
        techimgd4.setVisibility(GONE);
        techimge4.setVisibility(GONE);
        techimgt5.setVisibility(GONE);
        techimgs5.setVisibility(GONE);
        techimgd5.setVisibility(GONE);
        techimge5.setVisibility(GONE);

        technumt1.setVisibility(GONE);
        technums1.setVisibility(GONE);
        technumd1.setVisibility(GONE);
        technume1.setVisibility(GONE);
        technumt2.setVisibility(GONE);
        technums2.setVisibility(GONE);
        technumd2.setVisibility(GONE);
        technume2.setVisibility(GONE);
        technumt3.setVisibility(GONE);
        technums3.setVisibility(GONE);
        technumd3.setVisibility(GONE);
        technume3.setVisibility(GONE);
        technumt4.setVisibility(GONE);
        technums4.setVisibility(GONE);
        technumd4.setVisibility(GONE);
        technume4.setVisibility(GONE);
        technumt5.setVisibility(GONE);
        technums5.setVisibility(GONE);
        technumd5.setVisibility(GONE);
        technume5.setVisibility(GONE);
        try {
            if (Info.getTechn1() > 0) {
                techimgt1.setVisibility(VISIBLE);
                techimgs1.setVisibility(VISIBLE);
                techimgd1.setVisibility(VISIBLE);
                techimge1.setVisibility(VISIBLE);
                technumt1.setVisibility(VISIBLE);
                technums1.setVisibility(VISIBLE);
                technumd1.setVisibility(VISIBLE);
                technume1.setVisibility(VISIBLE);
                if (Info.getTech11() == 1 && Info.getTech12() == 2) {
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt1);
                    //techimgt1.setImageResource(R.drawable.tech_initial);
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd1);
                    //techimgd1.setImageResource(R.drawable.tech_initial);
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs1);
                    //techimgs1.setImageResource(R.drawable.tech_early);
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge1);
                    //techimge1.setImageResource(R.drawable.tech_early);
                } else if (Info.getTech11() == 2 && Info.getTech12() == 1) {
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt1);
                    //techimgt1.setImageResource(R.drawable.tech_early);
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd1);
                    //techimgd1.setImageResource(R.drawable.tech_early);
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs1);
                    //techimgs1.setImageResource(R.drawable.tech_initial);
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge1);
                    //techimge1.setImageResource(R.drawable.tech_initial);
                } else if (Info.getTech11() == 3 && Info.getTech12() == 3) {
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt1);
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd1);
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs1);
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge1);
                    //techimgt1.setImageResource(R.drawable.tech_mid);
                    //techimgd1.setImageResource(R.drawable.tech_mid);
                    //techimgs1.setImageResource(R.drawable.tech_mid);
                    //techimge1.setImageResource(R.drawable.tech_mid);
                } else if (Info.getTech11() == 4 && Info.getTech12() == 4) {
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt1);
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd1);
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs1);
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge1);
                    //techimgt1.setImageResource(R.drawable.tech_adv);
                    //techimgd1.setImageResource(R.drawable.tech_adv);
                    //techimgs1.setImageResource(R.drawable.tech_adv);
                    //techimge1.setImageResource(R.drawable.tech_adv);
                }

                else if (Info.getTech11() == 5 && Info.getTech12() == 5) {
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt1);
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd1);
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs1);
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge1);
                    //techimgt1.setImageResource(R.drawable.tech_bk_adv);
                    //techimgd1.setImageResource(R.drawable.tech_bk_adv);
                    //techimgs1.setImageResource(R.drawable.tech_bk_adv);
                    //techimge1.setImageResource(R.drawable.tech_bk_adv);
                }

                else if (Info.getTech11() == 6 && Info.getTech12() == 6) {
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt1);
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd1);
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs1);
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge1);
                    //techimgt1.setImageResource(R.drawable.tech_bk_adv);
                    //techimgd1.setImageResource(R.drawable.tech_bk_adv);
                    //techimgs1.setImageResource(R.drawable.tech_bk_adv);
                    //techimge1.setImageResource(R.drawable.tech_bk_adv);
                }

                else if (Info.getTech11() == 7 && Info.getTech12() == 7) {
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt1);
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd1);
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs1);
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge1);
                    //techimgt1.setImageResource(R.drawable.tech_bk_adv);
                    //techimgd1.setImageResource(R.drawable.tech_bk_adv);
                    //techimgs1.setImageResource(R.drawable.tech_bk_adv);
                    //techimge1.setImageResource(R.drawable.tech_bk_adv);
                }
            }


            if (Info.getTechn2() > 0) {
                techimgt2.setVisibility(VISIBLE);
                techimgs2.setVisibility(VISIBLE);
                techimgd2.setVisibility(VISIBLE);
                techimge2.setVisibility(VISIBLE);
                technumt2.setVisibility(VISIBLE);
                technums2.setVisibility(VISIBLE);
                technumd2.setVisibility(VISIBLE);
                technume2.setVisibility(VISIBLE);
                if (Info.getTech21() == 1 && Info.getTech22() == 2) {
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt2);
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd2);
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs2);
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge2);
                    //techimgt2.setImageResource(R.drawable.tech_initial);
                    //techimgd2.setImageResource(R.drawable.tech_initial);
                    //techimgs2.setImageResource(R.drawable.tech_early);
                    //techimge2.setImageResource(R.drawable.tech_early);
                } else if (Info.getTech21() == 2 && Info.getTech22() == 1) {
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt2);
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd2);
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs2);
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge2);
                    //techimgt2.setImageResource(R.drawable.tech_early);
                    //techimgd2.setImageResource(R.drawable.tech_early);
                    //techimgs2.setImageResource(R.drawable.tech_initial);
                    //techimge2.setImageResource(R.drawable.tech_initial);
                } else if (Info.getTech21() == 3 && Info.getTech22() == 3) {
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt2);
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd2);
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs2);
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge2);
                    //techimgt2.setImageResource(R.drawable.tech_mid);
                    //techimgd2.setImageResource(R.drawable.tech_mid);
                    //techimgs2.setImageResource(R.drawable.tech_mid);
                    //techimge2.setImageResource(R.drawable.tech_mid);
                } else if (Info.getTech21() == 4 && Info.getTech22() == 4) {
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt2);
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd2);
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs2);
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge2);
                    //techimgt2.setImageResource(R.drawable.tech_adv);
                    //techimgd2.setImageResource(R.drawable.tech_adv);
                    //techimgs2.setImageResource(R.drawable.tech_adv);
                    //techimge2.setImageResource(R.drawable.tech_adv);
                }

                else if (Info.getTech21() == 5 && Info.getTech22() == 5) {
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt2);
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd2);
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs2);
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge2);
                    //techimgt2.setImageResource(R.drawable.tech_bk_adv);
                    //techimgd2.setImageResource(R.drawable.tech_bk_adv);
                    //techimgs2.setImageResource(R.drawable.tech_bk_adv);
                    //techimge2.setImageResource(R.drawable.tech_bk_adv);
                }

                else if (Info.getTech21() == 6 && Info.getTech22() == 6) {
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt2);
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd2);
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs2);
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge2);
                    //techimgt2.setImageResource(R.drawable.tech_bk_adv);
                    //techimgd2.setImageResource(R.drawable.tech_bk_adv);
                    //techimgs2.setImageResource(R.drawable.tech_bk_adv);
                    //techimge2.setImageResource(R.drawable.tech_bk_adv);
                }

                else if (Info.getTech21() == 7 && Info.getTech22() == 7) {
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt2);
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd2);
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs2);
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge2);
                    //techimgt2.setImageResource(R.drawable.tech_bk_adv);
                    //techimgd2.setImageResource(R.drawable.tech_bk_adv);
                    //techimgs2.setImageResource(R.drawable.tech_bk_adv);
                    //techimge2.setImageResource(R.drawable.tech_bk_adv);
                }
            }


            if (Info.getTechn3() > 0) {
                techimgt3.setVisibility(VISIBLE);
                techimgs3.setVisibility(VISIBLE);
                techimgd3.setVisibility(VISIBLE);
                techimge3.setVisibility(VISIBLE);
                technumt3.setVisibility(VISIBLE);
                technums3.setVisibility(VISIBLE);
                technumd3.setVisibility(VISIBLE);
                technume3.setVisibility(VISIBLE);
                if (Info.getTech31() == 1 && Info.getTech32() == 2) {
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt3);
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd3);
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs3);
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge3);
                    //techimgt3.setImageResource(R.drawable.tech_initial);
                    //techimgd3.setImageResource(R.drawable.tech_initial);
                    //techimgs3.setImageResource(R.drawable.tech_early);
                    // techimge3.setImageResource(R.drawable.tech_early);
                } else if (Info.getTech31() == 2 && Info.getTech32() == 1) {
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt3);
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd3);
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs3);
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge3);
                    //techimgt3.setImageResource(R.drawable.tech_early);
                    //techimgd3.setImageResource(R.drawable.tech_early);
                    //techimgs3.setImageResource(R.drawable.tech_initial);
                    //techimge3.setImageResource(R.drawable.tech_initial);
                } else if (Info.getTech31() == 3 && Info.getTech32() == 3) {
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt3);
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd3);
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs3);
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge3);
                    //techimgt3.setImageResource(R.drawable.tech_mid);
                    //techimgd3.setImageResource(R.drawable.tech_mid);
                    //techimgs3.setImageResource(R.drawable.tech_mid);
                    //techimge3.setImageResource(R.drawable.tech_mid);
                } else if (Info.getTech31() == 4 && Info.getTech32() == 4) {
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt3);
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd3);
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs3);
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge3);
                    //techimgt3.setImageResource(R.drawable.tech_adv);
                    //techimgd3.setImageResource(R.drawable.tech_adv);
                    //techimgs3.setImageResource(R.drawable.tech_adv);
                    //techimge3.setImageResource(R.drawable.tech_adv);
                }

                else if (Info.getTech31() == 5 && Info.getTech32() == 5) {
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt3);
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd3);
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs3);
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge3);
                    //techimgt3.setImageResource(R.drawable.tech_bk_adv);
                    //techimgd3.setImageResource(R.drawable.tech_bk_adv);
                    //techimgs3.setImageResource(R.drawable.tech_bk_adv);
                    //techimge3.setImageResource(R.drawable.tech_bk_adv);
                }

                else if (Info.getTech31() == 6 && Info.getTech32() == 6) {
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt3);
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd3);
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs3);
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge3);
                    //techimgt3.setImageResource(R.drawable.tech_bk_adv);
                    //techimgd3.setImageResource(R.drawable.tech_bk_adv);
                    //techimgs3.setImageResource(R.drawable.tech_bk_adv);
                    //techimge3.setImageResource(R.drawable.tech_bk_adv);
                }

                else if (Info.getTech31() == 7 && Info.getTech32() == 7) {
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt3);
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd3);
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs3);
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge3);
                    //techimgt3.setImageResource(R.drawable.tech_bk_adv);
                    //techimgd3.setImageResource(R.drawable.tech_bk_adv);
                    //techimgs3.setImageResource(R.drawable.tech_bk_adv);
                    //techimge3.setImageResource(R.drawable.tech_bk_adv);
                }
            }


            if (Info.getTechn4() > 0) {
                techimgt4.setVisibility(VISIBLE);
                techimgs4.setVisibility(VISIBLE);
                techimgd4.setVisibility(VISIBLE);
                techimge4.setVisibility(VISIBLE);
                technumt4.setVisibility(VISIBLE);
                technums4.setVisibility(VISIBLE);
                technumd4.setVisibility(VISIBLE);
                technume4.setVisibility(VISIBLE);
                if (Info.getTech41() == 1 && Info.getTech42() == 2) {
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt4);
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd4);
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs4);
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge4);
                    //techimgt4.setImageResource(R.drawable.tech_initial);
                    //techimgd4.setImageResource(R.drawable.tech_initial);
                    //techimgs4.setImageResource(R.drawable.tech_early);
                    //techimge4.setImageResource(R.drawable.tech_early);
                } else if (Info.getTech41() == 2 && Info.getTech42() == 1) {
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt4);
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd4);
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs4);
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge4);
                    //techimgt4.setImageResource(R.drawable.tech_early);
                    //techimgd4.setImageResource(R.drawable.tech_early);
                    //techimgs4.setImageResource(R.drawable.tech_initial);
                    //techimge4.setImageResource(R.drawable.tech_initial);
                } else if (Info.getTech41() == 3 && Info.getTech42() == 3) {
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt4);
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd4);
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs4);
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge4);
                    //techimgt4.setImageResource(R.drawable.tech_mid);
                    //techimgd4.setImageResource(R.drawable.tech_mid);
                    //techimgs4.setImageResource(R.drawable.tech_mid);
                    //techimge4.setImageResource(R.drawable.tech_mid);
                } else if (Info.getTech41() == 4 && Info.getTech42() == 4) {
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt4);
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd4);
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs4);
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge4);
                    //techimgt4.setImageResource(R.drawable.tech_adv);
                    //techimgd4.setImageResource(R.drawable.tech_adv);
                    //techimgs4.setImageResource(R.drawable.tech_adv);
                    //techimge4.setImageResource(R.drawable.tech_adv);
                }

                else if (Info.getTech41() == 5 && Info.getTech42() == 5) {
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt4);
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd4);
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs4);
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge4);
                    //techimgt4.setImageResource(R.drawable.tech_bk_adv);
                    //techimgd4.setImageResource(R.drawable.tech_bk_adv);
                    //techimgs4.setImageResource(R.drawable.tech_bk_adv);
                    //techimge4.setImageResource(R.drawable.tech_bk_adv);
                }

                else if (Info.getTech41() == 6 && Info.getTech42() == 6) {
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt4);
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd4);
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs4);
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge4);
                    //techimgt4.setImageResource(R.drawable.tech_bk_adv);
                    //techimgd4.setImageResource(R.drawable.tech_bk_adv);
                    //techimgs4.setImageResource(R.drawable.tech_bk_adv);
                    //techimge4.setImageResource(R.drawable.tech_bk_adv);
                }

                else if (Info.getTech41() == 7 && Info.getTech42() == 7) {
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt4);
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd4);
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs4);
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge4);
                    //techimgt4.setImageResource(R.drawable.tech_bk_adv);
                    //techimgd4.setImageResource(R.drawable.tech_bk_adv);
                    //techimgs4.setImageResource(R.drawable.tech_bk_adv);
                    //techimge4.setImageResource(R.drawable.tech_bk_adv);
                }
            }


            if (Info.getTechn5() > 0) {
                techimgt5.setVisibility(VISIBLE);
                techimgs5.setVisibility(VISIBLE);
                techimgd5.setVisibility(VISIBLE);
                techimge5.setVisibility(VISIBLE);
                technumt5.setVisibility(VISIBLE);
                technums5.setVisibility(VISIBLE);
                technumd5.setVisibility(VISIBLE);
                technume5.setVisibility(VISIBLE);
                if (Info.getTech51() == 1 && Info.getTech52() == 2) {
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt5);
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd5);
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs5);
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge5);
                    //techimgt5.setImageResource(R.drawable.tech_initial);
                    //techimgd5.setImageResource(R.drawable.tech_initial);
                    //techimgs5.setImageResource(R.drawable.tech_early);
                    //techimge5.setImageResource(R.drawable.tech_early);
                } else if (Info.getTech51() == 2 && Info.getTech52() == 1) {
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt5);
                    Glide.with(conti).load(R.drawable.tech_early)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd5);
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs5);
                    Glide.with(conti).load(R.drawable.tech_initial)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge5);
                    //techimgt5.setImageResource(R.drawable.tech_early);
                    //techimgd5.setImageResource(R.drawable.tech_early);
                    //techimgs5.setImageResource(R.drawable.tech_initial);
                    //techimge5.setImageResource(R.drawable.tech_initial);
                } else if (Info.getTech51() == 3 && Info.getTech52() == 3) {
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt5);
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd5);
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs5);
                    Glide.with(conti).load(R.drawable.tech_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge5);
                    //techimgt5.setImageResource(R.drawable.tech_mid);
                    //techimgd5.setImageResource(R.drawable.tech_mid);
                    //techimgs5.setImageResource(R.drawable.tech_mid);
                    //techimge5.setImageResource(R.drawable.tech_mid);
                } else if (Info.getTech51() == 4 && Info.getTech52() == 4) {
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt5);
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd5);
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs5);
                    Glide.with(conti).load(R.drawable.tech_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge5);
                    //techimgt5.setImageResource(R.drawable.tech_adv);
                    //techimgd5.setImageResource(R.drawable.tech_adv);
                    //techimgs5.setImageResource(R.drawable.tech_adv);
                    //techimge5.setImageResource(R.drawable.tech_adv);
                }

                else if (Info.getTech51() == 5 && Info.getTech52() == 5) {
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt5);
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd5);
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs5);
                    Glide.with(conti).load(R.drawable.tech_bk_com)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge5);
                    //techimgt5.setImageResource(R.drawable.tech_bk_adv);
                    //techimgd5.setImageResource(R.drawable.tech_bk_adv);
                    //techimgs5.setImageResource(R.drawable.tech_bk_adv);
                    //techimge5.setImageResource(R.drawable.tech_bk_adv);
                }

                else if (Info.getTech51() == 6 && Info.getTech52() == 6) {
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt5);
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd5);
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs5);
                    Glide.with(conti).load(R.drawable.tech_bk_mid)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge5);
                    //techimgt5.setImageResource(R.drawable.tech_bk_adv);
                    //techimgd5.setImageResource(R.drawable.tech_bk_adv);
                    //techimgs5.setImageResource(R.drawable.tech_bk_adv);
                    //techimge5.setImageResource(R.drawable.tech_bk_adv);
                }

                else if (Info.getTech51() == 7 && Info.getTech52() == 7) {
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgt5);
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgd5);
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimgs5);
                    Glide.with(conti).load(R.drawable.tech_bk_adv)

                            .apply(options)
                        .thumbnail(0.1f)
                            .into(techimge5);
                    //techimgt5.setImageResource(R.drawable.tech_bk_adv);
                    //techimgd5.setImageResource(R.drawable.tech_bk_adv);
                    //techimgs5.setImageResource(R.drawable.tech_bk_adv);
                    //techimge5.setImageResource(R.drawable.tech_bk_adv);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
