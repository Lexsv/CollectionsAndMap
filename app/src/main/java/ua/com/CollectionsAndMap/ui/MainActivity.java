package ua.com.CollectionsAndMap.ui;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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

    public interface DataCalculation {
        void onClickCalculation(int position);
        void upData();
    }

    private DataCalculation datacalculation;
    private ViewPager viewPager;
    private PagerAdapt pagerAdapter;
    private TabLayout tabLayout;
    private int amoutElements;
    private AlertDialog showProgress;
    @Inject
    MainPresent mainPresent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTab();
        addDaggerDepend();
        mainPresent.build();
        datacalculation = mainPresent;
        if (savedInstanceState != null) {
            datacalculation.upData();
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

        pagerAdapter = new PagerAdapt(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager = findViewById(R.id.mainActivity_pager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void addAlertDialog() {
        AlertDialog.Builder addElementAlert = new AlertDialog.Builder(this);
        addElementAlert.setTitle("Add Element");
        addElementAlert.setView(R.layout.loader_view);
        addElementAlert.setIcon(R.drawable.database);
        addElementAlert.setPositiveButton("Посчитать", (dialog, which) -> {
            EditText editTextInLoad = ((AlertDialog) dialog).findViewById(R.id.loaderView_amount_elements);
            amoutElements = (valueOf(editTextInLoad.getText().toString()));
            datacalculation.onClickCalculation(viewPager.getCurrentItem());
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


    public int getAmoutElements() {
        return amoutElements;
    }
    private void addDaggerDepend (){
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModul(new AppModul(this))
                .presentModule(new PresentModule()).build();
        appComponent.inject(this);
    }

    public Fragment getFragment(int position){
        return pagerAdapter.getItem(position);
    }


    public void shoeProgress() {
        showProgress = new AlertDialog.Builder(this)
                .setView(R.layout.loader_view_progress)
                .setCancelable(false)
                .create();
        showProgress.show();
    }


    public void hidProgress() {
        showProgress.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresent.onDestroy();
    }
}
