package edu.aku.hassannaqvi.cbtfollowup.activities;

import android.app.Activity;
import android.os.Bundle;

import butterknife.OnClick;
import edu.aku.hassannaqvi.cbtfollowup.R;

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
