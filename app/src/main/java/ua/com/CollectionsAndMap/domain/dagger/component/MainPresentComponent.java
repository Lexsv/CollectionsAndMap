package ua.com.CollectionsAndMap.domain.dagger.component;

import dagger.Component;
import ua.com.CollectionsAndMap.domain.dagger.provid.ProvidMainContractView;
import ua.com.CollectionsAndMap.ui.mainaactivity.MainActivity;
import ua.com.CollectionsAndMap.domain.dagger.modules.PresentMainModule;
import ua.com.CollectionsAndMap.domain.dagger.provid.ProvidFillView;

@Component(modules = {PresentMainModule.class, ProvidFillView.class, ProvidMainContractView.class})
public interface MainPresentComponent {
   void  inject(MainActivity activity);

}
