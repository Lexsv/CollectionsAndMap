package ua.com.CollectionsAndMap.ui.presentation;

import java.util.List;
import java.util.Map;

import ua.com.CollectionsAndMap.data.DataSave;
import ua.com.CollectionsAndMap.data.DataSharedPreferences;
import ua.com.CollectionsAndMap.domain.model.ListModel.ArrayListModel;
import ua.com.CollectionsAndMap.domain.model.ListModel.CopyOnWriteModel;
import ua.com.CollectionsAndMap.domain.model.ListModel.LinkedListModel;
import ua.com.CollectionsAndMap.ui.fragment.InnterfasFragment.FillView;
import ua.com.CollectionsAndMap.ui.fragment.InnterfasFragment.SaveDataSharedPreference;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;
import ua.com.CollectionsAndMap.ui.MainActivity;
import ua.com.CollectionsAndMap.ui.fragment.TabCollection;


public class PresentForList implements MainContract.Presenter, SaveDataSharedPreference {

    private FillView fillView;
    private int queue = 0;
    private int amountElements;
    private DataSave listSave;
    private DataSharedPreferences preferences;
    private MainContract.View hidProgress;


    public PresentForList(MainActivity activity, TabCollection tabCollection) {
        this.fillView =  tabCollection;
        this.hidProgress = activity;
        this.listSave = DataSave.getDataSave();
        this.preferences = DataSharedPreferences.getDataSharedPref();
    }


    @Override
    public void onCalculation(int amauntElemants) {
        this.amountElements = amauntElemants;
        queue = 2;
        startNext();
    }


    public  void startNext() {

        if (queue == 0) {
            new CopyOnWriteModel(amountElements, this).start();

        }
        if (queue == 1) {
            new LinkedListModel(amountElements, this).start();
        }
        if (queue == 2) {
            new ArrayListModel(amountElements, this).start();
        }
        if (queue < 0) {
            hidProgress.hidProgress();

            //listSave.setDataList(fillView.getSaveData());
        }
        queue--;
    }

    public Map<Integer, String> getData() {
        return preferences.getDataList();
                //listSave.getDataList();
    }

    public  void callbackFromListModel(List<Integer> list, FlagList flag) {
       if (flag == FlagList.ARREY){fillView.fillResult(list,flag);}
       if (flag == FlagList.LINKED){fillView.fillResult(list,flag);}
       if (flag == FlagList.COPYONWRITE){fillView.fillResult(list,flag);}
    }


    @Override
    public void saveData(Map<Integer, String> data) {
        preferences.setDataList(data);
    }
}
