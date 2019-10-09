package ua.com.CollectionsAndMap.ui.presentation;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import javax.inject.Inject;

import ua.com.CollectionsAndMap.data.DataSharedPreferences;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;


public  class MainPresent implements MainContract.MainPrisenter, LifecycleObserver {

    private MainContract.View viewMain;

    @Inject
    public MainPresent(MainContract.View progress) {
        this.viewMain = progress;
    }


    @Override
    public void onCalculation(int amauntElemant) {
       viewMain.showProgress();
       viewMain.getPressentr().onCalculation(amauntElemant);
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() { viewMain = null; }

    @Override
    public void destroyCalcuiation() {
        viewMain.getPressentr().dispose();
        DataSharedPreferences.getDataSharedPref().removSharedPreferences();
    }

}
