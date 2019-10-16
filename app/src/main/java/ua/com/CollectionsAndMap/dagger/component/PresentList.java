package ua.com.CollectionsAndMap.dagger.component;



import dagger.Component;

import ua.com.CollectionsAndMap.dagger.modules.PresentListModul;
import ua.com.CollectionsAndMap.dagger.provid.ProvidFragmentInterfas;
import ua.com.CollectionsAndMap.dagger.provid.ProvidMainContractView;
import ua.com.CollectionsAndMap.fragment.TabCollection;



@Component(modules = {ProvidFragmentInterfas.class,  PresentListModul.class, ProvidMainContractView.class})
public interface PresentList {
    void  inject(TabCollection tabCollection);


}
