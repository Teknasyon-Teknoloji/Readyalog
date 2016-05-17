package com.teknasyon.readyalog.core;

import android.app.Dialog;
import android.os.Bundle;

/**
 * Created by ali on 16/05/16.
 */
public abstract class BaseReadyalog extends Dialog {

    protected ReadyalogFactory builder;

    public BaseReadyalog(ReadyalogFactory builder) {
        super(builder.getContext(), builder.style);
        this.builder = builder;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (builder.title != 0)
            setTitle(builder.title);
    }

    public void showReadyalog() {
        Dialog dialog = builder.dialog;
        if (dialog != null && !dialog.isShowing())
            dialog.show();
    }

    public void dismissReadylog() {
        Dialog dialog = builder.dialog;
        if (dialog != null && dialog.isShowing())
            dialog.dismiss();
    }
}
