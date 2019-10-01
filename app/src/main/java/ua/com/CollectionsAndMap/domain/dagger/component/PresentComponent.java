package ua.com.CollectionsAndMap.domain.dagger.component;



import dagger.Component;
import ua.com.CollectionsAndMap.domain.dagger.modules.PresenterMapModul;
import ua.com.CollectionsAndMap.domain.dagger.modules.PresentListModul;
import ua.com.CollectionsAndMap.domain.dagger.provid.ProvidFillView;
import ua.com.CollectionsAndMap.domain.dagger.provid.ProvidMainContractView;
import ua.com.CollectionsAndMap.ui.fragment.TabCollection;
import ua.com.CollectionsAndMap.ui.fragment.TabMap;


@Component(modules = {ProvidFillView.class, PresenterMapModul.class, PresentListModul.class, ProvidMainContractView.class})
public interface PresentComponent {
    void  inject(TabCollection tabCollection);
    void  inject(TabMap tabMap);

}
