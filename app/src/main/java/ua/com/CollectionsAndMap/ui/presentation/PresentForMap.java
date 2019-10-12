package ua.com.CollectionsAndMap.ui.presentation;


import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import ua.com.CollectionsAndMap.data.StatData;
import ua.com.CollectionsAndMap.data.TypeRow;
import ua.com.CollectionsAndMap.domain.model.MapModels.HashMapModel;
import ua.com.CollectionsAndMap.domain.model.MapModels.TreeMapModel;
import ua.com.CollectionsAndMap.ui.fragment.innterfasFragment.FillView;
import ua.com.CollectionsAndMap.ui.mainaactivity.MainViewModul;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;

import static ua.com.CollectionsAndMap.domain.utils.FillView.*;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.ADDMAP;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.REMOVEMAP;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.SEARCHMAP;


public  class PresentForMap extends BasePresenter implements LifecycleObserver {



    private int queue = 6;


    @Inject
    public PresentForMap(MainContract.View view, FillView fillView) {
        super(view, fillView);
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
    public void onCalculation(int amauntElemants) {
        new TreeMapModel(amauntElemants, this).start();
        new HashMapModel(amauntElemants, this).start();
    }





    @SuppressLint("CheckResult")
    public void callbackFromMapModel(Map<Byte, Byte> map, TypeCollectin flag) {

        if (flag == TypeCollectin.TREE) {

            callbackResaltSpeedMap(map, ADDMAP)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDMAP),TypeRow.TREEMAPADD);
                        fillView.fillResult(stringMap.get(ADDMAP), flag, ADDMAP);
                        finishCalcul();
                    }));
            callbackResaltSpeedMap(map, SEARCHMAP)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(SEARCHMAP),TypeRow.TREEMAPSEARCHKEY);
                        fillView.fillResult(stringMap.get(SEARCHMAP), flag, SEARCHMAP);
                        finishCalcul();
                    }));
            callbackResaltSpeedMap(map, REMOVEMAP)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEMAP),TypeRow.TREEMAPREMOV);
                        fillView.fillResult(stringMap.get(REMOVEMAP), flag, REMOVEMAP);
                        finishCalcul();
                    }));
        }
        if (flag == TypeCollectin.HASH) {

            callbackResaltSpeedMap(map, ADDMAP)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDMAP),TypeRow.HASHMAPADD);
                        fillView.fillResult(stringMap.get(ADDMAP), flag, ADDMAP);
                        finishCalcul();
                    }));
            callbackResaltSpeedMap(map, SEARCHMAP)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(SEARCHMAP),TypeRow.HASHMAPSEARCHKEY);
                        fillView.fillResult(stringMap.get(SEARCHMAP), flag, SEARCHMAP);
                        finishCalcul();
                    }));
            callbackResaltSpeedMap(map, REMOVEMAP)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEMAP),TypeRow.HASHMAPREMOVE);
                        fillView.fillResult(stringMap.get(REMOVEMAP), flag, REMOVEMAP);
                        finishCalcul();
                    }));
        }

    }

}