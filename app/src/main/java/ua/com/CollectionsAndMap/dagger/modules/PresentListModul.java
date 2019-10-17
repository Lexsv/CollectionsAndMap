package ua.com.CollectionsAndMap.dagger.modules;

import dagger.Module;
import dagger.Provides;

import ua.com.CollectionsAndMap.fragment.FragmentInterfas;
import ua.com.CollectionsAndMap.domain.MainViewModul;
import ua.com.CollectionsAndMap.presentation.PresentForList;
import ua.com.CollectionsAndMap.MainContract;
import ua.com.CollectionsAndMap.presentation.PresentForMap;

@Module
public class PresentListModul {
    private PresentForList presentForList;
    private MainContract.Presenter presenter;

    @Provides
    public MainContract.Presenter getPresentForList(MainContract.View view, FragmentInterfas fragmentInterfas) {
        if (MainViewModul.getMainViewModul().getPresentForList() == null) {
            presentForList = new PresentForList(view, fragmentInterfas);
            MainViewModul.getMainViewModul().setPresentForList(presentForList);
            presenter = presentForList;
            return presenter;
        } else {
            presentForList = MainViewModul.getMainViewModul().getPresentForList();
            presentForList.setView(view);
            presentForList.setFragmentInterfas(fragmentInterfas);
            presenter = presentForList;
            return presenter;
        }

    }


}
