package ua.com.CollectionsAndMap.ui.presentation;

import android.content.Context;
import javax.inject.Inject;

import ua.com.CollectionsAndMap.domain.dagger.modules.PresentListModul;
import ua.com.CollectionsAndMap.domain.dagger.modules.PresenterMapModul;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;
import ua.com.CollectionsAndMap.ui.MainActivity;


public  class MainPresent implements MainContract.MainPrisenter {

    private MainContract.View progress;

    @Inject
    public MainPresent(Context activity) {
        this.progress =(MainActivity) activity;
    }


    @Override
    public void onCalculation(int position,int amauntElemant) {
        if (position == 0 && amauntElemant > 0) {
            progress.showProgress();

            MainContract.Presenter presenterForList = PresentListModul.getPresentForList();
            presenterForList.onCalculation(amauntElemant);
        }

        if (position == 1 && amauntElemant > 0){
            progress.showProgress();
            MainContract.Presenter presenterForMap = PresenterMapModul.getPresentForMap();
            presenterForMap.onCalculation(amauntElemant);
        }
    }

    @Override
    public void onDestroy() {
        progress = null;
    }

}
