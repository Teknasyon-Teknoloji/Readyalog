package com.teknasyon.readyalog.core;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;

import com.teknasyon.readyalog.Readyalog;

/**
 * Created by ali on 16/05/16.
 */
public abstract class ReadyalogAlertBuilder<T> extends ReadyalogFactory<ReadyalogAlertBuilder> {

    protected AlertDialog.Builder builder;
    protected OnClickListener listener;
    protected int positiveButtonText = 0;
    protected int negativeButtonText = 0;
    protected int neutralButtonText = 0;

    public ReadyalogAlertBuilder(Context context) {
        super(context);
    }

    public T setReadyalogButtonListener(OnClickListener listener) {
        this.listener = listener;
        return (T) this;
    }

    public T setReadyalogPositiveButtonText(int positiveButtonText) {
        this.positiveButtonText = positiveButtonText;
        return (T) this;
    }

    public T setReadyalogNegativeButtonText(int negativeButtonText) {
        this.negativeButtonText = negativeButtonText;
        return (T) this;
    }

    public T setReadyalogNeutralButtonText(int neutralButtonText) {
        this.neutralButtonText = neutralButtonText;
        return (T) this;
    }

    protected abstract AlertDialog.Builder configExtras(@NonNull AlertDialog.Builder builder);

    @Override
    public Readyalog build() {
        builder = new AlertDialog.Builder(getContext(), style)
                .setCancelable(isCancellable);

        if (positiveButtonText != 0) builder.setPositiveButton(positiveButtonText, listener);
        if (negativeButtonText != 0) builder.setNegativeButton(negativeButtonText, listener);
        if (neutralButtonText != 0) builder.setNeutralButton(neutralButtonText, listener);
        if (title != 0) builder.setTitle(title);

        dialog = configExtras(builder).create();
        return new Readyalog(this);
    }
}
