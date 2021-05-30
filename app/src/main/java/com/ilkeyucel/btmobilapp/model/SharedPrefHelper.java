package com.ilkeyucel.btmobilapp.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ilkeyucel.btmobilapp.MainActivity;
import com.ilkeyucel.btmobilapp.model.PersonInfo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPrefHelper {
    public static final String PREF_USER_BASED = "user";
    public static final String KEY_PERSONS_ITEM_SET = "personItemSet";
    public static final String KEY_QUESTION_ITEM_SET = "questionItemSet";
    public static final String KEY_SETTINGS_ITEM_SET = "settingsItemSet";

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
        preferences.edit().putString(KEY_PERSONS_ITEM_SET, gson.toJson(listWillBePut)).apply();
    }

    public static List<PersonInfo> getPersonsList() {
        try {
            Gson gson = new Gson();
            SharedPreferences preferences = MainActivity.activity.getSharedPreferences(PREF_USER_BASED, Context.MODE_PRIVATE);
            Type typeOfT = TypeToken.getParameterized(List.class, PersonInfo.class).getType();
            String json = preferences.getString(KEY_PERSONS_ITEM_SET, null);
            if (json != null)
                return gson.fromJson(json, typeOfT);
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static void putQuestionList(List<Question> questionList) {
        Gson gson = new Gson();
        SharedPreferences preferences = MainActivity.activity.getSharedPreferences(PREF_USER_BASED, Context.MODE_PRIVATE);
        List<Question> listWillBePut = new ArrayList<>();
        if (questionList != null) {
            for (Question questionInfo : questionList) {
                listWillBePut.add(questionInfo);
            }

        }
        preferences.edit().putString(KEY_QUESTION_ITEM_SET, gson.toJson(listWillBePut)).apply();
    }

    public static List<Question> getQuestionList() {
        try {
            Gson gson = new Gson();
            SharedPreferences preferences = MainActivity.activity.getSharedPreferences(PREF_USER_BASED, Context.MODE_PRIVATE);
            Type typeOfT = TypeToken.getParameterized(List.class, Question.class).getType();
            String json = preferences.getString(KEY_QUESTION_ITEM_SET, null);
            if (json != null)
                return gson.fromJson(json, typeOfT);
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static void putSettingsList(List<Settings> settingsList) {
        Gson gson = new Gson();
        SharedPreferences preferences = MainActivity.activity.getSharedPreferences(PREF_USER_BASED, Context.MODE_PRIVATE);
        List<Settings> listWillBePut = new ArrayList<>();
        if (settingsList != null) {
            for (Settings settingsInfo : settingsList) {
                listWillBePut.add(settingsInfo);
            }

        }
        preferences.edit().putString(KEY_SETTINGS_ITEM_SET, gson.toJson(listWillBePut)).apply();
    }

    public static List<Settings> getSettingsList() {
        try {
            Gson gson = new Gson();
            SharedPreferences preferences = MainActivity.activity.getSharedPreferences(PREF_USER_BASED, Context.MODE_PRIVATE);
            Type typeOfT = TypeToken.getParameterized(List.class, Settings.class).getType();
            String json = preferences.getString(KEY_SETTINGS_ITEM_SET, null);
            if (json != null)
                return gson.fromJson(json, typeOfT);
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }
}
