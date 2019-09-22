package ua.com.CollectionsAndMap.ui.presentation;


import android.annotation.SuppressLint;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ua.com.CollectionsAndMap.domain.model.MapModels.HashMapModel;
import ua.com.CollectionsAndMap.domain.model.MapModels.TreeMapModel;
import ua.com.CollectionsAndMap.ui.MainActivity;
import ua.com.CollectionsAndMap.ui.fragment.innterfasFragment.FillView;
import ua.com.CollectionsAndMap.ui.fragment.TabMap;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;

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


    public PresentForMap(MainActivity activity, TabMap tabMap) {
        super(activity);
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

            Observable.fromCallable(() -> speedMap(map, ADDMAP))
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe((stringMap -> {
                        treeMap.put(ADDMAP,stringMap.get(ADDMAP));
                        fillView.fillResult(stringMap.get(ADDMAP), flag, ADDMAP);}));
            Observable.fromCallable(() -> speedMap(map, SEARCHMAP))
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe((stringMap -> {
                        treeMap.put(SEARCHMAP,stringMap.get(SEARCHMAP));
                        fillView.fillResult(stringMap.get(SEARCHMAP), flag, SEARCHMAP);}));
            Observable.fromCallable(() -> speedMap(map, REMOVEMAP))
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe((stringMap -> {
                        treeMap.put(REMOVEMAP,stringMap.get(REMOVEMAP));
                        fillView.fillResult(stringMap.get(REMOVEMAP), flag, REMOVEMAP);}));
        }
        if (flag == TypeCollectin.HASH) {

            Observable.fromCallable(() -> speedMap(map, ADDMAP))
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe((stringMap -> {
                        hashMap.put(ADDMAP,stringMap.get(ADDMAP));
                        fillView.fillResult(stringMap.get(ADDMAP), flag, ADDMAP);}));
            Observable.fromCallable(() -> speedMap(map, SEARCHMAP))
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe((stringMap -> {
                        hashMap.put(SEARCHMAP,stringMap.get(SEARCHMAP));
                        fillView.fillResult(stringMap.get(SEARCHMAP), flag, SEARCHMAP);}));
            Observable.fromCallable(() -> speedMap(map, REMOVEMAP))
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe((stringMap -> {
                        hashMap.put(REMOVEMAP,stringMap.get(REMOVEMAP));
                        fillView.fillResult(stringMap.get(REMOVEMAP), flag, REMOVEMAP);}));
        }

    }


}