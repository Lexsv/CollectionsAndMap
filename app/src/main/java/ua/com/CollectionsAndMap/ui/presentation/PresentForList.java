package ua.com.CollectionsAndMap.ui.presentation;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import ua.com.CollectionsAndMap.domain.model.ListModel.ArrayListModel;
import ua.com.CollectionsAndMap.domain.model.ListModel.CopyOnWriteModel;
import ua.com.CollectionsAndMap.domain.model.ListModel.LinkedListModel;
import ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill;
import ua.com.CollectionsAndMap.ui.fragment.TabCollection;
import ua.com.CollectionsAndMap.ui.fragment.innterfasFragment.FillView;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;

import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.ADDBEGIN;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.ADDEND;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.ADDMIDDL;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.REMOVEBEGIN;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.REMOVEMIDDL;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.REMOVEND;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.SEARCHLIST;
import static ua.com.CollectionsAndMap.domain.utils.FillView.callbackResaltSpeedList;


public class PresentForList extends BasePresenter implements LifecycleObserver {

    private FillView fillView;
    private int queue = 0;
    private int amountElements;
    private boolean wasCalcul = false;
    private Map<ActionFill, String> arreyMap = new HashMap<>();
    private Map<ActionFill, String> lincMap = new HashMap<>();
    private Map<ActionFill, String> copyMap = new HashMap<>();

    @Inject
    public PresentForList(Context context, TabCollection tabCollection) {
        super(context);
        this.fillView = tabCollection;
    }


    @Override
    public void onCalculation(int amauntElemants) {
        this.amountElements = amauntElemants;
        queue = 2;
        startNext();
    }

    @Override
    public  Map<ActionFill, String> getData(TypeCollectin typeCollectin) {
        return preferences.getDataList(typeCollectin);
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void saveData() {
        if (wasCalcul) {
            preferences.setDataList(arreyMap,TypeCollectin.ARREY);
            preferences.setDataList(lincMap,TypeCollectin.LINKED);
            preferences.setDataList(copyMap,TypeCollectin.COPYONWRITE);
        }
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
            hidProgress();
            wasCalcul = !wasCalcul;
        }
        queue--;
    }



