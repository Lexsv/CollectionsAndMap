package ua.com.CollectionsAndMap.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ua.com.CollectionsAndMap.R;
import ua.com.CollectionsAndMap.domain.utils.FillView;
import ua.com.CollectionsAndMap.ui.MainActivity;

import ua.com.CollectionsAndMap.ui.presentation.flag.FlagMap;
import ua.com.CollectionsAndMap.ui.presentation.PresentForMap;

import static java.lang.String.*;
import static ua.com.CollectionsAndMap.domain.utils.FillView.speedMap;


public class TabMap extends BaseFragmen {

    private Map<Integer, String> saveData = new HashMap<>();
    private static PresentForMap present;


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
        present = new PresentForMap((MainActivity)getContext(),this);
        onRecycle(savedInstanceState);
    }

    public void onRecycle(Bundle savedInstanceState) {
        if (savedInstanceState !=null && present.getData() != null){
            saveData = present.getData();
            for (Integer integer : saveData.keySet()) {
                if (treeMapAdd.getId() == integer){treeMapAdd.setText(saveData.get(integer));}
                if (treeMapSearchKey.getId() == integer){treeMapSearchKey.setText(saveData.get(integer));}
                if (treeMapRemov.getId() == integer){treeMapRemov.setText(saveData.get(integer));}
                if (hashMapAdd.getId() == integer){hashMapAdd.setText(saveData.get(integer));}
                if (hashMapSearchKey.getId() == integer){hashMapSearchKey.setText(saveData.get(integer));}
                if (hashMapRemove.getId() == integer){hashMapRemove.setText(saveData.get(integer));}

            }
        }

    }


    @SuppressLint("CheckResult")
    @Override
    public void fillResult(Map<Byte, Byte> list, FlagMap flag) {

        if (flag == FlagMap.HASH) {
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
        if (flag == FlagMap.TREE){
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

    }


    public static PresentForMap getPresent(){
        return present;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        present.saveData(saveData);

    }

}