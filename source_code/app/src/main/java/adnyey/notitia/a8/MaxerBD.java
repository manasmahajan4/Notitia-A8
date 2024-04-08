package adnyey.notitia.a8;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.text.NumberFormat;

import static android.view.View.GONE;

/**
 * Created by Mahajan-PC on 04-02-2017.
 */

public class MaxerBD {
    TextView accel1, top1, han1, nitro1;
    TextView accel2, top2, han2, nitro2;
    TextView accel3, top3, han3, nitro3;
    TextView accel4, top4, han4, nitro4;
    TextView accel5, top5, han5, nitro5;
    TextView accel6, top6, han6, nitro6;
    TextView accel7, top7, han7, nitro7;
    TextView accel8, top8, han8, nitro8;
    TextView accel9, top9, han9, nitro9;
    TextView accel10, top10, han10, nitro10;

    MaxerBD(Context conti, BasicInfo basic, ProNBObj Info) {
        final Dialog dialog = new Dialog(conti);
        dialog.setContentView(R.layout.table_max_bike);

        accel1 = (TextView) dialog.findViewById(R.id.L1_1);
        top1 = (TextView) dialog.findViewById(R.id.L1_2);
        han1 = (TextView) dialog.findViewById(R.id.L1_3);
        nitro1 = (TextView) dialog.findViewById(R.id.L1_4);
        accel2 = (TextView) dialog.findViewById(R.id.L2_1);
        top2 = (TextView) dialog.findViewById(R.id.L2_2);
        han2 = (TextView) dialog.findViewById(R.id.L2_3);
        nitro2 = (TextView) dialog.findViewById(R.id.L2_4);
        accel3 = (TextView) dialog.findViewById(R.id.L3_1);
        top3 = (TextView) dialog.findViewById(R.id.L3_2);
        han3 = (TextView) dialog.findViewById(R.id.L3_3);
        nitro3 = (TextView) dialog.findViewById(R.id.L3_4);
        accel4 = (TextView) dialog.findViewById(R.id.L4_1);
        top4 = (TextView) dialog.findViewById(R.id.L4_2);
        han4 = (TextView) dialog.findViewById(R.id.L4_3);
        nitro4 = (TextView) dialog.findViewById(R.id.L4_4);
        accel5 = (TextView) dialog.findViewById(R.id.L5_1);
        top5 = (TextView) dialog.findViewById(R.id.L5_2);
        han5 = (TextView) dialog.findViewById(R.id.L5_3);
        nitro5 = (TextView) dialog.findViewById(R.id.L5_4);
        accel6 = (TextView) dialog.findViewById(R.id.L6_1);
        top6 = (TextView) dialog.findViewById(R.id.L6_2);
        han6 = (TextView) dialog.findViewById(R.id.L6_3);
        nitro6 = (TextView) dialog.findViewById(R.id.L6_4);
        accel7 = (TextView) dialog.findViewById(R.id.L7_1);
        top7 = (TextView) dialog.findViewById(R.id.L7_2);
        han7 = (TextView) dialog.findViewById(R.id.L7_3);
        nitro7 = (TextView) dialog.findViewById(R.id.L7_4);
        accel8 = (TextView) dialog.findViewById(R.id.L8_1);
        top8 = (TextView) dialog.findViewById(R.id.L8_2);
        han8 = (TextView) dialog.findViewById(R.id.L8_3);
        nitro8 = (TextView) dialog.findViewById(R.id.L8_4);
        accel9 = (TextView) dialog.findViewById(R.id.L9_1);
        top9 = (TextView) dialog.findViewById(R.id.L9_2);
        han9 = (TextView) dialog.findViewById(R.id.L9_3);
        nitro9 = (TextView) dialog.findViewById(R.id.L9_4);
        accel10 = (TextView) dialog.findViewById(R.id.L10_1);
        top10 = (TextView) dialog.findViewById(R.id.L10_2);
        han10 = (TextView) dialog.findViewById(R.id.L10_3);
        nitro10 = (TextView) dialog.findViewById(R.id.L10_4);
        try {

            accel1.setText(NumberFormat.getIntegerInstance().format(Info.getAccel1()));
            top1.setText(NumberFormat.getIntegerInstance().format(Info.getTop1()));
            han1.setText(NumberFormat.getIntegerInstance().format(Info.getHan1()));
            nitro1.setText(NumberFormat.getIntegerInstance().format(Info.getNos1()));
            accel2.setText(NumberFormat.getIntegerInstance().format(Info.getAccel2()));
            top2.setText(NumberFormat.getIntegerInstance().format(Info.getTop2()));
            han2.setText(NumberFormat.getIntegerInstance().format(Info.getHan2()));
            nitro2.setText(NumberFormat.getIntegerInstance().format(Info.getNos2()));
            accel3.setText( NumberFormat.getIntegerInstance().format(Info.getAccel3()));
            top3.setText(NumberFormat.getIntegerInstance().format(Info.getTop3()));
            han3.setText(NumberFormat.getIntegerInstance().format(Info.getHan3()));
            nitro3.setText(NumberFormat.getIntegerInstance().format(Info.getNos3()));
            accel4.setText(NumberFormat.getIntegerInstance().format(Info.getAccel4()));
            top4.setText(NumberFormat.getIntegerInstance().format(Info.getTop4()));
            han4.setText(NumberFormat.getIntegerInstance().format(Info.getHan4()));
            nitro4.setText(NumberFormat.getIntegerInstance().format(Info.getNos4()));
            accel5.setText(NumberFormat.getIntegerInstance().format(Info.getAccel5()));
            top5.setText(NumberFormat.getIntegerInstance().format(Info.getTop5()));
            han5.setText(NumberFormat.getIntegerInstance().format(Info.getHan5()));
            nitro5.setText(NumberFormat.getIntegerInstance().format(Info.getNos5()));
            accel6.setText(NumberFormat.getIntegerInstance().format(Info.getAccel6()));
            top6.setText(NumberFormat.getIntegerInstance().format(Info.getTop6()));
            han6.setText(NumberFormat.getIntegerInstance().format(Info.getHan6()));
            nitro6.setText(NumberFormat.getIntegerInstance().format(Info.getNos6()));
            accel7.setText(NumberFormat.getIntegerInstance().format(Info.getAccel7()));
            top7.setText(NumberFormat.getIntegerInstance().format(Info.getTop7()));
            han7.setText(NumberFormat.getIntegerInstance().format(Info.getHan7()));
            nitro7.setText(NumberFormat.getIntegerInstance().format(Info.getNos7()));
            accel8.setText(NumberFormat.getIntegerInstance().format(Info.getAccel8()));
            top8.setText(NumberFormat.getIntegerInstance().format(Info.getTop8()));
            han8.setText(NumberFormat.getIntegerInstance().format(Info.getHan8()));
            nitro8.setText(NumberFormat.getIntegerInstance().format(Info.getNos8()));
            accel9.setText(NumberFormat.getIntegerInstance().format(Info.getAccel9()));
            top9.setText(NumberFormat.getIntegerInstance().format(Info.getTop9()));
            han9.setText(NumberFormat.getIntegerInstance().format(Info.getHan9()));
            nitro9.setText(NumberFormat.getIntegerInstance().format(Info.getNos9()));
            accel10.setText(NumberFormat.getIntegerInstance().format(Info.getAccel10()));
            top10.setText(NumberFormat.getIntegerInstance().format(Info.getTop10()));
            han10.setText(NumberFormat.getIntegerInstance().format(Info.getHan10()));
            nitro10.setText(NumberFormat.getIntegerInstance().format(Info.getNos10()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // Read your drawable from somewhere
        Drawable myDrawable = conti.getResources().getDrawable(R.drawable.a8t);
        Bitmap bitmap = ((BitmapDrawable) myDrawable).getBitmap();
// Scale it to 50 x 50
        Drawable d = new BitmapDrawable(conti.getResources(), Bitmap.createScaledBitmap(bitmap, 40, 40, true));

        if (basic.getId() == 145 || basic.getId() == 146)
        {
            top3.setTextColor(Color.parseColor("#7FFFD4"));
            nitro3.setTextColor(Color.parseColor("#7FFFD4"));
            top3.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);
            nitro3.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);
            accel4.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);
            han4.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);

            accel4.setTextColor(Color.parseColor("#7FFFD4"));
            han4.setTextColor(Color.parseColor("#7FFFD4"));

            accel5.setTextColor(Color.parseColor("#7FFFD4"));
            top5.setTextColor(Color.parseColor("#7FFFD4"));
            han5.setTextColor(Color.parseColor("#7FFFD4"));
            nitro5.setTextColor(Color.parseColor("#7FFFD4"));

            accel5.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);
            top5.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);
            han5.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);
            nitro5.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);
        }



        dialog.setTitle("MAX");
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        lp.copyFrom(window.getAttributes());

        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        window.setAttributes(lp);
        dialog.show();
    }


}
