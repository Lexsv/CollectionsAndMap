package ua.com.CollectionsAndMap.ui.presentation;


import android.annotation.SuppressLint;
import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ua.com.CollectionsAndMap.domain.model.MapModels.HashMapModel;
import ua.com.CollectionsAndMap.domain.model.MapModels.TreeMapModel;
import ua.com.CollectionsAndMap.ui.MainActivity;
import ua.com.CollectionsAndMap.ui.fragment.innterfasFragment.FillView;
import ua.com.CollectionsAndMap.ui.fragment.TabMap;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;

import static ua.com.CollectionsAndMap.domain.utils.FillView.*;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.ADDMAP;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.REMOVEMAP;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.SEARCHMAP;
import static ua.com.CollectionsAndMap.domain.utils.FillView.speedMap;

public class PresentForMap extends BasePresenter {


    private FillView fillView;
    private int amountElements;
    private int queue = 0;
    private boolean wasCalcul = false;
    private Map<ActionFill, String> treeMap= new HashMap<>();
    private Map<ActionFill, String> hashMap= new HashMap<>();

    @Inject
    public PresentForMap(Context context, TabMap tabMap) {
        super(context);
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
        wasCalcul = !wasCalcul;
    }

    @Override
    public Map<ActionFill, String> getData(TypeCollectin typeCollectin) {
        return preferences.getDataMap(typeCollectin);
    }

    @Override
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
                        treeMap.put(ADDMAP,stringMap.get(ADDMAP));
                        fillView.fillResult(stringMap.get(ADDMAP), flag, ADDMAP);}));
            callbackResaltSpeedMap(map, SEARCHMAP)
                    .subscribe((stringMap -> {
                        treeMap.put(SEARCHMAP,stringMap.get(SEARCHMAP));
                        fillView.fillResult(stringMap.get(SEARCHMAP), flag, SEARCHMAP);}));
            callbackResaltSpeedMap(map, REMOVEMAP)
                    .subscribe((stringMap -> {
                        treeMap.put(REMOVEMAP,stringMap.get(REMOVEMAP));
                        fillView.fillResult(stringMap.get(REMOVEMAP), flag, REMOVEMAP);}));
        }
        if (flag == TypeCollectin.HASH) {

            callbackResaltSpeedMap(map, ADDMAP)
                    .subscribe((stringMap -> {
                        hashMap.put(ADDMAP,stringMap.get(ADDMAP));
                        fillView.fillResult(stringMap.get(ADDMAP), flag, ADDMAP);}));
            callbackResaltSpeedMap(map, SEARCHMAP)
                    .subscribe((stringMap -> {
                        hashMap.put(SEARCHMAP,stringMap.get(SEARCHMAP));
                        fillView.fillResult(stringMap.get(SEARCHMAP), flag, SEARCHMAP);}));
            callbackResaltSpeedMap(map, REMOVEMAP)
                    .subscribe((stringMap -> {
                        hashMap.put(REMOVEMAP,stringMap.get(REMOVEMAP));
                        fillView.fillResult(stringMap.get(REMOVEMAP), flag, REMOVEMAP);}));
        }

    }


}