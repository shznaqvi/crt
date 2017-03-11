package edu.aku.hassannaqvi.crt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
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

public class SectionEActivity extends Activity {

    @BindView(R.id.activity_section_e)
    RelativeLayout activitySectionE;
    @BindView(R.id.scrollView01)
    ScrollView scrollView01;
    @BindView(R.id.app_header)
    TextView appHeader;
    @BindView(R.id.fpe001)
    RadioGroup fpe001;
    @BindView(R.id.fpe00101)
    RadioButton fpe00101;
    @BindView(R.id.fpe00102)
    RadioButton fpe00102;
    @BindView(R.id.fpe001a)
    EditText fpe001a;
    @BindView(R.id.fpe001b)
    EditText fpe001b;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.fpe00201)
    CheckBox fpe00201;
    @BindView(R.id.fpe00201x)
    EditText fpe00201x;
    @BindView(R.id.fpe00202)
    CheckBox fpe00202;
    @BindView(R.id.fpe00202x)
    EditText fpe00202x;
    @BindView(R.id.fpe00203)
    CheckBox fpe00203;
    @BindView(R.id.fpe00203x)
    EditText fpe00203x;
    @BindView(R.id.fpe00204)
    CheckBox fpe00204;
    @BindView(R.id.fpe00204x)
    EditText fpe00204x;
    @BindView(R.id.fpe00205)
    CheckBox fpe00205;
    @BindView(R.id.fpe00205x)
    EditText fpe00205x;
    @BindView(R.id.fpe00288)
    CheckBox fpe00288;
    @BindView(R.id.fpe00288x)
    EditText fpe00288x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_e);
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
                Intent secF = new Intent(this, SectionFActivity.class);
                startActivity(secF);

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
