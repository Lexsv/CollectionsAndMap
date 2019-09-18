package ua.com.CollectionsAndMap.ui.presentation;

import java.util.Map;

import ua.com.CollectionsAndMap.data.DataSharedPreferences;
import ua.com.CollectionsAndMap.ui.MainActivity;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract.Presenter;

public abstract class BasePresenter implements Presenter{
    protected DataSharedPreferences preferences;
    private MainContract.View hidProgress;

    public BasePresenter(MainActivity activity) {
        this.hidProgress = activity;
        this.preferences = DataSharedPreferences.getDataSharedPref();
    }

    void hidProgress(){ hidProgress.hidProgress();}

    public abstract Map<Integer, String> getData();
    public abstract void startNext();
    public abstract void saveData(Map<Integer, String> data) ;
}
