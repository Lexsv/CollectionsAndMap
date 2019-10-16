package ua.com.CollectionsAndMap.presentation;


import android.annotation.SuppressLint;

import androidx.lifecycle.LifecycleObserver;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;

import ua.com.CollectionsAndMap.CollOrMap;
import ua.com.CollectionsAndMap.domain.MainViewModul;
import ua.com.CollectionsAndMap.domain.StatData;
import ua.com.CollectionsAndMap.domain.TypeRow;
import ua.com.CollectionsAndMap.domain.FillCollection;
import ua.com.CollectionsAndMap.fragment.FragmentInterfas;

import ua.com.CollectionsAndMap.MainContract;

import static ua.com.CollectionsAndMap.domain.FillView.*;
import static ua.com.CollectionsAndMap.domain.FillView.ActionFill.ADDMAP;
import static ua.com.CollectionsAndMap.domain.FillView.ActionFill.REMOVEMAP;
import static ua.com.CollectionsAndMap.domain.FillView.ActionFill.SEARCHMAP;


public  class PresentForMap extends BasePresenter implements LifecycleObserver {



    private int queue = 6;


    @Inject
    public PresentForMap(MainContract.View view, FragmentInterfas fragmentInterfas) {
        super(view, fragmentInterfas);
    }

    @Override
    public void finishCalcul() {
        queue--;
        if (queue == 0) {
            hidProgress();
            MainViewModul.getMainViewModul().progress = !MainViewModul.getMainViewModul().progress;
            queue = 6;
        }
    }

    @Override
    public void fillView() {
        StatData.getLiveData().getData(TypeRow.TREEMAPADD).observe(fragmentInterfas.getOwn(), s -> {
            fragmentInterfas.fillResult(s,TypeRow.TREEMAPADD);});
        StatData.getLiveData().getData(TypeRow.TREEMAPSEARCHKEY).observe(fragmentInterfas.getOwn(), s -> {
            fragmentInterfas.fillResult(s,TypeRow.TREEMAPSEARCHKEY);});
        StatData.getLiveData().getData(TypeRow.TREEMAPREMOV).observe(fragmentInterfas.getOwn(), s -> {
            fragmentInterfas.fillResult(s,TypeRow.TREEMAPREMOV);});
        StatData.getLiveData().getData(TypeRow.HASHMAPADD).observe(fragmentInterfas.getOwn(), s -> {
            fragmentInterfas.fillResult(s,TypeRow.HASHMAPADD);});
        StatData.getLiveData().getData(TypeRow.HASHMAPSEARCHKEY).observe(fragmentInterfas.getOwn(), s -> {
            fragmentInterfas.fillResult(s,TypeRow.HASHMAPSEARCHKEY);});
        StatData.getLiveData().getData(TypeRow.HASHMAPREMOVE).observe(fragmentInterfas.getOwn(), s -> {
            fragmentInterfas.fillResult(s,TypeRow.HASHMAPREMOVE);});
    }

    @Override
    public void onCalculation(int amauntElemants) {
        FillCollection.getFlowableCollection(amauntElemants, CollOrMap.TREE)
                .subscribe((list)->callbackFromMapModel((TreeMap)list, CollOrMap.TREE));
        FillCollection.getFlowableCollection(amauntElemants, CollOrMap.HASH)
                .subscribe((list)->callbackFromMapModel((HashMap)list, CollOrMap.HASH));

    }




    @SuppressLint("CheckResult")
    public void callbackFromMapModel(Map<Byte, Byte> map, CollOrMap flag) {

        if (flag == CollOrMap.TREE) {

            callbackResaltSpeedMap(map, ADDMAP)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDMAP),TypeRow.TREEMAPADD);
                        finishCalcul();
                    }));
            callbackResaltSpeedMap(map, SEARCHMAP)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(SEARCHMAP),TypeRow.TREEMAPSEARCHKEY);
                        finishCalcul();
                    }));
            callbackResaltSpeedMap(map, REMOVEMAP)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEMAP),TypeRow.TREEMAPREMOV);
                        finishCalcul();
                    }));
        }
        if (flag == CollOrMap.HASH) {

            callbackResaltSpeedMap(map, ADDMAP)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDMAP),TypeRow.HASHMAPADD);
                        finishCalcul();
                    }));
            callbackResaltSpeedMap(map, SEARCHMAP)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(SEARCHMAP),TypeRow.HASHMAPSEARCHKEY);
                        finishCalcul();
                    }));
            callbackResaltSpeedMap(map, REMOVEMAP)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEMAP),TypeRow.HASHMAPREMOVE);
                        finishCalcul();
                    }));
        }

    }

}