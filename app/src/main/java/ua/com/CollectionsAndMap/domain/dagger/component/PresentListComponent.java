package ua.com.CollectionsAndMap.domain.dagger.component;



import dagger.Component;
import ua.com.CollectionsAndMap.domain.dagger.provid.AppModul;
import ua.com.CollectionsAndMap.domain.dagger.modules.PresentListModul;
import ua.com.CollectionsAndMap.domain.dagger.provid.ProvidTabCollection;
import ua.com.CollectionsAndMap.ui.fragment.TabCollection;


@Component(modules = {AppModul.class, ProvidTabCollection.class, PresentListModul.class})
public interface PresentListComponent {
    void  inject(TabCollection tabCollection);

}
