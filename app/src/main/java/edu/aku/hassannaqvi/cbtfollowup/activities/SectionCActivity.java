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
    @BindView(R.id.fpc00403)
    RadioButton fpc00403;
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
    @BindView(R.id.fpc00602)
    CheckBox fpc00602;
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
    @BindView(R.id.fpc00903)
    RadioButton fpc00903;
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
    @BindView(R.id.fpc01103)
    RadioButton fpc01103;
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
    @BindView(R.id.fpc01403)
    RadioButton fpc01403;
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

        fpc00602.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
                    fpc00602.setChecked(false);
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
        sC.put("fpc004", fpc00401.isChecked() ? "1" : fpc00402.isChecked() ? "2" : fpc00403.isChecked() ? "3" : "0");
        sC.put("fpc005", fpc00501.isChecked() ? "1" : fpc00588.isChecked() ? "88" : "0");
        sC.put("fpc00588x", fpc00588x.getText().toString());
        sC.put("fpc006", fpc00602.isChecked() ? "02" : fpc00601.getText().toString());
        sC.put("fpc00701", fpc00701.getText().toString());
        sC.put("fpc00702", fpc00702.getText().toString());
        sC.put("fpc00801", fpc00801.getText().toString());
        sC.put("fpc00802", fpc00802.getText().toString());
        sC.put("fpc009", fpc00901.isChecked() ? "1" : fpc00902.isChecked() ? "2" : fpc00903.isChecked() ? "3" : "0");
        sC.put("fpc010", fpc01001.isChecked() ? "1" : fpc01002.isChecked() ? "2" : fpc01003.isChecked() ? "3" : fpc01004.isChecked() ? "4" : fpc01088.isChecked() ? "88" : "0");
        sC.put("fpc01088x", fpc01088x.getText().toString());
        sC.put("fpc011", fpc01101.isChecked() ? "1" : fpc01102.isChecked() ? "2" : fpc01103.isChecked() ? "3" : "0");
        sC.put("fpc012", fpc012.getText().toString());
        sC.put("fpc013", fpc013.getText().toString());
        sC.put("fpc014", fpc01401.isChecked() ? "1" : fpc01402.isChecked() ? "2" : fpc01403.isChecked() ? "3" : "0");
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


        return true;
    }


}
