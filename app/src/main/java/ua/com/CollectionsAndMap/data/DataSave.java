package ua.com.CollectionsAndMap.data;

import java.util.Map;

public class DataSave {
    private static DataSave dataSave;
    private static Map <Integer,String> dataList;
    private  static Map <Integer,String> dataMap;

    private DataSave() {
    }
    public static DataSave getDataSave (){
        if (dataSave == null){return new DataSave();}
    return dataSave;
    }

    public Map<Integer, String> getDataList() {
        return dataList;
    }

    public void setDataList(Map<Integer, String> dataList) {
        this.dataList = dataList;
    }

    public Map<Integer, String> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<Integer, String> dataMap) {
        this.dataMap = dataMap;
    }
}
