package com.paragonfervour.syrok.bottomtoolbar.activity;

import android.os.Bundle;
import android.view.Menu;

import com.paragonfervour.syrok.bottomtoolbar.view.BottomActionBar;

import roboguice.activity.RoboActionBarActivity;


public class BottomActionBarActivity extends RoboActionBarActivity {

    private BottomActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mActionBar.setMenu(menu);
        return true;
    }

    public void setBottomActionBar(BottomActionBar actionBar) {
        mActionBar = actionBar;
    }

    public BottomActionBar getBottomActionBar() {
        return mActionBar;
    }
}
