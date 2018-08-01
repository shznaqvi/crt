package edu.aku.hassannaqvi.cbtfollowup.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.text.Editable;
import android.text.TextWatcher;
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
import static edu.aku.hassannaqvi.cbtfollowup.R.string.fpd005;


public class SectionDActivity extends Activity {

    @BindView(R.id.activity_section_d)
    ScrollView activitySectionD;
    @BindView(R.id.fpd001)
    RadioGroup fpd001;
    @BindView(R.id.fpd00101)
    RadioButton fpd00101;
    @BindView(R.id.fpd00102)
    RadioButton fpd00102;
    @BindView(R.id.fpd00103)
    RadioButton fpd00103;
    @BindView(R.id.fpd00102r)
    EditText fpd00102r;
    @BindView(R.id.fpdGrp001)
    LinearLayout fpdGrp001;
    @BindView(R.id.fpdGrp001a)
    LinearLayout fpdGrp001a;
    /*@BindView(R.id.fpd001a)
    RadioGroup fpd001a;*/
    @BindView(R.id.fpd001a01)
    CheckBox fpd001a01;
    @BindView(R.id.fpd001a02)
    CheckBox fpd001a02;
    @BindView(R.id.fpd001a03)
    CheckBox fpd001a03;
    @BindView(R.id.fpd001a04)
    CheckBox fpd001a04;
    @BindView(R.id.fpd001a05)
    CheckBox fpd001a05;
    @BindView(R.id.fpd001a06)
    CheckBox fpd001a06;
    @BindView(R.id.fpd001a07)
    CheckBox fpd001a07;
    @BindView(R.id.fpd001a88)
    CheckBox fpd001a88;
    @BindView(R.id.fpd001a88x)
    EditText fpd001a88x;
    @BindView(R.id.fpd002)
    RadioGroup fpd002;
    @BindView(R.id.fpd00201)
    RadioButton fpd00201;
    @BindView(R.id.fpd00288)
    RadioButton fpd00288;
    @BindView(R.id.fpd00288x)
    EditText fpd00288x;
    @BindView(R.id.fpd003)
    EditText fpd003;
    @BindView(R.id.fpd004)
    EditText fpd004;
    @BindView(R.id.fpdGrp004)
    LinearLayout fpdGrp004;
    /*@BindView(R.id.fpd004a)
    RadioGroup fpd004a;*/
    @BindView(R.id.fpd004a01)
    CheckBox fpd004a01;
    @BindView(R.id.fpd004a02)
    CheckBox fpd004a02;
    @BindView(R.id.fpd004a03)
    CheckBox fpd004a03;
    @BindView(R.id.fpd004a04)
    CheckBox fpd004a04;
    @BindView(R.id.fpd004a05)
    CheckBox fpd004a05;
    @BindView(R.id.fpd004a06)
    CheckBox fpd004a06;
    @BindView(R.id.fpd004a07)
    CheckBox fpd004a07;
    @BindView(R.id.fpd004a88)
    CheckBox fpd004a88;
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
    @BindView(R.id.fpdGrp007)
    LinearLayout fpdGrp007;
    /*@BindView(R.id.fpd008)
    RadioGroup fpd008;*/
    @BindView(R.id.fpd00801)
    CheckBox fpd00801;
    @BindView(R.id.fpd00802)
    CheckBox fpd00802;
    @BindView(R.id.fpd00803)
    CheckBox fpd00803;
    @BindView(R.id.fpd00804)
    CheckBox fpd00804;
    @BindView(R.id.fpd00888)
    CheckBox fpd00888;
    @BindView(R.id.fpd00888x)
    EditText fpd00888x;
    @BindView(R.id.fpd009)
    RadioGroup fpd009;
    @BindView(R.id.fpd00901)
    RadioButton fpd00901;
    @BindView(R.id.fpd00902)
    RadioButton fpd00902;
    @BindView(R.id.fpdGrp009)
    LinearLayout fpdGrp009;
    //    @BindView(R.id.fpd009a)
//    RadioGroup fpd009a;
    @BindView(R.id.fpd009a01)
    CheckBox fpd009a01;
    @BindView(R.id.fpd009a02)
    CheckBox fpd009a02;
    @BindView(R.id.fpd009a03)
    CheckBox fpd009a03;
    @BindView(R.id.fpd009a88)
    CheckBox fpd009a88;
    @BindView(R.id.fpd009a88x)
    EditText fpd009a88x;
    @BindView(R.id.fpd009b)
    EditText fpd009b;
    /*@BindView(R.id.fpd009c)
    RadioGroup fpd009c;*/
    @BindView(R.id.fpd009c01)
    CheckBox fpd009c01;
    @BindView(R.id.fpd009c02)
    CheckBox fpd009c02;
    @BindView(R.id.fpd009c03)
    CheckBox fpd009c03;
    @BindView(R.id.fpd009c88)
    CheckBox fpd009c88;
    @BindView(R.id.fpd009c99)
    CheckBox fpd009c99;
    @BindView(R.id.fpd009c88x)
    EditText fpd009c88x;
    @BindView(R.id.fldGrpbtn)
    LinearLayout fldGrpbtn;
    @BindView(R.id.fpd00104)
    RadioButton fpd00104;
    @BindView(R.id.fldGrpfpd002)
    LinearLayout fldGrpfpd002;
    @BindView(R.id.fpdGrp005)
    LinearLayout fpdGrp005;
    @BindView(R.id.fpd005)
    RadioGroup fpd005;
    @BindView(R.id.fpd005a)
    RadioButton fpd005a;
    @BindView(R.id.fpd005b)
    RadioButton fpd005b;
    @BindView(R.id.fpd005c)
    RadioButton fpd005c;
    @BindView(R.id.fpd005d)
    RadioButton fpd005d;
    @BindView(R.id.fpd005e)
    RadioButton fpd005e;
    @BindView(R.id.fpd005f)
    RadioButton fpd005f;
    @BindView(R.id.fpd005fx)
    EditText fpd005fx;
    int sachet = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_d);
        ButterKnife.bind(this);

        fpd001.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (fpd00101.isChecked()) {
                    fpdGrp001.setVisibility(View.VISIBLE);
                    fldGrpfpd002.setVisibility(View.VISIBLE);
                    fpd00102r.setText(null);
                    fpd00102r.setVisibility(View.GONE);
                    fpdGrp001a.setVisibility(View.GONE);
                } else if (fpd00102.isChecked()) {
                    fpdGrp001.setVisibility(View.GONE);
                    fpd001a01.setChecked(false);
                    fpd001a02.setChecked(false);
                    fpd001a03.setChecked(false);
                    fpd001a04.setChecked(false);
                    fpd001a05.setChecked(false);
                    fpd001a06.setChecked(false);
                    fpd001a07.setChecked(false);
                    fpd001a88.setChecked(false);
                    fpd001a88x.setText(null);
                    fpd002.clearCheck();
                    fpd00288x.setText(null);
                    fpd003.setText(null);
                    fpd004.setText(null);
                    fpd004a01.setChecked(false);
                    fpd004a02.setChecked(false);
                    fpd004a03.setChecked(false);
                    fpd004a04.setChecked(false);
                    fpd004a05.setChecked(false);
                    fpd004a06.setChecked(false);
                    fpd004a07.setChecked(false);
                    fpd004a88.setChecked(false);
                    fpd004a88x.setText(null);
                    fpd00501.setText(null);
                    fpd00502.setText(null);
                    fpd00601.setText(null);
                    fpd00602.setText(null);
                    fpd007.clearCheck();
                    fpd00801.setChecked(false);
                    fpd00802.setChecked(false);
                    fpd00803.setChecked(false);
                    fpd00804.setChecked(false);
                    fpd00888.setChecked(false);
                    fpd00888x.setText(null);
                    fpd009.clearCheck();
                    fpd009a01.setChecked(false);
                    fpd009a02.setChecked(false);
                    fpd009a03.setChecked(false);
                    fpd009a88.setChecked(false);
                    fpd009a88x.setText(null);
                    fpd009b.setText(null);
                    fpd009c01.setChecked(false);
                    fpd009c02.setChecked(false);
                    fpd009c03.setChecked(false);
                    fpd009c88.setChecked(false);
                    fpd009c99.setChecked(false);
                    fpd009c88x.setText(null);
                    fpd00102r.setVisibility(View.VISIBLE);
                } else if (fpd00103.isChecked()) {
                    fpd00102r.setText(null);
                    fpd00102r.setVisibility(View.GONE);
                    fpdGrp001.setVisibility(View.VISIBLE);
                    fpdGrp001a.setVisibility(View.VISIBLE);
                    fldGrpfpd002.setVisibility(View.GONE);
                    fpd002.clearCheck();
                    fpd00288x.setText(null);
                    fpd003.setText(null);
                    fpd004.setText(null);
                    fpd004a01.setChecked(false);
                    fpd004a02.setChecked(false);
                    fpd004a03.setChecked(false);
                    fpd004a04.setChecked(false);
                    fpd004a05.setChecked(false);
                    fpd004a06.setChecked(false);
                    fpd004a07.setChecked(false);
                    fpd004a88.setChecked(false);
                    fpd004a88x.setText(null);
                    fpd00501.setText(null);
                    fpd00502.setText(null);
                    fpd00601.setText(null);
                    fpd00602.setText(null);
                    fpd007.clearCheck();
                    fpd00801.setChecked(false);
                    fpd00802.setChecked(false);
                    fpd00803.setChecked(false);
                    fpd00804.setChecked(false);
                    fpd00888.setChecked(false);
                    fpd00888x.setText(null);
                    fpd009.clearCheck();
                    fpd009a01.setChecked(false);
                    fpd009a02.setChecked(false);
                    fpd009a03.setChecked(false);
                    fpd009a88.setChecked(false);
                    fpd009a88x.setText(null);
                    fpd009b.setText(null);
                    fpd009c01.setChecked(false);
                    fpd009c02.setChecked(false);
                    fpd009c03.setChecked(false);
                    fpd009c88.setChecked(false);
                    fpd009c88x.setText(null);
                    fpd009c99.setChecked(false);

                } else if (fpd00104.isChecked()) {
                    fpdGrp001a.setVisibility(View.GONE);
                    fldGrpfpd002.setVisibility(View.GONE);
                    fpd00102r.setVisibility(View.GONE);
                    fpd00102r.setText(null);
                    fpd001a01.setChecked(false);
                    fpd001a02.setChecked(false);
                    fpd001a03.setChecked(false);
                    fpd001a04.setChecked(false);
                    fpd001a05.setChecked(false);
                    fpd001a06.setChecked(false);
                    fpd001a07.setChecked(false);
                    fpd001a88.setChecked(false);
                    fpd001a88x.setText(null);
                    fpd002.clearCheck();
                    fpd00288x.setText(null);
                    fpd003.setText(null);
                    fpd004.setText(null);
                    fpd004a01.setChecked(false);
                    fpd004a02.setChecked(false);
                    fpd004a03.setChecked(false);
                    fpd004a04.setChecked(false);
                    fpd004a05.setChecked(false);
                    fpd004a06.setChecked(false);
                    fpd004a07.setChecked(false);
                    fpd004a88.setChecked(false);
                    fpd004a88x.setText(null);
                    fpd00501.setText(null);
                    fpd00502.setText(null);
                    fpd00601.setText(null);
                    fpd00602.setText(null);
                    fpd007.clearCheck();
                    fpd00801.setChecked(false);
                    fpd00802.setChecked(false);
                    fpd00803.setChecked(false);
                    fpd00804.setChecked(false);
                    fpd00888.setChecked(false);
                    fpd00888x.setText(null);
                    fpd009.clearCheck();
                    fpd009a01.setChecked(false);
                    fpd009a02.setChecked(false);
                    fpd009a03.setChecked(false);
                    fpd009a88.setChecked(false);
                    fpd009a88x.setText(null);
                    fpd009b.setText(null);
                    fpd009c01.setChecked(false);
                    fpd009c02.setChecked(false);
                    fpd009c03.setChecked(false);
                    fpd009c88.setChecked(false);
                    fpd009c99.setChecked(false);
                    fpd009c88x.setText(null);
                }
            }
        });
        // =================== Q1.1 Others ====================

        fpd001a88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpd001a88x.setVisibility(View.VISIBLE);
                } else {
                    fpd001a88x.setVisibility(View.GONE);
                    fpd001a88x.setText(null);
                }
            }
        });

        // =================== Q2 Others ====================
        fpd00288.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpd00288x.setVisibility(View.VISIBLE);
                } else {
                    fpd00288x.setVisibility(View.GONE);
                    fpd00288x.setText(null);
                }
            }
        });


        // =================== Q4.1 Others ====================

        fpd004a88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpd004a88x.setVisibility(View.VISIBLE);
                } else {
                    fpd004a88x.setVisibility(View.GONE);
                    fpd004a88x.setText(null);
                }
            }
        });


        fpd004.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!fpd004.getText().toString().isEmpty()) {
                    if (Integer.parseInt(fpd004.getText().toString()) == 0) {

                        fpdGrp004.setVisibility(View.VISIBLE);

                    } else {

                        fpd004a01.setChecked(false);
                        fpd004a02.setChecked(false);
                        fpd004a03.setChecked(false);
                        fpd004a04.setChecked(false);
                        fpd004a05.setChecked(false);
                        fpd004a06.setChecked(false);
                        fpd004a07.setChecked(false);
                        fpd004a88.setChecked(false);
                        fpd004a88x.setText(null);

                        fpdGrp004.setVisibility(View.GONE);
                        fpd004a88x.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //=================== Q5 check===========================
        fpd00502.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().equalsIgnoreCase("")) {

                    sachet = Integer.parseInt(charSequence.toString());
                } else {
                    sachet = 0;
                }
                if (sachet < 30 && sachet != 0) {

                    fpdGrp005.setVisibility(View.VISIBLE);
                } else {

                    fpdGrp005.setVisibility(View.GONE);
                    fpd005.clearCheck();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });


        fpd005.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.fpd005f) {

                    fpd005fx.setVisibility(View.VISIBLE);

                } else {

                    fpd005fx.setVisibility(View.GONE);
                    fpd005fx.setText(null);

                }
            }
        });


        // =================== Q8 Others ====================

        fpd00888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpd00888x.setVisibility(View.VISIBLE);
                } else {
                    fpd00888x.setVisibility(View.GONE);
                    fpd00888x.setText(null);
                }
            }
        });

        // =================== Q9.1 Others ====================

        fpd009a88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpd009a88x.setVisibility(View.VISIBLE);
                } else {
                    fpd009a88x.setVisibility(View.GONE);
                    fpd009a88x.setText(null);
                }
            }
        });

        /*fpd009c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (fpd009c88.isChecked()) {
                    fpd009c88x.setVisibility(View.VISIBLE);
                } else {
                    fpd009c88x.setVisibility(View.GONE);
                    fpd009c88x.setText(null);
                }

            }
        });*/


        fpd009c88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (fpd009c88.isChecked()) {
                    fpd009c88x.setVisibility(View.VISIBLE);
                    fpd009c99.setChecked(false);
                } else {
                    fpd009c88x.setVisibility(View.GONE);
                    fpd009c88x.setText(null);
                }
            }
        });


        fpd009c01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (fpd009c01.isChecked()) {
                    fpd009c99.setChecked(false);
                }
            }
        });

        fpd009c02.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (fpd009c02.isChecked()) {
                    fpd009c99.setChecked(false);
                }
            }
        });

        fpd009c03.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (fpd009c03.isChecked()) {
                    fpd009c99.setChecked(false);
                }
            }
        });


        fpd009c99.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (fpd009c99.isChecked()) {
                    fpd009c01.setChecked(false);
                    fpd009c02.setChecked(false);
                    fpd009c03.setChecked(false);
                    fpd009c88.setChecked(false);
                }
            }
        });


        // ====================== Q 7 Skip Pattern =========================

        fpd007.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (fpd00701.isChecked()) {
                    fpdGrp007.setVisibility(View.VISIBLE);
                } else {
                    fpdGrp007.setVisibility(View.GONE);
                    //fpd008.clearCheck();
                    fpd00801.setChecked(false);
                    fpd00802.setChecked(false);
                    fpd00803.setChecked(false);
                    fpd00804.setChecked(false);
                    fpd00888.setChecked(false);

                    fpd00888x.setText(null);
                }
            }
        });

        // ====================== Q 9 Skip Pattern =========================

        fpd009.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (fpd00901.isChecked()) {
                    fpdGrp009.setVisibility(View.VISIBLE);
                } else {
                    fpdGrp009.setVisibility(View.GONE);
                    //fpd009a.clearCheck();

                    fpd009a01.setChecked(false);
                    fpd009a02.setChecked(false);
                    fpd009a03.setChecked(false);
                    fpd009a88.setChecked(false);

                    fpd009a88x.setText(null);
                    fpd009b.setText(null);
                    //fpd009c.clearCheck();

                    fpd009c01.setChecked(false);
                    fpd009c02.setChecked(false);
                    fpd009c03.setChecked(false);
                    fpd009c88.setChecked(false);

                    fpd009c88x.setText(null);
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
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }


    }

    private void saveDrafts() throws JSONException {
        Toast.makeText(this, "saving Drafts", Toast.LENGTH_SHORT).show();

        JSONObject sD = new JSONObject();

        sD.put("fpd001", fpd00101.isChecked() ? "1" : fpd00102.isChecked() ? "2" : fpd00103.isChecked() ? "3"
                : fpd00104.isChecked() ? "4" : "0");
        sD.put("fpd00102r", fpd00102r.getText().toString());
        sD.put("fpd001a01", fpd001a01.isChecked() ? "1" : "0");
        sD.put("fpd001a02", fpd001a02.isChecked() ? "2" : "0");
        sD.put("fpd001a03", fpd001a03.isChecked() ? "3" : "0");
        sD.put("fpd001a04", fpd001a04.isChecked() ? "4" : "0");
        sD.put("fpd001a05", fpd001a05.isChecked() ? "5" : "0");
        sD.put("fpd001a06", fpd001a06.isChecked() ? "6" : "0");
        sD.put("fpd001a07", fpd001a07.isChecked() ? "7" : "0");
        sD.put("fpd001a88", fpd001a88.isChecked() ? "88" : "0");
        sD.put("fpd001a88x", fpd001a88x.getText().toString());
        //sD.put("fpd002", fpd00201.isChecked() ? "1" : fpd00202.isChecked() ? "2" : fpd00288.isChecked() ? "88"
        //: fpd00299.isChecked() ? "99" : "0");
        sD.put("fpd00288x", fpd00288x.getText().toString());
        sD.put("fpd003", fpd003.getText().toString());
        sD.put("fpd004", fpd004.getText().toString());
        sD.put("fpd004a01", fpd004a01.isChecked() ? "1" : "0");
        sD.put("fpd004a02", fpd001a02.isChecked() ? "2" : "0");
        sD.put("fpd004a03", fpd001a03.isChecked() ? "3" : "0");
        sD.put("fpd004a04", fpd001a04.isChecked() ? "4" : "0");
        sD.put("fpd004a05", fpd001a05.isChecked() ? "5" : "0");
        sD.put("fpd004a06", fpd001a06.isChecked() ? "6" : "0");
        sD.put("fpd004a07", fpd001a07.isChecked() ? "7" : "0");
        sD.put("fpd004a88", fpd001a88.isChecked() ? "88" : "0");
        sD.put("fpd004a88x", fpd004a88x.getText().toString());
        sD.put("fpd00501", fpd00501.getText().toString());
        sD.put("fpd00502", fpd00502.getText().toString());
        if (sachet < 30) {
            sD.put("fpd005aa", fpd005fx.getText().toString());
            sD.put("fpd005aa", fpd005a.isChecked() ? "1" : fpd005b.isChecked() ? "2" : fpd005c.isChecked() ? "3" : fpd005d.isChecked() ? "4" : fpd005e.isChecked() ? "5" : fpd005e.isChecked() ? "96" : "0");
        }
        sD.put("fpd00601 ", fpd00601.getText().toString());
        sD.put("fpd00602 ", fpd00602.getText().toString());
        sD.put("fpd007", fpd00701.isChecked() ? "1" : fpd00702.isChecked() ? "2" : "0");
        sD.put("fpd00801", fpd00801.isChecked() ? "1" : "0");
        sD.put("fpd00802", fpd00802.isChecked() ? "2" : "0");
        sD.put("fpd00803", fpd00803.isChecked() ? "3" : "0");
        sD.put("fpd00804", fpd00804.isChecked() ? "4" : "0");
        sD.put("fpd00888", fpd00888.isChecked() ? "88" : "0");
        sD.put("fpd00888x", fpd00888x.getText().toString());
        sD.put("fpd009", fpd00901.isChecked() ? "1" : fpd00902.isChecked() ? "2" : "0");
        sD.put("fpd009a01", fpd009a01.isChecked() ? "1" : "0");
        sD.put("fpd009a02", fpd009a02.isChecked() ? "2" : "0");
        sD.put("fpd009a03", fpd009a03.isChecked() ? "3" : "0");
        sD.put("fpd009a88", fpd009a88.isChecked() ? "88" : "0");
        sD.put("fpd009a88x", fpd009a88x.getText().toString());
        sD.put("fpd009b", fpd009b.getText().toString());
        sD.put("fpd009c01", fpd009c01.isChecked() ? "1" : "0");
        sD.put("fpd009c02", fpd009c02.isChecked() ? "2" : "0");
        sD.put("fpd009c03", fpd009c03.isChecked() ? "3" : "0");
        sD.put("fpd009c99", fpd009c99.isChecked() ? "99" : "0");
        sD.put("fpd009c88", fpd009c88.isChecked() ? "88" : "0");
        sD.put("fpd009c88x", fpd009c88x.getText().toString());

        AppMain.fc.setsD(String.valueOf(sD));

        Toast.makeText(this, "validation successful", Toast.LENGTH_SHORT).show();

    }

    public boolean validateForm() {

        // =================== Q1  ====================
        if (fpd001.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fpd001), Toast.LENGTH_SHORT).show();
            fpd00104.setError("This Data is required");
            Log.d(TAG, "not selected: fpd001 ");
            return false;
        } else {
            fpd00104.setError(null);
        }

        if (fpd00102.isChecked() && fpd00102r.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpd001) + " - " + getString(R.string.fpd00102r), Toast.LENGTH_LONG).show();
            fpd00102r.setError("This data is Required!");    // Set Error on last radio button
            Log.d(TAG, "fpd00102: This data is Required!");
            return false;
        } else {
            fpd00102r.setError(null);
        }

        if (fpd00103.isChecked()) {
            // =================== Q1.1  ====================

            if (!(fpd001a01.isChecked() ||
                    fpd001a02.isChecked() ||
                    fpd001a03.isChecked() ||
                    fpd001a04.isChecked() ||
                    fpd001a05.isChecked() ||
                    fpd001a06.isChecked() ||
                    fpd001a07.isChecked() ||
                    fpd001a88.isChecked())) {
                Toast.makeText(this, "" + getString(R.string.fpd001a), Toast.LENGTH_SHORT).show();
                fpd001a07.setError("This Data is required");
                Log.d(TAG, "not selected: fpd001a ");
                return false;
            } else {
                fpd001a07.setError(null);
            }


            if (fpd001a88.isChecked() && fpd001a88x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpd001a) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                fpd001a88x.setError("This data is Required!");    // Set Error on last radio button
                Log.d(TAG, "fpd001a88x: This data is Required!");
                return false;
            } else {
                fpd001a88x.setError(null);
            }
        }

        if (fpd00101.isChecked()) {

            // =================== Q2 ====================

            if (fpd002.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "" + getString(R.string.fpd002), Toast.LENGTH_SHORT).show();
                fpd00201.setError("This Data is required");
                Log.i(TAG, "not selected: fpd002");
                return false;
            } else {
                fpd00201.setError("This Data is required");
            }

            if (fpd00288.isChecked() && fpd00288x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpd002) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                fpd00288x.setError("This data is Required!");    // Set Error on last radio button
                Log.d(TAG, "fpd00288: This data is Required!");
                return false;
            } else {
                fpd00288x.setError(null);
            }

            // =================== Q3 ====================
            if (fpd003.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpd003), Toast.LENGTH_SHORT).show();
                fpd003.setError("This data is required");
                Log.d(TAG, "empty: fpd003  ");
                return false;
            } else {
                fpd003.setError(null);
            }


            if ((Integer.parseInt(fpd003.getText().toString().isEmpty() ? "0" : fpd003.getText().toString()) < 1) || (Integer.parseInt(fpd003.getText().toString()) > 40)) {
                Toast.makeText(this, "ERROR: " + getString(R.string.fpd004), Toast.LENGTH_LONG).show();
                fpd003.setError("Range is 1-40 ");
                Log.i(TAG, "fpd003: Range is 1-40 ");
                return false;
            } else {
                fpd003.setError(null);
            }

            // =================== Q4 ====================
            if (fpd004.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpd004), Toast.LENGTH_SHORT).show();
                fpd004.setError("This data is required");
                Log.d(TAG, "empty: fpd004  ");
                return false;
            } else {
                fpd004.setError(null);
            }

            if ((Integer.parseInt(fpd004.getText().toString().isEmpty() ? "0" : fpd004.getText().toString()) < 0) || (Integer.parseInt(fpd004.getText().toString()) > 5)) {
                Toast.makeText(this, "ERROR: " + getString(R.string.fpd004), Toast.LENGTH_LONG).show();
                fpd004.setError("Range is 0 - 5 ");
                Log.i(TAG, "fpd004: Range is 0 - 5 ");
                return false;
            } else {
                fpd004.setError(null);
            }

            // =================== Q4.1 ====================


            if (fpdGrp004.getVisibility() == View.VISIBLE) {

                if (Integer.parseInt(fpd004.getText().toString()) > 0) {

                    if (!(fpd004a01.isChecked() ||
                            fpd004a02.isChecked() ||
                            fpd004a03.isChecked() ||
                            fpd004a04.isChecked() ||
                            fpd004a05.isChecked() ||
                            fpd004a06.isChecked() ||
                            fpd004a07.isChecked() ||
                            fpd004a88.isChecked())) {
                        Toast.makeText(this, "" + getString(R.string.fpd004a), Toast.LENGTH_SHORT).show();
                        fpd004a07.setError("This Data is required");
                        Log.d(TAG, "not selected: fpd004a ");
                        return false;
                    } else {
                        fpd004a07.setError(null);
                    }

                }
            }






        /*if (fpd004a.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fpd004a), Toast.LENGTH_SHORT).show();
            fpd004a07.setError("This Data is required");
            Log.d(TAG, "not selected: fpd004a ");
            return false;
        } else {
            fpd004a07.setError(null);
        }*/

            if (fpd004a88.isChecked() && fpd004a88x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpd004a) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                fpd004a88x.setError("This data is Required!");    // Set Error on last radio button
                Log.d(TAG, "fpd004a88: This data is Required!");
                return false;
            } else {
                fpd004a88x.setError(null);
            }

            // =================== Q5 ====================
            if (fpd00501.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.day), Toast.LENGTH_SHORT).show();
                fpd00501.setError("This data is required");
                Log.d(TAG, "empty: fpd00501  ");
                return false;
            } else {
                fpd00501.setError(null);
            }

            if (sachet < 30) {

                if (fpd005.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "" + getString(R.string.fpd005aa), Toast.LENGTH_SHORT).show();
                    fpd005a.setError("This Data is required");
                    Log.d(TAG, "not selected: fpd004a ");
                    fpd005a.requestFocus();
                    return false;
                } else {
                    fpd005a.setError(null);
                    fpd005a.clearFocus();
                }

            }

            if (fpd005f.isChecked()) {

                if (fpd005fx.getText().toString().isEmpty()) {

                    Toast.makeText(this, getString(R.string.fpd005), Toast.LENGTH_SHORT).show();
                    fpd005fx.setError("This field is required");
                    fpd005fx.requestFocus();
                } else {
                    fpd005fx.clearFocus();

                }
            }


            if ((Integer.parseInt(fpd00501.getText().toString()) < 0) || (Integer.parseInt(fpd00501.getText().toString()) > 30)) {
                Toast.makeText(this, "ERROR: " + getString(R.string.fpd005) + getString(R.string.day), Toast.LENGTH_LONG).show();
                fpd00501.setError("Range is 0-30 days");
                Log.i(TAG, "fpd00501: Range is 0-30 days");
                return false;
            } else {
                fpd00501.setError(null);
            }

            if (fpd00502.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpd00501), Toast.LENGTH_SHORT).show();
                fpd00502.setError("This data is required");
                Log.d(TAG, "empty: fpd00502  ");
                return false;
            } else {
                fpd00502.setError(null);
            }

            if ((Integer.parseInt(fpd00502.getText().toString().isEmpty() ? "0" : fpd00502.getText().toString()) < 1) || (Integer.parseInt(fpd00502.getText().toString()) > 40)) {
                Toast.makeText(this, "ERROR: " + getString(R.string.fpd005) + getString(R.string.fpd00501), Toast.LENGTH_LONG).show();
                fpd00502.setError("Range is 1-40 ");
                Log.i(TAG, "fph005: Range is 1-40 ");
                return false;
            } else {
                fpd00502.setError(null);
            }


            // =================== Q6 ====================
            if (fpd00601.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpd006), Toast.LENGTH_SHORT).show();
                fpd00601.setError("This data is required");
                Log.d(TAG, "empty: fpd00601  ");
                return false;
            } else {
                fpd00601.setError(null);
            }

            if ((Integer.parseInt(fpd00601.getText().toString().isEmpty() ? "0" : fpd00601.getText().toString()) < 0) || (Integer.parseInt(fpd00601.getText().toString()) > 40)) {
                Toast.makeText(this, "ERROR: " + getString(R.string.fpd006), Toast.LENGTH_LONG).show();
                fpd00601.setError("Range is 0-40 ");
                Log.i(TAG, "fpd00601: Range is 0-40 ");
                return false;
            } else {
                fpd00601.setError(null);
            }

            if (fpd00602.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpd00602), Toast.LENGTH_SHORT).show();
                fpd00602.setError("This data is required");
                Log.d(TAG, "empty: fpd00602  ");
                return false;
            } else {
                fpd00602.setError(null);
            }

            if ((Integer.parseInt(fpd00602.getText().toString().isEmpty() ? "0" : fpd00602.getText().toString()) < 0) || (Integer.parseInt(fpd00602.getText().toString()) > 40)) {
                Toast.makeText(this, "ERROR: " + getString(R.string.fpd006), Toast.LENGTH_LONG).show();
                fpd00602.setError("Range is 0-40 ");
                Log.i(TAG, "fpd00601: Range is 0-40 ");
                return false;
            } else {
                fpd00602.setError(null);
            }

            // =================== Q7 ====================
            if (fpd007.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "" + getString(R.string.fpd007), Toast.LENGTH_SHORT).show();
                fpd00702.setError("This Data is required");
                Log.d(TAG, "not selected: fpd007 ");
                return false;
            } else {
                fpd00702.setError(null);
            }

            if (fpd00701.isChecked()) {

                // =================== Q8 ====================


                if (!(fpd00801.isChecked() ||
                        fpd00802.isChecked() ||
                        fpd00803.isChecked() ||
                        fpd00804.isChecked() ||
                        fpd00888.isChecked())) {
                    Toast.makeText(this, "" + getString(R.string.fpd008), Toast.LENGTH_SHORT).show();
                    fpd00804.setError("This Data is required");
                    Log.d(TAG, "not selected: fpd008 ");
                    return false;
                } else {
                    fpd00804.setError(null);
                }

            /*if (fpd008.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "" + getString(R.string.fpd008), Toast.LENGTH_SHORT).show();
                fpd00804.setError("This Data is required");
                Log.d(TAG, "not selected: fpd008 ");
                return false;
            } else {
                fpd00804.setError(null);
            }*/

                if (fpd00888.isChecked() && fpd00888x.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpd008) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                    fpd00888x.setError("This data is Required!");    // Set Error on last radio button
                    Log.d(TAG, "fpd00888: This data is Required!");
                    return false;
                } else {
                    fpd00888x.setError(null);
                }
            }

            // =================== Q9 ====================
            if (fpd009.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "" + getString(R.string.fpd009), Toast.LENGTH_SHORT).show();
                fpd00902.setError("This Data is required");
                Log.d(TAG, "not selected: fpd009 ");
                return false;
            } else {
                fpd00902.setError(null);
            }

            if (fpd00901.isChecked()) {

                // =================== Q9.1 ====================


                if (!(fpd009a01.isChecked() ||
                        fpd009a02.isChecked() ||
                        fpd009a03.isChecked() ||
                        fpd009a88.isChecked())) {
                    Toast.makeText(this, "" + getString(R.string.fpd009a), Toast.LENGTH_SHORT).show();
                    fpd009a03.setError("This Data is required");
                    Log.d(TAG, "not selected: fpd009a ");
                    return false;
                } else {
                    fpd009a03.setError(null);
                }


            /*if (fpd009a.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "" + getString(R.string.fpd009a), Toast.LENGTH_SHORT).show();
                fpd009a03.setError("This Data is required");
                Log.d(TAG, "not selected: fpd009a ");
                return false;
            } else {
                fpd009a03.setError(null);
            }*/

                if (fpd009a88.isChecked() && fpd009a88x.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpd009a) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                    fpd009a88x.setError("This data is Required!");    // Set Error on last radio button
                    Log.d(TAG, "fpd009a88: This data is Required!");
                    return false;
                } else {
                    fpd009a88x.setError(null);
                }

                // =================== Q9.2 ====================
                if (fpd009b.getText().toString().isEmpty()) {
                    Toast.makeText(this, "" + getString(R.string.fpd009b), Toast.LENGTH_SHORT).show();
                    fpd009b.setError("This data is required");
                    Log.d(TAG, "empty: fpd009b  ");
                    return false;
                } else {
                    fpd009b.setError(null);
                }


                if ((Integer.parseInt(fpd009b.getText().toString().isEmpty() ? "0" : fpd009b.getText().toString()) < 1) ||
                        (Integer.parseInt(fpd009b.getText().toString()) > 120)) {
                    Toast.makeText(this, "" + getString(R.string.fpd009b), Toast.LENGTH_SHORT).show();
                    fpd009b.setError("Range is 1 - 120 ");
                    Log.i(TAG, "fpd009b: Range is 1 - 120 ");
                    return false;
                } else {
                    fpd009b.setError(null);
                }


                // =================== Q9.3 ====================

                if (!fpd009c01.isChecked() &&
                        !fpd009c02.isChecked() &&
                        !fpd009c03.isChecked() &&
                        !fpd009c88.isChecked() &&
                        !fpd009c99.isChecked()) {
                    Toast.makeText(this, "" + getString(R.string.fpd009c), Toast.LENGTH_SHORT).show();
                    fpd009c88.setError("This Data is required");
                    Log.d(TAG, "not selected: fpd009c ");
                    return false;
                } else {
                    fpd009c88.setError(null);
                }

            /*if (fpd009c.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "" + getString(R.string.fpd009c), Toast.LENGTH_SHORT).show();
                fpd009c03.setError("This Data is required");
                Log.d(TAG, "not selected: fpd009c ");
                return false;
            } else {
                fpd009c03.setError(null);
            }*/

                if (fpd009c88.isChecked() && fpd009c88x.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpd009c) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                    fpd009c88x.setError("This data is Required!");    // Set Error on last radio button
                    Log.d(TAG, "fpd009c88: This data is Required!");
                    return false;
                } else {
                    fpd009c88x.setError(null);
                }
            }
        }


        return true;
    }


}
