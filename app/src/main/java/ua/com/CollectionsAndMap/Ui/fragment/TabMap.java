package ua.com.CollectionsAndMap.Ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.HashMap;
import java.util.TreeMap;

import butterknife.BindView;
import ua.com.CollectionsAndMap.Data.resors.HashMapElements;
import ua.com.CollectionsAndMap.Data.resors.TreeMapElements;
import ua.com.CollectionsAndMap.R;
import ua.com.CollectionsAndMap.Utils.FillView;

public class TabMap extends Fragment {

    @BindView(R.id.treeMap_add) TextView treeMapAdd;
    @BindView(R.id.treeMap_SearchKey) TextView treeMapSearchKey;
    @BindView(R.id.treeMap_remove) TextView treeMapRemov;
    @BindView(R.id.hashMap_add) TextView hashMapAdd;
    @BindView(R.id.hashMap_SearchKey) TextView hashMapSearchKey;
    @BindView(R.id.hashMap_remove) TextView hashMapRemove;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.map, container, false);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
            outState.putString("treeMapAdd", treeMapAdd.getText().toString());
            outState.putString("treeMapSearchKey", treeMapSearchKey.getText().toString());
            outState.putString("treeMapremove", treeMapRemov.getText().toString());
            outState.putString("hashMapAdd", hashMapAdd.getText().toString());
            outState.putString("hashMapSearchKey", hashMapSearchKey.getText().toString());
            outState.putString("hashMapRemove", hashMapRemove.getText().toString());

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() != null && isAdded()) {
            if (savedInstanceState != null && savedInstanceState.containsKey("treeMapAdd")) {
                initView(savedInstanceState);
            }
        }

    }


    private void initView(Bundle savedInstanceState) {
        treeMapAdd.setText(savedInstanceState.getString("treeMapAdd"));
        treeMapSearchKey.setText(savedInstanceState.getString("treeMapSearchKey"));
        treeMapRemov.setText(savedInstanceState.getString("treeMapremove"));
        hashMapAdd.setText(savedInstanceState.getString("hashMapAdd"));
        hashMapSearchKey.setText(savedInstanceState.getString("hashMapSearchKey"));
        hashMapRemove.setText(savedInstanceState.getString("hashMapRemove"));
    }



    public void initDataInView(int amountElements ) {
        TreeMap treeMap = new TreeMapElements(amountElements).getTreeMap();
        HashMap hashMap = new HashMapElements(amountElements).getHashMap();

        treeMapAdd.setText(String.valueOf(FillView.speedAddToMap(treeMap)));
        treeMapSearchKey.setText(String.valueOf(FillView.speedSearchInMap(treeMap)));
        treeMapRemov.setText(String.valueOf(FillView.speedRemovInMap(treeMap)));

        hashMapAdd.setText(String.valueOf(FillView.speedAddToMap(hashMap)));
        hashMapSearchKey.setText(String.valueOf(FillView.speedSearchInMap(hashMap)));
        hashMapRemove.setText(String.valueOf(FillView.speedRemovInMap(hashMap)));

    }
}
