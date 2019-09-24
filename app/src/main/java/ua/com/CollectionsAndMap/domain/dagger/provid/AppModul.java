package ua.com.CollectionsAndMap.domain.dagger.provid;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModul {
    private Context context;

    public AppModul(Context context) {
        this.context = context;

    }

    @Provides
    Context getContext(){
        return context;
    }
}
