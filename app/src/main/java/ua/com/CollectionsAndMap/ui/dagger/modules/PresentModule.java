package ua.com.CollectionsAndMap.ui.dagger.modules;

import android.content.Context;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.com.CollectionsAndMap.ui.presentation.MainPresent;

@Module
public class PresentModule {
    @Provides
    @Singleton
    public MainPresent getMainPresent(Context context){
        return new MainPresent(context);
    }
}
