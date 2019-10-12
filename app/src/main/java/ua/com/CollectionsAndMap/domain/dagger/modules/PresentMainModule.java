package ua.com.CollectionsAndMap.domain.dagger.modules;

import android.content.Context;


import dagger.Module;
import dagger.Provides;
import ua.com.CollectionsAndMap.ui.mainaactivity.MainViewModul;
import ua.com.CollectionsAndMap.ui.presentation.MainPresent;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;

@Module
public class PresentMainModule {
    private MainPresent mainPresent;

    @Provides
    public MainPresent getMainPresent(MainContract.View view){
        if (MainViewModul.getMainViewModul().getMainPresent() == null){
            mainPresent = new MainPresent(view);
            MainViewModul.getMainViewModul().setMainPresent(mainPresent);
            return mainPresent;
        }
        mainPresent =  MainViewModul.getMainViewModul().getMainPresent();
        mainPresent.setViewMain(view);
        return mainPresent;
    }

}
