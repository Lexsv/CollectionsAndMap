package ua.com.CollectionsAndMap.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ua.com.CollectionsAndMap.R;
import ua.com.CollectionsAndMap.data.DataSave;
import ua.com.CollectionsAndMap.domain.utils.FillView;
import ua.com.CollectionsAndMap.ui.MainActivity;
import ua.com.CollectionsAndMap.ui.presentation.PresentForList;

import static java.lang.String.*;
import static ua.com.CollectionsAndMap.domain.utils.FillView.speedList;

public class TabCollection extends Fragment {
    private Unbinder unbinder;
    private Map<Integer, String> saveData = new HashMap<>();
    private static PresentForList present;
    private MainActivity activity;




    @BindView(R.id.arrayList_addBagin)
    TextView arrayListAddBegin;
    @BindView(R.id.arrayList_addMiddle)
    TextView arrayListAddMiddle;
    @BindView(R.id.arrayList_addEnd)
    TextView arrayListAddEnd;
    @BindView(R.id.arrayList_search)
    TextView arrayListSearch;
    @BindView(R.id.arrayList_removeBagin)
    TextView arrayListRemoveBegin;
    @BindView(R.id.arrayList_ramoveMidlle)
    TextView arrayListRemoveMiddle;
    @BindView(R.id.arrayList_removeEnd)
    TextView arrayListRemoveEnd;
    @BindView(R.id.linkedList_addBagin)
    TextView linkedListAddBegin;
    @BindView(R.id.linkedList_addMiddle)
    TextView linkedListAddMiddle;
    @BindView(R.id.linkedList_addEnd)
    TextView linkedListAddEnd;
    @BindView(R.id.linkedList_search)
    TextView linkedListSearch;
    @BindView(R.id.linkedList_removeBagin)
    TextView linkedListRemoveBegin;
    @BindView(R.id.linkedList_ramoveMidlle)
    TextView linkedListRemoveMiddle;
    @BindView(R.id.linkedList_removeEnd)
    TextView linkedListRemoveEnd;
    @BindView(R.id.copyOn_write_addBagin)
    TextView copyOnWriteAddBegin;
    @BindView(R.id.copyOn_write_addMiddle)
    TextView copyOnWriteAddMiddle;
    @BindView(R.id.copyOn_write_addEnd)
    TextView copyOnWriteAddEnd;
    @BindView(R.id.copyOn_write_search)
    TextView copyOnWriteSearch;
    @BindView(R.id.copyOn_write_removeBagin)
    TextView copyOnWriteRemoveBegin;
    @BindView(R.id.copyOn_write_ramoveMidlle)
    TextView copyOnWriteRemoveMiddle;
    @BindView(R.id.copyOn_write_removeEnd)
    TextView copyOnWriteRemoveEnd;



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.activity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collection, container, false);
        unbinder = ButterKnife.bind(this, view);
        this.present = new PresentForList(activity,this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onRecycle(savedInstanceState);
    }

    @SuppressLint("CheckResult")
    public void fillResult(ArrayList<Integer> list) {
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.ADDBEGIN))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    arrayListAddBegin.setText(s);
                    saveData.put(R.id.arrayList_addBagin, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.ADDMIDDL))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    arrayListAddMiddle.setText(s);
                    saveData.put(R.id.arrayList_addMiddle, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.ADDEND))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    arrayListAddEnd.setText(s);
                    saveData.put(R.id.arrayList_addEnd, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.SEARCHLIST))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    arrayListSearch.setText(s);
                    saveData.put(R.id.arrayList_search, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.REMOVEBEGIN))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    arrayListRemoveBegin.setText(s);
                    saveData.put(R.id.arrayList_removeBagin, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.REMOVEMIDDL))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    arrayListRemoveMiddle.setText(s);
                    saveData.put(R.id.arrayList_ramoveMidlle, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.REMOVEND))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    arrayListRemoveEnd.setText(s);
                    saveData.put(R.id.arrayList_removeEnd, s);
                }));
    }

    @SuppressLint("CheckResult")
    public void fillResult(LinkedList<Integer> list) {
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.ADDBEGIN))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    linkedListAddBegin.setText(s);
                    saveData.put(R.id.linkedList_addBagin, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.ADDMIDDL))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    linkedListAddMiddle.setText(s);
                    saveData.put(R.id.linkedList_addMiddle, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.ADDEND))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    linkedListAddEnd.setText(s);
                    saveData.put(R.id.linkedList_addEnd, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.SEARCHLIST))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    linkedListSearch.setText(s);
                    saveData.put(R.id.linkedList_search, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.REMOVEBEGIN))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    linkedListRemoveBegin.setText(s);
                    saveData.put(R.id.linkedList_removeBagin, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.REMOVEMIDDL))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    linkedListRemoveMiddle.setText(s);
                    saveData.put(R.id.linkedList_ramoveMidlle, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.REMOVEND))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    linkedListRemoveEnd.setText(s);
                    saveData.put(R.id.linkedList_removeEnd, s);
                }));
    }

    @SuppressLint("CheckResult")
    public void fillResult(CopyOnWriteArrayList<Integer> list) {
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.ADDBEGIN))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    copyOnWriteAddBegin.setText(s);
                    saveData.put(R.id.copyOn_write_addBagin, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.ADDMIDDL))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    copyOnWriteAddMiddle.setText(s);
                    saveData.put(R.id.copyOn_write_addMiddle, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.ADDEND))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    copyOnWriteAddEnd.setText(s);
                    saveData.put(R.id.copyOn_write_addEnd, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.SEARCHLIST))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    copyOnWriteSearch.setText(s);
                    saveData.put(R.id.copyOn_write_search, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.REMOVEBEGIN))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    copyOnWriteRemoveBegin.setText(s);
                    saveData.put(R.id.copyOn_write_removeBagin, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.REMOVEMIDDL))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    copyOnWriteRemoveMiddle.setText(s);
                    saveData.put(R.id.copyOn_write_ramoveMidlle, s);
                }));
        Single.fromCallable(() -> speedList(list, FillView.ActionFill.REMOVEND))
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s -> {
                    copyOnWriteRemoveEnd.setText(s);
                    saveData.put(R.id.copyOn_write_removeEnd, s);
                }));
    }

    public static PresentForList getPresent() {return present;}

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public Map<Integer, String> getSaveData() {
        return saveData;
    }


    public void onRecycle(Bundle savedInstanceState) {
        if (savedInstanceState != null && present.getData() != null ){
          saveData = present.getData();
            for (Integer integer : saveData.keySet()){
                if (arrayListAddBegin.getId() == integer){arrayListAddBegin.setText(saveData.get(integer));}
                if (arrayListAddMiddle.getId() == integer){arrayListAddMiddle.setText(saveData.get(integer));}
                if (arrayListAddEnd.getId() == integer){arrayListAddEnd.setText(saveData.get(integer));}
                if (arrayListSearch.getId() == integer){arrayListSearch.setText(saveData.get(integer));}
                if (arrayListRemoveBegin.getId() == integer){arrayListRemoveBegin.setText(saveData.get(integer));}
                if (arrayListRemoveMiddle.getId() == integer){arrayListRemoveMiddle.setText(saveData.get(integer));}
                if (arrayListRemoveEnd.getId() == integer){arrayListRemoveEnd.setText(saveData.get(integer));}
                if (linkedListAddBegin.getId() == integer){linkedListAddBegin.setText(saveData.get(integer));}
                if (linkedListAddMiddle.getId() == integer){linkedListAddMiddle.setText(saveData.get(integer));}
                if (linkedListAddEnd.getId() == integer){linkedListAddEnd.setText(saveData.get(integer));}
                if (linkedListSearch.getId() == integer){linkedListSearch.setText(saveData.get(integer));}
                if (linkedListRemoveBegin.getId() == integer){linkedListRemoveBegin.setText(saveData.get(integer));}
                if (linkedListRemoveMiddle.getId() == integer){linkedListRemoveMiddle.setText(saveData.get(integer));}
                if (linkedListRemoveEnd.getId() == integer){linkedListRemoveEnd.setText(saveData.get(integer));}
                if (copyOnWriteAddBegin.getId() == integer){copyOnWriteAddBegin.setText(saveData.get(integer));}
                if (copyOnWriteAddMiddle.getId() == integer){copyOnWriteAddMiddle.setText(saveData.get(integer));}
                if (copyOnWriteAddEnd.getId() == integer){copyOnWriteAddEnd.setText(saveData.get(integer));}
                if (copyOnWriteSearch.getId() == integer){copyOnWriteSearch.setText(saveData.get(integer));}
                if (copyOnWriteRemoveBegin.getId() == integer){copyOnWriteRemoveBegin.setText(saveData.get(integer));}
                if (copyOnWriteRemoveMiddle.getId() == integer){copyOnWriteRemoveMiddle.setText(saveData.get(integer));}
                if (copyOnWriteRemoveEnd.getId() == integer){copyOnWriteRemoveEnd.setText(saveData.get(integer));}

            }
        }

    }



}
