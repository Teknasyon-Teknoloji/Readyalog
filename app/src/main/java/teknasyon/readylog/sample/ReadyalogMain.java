package teknasyon.readylog.sample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.teknasyon.readyalog.Readyalog;
import com.teknasyon.readyalog.types.DatePickerReadyalog;
import com.teknasyon.readyalog.types.ListViewReadyalog;

import java.util.Locale;

public class ReadyalogMain extends AppCompatActivity {

    private static final String TAG = ReadyalogMain.class.getName();

    ListView typesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readyalog_main);

        typesList = (ListView) findViewById(R.id.typesList);
        typesList.setAdapter(getAdapter(R.array.types));

        typesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showReadyalog(position);
            }
        });
    }

    private void showReadyalog(int position) {
        switch (position) {
            case 0: //simple message
                new Readyalog.ReadyalogBuilder(this)
                        .createSimpleMessageReadyalog()
                        .setReadyalogPositiveButtonText(R.string.ok)
                        .setReadyalogNegativeButtonText(R.string.cancel)
                        .setReadyalogNeutralButtonText(R.string.not_now)
                        .setReadyalogMessage(R.string.message_long_message)
                        .setReadyalogStyle(R.style.ReadyalogStyle)
                        .setReadyalogTitle(R.string.app_name)
                        .setReadyalogCancellable(false)
                        .build()
                        .showReadyalog();
                break;
            case 1: //date picker
                new Readyalog.ReadyalogBuilder(this)
                        .createDatePickerReadyalog()
                        .setReadyalogPositiveButtonText(getString(R.string.ok))
                        .setReadyalogNegativeButtonText(getString(R.string.cancel))
                        .setReadyalogButtonClickListener(new DatePickerReadyalog.ReadyalogDatePickerButtonListener() {
                            @Override
                            public void onDateSelected(DialogInterface dialog, int whichButton, int year, int monthOfYear, int dayOfMonth) {
                                String format = String.format(Locale.getDefault(),
                                        "%1d-%2d-%3d", dayOfMonth, monthOfYear, year);
                                Toast.makeText(ReadyalogMain.this, format, Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .setReadyalogCancellable(true)
                        .setReadyalogTitle(R.string.pick_date)
                        .build()
                        .showReadyalog();
                break;
            case 2://Custom Content
                new Readyalog.ReadyalogBuilder(this)
                        .createCustomContentReadyalog()
                        .setReadyalogLayout(R.layout.readyalog_custom)
                        .setReadyalogPositiveButtonText(R.string.ok)
                        .setReadyalogTitle(R.string.custom_content)
                        .setReadyalogCancellable(true)
                        .build()
                        .showReadyalog();
                break;
            case 3://List selection
                // pick which readyalog you need.
                ListViewReadyalog listReadyalog = new Readyalog.ReadyalogBuilder(this)
                        .createListViewReadyalog();
                // create readyalog with parameters.
                listReadyalog.setReadyalogLayout(R.layout.readyalog_list)
                        .setReadyalogTitle(R.string.choose_one)
                        .setReadyalogCancellable(true);
                // get an instance to show/dismiss the readyalog.
                final Readyalog readyalog = listReadyalog.build();
                readyalog.showReadyalog();
                // get list view within.
                ListView list = listReadyalog.getListViewId(R.id.listView);
                list.setAdapter(getAdapter(R.array.options));
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(ReadyalogMain.this, "POSITION: " + position, Toast.LENGTH_SHORT)
                                .show();
                        readyalog.dismissReadylog();
                    }
                });
                break;
        }
    }

    private ArrayAdapter getAdapter(int array) {
        return new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, getResources().getStringArray(array));
    }

}
