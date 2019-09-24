package ua.com.CollectionsAndMap.domain.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import ua.com.CollectionsAndMap.ui.MainActivity;
import ua.com.CollectionsAndMap.domain.dagger.provid.AppModul;
import ua.com.CollectionsAndMap.domain.dagger.modules.PresentListModul;
import ua.com.CollectionsAndMap.domain.dagger.modules.PresentMainModule;
import ua.com.CollectionsAndMap.domain.dagger.provid.ProvidTabCollection;

@Component(modules = {AppModul.class, PresentMainModule.class, ProvidTabCollection.class, PresentListModul.class})
public interface MainPresentComponent {
   void  inject(MainActivity activity);

}
