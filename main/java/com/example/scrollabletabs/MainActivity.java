package com.example.scrollabletabs;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.support.v4.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.app.ActionBar.TabListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.action_about:
                aboutMenuItem();
                break;
            case R.id.action_settings:
                Intent intent = new Intent(getApplicationContext(), Settings.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void aboutMenuItem() {
        new AlertDialog.Builder(this)
            .setTitle("Sample Mesage")
                .setMessage("Sample Message Text")
                .setNeutralButton("Sample Message Button Text", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                }).show();
    }
}

class MyAdapter extends FragmentStatePagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0) {
        Fragment fragment = null;
        if (arg0 == 0) {
            fragment = new FragmentA();
        }
        if (arg0 == 1) {
            fragment = new FragmentB();
        }
        if (arg0 == 2) {
            fragment = new FragmentC();
        }
        if (arg0 == 3) {
            fragment = new FragmentD();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Tab 1";
        }
        if (position == 1) {
            return "Tab 2";
        }
        if (position == 2) {
            return "Tab 3";
        }
        if (position == 3) {
            return "Tab 4";
        }
        return null;
    }
}
