package edu.aku.hassannaqvi.cbtfollowup.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
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
import edu.aku.hassannaqvi.cbtfollowup.core.DatabaseHelper;

import static android.content.ContentValues.TAG;

public class SectionGActivity extends Activity {

    @BindView(R.id.activity_section_g)
    ScrollView activitySectionG;
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
    @BindView(R.id.fpgGrp001a)
    LinearLayout fpgGrp001a;
    @BindView(R.id.fpgGrp001b)
    LinearLayout fpgGrp001b;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_g);
        ButterKnife.bind(this);

        // =================== Q1 Others ====================

        fpg00188.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpg00188x.setVisibility(View.VISIBLE);
                } else {
                    fpg00188x.setVisibility(View.GONE);
                    fpg00188x.setText(null);
                }
            }
        });

        // =================== Q3 Others ====================

        fpg00388.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpg00388x.setVisibility(View.VISIBLE);
                } else {
                    fpg00388x.setVisibility(View.GONE);
                    fpg00388x.setText(null);
                }
            }
        });

        // ====================== Q 1 Skip Pattern =========================

        fpg00109.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpgGrp001a.setVisibility(View.GONE);
                    fpg002.clearCheck();
                    fpg003.clearCheck();
                    fpgGrp001b.setVisibility(View.GONE);
                    fpg00188x.setText(null);
                    fpg00388x.setText(null);
                    fpg00101.setEnabled(false);
                    fpg00101.setChecked(false);
                    fpg00102.setEnabled(false);
                    fpg00102.setChecked(false);
                    fpg00103.setEnabled(false);
                    fpg00103.setChecked(false);
                    fpg00104.setEnabled(false);
                    fpg00104.setChecked(false);
                    fpg00105.setEnabled(false);
                    fpg00105.setChecked(false);
                    fpg00106.setEnabled(false);
                    fpg00106.setChecked(false);
                    fpg00107.setEnabled(false);
                    fpg00107.setChecked(false);
                    fpg00108.setEnabled(false);
                    fpg00108.setChecked(false);
                    fpg00188.setEnabled(false);
                    fpg00188.setChecked(false);
                    fpg00188x.setText(null);

                } else {
                    fpgGrp001a.setVisibility(View.VISIBLE);
                    fpgGrp001b.setVisibility(View.VISIBLE);
                    fpg00101.setEnabled(true);
                    fpg00102.setEnabled(true);
                    fpg00103.setEnabled(true);
                    fpg00104.setEnabled(true);
                    fpg00105.setEnabled(true);
                    fpg00106.setEnabled(true);
                    fpg00107.setEnabled(true);
                    fpg00108.setEnabled(true);
                    fpg00188.setEnabled(true);

                }
            }
        });

        // ====================== Q 2 Skip Pattern =========================

        fpg00202.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    fpgGrp001b.setVisibility(View.GONE);
                    fpg003.clearCheck();
                    fpg00388x.setText(null);

                } else {
                    fpgGrp001b.setVisibility(View.VISIBLE);

                }
            }
        });

    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        Toast.makeText(this, "complete Section", Toast.LENGTH_SHORT).show();
        Intent endSec = new Intent(this, EndingActivity.class);
        endSec.putExtra("complete", false);
        startActivity(endSec);
    }

    @OnClick(R.id.btnNext)
    void onBtnNextClick() {
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

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateG();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }


    }

    private void saveDrafts() throws JSONException {
        Toast.makeText(this, "saving Drafts", Toast.LENGTH_SHORT).show();

        JSONObject js = new JSONObject();
        js.put("fpg00101", fpg00101.isChecked() ? "1" : "0");
        js.put("fpg00102", fpg00102.isChecked() ? "2" : "0");
        js.put("fpg00103", fpg00103.isChecked() ? "3" : "0");
        js.put("fpg00104", fpg00104.isChecked() ? "4" : "0");
        js.put("fpg00105", fpg00105.isChecked() ? "5" : "0");
        js.put("fpg00106", fpg00106.isChecked() ? "6" : "0");
        js.put("fpg00107", fpg00107.isChecked() ? "7" : "0");
        js.put("fpg00108", fpg00108.isChecked() ? "8" : "0");
        js.put("fpg00109", fpg00109.isChecked() ? "9" : "0");
        js.put("fpg00188", fpg00188.isChecked() ? "88" : "0");
        js.put("fpg00188x", fpg00188x.getText().toString());
        js.put("fpg002", fpg00201.isChecked() ? "1" : fpg00202.isChecked() ? "2" : "0");
        js.put("fpg003", fpg00301.isChecked() ? "1" : fpg00302.isChecked() ? "2" : fpg00303.isChecked() ? "3" : fpg00304.isChecked() ? "4" : fpg00305.isChecked() ? "5" : fpg00306.isChecked() ? "6" : fpg00307.isChecked() ? "7" : fpg00308.isChecked() ? "8" : fpg00388.isChecked() ? "88" : "0");
        js.put("fpg00388x", fpg00388x.getText().toString());


        Toast.makeText(this, "validation succecful", Toast.LENGTH_SHORT).show();

    }

    public boolean validateForm() {

        // ====================== Q 1 ===================
        if (!(fpg00101.isChecked() || fpg00102.isChecked() || fpg00103.isChecked() || fpg00104.isChecked()
                || fpg00105.isChecked() || fpg00106.isChecked() || fpg00107.isChecked() || fpg00108.isChecked() || fpg00109.isChecked() || fpg00188.isChecked())) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpg001), Toast.LENGTH_LONG).show();
            fpg00188.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "fpg001: This data is Required!");
            return false;
        } else {
            fpg00188.setError(null);
        }

        if (fpg00188.isChecked() && fpg00188x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpg001) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
            fpg00188x.setError("This data is Required!");    // Set Error on last radio button
            Log.d(TAG, "fpg00188: This data is Required!");
            return false;
        } else {
            fpg00188x.setError(null);
        }

        if (!(fpg00109.isChecked())) {

            // ====================== Q 2 ===================
            if (fpg002.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "" + getString(R.string.fpg002), Toast.LENGTH_SHORT).show();
                fpg00202.setError("This Data is required");
                Log.d(TAG, "not selected: fpg002 ");
                return false;
            } else {
                fpg00202.setError(null);
            }
            if (fpg00201.isChecked()) {

                // ====================== Q 3 ===================
                if (fpg003.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "" + getString(R.string.fpg003), Toast.LENGTH_SHORT).show();
                    fpg00388.setError("This Data is required");
                    Log.d(TAG, "not selected: fpg003 ");
                    return false;
                } else {
                    fpg00388.setError(null);
                }

                if (fpg00388.isChecked() && fpg00388x.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpg003) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                    fpg00388x.setError("This data is Required!");    // Set Error on last radio button
                    Log.d(TAG, "fpg00388: This data is Required!");
                    return false;
                } else {
                    fpg00388x.setError(null);
                }
            }
        }

        return true;
    }


}
