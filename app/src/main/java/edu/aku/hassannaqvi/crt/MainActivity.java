package edu.aku.hassannaqvi.crt;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


    }
}
