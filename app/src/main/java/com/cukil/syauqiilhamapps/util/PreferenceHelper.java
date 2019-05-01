package com.cukil.syauqiilhamapps.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class PreferenceHelper {

    public static final String PREFS_NAME = "com.cukil.syauqiilhamapps.PREFERENCES";
    public static final String KEY_FIRST_TIME = "com.cukil.syauqiilhamapps.FIRST_TIME";

    public static String getString(Context ctx, String key) {
        SharedPreferences sp = ctx.getSharedPreferences(PREFS_NAME, Activity.MODE_PRIVATE);
        return sp.getString(key, null);
    }

    public static boolean getBoolean(Context ctx, String key) {
        SharedPreferences sp = ctx.getSharedPreferences(PREFS_NAME, Activity.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    public static boolean getBoolean(Context ctx, String key, boolean defValue) {
        SharedPreferences sp = ctx.getSharedPreferences(PREFS_NAME, Activity.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    public static void setString(Context ctx, String key, String value) {
        SharedPreferences sp = ctx.getSharedPreferences(PREFS_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void setBoolean(Context ctx, String key, boolean value) {
        SharedPreferences sp = ctx.getSharedPreferences(PREFS_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
}
