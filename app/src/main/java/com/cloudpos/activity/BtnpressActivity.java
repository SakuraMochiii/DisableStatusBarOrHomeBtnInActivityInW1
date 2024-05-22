package com.cloudpos.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.cloudpos.homebtn.demo.R;

public class BtnpressActivity extends Activity implements OnClickListener {

    private String TAG = "BtnpressActivity";

    @Override
    protected void onCreate(Bundle bundle) {
        setContentView(R.layout.btnpress_activity);
        super.onCreate(bundle);

        Button text = (Button) this.findViewById(R.id.cancelBtn);
        text.setOnClickListener(this);
        Button exit = (Button) this.findViewById(R.id.okBtn);
        exit.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        TextView text = (TextView) this.findViewById(R.id.content);
        text.append("\nkeyCode = " + keyCode);
        if (keyCode == KeyEvent.KEYCODE_HOME) {

            Log.e("DEBUG", "KEYCODE_HOME");

//			textview_home.setBackgroundColor(Color.GREEN);
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_BACK) {
//			textView_back.setBackgroundColor(Color.GREEN);

            Log.e(TAG, "KEYCODE_BACK");
            // isSuccessReturn = true;
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_MENU) {
//			textview_menu.setBackgroundColor(Color.GREEN);
            Log.e(TAG, "KEYCODE_MENU");
            // isSuccessMenu = true;
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cancelBtn) {
            TextView text = (TextView) this.findViewById(R.id.content);
            text.setText("");
        } else {
            this.finish();
        }
    }
}
