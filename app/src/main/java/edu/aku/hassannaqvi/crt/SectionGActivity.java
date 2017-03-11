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

public class SectionGActivity extends Activity {

    @BindView(R.id.activity_section_g)
    RelativeLayout activitySectionG;
    @BindView(R.id.scrollView01)
    ScrollView scrollView01;
    @BindView(R.id.app_header)
    TextView appHeader;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.fpg00101)
    CheckBox fpg00101;
    @BindView(R.id.fpg00102)
    CheckBox fpg00102;
    @BindView(R.id.fpg00103)
    CheckBox fpg00103;
    @BindView(R.id.fpg00104)
    CheckBox fpg00104;
    @BindView(R.id.fpg00105)
    CheckBox fpg00105;
    @BindView(R.id.fpg00106)
    CheckBox fpg00106;
    @BindView(R.id.fpg00107)
    CheckBox fpg00107;
    @BindView(R.id.fpg00108)
    CheckBox fpg00108;
    @BindView(R.id.fpg00109)
    CheckBox fpg00109;
    @BindView(R.id.fpg00188)
    CheckBox fpg00188;
    @BindView(R.id.fpg00188x)
    EditText fpg00188x;
    @BindView(R.id.fpg002)
    RadioGroup fpg002;
    @BindView(R.id.fpg00201)
    RadioButton fpg00201;
    @BindView(R.id.fpg00202)
    RadioButton fpg00202;
    @BindView(R.id.fpg003)
    RadioGroup fpg003;
    @BindView(R.id.fpg00301)
    RadioButton fpg00301;
    @BindView(R.id.fpg00302)
    RadioButton fpg00302;
    @BindView(R.id.fpg00303)
    RadioButton fpg00303;
    @BindView(R.id.fpg00304)
    RadioButton fpg00304;
    @BindView(R.id.fpg00305)
    RadioButton fpg00305;
    @BindView(R.id.fpg00306)
    RadioButton fpg00306;
    @BindView(R.id.fpg00307)
    RadioButton fpg00307;
    @BindView(R.id.fpg00308)
    RadioButton fpg00308;
    @BindView(R.id.fpg00388)
    RadioButton fpg00388;
    @BindView(R.id.fpg00388x)
    EditText fpg00388x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_g);
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
                Intent secH = new Intent(this, SectionHActivity.class);
                startActivity(secH);

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
