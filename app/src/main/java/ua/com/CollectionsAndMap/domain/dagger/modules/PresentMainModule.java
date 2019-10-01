package ua.com.CollectionsAndMap.domain.dagger.modules;

import android.content.Context;


import dagger.Module;
import dagger.Provides;
import ua.com.CollectionsAndMap.ui.presentation.MainPresent;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;

@Module
public class PresentMainModule {
    @Provides
    public MainPresent getMainPresent(MainContract.View view){
        return new MainPresent(view);
    }

}
