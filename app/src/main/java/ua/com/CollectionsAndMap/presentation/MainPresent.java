package ua.com.CollectionsAndMap.presentation;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import javax.inject.Inject;

import ua.com.CollectionsAndMap.domain.MainViewModul;
import ua.com.CollectionsAndMap.MainContract;


public  class MainPresent implements MainContract.MainPrisenter {

    private MainContract.View viewMain;

    @Inject
    public MainPresent(MainContract.View progress) {
        this.viewMain = progress;
    }


    @Override
    public void onCalculation(int amauntElemant) {
        if (viewMain.getItom() ==0){MainViewModul.getMainViewModul().getPresentForList().onCalculation(amauntElemant);}
        if (viewMain.getItom() ==1){MainViewModul.getMainViewModul().getPresentForMap().onCalculation(amauntElemant);}
        viewMain.showProgress();
        MainViewModul.getMainViewModul().progress = !MainViewModul.getMainViewModul().progress;
    }

    public void setViewMain(MainContract.View viewMain){
        this.viewMain = viewMain;
    }

}
