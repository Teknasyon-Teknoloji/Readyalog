package com.teknasyon.readyalog.types;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.StringRes;
import android.widget.DatePicker;

import com.teknasyon.readyalog.Readyalog;
import com.teknasyon.readyalog.core.ReadyalogFactory;

import java.util.Calendar;

/**
 * Created by ali on 16/05/16.
 */
public class DatePickerReadyalog extends ReadyalogFactory<DatePickerReadyalog> implements DatePickerDialog.OnDateSetListener {

    int day;
    int month;
    int year;

    CharSequence positiveButtonText = null;
    CharSequence negativeButtonText = null;

    Calendar calendar;
    ReadyalogDatePickerButtonListener buttonClickListener;

    public DatePickerReadyalog(Context context) {
        super(context);
        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
    }

    public DatePickerReadyalog setReadyalogDay(int day) {
        this.day = day;
        return this;
    }

    public DatePickerReadyalog setReadyalogMonth(int month) {
        this.month = month;
        return this;
    }

    public DatePickerReadyalog setReadyalogYear(int year) {
        this.year = year;
        return this;
    }

    public DatePickerReadyalog setReadyalogPositiveButtonText(@StringRes CharSequence positiveButtonText) {
        this.positiveButtonText = positiveButtonText;
        return this;
    }

    public DatePickerReadyalog setReadyalogNegativeButtonText(@StringRes CharSequence negativeButtonText) {
        this.negativeButtonText = negativeButtonText;
        return this;
    }

    public DatePickerReadyalog setReadyalogButtonClickListener(ReadyalogDatePickerButtonListener buttonClickListener) {
        this.buttonClickListener = buttonClickListener;
        return this;
    }

    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (buttonClickListener != null) {
                DatePicker picker = ((DatePickerDialog) dialog).getDatePicker();
                day = picker.getDayOfMonth();
                month = picker.getMonth() + 1;
                year = picker.getYear();
                buttonClickListener.onDateSelected(dialog, which, year, month, day);
            }
        }
    };

    @Override
    public Readyalog build() {
        dialog = new DatePickerDialog(getContext(), this, year, month, day);
        if (positiveButtonText != null) ((DatePickerDialog) dialog)
                .setButton(DialogInterface.BUTTON_POSITIVE, positiveButtonText, onClickListener);
        if (negativeButtonText != null) ((DatePickerDialog) dialog)
                .setButton(DialogInterface.BUTTON_NEGATIVE, negativeButtonText, onClickListener);
        return new Readyalog(this);
    }

    @Override
    public void onDateSet(DatePicker view, int y, int moy, int dom) {
        year = y;
        month = moy + 1;
        day = dom;
    }

    public interface ReadyalogDatePickerButtonListener {
        void onDateSelected(DialogInterface dialog, int whichButton, int year, int monthOfYear, int dayOfMonth);
    }
}
