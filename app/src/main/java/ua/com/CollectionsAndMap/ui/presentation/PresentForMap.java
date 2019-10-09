package ua.com.CollectionsAndMap.ui.presentation;


import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import ua.com.CollectionsAndMap.domain.model.MapModels.HashMapModel;
import ua.com.CollectionsAndMap.domain.model.MapModels.TreeMapModel;
import ua.com.CollectionsAndMap.ui.fragment.innterfasFragment.FillView;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;

import static ua.com.CollectionsAndMap.domain.utils.FillView.*;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.ADDMAP;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.REMOVEMAP;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.SEARCHMAP;


public  class PresentForMap extends BasePresenter implements LifecycleObserver {



    private int queue = 6;
    private boolean wasCalcul = false;
    private Map<ActionFill, String> treeMap = new HashMap<>();
    private Map<ActionFill, String> hashMap = new HashMap<>();

    @Inject
    public PresentForMap(MainContract.View view, FillView fillView) {
        super(view, fillView);
    }

    @Override
    public void finishCalcul() {
        queue--;
        if (queue == 0) {
            hidProgress();
            wasCalcul = !wasCalcul;
            queue = 6;
        }
    }

    @Override
    public void onCalculation(int amauntElemants) {
        new TreeMapModel(amauntElemants, this).start();
        new HashMapModel(amauntElemants, this).start();
    }


    @Override
    public Map<ActionFill, String> getData(TypeCollectin typeCollectin) {
        return preferences.getDataMap(typeCollectin);
    }
    @Override
    public void dispose(){
//        for (String d : disposableMap.keySet()){
//            if (disposableMap.get(d) !=null){disposableMap.get(d).dispose();}
//        }
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void saveData() {
        if (wasCalcul) {
            preferences.setDataMap(treeMap, TypeCollectin.TREE);
            preferences.setDataMap(hashMap, TypeCollectin.HASH);
        }
    }

    @SuppressLint("CheckResult")
    public void callbackFromMapModel(Map<Byte, Byte> map, TypeCollectin flag) {

        if (flag == TypeCollectin.TREE) {

            callbackResaltSpeedMap(map, ADDMAP)
                    .subscribe((stringMap -> {
                        treeMap.put(ADDMAP, stringMap.get(ADDMAP));
                        fillView.fillResult(stringMap.get(ADDMAP), flag, ADDMAP);
                        finishCalcul();
                    }));
            callbackResaltSpeedMap(map, SEARCHMAP)
                    .subscribe((stringMap -> {
                        treeMap.put(SEARCHMAP, stringMap.get(SEARCHMAP));
                        fillView.fillResult(stringMap.get(SEARCHMAP), flag, SEARCHMAP);
                        finishCalcul();
                    }));
            callbackResaltSpeedMap(map, REMOVEMAP)
                    .subscribe((stringMap -> {
                        treeMap.put(REMOVEMAP, stringMap.get(REMOVEMAP));
                        fillView.fillResult(stringMap.get(REMOVEMAP), flag, REMOVEMAP);
                        finishCalcul();
                    }));
        }
        if (flag == TypeCollectin.HASH) {

            callbackResaltSpeedMap(map, ADDMAP)
                    .subscribe((stringMap -> {
                        hashMap.put(ADDMAP, stringMap.get(ADDMAP));
                        fillView.fillResult(stringMap.get(ADDMAP), flag, ADDMAP);
                        finishCalcul();
                    }));
            callbackResaltSpeedMap(map, SEARCHMAP)
                    .subscribe((stringMap -> {
                        hashMap.put(SEARCHMAP, stringMap.get(SEARCHMAP));
                        fillView.fillResult(stringMap.get(SEARCHMAP), flag, SEARCHMAP);
                        finishCalcul();
                    }));
            callbackResaltSpeedMap(map, REMOVEMAP)
                    .subscribe((stringMap -> {
                        hashMap.put(REMOVEMAP, stringMap.get(REMOVEMAP));
                        fillView.fillResult(stringMap.get(REMOVEMAP), flag, REMOVEMAP);
                        finishCalcul();
                    }));
        }

    }

}