package edu.aku.hassannaqvi.cbtfollowup.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;
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

public class SectionBActivity extends Activity {

    @BindView(R.id.activity_section_b)
    ScrollView activitySectionB;
    @BindView(R.id.fpb001)
    RadioGroup fpb001;
    @BindView(R.id.fpb00101)
    RadioButton fpb00101;
    @BindView(R.id.fpb00102)
    RadioButton fpb00102;
    @BindView(R.id.fpb00103)
    RadioButton fpb00103;
    @BindView(R.id.fpb00104)
    RadioButton fpb00104;
    @BindView(R.id.fpb00105)
    RadioButton fpb00105;
    @BindView(R.id.fpb00106)
    RadioButton fpb00106;
    @BindView(R.id.fpb00201)
    EditText fpb00201;
    @BindView(R.id.fpb00202)
    EditText fpb00202;
    @BindView(R.id.fldGrpfpb002)
    LinearLayout fldGrpfpb002;
    public static boolean isChildDeath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_b);
        ButterKnife.bind(this);

        fpb001.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (fpb00101.isChecked()) {
                    fldGrpfpb002.setVisibility(View.VISIBLE);
                } else {
                    fldGrpfpb002.setVisibility(View.GONE);
                    fpb00201.setText(null);
                    fpb00202.setText(null);
                }
            }
        });

    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        Toast.makeText(this, "complete section", Toast.LENGTH_SHORT).show();
/*        Intent endSec = new Intent(this, EndingActivity.class);
        endSec.putExtra("complete", false);
        startActivity(endSec);*/

        AppMain.endActivity(this, this);

    }


    @OnClick(R.id.btnNext)
    void onBtnNextClick() {
       // Toast.makeText(this, "Processing thi section", Toast.LENGTH_SHORT).show();
        if (validateForm()){
            try {
                saveDrafts();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (updateDb()) {
               // Toast.makeText(this, "starting next section", Toast.LENGTH_SHORT).show();
                if (fpb00105.isChecked()) {
                    isChildDeath = true;
                    finish();
                    Intent secC = new Intent(this, SectionGActivity.class);
                    startActivity(secC);
                }else if(fpb00101.isChecked()){
                    finish();
                    Intent secC = new Intent(this, SectionCActivity.class);
                    startActivity(secC);
                }else if(fpb00106.isChecked()){
                    finish();
                    Intent secC = new Intent(this, SectionIActivity.class);
                    startActivity(secC);
                }else{
                    finish();
                    Intent secC = new Intent(this, EndingActivity.class);
                    secC.putExtra("complete", false);
                    startActivity(secC);
                }


            } else {
                Toast.makeText(this, "Failed to update Database", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean updateDb() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateB();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }


    }

    private void saveDrafts() throws JSONException {
        //Toast.makeText(this, "saving Drafts", Toast.LENGTH_SHORT).show();

        JSONObject sB = new JSONObject();

        sB.put("fpb001", fpb00101.isChecked() ? "1" : fpb00102.isChecked() ? "2" : fpb00103.isChecked() ? "3"
                : fpb00104.isChecked() ? "4" : fpb00105.isChecked() ? "5" : fpb00106.isChecked() ? "6" : "0");
        sB.put("fpb00201", fpb00201.getText().toString());
        sB.put("fpb00202", fpb00202.getText().toString());

        AppMain.fc.setsB(String.valueOf(sB));

       // Toast.makeText(this, "validation succecful", Toast.LENGTH_SHORT).show();

    }

    public boolean validateForm() {

        // =================== Q1  ====================
        if (fpb001.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.fpb001), Toast.LENGTH_SHORT).show();
            fpb00105.setError("This Data is required");
            Log.d(TAG, "not selected: fpb001 ");
            return false;
        } else {
            fpb00105.setError(null);
        }

        if (fpb00101.isChecked()) {

            // =================== Q2  ====================
            if (fpb00201.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.month), Toast.LENGTH_SHORT).show();
                fpb00201.setError("This data is required");
                Log.d(TAG, "empty: fpa002  ");
                return false;
            } else {
                fpb00201.setError(null);
            }

            if ((Integer.parseInt(fpb00201.getText().toString()) < 7) || (Integer.parseInt(fpb00201.getText().toString()) > 24)) {
                Toast.makeText(this, "ERROR(Empty) " + getString(R.string.fpb002) + getString(R.string.month), Toast.LENGTH_SHORT).show();
                fpb00201.setError("Range is 7-24 months");
                Log.i(TAG, "fpb00201: Range is 7-24 months");
                return false;
            } else {
                fpb00201.setError(null);
            }

            if (fpb00202.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.day), Toast.LENGTH_SHORT).show();
                fpb00202.setError("This data is required");
                Log.d(TAG, "empty: fpa002  ");
                return false;
            } else {
                fpb00202.setError(null);
            }

            if ((Integer.parseInt(fpb00202.getText().toString()) < 0) || (Integer.parseInt(fpb00202.getText().toString()) > 29)) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.fpb002) + getString(R.string.day), Toast.LENGTH_LONG).show();
                fpb00202.setError("Range is 0 - 29 days");
                Log.i(TAG, "fpb00202: Range is 0 - 29 days");
                return false;
            } else {
                fpb00202.setError(null);
            }

            /*if(Integer.valueOf(fpb00201.getText().toString()) == 6 && Integer.valueOf(fpb00202.getText().toString()) > 25)
            {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.fpb002) + getString(R.string.day), Toast.LENGTH_LONG).show();
                fpb00202.setError("Minimum Range is 6 Months and 25 days only");
                Log.i(TAG, "fpb00202: Minimum Range is 6 Months and 25 days only");
                return false;
            }else{
                fpb00202.setError(null);
            }*/
        }


        return true;
    }


    @Override
    public void onBackPressed() {


        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
