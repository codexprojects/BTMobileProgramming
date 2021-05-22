package com.ilkeyucel.btmobilapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPrefHelper {
    public static final String PREF_USER_BASED = "user";
    public static final String KEY_LAST_PERSONS_ITEM_SET = "personItemSet";

    public static void putPersonsList(List<PersonInfo> personList) {
        Gson gson = new Gson();
        SharedPreferences preferences = MainActivity.activity.getSharedPreferences(PREF_USER_BASED, Context.MODE_PRIVATE);
        List<PersonInfo> listWillBePut = new ArrayList<>();
        if (personList != null) {
            for (PersonInfo personInfo : personList) {
                listWillBePut.add(personInfo);
            }
            if (listWillBePut.size() > 100) {
                listWillBePut = listWillBePut.subList(listWillBePut.size() - 100, listWillBePut.size());
            }
        }
        preferences.edit().putString(KEY_LAST_PERSONS_ITEM_SET, gson.toJson(listWillBePut)).apply();
    }

    public static List<PersonInfo> getPersonsList() {
        try {
            Gson gson = new Gson();
            SharedPreferences preferences = MainActivity.activity.getSharedPreferences(PREF_USER_BASED, Context.MODE_PRIVATE);
            Type typeOfT = TypeToken.getParameterized(List.class, PersonInfo.class).getType();
            String json = preferences.getString(KEY_LAST_PERSONS_ITEM_SET, null);
            if (json != null)
                return gson.fromJson(json, typeOfT);
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }
}
