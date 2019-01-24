package com.example.androidtest.contraint;

import android.support.constraint.Group;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.androidtest.BaseFragment;
import com.example.androidtest.R;

public class BasicsContraintsFragment extends BaseFragment {

    private Group labelsGroup;

    private EditText titleInput;

    public static BasicsContraintsFragment newInstance() {
        BasicsContraintsFragment fragment = new BasicsContraintsFragment();
        return fragment;
    }

    @Override
    protected int fragmentLayout() {
        return R.layout.fragment_basics_contraint;
    }

    @Override
    protected void configureToolbar(Toolbar toolbar) {
        toolbar.setTitle(R.string.basics_contraints_title);
    }

    @Override
    protected void setupView(View view) {
        labelsGroup = view.findViewById(R.id.basic_constraints_labels_group);
        titleInput = view.findViewById(R.id.basic_constraints_title_input);
        setupTitleInput(titleInput);
    }

    private void setupTitleInput(EditText titleInput) {
        if (titleInput == null) {
            return;
        }
        titleInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Nothing to do
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    labelsGroup.setVisibility(View.VISIBLE);
                } else {
                    labelsGroup.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Nothing to do
            }
        });
    }
}
