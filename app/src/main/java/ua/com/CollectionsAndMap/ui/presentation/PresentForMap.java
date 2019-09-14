package ua.com.CollectionsAndMap.ui.presentation;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import ua.com.CollectionsAndMap.data.DataSave;
import ua.com.CollectionsAndMap.domain.model.MapModels.HashMapModel;
import ua.com.CollectionsAndMap.domain.model.MapModels.TreeMapModel;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.Presenter;
import ua.com.CollectionsAndMap.ui.MainActivity;
import ua.com.CollectionsAndMap.ui.fragment.TabMap;

public class PresentForMap implements Presenter {

    private TabMap tabMap;
    private int amountElements;
    private int queue = 0;
    private DataSave listSave;
    private MainActivity activity;

    public PresentForMap(MainActivity activity, TabMap tabMap) {
        this.tabMap = tabMap;
        this.activity = activity;
        this.listSave = DataSave.getDataSave();
    }
    @Override
    public void onCalculation(int amauntElemants) {
        this.amountElements = amauntElemants;
        queue = 1;
        startNext();
    }

    public void startNext() {
        if (queue == 0) {
            new TreeMapModel(amountElements, this).start();
        }
        if (queue == 1) {
            new HashMapModel(amountElements, this).start();
        }
        if (queue < 0) {
            activity.hidProgress();
            listSave.setDataMap(tabMap.getSaveData());
        }
        queue--;
    }

    public Map<Integer, String> getData() {
        return listSave.getDataMap();
    }
    public void callbackFromMapModel(Map<Byte, Byte> list, FlagMap flagMap) {
        if ((flagMap == FlagMap.TREE)){tabMap.fillResult((TreeMap<Byte, Byte>) list);}
        if (flagMap == FlagMap.HASH){tabMap.fillResult((HashMap<Byte, Byte>) list);}

    }
}