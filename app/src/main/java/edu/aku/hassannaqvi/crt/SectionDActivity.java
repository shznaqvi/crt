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

public class SectionDActivity extends Activity {

    @BindView(R.id.activity_section_d)
    RelativeLayout activitySectionD;
    @BindView(R.id.scrollView01)
    ScrollView scrollView01;
    @BindView(R.id.app_header)
    TextView appHeader;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.fpd001)
    RadioGroup fpd001;
    @BindView(R.id.fpd00101)
    RadioButton fpd00101;
    @BindView(R.id.fpd00102)
    RadioButton fpd00102;
    @BindView(R.id.fpd00103)
    RadioButton fpd00103;
    @BindView(R.id.fpd00103R)
    EditText fpd00103R;
    @BindView(R.id.fpd001a)
    RadioGroup fpd001a;
    @BindView(R.id.fpd001a01)
    RadioButton fpd001a01;
    @BindView(R.id.fpd001a02)
    RadioButton fpd001a02;
    @BindView(R.id.fpd001a03)
    RadioButton fpd001a03;
    @BindView(R.id.fpd001a04)
    RadioButton fpd001a04;
    @BindView(R.id.fpd001a05)
    RadioButton fpd001a05;
    @BindView(R.id.fpd001a06)
    RadioButton fpd001a06;
    @BindView(R.id.fpd001a07)
    RadioButton fpd001a07;
    @BindView(R.id.fpd001a88)
    RadioButton fpd001a88;
    @BindView(R.id.fpd001a88x)
    EditText fpd001a88x;
    @BindView(R.id.fpd002)
    RadioGroup fpd002;
    @BindView(R.id.fpd00201)
    RadioButton fpd00201;
    @BindView(R.id.fpd00299)
    RadioButton fpd00299;
    @BindView(R.id.fpd00288)
    RadioButton fpd00288;
    @BindView(R.id.fpd00288x)
    EditText fpd00288x;
    @BindView(R.id.fpd003)
    EditText fpd003;
    @BindView(R.id.fpd004)
    EditText fpd004;
    @BindView(R.id.fpd004a)
    RadioGroup fpd004a;
    @BindView(R.id.fpd004a01)
    RadioButton fpd004a01;
    @BindView(R.id.fpd004a02)
    RadioButton fpd004a02;
    @BindView(R.id.fpd004a03)
    RadioButton fpd004a03;
    @BindView(R.id.fpd004a04)
    RadioButton fpd004a04;
    @BindView(R.id.fpd004a05)
    RadioButton fpd004a05;
    @BindView(R.id.fpd004a06)
    RadioButton fpd004a06;
    @BindView(R.id.fpd004a07)
    RadioButton fpd004a07;
    @BindView(R.id.fpd004a88)
    RadioButton fpd004a88;
    @BindView(R.id.fpd004a88x)
    EditText fpd004a88x;
    @BindView(R.id.fpd00501)
    EditText fpd00501;
    @BindView(R.id.fpd00502)
    EditText fpd00502;
    @BindView(R.id.fpd00601)
    EditText fpd00601;
    @BindView(R.id.fpd00602)
    EditText fpd00602;
    @BindView(R.id.fpd007)
    RadioGroup fpd007;
    @BindView(R.id.fpd00701)
    RadioButton fpd00701;
    @BindView(R.id.fpd00702)
    RadioButton fpd00702;
    @BindView(R.id.fpd008)
    RadioGroup fpd008;
    @BindView(R.id.fpd00801)
    RadioButton fpd00801;
    @BindView(R.id.fpd00802)
    RadioButton fpd00802;
    @BindView(R.id.fpd00803)
    RadioButton fpd00803;
    @BindView(R.id.fpd00804)
    RadioButton fpd00804;
    @BindView(R.id.fpd00888)
    RadioButton fpd00888;
    @BindView(R.id.fpd00888x)
    EditText fpd00888x;
    @BindView(R.id.fpd009)
    RadioGroup fpd009;
    @BindView(R.id.fpd00901)
    RadioButton fpd00901;
    @BindView(R.id.fpd00902)
    RadioButton fpd00902;
    @BindView(R.id.fpd009a)
    RadioGroup fpd009a;
    @BindView(R.id.fpd009a01)
    RadioButton fpd009a01;
    @BindView(R.id.fpd009a02)
    RadioButton fpd009a02;
    @BindView(R.id.fpd009a03)
    RadioButton fpd009a03;
    @BindView(R.id.fpd009a88)
    RadioButton fpd009a88;
    @BindView(R.id.fpd009a88x)
    EditText fpd009a88x;
    @BindView(R.id.fpd009b)
    EditText fpd009b;
    @BindView(R.id.fpd009c)
    RadioGroup fpd009c;
    @BindView(R.id.fpd009c01)
    RadioButton fpd009c01;
    @BindView(R.id.fpd009c02)
    RadioButton fpd009c02;
    @BindView(R.id.fpd009c03)
    RadioButton fpd009c03;
    @BindView(R.id.fpd009c99)
    RadioButton fpd009c99;
    @BindView(R.id.fpd009c88)
    RadioButton fpd009c88;
    @BindView(R.id.fpd009c88x)
    EditText fpd009c88x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_d);
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
                Intent secE = new Intent(this, SectionEActivity.class);
                startActivity(secE);

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
