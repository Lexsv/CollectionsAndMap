package ua.com.CollectionsAndMap.domain.dagger.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import ua.com.CollectionsAndMap.ui.fragment.TabCollection;
import ua.com.CollectionsAndMap.ui.presentation.PresentForList;

@Module
public class PresentListModul {
    private static PresentForList presentForList;
    @Provides
    public PresentForList getPresentForList(Context context, TabCollection tabCollection){
        presentForList =  new PresentForList(context, tabCollection);
        return presentForList;}

    public static PresentForList getPresentForList() {
        return presentForList;
    }
}
