package com.paragonfervour.syrok.bottomtoolbar.activity;

import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

import com.paragonfervour.syrok.bottomtoolbar.view.BottomActionBar;


public class BottomActionBarActivity extends ActionBarActivity {
    private BottomActionBar mActionBar;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mActionBar.setMenu(menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void setBottomActionBar(BottomActionBar actionBar) {
        mActionBar = actionBar;
    }

    public BottomActionBar getBottomActionBar() {
        return mActionBar;
    }
}
