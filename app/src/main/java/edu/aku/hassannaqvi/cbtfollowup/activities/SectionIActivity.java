package edu.aku.hassannaqvi.cbtfollowup.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.cbtfollowup.R;

import static android.content.ContentValues.TAG;

public class SectionIActivity extends Activity {

    @BindView(R.id.activity_section_i)
    ScrollView activitySectionI;
    @BindView(R.id.status)
    RadioGroup status;
    @BindView(R.id.status1)
    RadioButton status1;
    @BindView(R.id.status2)
    RadioButton status2;
    @BindView(R.id.fldGrpbtn)
    LinearLayout fldGrpbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_i);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        Toast.makeText(this, "complete section", Toast.LENGTH_SHORT).show();
        Intent secA = new Intent(this, SectionAActivity.class);
        secA.putExtra("complete", false);
        startActivity(secA);
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();


    }

    private boolean formValidation() {
        Toast.makeText(this, "Validating Closing Section", Toast.LENGTH_SHORT).show();

        if (status.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(not selected): " + getResources().getResourceTypeName(R.string.status), Toast.LENGTH_LONG).show();
            status2.setError("This data is Required!");
            Log.i(TAG, "mnd9: This data is Required!");
            return false;
        } else {
            status2.setError(null);
        }
        return true;
    }
}


