package adnyey.notitia.a8;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.codewaves.stickyheadergrid.StickyHeaderGridAdapter;

import java.util.List;

import static android.view.View.GONE;

public class CarSelectorAdapter extends StickyHeaderGridAdapter {
    private List<List<GItem>> labels;
    CarsSelector mContext;
    CarsSelector.OnMyDialogResult resultt;

    CarSelectorAdapter(List<List<GItem>> labels, CarsSelector mContext, CarsSelector.OnMyDialogResult resultt) {
        this.labels = labels;
        this.mContext = mContext;
        this.resultt = resultt;
    }

    @Override
    public int getSectionCount() {
        try {
            return labels.size();
        }catch(NullPointerException e)
        {
            return 0;
        }
    }

    @Override
    public int getSectionItemCount(int section) {
        return labels.get(section).size();
    }

    @Override
    public StickyHeaderGridAdapter.HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_header, parent, false);
        return new MyHeaderViewHolder(view);
    }

    @Override
    public StickyHeaderGridAdapter.ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new MyItemViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(StickyHeaderGridAdapter.HeaderViewHolder viewHolder, int section) {
        final MyHeaderViewHolder holder = (MyHeaderViewHolder)viewHolder;
        switch(section)
        {
            case 0:
                holder.labelView.setText("Class D");
                break;
            case 1:
                holder.labelView.setText("Class C");
                break;
            case 2:
                holder.labelView.setText("Class B");
                break;
            case 3:
                holder.labelView.setText("Class A");
                break;
            case 4:
                holder.labelView.setText("Class S");
                break;
        }


    }

    @Override
    public void onBindItemViewHolder(StickyHeaderGridAdapter.ItemViewHolder viewHolder, final int section, final int position) {
        final MyItemViewHolder holder = (MyItemViewHolder)viewHolder;
        final GItem label = labels.get(section).get(position);

        final int pointer[] = new int[labels.get(section).size()];
        for(int i=0;i<labels.get(section).size();i++)
            pointer[i]=labels.get(section).get(i).getId();

        holder.back.setBackgroundColor(Color.parseColor("#B4000000"));
/*        if (label.getType() == 1)

            holder.back.setBackgroundColor(Color.parseColor("#B4536DFE"));
        else */if (label.getType() == 2)
            holder.back.setBackgroundColor(Color.parseColor("#B4F44336"));

        holder.imgItem.setVisibility(GONE);
        holder.txtItem.setText(label.getTitle());


        if (label.getWin() == 0)
            holder.imgTic.setVisibility(GONE);
        else {
            holder.imgTic.setVisibility(View.VISIBLE);
            if (label.getWin() == 1)
                holder.imgTic.setImageResource(R.drawable.tic_rnd);
            else if (label.getWin() == 2)
                holder.imgTic.setImageResource(R.drawable.tic_edd);
            else if (label.getWin() == 3)
                holder.imgTic.setImageResource(R.drawable.tic_champ);
            else if (label.getWin() == 4)
                holder.imgTic.setImageResource(R.drawable.tic_vip);
            else if (label.getWin() == 5)
                holder.imgTic.setImageResource(R.drawable.tic_mast);
            else if (label.getWin() == 6)
                holder.imgTic.setImageResource(R.drawable.tic_mp);
            else if (label.getWin() == 7)
                holder.imgTic.setImageResource(R.drawable.tic_por);
            else if (label.getWin() == 8)
                holder.imgTic.setImageResource(R.drawable.tic_fob);
            else if (label.getWin() == 9)
                holder.imgTic.setImageResource(R.drawable.tic_fest);
        }

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultt.finish(label.getId());
                mContext.dismiss();
            }
        });
    }

    public static class MyHeaderViewHolder extends StickyHeaderGridAdapter.HeaderViewHolder {
        TextView labelView;


        MyHeaderViewHolder(View itemView) {
            super(itemView);
            labelView = (TextView) itemView.findViewById(R.id.label);

        }
    }

    public static class MyItemViewHolder extends StickyHeaderGridAdapter.ItemViewHolder {
        ImageView imgItem, imgTic;
        TextView txtItem;
        LinearLayout back;
        RelativeLayout card;
        MyItemViewHolder(View itemView) {
            super(itemView);
            imgItem = (ImageView) itemView.findViewById(R.id.imgItem);
            imgTic = (ImageView) itemView.findViewById(R.id.imgTic);
            txtItem = (TextView) itemView.findViewById(R.id.txtItem);
            back = (LinearLayout) itemView.findViewById(R.id.itemBack);
            card = (RelativeLayout) itemView.findViewById(R.id.grid_card);
        }
    }
}
