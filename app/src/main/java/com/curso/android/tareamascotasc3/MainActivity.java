package com.curso.android.tareamascotasc3;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.curso.android.tareamascotasc3.adapters.PageAdapter;
import com.curso.android.tareamascotasc3.vista.fragments.RVFotosMascotaFragment;
import com.curso.android.tareamascotasc3.vista.fragments.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //para viewPager y fragment
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

    }

    /*********************************
     * INICIO MENÚ OPCIONES
     *****************************************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mContacto:
                Intent email = new Intent(MainActivity.this, Contacto.class);
                startActivity(email);
                break;
            case R.id.mAcercade:
                Intent acercade = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(acercade);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /*******************************
     * FIN MENÚ OPCIONES
     **********************************************/

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new RVFotosMascotaFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);
    }
}
