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
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.cbtfollowup.R;

import static android.content.ContentValues.TAG;


public class SectionEActivity extends Activity {

    @BindView(R.id.activity_section_e)
    RelativeLayout activitySectionE;
    @BindView(R.id.scrollView01)
    ScrollView scrollView01;
    @BindView(R.id.app_header)
    TextView appHeader;
    @BindView(R.id.fpe001)
    RadioGroup fpe001;
    @BindView(R.id.fpe00101)
    RadioButton fpe00101;
    @BindView(R.id.fpe00102)
    RadioButton fpe00102;
    @BindView(R.id.fpe001a)
    EditText fpe001a;
    @BindView(R.id.fpe001b)
    EditText fpe001b;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.fpe00201)
    CheckBox fpe00201;
    @BindView(R.id.fpe00201x)
    EditText fpe00201x;
    @BindView(R.id.fpe00202)
    CheckBox fpe00202;
    @BindView(R.id.fpe00202x)
    EditText fpe00202x;
    @BindView(R.id.fpe00203)
    CheckBox fpe00203;
    @BindView(R.id.fpe00203x)
    EditText fpe00203x;
    @BindView(R.id.fpe00204)
    CheckBox fpe00204;
    @BindView(R.id.fpe00204x)
    EditText fpe00204x;
    @BindView(R.id.fpe00205)
    CheckBox fpe00205;
    @BindView(R.id.fpe00205x)
    EditText fpe00205x;
    @BindView(R.id.fpe00288)
    CheckBox fpe00288;
    @BindView(R.id.fpe00288x)
    EditText fpe00288x;
    @BindView(R.id.fpeGrp001a)
    LinearLayout fpeGrp001a;
    @BindView(R.id.fpeGrp001b)
    LinearLayout fpeGrp001b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_e);
        ButterKnife.bind(this);

        // =================== Q2a Amount ====================

        fpe00201.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpe00201x.setVisibility(View.VISIBLE);
                } else {
                    fpe00201x.setVisibility(View.GONE);
                    fpe00201x.setText(null);
                }
            }
        });

        // =================== Q2b Amount ====================

        fpe00202.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpe00202x.setVisibility(View.VISIBLE);
                } else {
                    fpe00202x.setVisibility(View.GONE);
                    fpe00202x.setText(null);
                }
            }
        });

        // =================== Q2c Amount ====================

        fpe00203.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpe00203x.setVisibility(View.VISIBLE);
                } else {
                    fpe00203x.setVisibility(View.GONE);
                    fpe00203x.setText(null);
                }
            }
        });

        // =================== Q2d Amount ====================

        fpe00204.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpe00204x.setVisibility(View.VISIBLE);
                } else {
                    fpe00204x.setVisibility(View.GONE);
                    fpe00204x.setText(null);
                }
            }
        });

        // =================== Q2e Amount ====================

        fpe00205.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpe00205x.setVisibility(View.VISIBLE);
                } else {
                    fpe00205x.setVisibility(View.GONE);
                    fpe00205x.setText(null);
                }
            }
        });

        // =================== Q2 Others ====================

        fpe00288.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpe00288x.setVisibility(View.VISIBLE);
                } else {
                    fpe00288x.setVisibility(View.GONE);
                    fpe00288x.setText(null);
                }
            }
        });


        // ====================== Q 1.1Skip Pattern =========================

        fpe00101.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpeGrp001a.setVisibility(View.VISIBLE);
                    fpeGrp001b.setVisibility(View.GONE);
                    fpe001b.setText(null);

                } else {
                    fpeGrp001a.setVisibility(View.GONE);
                    fpeGrp001b.setVisibility(View.VISIBLE);

                }
            }
        });

        // ====================== Q 1.2 Skip Pattern =========================

        fpe00102.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fpeGrp001a.setVisibility(View.GONE);
                    fpeGrp001b.setVisibility(View.VISIBLE);
                    fpe001a.setText(null);

                } else {
                    fpeGrp001a.setVisibility(View.VISIBLE);
                    fpeGrp001b.setVisibility(View.GONE);

                }
            }
        });

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
                Intent secF = new Intent(this, SectionFActivity.class);
                startActivity(secF);

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

        js.put("fpe001", fpe00101.isChecked() ? "1" : fpe00102.isChecked() ? "2" : "0");
        js.put("fpe001a", fpe001a.getText().toString());
        js.put("fpe001b", fpe001b.getText().toString());
        js.put("fpe00201", fpe00201.isChecked() ? "1" : "0");
        js.put("fpe00201x", fpe00201x.getText().toString());
        js.put("fpe00202", fpe00202.isChecked() ? "2" : "0");
        js.put("fpe00202x", fpe00202x.getText().toString());
        js.put("fpe00203", fpe00203.isChecked() ? "3" : "0");
        js.put("fpe00203x", fpe00203x.getText().toString());
        js.put("fpe00204", fpe00204.isChecked() ? "4" : "0");
        js.put("fpe00204x", fpe00204x.getText().toString());
        js.put("fpe00205", fpe00205.isChecked() ? "5" : "0");
        js.put("fpe00205x", fpe00205x.getText().toString());
        js.put("fpe00288", fpe00288.isChecked() ? "88" : "0");
        js.put("fpe00288x", fpe00288x.getText().toString());


        Toast.makeText(this, "validation succecful", Toast.LENGTH_SHORT).show();

    }

    public boolean validateForm() {

        // =================== Q1  ====================
        if (fpe001.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fpe001), Toast.LENGTH_SHORT).show();
            fpe00102.setError("This Data is required");
            Log.d(TAG, "not selected: fpe001 ");
            return false;
        } else {
            fpe00102.setError(null);
        }

        if (fpe00101.isChecked()) {
            // =================== Q1.1 ====================
            if (fpe001a.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpe001a), Toast.LENGTH_SHORT).show();
                fpe001a.setError("This data is required");
                Log.d(TAG, "empty: fpe001a  ");
                return false;
            } else {
                fpe001a.setError(null);
            }

            if ((Integer.parseInt(fpe001a.getText().toString().isEmpty() ? "0" : fpe001a.getText().toString()) < 100) || (Integer.parseInt(fpe001a.getText().toString()) > 5000)) {
                Toast.makeText(this, "ERROR: " + getString(R.string.fpe001a) + getString(R.string.fpe001a01), Toast.LENGTH_LONG).show();
                fpe001a.setError("Range is 100-5000 rupees ");
                Log.i(TAG, "fpd00501: Range is 100-5000 rupees");
                return false;
            } else {
                fpe001a.setError(null);
            }

        } else {
            if (fpe001b.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpe001b), Toast.LENGTH_SHORT).show();
                fpe001b.setError("This data is required");
                Log.d(TAG, "empty: fpe001b  ");
                return false;
            } else {
                fpe001b.setError(null);
            }

            if ((Integer.parseInt(fpe001b.getText().toString().isEmpty() ? "0" : fpe001b.getText().toString()) < 1) || (Integer.parseInt(fpe001b.getText().toString()) > 24)) {
                Toast.makeText(this, "ERROR: " + getString(R.string.fpe001b) + getString(R.string.month), Toast.LENGTH_LONG).show();
                fpe001b.setError("Range is 1-24 months");
                Log.i(TAG, "fpe001b: Range is 1-24 months");
                return false;
            } else {
                fpe001b.setError(null);
            }
        }
        // ====================== Q 2 ===================
        if (!(fpe00201.isChecked() || fpe00202.isChecked() || fpe00203.isChecked() || fpe00204.isChecked()
                || fpe00205.isChecked() || fpe00288.isChecked())) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.fpe002), Toast.LENGTH_LONG).show();
            fpe00288.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "fpe002: This data is Required!");
            return false;
        } else {
            fpe00288.setError(null);
        }

        // ====================== Q 2a Amount ===================
        if (fpe00201.isChecked() && ((Integer.parseInt(fpe00201x.getText().toString().isEmpty() ? "0" : fpe00201x.getText().toString()) < 100) || (Integer.parseInt(fpe00201x.getText().toString().isEmpty() ? "0" : fpe00201x.getText().toString()) > 5000))) {
            Toast.makeText(this, "ERROR: " + getString(R.string.fpe002), Toast.LENGTH_LONG).show();
            fpe00201x.setError("Range is 100-5000");
            Log.i(TAG, "fpe00201: Range is 100-5000");
            return false;
        } else {
            fpe00201x.setError(null);
        }
        // ====================== Q 2b Amount ===================
        if (fpe00202.isChecked() && ((Integer.parseInt(fpe00202x.getText().toString().isEmpty() ? "0" : fpe00202x.getText().toString()) < 100) || (Integer.parseInt(fpe00202x.getText().toString().isEmpty() ? "0" : fpe00202x.getText().toString()) > 5000))) {
            Toast.makeText(this, "ERROR: " + getString(R.string.fpe002), Toast.LENGTH_LONG).show();
            fpe00202x.setError("Range is 100-5000");
            Log.i(TAG, "fpe00202: Range is 100-5000");
            return false;
        } else {
            fpe00202x.setError(null);
        }

        // ====================== Q 2c Amount ===================
        if (fpe00203.isChecked() && ((Integer.parseInt(fpe00203x.getText().toString().isEmpty() ? "0" : fpe00203x.getText().toString()) < 100) || (Integer.parseInt(fpe00203x.getText().toString().isEmpty() ? "0" : fpe00203x.getText().toString()) > 5000))) {
            Toast.makeText(this, "ERROR: " + getString(R.string.fpe002), Toast.LENGTH_LONG).show();
            fpe00203x.setError("Range is 100-5000");
            Log.i(TAG, "fpe00203: Range is 100-5000");
            return false;
        } else {
            fpe00203x.setError(null);
        }

        // ====================== Q 2d Amount ===================
        if (fpe00204.isChecked() && ((Integer.parseInt(fpe00204x.getText().toString().isEmpty() ? "0" : fpe00204x.getText().toString()) < 100) || (Integer.parseInt(fpe00204x.getText().toString().isEmpty() ? "0" : fpe00204x.getText().toString()) > 5000))) {
            Toast.makeText(this, "ERROR: " + getString(R.string.fpe002), Toast.LENGTH_LONG).show();
            fpe00204x.setError("Range is 100-5000");
            Log.i(TAG, "fpe00204: Range is 100-5000");
            return false;
        } else {
            fpe00204x.setError(null);
        }

        // ====================== Q 2e Amount ===================
        if (fpe00205.isChecked() && ((Integer.parseInt(fpe00205x.getText().toString().isEmpty() ? "0" : fpe00205x.getText().toString()) < 100) || (Integer.parseInt(fpe00205x.getText().toString().isEmpty() ? "0" : fpe00205x.getText().toString()) > 5000))) {
            Toast.makeText(this, "ERROR: " + getString(R.string.fpe002), Toast.LENGTH_LONG).show();
            fpe00205x.setError("Range is 100-5000");
            Log.i(TAG, "fpe00205: Range is 100-5000");
            return false;
        } else {
            fpe00205x.setError(null);
        }

        // ====================== Q 2 Others ===================
        if (fpe00288.isChecked() && ((Integer.parseInt(fpe00288x.getText().toString().isEmpty() ? "0" : fpe00288x.getText().toString()) < 100) || (Integer.parseInt(fpe00288x.getText().toString().isEmpty() ? "0" : fpe00288x.getText().toString()) > 5000))) {
            Toast.makeText(this, "ERROR: " + getString(R.string.fpe002), Toast.LENGTH_LONG).show();
            fpe00288x.setError("Range is 100-5000");
            Log.i(TAG, "fpe00288: Range is 100-5000");
            return false;
        } else {
            fpe00288x.setError(null);
        }



        return true;
    }


}
