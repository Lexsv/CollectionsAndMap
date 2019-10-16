package ua.com.CollectionsAndMap.dagger.component;


import dagger.Component;
import ua.com.CollectionsAndMap.dagger.modules.PresenterMapModul;
import ua.com.CollectionsAndMap.dagger.provid.ProvidFragmentInterfas;
import ua.com.CollectionsAndMap.dagger.provid.ProvidMainContractView;
import ua.com.CollectionsAndMap.fragment.TabMap;

@Component(modules = {ProvidFragmentInterfas.class, PresenterMapModul.class, ProvidMainContractView.class})
public interface PresentMap {
    void  inject(TabMap tabMap);
}
