package ua.com.CollectionsAndMap.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ua.com.CollectionsAndMap.R;
import ua.com.CollectionsAndMap.domain.utils.FillView;
import ua.com.CollectionsAndMap.ui.presentation.Interface.DataView;
import ua.com.CollectionsAndMap.ui.presentation.Interface.ProgressBar;

import static java.lang.String.*;
import static ua.com.CollectionsAndMap.domain.utils.FillView.speedList;
import static ua.com.CollectionsAndMap.domain.utils.FillView.speedMap;

public class TabMap extends Fragment implements ProgressBar, DataView {

    private Unbinder unbinder;
    private AlertDialog showProgress;

    private Map<TextView, String> saveData = new HashMap<>();

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
    public void shoeProgress() {
        showProgress = new AlertDialog.Builder(this.getContext())
                .setView(R.layout.loader_view_progress)
                .setCancelable(false)
                .create();
        showProgress.show();
    }

    @Override
    public void hidProgress() {
        showProgress.cancel();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void fillResult(HashMap<Byte, Byte> list) {

        Single.fromCallable(()->speedMap(list, FillView.ActionFill.ADDBEGIN))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    treeMapAdd.setText(s);
                    saveData.put(treeMapAdd, s );
                }));

        Single.fromCallable(()->speedMap(list, FillView.ActionFill.ADDMIDDL))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    treeMapSearchKey.setText(s);
                    saveData.put(treeMapSearchKey, s );
                }));
        Single.fromCallable(()->speedMap(list, FillView.ActionFill.ADDEND))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    treeMapRemov.setText(s);
                    saveData.put(treeMapRemov, s );
                }));

    }

    public void fillResult(TreeMap<Byte, Byte> list) {

        Single.fromCallable(()->speedMap(list, FillView.ActionFill.ADDBEGIN))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    hashMapAdd.setText(s);
                    saveData.put(hashMapAdd, s );
                }));

        Single.fromCallable(()->speedMap(list, FillView.ActionFill.ADDMIDDL))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    hashMapSearchKey.setText(s);
                    saveData.put(hashMapSearchKey, s );
                }));
        Single.fromCallable(()->speedMap(list, FillView.ActionFill.ADDEND))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    hashMapRemove.setText(s);
                    saveData.put(hashMapRemove, s );
                }));

    }

    @Override
    public void onRecycle(Map<TextView, String> list) {
        for ( TextView textView : list.keySet()){
            textView.setText(list.get(textView));
        }
    }
}