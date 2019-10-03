package ua.com.CollectionsAndMap.ui.presentation;

import java.util.Map;
import ua.com.CollectionsAndMap.data.DataSharedPreferences;
import ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill;
import ua.com.CollectionsAndMap.ui.fragment.innterfasFragment.FillView;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract.Presenter;

public abstract class BasePresenter  implements Presenter{

    protected   FillView fillView;
    protected DataSharedPreferences preferences;
    private MainContract.View presentor;


    public BasePresenter(MainContract.View view, FillView fillView) {
        this.presentor = view;
        this.preferences = DataSharedPreferences.getDataSharedPref();
        this.fillView = fillView;
    }

    void hidProgress(){ presentor.hidProgress();}
    public abstract void  finishCalcul();

    public abstract Map<ActionFill, String> getData(TypeCollectin typeCollectin);
    public abstract void saveData() ;
}
