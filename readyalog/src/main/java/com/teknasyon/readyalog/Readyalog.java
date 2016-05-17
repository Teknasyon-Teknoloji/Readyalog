package com.teknasyon.readyalog;

import android.content.Context;

import com.teknasyon.readyalog.core.BaseReadyalog;
import com.teknasyon.readyalog.core.ReadyalogFactory;
import com.teknasyon.readyalog.types.CustomContentReadyalog;
import com.teknasyon.readyalog.types.DatePickerReadyalog;
import com.teknasyon.readyalog.types.ListViewReadyalog;
import com.teknasyon.readyalog.types.SimpleMessageReadyalog;

/**
 * Created by ali on 16/05/16.
 */
public class Readyalog extends BaseReadyalog {

    public Readyalog(ReadyalogFactory builder) {
        super(builder);
    }

    /**
     * init your customized dialogs here.
     */
    public static class ReadyalogBuilder {

        Context context;

        public ReadyalogBuilder(Context context) {
            this.context = context;
        }

        public SimpleMessageReadyalog createSimpleMessageReadyalog() {
            return new SimpleMessageReadyalog(context);
        }

        public DatePickerReadyalog createDatePickerReadyalog() {
            return new DatePickerReadyalog(context);
        }

        public CustomContentReadyalog createCustomContentReadyalog() {
            return new CustomContentReadyalog(context);
        }

        public ListViewReadyalog createListViewReadyalog() {
            return new ListViewReadyalog(context);
        }
    }
}
