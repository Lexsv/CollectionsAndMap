package ua.com.CollectionsAndMap.data;

import java.util.Map;

public class DataSave implements DataSaveSharedPreferences {
    private static DataSave dataSave;
    private static Map<Integer, String> dataList;
    private static Map<Integer, String> dataMap;

    private DataSave() {
    }

    public static DataSave getDataSave() {
        if (dataSave == null) {
            return new DataSave();
        }
        return dataSave;
    }

    @Override
    public Map<Integer, String> getDataList() {
        return dataList;
    }

    @Override
    public void setDataList(Map<Integer, String> dataList) {
        this.dataList = dataList;
    }

    @Override
    public Map<Integer, String> getDataMap() {
        return dataMap;
    }

    @Override
    public void setDataMap(Map<Integer, String> dataMap) {
        this.dataMap = dataMap;
    }
}
