package ua.com.CollectionsAndMap.domain.dagger.provid;

import dagger.Module;
import dagger.Provides;
import ua.com.CollectionsAndMap.ui.fragment.TabCollection;
import ua.com.CollectionsAndMap.ui.fragment.innterfasFragment.FillView;

@Module
public class ProvidFillView {
    private FillView fillView;

    public ProvidFillView(FillView fillView) {
        this.fillView =fillView;

    }

    @Provides
    FillView getFillView(){
        return fillView;
    }
}
