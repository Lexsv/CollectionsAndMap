package ua.com.CollectionsAndMap.domain.dagger.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

import ua.com.CollectionsAndMap.ui.fragment.innterfasFragment.FillView;

import ua.com.CollectionsAndMap.ui.mainaactivity.MainViewModul;
import ua.com.CollectionsAndMap.ui.presentation.PresentForMap;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;

@Module
public class PresenterMapModul {
    private PresentForMap presentForMap;

    @Provides
    public PresentForMap getpresentForMap(MainContract.View view, FillView fillView) {

        if (MainViewModul.getMainViewModul().getPresentForMap() == null) {
            presentForMap = new PresentForMap(view, fillView);
            MainViewModul.getMainViewModul().setPresentForMap(presentForMap);
            return presentForMap;
        } else {
            presentForMap = MainViewModul.getMainViewModul().getPresentForMap();
            presentForMap.setView(view);
            presentForMap.setFillView(fillView);
            return presentForMap;
        }

    }

}

