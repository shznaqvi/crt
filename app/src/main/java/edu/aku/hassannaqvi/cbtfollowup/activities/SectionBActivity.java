package edu.aku.hassannaqvi.cbtfollowup.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
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
    @BindView(R.id.fpb00201)
    EditText fpb00201;
    @BindView(R.id.fpb00202)
    EditText fpb00202;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_b);
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
                Intent secC = new Intent(this, SectionCActivity.class);
                startActivity(secC);
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

        sB.put("fpb001", fpb00101.isChecked() ? "1" : fpb00102.isChecked() ? "2" : fpb00103.isChecked() ? "3" : fpb00104.isChecked() ? "4" : fpb00105.isChecked() ? "5" : "0");
        sB.put("fpb00201", fpb00201.getText().toString());
        sB.put("fpb00202", fpb00202.getText().toString());

        AppMain.fc.setsB(String.valueOf(sB));

        Toast.makeText(this, "validation succecful", Toast.LENGTH_SHORT).show();

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

        if ((Integer.parseInt(fpb00202.getText().toString()) < 1) || (Integer.parseInt(fpb00202.getText().toString()) > 30)) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.fpb002) + getString(R.string.day), Toast.LENGTH_LONG).show();
            fpb00202.setError("Range is 1-30 days");
            Log.i(TAG, "fpb00202: Range is 1-30 days");
            return false;
        } else {
            fpb00202.setError(null);
        }


        return true;
    }


}
