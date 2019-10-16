package ua.com.CollectionsAndMap.fragment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;

import javax.inject.Inject;
import butterknife.BindView;
import ua.com.CollectionsAndMap.R;
import ua.com.CollectionsAndMap.dagger.component.DaggerPresentMap;
import ua.com.CollectionsAndMap.dagger.component.PresentMap;
import ua.com.CollectionsAndMap.dagger.modules.PresenterMapModul;
import ua.com.CollectionsAndMap.dagger.provid.ProvidFragmentInterfas;
import ua.com.CollectionsAndMap.dagger.provid.ProvidMainContractView;
import ua.com.CollectionsAndMap.domain.TypeRow;
import ua.com.CollectionsAndMap.MainContract;



public class TabMap extends BaseFragmen {

    @Inject
    MainContract.Presenter mPresentor;


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
        mPresentor.fillView();
    }

    private void addDaggerDepend() {
        PresentMap presentMap = DaggerPresentMap.builder()
                .providMainContractView(new ProvidMainContractView((MainContract.View) getContext()))
                .providFragmentInterfas(new ProvidFragmentInterfas(this))
                .presenterMapModul(new PresenterMapModul())
                .build();


        presentMap.inject(this);
    }

    @Override
    public void fillResult(String s, TypeRow typeRow) {


        if (typeRow == TypeRow.TREEMAPADD) {
            treeMapAdd.setText(s);
        }
        if (typeRow == TypeRow.TREEMAPSEARCHKEY) {
            treeMapSearchKey.setText(s);
        }
        if (typeRow == TypeRow.TREEMAPREMOV) {
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