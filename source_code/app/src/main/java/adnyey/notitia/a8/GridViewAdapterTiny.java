package adnyey.notitia.a8;

import android.content.Context;
import android.graphics.Color;
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
 * Created by Mahajan-PC on 10-02-2017.
 */

public class GridViewAdapterTiny extends ArrayAdapter<GItem> {
    Context mContext;
    int resourceId;
    ArrayList<GItem> data = new ArrayList<GItem>();

    public GridViewAdapterTiny(Context context, int layoutResourceId, ArrayList<GItem> data) {
        super(context, layoutResourceId, data);
        this.mContext = context;
        this.resourceId = layoutResourceId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        GridViewAdapterTiny.ViewHolder holder = null;

        if (itemView == null) {
            final LayoutInflater layoutInflater =
                    (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = layoutInflater.inflate(resourceId, parent, false);

            holder = new GridViewAdapterTiny.ViewHolder();
            holder.imgItem = (ImageView) itemView.findViewById(R.id.imgItem);
            holder.imgTic = (ImageView) itemView.findViewById(R.id.imgTic);
            holder.txtItem = (TextView) itemView.findViewById(R.id.txtItem);
            holder.back = (LinearLayout) itemView.findViewById(R.id.itemBack);
            itemView.setTag(holder);
        } else {
            holder = (GridViewAdapterTiny.ViewHolder) itemView.getTag();
        }

        GItem item = getItem(position);
        holder.back.setBackgroundColor(Color.parseColor("#B4000000"));
/*        if (item.getType() == 1)
            holder.back.setBackgroundColor(Color.parseColor("#B4536DFE"));
        else */if (item.getType() == 2)
            holder.back.setBackgroundColor(Color.parseColor("#B4F44336"));

        holder.imgItem.setVisibility(GONE);
        holder.txtItem.setText(item.getTitle());


        if (item.getWin() == 0)
            holder.imgTic.setVisibility(GONE);
        else {
            holder.imgTic.setVisibility(View.VISIBLE);
            if (item.getWin() == 1)
                holder.imgTic.setImageResource(R.drawable.tic_rnd);
            else if (item.getWin() == 2)
                holder.imgTic.setImageResource(R.drawable.tic_edd);
            else if (item.getWin() == 3)
                holder.imgTic.setImageResource(R.drawable.tic_champ);
            else if (item.getWin() == 4)
                holder.imgTic.setImageResource(R.drawable.tic_vip);
            else if (item.getWin() == 5)
                holder.imgTic.setImageResource(R.drawable.tic_mast);
            else if (item.getWin() == 6)
                holder.imgTic.setImageResource(R.drawable.tic_mp);
            else if (item.getWin() == 7)
                holder.imgTic.setImageResource(R.drawable.tic_por);
            else if (item.getWin() == 8)
                holder.imgTic.setImageResource(R.drawable.tic_fob);
            else if (item.getWin() == 9)
                holder.imgTic.setImageResource(R.drawable.tic_fest);
        }

        return itemView;
    }

    static class ViewHolder {
        ImageView imgItem, imgTic;
        TextView txtItem;
        LinearLayout back;
    }
}

