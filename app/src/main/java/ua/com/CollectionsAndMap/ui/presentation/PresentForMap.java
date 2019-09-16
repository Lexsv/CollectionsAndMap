package ua.com.CollectionsAndMap.ui.presentation;


import java.util.Map;

import ua.com.CollectionsAndMap.data.DataSave;
import ua.com.CollectionsAndMap.data.DataSharedPreferences;
import ua.com.CollectionsAndMap.domain.model.MapModels.HashMapModel;
import ua.com.CollectionsAndMap.domain.model.MapModels.TreeMapModel;
import ua.com.CollectionsAndMap.ui.MainActivity;
import ua.com.CollectionsAndMap.ui.fragment.InnterfasFragment.FillView;
import ua.com.CollectionsAndMap.ui.fragment.InnterfasFragment.SaveDataSharedPreference;
import ua.com.CollectionsAndMap.ui.fragment.TabMap;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;

public class PresentForMap implements MainContract.Presenter, SaveDataSharedPreference {

    private FillView fillView;
    private int amountElements;
    private int queue = 0;
    private DataSave listSave;
    private DataSharedPreferences preferences;
    private MainActivity activity;

    public PresentForMap(MainActivity activity, TabMap tabMap) {
        this.fillView = tabMap;
        this.activity = activity;
        this.listSave = DataSave.getDataSave();
         this.preferences = DataSharedPreferences.getDataSharedPref();
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
            //listSave.setDataMap(fillView.getSaveData());
        }
        queue--;
    }

    public Map<Integer, String> getData() {
        return  preferences.getDataMap(); //listSave.getDataMap();
    }

    public void callbackFromMapModel(Map<Byte, Byte> map, FlagMap flag) {
        if ((flag == FlagMap.TREE)){fillView.fillResult(map,flag);}
        if (flag == FlagMap.HASH){fillView.fillResult(map,flag);}

    }

    @Override
    public void saveData(Map<Integer, String> data) {
        preferences.setDataMap(data);

    }
}