package ua.com.CollectionsAndMap.ui.presentation;

import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import java.util.Map;
import ua.com.CollectionsAndMap.data.DataSharedPreferences;
import ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract.Presenter;

public abstract class BasePresenter  implements Presenter{
    protected DataSharedPreferences preferences;
    private MainContract.View hidProgress;


    public BasePresenter(Context context) {
        this.hidProgress = (MainContract.View) context;
        this.preferences = DataSharedPreferences.getDataSharedPref();
    }

    void hidProgress(){ hidProgress.hidProgress();}


    public abstract Map<ActionFill, String> getData(TypeCollectin typeCollectin);
    public abstract void startNext();
    public abstract void saveData() ;
}