    @SuppressLint("CheckResult")
    public void callbackFromListModel(List<Integer> list, TypeCollectin flag) {
        if (flag == TypeCollectin.ARREY) {
            callbackResaltSpeedList(list,ADDBEGIN)
                    .subscribe((stringMap -> {
                        arreyMap.put(ADDBEGIN, stringMap.get(ADDBEGIN));
                        fillView.fillResult(stringMap.get(ADDBEGIN), flag, ADDBEGIN);
                    }));

            callbackResaltSpeedList(list, ADDMIDDL)
                    .subscribe((stringMap -> {
                        arreyMap.put(ADDMIDDL, stringMap.get(ADDMIDDL));
                        fillView.fillResult(stringMap.get(ADDMIDDL), flag, ADDMIDDL);
                    }));
            callbackResaltSpeedList(list, ADDEND)
                    .subscribe((stringMap -> {
                        arreyMap.put(ADDEND, stringMap.get(ADDEND));
                        fillView.fillResult(stringMap.get(ADDEND), flag, ADDEND);
                    }));

            callbackResaltSpeedList(list, SEARCHLIST)
                    .subscribe((stringMap -> {
                        arreyMap.put(SEARCHLIST, stringMap.get(SEARCHLIST));
                        fillView.fillResult(stringMap.get(SEARCHLIST), flag, SEARCHLIST);
                    }));
            callbackResaltSpeedList(list, REMOVEBEGIN)
                    .subscribe((stringMap -> {
                        arreyMap.put(REMOVEBEGIN, stringMap.get(REMOVEBEGIN));
                        fillView.fillResult(stringMap.get(REMOVEBEGIN), flag, REMOVEBEGIN);
                    }));
            callbackResaltSpeedList(list, REMOVEMIDDL)
                    .subscribe((stringMap -> {
                        arreyMap.put(REMOVEMIDDL, stringMap.get(REMOVEMIDDL));
                        fillView.fillResult(stringMap.get(REMOVEMIDDL), flag, REMOVEMIDDL);
                    }));
            callbackResaltSpeedList(list, REMOVEND)
                    .subscribe((stringMap -> {
                        arreyMap.put(REMOVEND, stringMap.get(REMOVEND));
                        fillView.fillResult(stringMap.get(REMOVEND), flag, REMOVEND);
                    }));
        }

        if (flag == TypeCollectin.LINKED) {
            callbackResaltSpeedList(list, ADDBEGIN)
                    .subscribe((stringMap -> {
                        lincMap.put(ADDBEGIN, stringMap.get(ADDBEGIN));
                        fillView.fillResult(stringMap.get(ADDBEGIN), flag, ADDBEGIN);
                    }));

            callbackResaltSpeedList(list, ADDMIDDL)
                    .subscribe((stringMap -> {
                        lincMap.put(ADDMIDDL, stringMap.get(ADDMIDDL));
                        fillView.fillResult(stringMap.get(ADDMIDDL), flag, ADDMIDDL);
                    }));
            callbackResaltSpeedList(list, ADDEND)
                    .subscribe((stringMap -> {
                        lincMap.put(ADDEND, stringMap.get(ADDEND));
                        fillView.fillResult(stringMap.get(ADDEND), flag, ADDEND);
                    }));

            callbackResaltSpeedList(list, SEARCHLIST)
                    .subscribe((stringMap -> {
                        lincMap.put(SEARCHLIST, stringMap.get(SEARCHLIST));
                        fillView.fillResult(stringMap.get(SEARCHLIST), flag, SEARCHLIST);
                    }));
            callbackResaltSpeedList(list, REMOVEBEGIN)
                    .subscribe((stringMap -> {
                        lincMap.put(REMOVEBEGIN, stringMap.get(REMOVEBEGIN));
                        fillView.fillResult(stringMap.get(REMOVEBEGIN), flag, REMOVEBEGIN);
                    }));
            callbackResaltSpeedList(list, REMOVEMIDDL)
                    .subscribe((stringMap -> {
                        lincMap.put(REMOVEMIDDL, stringMap.get(REMOVEMIDDL));
                        fillView.fillResult(stringMap.get(REMOVEMIDDL), flag, REMOVEMIDDL);
                    }));
            callbackResaltSpeedList(list, REMOVEND)
                    .subscribe((stringMap -> {
                        lincMap.put(REMOVEND, stringMap.get(REMOVEND));
                        fillView.fillResult(stringMap.get(REMOVEND), flag, REMOVEND);
                    }));
        }

        if (flag == TypeCollectin.COPYONWRITE) {
            callbackResaltSpeedList(list, ADDBEGIN)
                    .subscribe((stringMap -> {
                        copyMap.put(ADDBEGIN, stringMap.get(ADDBEGIN));
                        fillView.fillResult(stringMap.get(ADDBEGIN), flag, ADDBEGIN);
                    }));

            callbackResaltSpeedList(list, ADDMIDDL)
                    .subscribe((stringMap -> {
                        copyMap.put(ADDMIDDL, stringMap.get(ADDMIDDL));
                        fillView.fillResult(stringMap.get(ADDMIDDL), flag, ADDMIDDL);
                    }));
            callbackResaltSpeedList(list, ADDEND)
                    .subscribe((stringMap -> {
                        copyMap.put(ADDEND, stringMap.get(ADDEND));
                        fillView.fillResult(stringMap.get(ADDEND), flag, ADDEND);
                    }));

            callbackResaltSpeedList(list, SEARCHLIST)
                    .subscribe((stringMap -> {
                        copyMap.put(SEARCHLIST, stringMap.get(SEARCHLIST));
                        fillView.fillResult(stringMap.get(SEARCHLIST), flag, SEARCHLIST);
                    }));
            callbackResaltSpeedList(list, REMOVEBEGIN)
                    .subscribe((stringMap -> {
                        copyMap.put(REMOVEBEGIN, stringMap.get(REMOVEBEGIN));
                        fillView.fillResult(stringMap.get(REMOVEBEGIN), flag, REMOVEBEGIN);
                    }));
            callbackResaltSpeedList(list, REMOVEMIDDL)
                    .subscribe((stringMap -> {
                copyMap.put(REMOVEMIDDL, stringMap.get(REMOVEMIDDL));
                fillView.fillResult(stringMap.get(REMOVEMIDDL), flag, REMOVEMIDDL);
            }));

            callbackResaltSpeedList(list, REMOVEND)
                    .subscribe((stringMap -> {
                        copyMap.put(REMOVEND, stringMap.get(REMOVEND));
                        fillView.fillResult(stringMap.get(REMOVEND), flag, REMOVEND);
                    }));
        }
    }
}
