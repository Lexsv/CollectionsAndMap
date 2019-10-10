package ua.com.CollectionsAndMap.ui.presentation;

import java.util.Map;

import ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill;
import ua.com.CollectionsAndMap.ui.fragment.innterfasFragment.FillView;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract.Presenter;

public abstract class BasePresenter  implements Presenter{

    protected   FillView fillView;

    private MainContract.View presentor;


    public BasePresenter(MainContract.View view, FillView fillView) {
        this.presentor = view;
        this.fillView = fillView;
    }

    void hidProgress(){ presentor.hidProgress();}
    public abstract void  finishCalcul();


}
