package br.com.doghero.dhproject.fragments.hero;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.doghero.dhproject.R;
import br.com.doghero.dhproject.images.ImageHelper;
import br.com.doghero.dhproject.model.Hero;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    private List<Hero> mHeroes;
    private Context ctx;

    public HeroAdapter(List<Hero> heroes) {
        mHeroes = heroes;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name, price, neighborhood;
        public ImageView photo, superhero;
        public ImageButton btnFavorite;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.hero_name);
            price = view.findViewById(R.id.hero_price);
            neighborhood = view.findViewById(R.id.hero_neighborhood);
            photo = view.findViewById(R.id.hero_photo);
            superhero = view.findViewById(R.id.hero_is_superhero);

            btnFavorite = view.findViewById(R.id.favorite_button);
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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Hero hero = mHeroes.get(position);

        // Setting text
        holder.name.setText(hero.getFirstName());
        holder.neighborhood.setText(hero.getAddressNeighborhood());
        String heroPrice = Integer.toString(hero.getPrice());
        holder.price.setText(heroPrice);

        // TODO: ask - favorite button should not appear on recent?
        // TODO: change placeholder img
        // Image loading
        ImageHelper.loadImage(ctx, hero.getImageUrl(), R.mipmap.ic_launcher, holder.photo);
        // show or hide superhero icon
        int superheroCheck = hero.getIsSuperHero()? View.VISIBLE : View.GONE;
        holder.superhero.setVisibility(superheroCheck);

        // OnClickHandlers
        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int drawable;
                String tag = (String) holder.btnFavorite.getTag();

                // TODO: finish tag toggle
                if(tag.equals("true")){
                    drawable = R.drawable.icon_like_border_vector_gray_battleship;
                    tag = "false";
                }else{
                    drawable = R.drawable.icon_like_filled_vector_red;
                    tag = "true";
                }
                Log.e("holder", holder.btnFavorite.getTag().toString());
                holder.btnFavorite.setImageResource(drawable);
                holder.btnFavorite.setTag(tag);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHeroes.size();
    }
}
