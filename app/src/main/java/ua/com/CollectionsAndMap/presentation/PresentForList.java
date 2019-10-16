package ua.com.CollectionsAndMap.presentation;

import android.annotation.SuppressLint;

import androidx.lifecycle.LifecycleObserver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.inject.Inject;


import ua.com.CollectionsAndMap.CollOrMap;
import ua.com.CollectionsAndMap.domain.MainViewModul;


import ua.com.CollectionsAndMap.domain.StatData;


import ua.com.CollectionsAndMap.domain.TypeRow;
import ua.com.CollectionsAndMap.domain.FillCollection;

import ua.com.CollectionsAndMap.fragment.FragmentInterfas;
import ua.com.CollectionsAndMap.MainContract;

import static ua.com.CollectionsAndMap.domain.FillView.ActionFill.ADDBEGIN;
import static ua.com.CollectionsAndMap.domain.FillView.ActionFill.ADDEND;
import static ua.com.CollectionsAndMap.domain.FillView.ActionFill.ADDMIDDL;
import static ua.com.CollectionsAndMap.domain.FillView.ActionFill.REMOVEBEGIN;
import static ua.com.CollectionsAndMap.domain.FillView.ActionFill.REMOVEMIDDL;
import static ua.com.CollectionsAndMap.domain.FillView.ActionFill.REMOVEND;
import static ua.com.CollectionsAndMap.domain.FillView.ActionFill.SEARCHLIST;
import static ua.com.CollectionsAndMap.domain.FillView.callbackResaltSpeedList;


public class PresentForList extends BasePresenter  {

    private volatile int queue = 21;


    @Inject
    public PresentForList(MainContract.View view, FragmentInterfas fragmentInterfas) {
        super(view, fragmentInterfas);

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
        StatData.getLiveData().getData(TypeRow.ARRAYLISTADDBEGIN).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.ARRAYLISTADDBEGIN);}));
        StatData.getLiveData().getData(TypeRow.ARRAYLISTADDMIDDLE).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.ARRAYLISTADDMIDDLE);}));
        StatData.getLiveData().getData(TypeRow.ARRAYLISTADDEND).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.ARRAYLISTADDEND);}));
        StatData.getLiveData().getData(TypeRow.ARRAYLISTSEARCH).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.ARRAYLISTSEARCH);}));
        StatData.getLiveData().getData(TypeRow.ARRAYLISTREMOVEBEGIN).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.ARRAYLISTREMOVEBEGIN);}));
        StatData.getLiveData().getData(TypeRow.ARRAYLISTREMOVEMIDDLE).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.ARRAYLISTREMOVEMIDDLE);}));
        StatData.getLiveData().getData(TypeRow.ARRAYLISTREMOVEEND).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.ARRAYLISTREMOVEEND);}));
        StatData.getLiveData().getData(TypeRow.LINKEDLISTADDBEGIN).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.LINKEDLISTADDBEGIN);}));
        StatData.getLiveData().getData(TypeRow.LINKEDLISTADDMIDDLE).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.LINKEDLISTADDMIDDLE);}));
        StatData.getLiveData().getData(TypeRow.LINKEDLISTADDEND).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.LINKEDLISTADDEND);}));
        StatData.getLiveData().getData(TypeRow.LINKEDLISTSEARCH).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.LINKEDLISTSEARCH);}));
        StatData.getLiveData().getData(TypeRow.LINKEDLISTREMOVEBEGIN).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.LINKEDLISTREMOVEBEGIN);}));
        StatData.getLiveData().getData(TypeRow.LINKEDLISTREMOVEMIDDLE).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.LINKEDLISTREMOVEMIDDLE);}));
        StatData.getLiveData().getData(TypeRow.LINKEDLISTREMOVEEND).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.LINKEDLISTREMOVEEND);}));
        StatData.getLiveData().getData(TypeRow.COPYONWRITEADDBEGIN).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.COPYONWRITEADDBEGIN);}));
        StatData.getLiveData().getData(TypeRow.COPYONWRITEADDMIDDLE).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.COPYONWRITEADDMIDDLE);}));
        StatData.getLiveData().getData(TypeRow.COPYONWRITEADDEND).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.COPYONWRITEADDEND);}));
        StatData.getLiveData().getData(TypeRow.COPYONWRITESEARCH).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.COPYONWRITESEARCH);}));
        StatData.getLiveData().getData(TypeRow.COPYONWRITEREMOVEBEGIN).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.COPYONWRITEREMOVEBEGIN);}));
        StatData.getLiveData().getData(TypeRow.COPYONWRITEREMOVEMIDDLE).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.COPYONWRITEREMOVEMIDDLE);}));
        StatData.getLiveData().getData(TypeRow.COPYONWRITEREMOVEEND).observe(fragmentInterfas.getOwn(),(s -> {
            fragmentInterfas.fillResult(s,TypeRow.COPYONWRITEREMOVEEND);}));
    }

    @Override
    public  void  onCalculation(int amauntElemants) {

        FillCollection.getFlowableCollection(amauntElemants, CollOrMap.ARREY)
                .subscribe((list)->callbackFromListModel((ArrayList)list, CollOrMap.ARREY));
        FillCollection.getFlowableCollection(amauntElemants, CollOrMap.LINKED)
                .subscribe((list)->callbackFromListModel((LinkedList)list, CollOrMap.LINKED));
        FillCollection.getFlowableCollection(amauntElemants, CollOrMap.COPYONWRITE)
                .subscribe((list)->callbackFromListModel((CopyOnWriteArrayList)list, CollOrMap.COPYONWRITE));

    }


    @SuppressLint("CheckResult")
    public void callbackFromListModel(List<Integer> list, CollOrMap flag) {
        if (flag == CollOrMap.ARREY) {
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

        if (flag == CollOrMap.LINKED) {
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

        if (flag == CollOrMap.COPYONWRITE) {
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
