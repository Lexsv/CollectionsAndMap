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
import ua.com.CollectionsAndMap.ui.presentation.interfaceExpand.DataView;
import ua.com.CollectionsAndMap.ui.presentation.interfaceExpand.ProgressBar;

import static java.lang.String.*;
import static ua.com.CollectionsAndMap.domain.utils.FillView.speedMap;

public class TabMap extends Fragment implements DataView {

    private Unbinder unbinder;
    private Map<Integer, String> saveData = new HashMap<>();

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
    public void onRecycle(Map<Integer, String> list) {

        for (Integer textView : list.keySet()) {
            System.out.println(" ******** onRecycleView ********* ");
            //textView.setText(list.get(textView));
            System.out.println("Key: " + textView + " **** Value: " + list.get(textView));
        }
    }


    public void fillResult(HashMap<Byte, Byte> list) {

        Single.fromCallable(() -> speedMap(list, FillView.ActionFill.ADDBEGIN))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    treeMapAdd.setText(s);
                    saveData.put(R.id.treeMap_add, s);
                }));

        Single.fromCallable(() -> speedMap(list, FillView.ActionFill.ADDMIDDL))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    treeMapSearchKey.setText(s);
                    saveData.put(R.id.treeMap_SearchKey, s);
                }));
        Single.fromCallable(() -> speedMap(list, FillView.ActionFill.ADDEND))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    treeMapRemov.setText(s);
                    saveData.put(R.id.treeMap_remove, s);
                }));

    }

    public void fillResult(TreeMap<Byte, Byte> list) {

        Single.fromCallable(() -> speedMap(list, FillView.ActionFill.ADDBEGIN))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    hashMapAdd.setText(s);
                    saveData.put(R.id.hashMap_add, s);
                }));

        Single.fromCallable(() -> speedMap(list, FillView.ActionFill.ADDMIDDL))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    hashMapSearchKey.setText(s);
                    saveData.put(R.id.hashMap_SearchKey, s);
                }));
        Single.fromCallable(() -> speedMap(list, FillView.ActionFill.ADDEND))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    hashMapRemove.setText(s);
                    saveData.put(R.id.hashMap_remove, s);
                }));

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}