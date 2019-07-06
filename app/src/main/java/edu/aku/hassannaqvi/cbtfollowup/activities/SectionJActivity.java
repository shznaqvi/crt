package edu.aku.hassannaqvi.cbtfollowup.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.cbtfollowup.R;
import edu.aku.hassannaqvi.cbtfollowup.core.AppMain;
import edu.aku.hassannaqvi.cbtfollowup.core.DatabaseHelper;
import edu.aku.hassannaqvi.cbtfollowup.validation.ClearClass;
import edu.aku.hassannaqvi.cbtfollowup.validation.ValidatorClass;

public class SectionJActivity extends AppCompatActivity {

    @BindView(R.id.llJ)
    LinearLayout llJ;
    @BindView(R.id.fpj01)
    RadioGroup fpj01;
    @BindView(R.id.fpj01a)
    RadioButton fpj01a;
    @BindView(R.id.fpj01b)
    RadioButton fpj01b;
    @BindView(R.id.cvfpj02)
    CardView cvfpj02;
    @BindView(R.id.fpj02)
    RadioGroup fpj02;
    @BindView(R.id.fpj02a)
    RadioButton fpj02a;
    @BindView(R.id.fpj02b)
    RadioButton fpj02b;
    @BindView(R.id.fpj02c)
    RadioButton fpj02c;
    @BindView(R.id.fpj02d)
    RadioButton fpj02d;
    @BindView(R.id.cvfpj03)
    CardView cvfpj03;
    @BindView(R.id.fpj03r)
    RadioGroup fpj03r;
    @BindView(R.id.fpj03ra)
    RadioButton fpj03ra;
    @BindView(R.id.fpj03rb)
    RadioButton fpj03rb;
    @BindView(R.id.fpj03s)
    RadioGroup fpj03s;
    @BindView(R.id.fpj03sa)
    RadioButton fpj03sa;
    @BindView(R.id.fpj03sb)
    RadioButton fpj03sb;
    @BindView(R.id.cvfpj04)
    CardView cvfpj04;
    @BindView(R.id.fpj04r)
    RadioGroup fpj04r;
    @BindView(R.id.fpj04ra)
    RadioButton fpj04ra;
    @BindView(R.id.fpj04rb)
    RadioButton fpj04rb;
    @BindView(R.id.fpj04s)
    RadioGroup fpj04s;
    @BindView(R.id.fpj04sa)
    RadioButton fpj04sa;
    @BindView(R.id.fpj04sb)
    RadioButton fpj04sb;
    @BindView(R.id.cvfpj05)
    CardView cvfpj05;
    @BindView(R.id.fpj05r)
    RadioGroup fpj05r;
    @BindView(R.id.fpj05ra)
    RadioButton fpj05ra;
    @BindView(R.id.fpj05rb)
    RadioButton fpj05rb;
    @BindView(R.id.fpj05s)
    RadioGroup fpj05s;
    @BindView(R.id.fpj05sa)
    RadioButton fpj05sa;
    @BindView(R.id.fpj05sb)
    RadioButton fpj05sb;
    @BindView(R.id.cvfpj06)
    CardView cvfpj06;
    @BindView(R.id.fpj06)
    RadioGroup fpj06;
    @BindView(R.id.fpj06a)
    RadioButton fpj06a;
    @BindView(R.id.fpj06b)
    RadioButton fpj06b;
    @BindView(R.id.fpj0698)
    RadioButton fpj0698;
    @BindView(R.id.cvfpj07)
    CardView cvfpj07;
    @BindView(R.id.cvfpj08)
    CardView cvfpj08;
    @BindView(R.id.fpj07)
    RadioGroup fpj07;
    @BindView(R.id.fpj07a)
    RadioButton fpj07a;
    @BindView(R.id.fpj07b)
    RadioButton fpj07b;
    @BindView(R.id.fpj08)
    EditText fpj08;
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

        fpj01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == fpj01a.getId()) {
                    cvfpj02.setVisibility(View.VISIBLE);
                } else {
                    ClearClass.ClearAllFields(cvfpj02, null);
                    cvfpj02.setVisibility(View.GONE);
                }
            }
        });

        fpj06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != fpj06b.getId()) {
                    cvfpj07.setVisibility(View.VISIBLE);
                    cvfpj08.setVisibility(View.VISIBLE);
                } else {
                    ClearClass.ClearAllFields(cvfpj07, null);
                    ClearClass.ClearAllFields(cvfpj08, null);
                    cvfpj07.setVisibility(View.GONE);
                    cvfpj08.setVisibility(View.GONE);
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
                Intent secE = new Intent(this, EndingActivity.class).putExtra("complete", true);
                startActivity(secE);

            } else {
                Toast.makeText(this, "Failed to update Database", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean updateDb() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateJ();

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

        JSONObject sJ = new JSONObject();

        sJ.put("fpj01", fpj01a.isChecked() ? "1"
                : fpj01b.isChecked() ? "2"
                : "0");

        sJ.put("fpj02", fpj02a.isChecked() ? "1"
                : fpj02b.isChecked() ? "2"
                : fpj02c.isChecked() ? "3"
                : fpj02d.isChecked() ? "4"
                : "0");

        sJ.put("fpj03r", fpj03ra.isChecked() ? "1"
                : fpj03rb.isChecked() ? "2"
                : "0");

        sJ.put("fpj03s", fpj03sa.isChecked() ? "1"
                : fpj03sb.isChecked() ? "2"
                : "0");

        sJ.put("fpj04r", fpj04ra.isChecked() ? "1"
                : fpj04rb.isChecked() ? "2"
                : "0");

        sJ.put("fpj04s", fpj04sa.isChecked() ? "1"
                : fpj04sb.isChecked() ? "2"
                : "0");

        sJ.put("fpj05r", fpj05ra.isChecked() ? "1"
                : fpj05rb.isChecked() ? "2"
                : "0");

        sJ.put("fpj05s", fpj05sa.isChecked() ? "1"
                : fpj05sb.isChecked() ? "2"
                : "0");

        sJ.put("fpj06", fpj06a.isChecked() ? "1"
                : fpj06b.isChecked() ? "2"
                : fpj0698.isChecked() ? "98"
                : "0");

        sJ.put("fpj07", fpj07a.isChecked() ? "1"
                : fpj07b.isChecked() ? "2"
                : "0");

        //fpj08
        sJ.put("fpj08", fpj08.getText().toString().length() > 0 ? fpj08.getText().toString().trim() : "0");

        AppMain.fc.setsJ(String.valueOf(sJ));

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
