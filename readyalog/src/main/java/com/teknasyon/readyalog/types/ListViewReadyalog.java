package com.teknasyon.readyalog.types;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.widget.ListView;

/**
 * Created by ali on 17/05/16.
 */
public class ListViewReadyalog extends CustomContentReadyalog {

    public ListViewReadyalog(Context context) {
        super(context);
    }

    public ListView getListViewId(@IdRes int listViewId) {
        return (ListView) findByIdInReadyalogContent(listViewId);
    }

    @Override
    protected AlertDialog.Builder configExtras(@NonNull AlertDialog.Builder builder) {
        return builder.setView(contentView);
    }
}
