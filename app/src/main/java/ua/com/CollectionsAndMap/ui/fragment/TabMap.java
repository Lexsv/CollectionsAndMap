package ua.com.CollectionsAndMap.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;

import javax.inject.Inject;

import butterknife.BindView;

import ua.com.CollectionsAndMap.R;

import ua.com.CollectionsAndMap.data.StatData;
import ua.com.CollectionsAndMap.data.TypeRow;
import ua.com.CollectionsAndMap.domain.dagger.component.DaggerPresentComponent;
import ua.com.CollectionsAndMap.domain.dagger.component.PresentComponent;
import ua.com.CollectionsAndMap.domain.dagger.modules.PresenterMapModul;
import ua.com.CollectionsAndMap.domain.dagger.provid.ProvidFillView;
import ua.com.CollectionsAndMap.domain.dagger.provid.ProvidMainContractView;
import ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill;
import ua.com.CollectionsAndMap.ui.mainaactivity.MainViewModul;
import ua.com.CollectionsAndMap.ui.presentation.PresentForMap;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;


public class TabMap extends BaseFragmen {
    @Inject
    PresentForMap present;


    @BindView(R.id.treeMap_add)
    TextView treeMapAdd;
    @BindView(R.id.treeMap_SearchKey)
    TextView treeMapSearchKey;
    @BindView(R.id.treeMap_remove)
    TextView treeMapRemov;
    @BindView(R.id.hashMap_add)
    TextView hashMapAdd;
    @BindView(R.id.hashMap_SearchKey)
    TextView hashMapSearchKey;
    @BindView(R.id.hashMap_remove)
    TextView hashMapRemove;


    @Override
    protected int getLayout() {
        return R.layout.map;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addDaggerDepend();
        getLifecycle().addObserver(present);
       present.fillView();
    }

    private void addDaggerDepend() {
        PresentComponent presentComponent = DaggerPresentComponent.builder()
                .providMainContractView(new ProvidMainContractView((MainContract.View) getContext()))
                .providFillView(new ProvidFillView(this))
                .presenterMapModul(new PresenterMapModul())
                .build();
        presentComponent.inject(this);
    }


    @Override
    public MainContract.Presenter getPresent() {
        return  present;
    }



    @Override
    public void fillResult(String s, TypeRow typeRow) {


        if (typeRow == TypeRow.TREEMAPADD) {
            treeMapAdd.setText(s);
        }
        if (typeRow == TypeRow.TREEMAPSEARCHKEY ) {
            treeMapSearchKey.setText(s);
        }
        if (typeRow ==TypeRow.TREEMAPREMOV ) {
            treeMapRemov.setText(s);
        }

        if (typeRow == TypeRow.HASHMAPADD) {
            hashMapAdd.setText(s);
        }

        if (typeRow == TypeRow.HASHMAPSEARCHKEY) {
            hashMapSearchKey.setText(s);
        }
        if (typeRow == TypeRow.HASHMAPREMOVE) {
            hashMapRemove.setText(s);
        }

    }


    @Override
    public LifecycleOwner getOwn() {
        return this;
    }
}