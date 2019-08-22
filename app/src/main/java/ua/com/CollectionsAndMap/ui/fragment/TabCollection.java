package ua.com.CollectionsAndMap.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import butterknife.BindView;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ua.com.CollectionsAndMap.data.resors.ArrayListElements;
import ua.com.CollectionsAndMap.data.resors.CopyOnWriteListElements;
import ua.com.CollectionsAndMap.data.resors.LinkedListElements;
import ua.com.CollectionsAndMap.R;
import ua.com.CollectionsAndMap.utils.FillView;

public class TabCollection extends Fragment {
    private Unbinder unbinder;
    private int amountElements = 0;

    public TabCollection() { }
    public TabCollection(int amountElements) {
        this.amountElements = amountElements;
    }

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

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("arrayListAddBegin", arrayListAddBegin.getText().toString());
        outState.putString("arrayListAddMiddle", arrayListAddMiddle.getText().toString());
        outState.putString("arrayListAddEnd", arrayListAddEnd.getText().toString());
        outState.putString("arrayListSearch", arrayListSearch.getText().toString());
        outState.putString("arrayListRemoveBegin", arrayListRemoveBegin.getText().toString());
        outState.putString("arrayListRemoveMiddle", arrayListRemoveMiddle.getText().toString());
        outState.putString("arrayListRemoveEnd", arrayListRemoveEnd.getText().toString());
        outState.putString("linkedListAddBegin", linkedListAddBegin.getText().toString());
        outState.putString("linkedListAddMiddle", linkedListAddMiddle.getText().toString());
        outState.putString("linkedListAddEnd", linkedListAddEnd.getText().toString());
        outState.putString("linkedListSearch", linkedListSearch.getText().toString());
        outState.putString("linkedListRemoveBegin", linkedListRemoveBegin.getText().toString());
        outState.putString("linkedListRemoveMiddle", linkedListRemoveMiddle.getText().toString());
        outState.putString("linkedListRemoveEnd", linkedListRemoveEnd.getText().toString());
        outState.putString("copyOnWriteAddBegin", copyOnWriteAddBegin.getText().toString());
        outState.putString("copyOnWriteAddMiddle", copyOnWriteAddMiddle.getText().toString());
        outState.putString("copyOnWriteAddEnd", copyOnWriteAddEnd.getText().toString());
        outState.putString("copyOnWriteSearch", copyOnWriteSearch.getText().toString());
        outState.putString("copyOnWriteRemoveBegin", copyOnWriteRemoveBegin.getText().toString());
        outState.putString("copyOnWriteRemoveMiddle", copyOnWriteRemoveMiddle.getText().toString());
        outState.putString("copyOnWriteRemoveEnd", copyOnWriteRemoveEnd.getText().toString());

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null && savedInstanceState.containsKey("arrayListAddBegin")) {
                initView(savedInstanceState);
            }

    }


    private void initView(Bundle savedInstanceState) {
        arrayListAddBegin.setText(savedInstanceState.getString("arrayListAddBegin"));
        arrayListAddMiddle.setText(savedInstanceState.getString("arrayListAddMiddle"));
        arrayListAddEnd.setText(savedInstanceState.getString("arrayListAddEnd"));
        arrayListSearch.setText(savedInstanceState.getString("arrayListSearch"));
        arrayListRemoveBegin.setText(savedInstanceState.getString("arrayListRemoveBegin"));
        arrayListRemoveMiddle.setText(savedInstanceState.getString("arrayListRemoveMiddle"));
        arrayListRemoveEnd.setText(savedInstanceState.getString("arrayListRemoveEnd"));
        linkedListAddBegin.setText(savedInstanceState.getString("linkedListAddBegin"));
        linkedListAddMiddle.setText(savedInstanceState.getString("linkedListAddMiddle"));
        linkedListAddEnd.setText(savedInstanceState.getString("linkedListAddEnd"));
        linkedListSearch.setText(savedInstanceState.getString("linkedListSearch"));
        linkedListRemoveBegin.setText(savedInstanceState.getString("linkedListRemoveBegin"));
        linkedListRemoveMiddle.setText(savedInstanceState.getString("linkedListRemoveMiddle"));
        linkedListRemoveEnd.setText(savedInstanceState.getString("linkedListRemoveEnd"));
        copyOnWriteAddBegin.setText(savedInstanceState.getString("copyOnWriteAddBegin"));
        copyOnWriteAddMiddle.setText(savedInstanceState.getString("copyOnWriteAddMiddle"));
        copyOnWriteAddEnd.setText(savedInstanceState.getString("copyOnWriteAddEnd"));
        copyOnWriteSearch.setText(savedInstanceState.getString("copyOnWriteSearch"));
        copyOnWriteRemoveBegin.setText(savedInstanceState.getString("copyOnWriteRemoveBegin"));
        copyOnWriteRemoveMiddle.setText(savedInstanceState.getString("copyOnWriteRemoveMiddle"));
        copyOnWriteRemoveEnd.setText(savedInstanceState.getString("copyOnWriteRemoveEnd"));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
