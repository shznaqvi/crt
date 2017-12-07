package edu.aku.hassannaqvi.cbtfollowup.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
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
import static edu.aku.hassannaqvi.cbtfollowup.R.string.fpb007;

public class SectionBActivity extends Activity {

    @BindView(R.id.activity_section_b)
    ScrollView activitySectionB;
    @BindView(R.id.fpb001m1)
    EditText fpb001m1;
    @BindView(R.id.fpb002m1)
    EditText fpb002m1;
    @BindView(R.id.fpb001m2)
    EditText fpb001m2;
    @BindView(R.id.fpb002m2)
    EditText fpb002m2;
    @BindView(R.id.fpb001m3)
    EditText fpb001m3;
    @BindView(R.id.fpb002m3)
    EditText fpb002m3;
    @BindView(R.id.fpb004)
    RadioGroup fpb004;
    @BindView(R.id.fpb00401)
    RadioButton fpb00401;
    @BindView(R.id.fpb00402)
    RadioButton fpb00402;
    @BindView(R.id.fpb00477)
    RadioButton fpb00477;
    @BindView(R.id.fldGrp004)
    LinearLayout fldGrp004;
    @BindView(R.id.fpb005)
    RadioGroup fpb005;
    @BindView(R.id.fpb00501)
    RadioButton fpb00501;
    @BindView(R.id.fpb00588)
    RadioButton fpb00588;
    @BindView(R.id.fpb00588x)
    EditText fpb00588x;
    @BindView(R.id.fpb00601)
    EditText fpb00601;
    @BindView(R.id.fpb00677)
    CheckBox fpb00677;
    @BindView(R.id.fpb00701)
    EditText fpb00701;
    @BindView(R.id.fpb00702)
    EditText fpb00702;
    @BindView(R.id.fpb00801)
    EditText fpb00801;
    @BindView(R.id.fpb00802)
    EditText fpb00802;
    @BindView(R.id.fpb009)
    RadioGroup fpb009;
    @BindView(R.id.fpb00901)
    RadioButton fpb00901;
    @BindView(R.id.fpb00902)
    RadioButton fpb00902;

    @BindView(R.id.fldGrp009)
    LinearLayout fldGrp009;
    @BindView(R.id.fpb01001)
    CheckBox fpb01001;
    @BindView(R.id.fpb01002)
    CheckBox fpb01002;
    @BindView(R.id.fpb01003)
    CheckBox fpb01003;
    @BindView(R.id.fpb01004)
    CheckBox fpb01004;
    @BindView(R.id.fpb01088)
    CheckBox fpb01088;
    @BindView(R.id.fpb01088x)
    EditText fpb01088x;
    @BindView(R.id.fpb011)
    RadioGroup fpb011;
    @BindView(R.id.fpb01101)
    RadioButton fpb01101;
    @BindView(R.id.fpb01102)
    RadioButton fpb01102;
    @BindView(R.id.fpb01177)
    RadioButton fpb01177;

