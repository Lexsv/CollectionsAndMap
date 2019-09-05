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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ua.com.CollectionsAndMap.R;
import ua.com.CollectionsAndMap.domain.utils.FillView;
import ua.com.CollectionsAndMap.ui.presentation.Interface.DataView;
import ua.com.CollectionsAndMap.ui.presentation.Interface.ProgressBar;

import static java.lang.String.*;
import static ua.com.CollectionsAndMap.domain.utils.FillView.speedList;

public class TabCollection extends Fragment implements ProgressBar, DataView {
    private Unbinder unbinder;
    private AlertDialog showProgress;
    private Map<TextView, String> saveData = new HashMap<>();

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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collection, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    public void fillResult(ArrayList<Integer> list) {

        Single.fromCallable(()->speedList(list, FillView.ActionFill.ADDBEGIN))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    arrayListAddBegin.setText(s);
                        saveData.put(arrayListAddBegin, s );
                }));

        Single.fromCallable(()->speedList(list, FillView.ActionFill.ADDMIDDL))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    arrayListAddMiddle.setText(s);
                    saveData.put(arrayListAddMiddle, s );
                }));
        Single.fromCallable(()->speedList(list, FillView.ActionFill.ADDEND))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    arrayListAddEnd.setText(s);
                    saveData.put(arrayListAddEnd, s );
                }));

        Single.fromCallable(()->speedList(list, FillView.ActionFill.SEARCHLIST))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    arrayListSearch.setText(s);
                    saveData.put(arrayListSearch, s );
                }));

        Single.fromCallable(()->speedList(list, FillView.ActionFill.REMOVEBEGIN))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    arrayListRemoveBegin.setText(s);
                    saveData.put(arrayListRemoveBegin, s );
                }));

        Single.fromCallable(()->speedList(list, FillView.ActionFill.REMOVEMIDDL))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    arrayListRemoveMiddle.setText(s);
                    saveData.put(arrayListRemoveMiddle, s );
                }));
        Single.fromCallable(()->speedList(list, FillView.ActionFill.REMOVEND))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    arrayListRemoveEnd.setText(s);
                    saveData.put(arrayListRemoveEnd, s );
                }));
    }

    public void fillResult(LinkedList<Integer> list) {


        Single.fromCallable(()->speedList(list, FillView.ActionFill.ADDBEGIN))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    linkedListAddBegin.setText(s);
                    saveData.put(linkedListAddBegin, s );
                }));

        Single.fromCallable(()->speedList(list, FillView.ActionFill.ADDMIDDL))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    linkedListAddMiddle.setText(s);
                    saveData.put(linkedListAddMiddle, s );
                }));
        Single.fromCallable(()->speedList(list, FillView.ActionFill.ADDEND))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    linkedListAddEnd.setText(s);
                    saveData.put(linkedListAddEnd, s );
                }));

        Single.fromCallable(()->speedList(list, FillView.ActionFill.SEARCHLIST))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    linkedListSearch.setText(s);
                    saveData.put(linkedListSearch, s );
                }));

        Single.fromCallable(()->speedList(list, FillView.ActionFill.REMOVEBEGIN))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    linkedListRemoveBegin.setText(s);
                    saveData.put(linkedListRemoveBegin, s );
                }));

        Single.fromCallable(()->speedList(list, FillView.ActionFill.REMOVEMIDDL))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    linkedListRemoveMiddle.setText(s);
                    saveData.put(linkedListRemoveMiddle, s );
                }));
        Single.fromCallable(()->speedList(list, FillView.ActionFill.REMOVEND))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    linkedListRemoveEnd.setText(s);
                    saveData.put(linkedListRemoveEnd, s );
                }));
    }

    public void fillResult(CopyOnWriteArrayList<Integer> list) {

        Single.fromCallable(()->speedList(list, FillView.ActionFill.ADDBEGIN))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    copyOnWriteAddBegin.setText(s);
                    saveData.put(copyOnWriteAddBegin, s );
                }));

        Single.fromCallable(()->speedList(list, FillView.ActionFill.ADDMIDDL))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    copyOnWriteAddMiddle.setText(s);
                    saveData.put(copyOnWriteAddMiddle, s );
                }));
        Single.fromCallable(()->speedList(list, FillView.ActionFill.ADDEND))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    copyOnWriteAddEnd.setText(s);
                    saveData.put(copyOnWriteAddEnd, s );
                }));

        Single.fromCallable(()->speedList(list, FillView.ActionFill.SEARCHLIST))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    copyOnWriteSearch.setText(s);
                    saveData.put(copyOnWriteSearch, s );
                }));

        Single.fromCallable(()->speedList(list, FillView.ActionFill.REMOVEBEGIN))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    copyOnWriteRemoveBegin.setText(s);
                    saveData.put(copyOnWriteRemoveBegin, s );
                }));

        Single.fromCallable(()->speedList(list, FillView.ActionFill.REMOVEMIDDL))
                .subscribeOn(Schedulers.newThread())
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    copyOnWriteRemoveMiddle.setText(s);
                    saveData.put(copyOnWriteRemoveMiddle, s );
                }));
        Single.fromCallable(()->speedList(list, FillView.ActionFill.REMOVEND))
                .map((m) -> valueOf(m))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s ->{
                    copyOnWriteRemoveEnd.setText(s);
                    saveData.put(copyOnWriteRemoveEnd, s );
                }));

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

    public Map<TextView, String> getSaveData() {
        return saveData;
    }

    @Override
    public void onRecycle(Map<TextView, String> list) {
        for ( TextView textView : list.keySet()){
            textView.setText(list.get(textView));
        }
    }
}
