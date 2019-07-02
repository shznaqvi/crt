package edu.aku.hassannaqvi.cbtfollowup.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.cbtfollowup.R;
import edu.aku.hassannaqvi.cbtfollowup.core.AppMain;
import edu.aku.hassannaqvi.cbtfollowup.core.DatabaseHelper;
import edu.aku.hassannaqvi.cbtfollowup.validation.ValidatorClass;

import static edu.aku.hassannaqvi.cbtfollowup.validation.ClearAllcontrol.ClearAllC;

public class SectionJActivity extends AppCompatActivity {

    @BindView(R.id.activity_section_j)
    ScrollView activitySectionJ;
    @BindView(R.id.llJ)
    LinearLayout llJ;
    @BindView(R.id.cvhpj01)
    CardView cvhpj01;
    @BindView(R.id.hpj01)
    RadioGroup hpj01;
    @BindView(R.id.hpj01a)
    RadioButton hpj01a;
    @BindView(R.id.hpj01b)
    RadioButton hpj01b;
    @BindView(R.id.cvhpj02)
    CardView cvhpj02;
    @BindView(R.id.hpj02)
    RadioGroup hpj02;
    @BindView(R.id.hpj02a)
    RadioButton hpj02a;
    @BindView(R.id.hpj02b)
    RadioButton hpj02b;
    @BindView(R.id.hpj02c)
    RadioButton hpj02c;
    @BindView(R.id.hpj02d)
    RadioButton hpj02d;
    @BindView(R.id.cvhpj03)
    CardView cvhpj03;
    @BindView(R.id.hpj03r)
    RadioGroup hpj03r;
    @BindView(R.id.hpj03ra)
    RadioButton hpj03ra;
    @BindView(R.id.hpj03rb)
    RadioButton hpj03rb;
    @BindView(R.id.hpj03s)
    RadioGroup hpj03s;
    @BindView(R.id.hpj03sa)
    RadioButton hpj03sa;
    @BindView(R.id.hpj03sb)
    RadioButton hpj03sb;
    @BindView(R.id.cvhpj04)
    CardView cvhpj04;
    @BindView(R.id.hpj04r)
    RadioGroup hpj04r;
    @BindView(R.id.hpj04ra)
    RadioButton hpj04ra;
    @BindView(R.id.hpj04rb)
    RadioButton hpj04rb;
    @BindView(R.id.hpj04s)
    RadioGroup hpj04s;
    @BindView(R.id.hpj04sa)
    RadioButton hpj04sa;
    @BindView(R.id.hpj04sb)
    RadioButton hpj04sb;
    @BindView(R.id.cvhpj05)
    CardView cvhpj05;
    @BindView(R.id.hpj05r)
    RadioGroup hpj05r;
    @BindView(R.id.hpj05ra)
    RadioButton hpj05ra;
    @BindView(R.id.hpj05rb)
    RadioButton hpj05rb;
    @BindView(R.id.hpj05s)
    RadioGroup hpj05s;
    @BindView(R.id.hpj05sa)
    RadioButton hpj05sa;
    @BindView(R.id.hpj05sb)
    RadioButton hpj05sb;
    @BindView(R.id.cvhpj06)
    CardView cvhpj06;
    @BindView(R.id.hpj06)
    RadioGroup hpj06;
    @BindView(R.id.hpj06a)
    RadioButton hpj06a;
    @BindView(R.id.hpj06b)
    RadioButton hpj06b;
    @BindView(R.id.hpj0698)
    RadioButton hpj0698;
    @BindView(R.id.cvhpj07)
    CardView cvhpj07;
    @BindView(R.id.hpj07)
    RadioGroup hpj07;
    @BindView(R.id.hpj07a)
    RadioButton hpj07a;
    @BindView(R.id.hpj07b)
    RadioButton hpj07b;
    @BindView(R.id.btnNext)
    Button btnNext;
    @BindView(R.id.btn_End)
    Button btnEnd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_j);
        ButterKnife.bind(this);
        setupSkips();


    }

    private void setupSkips() {

        hpj01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == hpj01a.getId()) {
                    cvhpj02.setVisibility(View.VISIBLE);
                } else {
                    ClearAllC(cvhpj02);
                    cvhpj02.setVisibility(View.GONE);
                }
            }
        });

        hpj06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != hpj06b.getId()) {
                    cvhpj07.setVisibility(View.VISIBLE);
                } else {
                    ClearAllC(cvhpj07);
                    cvhpj07.setVisibility(View.GONE);
                }
            }
        });

    }


    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        Toast.makeText(this, "complete Section", Toast.LENGTH_SHORT).show();
/*        Intent endSec = new Intent(this, EndingActivity.class);
        endSec.putExtra("complete", false);
        startActivity(endSec);*/

        AppMain.endActivity(this, this);
    }


    @OnClick(R.id.btnNext)
    void onBtnNextClick() {
        //Toast.makeText(this, "Processing this section", Toast.LENGTH_SHORT).show();
        if (validateForm()) {
            try {
                saveDrafts();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (updateDb()) {
                //    Toast.makeText(this, "starting next section", Toast.LENGTH_SHORT).show();

                finish();
                Intent secE = new Intent(this, SectionEActivity.class);
                startActivity(secE);

            } else {
                Toast.makeText(this, "Failed to update Database", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean updateDb() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateD();

        if (updcount == 1) {
            // Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }


    }


    private void saveDrafts() throws JSONException {
        //Toast.makeText(this, "saving Drafts", Toast.LENGTH_SHORT).show();

        JSONObject sD = new JSONObject();

        sD.put("hpj01", hpj01a.isChecked() ? "1"
                : hpj01b.isChecked() ? "2"
                : "0");

        sD.put("hpj02", hpj02a.isChecked() ? "1"
                : hpj02b.isChecked() ? "2"
                : hpj02c.isChecked() ? "3"
                : hpj02d.isChecked() ? "4"
                : "0");

        sD.put("hpj03r", hpj03ra.isChecked() ? "1"
                : hpj03rb.isChecked() ? "2"
                : "0");

        sD.put("hpj03s", hpj03sa.isChecked() ? "1"
                : hpj03sb.isChecked() ? "2"
                : "0");

        sD.put("hpj04r", hpj04ra.isChecked() ? "1"
                : hpj04rb.isChecked() ? "2"
                : "0");

        sD.put("hpj04s", hpj04sa.isChecked() ? "1"
                : hpj04sb.isChecked() ? "2"
                : "0");

        sD.put("hpj05r", hpj05ra.isChecked() ? "1"
                : hpj05rb.isChecked() ? "2"
                : "0");

        sD.put("hpj05s", hpj05sa.isChecked() ? "1"
                : hpj05sb.isChecked() ? "2"
                : "0");

        sD.put("hpj06", hpj06a.isChecked() ? "1"
                : hpj06b.isChecked() ? "2"
                : hpj0698.isChecked() ? "98"
                : "0");

        sD.put("hpj07", hpj07a.isChecked() ? "1"
                : hpj07b.isChecked() ? "2"
                : "0");

        AppMain.fc.setsD(String.valueOf(sD));

        //Toast.makeText(this, "validation successful", Toast.LENGTH_SHORT).show();

    }


    public boolean validateForm() {

        return ValidatorClass.EmptyCheckingContainer(this, llJ);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}
