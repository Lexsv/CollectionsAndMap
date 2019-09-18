package ua.com.CollectionsAndMap.ui.presentation;


import java.util.Map;

import ua.com.CollectionsAndMap.domain.model.MapModels.HashMapModel;
import ua.com.CollectionsAndMap.domain.model.MapModels.TreeMapModel;
import ua.com.CollectionsAndMap.ui.MainActivity;
import ua.com.CollectionsAndMap.ui.fragment.InnterfasFragment.FillView;
import ua.com.CollectionsAndMap.ui.fragment.TabMap;
import ua.com.CollectionsAndMap.ui.presentation.flag.FlagMap;

public class PresentForMap extends BasePresenter{

    private FillView fillView;
    private int amountElements;
    private int queue = 0;


    public PresentForMap(MainActivity activity,TabMap tabMap) {
        super(activity);
        this.fillView = tabMap;
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
            hidProgress();
        }
        queue--;
    }

    public Map<Integer, String> getData() {
        return  preferences.getDataMap();
    }

    public void callbackFromMapModel(Map<Byte, Byte> map, FlagMap flag) {
        if ((flag == FlagMap.TREE)){fillView.fillResult(map,flag);}
        if (flag == FlagMap.HASH){fillView.fillResult(map,flag);}

    }

    public void saveData(Map<Integer, String> data) {
        preferences.setDataMap(data);

    }
}