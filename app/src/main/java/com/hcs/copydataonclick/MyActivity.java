package com.hcs.copydataonclick;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MyActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        findViewById(R.id.copy_button).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            final android.content.ClipboardManager clipboardManager = (android.content.ClipboardManager) getApplicationContext()
                    .getSystemService(Context.CLIPBOARD_SERVICE);
            final android.content.ClipData clipData = android.content.ClipData
                    .newPlainText("text label", "text to clip");
            clipboardManager.setPrimaryClip(clipData);
        } else {
            final android.text.ClipboardManager clipboardManager = (android.text.ClipboardManager) getApplicationContext()
                    .getSystemService(Context.CLIPBOARD_SERVICE);
            clipboardManager.setText("text to clip");
        }
    }
}
