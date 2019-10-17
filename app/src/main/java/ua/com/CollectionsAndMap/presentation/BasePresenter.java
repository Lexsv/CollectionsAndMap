package ua.com.CollectionsAndMap.presentation;


import ua.com.CollectionsAndMap.MainContract;
import ua.com.CollectionsAndMap.MainContract.Presenter;
import ua.com.CollectionsAndMap.fragment.FragmentInterfas;

public abstract class BasePresenter  implements Presenter{

    protected FragmentInterfas fragmentInterfas;

    protected MainContract.View view;

    public void setFragmentInterfas(FragmentInterfas fragmentInterfas) {
        this.fragmentInterfas = fragmentInterfas;
    }

    public void setView(MainContract.View view) {
        this.view = view;
    }

    public FragmentInterfas getFragmentInterfas() {
        return fragmentInterfas;
    }

    public MainContract.View getView() {
        return view;
    }

    public BasePresenter(MainContract.View view, FragmentInterfas fragmentInterfas) {
        this.view = view;
        this.fragmentInterfas = fragmentInterfas;
    }

    void hidProgress(){ view.hidProgress();}
    public abstract void  finishCalcul();


}
