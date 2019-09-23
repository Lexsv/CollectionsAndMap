package ua.com.CollectionsAndMap.data;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.AndroidViewModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

import ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill;
import ua.com.CollectionsAndMap.domain.utils.ProvidContext;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;

public final class DataSharedPreferences  {

    private static DataSharedPreferences dataSharedPreferences;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Gson gson;
    private static String ARRLIST = "ARRLIST";
    private static String LINKED = "LINKED";
    private static String COPYONWRITE = "COPYONWRITE";

    private static String TREE = "TREE";
    private static String HASH = "HASH";

    private DataSharedPreferences() {
        this.preferences = ProvidContext.getContext().getSharedPreferences("save_data", Context.MODE_PRIVATE);
        this.editor = preferences.edit();
        gson = new Gson();
    }



    public static synchronized DataSharedPreferences getDataSharedPref(){
        if (dataSharedPreferences == null) {
            dataSharedPreferences = new DataSharedPreferences();
        }
        return dataSharedPreferences;
    }

    public Map<ActionFill, String> getDataList(TypeCollectin typeCollectin) {
        Type type = new TypeToken<Map<ActionFill, String>>(){}.getType();
        if (typeCollectin == TypeCollectin.ARREY){ return gson.fromJson(preferences.getString(ARRLIST, null),type);}
        if (typeCollectin == TypeCollectin.LINKED){ return gson.fromJson(preferences.getString(LINKED, null),type);}
        if (typeCollectin == TypeCollectin.COPYONWRITE){ return gson.fromJson(preferences.getString(COPYONWRITE, null),type);}

        return null;
    }


    public void setDataList(Map<ActionFill, String> dataList, TypeCollectin typeCollectin) {
        if (typeCollectin == TypeCollectin.ARREY){ editor.putString(ARRLIST, gson.toJson(dataList));}
        if (typeCollectin == TypeCollectin.LINKED){  editor.putString(LINKED , gson.toJson(dataList));}
        if (typeCollectin == TypeCollectin.COPYONWRITE){ editor.putString(COPYONWRITE , gson.toJson(dataList));}
        editor.commit();

    }


    public Map<ActionFill, String> getDataMap(TypeCollectin typeCollectin) {
        Type type = new TypeToken<Map<ActionFill, String>>(){}.getType();
        if (typeCollectin == TypeCollectin.TREE){ return gson.fromJson(preferences.getString(TREE, null),type);}
        if (typeCollectin == TypeCollectin.HASH){ return gson.fromJson(preferences.getString(HASH, null),type);}
        return null;
    }


    public void setDataMap(Map<ActionFill, String> dataMap, TypeCollectin typeCollectin) {
        if (typeCollectin == TypeCollectin.TREE){ editor.putString(TREE, gson.toJson(dataMap));}
        if (typeCollectin == TypeCollectin.HASH){  editor.putString(HASH , gson.toJson(dataMap));}
        editor.commit();
    }


}
