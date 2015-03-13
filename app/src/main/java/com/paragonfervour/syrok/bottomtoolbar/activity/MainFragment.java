package com.paragonfervour.syrok.bottomtoolbar.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.paragonfervour.syrok.bottomtoolbar.R;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;


public class MainFragment extends RoboFragment {
    @InjectView(R.id.fragment_button)
    Button mButton;

    public MainFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup items = (ViewGroup)getActivity().findViewById(R.id.bab_layout);
                Log.d("JON", "Items " + items.getChildCount());
            }
        });
    }
}
