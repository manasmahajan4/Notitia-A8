package adnyey.notitia.a8;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.view.View.GONE;

/**
 * Created by Mahajan-PC on 11-02-2017.
 */

public class GridVIewAdapterEng extends ArrayAdapter<EngObj> {
    Context mContext;
    int resourceId;
    ArrayList<EngObj> data = new ArrayList<EngObj>();

    public GridVIewAdapterEng(Context context, int layoutResourceId, ArrayList<EngObj> data) {
        super(context, layoutResourceId, data);
        this.mContext = context;
        this.resourceId = layoutResourceId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        GridVIewAdapterEng.ViewHolder holder = null;

        if (itemView == null) {
            final LayoutInflater layoutInflater =
                    (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = layoutInflater.inflate(resourceId, parent, false);

            holder = new GridVIewAdapterEng.ViewHolder();
            holder.txtItem = (TextView) itemView.findViewById(R.id.txtItem);
            holder.txteng = (TextView) itemView.findViewById(R.id.eng_tic);
            itemView.setTag(holder);
        } else {
            holder = (GridVIewAdapterEng.ViewHolder) itemView.getTag();
        }

        EngObj item = getItem(position);
        holder.txteng.setTypeface(null, Typeface.BOLD);
        try {
            holder.txtItem.setText(item.getName());
            holder.txteng.setText(""+item.getEngn());
        } catch (Exception e) {
            e.printStackTrace();
        }


        return itemView;
    }

    static class ViewHolder {
        TextView txtItem, txteng;
    }
}

