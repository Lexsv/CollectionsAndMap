package ua.com.CollectionsAndMap.domain.dagger.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

import ua.com.CollectionsAndMap.ui.fragment.innterfasFragment.FillView;
import ua.com.CollectionsAndMap.ui.presentation.PresentForList;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;

@Module
public class PresentListModul {

    @Provides
    public PresentForList getPresentForList(MainContract.View view, FillView fillView){
        return new PresentForList(view, fillView);}


}
