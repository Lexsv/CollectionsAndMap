package ua.com.CollectionsAndMap.ui.presentation;

import android.annotation.SuppressLint;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;

import androidx.lifecycle.OnLifecycleEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ua.com.CollectionsAndMap.data.StatData;
import ua.com.CollectionsAndMap.data.TypeRow;
import ua.com.CollectionsAndMap.domain.model.ListModel.ArrayListModel;
import ua.com.CollectionsAndMap.domain.model.ListModel.CopyOnWriteModel;
import ua.com.CollectionsAndMap.domain.model.ListModel.LinkedListModel;
import ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill;
import ua.com.CollectionsAndMap.ui.fragment.innterfasFragment.FillView;
import ua.com.CollectionsAndMap.ui.mainaactivity.MainViewModul;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;

import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.ADDBEGIN;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.ADDEND;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.ADDMIDDL;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.REMOVEBEGIN;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.REMOVEMIDDL;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.REMOVEND;
import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill.SEARCHLIST;
import static ua.com.CollectionsAndMap.domain.utils.FillView.callbackResaltSpeedList;


public class PresentForList extends BasePresenter implements LifecycleObserver {

    private volatile int queue = 21;


    @Inject
    public PresentForList(MainContract.View view, FillView fillView) {
        super(view,fillView);

    }

    @Override
    public void finishCalcul() {
        queue--;
        if (queue == 0){
            hidProgress();
            MainViewModul.getMainViewModul().progress = !MainViewModul.getMainViewModul().progress;
            queue = 21;
        }

    }

    @Override
    public  void  onCalculation(int amauntElemants) {
        new CopyOnWriteModel(amauntElemants, this).start();
        new LinkedListModel(amauntElemants, this).start();
        new ArrayListModel(amauntElemants, this).start();
    }


    @SuppressLint("CheckResult")
    public void callbackFromListModel(List<Integer> list, TypeCollectin flag) {
        if (flag == TypeCollectin.ARREY) {
            callbackResaltSpeedList(list,ADDBEGIN)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDBEGIN), TypeRow.ARRAYLISTADDBEGIN);
                        //fillView.fillResult(stringMap.get(ADDBEGIN), flag, ADDBEGIN);
                        finishCalcul();
                    }));

            callbackResaltSpeedList(list, ADDMIDDL)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDMIDDL), TypeRow.ARRAYLISTADDMIDDLE);
                        //fillView.fillResult(stringMap.get(ADDMIDDL), flag, ADDMIDDL);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, ADDEND)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDEND), TypeRow.ARRAYLISTADDEND);
                        //fillView.fillResult(stringMap.get(ADDEND), flag, ADDEND);
                        finishCalcul();
                    }));

            callbackResaltSpeedList(list, SEARCHLIST)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(SEARCHLIST), TypeRow.ARRAYLISTSEARCH);
                        //fillView.fillResult(stringMap.get(SEARCHLIST), flag, SEARCHLIST);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, REMOVEBEGIN)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEBEGIN), TypeRow.ARRAYLISTREMOVEBEGIN);
                        //fillView.fillResult(stringMap.get(REMOVEBEGIN), flag, REMOVEBEGIN);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, REMOVEMIDDL)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEMIDDL), TypeRow.ARRAYLISTREMOVEMIDDLE);
                        //fillView.fillResult(stringMap.get(REMOVEMIDDL), flag, REMOVEMIDDL);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, REMOVEND)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEND), TypeRow.ARRAYLISTREMOVEEND);
                        //fillView.fillResult(stringMap.get(REMOVEND), flag, REMOVEND);
                        finishCalcul();
                    }));
        }

        if (flag == TypeCollectin.LINKED) {
            callbackResaltSpeedList(list, ADDBEGIN)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDBEGIN), TypeRow.LINKEDLISTADDBEGIN);
                        //fillView.fillResult(stringMap.get(ADDBEGIN), flag, ADDBEGIN);
                        finishCalcul();
                    }));

            callbackResaltSpeedList(list, ADDMIDDL)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDMIDDL), TypeRow.LINKEDLISTADDMIDDLE);
                        //fillView.fillResult(stringMap.get(ADDMIDDL), flag, ADDMIDDL);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, ADDEND)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDEND), TypeRow.LINKEDLISTADDEND);
                        //fillView.fillResult(stringMap.get(ADDEND), flag, ADDEND);
                        finishCalcul();
                    }));

            callbackResaltSpeedList(list, SEARCHLIST)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(SEARCHLIST), TypeRow.LINKEDLISTSEARCH);
                        //fillView.fillResult(stringMap.get(SEARCHLIST), flag, SEARCHLIST);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, REMOVEBEGIN)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEBEGIN), TypeRow.LINKEDLISTREMOVEBEGIN);
                        //fillView.fillResult(stringMap.get(REMOVEBEGIN), flag, REMOVEBEGIN);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, REMOVEMIDDL)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEMIDDL), TypeRow.LINKEDLISTREMOVEMIDDLE);
                        //fillView.fillResult(stringMap.get(REMOVEMIDDL), flag, REMOVEMIDDL);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, REMOVEND)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEND), TypeRow.LINKEDLISTREMOVEEND);
                        //fillView.fillResult(stringMap.get(REMOVEND), flag, REMOVEND);
                        finishCalcul();
                    }));
        }

        if (flag == TypeCollectin.COPYONWRITE) {
            callbackResaltSpeedList(list, ADDBEGIN)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDBEGIN), TypeRow.COPYONWRITEADDBEGIN);
                        //fillView.fillResult(stringMap.get(ADDBEGIN), flag, ADDBEGIN);
                        finishCalcul();
                    }));

            callbackResaltSpeedList(list, ADDMIDDL)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDMIDDL), TypeRow.COPYONWRITEADDMIDDLE);
                        //fillView.fillResult(stringMap.get(ADDMIDDL), flag, ADDMIDDL);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, ADDEND)
                    .subscribe((stringMap -> {

                        StatData.getLiveData().setStatData(stringMap.get(ADDEND), TypeRow.COPYONWRITEADDEND);
                        //fillView.fillResult(stringMap.get(ADDEND), flag, ADDEND);
                        finishCalcul();
                    }));

            callbackResaltSpeedList(list, SEARCHLIST)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(SEARCHLIST), TypeRow.COPYONWRITESEARCH);
                        //fillView.fillResult(stringMap.get(SEARCHLIST), flag, SEARCHLIST);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, REMOVEBEGIN)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEBEGIN), TypeRow.COPYONWRITEREMOVEBEGIN);
                        //fillView.fillResult(stringMap.get(REMOVEBEGIN), flag, REMOVEBEGIN);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, REMOVEMIDDL)
                    .subscribe((stringMap -> {
                StatData.getLiveData().setStatData(stringMap.get(REMOVEMIDDL), TypeRow.COPYONWRITEREMOVEMIDDLE);
                //fillView.fillResult(stringMap.get(REMOVEMIDDL), flag, REMOVEMIDDL);
                finishCalcul();
            }));

            callbackResaltSpeedList(list, REMOVEND)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEND), TypeRow.COPYONWRITEREMOVEEND);
                        //fillView.fillResult(stringMap.get(REMOVEND), flag, REMOVEND);
                        finishCalcul();
                    }));
        }
    }
}
