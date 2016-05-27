package com.emergency.doditcoba.Util;

import android.content.Context;
import android.content.SharedPreferences;

import com.emergency.doditcoba.Model.ModelMateri;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CodeLabs on 28/05/2016.
 */
public class SessionManager {

    public static final String PREFS_NAME = "DODIT_APP";
    public static final String FAVORITES = "Product_Favorite";

    public SessionManager() {
        super();
    }

    // This four methods are used for maintaining favorites.
    public void saveFavorites(Context context, ArrayList<ModelMateri> favorites) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);

        editor.commit();
    }

    public void addFavorite(Context context, ModelMateri materi) {
        ArrayList<ModelMateri> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<ModelMateri>();
        favorites.add(materi);
        saveFavorites(context, favorites);
    }

    public void removeFavorite(Context context, ModelMateri product) {
        ArrayList<ModelMateri> favorites = getFavorites(context);
        if (favorites != null) {
            favorites.remove(product);
            saveFavorites(context, favorites);
        }
    }

    public ArrayList<ModelMateri> getFavorites(Context context) {
        SharedPreferences settings;
        List<ModelMateri> favorites;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            ModelMateri[] favoriteItems = gson.fromJson(jsonFavorites,
                    ModelMateri[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<ModelMateri>(favorites);
        } else
            return null;

        return (ArrayList<ModelMateri>) favorites;
    }

}
