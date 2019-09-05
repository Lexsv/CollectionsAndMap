package ua.com.CollectionsAndMap.ui.dagger.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModul {
    private Context context;

    public AppModul(Context context) {
        this.context = context;

    }

    @Provides
    @Singleton
    Context getContext(){
        return context;
    }
}
