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

public class SectionAActivity extends Activity {

    @BindView(R.id.activity_section_a)
    RelativeLayout activitySectionA;
    @BindView(R.id.scrollView01)
    ScrollView scrollView01;
    @BindView(R.id.app_header)
    TextView appHeader;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.fpa001)
    RadioGroup fpa001;
    @BindView(R.id.fpa00101)
    RadioButton fpa00101;
    @BindView(R.id.fpa00102)
    RadioButton fpa00102;
    @BindView(R.id.fpa00103)
    RadioButton fpa00103;
    @BindView(R.id.fpa00104)
    RadioButton fpa00104;
    @BindView(R.id.fpa00105)
    RadioButton fpa00105;
    @BindView(R.id.fpa002)
    EditText fpa002;
    @BindView(R.id.fpa00301)
    EditText fpa00301;
    @BindView(R.id.fpa00302)
    EditText fpa00302;
    @BindView(R.id.fpa00401)
    EditText fpa00401;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_a);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        Toast.makeText(this, "complete section", Toast.LENGTH_SHORT).show();

        Intent endSec = new Intent(this, SectionIActivity.class);
        endSec.putExtra("complete", false);
        startActivity(endSec);
    }




    @OnClick(R.id.btn_Continue)
    void onBtnContinueClick() {

        Toast.makeText(this, "Processing thi section", Toast.LENGTH_SHORT).show();
        if (validateForm()) {
            try {
                saveDrafts();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (updateDb()) {
                Toast.makeText(this, "starting next section", Toast.LENGTH_SHORT).show();

                finish();
                Intent secB = new Intent(this, SectionBActivity.class);
                startActivity(secB);
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
