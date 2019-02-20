package com.example.androidtest.preference;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidtest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreferenceFragment extends PreferenceFragmentCompat {

    public static PreferenceFragment newInstance(){
        return new PreferenceFragment();
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String rootKey) {
        setPreferencesFromResource(R.xml.preference, rootKey);
    }
}
