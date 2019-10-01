package ua.com.CollectionsAndMap.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;

import ua.com.CollectionsAndMap.R;

import ua.com.CollectionsAndMap.domain.dagger.component.DaggerPresentComponent;
import ua.com.CollectionsAndMap.domain.dagger.component.PresentComponent;
import ua.com.CollectionsAndMap.domain.dagger.modules.PresenterMapModul;
import ua.com.CollectionsAndMap.domain.dagger.provid.ProvidFillView;
import ua.com.CollectionsAndMap.domain.dagger.provid.ProvidMainContractView;
import ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill;
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
        onRecycle(savedInstanceState);
    }

    private void addDaggerDepend() {
        PresentComponent presentComponent = DaggerPresentComponent.builder()
                .providMainContractView(new ProvidMainContractView((MainContract.View) getContext()))
                .providFillView(new ProvidFillView(this))
                .presenterMapModul(new PresenterMapModul())
                .build();
        presentComponent.inject(this);
    }

    public void onRecycle(Bundle savedInstanceState) {
        if (savedInstanceState != null ) {
            Map<ActionFill, String> treeMap = present.getData(TypeCollectin.TREE);
            Map<ActionFill, String> hashMap = present.getData(TypeCollectin.HASH);

            for (ActionFill actionFill : treeMap.keySet()) {
                if (ActionFill.ADDMAP == actionFill) {
                    treeMapAdd.setText(treeMap.get(actionFill));
                }
                if (ActionFill.SEARCHMAP == actionFill) {
                    treeMapSearchKey.setText(treeMap.get(actionFill));
                }
                if (ActionFill.REMOVEMAP == actionFill) {
                    treeMapRemov.setText(treeMap.get(actionFill));
                }
            }

            for (ActionFill actionFill : hashMap.keySet()) {
                if (ActionFill.ADDMAP == actionFill) {
                    hashMapAdd.setText(hashMap.get(actionFill));
                }
                if (ActionFill.SEARCHMAP == actionFill) {
                    hashMapSearchKey.setText(hashMap.get(actionFill));
                }
                if (ActionFill.REMOVEMAP == actionFill) {
                    hashMapRemove.setText(hashMap.get(actionFill));
                }
            }


        }

    }

    @Override
    public MainContract.Presenter getPresent() {
        return  present;
    }


    @SuppressLint("CheckResult")
    @Override
    public void fillResult(String s, TypeCollectin flagList, ActionFill flagAction) {

        if (flagList == TypeCollectin.TREE) {

            if (flagAction == ActionFill.ADDMAP) {
                treeMapAdd.setText(s);
            }
            if (flagAction == ActionFill.SEARCHMAP) {
                treeMapSearchKey.setText(s);
            }
            if (flagAction == ActionFill.REMOVEMAP) {
                treeMapRemov.setText(s);
            }
        }

        if (flagList == TypeCollectin.HASH) {

            if (flagAction == ActionFill.ADDMAP) {
                hashMapAdd.setText(s);
            }

            if (flagAction == ActionFill.SEARCHMAP) {
                hashMapSearchKey.setText(s);
            }
            if (flagAction == ActionFill.REMOVEMAP) {
                hashMapRemove.setText(s);
            }
        }

    }



}