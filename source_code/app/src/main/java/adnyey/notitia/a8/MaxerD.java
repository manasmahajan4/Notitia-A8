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

import adnyey.notitia.a8.utils.Utils;

import static android.view.View.GONE;

/**
 * Created by Mahajan-PC on 04-02-2017.
 */

public class MaxerD {
    TextView accel1, top1, han1, nitro1;
    TextView accel2, top2, han2, nitro2;
    TextView accel3, top3, han3, nitro3;
    TextView accel4, top4, han4, nitro4;
    TextView accel5, top5, han5, nitro5;

    MaxerD(Context conti, BasicInfo basic, ProNObj Info) {
        final Dialog dialog = new Dialog(conti);
        dialog.setContentView(R.layout.table_max_up);

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


        // Read your drawable from somewhere
        Drawable myDrawable = conti.getResources().getDrawable(R.drawable.a8t);
        Bitmap bitmap = ((BitmapDrawable) myDrawable).getBitmap();
        // Scale it to 50 x 50
        Drawable tkImg = new BitmapDrawable(conti.getResources(), Bitmap.createScaledBitmap(bitmap, 40, 40, true));

        try {

            accel1.setText(NumberFormat.getIntegerInstance().format(Info.getAccel1()));
            setIsToken(accel1, tkImg, Info.getMaxUpgrades().isToken(0, 0));
            top1.setText(NumberFormat.getIntegerInstance().format(Info.getTop1()));
            setIsToken(top1, tkImg, Info.getMaxUpgrades().isToken(0, 1));
            han1.setText(NumberFormat.getIntegerInstance().format(Info.getHan1()));
            setIsToken(han1, tkImg, Info.getMaxUpgrades().isToken(0, 2));
            nitro1.setText(NumberFormat.getIntegerInstance().format(Info.getNos1()));
            setIsToken(nitro1, tkImg, Info.getMaxUpgrades().isToken(0, 3));
            accel2.setText(NumberFormat.getIntegerInstance().format(Info.getAccel2()));
            setIsToken(accel2, tkImg, Info.getMaxUpgrades().isToken(1, 0));
            top2.setText(NumberFormat.getIntegerInstance().format(Info.getTop2()));
            setIsToken(top2, tkImg, Info.getMaxUpgrades().isToken(1, 1));
            han2.setText(NumberFormat.getIntegerInstance().format(Info.getHan2()));
            setIsToken(han2, tkImg, Info.getMaxUpgrades().isToken(1, 2));
            nitro2.setText(NumberFormat.getIntegerInstance().format(Info.getNos2()));
            setIsToken(nitro2, tkImg, Info.getMaxUpgrades().isToken(1, 3));
            accel3.setText(NumberFormat.getIntegerInstance().format(Info.getAccel3()));
            setIsToken(accel3, tkImg, Info.getMaxUpgrades().isToken(2, 0));
            top3.setText(NumberFormat.getIntegerInstance().format(Info.getTop3()));
            setIsToken(top3, tkImg, Info.getMaxUpgrades().isToken(2, 1));
            han3.setText(NumberFormat.getIntegerInstance().format(Info.getHan3()));
            setIsToken(han3, tkImg, Info.getMaxUpgrades().isToken(2, 2));
            nitro3.setText(NumberFormat.getIntegerInstance().format(Info.getNos3()));
            setIsToken(nitro3, tkImg, Info.getMaxUpgrades().isToken(2, 3));
            accel4.setText(NumberFormat.getIntegerInstance().format(Info.getAccel4()));
            setIsToken(accel4, tkImg, Info.getMaxUpgrades().isToken(3, 0));
            top4.setText(NumberFormat.getIntegerInstance().format(Info.getTop4()));
            setIsToken(top4, tkImg, Info.getMaxUpgrades().isToken(3, 1));
            han4.setText(NumberFormat.getIntegerInstance().format(Info.getHan4()));
            setIsToken(han4, tkImg, Info.getMaxUpgrades().isToken(3, 2));
            nitro4.setText(NumberFormat.getIntegerInstance().format(Info.getNos4()));
            setIsToken(nitro4, tkImg, Info.getMaxUpgrades().isToken(3, 3));
            accel5.setText(NumberFormat.getIntegerInstance().format(Info.getAccel5()));
            setIsToken(accel5, tkImg, Info.getMaxUpgrades().isToken(4, 0));
            top5.setText(NumberFormat.getIntegerInstance().format(Info.getTop5()));
            setIsToken(top5, tkImg, Info.getMaxUpgrades().isToken(4, 1));
            han5.setText(NumberFormat.getIntegerInstance().format(Info.getHan5()));
            setIsToken(han5, tkImg, Info.getMaxUpgrades().isToken(4, 2));
            nitro5.setText(NumberFormat.getIntegerInstance().format(Info.getNos5()));
            setIsToken(nitro5, tkImg, Info.getMaxUpgrades().isToken(4, 3));
        } catch (NullPointerException e) {
            e.printStackTrace();
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

    void setIsToken(TextView text, Drawable tkImg, boolean isToken) {
        if (isToken) {
            text.setTextColor(Color.parseColor("#7FFFD4"));
            text.setCompoundDrawablesWithIntrinsicBounds(tkImg, null, null, null);
        }
    }


}
