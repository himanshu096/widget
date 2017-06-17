package ga.himanshu.home.test2;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Spinner;

public class ExampleAppWidgetConfigure extends AppCompatActivity {
    int mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;
    Spinner mRefreshIntervalSpn;

    public static String TTS_PREF = "tts_pref";
    public static String ALPHABET_PREF = "alphabet_pref";
    public static String INTERVAL_PREF = "interval_pref";
    public static String DEFAULT_INTERVAL = "60";
    public static String ALL_ALPHABET = "*";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_app_widget_configure);

        setResult(RESULT_CANCELED);

        setContentView(R.layout.activity_example_app_widget_configure);
        mRefreshIntervalSpn = (Spinner) findViewById(R.id.refresh_interval_spinner);
        findViewById(R.id.add_button).setOnClickListener(mOnClickListener);

        // Find the widget id from the intent.
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mAppWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        }

        // If this activity was started with an intent without an app widget ID,
        // finish with an error.
        if (mAppWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish();
            return;
        }

        mRefreshIntervalSpn.setSelection(getSelectedPosition(loadIntervalPref(this, mAppWidgetId)));
    }

    private int getSelectedPosition(String interval) {
        String[] values = getResources().getStringArray(R.array.refresh_interval_values);
        for (int i=0; i<values.length; i++) {
            if (values[i].equals(interval)) return i;
        }
        return 0;
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            final Context context = ExampleAppWidgetConfigure.this;

            // When the button is clicked, store the string locally
            String[] values = getResources().getStringArray(R.array.refresh_interval_values);
            String widgetText = values[mRefreshIntervalSpn.getSelectedItemPosition()];
            saveIntervalPref(context, mAppWidgetId, widgetText);

            // Make sure we pass back the original appWidgetId
            Intent resultValue = new Intent();
            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
            setResult(RESULT_OK, resultValue);
            finish();
        }
    };

    // Write the prefix to the SharedPreferences object for this widget
    static void saveIntervalPref(Context context, int appWidgetId, String text) {
        SharedPreferences.Editor prefs = PreferenceManager.getDefaultSharedPreferences(context).edit();
        prefs.putString(INTERVAL_PREF, text);
        prefs.commit();
    }

    // Read the prefix from the SharedPreferences object for this widget.
    // If there is no preference saved, get the default from a resource
    static String loadIntervalPref(Context context, int appWidgetId) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String interval = prefs.getString(INTERVAL_PREF, DEFAULT_INTERVAL);
        return interval;
    }

}