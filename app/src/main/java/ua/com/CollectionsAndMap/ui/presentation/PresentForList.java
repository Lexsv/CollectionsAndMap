package ua.com.CollectionsAndMap.ui.presentation;



import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedList;

import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import ua.com.CollectionsAndMap.domain.model.ListModel.ArrayListModel;
import ua.com.CollectionsAndMap.domain.model.ListModel.CopyOnWriteModel;
import ua.com.CollectionsAndMap.domain.model.ListModel.LinkedListModel;

import ua.com.CollectionsAndMap.ui.MainActivity;
import ua.com.CollectionsAndMap.ui.fragment.TabCollection;
import ua.com.CollectionsAndMap.ui.presentation.interfaceExpand.Presenter;




public class PresentForList implements Presenter {

    private TabCollection tabCollection;
    private int queue = 0;
    private int amountElements;
    private MainPresent mainPresent;

    public PresentForList(MainPresent mainPresent) {
        this.mainPresent = mainPresent;
    }

    private static Map<Integer,String> saveView = new HashMap<>();

    public static Map<Integer, String> getSaveView() {
        return saveView;
    }


    public void showDataView(int amountElements) {
        this.amountElements = amountElements;
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

            mainPresent.hidProgress();
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

    public void setTabCollection(TabCollection tabCollection) {
        this.tabCollection = tabCollection;

    }


}
