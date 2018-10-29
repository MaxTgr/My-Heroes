package br.com.doghero.dhproject.fragments.hero;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroViewHolder> {

    private Hero[] mHeroes;
    private Context ctx;

    HeroAdapter(Hero[] heroes) {
        mHeroes = heroes;
    }

    public static class HeroViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView price;
        private TextView neighborhood;
        private ImageView photo;
        private ImageView superhero;
        private ImageButton btnFavorite;

        private HeroViewHolder(View view) {
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
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hero_list_item, parent, false);

        ctx = card.getContext();

        return new HeroViewHolder(card);
    }

    @Override
    public void onBindViewHolder(final HeroViewHolder holder, int position) {
        Hero hero = mHeroes[position];

        // Setting text
        holder.name.setText(hero.user.first_name);
        holder.neighborhood.setText(hero.address_neighborhood);
        String heroPrice = Integer.toString(hero.price);
        holder.price.setText(heroPrice);

        // Image loading
        ImageHelper.loadImage(ctx, hero.user.image_url, R.drawable.icon_hero, holder.photo);
        // show or hide superhero icon
        int superheroCheck = hero.is_superhero ? View.VISIBLE : View.GONE;
        holder.superhero.setVisibility(superheroCheck);

        // OnClickHandlers
        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int drawable;
                String tag = (String) holder.btnFavorite.getTag();

                if (tag.equals("true")) {
                    drawable = R.drawable.icon_like_border_vector_gray_battleship;
                    tag = "false";
                } else {
                    drawable = R.drawable.icon_like_filled_vector_red;
                    tag = "true";
                }
                holder.btnFavorite.setImageResource(drawable);
                holder.btnFavorite.setTag(tag);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHeroes.length;
    }
}
