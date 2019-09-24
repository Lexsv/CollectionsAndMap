package ua.com.CollectionsAndMap.domain.dagger.provid;

import dagger.Module;
import dagger.Provides;
import ua.com.CollectionsAndMap.ui.fragment.TabCollection;

@Module
public class ProvidTabCollection {
    private TabCollection tabCollection;

    public ProvidTabCollection(TabCollection tabCollection) {
        this.tabCollection = tabCollection;

    }

    @Provides
    TabCollection getTabCollection(){
        return tabCollection;
    }
}
