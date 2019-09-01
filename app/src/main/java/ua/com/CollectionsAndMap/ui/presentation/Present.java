package ua.com.CollectionsAndMap.ui.presentation;

import androidx.viewpager.widget.ViewPager;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.inject.Inject;

import ua.com.CollectionsAndMap.domain.model.ListModel.ArrayListModel;
import ua.com.CollectionsAndMap.domain.model.ListModel.CopyOnWriteModel;
import ua.com.CollectionsAndMap.domain.model.ListModel.LinkedListModel;
import ua.com.CollectionsAndMap.domain.model.MapModels.HashMapModel;
import ua.com.CollectionsAndMap.domain.model.MapModels.TreeMapModel;
import ua.com.CollectionsAndMap.ui.MainActivity;

public class Present {

    private ViewPager viewPager;
    private MainActivity activity;
    private int queue = 0;
    private int amountElements;

    public Present(MainActivity activity, ViewPager viewPager) {
        this.viewPager = viewPager;
        this.activity = activity;

    }

    public void showDataView(int amountElements) {
        this.amountElements = amountElements;
        activity.shoeProgress();

        if (viewPager.getCurrentItem() == 0) {
            queue = 2;
            startNextList();
        }
        if (viewPager.getCurrentItem() == 1) {
            queue = 1;
            startNextMap();
        }
    }

    public void startNextList() {

        if (queue == 0) {
            new ArrayListModel(amountElements, this).execute();
        }
        if (queue == 1) {
            new LinkedListModel(amountElements, this).execute();
        }
        if (queue == 2) {
            new CopyOnWriteModel(amountElements, this).execute();
        }
        if (queue < 0) {
            activity.hidProgress();
        }
        queue--;
    }

    public void startNextMap() {
        if (queue == 0) {

            new TreeMapModel(amountElements, this).execute();
        }
        if (queue == 1) {
            new HashMapModel(amountElements, this).execute();
        }
        if (queue < 0) {
            activity.hidProgress();
        }
        queue--;
    }

    public void callbackFromListModel(ArrayList<Integer> list) {
        activity.fillViewToFragment(list);
    }

    public void callbackFromListModel(LinkedList<Byte> list) {
        activity.fillViewToFragment(list);
    }

    public void callbackFromListModel(CopyOnWriteArrayList<Integer> list) {
        activity.fillViewToFragment(list);
    }

    public void callbackFromListModel(HashMap<Byte, Byte> list) {
        activity.fillViewToFragment(list);
    }

    public void callbackFromListModel(TreeMap<Byte, Byte> list) {
        activity.fillViewToFragment(list);
    }

    public void onDestroy() {
        activity = null;
    }
}
