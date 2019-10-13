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
    public void fillView() {
        StatData.getLiveData().getData(TypeRow.ARRAYLISTADDBEGIN).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.ARRAYLISTADDBEGIN);}));
        StatData.getLiveData().getData(TypeRow.ARRAYLISTADDMIDDLE).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.ARRAYLISTADDMIDDLE);}));
        StatData.getLiveData().getData(TypeRow.ARRAYLISTADDEND).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.ARRAYLISTADDEND);}));
        StatData.getLiveData().getData(TypeRow.ARRAYLISTSEARCH).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.ARRAYLISTSEARCH);}));
        StatData.getLiveData().getData(TypeRow.ARRAYLISTREMOVEBEGIN).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.ARRAYLISTREMOVEBEGIN);}));
        StatData.getLiveData().getData(TypeRow.ARRAYLISTREMOVEMIDDLE).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.ARRAYLISTREMOVEMIDDLE);}));
        StatData.getLiveData().getData(TypeRow.ARRAYLISTREMOVEEND).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.ARRAYLISTREMOVEEND);}));
        StatData.getLiveData().getData(TypeRow.LINKEDLISTADDBEGIN).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.LINKEDLISTADDBEGIN);}));
        StatData.getLiveData().getData(TypeRow.LINKEDLISTADDMIDDLE).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.LINKEDLISTADDMIDDLE);}));
        StatData.getLiveData().getData(TypeRow.LINKEDLISTADDEND).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.LINKEDLISTADDEND);}));
        StatData.getLiveData().getData(TypeRow.LINKEDLISTSEARCH).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.LINKEDLISTSEARCH);}));
        StatData.getLiveData().getData(TypeRow.LINKEDLISTREMOVEBEGIN).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.LINKEDLISTREMOVEBEGIN);}));
        StatData.getLiveData().getData(TypeRow.LINKEDLISTREMOVEMIDDLE).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.LINKEDLISTREMOVEMIDDLE);}));
        StatData.getLiveData().getData(TypeRow.LINKEDLISTREMOVEEND).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.LINKEDLISTREMOVEEND);}));
        StatData.getLiveData().getData(TypeRow.COPYONWRITEADDBEGIN).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.COPYONWRITEADDBEGIN);}));
        StatData.getLiveData().getData(TypeRow.COPYONWRITEADDMIDDLE).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.COPYONWRITEADDMIDDLE);}));
        StatData.getLiveData().getData(TypeRow.COPYONWRITEADDEND).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.COPYONWRITEADDEND);}));
        StatData.getLiveData().getData(TypeRow.COPYONWRITESEARCH).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.COPYONWRITESEARCH);}));
        StatData.getLiveData().getData(TypeRow.COPYONWRITEREMOVEBEGIN).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.COPYONWRITEREMOVEBEGIN);}));
        StatData.getLiveData().getData(TypeRow.COPYONWRITEREMOVEMIDDLE).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.COPYONWRITEREMOVEMIDDLE);}));
        StatData.getLiveData().getData(TypeRow.COPYONWRITEREMOVEEND).observe(fillView.getOwn(),(s -> {fillView.fillResult(s,TypeRow.COPYONWRITEREMOVEEND);}));
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
                        finishCalcul();
                    }));

            callbackResaltSpeedList(list, ADDMIDDL)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDMIDDL), TypeRow.ARRAYLISTADDMIDDLE);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, ADDEND)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDEND), TypeRow.ARRAYLISTADDEND);
                        finishCalcul();
                    }));

            callbackResaltSpeedList(list, SEARCHLIST)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(SEARCHLIST), TypeRow.ARRAYLISTSEARCH);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, REMOVEBEGIN)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEBEGIN), TypeRow.ARRAYLISTREMOVEBEGIN);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, REMOVEMIDDL)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEMIDDL), TypeRow.ARRAYLISTREMOVEMIDDLE);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, REMOVEND)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEND), TypeRow.ARRAYLISTREMOVEEND);
                        finishCalcul();
                    }));
        }

        if (flag == TypeCollectin.LINKED) {
            callbackResaltSpeedList(list, ADDBEGIN)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDBEGIN), TypeRow.LINKEDLISTADDBEGIN);
                        finishCalcul();
                    }));

            callbackResaltSpeedList(list, ADDMIDDL)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDMIDDL), TypeRow.LINKEDLISTADDMIDDLE);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, ADDEND)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDEND), TypeRow.LINKEDLISTADDEND);
                        finishCalcul();
                    }));

            callbackResaltSpeedList(list, SEARCHLIST)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(SEARCHLIST), TypeRow.LINKEDLISTSEARCH);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, REMOVEBEGIN)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEBEGIN), TypeRow.LINKEDLISTREMOVEBEGIN);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, REMOVEMIDDL)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEMIDDL), TypeRow.LINKEDLISTREMOVEMIDDLE);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, REMOVEND)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEND), TypeRow.LINKEDLISTREMOVEEND);
                        finishCalcul();
                    }));
        }

        if (flag == TypeCollectin.COPYONWRITE) {
            callbackResaltSpeedList(list, ADDBEGIN)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDBEGIN), TypeRow.COPYONWRITEADDBEGIN);
                        finishCalcul();
                    }));

            callbackResaltSpeedList(list, ADDMIDDL)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(ADDMIDDL), TypeRow.COPYONWRITEADDMIDDLE);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, ADDEND)
                    .subscribe((stringMap -> {

                        StatData.getLiveData().setStatData(stringMap.get(ADDEND), TypeRow.COPYONWRITEADDEND);
                        finishCalcul();
                    }));

            callbackResaltSpeedList(list, SEARCHLIST)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(SEARCHLIST), TypeRow.COPYONWRITESEARCH);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, REMOVEBEGIN)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEBEGIN), TypeRow.COPYONWRITEREMOVEBEGIN);
                        finishCalcul();
                    }));
            callbackResaltSpeedList(list, REMOVEMIDDL)
                    .subscribe((stringMap -> {
                StatData.getLiveData().setStatData(stringMap.get(REMOVEMIDDL), TypeRow.COPYONWRITEREMOVEMIDDLE);
                finishCalcul();
            }));

            callbackResaltSpeedList(list, REMOVEND)
                    .subscribe((stringMap -> {
                        StatData.getLiveData().setStatData(stringMap.get(REMOVEND), TypeRow.COPYONWRITEREMOVEEND);
                        finishCalcul();
                    }));
        }
    }
}
