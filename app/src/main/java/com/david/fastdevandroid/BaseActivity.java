package com.david.fastdevandroid;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import com.trello.rxlifecycle.components.RxActivity;

/**
 * Created by Administrator on 2016/12/6.
 */

public class BaseActivity extends RxActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
