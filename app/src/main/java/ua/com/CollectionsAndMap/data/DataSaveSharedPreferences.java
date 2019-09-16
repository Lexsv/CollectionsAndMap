package ua.com.CollectionsAndMap.data;

import java.util.Map;

public interface DataSaveSharedPreferences {
    Map<Integer, String> getDataList();
    void setDataList(Map<Integer, String> dataList);
    Map<Integer, String> getDataMap();
    void setDataMap(Map<Integer, String> dataMap);
}
