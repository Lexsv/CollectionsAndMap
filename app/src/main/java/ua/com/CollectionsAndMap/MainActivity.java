package ua.com.CollectionsAndMap;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;


import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import ua.com.CollectionsAndMap.Fragment.PagerAdapt;
import ua.com.CollectionsAndMap.Moduls.ArrayListElements;
import ua.com.CollectionsAndMap.Moduls.CopyOnWriteListElements;
import ua.com.CollectionsAndMap.Moduls.HashMapElements;
import ua.com.CollectionsAndMap.Moduls.LinkedListElements;
import ua.com.CollectionsAndMap.Moduls.TreeMapElements;
import ua.com.CollectionsAndMap.Utils.FillView;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Boolean amElemVisebl = true;
    private int amountAddElementList;
    private int amountAddElementMap;

    @BindView( R.id.arrayList_addBagin) TextView arrayListAddBegin ;
    @BindView( R.id.arrayList_addMiddle) TextView arrayListAddMiddle ;
    @BindView( R.id.arrayList_addEnd) TextView arrayListAddEnd ;
    @BindView( R.id.arrayList_search) TextView arrayListSearch ;
    @BindView( R.id.arrayList_removeBagin) TextView arrayListRemoveBegin ;
    @BindView( R.id.arrayList_ramoveMidlle) TextView arrayListRemoveMiddle ;
    @BindView( R.id.arrayList_removeEnd) TextView arrayListRemoveEnd ;
    @BindView( R.id.linkedList_addBagin) TextView linkedListAddBegin ;
    @BindView( R.id.linkedList_addMiddle) TextView linkedListAddMiddle ;
    @BindView( R.id.linkedList_addEnd) TextView linkedListAddEnd ;
    @BindView( R.id.linkedList_search) TextView linkedListSearch ;
    @BindView( R.id.linkedList_removeBagin) TextView linkedListRemoveBegin ;
    @BindView( R.id.linkedList_ramoveMidlle) TextView linkedListRemoveMiddle ;
    @BindView( R.id.linkedList_removeEnd) TextView linkedListRemoveEnd ;
    @BindView( R.id.copyOn_write_addBagin) TextView copyOnWriteAddBegin ;
    @BindView( R.id.copyOn_write_addMiddle) TextView copyOnWriteAddMiddle ;
    @BindView( R.id.copyOn_write_addEnd) TextView copyOnWriteAddEnd ;
    @BindView( R.id.copyOn_write_search) TextView copyOnWriteSearch ;
    @BindView( R.id.copyOn_write_removeBagin) TextView copyOnWriteRemoveBegin ;
    @BindView( R.id.copyOn_write_ramoveMidlle) TextView copyOnWriteRemoveMiddle ;
    @BindView( R.id.copyOn_write_removeEnd) TextView copyOnWriteRemoveEnd ;
    @BindView( R.id.treeMap_add)  TextView treeMapAdd ;
    @BindView( R.id.treeMap_SearchKey) TextView treeMapSearchKey ;
    @BindView( R.id.treeMap_remove) TextView treeMapremove ;
    @BindView( R.id.hashMap_add) TextView hashMapAdd ;
    @BindView( R.id.hashMap_SearchKey) TextView hashMapSearchKey ;
    @BindView( R.id.hashMap_remove) TextView hashMapRemove ;




    ArrayList<Integer> arrayList = new ArrayList<>();
    LinkedList<Integer> linkedList = new LinkedList<>();
    CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    TreeMap<String, Integer> treeMap = new TreeMap<>();
    HashMap<String, Integer> hashMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.mainActivity_toolbar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.mainActivity_tabsLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Collections"));
        tabLayout.addTab(tabLayout.newTab().setText("Map"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addOnTabSelectedListener(this);

        viewPager = findViewById(R.id.mainActivity_pager);
        final PagerAdapt pagerAdapter = new PagerAdapt(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        if (savedInstanceState != null) initView(savedInstanceState);

        final EditText amountElements = findViewById(R.id.mainActivity_amount_element);


        FloatingActionButton faButtn = findViewById(R.id.mainActivity_float_button);
        faButtn.setOnClickListener(view -> {

            if (amElemVisebl) {
                amountElements.setVisibility(View.VISIBLE);
                amElemVisebl = !amElemVisebl;
                faButtn.setVisibility(View.GONE);
                showKeyBoard(amountElements);
            } else {
                amountElements.setVisibility(View.INVISIBLE);
                amElemVisebl = !amElemVisebl;
            }

        });

        amountElements.setOnEditorActionListener((textView, i, keyEvent) -> {
            if (i == EditorInfo.IME_ACTION_DONE) {
                faButtn.setVisibility(View.VISIBLE);
                faButtn.performClick();
                hideKeyBoard(amountElements);


                if (tabLayout.getSelectedTabPosition() == 0) {
                    arrayList.clear();
                    linkedList.clear();
                    copyOnWriteArrayList.clear();

                    amountAddElementList = amountElements.getText().toString().equals("") ? 0 : Integer.valueOf(amountElements.getText().toString());
                    new Thread(() -> {
                        fillList();
                        runOnUiThread(addResultToViewList);
                    }).start();

                }
                if (tabLayout.getSelectedTabPosition() == 1) {
                    treeMap.clear();
                    hashMap.clear();
                    amountAddElementMap = amountElements.getText().toString().equals("") ? 0 : Integer.valueOf(amountElements.getText().toString());
                    new Thread(() -> {
                        fillMap();
                        runOnUiThread(addResultToViewMap);
                    }).start();

                }
            }
            return false;
        });

    }


    private void showKeyBoard(View v) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT);
    }

    private void hideKeyBoard(View v) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    private void fillList() {
        runOnUiThread(() -> {
            ProgressBar pr = findViewById(R.id.progressBar_List);
            pr.setVisibility(View.VISIBLE);
        });
        CountDownLatch cd = new CountDownLatch(3);
        Thread threadAddBeginArr = new Thread(new ArrayListElements(amountAddElementList, arrayList, cd));
        Thread threadAddBeginLink = new Thread(new LinkedListElements(amountAddElementList, linkedList, cd));
        Thread threadAddBeginCopyWrit = new Thread(new CopyOnWriteListElements(amountAddElementList, copyOnWriteArrayList, cd));
        threadAddBeginArr.start();
        threadAddBeginLink.start();
        threadAddBeginCopyWrit.start();

        try {
            cd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runOnUiThread(() -> {
            ProgressBar pr = findViewById(R.id.progressBar_List);
            pr.setVisibility(View.INVISIBLE);
        });

    }


    Runnable addResultToViewList = () -> {
        ButterKnife.bind(this);

        arrayListAddBegin.setText(String.valueOf(FillView.speedAddBeginToList(arrayList)));
        linkedListAddBegin.setText(String.valueOf(FillView.speedAddBeginToList(linkedList)));
        copyOnWriteAddBegin.setText(String.valueOf(FillView.speedAddBeginToList(copyOnWriteArrayList)));

        arrayListAddMiddle.setText(String.valueOf(FillView.speedAddMiddleToList(arrayList)));
        linkedListAddMiddle.setText(String.valueOf(FillView.speedAddMiddleToList(linkedList)));
        copyOnWriteAddMiddle.setText(String.valueOf(FillView.speedAddMiddleToList(copyOnWriteArrayList)));

        arrayListAddEnd.setText(String.valueOf(FillView.speedAddEndToList(arrayList)));
        linkedListAddEnd.setText(String.valueOf(FillView.speedAddEndToList(linkedList)));
        copyOnWriteAddEnd.setText(String.valueOf(FillView.speedAddEndToList(copyOnWriteArrayList)));

        arrayListSearch.setText(String.valueOf(FillView.speedSearchInList(arrayList)));
        linkedListSearch.setText(String.valueOf(FillView.speedSearchInList(linkedList)));
        copyOnWriteSearch.setText(String.valueOf(FillView.speedSearchInList(copyOnWriteArrayList)));

        arrayListRemoveBegin.setText(String.valueOf(FillView.speedRemoveBeginToList(arrayList)));
        linkedListRemoveBegin.setText(String.valueOf(FillView.speedRemoveBeginToList(linkedList)));
        copyOnWriteRemoveBegin.setText(String.valueOf(FillView.speedRemoveBeginToList(copyOnWriteArrayList)));

        arrayListRemoveMiddle.setText(String.valueOf(FillView.speedRemoveMiddleToList(arrayList)));
        linkedListRemoveMiddle.setText(String.valueOf(FillView.speedRemoveMiddleToList(linkedList)));
        copyOnWriteRemoveMiddle.setText(String.valueOf(FillView.speedRemoveMiddleToList(copyOnWriteArrayList)));

        arrayListRemoveEnd.setText(String.valueOf(FillView.speedRemoveEndToList(arrayList)));
        linkedListRemoveEnd.setText(String.valueOf(FillView.speedRemoveEndToList(linkedList)));
        copyOnWriteRemoveEnd.setText(String.valueOf(FillView.speedRemoveEndToList(copyOnWriteArrayList)));


    };

    private void fillMap() {
        runOnUiThread(() -> {
            ProgressBar pr = findViewById(R.id.progressBar_Map);
            pr.setVisibility(View.VISIBLE);
        });
        CountDownLatch cd = new CountDownLatch(2);
        Thread threadAddBeginTree = new Thread(new TreeMapElements(amountAddElementMap, treeMap, cd));
        Thread threadAddBeginHas = new Thread(new HashMapElements(amountAddElementMap, hashMap, cd));

        threadAddBeginTree.start();
        threadAddBeginHas.start();

        try {
            cd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runOnUiThread(() -> {
            ProgressBar pr = findViewById(R.id.progressBar_Map);
            pr.setVisibility(View.INVISIBLE);
        });
    }

    Runnable addResultToViewMap = () -> {
        ButterKnife.bind(this);
        treeMapAdd.setText(String.valueOf(FillView.speedAddToMap(treeMap)));
        treeMapSearchKey.setText(String.valueOf(FillView.speedSearchInMap(treeMap)));
        treeMapremove.setText(String.valueOf(FillView.speedRemovInMap(treeMap)));

        hashMapAdd.setText(String.valueOf(FillView.speedAddToMap(hashMap)));
        hashMapSearchKey.setText(String.valueOf(FillView.speedSearchInMap(hashMap)));
        hashMapRemove.setText(String.valueOf(FillView.speedRemovInMap(hashMap)));

    };


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
        EditText amountElements = findViewById(R.id.mainActivity_amount_element);
        amountElements.setVisibility(View.INVISIBLE);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(amountElements.getWindowToken(), 0);
        FloatingActionButton faButtn = findViewById(R.id.mainActivity_float_button);
        faButtn.setVisibility(View.VISIBLE);

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {


    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("treeMapAdd", treeMapAdd.getText().toString());
        outState.putString("treeMapSearchKey", treeMapSearchKey.getText().toString());
        outState.putString("treeMapremove", treeMapremove.getText().toString());
        outState.putString("hashMapAdd", hashMapAdd.getText().toString());
        outState.putString("hashMapSearchKey", hashMapSearchKey.getText().toString());
        outState.putString("hashMapRemove", hashMapRemove.getText().toString());
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

    private void initView(Bundle savedInstanceState) {

        if (savedInstanceState.containsKey("treeMapAdd")) {

            treeMapAdd.setText(savedInstanceState.getString("treeMapAdd"));
            treeMapSearchKey.setText(savedInstanceState.getString("treeMapSearchKey"));
            treeMapremove.setText(savedInstanceState.getString("treeMapremove"));
            hashMapAdd.setText(savedInstanceState.getString("hashMapAdd"));
            hashMapSearchKey.setText(savedInstanceState.getString("hashMapSearchKey"));
            hashMapRemove.setText(savedInstanceState.getString("hashMapRemove"));
        }

        if (savedInstanceState.containsKey("arrayListAddBegin")) {

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


    }
}
