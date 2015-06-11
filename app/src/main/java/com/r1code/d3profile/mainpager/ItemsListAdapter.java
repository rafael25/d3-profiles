package com.r1code.d3profile.mainpager;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.r1code.d3profile.R;
import com.r1code.d3profile.json.d3hero.BaseItem;
import com.r1code.d3profile.json.d3hero.Items;
import com.squareup.picasso.Picasso;

/**
 * Created by rafael on 11/06/15.
 */
public class ItemsListAdapter extends RecyclerView.Adapter<ItemsListAdapter.ViewHolder> {

    private static final int HERO_ITEM = 0;
    private static final int SPACE = 1;

    private Items items;

    public ItemsListAdapter(Items items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == SPACE) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_space, parent, false);
            return new ViewHolder(v);
        }

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder vh, int position) {
        if (! isLastPosition(position)) {
            BaseItem item = items.getItem(position);

            vh.itemName.setText(item.getName());
            vh.itemType.setText(item.getDisplayColor());
            ImageView image = vh.itemIcon;

            Picasso.with(image.getContext())
                    .load("http://media.blizzard.com/d3/icons/items/large/" + item.getIcon() + ".png")
                    .into(image);
            image.setAdjustViewBounds(true);
        }
    }

    @Override
    public int getItemCount() {
        return items.size() + 1 /* Ads a space at the bottom */;
    }

    @Override
    public int getItemViewType(int position) {
        if (isLastPosition(position)) {
            return SPACE;
        }

        return HERO_ITEM;
    }

    private boolean isLastPosition(int position) {
        return position + 1 == getItemCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView itemIcon;
        public TextView itemName;
        public TextView itemType;

        public ViewHolder(View v) {
            super(v);

            itemIcon = (ImageView) v.findViewById(R.id.item_icon);
            itemName = (TextView) v.findViewById(R.id.item_name);
            itemType = (TextView) v.findViewById(R.id.item_type);
        }
    }
}
