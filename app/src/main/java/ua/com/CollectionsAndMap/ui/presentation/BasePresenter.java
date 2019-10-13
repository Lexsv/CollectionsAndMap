package ua.com.CollectionsAndMap.ui.presentation;

import ua.com.CollectionsAndMap.ui.fragment.innterfasFragment.FillView;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract.Presenter;

public abstract class BasePresenter  implements Presenter{

    protected   FillView fillView;

    protected MainContract.View view;

    public void setFillView(FillView fillView) {
        this.fillView = fillView;
    }

    public void setView(MainContract.View view) {
        this.view = view;
    }

    public FillView getFillView() {
        return fillView;
    }

    public MainContract.View getView() {
        return view;
    }

    public BasePresenter(MainContract.View view, FillView fillView) {
        this.view = view;
        this.fillView = fillView;
    }

    void hidProgress(){ view.hidProgress();}
    public abstract void  finishCalcul();


}
