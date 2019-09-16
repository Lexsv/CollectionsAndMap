package ua.com.CollectionsAndMap.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

import ua.com.CollectionsAndMap.domain.utils.ProvidContext;

public final class DataSharedPreferences implements DataSaveSharedPreferences {

    private static DataSharedPreferences dataSharedPreferences;
    private  SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Gson gson;
    private static String LIST = "LIST";
    private static String MAP = "MAP";

    private DataSharedPreferences() {
        this.preferences = ProvidContext.getContext().getSharedPreferences("save_data", Context.MODE_PRIVATE);
        this.editor = preferences.edit();
        gson = new Gson();
    }


    public static DataSharedPreferences getDataSharedPref(){
        if (dataSharedPreferences == null) {
            dataSharedPreferences = new DataSharedPreferences();
            return dataSharedPreferences;
        }else {return dataSharedPreferences;}
    }

    @Override
    public Map<Integer, String> getDataList() {
        Type type = new TypeToken<Map<Integer, String>>(){}.getType();
        return gson.fromJson(preferences.getString(LIST, null),type);
    }

    @Override
    public void setDataList(Map<Integer, String> dataList) {
        editor.putString(LIST , gson.toJson(dataList));
        editor.commit();
    }

    @Override
    public Map<Integer, String> getDataMap() {
        Type type = new TypeToken<Map<Integer, String>>(){}.getType();
        return gson.fromJson(preferences.getString(MAP, null),type);
    }

    @Override
    public void setDataMap(Map<Integer, String> dataMap) {
        editor.putString(MAP , gson.toJson(dataMap));
        editor.commit();

    }


}
