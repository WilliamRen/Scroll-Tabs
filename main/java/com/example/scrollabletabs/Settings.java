package com.example.scrollabletabs;

import android.os.Bundle;
import android.preference.PreferenceActivity;


public class Settings extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.layout.settings);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
