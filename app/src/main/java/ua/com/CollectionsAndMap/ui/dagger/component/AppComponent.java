package ua.com.CollectionsAndMap.ui.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import ua.com.CollectionsAndMap.ui.MainActivity;
import ua.com.CollectionsAndMap.ui.dagger.modules.AppModul;
import ua.com.CollectionsAndMap.ui.dagger.modules.PresentModule;

@Component(modules = {AppModul.class, PresentModule.class})
@Singleton
public interface AppComponent {
   void  inject(MainActivity activity);
}
