package ua.com.CollectionsAndMap;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
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


        final EditText amountElements = findViewById(R.id.mainActivity_amount_element);


        FloatingActionButton faButtn = findViewById(R.id.mainActivity_float_button);
        faButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (amElemVisebl) {
                    amountElements.setVisibility(View.VISIBLE);
                    amElemVisebl = !amElemVisebl;
                    showKeyBoard(amountElements);
                } else {
                    amountElements.setVisibility(View.INVISIBLE);
                    amElemVisebl = !amElemVisebl;
                }

            }
        });

        amountElements.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE) {
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
            }
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

        TextView arrayListAddBegin = findViewById(R.id.arrayList_addBagin);
        TextView arrayListAddMiddle = findViewById(R.id.arrayList_addMiddle);
        TextView arrayListAddEnd = findViewById(R.id.arrayList_addEnd);
        TextView arrayListSearch = findViewById(R.id.arrayList_search);
        TextView arrayListRemoveBegin = findViewById(R.id.arrayList_removeBagin);
        TextView arrayListRemoveMiddle = findViewById(R.id.arrayList_ramoveMidlle);
        TextView arrayListRemoveEnd = findViewById(R.id.arrayList_removeEnd);

        TextView linkedListAddBegin = findViewById(R.id.linkedList_addBagin);
        TextView linkedListAddMiddle = findViewById(R.id.linkedList_addMiddle);
        TextView linkedListAddEnd = findViewById(R.id.linkedList_addEnd);
        TextView linkedListSearch = findViewById(R.id.linkedList_search);
        TextView linkedListRemoveBegin = findViewById(R.id.linkedList_removeBagin);
        TextView linkedListRemoveMiddle = findViewById(R.id.linkedList_ramoveMidlle);
        TextView linkedListRemoveEnd = findViewById(R.id.linkedList_removeEnd);

        TextView copyOnWriteAddBegin = findViewById(R.id.copyOn_write_addBagin);
        TextView copyOnWriteAddMiddle = findViewById(R.id.copyOn_write_addMiddle);
        TextView copyOnWriteAddEnd = findViewById(R.id.copyOn_write_addEnd);
        TextView copyOnWriteSearch = findViewById(R.id.copyOn_write_search);
        TextView copyOnWriteRemoveBegin = findViewById(R.id.copyOn_write_removeBagin);
        TextView copyOnWriteRemoveMiddle = findViewById(R.id.copyOn_write_ramoveMidlle);
        TextView copyOnWriteRemoveEnd = findViewById(R.id.copyOn_write_removeEnd);


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

        TextView treeMapAdd = findViewById(R.id.treeMap_add);
        TextView treeMapSearchKey = findViewById(R.id.treeMap_SearchKey);
        TextView treeMapremove = findViewById(R.id.treeMap_remove);

        TextView hashMapAdd = findViewById(R.id.hashMap_add);
        TextView hashMapSearchKey = findViewById(R.id.hashMap_SearchKey);
        TextView hashMapRemove = findViewById(R.id.hashMap_remove);

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
    }
}
