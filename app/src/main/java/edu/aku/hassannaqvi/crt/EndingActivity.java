package edu.aku.hassannaqvi.crt;

import android.app.Activity;
import android.os.Bundle;

import butterknife.OnClick;

public class EndingActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);


    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {

    }

}
