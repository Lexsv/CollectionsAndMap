package ua.com.CollectionsAndMap.domain.dagger.provid;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;

@Module
public class ProvidMainContractView {
    private MainContract.View view;

    public ProvidMainContractView(MainContract.View view) {
        this.view = view;
    }
    @Provides
    MainContract.View getView(){return view;}
}
