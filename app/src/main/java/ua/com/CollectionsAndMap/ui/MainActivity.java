package ua.com.CollectionsAndMap.ui;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import javax.inject.Inject;

import ua.com.CollectionsAndMap.R;
import ua.com.CollectionsAndMap.ui.dagger.component.AppComponent;
import ua.com.CollectionsAndMap.ui.dagger.component.DaggerAppComponent;
import ua.com.CollectionsAndMap.ui.dagger.modules.AppModul;
import ua.com.CollectionsAndMap.ui.dagger.modules.PresentModule;
import ua.com.CollectionsAndMap.ui.fragment.PagerAdapt;
import ua.com.CollectionsAndMap.ui.presentation.MainPresent;
import static java.lang.Integer.valueOf;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    public interface ClickCalculation {
        void onClickCalculation();
        void upData();
    }

    private ClickCalculation clickcalculation;
    private ViewPager viewPager;
    private PagerAdapt pagerAdapter;
    private TabLayout tabLayout;
    private int amoutElements;
    @Inject
    MainPresent mainPresent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppComponent appComponent = DaggerAppComponent.builder()
                                     .appModul(new AppModul(this))
                                      .presentModule(new PresentModule()).build();
        appComponent.inject(this);
        initTab();
        clickcalculation = mainPresent;
        if (savedInstanceState != null) {
            mainPresent.setViewPager(viewPager);
            clickcalculation.upData();
        }
        FloatingActionButton faButtn = findViewById(R.id.mainActivity_float_button);
        faButtn.setOnClickListener(view -> addAlertDialog());
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
            amoutElements = (valueOf(editTextInLoad.getText().toString()));
            clickcalculation.onClickCalculation();
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

    public ViewPager getViewPager() {
        return viewPager;
    }

    public int getAmoutElements() {
        return amoutElements;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresent.onDestroy();
    }
}
