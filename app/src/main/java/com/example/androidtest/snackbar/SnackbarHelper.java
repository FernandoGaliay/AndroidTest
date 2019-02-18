package com.example.androidtest.snackbar;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.example.androidtest.R;

public class SnackbarHelper {

    public static void show(Context context, View view) {
        show(context, view, context.getResources().getString(R.string.dashboard_snackbar_message));
    }

    public static void show(Context context, View view, String message) {
        if (view == null) {
            return;
        }
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        snackbar.setAction(R.string.snackbar_action_click, itemView -> snackbar.dismiss());
        snackbar.setActionTextColor(context.getResources().getColor(R.color.colorAccent));
        snackbar.addCallback(new Snackbar.Callback() {
            @Override
            public void onDismissed(Snackbar transientBottomBar, int event) {
                super.onDismissed(transientBottomBar, event);
            }

            @Override
            public void onShown(Snackbar sb) {
                super.onShown(sb);
            }
        });
        snackbar.show();
    }
}
