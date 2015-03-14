package com.paragonfervour.syrok.bottomtoolbar.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.paragonfervour.bottombar.view.BottomActionBar;
import com.paragonfervour.bottombar.view.activity.BottomActionBarActivity;
import com.paragonfervour.syrok.bottomtoolbar.R;

import roboguice.inject.InjectView;


public class MainActivity extends BottomActionBarActivity {

    @InjectView(R.id.main_bottom_actionbar)
    BottomActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBottomActionBar(mActionBar);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
