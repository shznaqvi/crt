package edu.aku.hassannaqvi.cbtfollowup.activities;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;
import edu.aku.hassannaqvi.cbtfollowup.R;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


    }
}
