package ua.com.CollectionsAndMap.dagger.component;

import dagger.Component;
import ua.com.CollectionsAndMap.dagger.provid.ProvidMainContractView;
import ua.com.CollectionsAndMap.MainActivity;
import ua.com.CollectionsAndMap.dagger.modules.PresentMainModule;
import ua.com.CollectionsAndMap.dagger.provid.ProvidFragmentInterfas;

@Component(modules = {PresentMainModule.class, ProvidFragmentInterfas.class, ProvidMainContractView.class})
public interface MainPresentComponent {
   void  inject(MainActivity activity);

}
