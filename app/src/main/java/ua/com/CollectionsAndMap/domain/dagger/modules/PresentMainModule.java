package ua.com.CollectionsAndMap.domain.dagger.modules;

import android.content.Context;


import dagger.Module;
import dagger.Provides;
import ua.com.CollectionsAndMap.ui.presentation.MainPresent;

@Module
public class PresentMainModule {
    @Provides
    public MainPresent getMainPresent(Context context){
        return new MainPresent(context);
    }

}
