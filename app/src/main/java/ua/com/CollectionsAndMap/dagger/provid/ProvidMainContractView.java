package ua.com.CollectionsAndMap.dagger.provid;

import dagger.Module;
import dagger.Provides;
import ua.com.CollectionsAndMap.MainContract;

@Module
public class ProvidMainContractView {
    private MainContract.View view;

    public ProvidMainContractView(MainContract.View view) {
        this.view = view;
    }
    @Provides
    MainContract.View getView(){return view;}
}
