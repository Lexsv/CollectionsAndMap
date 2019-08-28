package ua.com.CollectionsAndMap.ui;

import android.os.Bundle;

import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import ua.com.CollectionsAndMap.R;
import ua.com.CollectionsAndMap.domain.model.MapModels.HashMapModel;
import ua.com.CollectionsAndMap.ui.fragment.PagerAdapt;
import ua.com.CollectionsAndMap.ui.fragment.TabCollection;
import ua.com.CollectionsAndMap.ui.fragment.TabMap;
import ua.com.CollectionsAndMap.ui.presentation.Present;

import static java.lang.Integer.valueOf;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {


    private ViewPager viewPager;
    private PagerAdapt pagerAdapter;
    private TabLayout tabLayout;
    private Present present;
    private int amoutElements;
    private AlertDialog showProgress;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTab();
        present = new Present(this, viewPager);
        FloatingActionButton faButtn = findViewById(R.id.mainActivity_float_button);
        faButtn.setOnClickListener(view -> {
            addAlertDialog();
        });


    }

    private void initTab() {
        tabLayout = findViewById(R.id.mainActivity_tabsLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Collections"));
        tabLayout.addTab(tabLayout.newTab().setText("Map"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addOnTabSelectedListener(this);

        viewPager = findViewById(R.id.mainActivity_pager);
        pagerAdapter = new PagerAdapt(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void addAlertDialog() {
        AlertDialog.Builder addElementAlert = new AlertDialog.Builder(this);
        addElementAlert.setTitle("Add Element");
        addElementAlert.setView(R.layout.loader_view);
        addElementAlert.setIcon(R.drawable.database);
        addElementAlert.setPositiveButton("Добавить",(dialog, which) -> {
            EditText editTextInLoad = ((AlertDialog) dialog).findViewById(R.id.loaderView_amount_elements);
            amoutElements = (valueOf(editTextInLoad.getText().toString()));
            present.showDataView(amoutElements);
            dialog.cancel();
        });
        addElementAlert.create();
        addElementAlert.show();

    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {


    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {


    }

    public void shoeProgress() {
        showProgress = new AlertDialog.Builder(viewPager.getContext())
                .setView(R.layout.loader_view_progress)
                .setCancelable(false)
                .create();
        showProgress.show();
    }

    public  void fillViewToFragment (ArrayList<Integer> list){
       TabCollection fragment = (TabCollection) pagerAdapter.getItem(viewPager.getCurrentItem());
       fragment.fillResult(list);
    }
    public  void fillViewToFragment (HashMap<Byte, Byte> list){
        TabMap fragment = (TabMap) pagerAdapter.getItem(viewPager.getCurrentItem());
        fragment.fillResult(list);
    }
    public  void fillViewToFragment (TreeMap<Byte, Byte> list){
        TabMap fragment = (TabMap) pagerAdapter.getItem(viewPager.getCurrentItem());
        fragment.fillResult(list);
    }

    public  void fillViewToFragment (LinkedList<Byte> list){
        TabCollection fragment = (TabCollection) pagerAdapter.getItem(viewPager.getCurrentItem());
        fragment.fillResult(list);
    }
    public  void fillViewToFragment (CopyOnWriteArrayList<Integer> list){
        TabCollection fragment = (TabCollection) pagerAdapter.getItem(viewPager.getCurrentItem());
        fragment.fillResult(list);
    }
    public void hidProgress() {showProgress.cancel();}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        present.onDestroy();
    }
}
