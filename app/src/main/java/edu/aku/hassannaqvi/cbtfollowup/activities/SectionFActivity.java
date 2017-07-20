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
import edu.aku.hassannaqvi.cbtfollowup.core.AppMain;
import edu.aku.hassannaqvi.cbtfollowup.core.DatabaseHelper;

import static android.content.ContentValues.TAG;

public class SectionFActivity extends Activity {

    @BindView(R.id.activity_section_f)
    ScrollView activitySectionF;
    @BindView(R.id.fpf001)
    RadioGroup fpf001;
    @BindView(R.id.fpf00101)
    RadioButton fpf00101;
    @BindView(R.id.fpf00102)
    RadioButton fpf00102;
    /*@BindView(R.id.fpf001a)
    RadioGroup fpf001a;*/
    @BindView(R.id.fpf001a01)
    CheckBox fpf001a01;
    @BindView(R.id.fpf001a02)
    CheckBox fpf001a02;
    @BindView(R.id.fpf001a03)
    CheckBox fpf001a03;
    @BindView(R.id.fpf001a04)
    CheckBox fpf001a04;
    @BindView(R.id.fpf001a05)
    CheckBox fpf001a05;
    @BindView(R.id.fpf001a06)
    CheckBox fpf001a06;
    @BindView(R.id.fpf001a07)
    CheckBox fpf001a07;
    @BindView(R.id.fpf001a08)
    CheckBox fpf001a08;
    @BindView(R.id.fpf001a88)
    CheckBox fpf001a88;
    @BindView(R.id.fpf001a88x)
    EditText fpf001a88x;
    /*@BindView(R.id.fpf001b)
    RadioGroup fpf001b;*/
    @BindView(R.id.fpf001b01)
    CheckBox fpf001b01;
    @BindView(R.id.fpf001b02)
    CheckBox fpf001b02;
    @BindView(R.id.fpf001b03)
    CheckBox fpf001b03;
    @BindView(R.id.fpf001b04)
    CheckBox fpf001b04;
    @BindView(R.id.fpf001b88)
    CheckBox fpf001b88;
    @BindView(R.id.fpf001b88x)
    EditText fpf001b88x;
    @BindView(R.id.fpfGrp001)
    LinearLayout fpfGrp001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_f);
        ButterKnife.bind(this);

        // =================== Q1.1 Others ====================

        fpf001a88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpf001a88x.setVisibility(View.VISIBLE);
                } else {
                    fpf001a88x.setVisibility(View.GONE);
                    fpf001a88x.setText(null);
                }
            }
        });

        // =================== Q1.2 Others ====================

        fpf001b88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpf001b88x.setVisibility(View.VISIBLE);
                } else {
                    fpf001b88x.setVisibility(View.GONE);
                    fpf001b88x.setText(null);
                }
            }
        });

        // ====================== Q 1 Skip Pattern =========================

        fpf00102.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpfGrp001.setVisibility(View.GONE);
                    //fpf001a.clearCheck();

                    fpf001a01.setChecked(false);
                    fpf001a02.setChecked(false);
                    fpf001a03.setChecked(false);
                    fpf001a04.setChecked(false);
                    fpf001a05.setChecked(false);
                    fpf001a06.setChecked(false);
                    fpf001a07.setChecked(false);
                    fpf001a08.setChecked(false);
                    fpf001a88.setChecked(false);

                    fpf001a88x.setText(null);
                    //fpf001b.clearCheck();

                    fpf001b01.setChecked(false);
                    fpf001b02.setChecked(false);
                    fpf001b03.setChecked(false);
                    fpf001b04.setChecked(false);
                    fpf001b88.setChecked(false);

                    fpf001b88x.setText(null);

                } else {
                    fpfGrp001.setVisibility(View.VISIBLE);


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

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateF();

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

        JSONObject sF = new JSONObject();

        sF.put("fpf001", fpf00101.isChecked() ? "1" : fpf00102.isChecked() ? "2" : "0");
        sF.put("fpf001a", fpf001a01.isChecked() ? "1" : fpf001a02.isChecked() ? "2" : fpf001a03.isChecked() ? "3" : fpf001a04.isChecked() ? "4" : fpf001a05.isChecked() ? "5" : fpf001a06.isChecked() ? "6" : fpf001a07.isChecked() ? "7" : fpf001a08.isChecked() ? "8" : fpf001a88.isChecked() ? "88" : "0");
        sF.put("fpf001b", fpf001b01.isChecked() ? "1" : fpf001b02.isChecked() ? "2" : fpf001b03.isChecked() ? "3" : fpf001b03.isChecked() ? "3" : fpf001b04.isChecked() ? "4" : fpf001b88.isChecked() ? 88 : "0");

        AppMain.fc.setsF(String.valueOf(sF));

        Toast.makeText(this, "validation succecful", Toast.LENGTH_SHORT).show();
    }

    public boolean validateForm() {

        // =================== Q1  ====================
        if (fpf001.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fpf001), Toast.LENGTH_SHORT).show();
            fpf00102.setError("This Data is required");
            Log.d(TAG, "not selected: fpf001 ");
            return false;
        } else {
            fpf00102.setError(null);
        }

        if (fpf00101.isChecked()) {
            // =================== Q1.1 ====================


            if (!(fpf001a01.isChecked() ||
                    fpf001a02.isChecked() ||
                    fpf001a03.isChecked() ||
                    fpf001a04.isChecked() ||
                    fpf001a05.isChecked() ||
                    fpf001a06.isChecked() ||
                    fpf001a07.isChecked() ||
                    fpf001a08.isChecked() ||
                    fpf001a88.isChecked())) {
                Toast.makeText(this, "" + getString(R.string.fpf001a), Toast.LENGTH_SHORT).show();
                fpf001a88.setError("This Data is required");
                Log.d(TAG, "not selected: fpf001a ");
                return false;
            } else {
                fpf001a88.setError(null);
            }


            /*if (fpf001a.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "" + getString(R.string.fpf001a), Toast.LENGTH_SHORT).show();
                fpf001a88.setError("This Data is required");
                Log.d(TAG, "not selected: fpf001a ");
                return false;
            } else {
                fpf001a88.setError(null);
            }*/

            if (fpf001a88.isChecked() && fpf001a88x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpf001a) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                fpf001a88x.setError("This data is Required!");    // Set Error on last radio button
                Log.d(TAG, "fpf001a88: This data is Required!");
                return false;
            } else {
                fpf001a88x.setError(null);
            }

            // =================== Q1.2 ====================

            if (!(fpf001b01.isChecked() ||
                    fpf001b02.isChecked() ||
                    fpf001b03.isChecked() ||
                    fpf001b04.isChecked() ||
                    fpf001b88.isChecked())) {
                Toast.makeText(this, "" + getString(R.string.fpf001b), Toast.LENGTH_SHORT).show();
                fpf001b88.setError("This Data is required");
                Log.d(TAG, "not selected: fpf001b ");
                return false;
            } else {
                fpf001b88.setError(null);
            }


            /*if (fpf001b.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "" + getString(R.string.fpf001b), Toast.LENGTH_SHORT).show();
                fpf001b88.setError("This Data is required");
                Log.d(TAG, "not selected: fpf001b ");
                return false;
            } else {
                fpf001b88.setError(null);
            }*/

            if (fpf001b88.isChecked() && fpf001b88x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpf001b) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                fpf001b88x.setError("This data is Required!");    // Set Error on last radio button
                Log.d(TAG, "fpf001b88: This data is Required!");
                return false;
            } else {
                fpf001b88x.setError(null);
            }
        }
        return true;
    }


}
