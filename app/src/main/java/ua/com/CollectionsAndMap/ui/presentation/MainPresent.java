package ua.com.CollectionsAndMap.ui.presentation;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import javax.inject.Inject;

import ua.com.CollectionsAndMap.ui.mainaactivity.MainViewModul;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;


public  class MainPresent implements MainContract.MainPrisenter, LifecycleObserver {

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

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() { viewMain = null; }

    public void setViewMain(MainContract.View viewMain){
        this.viewMain = viewMain;
    }

}
