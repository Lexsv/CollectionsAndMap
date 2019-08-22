package ua.com.CollectionsAndMap.ui.presentation;

import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import ua.com.CollectionsAndMap.R;
import ua.com.CollectionsAndMap.data.resors.ArrayListElements;
import ua.com.CollectionsAndMap.data.resors.CopyOnWriteListElements;
import ua.com.CollectionsAndMap.data.resors.HashMapElements;
import ua.com.CollectionsAndMap.data.resors.LinkedListElements;
import ua.com.CollectionsAndMap.data.resors.TreeMapElements;
import ua.com.CollectionsAndMap.utils.FillView;

public class Present {


    private ViewPager viewPager;

    ArrayList<Integer> arrayList;
    LinkedList<Integer> linkedList;
    CopyOnWriteArrayList<Integer> copyOnWriteArrayList;

    TreeMap<Integer, Integer> treeMap;
    HashMap<Integer, Integer> hashMap;

    public void showDataView() {
        if (viewPager.getCurrentItem() == 0) {

            TextView arrayListAddBegin = viewPager.getRootView().findViewById(R.id.arrayList_addBagin);
            TextView arrayListAddMiddle = viewPager.getRootView().findViewById(R.id.arrayList_addMiddle);
            TextView arrayListAddEnd = viewPager.getRootView().findViewById(R.id.arrayList_addEnd);
            TextView arrayListSearch = viewPager.getRootView().findViewById(R.id.arrayList_search);
            TextView arrayListRemoveBegin = viewPager.getRootView().findViewById(R.id.arrayList_removeBagin);
            TextView arrayListRemoveMiddle = viewPager.getRootView().findViewById(R.id.arrayList_ramoveMidlle);
            TextView arrayListRemoveEnd = viewPager.getRootView().findViewById(R.id.arrayList_removeEnd);
            TextView linkedListAddBegin = viewPager.getRootView().findViewById(R.id.linkedList_addBagin);
            TextView linkedListAddMiddle = viewPager.getRootView().findViewById(R.id.linkedList_addMiddle);
            TextView linkedListAddEnd = viewPager.getRootView().findViewById(R.id.linkedList_addEnd);
            TextView linkedListSearch = viewPager.getRootView().findViewById(R.id.linkedList_search);
            TextView linkedListRemoveBegin = viewPager.getRootView().findViewById(R.id.linkedList_removeBagin);
            TextView linkedListRemoveMiddle = viewPager.getRootView().findViewById(R.id.linkedList_ramoveMidlle);
            TextView linkedListRemoveEnd = viewPager.getRootView().findViewById(R.id.linkedList_removeEnd);
            TextView copyOnWriteAddBegin = viewPager.getRootView().findViewById(R.id.copyOn_write_addBagin);
            TextView copyOnWriteAddMiddle = viewPager.getRootView().findViewById(R.id.copyOn_write_addMiddle);
            TextView copyOnWriteAddEnd = viewPager.getRootView().findViewById(R.id.copyOn_write_addEnd);
            TextView copyOnWriteSearch = viewPager.getRootView().findViewById(R.id.copyOn_write_search);
            TextView copyOnWriteRemoveBegin = viewPager.getRootView().findViewById(R.id.copyOn_write_removeBagin);
            TextView copyOnWriteRemoveMiddle = viewPager.getRootView().findViewById(R.id.copyOn_write_ramoveMidlle);
            TextView copyOnWriteRemoveEnd = viewPager.getRootView().findViewById(R.id.copyOn_write_removeEnd);


            arrayListAddBegin.setText(String.valueOf(FillView.speedAddBeginToList(arrayList)));
            linkedListAddBegin.setText(String.valueOf(FillView.speedAddBeginToList(linkedList)));
            copyOnWriteAddBegin.setText(String.valueOf(FillView.speedAddBeginToList(copyOnWriteArrayList)));

            arrayListAddMiddle.setText(String.valueOf(FillView.speedAddMiddleToList(arrayList)));
            linkedListAddMiddle.setText(String.valueOf(FillView.speedAddMiddleToList(linkedList)));
            copyOnWriteAddMiddle.setText(String.valueOf(FillView.speedAddMiddleToList(copyOnWriteArrayList)));

            arrayListAddEnd.setText(String.valueOf(FillView.speedAddEndToList(arrayList)));
            linkedListAddEnd.setText(String.valueOf(FillView.speedAddEndToList(linkedList)));
            copyOnWriteAddEnd.setText(String.valueOf(FillView.speedAddEndToList(copyOnWriteArrayList)));

            arrayListSearch.setText(String.valueOf(FillView.speedSearchInList(arrayList)));
            linkedListSearch.setText(String.valueOf(FillView.speedSearchInList(linkedList)));
            copyOnWriteSearch.setText(String.valueOf(FillView.speedSearchInList(copyOnWriteArrayList)));

            arrayListRemoveBegin.setText(String.valueOf(FillView.speedRemoveBeginToList(arrayList)));
            linkedListRemoveBegin.setText(String.valueOf(FillView.speedRemoveBeginToList(linkedList)));
            copyOnWriteRemoveBegin.setText(String.valueOf(FillView.speedRemoveBeginToList(copyOnWriteArrayList)));

            arrayListRemoveMiddle.setText(String.valueOf(FillView.speedRemoveMiddleToList(arrayList)));
            linkedListRemoveMiddle.setText(String.valueOf(FillView.speedRemoveMiddleToList(linkedList)));
            copyOnWriteRemoveMiddle.setText(String.valueOf(FillView.speedRemoveMiddleToList(copyOnWriteArrayList)));

            arrayListRemoveEnd.setText(String.valueOf(FillView.speedRemoveEndToList(arrayList)));
            linkedListRemoveEnd.setText(String.valueOf(FillView.speedRemoveEndToList(linkedList)));
            copyOnWriteRemoveEnd.setText(String.valueOf(FillView.speedRemoveEndToList(copyOnWriteArrayList)));

        }

        if (viewPager.getCurrentItem() == 1) {
            TextView treeMapAdd = viewPager.getRootView().findViewById(R.id.treeMap_add);
            TextView treeMapSearchKey = viewPager.getRootView().findViewById(R.id.treeMap_SearchKey);
            TextView treeMapRemov = viewPager.getRootView().findViewById(R.id.treeMap_remove);
            TextView hashMapAdd = viewPager.getRootView().findViewById(R.id.hashMap_add);
            TextView hashMapSearchKey = viewPager.getRootView().findViewById(R.id.hashMap_SearchKey);
            TextView hashMapRemove = viewPager.getRootView().findViewById(R.id.hashMap_remove);


            treeMapAdd.setText(String.valueOf(FillView.speedAddToMap(treeMap)));
            treeMapSearchKey.setText(String.valueOf(FillView.speedSearchInMap(treeMap)));
            treeMapRemov.setText(String.valueOf(FillView.speedRemovInMap(treeMap)));

            hashMapAdd.setText(String.valueOf(FillView.speedAddToMap(hashMap)));
            hashMapSearchKey.setText(String.valueOf(FillView.speedSearchInMap(hashMap)));
            hashMapRemove.setText(String.valueOf(FillView.speedRemovInMap(hashMap)));
        }


    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }


    public synchronized void  setAmoutElement(int amountElements) {


            if (viewPager.getCurrentItem() == 0) {
                arrayList = new ArrayListElements(amountElements).getArrayList();
                linkedList = new LinkedListElements(amountElements).getLinkedList();
                copyOnWriteArrayList = new CopyOnWriteListElements(amountElements).getCopyOnWriteArrayList();
            }

            if (viewPager.getCurrentItem() == 1) {
                treeMap = new TreeMapElements(amountElements).getTreeMap();
                hashMap = new HashMapElements(amountElements).getHashMap();
            }

    }
}