    @BindView(R.id.fldGrp012)
    LinearLayout fldGrp012;
    @BindView(R.id.fpb012)
    EditText fpb012;
    @BindView(R.id.fldGrp013)
    LinearLayout fldGrp013;
    @BindView(R.id.fpb013)
    EditText fpb013;
    @BindView(R.id.fpb014)
    RadioGroup fpb014;
    @BindView(R.id.fpb01401)
    RadioButton fpb01401;
    @BindView(R.id.fpb01402)
    RadioButton fpb01402;
    @BindView(R.id.fpb01477)
    RadioButton fpb01477;
    @BindView(R.id.fldGrp014)
    LinearLayout fldGrp014;
    @BindView(R.id.fpb01501)
    EditText fpb01501;
    @BindView(R.id.fpb01502)
    CheckBox fpb01502;
    @BindView(R.id.fpb016)
    RadioGroup fpb016;
    @BindView(R.id.fpb01601)
    RadioButton fpb01601;
    @BindView(R.id.fpb01602)
    RadioButton fpb01602;
    @BindView(R.id.fpb017)
    EditText fpb017;
    @BindView(R.id.fpb018)
    EditText fpb018;
    @BindView(R.id.fpb019)
    EditText fpb019;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_b);
        ButterKnife.bind(this);

        fpb00588.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpb00588x.setVisibility(View.VISIBLE);
                } else {
                    fpb00588x.setVisibility(View.GONE);
                    fpb00588x.setText(null);
                }
            }
        });

        fpb00677.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    fpb00601.setVisibility(View.GONE);
                    fpb00601.setText(null);
                } else {
                    fpb00601.setVisibility(View.VISIBLE);
                }
            }
        });


        fpb004.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (fpb00401.isChecked()) {
                    fldGrp004.setVisibility(View.VISIBLE);
                } else {
                    fldGrp004.setVisibility(View.GONE);
                    fpb005.clearCheck();
                    fpb00588x.setText(null);
                    fpb00601.setText(null);
                    fpb00677.setChecked(false);
                    fpb00702.setText(null);
                    fpb00701.setText(null);
                    fpb00802.setText(null);
                    fpb00801.setText(null);
                    fpb009.clearCheck();
                    fpb01001.setChecked(false);
                    fpb01002.setChecked(false);
                    fpb01003.setChecked(false);
                    fpb01004.setChecked(false);
                    fpb01088.setChecked(false);
                    fpb01088x.setText(null);

                }
            }
        });

        fpb009.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (fpb00901.isChecked()) {
                    fldGrp009.setVisibility(View.VISIBLE);
                } else {
                    fldGrp009.setVisibility(View.GONE);
                    //fpd008.clearCheck();
                    fpb01001.setChecked(false);
                    fpb01002.setChecked(false);
                    fpb01003.setChecked(false);
                    fpb01004.setChecked(false);
                    fpb01088.setChecked(false);

                    fpb01088x.setText(null);
                }
            }
        });


        fpb01088.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpb01088x.setVisibility(View.VISIBLE);
                } else {
                    fpb01088x.setVisibility(View.GONE);
                    fpb01088x.setText(null);
                }
            }
        });

        fpb011.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (fpb01101.isChecked()) {
                    fldGrp012.setVisibility(View.VISIBLE);
                    fldGrp013.setVisibility(View.GONE);
                    fpb013.setText(null);

                } else if (fpb01102.isChecked()) {
                    fldGrp013.setVisibility(View.VISIBLE);
                    fldGrp012.setVisibility(View.GONE);
                    fpb012.setText(null);
                } else {
                    fldGrp013.setVisibility(View.GONE);
                    fldGrp012.setVisibility(View.GONE);
                    fpb012.setText(null);
                    fpb013.setText(null);
                }

            }
        });


        fpb014.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (fpb01401.isChecked()) {
                    fldGrp014.setVisibility(View.GONE);
                    fpb01501.setText(null);
                    fpb01502.setChecked(false);
                } else {
                    fldGrp014.setVisibility(View.VISIBLE);

                }
            }
        });

        fpb01502.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    fpb01501.setVisibility(View.GONE);
                    fpb01501.setText(null);
                } else {
                    fpb01501.setVisibility(View.VISIBLE);
                }
            }
        });

    }


    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        Toast.makeText(this, "complete section", Toast.LENGTH_SHORT).show();
        Intent endSec = new Intent(this, EndingActivity.class);
        endSec.putExtra("complete", false);
        startActivity(endSec);
        AppMain.endActivity(this, this);
    }


    @OnClick(R.id.btnNext)
    void onBtnNextClick() {
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

                /*if (AppMain.arm == 1) {
                    Intent secD = new Intent(this, SectionGActivity.class);
                    startActivity(secD);
                } else if (AppMain.arm == 2 || AppMain.arm == 3) {
                    Intent secD = new Intent(this, SectionEActivity.class);
                    startActivity(secD);
                } else {
                    Intent secD = new Intent(this, SectionDActivity.class);
                    startActivity(secD);
                }*/

                finish();
                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));


            } else {
                Toast.makeText(this, "Failed to update Database", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean updateDb() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateB();

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

        JSONObject sB = new JSONObject();

        sB.put("fpb001m1", fpb001m1.getText().toString());
        sB.put("fpb001m2", fpb001m2.getText().toString());
        sB.put("fpb001m3", fpb001m3.getText().toString());
        sB.put("fpb002m1", fpb002m1.getText().toString());
        sB.put("fpb002m2", fpb002m2.getText().toString());
        sB.put("fpb002m3", fpb002m3.getText().toString());
        sB.put("fpb004", fpb00401.isChecked() ? "1" : fpb00402.isChecked() ? "2" : fpb00477.isChecked() ? "77" : "0");
        sB.put("fpb005", fpb00501.isChecked() ? "1" : fpb00588.isChecked() ? "88" : "0");
        sB.put("fpb00588x", fpb00588x.getText().toString());
        sB.put("fpb006", fpb00677.isChecked() ? "77" : fpb00601.getText().toString());
        sB.put("fpb00701", fpb00701.getText().toString());
        sB.put("fpb00702", fpb00702.getText().toString());
        sB.put("fpb00801", fpb00801.getText().toString());
        sB.put("fpb00802", fpb00802.getText().toString());
        sB.put("fpb009", fpb00901.isChecked() ? "1" : fpb00902.isChecked() ? "2" : "0");
        sB.put("fpb010", fpb01001.isChecked() ? "1" : fpb01002.isChecked() ? "2" : fpb01003.isChecked() ? "3" : fpb01004.isChecked() ? "4" : fpb01088.isChecked() ? "88" : "0");
        sB.put("fpb01088x", fpb01088x.getText().toString());
        sB.put("fpb011", fpb01101.isChecked() ? "1" : fpb01102.isChecked() ? "2" : fpb01177.isChecked() ? "77" : "0");
        sB.put("fpb012", fpb012.getText().toString());
        sB.put("fpb013", fpb013.getText().toString());
        sB.put("fpb014", fpb01401.isChecked() ? "1" : fpb01402.isChecked() ? "2" : fpb01477.isChecked() ? "77" : "0");
        sB.put("fpb015", fpb01502.isChecked() ? "02" : fpb01501.getText().toString());
        sB.put("fpb016", fpb01601.isChecked() ? "1" : fpb01602.isChecked() ? "2" : "0");
        sB.put("fpb017", fpb017.getText().toString());
        sB.put("fpb018", fpb018.getText().toString());
        sB.put("fpb019", fpb019.getText().toString());

        AppMain.fc.setsB(String.valueOf(sB));

        Toast.makeText(this, "validation succecful", Toast.LENGTH_SHORT).show();

    }

    public boolean validateForm() {

        if (fpb001m1.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpb001), Toast.LENGTH_SHORT).show();
            fpb001m1.setError("This data is Required!");
            Log.i(TAG, "fpb001m1: This data is Required!");
            return false;
        } else {
            fpb001m1.setError(null);
            if (!fpb001m1.getText().toString().contains(".")) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpb001), Toast.LENGTH_SHORT).show();
                fpb001m1.setError("Invalid: Decimal value is Required!");
                Log.i(TAG, "fpb001m1: Invalid Decimal value is Required!");
                return false;
            } else {
                fpb001m1.setError(null);
                if (Double.parseDouble(fpb001m1.getText().toString()) < 1) {
                    Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpb001), Toast.LENGTH_SHORT).show();
                    fpb001m1.setError("Invalid: Greater then 0");
                    Log.i(TAG, "fpb001m1: Invalid Greater then 0");
                    return false;
                } else {
                    fpb001m1.setError(null);
                    if (Double.parseDouble(fpb001m1.getText().toString()) < 40 || Double.parseDouble(fpb001m1.getText().toString()) > 100) {
                        Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpb001), Toast.LENGTH_SHORT).show();
                        fpb001m1.setError("Invalid: Range 40.0-100.0");
                        Log.i(TAG, "fpb001m1: Invalid Range 40.0-100.0");
                        return false;
                    } else {
                        fpb001m1.setError(null);
                    }
                }
            }
        }


        if (fpb002m1.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpb002), Toast.LENGTH_SHORT).show();
            fpb002m1.setError("This data is Required!");
            Log.i(TAG, "fpb002m1: This data is Required!");
            return false;
        } else {
            fpb002m1.setError(null);
            if (!fpb002m1.getText().toString().contains(".")) {
                Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpb002), Toast.LENGTH_SHORT).show();
                fpb002m1.setError("Invalid: Decimal value is Required!");
                Log.i(TAG, "fpb002m1: Invalid Decimal value is Required!");
                return false;
            } else {
                fpb002m1.setError(null);
                if (Double.parseDouble(fpb002m1.getText().toString()) < 1) {
                    Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpb002), Toast.LENGTH_SHORT).show();
                    fpb002m1.setError("Invalid: Greater then 0");
                    Log.i(TAG, "fpb002m1: Invalid Greater then 0");
                    return false;
                } else {
                    fpb002m1.setError(null);
                    if (Double.parseDouble(fpb002m1.getText().toString()) < 1 || Double.parseDouble(fpb002m1.getText().toString()) > 20) {
                        Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpb002), Toast.LENGTH_SHORT).show();
                        fpb002m1.setError("Invalid: Range 1.0-20.0");
                        Log.i(TAG, "fpb002m1: Invalid Range 1.0-20.0");
                        return false;
                    } else {
                        fpb002m1.setError(null);
                    }
                }
            }
        }


        if (fpb001m2.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpb001), Toast.LENGTH_SHORT).show();
            fpb001m2.setError("This data is Required!");
            Log.i(TAG, "fpb001m1: This data is Required!");
            return false;
        } else {
            fpb001m2.setError(null);
            if (!fpb001m2.getText().toString().contains(".")) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpb001), Toast.LENGTH_SHORT).show();
                fpb001m2.setError("Invalid: Decimal value is Required!");
                Log.i(TAG, "fpb001m2: Invalid Decimal value is Required!");
                return false;
            } else {
                fpb001m2.setError(null);
                if (Double.parseDouble(fpb001m2.getText().toString()) < 1) {
                    Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpb001), Toast.LENGTH_SHORT).show();
                    fpb001m2.setError("Invalid: Greater then 0");
                    Log.i(TAG, "fpb001m1: Invalid Greater then 0");
                    return false;
                } else {
                    fpb001m2.setError(null);
                    if (Double.parseDouble(fpb001m2.getText().toString()) < 40 || Double.parseDouble(fpb001m2.getText().toString()) > 100) {
                        Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpb001), Toast.LENGTH_SHORT).show();
                        fpb001m2.setError("Invalid: Range 40.0-100.0");
                        Log.i(TAG, "fpb001m1: Invalid Range 40.0-100.0");
                        return false;
                    } else {
                        fpb001m2.setError(null);
                    }
                }
            }
        }


        if (fpb002m2.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpb002), Toast.LENGTH_SHORT).show();
            fpb002m2.setError("This data is Required!");
            Log.i(TAG, "fpb002m2: This data is Required!");
            return false;
        } else {
            fpb002m2.setError(null);
            if (!fpb002m2.getText().toString().contains(".")) {
                Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpb002), Toast.LENGTH_SHORT).show();
                fpb002m2.setError("Invalid: Decimal value is Required!");
                Log.i(TAG, "fpb002m2: Invalid Decimal value is Required!");
                return false;
            } else {
                fpb002m2.setError(null);
                if (Double.parseDouble(fpb002m2.getText().toString()) < 1) {
                    Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpb002), Toast.LENGTH_SHORT).show();
                    fpb002m2.setError("Invalid: Greater then 0");
                    Log.i(TAG, "fpb002m1: Invalid Greater then 0");
                    return false;
                } else {
                    fpb002m2.setError(null);
                    if (Double.parseDouble(fpb002m2.getText().toString()) < 1 || Double.parseDouble(fpb002m2.getText().toString()) > 20) {
                        Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpb002), Toast.LENGTH_SHORT).show();
                        fpb002m2.setError("Invalid: Range 1.0-20.0");
                        Log.i(TAG, "fpb002m1: Invalid Range 1.0-20.0");
                        return false;
                    } else {
                        fpb002m2.setError(null);
                    }
                }
            }
        }


        if (fpb001m3.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpb001), Toast.LENGTH_SHORT).show();
            fpb001m3.setError("This data is Required!");
            Log.i(TAG, "fpb001m3: This data is Required!");
            return false;
        } else {
            fpb001m3.setError(null);
            if (!fpb001m3.getText().toString().contains(".")) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpb001), Toast.LENGTH_SHORT).show();
                fpb001m3.setError("Invalid: Decimal value is Required!");
                Log.i(TAG, "fpb001m3: Invalid Decimal value is Required!");
                return false;
            } else {
                fpb001m3.setError(null);
                if (Double.parseDouble(fpb001m3.getText().toString()) < 1) {
                    Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpb001), Toast.LENGTH_SHORT).show();
                    fpb001m3.setError("Invalid: Greater then 0");
                    Log.i(TAG, "fpb001m3: Invalid Greater then 0");
                    return false;
                } else {
                    fpb001m3.setError(null);
                    if (Double.parseDouble(fpb001m3.getText().toString()) != 0
                            && (Double.parseDouble(fpb001m3.getText().toString()) < 40)
                            || Double.parseDouble(fpb001m3.getText().toString()) > 100) {
                        Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpb001), Toast.LENGTH_SHORT).show();
                        fpb001m3.setError("Invalid: Range 40.0-100.0");
                        Log.i(TAG, "fpb001m3: Invalid Range 40.0-100.0");
                        return false;
                    } else {
                        fpb001m3.setError(null);
                    }
                }
            }
        }

        if (fpb002m3.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpb002), Toast.LENGTH_SHORT).show();
            fpb002m3.setError("This data is Required!");
            Log.i(TAG, "fpb002m3: This data is Required!");
            return false;
        } else {
            fpb002m3.setError(null);
            if (!fpb002m3.getText().toString().contains(".")) {
                Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpb002), Toast.LENGTH_SHORT).show();
                fpb002m3.setError("Invalid: Decimal value is Required!");
                Log.i(TAG, "fpb002m3: Invalid Decimal value is Required!");
                return false;
            } else {
                fpb002m3.setError(null);
                if (Double.parseDouble(fpb002m3.getText().toString()) < 1) {
                    Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpb002), Toast.LENGTH_SHORT).show();
                    fpb002m3.setError("Invalid: Greater then 0");
                    Log.i(TAG, "fpb002m3: Invalid Greater then 0");
                    return false;
                } else {
                    fpb002m3.setError(null);
            if (Double.parseDouble(fpb002m3.getText().toString()) < 0 || Double.parseDouble(fpb002m3.getText().toString()) > 20) {
                Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpb002), Toast.LENGTH_SHORT).show();
                fpb002m3.setError("Invalid: Range 1.0-20.0");
                Log.i(TAG, "fpb002m1: Invalid Range 1.0-20.0");
                        return false;
                    } else {
                fpb002m3.setError(null);
                    }
                }
            }
        }

        if (fpb004.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fpb004), Toast.LENGTH_SHORT).show();
            fpb00477.setError("This Data is required");
            Log.i(TAG, "not selected: fpb004");
            return false;
        } else {
            fpb00477.setError(null);
        }

        if (fpb00401.isChecked()) {
            if (fpb005.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "" + getString(R.string.fpb005), Toast.LENGTH_SHORT).show();
                fpb00588.setError("This Data is required");
                Log.i(TAG, "not selected: fpb005");
                return false;
            } else {
                fpb00588.setError(null);
            }

            if (fpb00588.isChecked() && fpb00588x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpb005) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                fpb00588x.setError("This data is Required!");    // Set Error on last radio button
                Log.d(TAG, "fpd00588: This data is Required!");
                return false;
            } else {
                fpb00588x.setError(null);
            }

            if (!fpb00677.isChecked()) {
                if (fpb00601.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(Empty)" + getString(R.string.fpb00601) + " - " + getString(R.string.na), Toast.LENGTH_SHORT).show();
                    fpb00601.setError("This data is Required!");

                    Log.i(TAG, "fpb00601: This Data is Required!");
                    return false;
                } else {
                    fpb00601.setError(null);
                }

                if ((Integer.parseInt(fpb00601.getText().toString().isEmpty() ? "0" : fpb00601.getText().toString()) < 1) || (Integer.parseInt(fpb00702.getText().toString()) > 40)) {
                    Toast.makeText(this, "ERROR: " + getString(R.string.fpb00601), Toast.LENGTH_LONG).show();
                    fpb00601.setError("Range is 1-40 ");
                    Log.i(TAG, "fpb00601: Range is 1-40 ");
                    return false;
                } else {
                    fpb00601.setError(null);
                }
            }

            if (fpb00701.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.day), Toast.LENGTH_SHORT).show();
                fpb00701.setError("This data is required");
                Log.d(TAG, "empty: fpb00701");
                return false;
            } else {
                fpb00701.setError(null);
            }

            if ((Integer.parseInt(fpb00701.getText().toString()) < 0) || (Integer.parseInt(fpb00701.getText().toString()) > 40)) {
                Toast.makeText(this, "ERROR: " + getString(fpb007) + getString(R.string.day), Toast.LENGTH_LONG).show();
                fpb00701.setError("Range is 0-40 days");
                Log.i(TAG, "fpb00701: Range is 0-40 days");
                return false;
            } else {
                fpb00701.setError(null);
            }

            if (fpb00702.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpb00701), Toast.LENGTH_SHORT).show();
                fpb00702.setError("This data is required");
                Log.d(TAG, "empty: fpb00702");
                return false;
            } else {
                fpb00702.setError(null);
            }

            if ((Integer.parseInt(fpb00702.getText().toString()) < 0) || (Integer.parseInt(fpb00702.getText().toString()) > 40)) {
                Toast.makeText(this, "ERROR: " + getString(fpb007) + getString(R.string.fpb00701), Toast.LENGTH_LONG).show();
                fpb00702.setError("Range is 0-40 ");
                Log.i(TAG, "fph005: Range is 0-40 ");
                return false;
            } else {
                fpb00702.setError(null);
            }

            if (fpb00801.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpb00801), Toast.LENGTH_SHORT).show();
                fpb00801.setError("This data is required");
                Log.d(TAG, "empty: fpb00801");
                return false;
            } else {
                fpb00801.setError(null);
            }

            if ((Integer.parseInt(fpb00801.getText().toString()) < 0) || (Integer.parseInt(fpb00801.getText().toString()) > 30)) {
                Toast.makeText(this, "ERROR: " + getString(R.string.fpb008) + getString(R.string.day), Toast.LENGTH_LONG).show();
                fpb00801.setError("Range is 0-30 ");
                Log.i(TAG, "fpd00601: Range is 0-30 ");
                return false;
            } else {
                fpb00801.setError(null);
            }

            if (fpb00802.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpb00802), Toast.LENGTH_SHORT).show();
                fpb00802.setError("This data is required");
                Log.d(TAG, "empty: fpb00802");
                return false;
            } else {
                fpb00802.setError(null);
            }

            if ((Integer.parseInt(fpb00802.getText().toString()) < 0) || (Integer.parseInt(fpb00802.getText().toString()) > 40)) {
                Toast.makeText(this, "ERROR: " + getString(R.string.fpb008), Toast.LENGTH_LONG).show();
                fpb00802.setError("Range is 0-40 ");
                Log.i(TAG, "fpb00802: Range is 0-40 ");
                return false;
            } else {
                fpb00802.setError(null);
            }

            if (fpb009.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "" + getString(R.string.fpb009), Toast.LENGTH_SHORT).show();
                fpb00902.setError("This Data is required");
                Log.i(TAG, "not selected: fpb009");
                return false;
            } else {
                fpb00902.setError(null);
            }

            if (fpb00901.isChecked()) {

                if (!(fpb01001.isChecked() ||
                        fpb01002.isChecked() ||
                        fpb01003.isChecked() ||
                        fpb01004.isChecked() ||
                        fpb01088.isChecked())) {
                    Toast.makeText(this, "" + getString(R.string.fpb010), Toast.LENGTH_SHORT).show();
                    fpb01088.setError("This Data is required");
                    Log.d(TAG, "not selected: fpb010 ");
                    return false;
                } else {
                    fpb01088.setError(null);
                }

                if (fpb01088.isChecked() && fpb01088x.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpb010) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                    fpb01088x.setError("This data is Required!");
                    Log.d(TAG, "fpd01088x: This data is Required!");
                    return false;
                } else {
                    fpb01088x.setError(null);
                }

            }
        }
        if (fpb011.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fpb011), Toast.LENGTH_SHORT).show();
            fpb01177.setError("This Data is required");
            Log.i(TAG, "not selected: fpb011");
            return false;
        } else {
            fpb01177.setError(null);
        }

        if (fpb01101.isChecked()) {

            if (fpb012.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpb012), Toast.LENGTH_SHORT).show();
                fpb012.setError("This data is required");
                Log.d(TAG, "empty: fpe001a  ");
                return false;
            } else {
                fpb012.setError(null);
            }


            if ((Integer.parseInt(fpb012.getText().toString().isEmpty() ? "0" : fpb012.getText().toString()) < 1000) || (Integer.parseInt(fpb012.getText().toString()) > 15000)) {
                Toast.makeText(this, "ERROR: " + getString(R.string.fpb012) + getString(R.string.fpb012), Toast.LENGTH_LONG).show();
                fpb012.setError("Range is 1000 - 15000 rupees ");
                Log.i(TAG, "fpb012: Range is 1000 - 15000 rupees");
                return false;
            } else {
                fpb012.setError(null);
            }
        } else if (fpb01102.isChecked()) {
            if (fpb013.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpb013), Toast.LENGTH_SHORT).show();
                fpb013.setError("This data is required");
                Log.d(TAG, "empty: fpb013");
                return false;
            } else {
                fpb013.setError(null);
            }

            if ((Integer.parseInt(fpb013.getText().toString().isEmpty() ? "0" : fpb013.getText().toString()) < 1) || (Integer.parseInt(fpb013.getText().toString()) > 24)) {
                Toast.makeText(this, "ERROR: " + getString(R.string.fpb013) + getString(R.string.month), Toast.LENGTH_LONG).show();
                fpb013.setError("Range is 1-24 months");
                Log.i(TAG, "fpb013: Range is 1-24 months");
                return false;
            } else {
                fpb013.setError(null);
            }
        } else {

            if (fpb014.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "" + getString(R.string.fpb014), Toast.LENGTH_SHORT).show();
                fpb01477.setError("This Data is required");
                Log.i(TAG, "not selected: fpb014");
                return false;
            } else {
                fpb01477.setError(null);
            }
        }
        if (!fpb01401.isChecked()) {
            if (!fpb01502.isChecked()) {
                if (fpb01501.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(Empty)" + getString(R.string.fpb01501) + " - " + getString(R.string.na), Toast.LENGTH_SHORT).show();
                    fpb01501.setError("This data is Required!");

                    Log.i(TAG, "fpb01501: This Data is Required!");
                    return false;
                } else {
                    fpb01501.setError(null);
                }
            }
        }
        if (fpb016.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fpb016), Toast.LENGTH_SHORT).show();
            fpb01602.setError("This Data is required");
            Log.i(TAG, "not selected: fpb016");
            return false;
        } else {
            fpb01602.setError(null);
        }

        if (fpb017.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.fpb017), Toast.LENGTH_SHORT).show();
            fpb017.setError("This data is Required!");

            Log.i(TAG, "fpb017: This Data is Required!");
            return false;
        } else {
            fpb017.setError(null);
        }

        if (fpb018.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.fpb018), Toast.LENGTH_SHORT).show();
            fpb018.setError("This data is Required!");

            Log.i(TAG, "fpb018: This Data is Required!");
            return false;
        } else {
            fpb018.setError(null);
        }

        if (!(fpb018.getText().toString().length() == 15)) {
            Toast.makeText(this, "ERROR: " + getString(R.string.fpb018), Toast.LENGTH_LONG).show();
            fpb018.setError("cannot be less then 15 digit ");
            Log.i(TAG, "cannot be less then 15 digit ");
            return false;
        } else {
            fpb018.setError(null);
        }

        if (fpb019.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.fpb019), Toast.LENGTH_SHORT).show();
            fpb019.setError("This data is Required!");

            Log.i(TAG, "fpb019: This Data is Required!");
            return false;
        } else {
            fpb019.setError(null);
        }



        return true;
    }


}
