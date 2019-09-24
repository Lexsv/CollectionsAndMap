package ua.com.CollectionsAndMap.domain.dagger.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import ua.com.CollectionsAndMap.ui.fragment.TabMap;
import ua.com.CollectionsAndMap.ui.presentation.PresentForMap;

@Module
public class PresenterMapModul {
    private static PresentForMap presentForMap;
    @Provides
    public PresentForMap getpresentForMap (Context context, TabMap tabMap){
        presentForMap = new PresentForMap(context,tabMap);
        return presentForMap;
    }

    public static PresentForMap getPresentForMap() {
        return presentForMap;
    }
}

