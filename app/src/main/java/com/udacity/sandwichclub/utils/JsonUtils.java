package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject jObj = new JSONObject(json);
        JSONObject subObj = jObj.getJSONObject("name");
        String mainName = subObj.getString("mainName");
        JSONArray jArr = subObj.getJSONArray("alsoKnownAs");
        List<String> alsoKnownAs = new ArrayList<String>();
        for(int i=0; i<jArr.length();i++){
            alsoKnownAs.add(jArr.getString(i));
        }
        String placeOfOrigin = jObj.getString("placeOfOrigin");
        String description = jObj.getString("description");
        String image = jObj.getString("image");
        JSONArray jArr2 = jObj.getJSONArray("ingredients");
        List<String> ingredients = new ArrayList<String>();
        for(int i=0; i<jArr2.length();i++){
            ingredients.add(jArr2.getString(i));
        }

        Sandwich sandwich = new Sandwich(mainName,alsoKnownAs,placeOfOrigin,description,image,ingredients);

        return sandwich;
    }

}
