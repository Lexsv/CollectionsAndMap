package ua.com.CollectionsAndMap.dagger.provid;

import dagger.Module;
import dagger.Provides;
import ua.com.CollectionsAndMap.fragment.FragmentInterfas;

@Module
public class ProvidFragmentInterfas {
    private FragmentInterfas fragmentInterfas;

    public ProvidFragmentInterfas(FragmentInterfas fragmentInterfas) {
        this.fragmentInterfas = fragmentInterfas;

    }

    @Provides
    FragmentInterfas getFragmentInterfas(){
        return fragmentInterfas;
    }
}
