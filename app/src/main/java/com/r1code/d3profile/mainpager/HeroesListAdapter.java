package com.r1code.d3profile.mainpager;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.r1code.d3profile.R;
import com.r1code.d3profile.json.d3profile.SimpleHero;

import java.util.List;

/**
 * Created by rafael on 5/06/15.
 */
public class HeroesListAdapter extends RecyclerView.Adapter<HeroesListAdapter.ViewHolder> {

    private static final int HERO_ITEM = 0;
    private static final int SPACE = 1;

    Fragment fragment;
    List<SimpleHero> heroes;

    public HeroesListAdapter(List<SimpleHero> heroes, Fragment fragment) {
        this.heroes = heroes;
        this.fragment = fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == SPACE) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_space, parent, false);
            return new ViewHolder(v);
        }

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.heroes_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position < getItemCount() - 1) {
            SimpleHero hero = heroes.get(position);
            String heroName = hero.getName();
            String heroClass = hero.getClass_();

            String imageName = "@mipmap/hero_portrait_" + heroClass.replace('-', '_') + "_" + hero.getGender();
            int portrait = fragment.getResources().getIdentifier(imageName, "mipmap", fragment.getActivity().getPackageName());

            holder.heroId = hero.getId();
            holder.imageView.setImageResource(portrait);
            holder.level.setText("Level: "+hero.getLevel());
            holder.paragonLevel.setText("Paragon Level: "+hero.getParagonLevel());
            holder.textView.setText(heroName);
        }
    }

    @Override
    public int getItemCount() {
        return heroes.size() + 1 /* Adds a space at the bottom */;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return SPACE;
        }

        return HERO_ITEM;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView level;
        public TextView paragonLevel;
        public ImageView imageView;
        public long heroId;

        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.hero_name);
            level = (TextView) v.findViewById(R.id.level);
            paragonLevel = (TextView) v.findViewById(R.id.paragon_level);
            imageView = (ImageView) v.findViewById(R.id.hero_portrait);
        }
    }

    public static class SpaceHolder extends RecyclerView.ViewHolder {
        public SpaceHolder(View v) {
            super(v);
        }
    }
}
