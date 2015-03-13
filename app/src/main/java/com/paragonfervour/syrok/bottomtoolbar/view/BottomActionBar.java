package com.paragonfervour.syrok.bottomtoolbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

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
    private Menu mMenu;
    private ViewGroup mActionButtonLayout;

    // region constructors
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
        View view = inflate(getContext(), R.layout.bottom_actionbar_main, this);
        mActionButtonLayout = (ViewGroup)view.findViewById(R.id.bab_layout);
    }

    // endregion

    public void setOnMenuItemClickListener(OnMenuItemClickListener listener) {
        mItemClickListener = listener;
    }

    public void setMenu(Menu menu) {
        mMenu = menu;
        buildActionButtons();
    }

    // region local methods

    public void inflateMenu(int menuResId) {
        MenuInflater inflater = new MenuInflater(getContext());
        inflater.inflate(menuResId, mMenu);
        buildActionButtons();
    }

    private void buildActionButtons() {
        if (mMenu == null) {
            return;
        }
        for (int i = 0; i < mMenu.size(); i++) {
            BottomActionButton button = new BottomActionButton(getContext());
            // layout params
            int padding = (int)getContext().getResources().getDimension(R.dimen.action_button_padding);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(padding, 0, padding, 0);
            params.gravity = Gravity.CENTER_VERTICAL;
            button.setLayoutParams(params);

            MenuItem item = mMenu.getItem(i);
            button.setOnClickListener(new MenuItemClickListener(item));
            button.setOnLongClickListener(new MenuItemLongClickListener(item));
            button.setActionIcon(item.getIcon());
            button.setActionTitle(item.getTitle());
            mActionButtonLayout.addView(button);
        }
    }

    // endregion

    private class MenuItemLongClickListener implements OnLongClickListener {
        private MenuItem mItem;
        public MenuItemLongClickListener(MenuItem item) {
            mItem = item;
        }
        @Override
        public boolean onLongClick(View v) {
            Toast.makeText(v.getContext(), mItem.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private class MenuItemClickListener implements OnClickListener {
        private MenuItem mItem;
        public MenuItemClickListener(MenuItem item) {
            mItem = item;
        }
        @Override
        public void onClick(View v) {
            if(mItemClickListener != null) {
                mItemClickListener.onMenuItemClick(mItem);
            }
        }
    }
}
