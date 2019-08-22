package ua.com.CollectionsAndMap.domain;

import android.app.Instrumentation;
import android.content.Context;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;


import ua.com.CollectionsAndMap.R;
import ua.com.CollectionsAndMap.ui.fragment.PagerAdapt;
import ua.com.CollectionsAndMap.ui.presentation.Present;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {


    private ViewPager viewPager;
    private PagerAdapt pagerAdapter;
    private TabLayout tabLayout;
    private Present present = new Present();
    private int amoutElements;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTab();
        present.setViewPager(viewPager);
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
        addElementAlert.setPositiveButton("Добавить", (dialog, which) -> {
            EditText editTextInLoad = ((AlertDialog) dialog).findViewById(R.id.loaderView_amount_elements);
            amoutElements = (Integer.valueOf(editTextInLoad.getText().toString()));
            showProgress();
            new Thread(()->{
                present.setAmoutElement(amoutElements);
                runOnUiThread(()-> {
                    present.showDataView();
                    // Событие закрытия AlertDialog.Builder showProgress
                });
            }).start();
        });
        addElementAlert.create();
        addElementAlert.show();
    }

    private void showProgress() {
        AlertDialog.Builder showProgress = new AlertDialog.Builder(this);
        showProgress.setView(R.layout.loader_view_progress);
        showProgress.create();
        showProgress.show();
    }

    private void showKeyBoard(View v) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT);
    }

    private void hideKeyBoard(View v) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
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

}
