package ua.com.CollectionsAndMap.ui.presentation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import ua.com.CollectionsAndMap.data.DataSave;
import ua.com.CollectionsAndMap.domain.model.ListModel.ArrayListModel;
import ua.com.CollectionsAndMap.domain.model.ListModel.CopyOnWriteModel;
import ua.com.CollectionsAndMap.domain.model.ListModel.LinkedListModel;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.Presenter;
import ua.com.CollectionsAndMap.ui.MainActivity;
import ua.com.CollectionsAndMap.ui.fragment.TabCollection;


public class PresentForList implements Presenter {

    private TabCollection tabCollection;
    private int queue = 0;
    private int amountElements;
    private DataSave listSave;
    private MainActivity activity;


    public PresentForList(MainActivity activity, TabCollection tabCollection) {
        this.tabCollection = tabCollection;
        this.activity = activity;
        this.listSave = DataSave.getDataSave();
    }


    @Override
    public void onCalculation(int amauntElemants) {
        this.amountElements = amauntElemants;
        queue = 2;
        startNext();
    }


    public void startNext() {

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
            activity.hidProgress();
            listSave.setDataList(tabCollection.getSaveData());
        }
        queue--;
    }

    public Map<Integer, String> getData() {
        return listSave.getDataList();
    }

    public void callbackFromListModel(List<Integer> list, FlagList flag) {
       if (flag == FlagList.ARREY){tabCollection.fillResult((ArrayList<Integer>) list);}
       if (flag == FlagList.LINKED){tabCollection.fillResult((LinkedList<Integer>) list);}
       if (flag == FlagList.COPYONWRITE){tabCollection.fillResult((CopyOnWriteArrayList<Integer>) list);}
    }


}
