package ua.com.CollectionsAndMap.ui.presentation;



import android.widget.TextView;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedList;

import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import ua.com.CollectionsAndMap.domain.model.ListModel.ArrayListModel;
import ua.com.CollectionsAndMap.domain.model.ListModel.CopyOnWriteModel;
import ua.com.CollectionsAndMap.domain.model.ListModel.LinkedListModel;

import ua.com.CollectionsAndMap.ui.fragment.TabCollection;
import ua.com.CollectionsAndMap.ui.presentation.interfaceExpand.Presenter;
import ua.com.CollectionsAndMap.ui.presentation.interfaceExpand.ProgressBar;

public class PresentForList implements Presenter {

    private TabCollection tabCollection;
    private int queue = 0;
    private int amountElements;
    private ProgressBar progressBar;
    private Map<TextView,String> saveView =   new HashMap<>();


    public PresentForList(int amountElements, TabCollection tabCollection) {
        this.tabCollection = tabCollection;
        this.amountElements = amountElements;
        this.progressBar = tabCollection;
    }
    @Override
    public void showDataView(int amountElements) {
        progressBar.shoeProgress();
        this.amountElements = amountElements;
            queue = 2;
            startNext();
    }
    @Override
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
            progressBar.hidProgress();
            saveView = tabCollection.getSaveData();
        }
        queue--;
    }

    public void callbackFromListModel(ArrayList<Integer> list) {
        tabCollection.fillResult(list);
    }

    public void callbackFromListModel(LinkedList<Integer> list) {
        tabCollection.fillResult(list);
    }

    public void callbackFromListModel(CopyOnWriteArrayList<Integer> list) {
        tabCollection.fillResult(list);
    }
    @Override
    public void fillDataView (){
       tabCollection.onRecycleView(saveView);
    }

}
