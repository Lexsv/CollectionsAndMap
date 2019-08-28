package ua.com.CollectionsAndMap.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.HashMap;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ua.com.CollectionsAndMap.R;
import ua.com.CollectionsAndMap.domain.utils.FillView;

import static java.lang.String.*;

public class TabMap extends Fragment {

    private Unbinder unbinder;

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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
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


        if (savedInstanceState != null && savedInstanceState.containsKey("treeMapAdd")) {
            initView(savedInstanceState);
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void fillResult(HashMap<Byte, Byte> list) {
        treeMapAdd.setText(valueOf(FillView.speedAddToMap(list)));
        treeMapSearchKey.setText(valueOf(FillView.speedSearchInMap(list)));
        treeMapRemov.setText(valueOf(FillView.speedRemovInMap(list)));
    }

    public void fillResult(TreeMap<Byte, Byte> list) {
        hashMapAdd.setText(String.valueOf(FillView.speedAddToMap(list)));
        hashMapSearchKey.setText(String.valueOf(FillView.speedSearchInMap(list)));
        hashMapRemove.setText(String.valueOf(FillView.speedRemovInMap(list)));

    }
}