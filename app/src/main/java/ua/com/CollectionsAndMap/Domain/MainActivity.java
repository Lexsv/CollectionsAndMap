package ua.com.CollectionsAndMap.Domain;

import android.content.Context;

import android.os.Bundle;
import android.view.View;

import android.view.inputmethod.InputMethodManager;

import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;


import butterknife.BindView;
import ua.com.CollectionsAndMap.R;
import ua.com.CollectionsAndMap.Ui.fragment.PagerAdapt;
import ua.com.CollectionsAndMap.Ui.presentation.Present;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = findViewById(R.id.mainActivity_tabsLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Collections"));
        tabLayout.addTab(tabLayout.newTab().setText("Map"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addOnTabSelectedListener(this);

        viewPager = findViewById(R.id.mainActivity_pager);
        final PagerAdapt pagerAdapter = new PagerAdapt(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        Present present = new Present();
        present.setPagerAdapt(pagerAdapter);


        FloatingActionButton faButtn = findViewById(R.id.mainActivity_float_button);
        faButtn.setOnClickListener(view -> {

            AlertDialog.Builder ratingdialog = new AlertDialog.Builder(this);
            ratingdialog.setPositiveButton("Готово", (dialog, which) -> {
                dialog.dismiss();

            })
                    .setNegativeButton("Отмена",
                            (dialog, id) -> dialog.cancel());
            ratingdialog.setTitle("Add Element");
            ratingdialog.setView(R.layout.loader_view);
            ratingdialog.setIcon(R.drawable.database);
            ratingdialog.create();
            ratingdialog.show();
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
