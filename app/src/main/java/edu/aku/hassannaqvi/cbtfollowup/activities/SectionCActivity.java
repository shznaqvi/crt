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
import static edu.aku.hassannaqvi.cbtfollowup.R.string.fpc007;

public class SectionCActivity extends Activity {

    @BindView(R.id.activity_section_c)
    ScrollView activitySectionC;
    @BindView(R.id.fpc001m1)
    EditText fpc001m1;
    @BindView(R.id.fpc002m1)
    EditText fpc002m1;
    @BindView(R.id.fpc001m2)
    EditText fpc001m2;
    @BindView(R.id.fpc002m2)
    EditText fpc002m2;
    @BindView(R.id.fpc001m3)
    EditText fpc001m3;
    @BindView(R.id.fpc002m3)
    EditText fpc002m3;
    @BindView(R.id.fpc004)
    RadioGroup fpc004;
    @BindView(R.id.fpc00401)
    RadioButton fpc00401;
    @BindView(R.id.fpc00402)
    RadioButton fpc00402;
    @BindView(R.id.fpc00477)
    RadioButton fpc00477;
    @BindView(R.id.fldGrp004)
    LinearLayout fldGrp004;
    @BindView(R.id.fpc005)
    RadioGroup fpc005;
    @BindView(R.id.fpc00501)
    RadioButton fpc00501;
    @BindView(R.id.fpc00588)
    RadioButton fpc00588;
    @BindView(R.id.fpc00588x)
    EditText fpc00588x;
    @BindView(R.id.fpc00601)
    EditText fpc00601;
    @BindView(R.id.fpc00677)
    CheckBox fpc00677;
    @BindView(R.id.fpc00701)
    EditText fpc00701;
    @BindView(R.id.fpc00702)
    EditText fpc00702;
    @BindView(R.id.fpc00801)
    EditText fpc00801;
    @BindView(R.id.fpc00802)
    EditText fpc00802;
    @BindView(R.id.fpc009)
    RadioGroup fpc009;
    @BindView(R.id.fpc00901)
    RadioButton fpc00901;
    @BindView(R.id.fpc00902)
    RadioButton fpc00902;
    @BindView(R.id.fpc00977)
    RadioButton fpc00977;
    @BindView(R.id.fldGrp009)
    LinearLayout fldGrp009;
    @BindView(R.id.fpc01001)
    CheckBox fpc01001;
    @BindView(R.id.fpc01002)
    CheckBox fpc01002;
    @BindView(R.id.fpc01003)
    CheckBox fpc01003;
    @BindView(R.id.fpc01004)
    CheckBox fpc01004;
    @BindView(R.id.fpc01088)
    CheckBox fpc01088;
    @BindView(R.id.fpc01088x)
    EditText fpc01088x;
    @BindView(R.id.fpc011)
    RadioGroup fpc011;
    @BindView(R.id.fpc01101)
    RadioButton fpc01101;
    @BindView(R.id.fpc01102)
    RadioButton fpc01102;
    @BindView(R.id.fpc01177)
    RadioButton fpc01177;
    @BindView(R.id.fldGrp011)
    LinearLayout fldGrp011;
    @BindView(R.id.fldGrp012)
    LinearLayout fldGrp012;
    @BindView(R.id.fpc012)
    EditText fpc012;
    @BindView(R.id.fldGrp013)
    LinearLayout fldGrp013;
    @BindView(R.id.fpc013)
    EditText fpc013;
    @BindView(R.id.fpc014)
    RadioGroup fpc014;
    @BindView(R.id.fpc01401)
    RadioButton fpc01401;
    @BindView(R.id.fpc01402)
    RadioButton fpc01402;
    @BindView(R.id.fpc01477)
    RadioButton fpc01477;
    @BindView(R.id.fldGrp014)
    LinearLayout fldGrp014;
    @BindView(R.id.fpc01501)
    EditText fpc01501;
    @BindView(R.id.fpc01502)
    CheckBox fpc01502;
    @BindView(R.id.fpc016)
    RadioGroup fpc016;
    @BindView(R.id.fpc01601)
    RadioButton fpc01601;
    @BindView(R.id.fpc01602)
    RadioButton fpc01602;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_c);
        ButterKnife.bind(this);

        fpc00677.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    fpc00601.setVisibility(View.GONE);
                    fpc00601.setText(null);
                } else {
                    fpc00601.setVisibility(View.VISIBLE);
                }
            }
        });


        fpc004.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (fpc00401.isChecked()) {
                    fldGrp004.setVisibility(View.VISIBLE);
                } else {
                    fldGrp004.setVisibility(View.GONE);
                    fpc005.clearCheck();
                    fpc00588x.setText(null);
                    fpc00601.setText(null);
                    fpc00677.setChecked(false);
                    fpc00702.setText(null);
                    fpc00701.setText(null);
                    fpc00802.setText(null);
                    fpc00801.setText(null);
                    fpc009.clearCheck();
                    fpc01001.setChecked(false);
                    fpc01002.setChecked(false);
                    fpc01003.setChecked(false);
                    fpc01004.setChecked(false);
                    fpc01088.setChecked(false);
                    fpc01088x.setText(null);

                }
            }
        });

        fpc009.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (fpc00901.isChecked()) {
                    fldGrp009.setVisibility(View.VISIBLE);
                } else {
                    fldGrp009.setVisibility(View.GONE);
                    //fpd008.clearCheck();
                    fpc01001.setChecked(false);
                    fpc01002.setChecked(false);
                    fpc01003.setChecked(false);
                    fpc01004.setChecked(false);
                    fpc01088.setChecked(false);

                    fpc01088x.setText(null);
                }
            }
        });

        fpc011.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (fpc01101.isChecked()) {
                    fldGrp011.setVisibility(View.VISIBLE);
                } else {
                    fldGrp011.setVisibility(View.GONE);
                    fpc012.setText(null);
                    fpc013.setText(null);
                }
            }
        });

        fpc01101.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fldGrp012.setVisibility(View.VISIBLE);
                    fldGrp013.setVisibility(View.GONE);
                    fpc013.setText(null);

                } else {
                    fldGrp012.setVisibility(View.GONE);
                    fldGrp013.setVisibility(View.VISIBLE);

                }
            }
        });

        // ====================== Q 1.2 Skip Pattern =========================

        fpc01102.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fldGrp012.setVisibility(View.GONE);
                    fldGrp013.setVisibility(View.VISIBLE);
                    fpc012.setText(null);

                } else {
                    fldGrp012.setVisibility(View.VISIBLE);
                    fldGrp013.setVisibility(View.GONE);

                }
            }
        });

        fpc014.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (fpc01401.isChecked()) {
                    fldGrp014.setVisibility(View.GONE);
                    fpc01501.setText(null);
                    fpc01502.setChecked(false);
                } else {
                    fldGrp014.setVisibility(View.VISIBLE);

                }
            }
        });


    }


    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        Toast.makeText(this, "complete section", Toast.LENGTH_SHORT).show();
        /*Intent endSec = new Intent(this, EndingActivity.class);
        endSec.putExtra("complete", false);
        startActivity(endSec);*/
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

        int updcount = db.updateC();

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

        JSONObject sC = new JSONObject();

        sC.put("fpc001m1", fpc001m1.getText().toString());
        sC.put("fpc001m2", fpc001m2.getText().toString());
        sC.put("fpc001m3", fpc001m3.getText().toString());
        sC.put("fpc002m1", fpc002m1.getText().toString());
        sC.put("fpc002m2", fpc002m2.getText().toString());
        sC.put("fpc002m3", fpc002m3.getText().toString());
        sC.put("fpc004", fpc00401.isChecked() ? "1" : fpc00402.isChecked() ? "2" : fpc00477.isChecked() ? "77" : "0");
        sC.put("fpc005", fpc00501.isChecked() ? "1" : fpc00588.isChecked() ? "88" : "0");
        sC.put("fpc00588x", fpc00588x.getText().toString());
        sC.put("fpc006", fpc00677.isChecked() ? "77" : fpc00601.getText().toString());
        sC.put("fpc00701", fpc00701.getText().toString());
        sC.put("fpc00702", fpc00702.getText().toString());
        sC.put("fpc00801", fpc00801.getText().toString());
        sC.put("fpc00802", fpc00802.getText().toString());
        sC.put("fpc009", fpc00901.isChecked() ? "1" : fpc00902.isChecked() ? "2" : fpc00977.isChecked() ? "77" : "0");
        sC.put("fpc010", fpc01001.isChecked() ? "1" : fpc01002.isChecked() ? "2" : fpc01003.isChecked() ? "3" : fpc01004.isChecked() ? "4" : fpc01088.isChecked() ? "88" : "0");
        sC.put("fpc01088x", fpc01088x.getText().toString());
        sC.put("fpc011", fpc01101.isChecked() ? "1" : fpc01102.isChecked() ? "2" : fpc01177.isChecked() ? "77" : "0");
        sC.put("fpc012", fpc012.getText().toString());
        sC.put("fpc013", fpc013.getText().toString());
        sC.put("fpc014", fpc01401.isChecked() ? "1" : fpc01402.isChecked() ? "2" : fpc01477.isChecked() ? "77" : "0");
        sC.put("fpc015", fpc01502.isChecked() ? "02" : fpc01501.getText().toString());
        sC.put("fpc016", fpc01601.isChecked() ? "1" : fpc01602.isChecked() ? "2" : "0");

        AppMain.fc.setsC(String.valueOf(sC));

        Toast.makeText(this, "validation succecful", Toast.LENGTH_SHORT).show();

    }

    public boolean validateForm() {

        if (fpc001m1.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpc001), Toast.LENGTH_SHORT).show();
            fpc001m1.setError("This data is Required!");
            Log.i(TAG, "fpc001m1: This data is Required!");
            return false;
        } else {
            fpc001m1.setError(null);
            if (!fpc001m1.getText().toString().contains(".")) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpc001), Toast.LENGTH_SHORT).show();
                fpc001m1.setError("Invalid: Decimal value is Required!");
                Log.i(TAG, "fpc001m1: Invalid Decimal value is Required!");
                return false;
            } else {
                fpc001m1.setError(null);
                if (Double.parseDouble(fpc001m1.getText().toString()) < 1) {
                    Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc001), Toast.LENGTH_SHORT).show();
                    fpc001m1.setError("Invalid: Greater then 0");
                    Log.i(TAG, "fpc001m1: Invalid Greater then 0");
                    return false;
                } else {
                    fpc001m1.setError(null);
                    if (Double.parseDouble(fpc001m1.getText().toString()) < 40 || Double.parseDouble(fpc001m1.getText().toString()) > 100) {
                        Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc001), Toast.LENGTH_SHORT).show();
                        fpc001m1.setError("Invalid: Range 40.0-100.0");
                        Log.i(TAG, "fpc001m1: Invalid Range 40.0-100.0");
                        return false;
                    } else {
                        fpc001m1.setError(null);
                    }
                }
            }
        }


        if (fpc002m1.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpc002), Toast.LENGTH_SHORT).show();
            fpc002m1.setError("This data is Required!");
            Log.i(TAG, "fpc002m1: This data is Required!");
            return false;
        } else {
            fpc002m1.setError(null);
            if (!fpc002m1.getText().toString().contains(".")) {
                Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc002), Toast.LENGTH_SHORT).show();
                fpc002m1.setError("Invalid: Decimal value is Required!");
                Log.i(TAG, "fpc002m1: Invalid Decimal value is Required!");
                return false;
            } else {
                fpc002m1.setError(null);
                if (Double.parseDouble(fpc002m1.getText().toString()) < 1) {
                    Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc002), Toast.LENGTH_SHORT).show();
                    fpc002m1.setError("Invalid: Greater then 0");
                    Log.i(TAG, "fpc002m1: Invalid Greater then 0");
                    return false;
                } else {
                    fpc002m1.setError(null);
                    if (Double.parseDouble(fpc002m1.getText().toString()) < 1 || Double.parseDouble(fpc002m1.getText().toString()) > 20) {
                        Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc002), Toast.LENGTH_SHORT).show();
                        fpc002m1.setError("Invalid: Range 1.0-20.0");
                        Log.i(TAG, "fpc002m1: Invalid Range 1.0-20.0");
                        return false;
                    } else {
                        fpc002m1.setError(null);
                    }
                }
            }
        }


        if (fpc001m2.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpc001), Toast.LENGTH_SHORT).show();
            fpc001m2.setError("This data is Required!");
            Log.i(TAG, "fpc001m1: This data is Required!");
            return false;
        } else {
            fpc001m2.setError(null);
            if (!fpc001m2.getText().toString().contains(".")) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpc001), Toast.LENGTH_SHORT).show();
                fpc001m2.setError("Invalid: Decimal value is Required!");
                Log.i(TAG, "fpc001m2: Invalid Decimal value is Required!");
                return false;
            } else {
                fpc001m2.setError(null);
                if (Double.parseDouble(fpc001m2.getText().toString()) < 1) {
                    Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc001), Toast.LENGTH_SHORT).show();
                    fpc001m2.setError("Invalid: Greater then 0");
                    Log.i(TAG, "fpc001m1: Invalid Greater then 0");
                    return false;
                } else {
                    fpc001m2.setError(null);
                    if (Double.parseDouble(fpc001m2.getText().toString()) < 40 || Double.parseDouble(fpc001m2.getText().toString()) > 100) {
                        Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc001), Toast.LENGTH_SHORT).show();
                        fpc001m2.setError("Invalid: Range 40.0-100.0");
                        Log.i(TAG, "fpc001m1: Invalid Range 40.0-100.0");
                        return false;
                    } else {
                        fpc001m2.setError(null);
                    }
                }
            }
        }


        if (fpc002m2.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpc002), Toast.LENGTH_SHORT).show();
            fpc002m2.setError("This data is Required!");
            Log.i(TAG, "fpc002m2: This data is Required!");
            return false;
        } else {
            fpc002m2.setError(null);
            if (!fpc002m2.getText().toString().contains(".")) {
                Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc002), Toast.LENGTH_SHORT).show();
                fpc002m2.setError("Invalid: Decimal value is Required!");
                Log.i(TAG, "fpc002m2: Invalid Decimal value is Required!");
                return false;
            } else {
                fpc002m2.setError(null);
                if (Double.parseDouble(fpc002m2.getText().toString()) < 1) {
                    Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc002), Toast.LENGTH_SHORT).show();
                    fpc002m2.setError("Invalid: Greater then 0");
                    Log.i(TAG, "fpc002m1: Invalid Greater then 0");
                    return false;
                } else {
                    fpc002m2.setError(null);
                    if (Double.parseDouble(fpc002m2.getText().toString()) < 1 || Double.parseDouble(fpc002m2.getText().toString()) > 20) {
                        Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc002), Toast.LENGTH_SHORT).show();
                        fpc002m2.setError("Invalid: Range 1.0-20.0");
                        Log.i(TAG, "fpc002m1: Invalid Range 1.0-20.0");
                        return false;
                    } else {
                        fpc002m2.setError(null);
                    }
                }
            }
        }


        if (fpc001m3.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpc001), Toast.LENGTH_SHORT).show();
            fpc001m3.setError("This data is Required!");
            Log.i(TAG, "fpc001m3: This data is Required!");
            return false;
        } else {
            fpc001m3.setError(null);
            /*if (!fpc001m3.getText().toString().contains(".")) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpc001), Toast.LENGTH_SHORT).show();
                fpc001m3.setError("Invalid: Decimal value is Required!");
                Log.i(TAG, "fpc001m3: Invalid Decimal value is Required!");
                return false;
            } else {
                fpc001m3.setError(null);*/
                /*if (Double.parseDouble(fpc001m3.getText().toString()) < 1) {
                    Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc001), Toast.LENGTH_SHORT).show();
                    fpc001m3.setError("Invalid: Greater then 0");
                    Log.i(TAG, "fpc001m3: Invalid Greater then 0");
                    return false;
                } else {
                    fpc001m3.setError(null);
                */
            if (Double.parseDouble(fpc001m3.getText().toString()) != 0
                    && (Double.parseDouble(fpc001m3.getText().toString()) < 40)
                    || Double.parseDouble(fpc001m3.getText().toString()) > 100) {
                        Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc001), Toast.LENGTH_SHORT).show();
                        fpc001m3.setError("Invalid: Range 40.0-100.0");
                        Log.i(TAG, "fpc001m3: Invalid Range 40.0-100.0");
                        return false;
            } else {
                        fpc001m3.setError(null);
                    }
                }
        //}



        if (fpc002m3.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpc002), Toast.LENGTH_SHORT).show();
            fpc002m3.setError("This data is Required!");
            Log.i(TAG, "fpc002m3: This data is Required!");
            return false;
        } else {
            fpc002m3.setError(null);
            /*if (!fpc002m3.getText().toString().contains(".")) {
                Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc002), Toast.LENGTH_SHORT).show();
                fpc002m3.setError("Invalid: Decimal value is Required!");
                Log.i(TAG, "fpc002m3: Invalid Decimal value is Required!");
                return false;
            } else {
                fpc002m3.setError(null);
                if (Double.parseDouble(fpc002m3.getText().toString()) < 1) {
                    Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc002), Toast.LENGTH_SHORT).show();
                    fpc002m3.setError("Invalid: Greater then 0");
                    Log.i(TAG, "fpc002m3: Invalid Greater then 0");
                    return false;
                } else {
                    fpc002m3.setError(null);*/
            if (Double.parseDouble(fpc002m3.getText().toString()) < 0 || Double.parseDouble(fpc002m3.getText().toString()) > 20) {
                        Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc002), Toast.LENGTH_SHORT).show();
                        fpc002m3.setError("Invalid: Range 1.0-20.0");
                        Log.i(TAG, "fpc002m1: Invalid Range 1.0-20.0");
                        return false;
                    } else {
                        fpc002m3.setError(null);
                    }
                }
        //}
        //}

        if (fpc004.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fpc004), Toast.LENGTH_SHORT).show();
            fpc00477.setError("This Data is required");
            Log.i(TAG, "not selected: fpc004");
            return false;
        } else {
            fpc00477.setError("This Data is required");
        }

        if (fpc005.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fpc005), Toast.LENGTH_SHORT).show();
            fpc00588.setError("This Data is required");
            Log.i(TAG, "not selected: fpc005");
            return false;
        } else {
            fpc00588.setError("This Data is required");
        }

        if (fpc00588.isChecked() && fpc00588x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpc005) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
            fpc00588x.setError("This data is Required!");    // Set Error on last radio button
            Log.d(TAG, "fpd00588: This data is Required!");
            return false;
        } else {
            fpc00588x.setError(null);
        }

        if (!fpc00677.isChecked()) {
            if (fpc00601.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.fpc00601) + " - " + getString(R.string.na), Toast.LENGTH_SHORT).show();
                fpc00601.setError("This data is Required!");

                Log.i(TAG, "fpc00601: This Data is Required!");
                return false;
            } else {
                fpc00601.setError(null);
            }
        }

        if (fpc00701.getText().toString().isEmpty()) {
            Toast.makeText(this, "" + getString(R.string.day), Toast.LENGTH_SHORT).show();
            fpc00701.setError("This data is required");
            Log.d(TAG, "empty: fpc00701");
            return false;
        } else {
            fpc00701.setError(null);
        }

        if ((Integer.parseInt(fpc00701.getText().toString()) < 0) || (Integer.parseInt(fpc00701.getText().toString()) > 30)) {
            Toast.makeText(this, "ERROR: " + getString(fpc007) + getString(R.string.day), Toast.LENGTH_LONG).show();
            fpc00701.setError("Range is 0-30 days");
            Log.i(TAG, "fpc00701: Range is 0-30 days");
            return false;
        } else {
            fpc00701.setError(null);
        }

        if (fpc00702.getText().toString().isEmpty()) {
            Toast.makeText(this, "" + getString(R.string.fpc00701), Toast.LENGTH_SHORT).show();
            fpc00702.setError("This data is required");
            Log.d(TAG, "empty: fpc00702");
            return false;
        } else {
            fpc00702.setError(null);
        }

        if ((Integer.parseInt(fpc00702.getText().toString().isEmpty() ? "0" : fpc00702.getText().toString()) < 1) || (Integer.parseInt(fpc00702.getText().toString()) > 40)) {
            Toast.makeText(this, "ERROR: " + getString(fpc007) + getString(R.string.fpc00701), Toast.LENGTH_LONG).show();
            fpc00702.setError("Range is 1-40 ");
            Log.i(TAG, "fph005: Range is 1-40 ");
            return false;
        } else {
            fpc00702.setError(null);
        }

        if (fpc00801.getText().toString().isEmpty()) {
            Toast.makeText(this, "" + getString(R.string.fpc00801), Toast.LENGTH_SHORT).show();
            fpc00801.setError("This data is required");
            Log.d(TAG, "empty: fpc00801");
            return false;
        } else {
            fpc00801.setError(null);
        }

        if ((Integer.parseInt(fpc00801.getText().toString().isEmpty() ? "0" : fpc00801.getText().toString()) < 0) || (Integer.parseInt(fpc00801.getText().toString()) > 40)) {
            Toast.makeText(this, "ERROR: " + getString(R.string.fpc008), Toast.LENGTH_LONG).show();
            fpc00801.setError("Range is 0-40 ");
            Log.i(TAG, "fpd00601: Range is 0-40 ");
            return false;
        } else {
            fpc00801.setError(null);
        }

        if (fpc00802.getText().toString().isEmpty()) {
            Toast.makeText(this, "" + getString(R.string.fpc00802), Toast.LENGTH_SHORT).show();
            fpc00802.setError("This data is required");
            Log.d(TAG, "empty: fpc00802");
            return false;
        } else {
            fpc00802.setError(null);
        }

        if ((Integer.parseInt(fpc00802.getText().toString().isEmpty() ? "0" : fpc00802.getText().toString()) < 0) || (Integer.parseInt(fpc00802.getText().toString()) > 40)) {
            Toast.makeText(this, "ERROR: " + getString(R.string.fpc008), Toast.LENGTH_LONG).show();
            fpc00802.setError("Range is 0-40 ");
            Log.i(TAG, "fpc00802: Range is 0-40 ");
            return false;
        } else {
            fpc00802.setError(null);
        }

        if (fpc009.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fpc009), Toast.LENGTH_SHORT).show();
            fpc00977.setError("This Data is required");
            Log.i(TAG, "not selected: fpc009");
            return false;
        } else {
            fpc00977.setError("This Data is required");
        }

        if (!(fpc01001.isChecked() ||
                fpc01002.isChecked() ||
                fpc01003.isChecked() ||
                fpc01004.isChecked() ||
                fpc01088.isChecked())) {
            Toast.makeText(this, "" + getString(R.string.fpc010), Toast.LENGTH_SHORT).show();
            fpc01088.setError("This Data is required");
            Log.d(TAG, "not selected: fpc010 ");
            return false;
        } else {
            fpc01088.setError(null);
        }

        if (fpc01088.isChecked() && fpc01088x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpc010) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
            fpc01088x.setError("This data is Required!");
            Log.d(TAG, "fpd01088x: This data is Required!");
            return false;
        } else {
            fpc01088x.setError(null);
        }

        if (fpc011.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fpc011), Toast.LENGTH_SHORT).show();
            fpc01177.setError("This Data is required");
            Log.i(TAG, "not selected: fpc011");
            return false;
        } else {
            fpc01177.setError("This Data is required");
        }

        if (fpc012.getText().toString().isEmpty()) {
            Toast.makeText(this, "" + getString(R.string.fpc012), Toast.LENGTH_SHORT).show();
            fpc012.setError("This data is required");
            Log.d(TAG, "empty: fpe001a  ");
            return false;
        } else {
            fpc012.setError(null);
        }

        if ((Integer.parseInt(fpc012.getText().toString().isEmpty() ? "0" : fpc012.getText().toString()) < 1000) || (Integer.parseInt(fpc012.getText().toString()) > 15000)) {
            Toast.makeText(this, "ERROR: " + getString(R.string.fpc012) + getString(R.string.fpc012), Toast.LENGTH_LONG).show();
            fpc012.setError("Range is 1000 - 15000 rupees ");
            Log.i(TAG, "fpc012: Range is 1000 - 15000 rupees");
            return false;
        } else {
            fpc012.setError(null);
        }

        if (fpc013.getText().toString().isEmpty()) {
            Toast.makeText(this, "" + getString(R.string.fpc013), Toast.LENGTH_SHORT).show();
            fpc013.setError("This data is required");
            Log.d(TAG, "empty: fpc013");
            return false;
        } else {
            fpc013.setError(null);
        }

        if ((Integer.parseInt(fpc013.getText().toString().isEmpty() ? "0" : fpc013.getText().toString()) < 1) || (Integer.parseInt(fpc013.getText().toString()) > 24)) {
            Toast.makeText(this, "ERROR: " + getString(R.string.fpc013) + getString(R.string.month), Toast.LENGTH_LONG).show();
            fpc013.setError("Range is 1-24 months");
            Log.i(TAG, "fpc013: Range is 1-24 months");
            return false;
        } else {
            fpc013.setError(null);
        }

        if (fpc014.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fpc014), Toast.LENGTH_SHORT).show();
            fpc01477.setError("This Data is required");
            Log.i(TAG, "not selected: fpc014");
            return false;
        } else {
            fpc01477.setError("This Data is required");
        }

        if (!fpc01502.isChecked()) {
            if (fpc01501.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.fpc015) + " - " + getString(R.string.fpc01501), Toast.LENGTH_SHORT).show();
                fpc01501.setError("This data is Required!");

                Log.i(TAG, "fpc01501: This Data is Required!");
                return false;
            } else {
                fpc01501.setError(null);
            }
        }

        if (fpc016.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fpc016), Toast.LENGTH_SHORT).show();
            fpc01602.setError("This Data is required");
            Log.i(TAG, "not selected: fpc016");
            return false;
        } else {
            fpc01602.setError("This Data is required");
        }


        return true;
    }


}
