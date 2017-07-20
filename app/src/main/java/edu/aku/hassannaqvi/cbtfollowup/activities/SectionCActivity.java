package edu.aku.hassannaqvi.cbtfollowup.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
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
    @BindView(R.id.fpc001m2)
    EditText fpc001m2;
    @BindView(R.id.fpc001m3)
    EditText fpc001m3;
    @BindView(R.id.fpc002m1)
    EditText fpc002m1;
    @BindView(R.id.fpc002m2)
    EditText fpc002m2;
    @BindView(R.id.fpc002m3)
    EditText fpc002m3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_c);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        Toast.makeText(this, "complete section", Toast.LENGTH_SHORT).show();
        Intent endSec = new Intent(this, EndingActivity.class);
        endSec.putExtra("complete", false);
        startActivity(endSec);
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

                if (AppMain.arm == 1) {
                    Intent secD = new Intent(this, SectionGActivity.class);
                    startActivity(secD);
                } else if (AppMain.arm == 2 || AppMain.arm == 3) {
                    Intent secD = new Intent(this, SectionEActivity.class);
                    startActivity(secD);
                } else {
                    Intent secD = new Intent(this, SectionDActivity.class);
                    startActivity(secD);
                }


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
        sC.put("fpc002m1 ", fpc002m1.getText().toString());
        sC.put("fpc002m2 ", fpc002m2.getText().toString());
        sC.put("fpc002m3 ", fpc002m3.getText().toString());

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
            if (!fpc001m3.getText().toString().contains(".")) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpc001), Toast.LENGTH_SHORT).show();
                fpc001m3.setError("Invalid: Decimal value is Required!");
                Log.i(TAG, "fpc001m3: Invalid Decimal value is Required!");
                return false;
            } else {
                fpc001m3.setError(null);
                if (Double.parseDouble(fpc001m3.getText().toString()) < 1) {
                    Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc001), Toast.LENGTH_SHORT).show();
                    fpc001m3.setError("Invalid: Greater then 0");
                    Log.i(TAG, "fpc001m3: Invalid Greater then 0");
                    return false;
                } else {
                    fpc001m3.setError(null);
                    if (Double.parseDouble(fpc001m3.getText().toString()) < 40 || Double.parseDouble(fpc001m3.getText().toString()) > 100) {
                        Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc001), Toast.LENGTH_SHORT).show();
                        fpc001m3.setError("Invalid: Range 40.0-100.0");
                        Log.i(TAG, "fpc001m3: Invalid Range 40.0-100.0");
                        return false;
                    } else {
                        fpc001m3.setError(null);
                    }
                }
            }
        }


        if (fpc002m3.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpc002), Toast.LENGTH_SHORT).show();
            fpc002m3.setError("This data is Required!");
            Log.i(TAG, "fpc002m3: This data is Required!");
            return false;
        } else {
            fpc002m3.setError(null);
            if (!fpc002m3.getText().toString().contains(".")) {
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
                    fpc002m3.setError(null);
                    if (Double.parseDouble(fpc002m3.getText().toString()) < 1 || Double.parseDouble(fpc002m3.getText().toString()) > 20) {
                        Toast.makeText(this, "ERROR(invalid): " + getString(R.string.fpc002), Toast.LENGTH_SHORT).show();
                        fpc002m3.setError("Invalid: Range 1.0-20.0");
                        Log.i(TAG, "fpc002m1: Invalid Range 1.0-20.0");
                        return false;
                    } else {
                        fpc002m3.setError(null);
                    }
                }
            }
        }


        return true;
    }


}
