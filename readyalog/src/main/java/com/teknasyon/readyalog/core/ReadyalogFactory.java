package com.teknasyon.readyalog.core;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;

import com.teknasyon.readyalog.Readyalog;

/**
 * Created by ali on 16/05/16.
 */
public abstract class ReadyalogFactory <T extends ReadyalogFactory> extends Dialog {

    public boolean isCancellable = true;
    public int title = 0;
    public Dialog dialog;
    public int style;

    public ReadyalogFactory(Context context) {
        super(context);
    }

    public T setReadyalogCancellable(boolean isCancellable) {
        this.isCancellable = isCancellable;
        return (T) this;
    }

    public T setReadyalogTitle(@StringRes int title) {
        this.title = title;
        return (T) this;
    }

    public T setReadyalogStyle(@StyleRes int style) {
        this.style = style;
        return (T) this;
    }

    public abstract Readyalog build();
}
