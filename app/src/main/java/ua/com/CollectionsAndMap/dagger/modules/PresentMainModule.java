package ua.com.CollectionsAndMap.dagger.modules;


import dagger.Module;
import dagger.Provides;
import ua.com.CollectionsAndMap.domain.MainViewModul;
import ua.com.CollectionsAndMap.presentation.MainPresent;
import ua.com.CollectionsAndMap.MainContract;

@Module
public class PresentMainModule {
    private MainPresent mainPresent;
    private  MainContract.MainPrisenter presenter;

    @Provides
    public MainContract.MainPrisenter getMainPresent(MainContract.View view){
        if (MainViewModul.getMainViewModul().getMainPresent() == null){
            mainPresent = new MainPresent(view);
            MainViewModul.getMainViewModul().setMainPresent(mainPresent);
            presenter = mainPresent;
            return presenter;
        }
        mainPresent =  MainViewModul.getMainViewModul().getMainPresent();
        mainPresent.setViewMain(view);
        presenter = mainPresent;
        return presenter;
    }

}
