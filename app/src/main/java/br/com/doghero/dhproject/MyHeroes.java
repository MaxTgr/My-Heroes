package br.com.doghero.dhproject;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.doghero.dhproject.model.Hero;

public class MyHeroes {

    public static HashMap<String, List<Hero>> build(String json) {
        List<Hero> recentHeroes = new ArrayList<>();
        List<Hero> favoriteHeroes = new ArrayList<>();
        HashMap<String, List<Hero>> returning = new HashMap<>();

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray recents = jsonObject.getJSONArray("recents");
            JSONArray favorites = jsonObject.getJSONArray("favorites");
            for (int i = 0; i < recents.length(); i++) {
                recentHeroes.add(heroCreator(recents, i));
            }
            for (int i = 0; i < favorites.length(); i++) {
                favoriteHeroes.add(heroCreator(favorites, i));
            }

            returning.put("recents", recentHeroes);
            returning.put("favorites", favoriteHeroes);
        } catch (JSONException e) {
            Log.e("Json", e.toString());
        }

        return returning;

    }

    private static Hero heroCreator(JSONArray array, int index) {
        try {
            JSONObject heroServices = array.getJSONObject(index);
            JSONObject heroUser = heroServices.getJSONObject("user");

            Boolean isSuperHero = heroServices.getBoolean("is_superhero");
            String address = heroServices.getString("address_neighborhood");
            int price = heroServices.getInt("price");

            String name = heroUser.getString("first_name");
            String photo = heroUser.getString("image_url");

            return new Hero(isSuperHero, name, photo, address, price);
        } catch (JSONException e) {
            Log.e("Json", e.toString());
        }

        return null;
    }

}
