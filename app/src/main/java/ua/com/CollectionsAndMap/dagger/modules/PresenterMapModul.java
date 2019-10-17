package ua.com.CollectionsAndMap.dagger.modules;

import dagger.Module;
import dagger.Provides;

import ua.com.CollectionsAndMap.fragment.FragmentInterfas;

import ua.com.CollectionsAndMap.domain.MainViewModul;
import ua.com.CollectionsAndMap.presentation.PresentForMap;
import ua.com.CollectionsAndMap.MainContract;

@Module
public class PresenterMapModul {
    private PresentForMap presentForMap;
    private MainContract.Presenter presenter;


    @Provides
    public MainContract.Presenter getpresentForMap(MainContract.View view, FragmentInterfas fragmentInterfas) {

        if (MainViewModul.getMainViewModul().getPresentForMap() == null) {
            presentForMap = new PresentForMap(view, fragmentInterfas);
            MainViewModul.getMainViewModul().setPresentForMap(presentForMap);
            presenter = presentForMap;
            return presenter;
        } else {
            presentForMap = MainViewModul.getMainViewModul().getPresentForMap();
            presentForMap.setView(view);
            presentForMap.setFragmentInterfas(fragmentInterfas);
            presenter = presentForMap;
            return presenter;
        }

    }

}

