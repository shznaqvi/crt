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
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.cbtfollowup.R;

import static android.content.ContentValues.TAG;

public class EndingActivity extends Activity {

    @BindView(R.id.activity_ending)
    ScrollView activityEnding;
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
        setContentView(R.layout.activity_ending);


        ButterKnife.bind(this);


        Boolean check = getIntent().getExtras().getBoolean("complete");

        if (check) {
            status1.setEnabled(true);
            status2.setEnabled(false);

        } else {
            status1.setEnabled(false);
            status2.setEnabled(true);
        }

    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        Toast.makeText(this, "Processing Closing Section", Toast.LENGTH_SHORT).show();
        if (validateForm()) {
            try {
                saveDrafts();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (updateDb()) {
                finish();
                Toast.makeText(this, "Closing Form!", Toast.LENGTH_SHORT).show();
                Intent endSec = new Intent(this, MainActivity.class);
                //AppMain.mnb1 = "TEST";
                startActivity(endSec);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
            //}
        }
    }


    private boolean updateDb() {

        return true;
    }

    private void saveDrafts() throws JSONException {
        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

        JSONObject js = new JSONObject();

        js.put("status", status1.isChecked() ? "1" : status2.isChecked() ? "2" : "0");
    }

    private boolean validateForm() {
        Toast.makeText(this, "Validating Closing Section", Toast.LENGTH_SHORT).show();

        if (status.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.status), Toast.LENGTH_SHORT).show();
            status2.setError("This data is Required!");
            Log.i(TAG, "mnd9: This data is Required!");
            return false;
        } else {
            status2.setError(null);
        }
        return true;
    }
}
