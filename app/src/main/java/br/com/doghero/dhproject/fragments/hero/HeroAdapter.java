package br.com.doghero.dhproject.fragments.hero;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.doghero.dhproject.R;
import br.com.doghero.dhproject.images.ImageHelper;
import br.com.doghero.dhproject.model.Hero;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    private List<Hero> mHeroes;
    private Context ctx;

    //TODO: add correct dataset
    public HeroAdapter(List<Hero> heroes) {
        mHeroes = heroes;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name, price, neighborhood;
        public ImageView photo, superhero;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.hero_name);
            price = view.findViewById(R.id.hero_price);
            neighborhood = view.findViewById(R.id.hero_neighborhood);
            photo = view.findViewById(R.id.hero_photo);
            superhero = view.findViewById(R.id.hero_is_superhero);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hero_list_item, parent, false);

        ctx = card.getContext();

        return new ViewHolder(card);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hero hero = mHeroes.get(position);

        holder.name.setText(hero.getFirstName());
        holder.neighborhood.setText(hero.getAddressNeighborhood());
        String heroPrice = Integer.toString(hero.getPrice());
        holder.price.setText(heroPrice);

        // TODO: ask - favorite button should not appear on recent?

        // TODO: change placeholder img
        ImageHelper.loadImage(ctx, hero.getImageUrl(), R.mipmap.ic_launcher, holder.photo);
        // TODO: implement superhero icon
    }

    @Override
    public int getItemCount() {
        return mHeroes.size();
    }
}
