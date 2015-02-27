package com.paragonfervour.syrok.bottomtoolbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.paragonfervour.syrok.bottomtoolbar.R;

/**
 * Action bar that sits on the bottom of the screen and expands up to show details.
 * * Expanded action bar contains extra actions and labels below actionbutton icons.
 * * Bottom action bar does not feature an Up button.
 */
public class BottomActionBar extends LinearLayout {

    public interface OnMenuItemClickListener {
        public boolean onMenuItemClick(MenuItem item);
    }

    private static final String TAG = BottomActionBar.class.getSimpleName();

    private OnMenuItemClickListener mItemClickListener;

    public BottomActionBar(Context context) {
        super(context);
        init();
    }

    public BottomActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BottomActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.bottom_actionbar_main, this, false);
        this.addView(view);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener listener) {
        mItemClickListener = listener;
    }

    public void inflateMenu(int menuResId) {
        // todo: figure out how to use a custom Menu.
//        MenuInflater inflater = new MenuInflater(getContext());
    }

}
