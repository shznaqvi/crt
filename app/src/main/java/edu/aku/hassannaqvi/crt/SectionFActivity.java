package edu.aku.hassannaqvi.crt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SectionFActivity extends Activity {

    @BindView(R.id.activity_section_f)
    RelativeLayout activitySectionF;
    @BindView(R.id.scrollView01)
    ScrollView scrollView01;
    @BindView(R.id.app_header)
    TextView appHeader;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.fpf001)
    RadioGroup fpf001;
    @BindView(R.id.fpf00101)
    RadioButton fpf00101;
    @BindView(R.id.fpf00102)
    RadioButton fpf00102;
    @BindView(R.id.fpf001a)
    RadioGroup fpf001a;
    @BindView(R.id.fpf001a01)
    RadioButton fpf001a01;
    @BindView(R.id.fpf001a02)
    RadioButton fpf001a02;
    @BindView(R.id.fpd00fa03)
    RadioButton fpd00fa03;
    @BindView(R.id.fpf001a04)
    RadioButton fpf001a04;
    @BindView(R.id.fpf001a05)
    RadioButton fpf001a05;
    @BindView(R.id.fpf001a06)
    RadioButton fpf001a06;
    @BindView(R.id.fpf001a07)
    RadioButton fpf001a07;
    @BindView(R.id.fpf001a08)
    RadioButton fpf001a08;
    @BindView(R.id.fpf001a88)
    RadioButton fpf001a88;
    @BindView(R.id.fpf001a88x)
    EditText fpf001a88x;
    @BindView(R.id.fpf001b)
    RadioGroup fpf001b;
    @BindView(R.id.fpf001b01)
    RadioButton fpf001b01;
    @BindView(R.id.fpf001b02)
    RadioButton fpf001b02;
    @BindView(R.id.fpd00fb03)
    RadioButton fpd00fb03;
    @BindView(R.id.fpf001b04)
    RadioButton fpf001b04;
    @BindView(R.id.fpf001b88)
    RadioButton fpf001b88;
    @BindView(R.id.fpf001b88x)
    EditText fpf001b88x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_f);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        Toast.makeText(this, "complete Section", Toast.LENGTH_SHORT).show();
        Intent endSec = new Intent(this, SectionIActivity.class);
        endSec.putExtra("complete", false);
        startActivity(endSec);
    }


    @OnClick(R.id.btn_Continue)
    void onBtnContinueClick() {
        Toast.makeText(this, "Processing this section", Toast.LENGTH_SHORT).show();
        if (validateForm()) {
            try {
                saveDrafts();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (updateDb()) {
                Toast.makeText(this, "starting next section", Toast.LENGTH_SHORT).show();

                finish();
                Intent secG = new Intent(this, SectionGActivity.class);
                startActivity(secG);

            } else {
                Toast.makeText(this, "Failed to update Database", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean updateDb() {

        return true;
    }

    private void saveDrafts() throws JSONException {
        Toast.makeText(this, "saving Drafts", Toast.LENGTH_SHORT).show();

        JSONObject js = new JSONObject();


        Toast.makeText(this, "validation succecful", Toast.LENGTH_SHORT).show();

    }

    public boolean validateForm() {

        return true;
    }


}
