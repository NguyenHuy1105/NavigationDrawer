package com.example.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnCreateContextMenuListener{
    private static final int FRAGMENT_MAYTINH=0;
    private static final int FRAGMENT_COSO=1;
    private static final int FRAGMENT_HESO=2;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ListView listView;
    ArrayList<itemMenu> arrayList;
    menuAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        actionToolbar();
        actionMenu();
    }

    private void actionMenu() {
        arrayList=new ArrayList<>();
        arrayList.add(new itemMenu("máy tính", R.drawable.ic_baseline_calculate_24));
        arrayList.add(new itemMenu("chuyển đổi cơ số", R.drawable.ic_baseline_filter_2_24));
        arrayList.add(new itemMenu("chuyển đổi đơn vị", R.drawable.ic_baseline_cached_24));
        adapter= new menuAdapter(this, R.layout.dongitem,arrayList);
        listView.setAdapter(adapter);
    }

    private void actionToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
            }

    private void anhxa() {
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        drawerLayout=(DrawerLayout) findViewById(R.id.drawerlayout);
        navigationView=(NavigationView) findViewById(R.id.navigationView);
        listView=(ListView) findViewById(R.id.lv);
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_fame,fragment);
    }
}