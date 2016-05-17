package com.teknasyon.readyalog.types;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.teknasyon.readyalog.core.ReadyalogAlertBuilder;

/**
 * Created by ali on 17/05/16.
 */
public class CustomContentReadyalog extends ReadyalogAlertBuilder<CustomContentReadyalog> {

    View contentView;

    public CustomContentReadyalog(Context context) {
        super(context);
    }

    public <T extends CustomContentReadyalog> T setReadyalogLayout(@LayoutRes int layoutRes) {
        contentView = LayoutInflater.from(getContext()).inflate(layoutRes, null);
        return (T) this;
    }

    public View findByIdInReadyalogContent(@IdRes int id) {
        return contentView.findViewById(id);
    }

    @Override
    protected AlertDialog.Builder configExtras(@NonNull AlertDialog.Builder builder) {
        return builder.setView(contentView);
    }
}
