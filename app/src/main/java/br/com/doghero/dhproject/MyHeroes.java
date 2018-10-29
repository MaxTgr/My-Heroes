package br.com.doghero.dhproject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

import br.com.doghero.dhproject.model.Hero;

public class MyHeroes {

    private MyHeroes() {
    }

    public static Map<String, Hero[]> build(String json) {
        Map<String, Hero[]> full = new HashMap<>();
        JsonElement rootElement = new JsonParser().parse(json);
        JsonObject rootObject = rootElement.getAsJsonObject();

        JsonArray recents = rootObject.get("recents").getAsJsonArray();
        JsonArray favorites = rootObject.get("favorites").getAsJsonArray();
        Hero[] recHeroes = new Gson().fromJson(recents, Hero[].class);
        Hero[] favHeroes = new Gson().fromJson(favorites, Hero[].class);

        full.put("recents", recHeroes);
        full.put("favorites", favHeroes);
        return full;
    }
}
