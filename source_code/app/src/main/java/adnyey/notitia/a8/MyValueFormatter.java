package adnyey.notitia.a8;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;

/**
 * Created by Mahajan-PC on 15-01-2017.
 */

public class MyValueFormatter implements IValueFormatter {

    protected DecimalFormat Format_handling, Format_accel, Format_speed, Format_rank;

    public MyValueFormatter() {
        Format_accel = new DecimalFormat("#0.00");
        Format_speed = new DecimalFormat("#0.0");
        Format_rank = new DecimalFormat("#0");
        Format_handling = new DecimalFormat("#0.000");
    }

    // IValueFormatter
    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        if(entry.getX()==0) {
                return Format_accel.format((12000-value)/1000);
        }
        if(entry.getX()==1) {
            return Format_speed.format(value/30);
        }
        if(entry.getX()==2) {
            return Format_handling.format(value/3000);
        }
        if(entry.getX()==3) {
            return Format_speed.format(value/120);
        }
        if(entry.getX()==4) {
            return Format_speed.format(value/30);
        }
        if(entry.getX()==5) {
            return Format_rank.format(value/5);
        }
        else
            return Format_speed.format(value);
    }


    public int getDecimalDigits() {
        return 1;
    }
}