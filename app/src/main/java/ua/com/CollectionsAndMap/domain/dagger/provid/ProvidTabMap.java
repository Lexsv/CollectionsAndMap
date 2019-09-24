package ua.com.CollectionsAndMap.domain.dagger.provid;

import dagger.Module;
import dagger.Provides;
import ua.com.CollectionsAndMap.ui.fragment.TabMap;

@Module
public class ProvidTabMap {
    private TabMap tabMap;

    public ProvidTabMap(TabMap tabMap) {
        this.tabMap = tabMap;

    }

    @Provides
    TabMap getTabCollection(){
        return tabMap;
    }
}
