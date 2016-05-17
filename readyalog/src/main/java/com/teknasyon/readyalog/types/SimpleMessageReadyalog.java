package com.teknasyon.readyalog.types;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;

import com.teknasyon.readyalog.core.ReadyalogAlertBuilder;

/**
 * Created by ali on 16/05/16.
 */
public class SimpleMessageReadyalog extends ReadyalogAlertBuilder<SimpleMessageReadyalog> {

    public int message;

    public SimpleMessageReadyalog(Context context) {
        super(context);
    }

    public SimpleMessageReadyalog setReadyalogMessage(@StringRes int message) {
        this.message = message;
        return this;
    }

    @Override
    protected AlertDialog.Builder configExtras(@NonNull AlertDialog.Builder builder) {
        builder.setMessage(message);
        return builder;
    }

}
