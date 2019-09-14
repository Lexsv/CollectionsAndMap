package ua.com.CollectionsAndMap.ui.presentation;

import android.content.Context;
import javax.inject.Inject;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainPresenter;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.Presenter;
import ua.com.CollectionsAndMap.ui.MainActivity;
import ua.com.CollectionsAndMap.ui.fragment.TabCollection;
import ua.com.CollectionsAndMap.ui.fragment.TabMap;


public  class MainPresent implements MainPresenter {

    private MainActivity activity;



    @Inject
    public MainPresent(Context activity) {
        this.activity = (MainActivity) activity;
    }

    @Override
    public void onCalculation(int position,int amauntElemant) {
        if (position == 0 && amauntElemant > 0) {
            activity.shoeProgress();
            Presenter presenterForList = TabCollection.getPresent();
            presenterForList.onCalculation(amauntElemant);}

        if (position == 1 && amauntElemant > 0){
            activity.shoeProgress();
            Presenter presenterForMap =  TabMap.getPresent();
            presenterForMap.onCalculation(amauntElemant);
        }
    }


    public void onDestroy() {
        activity = null;
    }

}
