package ua.com.CollectionsAndMap.domain.dagger.component;

import dagger.Component;
import ua.com.CollectionsAndMap.domain.dagger.modules.PresentListModul;
import ua.com.CollectionsAndMap.domain.dagger.modules.PresenterMapModul;
import ua.com.CollectionsAndMap.domain.dagger.provid.AppModul;
import ua.com.CollectionsAndMap.domain.dagger.provid.ProvidTabMap;
import ua.com.CollectionsAndMap.ui.fragment.TabMap;

@Component(modules = {AppModul.class, ProvidTabMap.class, PresenterMapModul.class})
public interface PresentMapComponent {
    void  inject(TabMap tabMap);
}
