package edu.aku.hassannaqvi.cbtfollowup.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.cbtfollowup.R;
import edu.aku.hassannaqvi.cbtfollowup.contracts.FollowUpsContract;
import edu.aku.hassannaqvi.cbtfollowup.core.DatabaseHelper;
import edu.aku.hassannaqvi.cbtfollowup.contracts.FormsContract;
import edu.aku.hassannaqvi.cbtfollowup.core.AppMain;

public class SectionAActivity extends Activity {

    private static final String TAG = SectionAActivity.class.getSimpleName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    @BindView(R.id.activity_section_a)
    ScrollView activitySectionA;
    @BindView(R.id.fpa001)
    RadioGroup fpa001;
    @BindView(R.id.fpa00101)
    RadioButton fpa00101;
    @BindView(R.id.fpa00102)
    RadioButton fpa00102;
    @BindView(R.id.fpa00103)
    RadioButton fpa00103;
    @BindView(R.id.fpa00104)
    RadioButton fpa00104;
    @BindView(R.id.fpa00105)
    RadioButton fpa00105;
    @BindView(R.id.fpa002)
    EditText fpa002;
    @BindView(R.id.fpa003)
    TextView fpa003;

    @BindView(R.id.foundFollowup)
    TextView foundFollowup;

    //    @BindView(R.id.fpa00301)
//    EditText fpa00301;
    @BindView(R.id.fpa00302)
    EditText fpa00302;
    @BindView(R.id.fpa00401)
    EditText fpa00401;
    @BindView(R.id.fldGrpbtn)
    LinearLayout fldGrpbtn;

    @BindView(R.id.membersExists)
    LinearLayout membersExists;

    DatabaseHelper db;

    Boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_a);
        ButterKnife.bind(this);

        db = new DatabaseHelper(this);

        fpa002.setEnabled(false);
        fpa00401.setEnabled(false);


        fpa00302.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                membersExists.setVisibility(View.GONE);

                flag = false;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    /*@OnClick(R.id.btn_End)
    void onBtnEndClick() {
        Toast.makeText(this, "complete section", Toast.LENGTH_SHORT).show();

        Intent endSec = new Intent(this, SectionIActivity.class);
        endSec.putExtra("complete", false);
        startActivity(endSec);
    }*/

    @OnClick(R.id.checkChildID)
    void onCheckChildIDClick() {

        if (!fpa00302.getText().toString().isEmpty()) {
            fpa00302.setError(null);
            AppMain.followUpList = db.getFollowUpByChildID(fpa00302.getText().toString().toUpperCase());

            if (AppMain.followUpList.size() != 0) {

                if (getDays(AppMain.followUpList.get(0).getFOLLOWUPDT())) {

                    membersExists.setVisibility(View.VISIBLE);

                    foundFollowup.setVisibility(View.GONE);

                    fpa002.setText(AppMain.followUpList.get(0).getCHILDNAME().toUpperCase());
                    fpa003.setText(fpa003.getText() + AppMain.followUpList.get(0).getMOTHERNAME().toUpperCase());
                    fpa00401.setText(AppMain.followUpList.get(0).getFOLLOWUPRND());

                    flag = true;

                    Toast.makeText(this, "Child Found", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Child Found Follow Up Date Expired", Toast.LENGTH_LONG).show();
                    foundFollowup.setText("Child Found Follow Up Date Expired");

                    foundFollowup.setVisibility(View.VISIBLE);
                }
            } else {

                foundFollowup.setText("No Child Found");

                foundFollowup.setVisibility(View.VISIBLE);

                Toast.makeText(this, "No Child Found", Toast.LENGTH_LONG).show();
            }
        } else {
            fpa00302.setError("This data is Required!");
        }
    }

    public Boolean getDays(String date) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date date1 = myFormat.parse(date);
            Date date2 = new Date();
            long diff = date2.getTime() - date1.getTime();

            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) <= 7;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }


    @OnClick(R.id.btnNext)
    void onBtnNextClick() {

        Toast.makeText(this, "Processing thi section", Toast.LENGTH_SHORT).show();
        if (validateForm()) {

            if (flag) {
                try {
                    saveDrafts();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if (updateDb()) {
                    Toast.makeText(this, "starting next section", Toast.LENGTH_SHORT).show();

                    finish();
                    Intent secB = new Intent(this, SectionBActivity.class);
                    startActivity(secB);
                } else {
                    Toast.makeText(this, "Failed to update Database", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Click on Check Button", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean updateDb() {

        Long updcount = db.addForm(AppMain.fc);
        AppMain.fc.setID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            AppMain.fc.setUID(
                    (AppMain.fc.getDeviceID() + AppMain.fc.getID()));
            db.updateFormID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void saveDrafts() throws JSONException {
        Toast.makeText(this, "saving Drafts", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);

        AppMain.fc = new FormsContract();

        AppMain.fc.setDevicetagId(sharedPref.getString("tagName", null));
        AppMain.fc.setFormDate(dtToday);
        AppMain.fc.setUser(AppMain.userName);
        AppMain.fc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));

        JSONObject sA = new JSONObject();

        sA.put("fpa001", fpa00101.isChecked() ? "1" : fpa00102.isChecked() ? "2" : fpa00103.isChecked() ? "3" : fpa00104.isChecked() ? "4" : fpa00105.isChecked() ? "5" : "0");
        sA.put("fpa002", fpa002.getText().toString());
//        sA.put("fpa00301", fpa00301.getText().toString());
        sA.put("fpa00302 ", fpa00302.getText().toString());
        sA.put("fpa00401  ", fpa00401.getText().toString());

        AppMain.fc.setsA(String.valueOf(sA));

        setGPS();

        Toast.makeText(this, "validation succecful", Toast.LENGTH_SHORT).show();

    }


    public void setGPS() {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);

//        String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String dt = GPSPref.getString("Time", "0");

            if (lat == "0" && lang == "0") {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            AppMain.fc.setGpsLat(GPSPref.getString("Latitude", "0"));
            AppMain.fc.setGpsLng(GPSPref.getString("Longitude", "0"));
            AppMain.fc.setGpsAcc(GPSPref.getString("Accuracy", "0"));
//            AppMain.fc.setGpsTime(GPSPref.getString(date, "0")); // Timestamp is converted to date above
            AppMain.fc.setGpsTime(date); // Timestamp is converted to date above

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }

    public boolean validateForm() {

        if (fpa00302.getText().toString().isEmpty()) {
            Toast.makeText(this, "" + getString(R.string.fpa00302), Toast.LENGTH_SHORT).show();
            fpa00302.setError("This data is required");
            Log.d(TAG, "empty: fpa00302  ");
            return false;
        } else {
            fpa00302.setError(null);
        }

        if (flag) {

            if (fpa001.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "" + getString(R.string.fpa001), Toast.LENGTH_SHORT).show();
                fpa00105.setError("This Data is required");
                Log.d(TAG, "not selected: fpa001 ");
                return false;
            } else {
                fpa00105.setError(null);
            }

            if (fpa002.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpa002), Toast.LENGTH_SHORT).show();
                fpa002.setError("This data is required");
                Log.d(TAG, "empty: fpa002  ");
                return false;
            } else {
                fpa002.setError(null);
            }

//        if (fpa00301.getText().toString().isEmpty()) {
//            Toast.makeText(this, "" + getString(R.string.fpa00301), Toast.LENGTH_SHORT).show();
//            fpa00301.setError("This data is required");
//            Log.d(TAG, "empty: fpa00301  ");
//            return false;
//        } else {
//            fpa00301.setError(null);
//        }


//        if ((Integer.parseInt(fpa00302.getText().toString()) == 0)) {
//            Toast.makeText(this, "ERROR: " + getString(R.string.fpa003) + getString(R.string.fpa00302), Toast.LENGTH_LONG).show();
//            fpa00302.setError("Id cannnot be zero");
//            Log.i(TAG, "fpa00302: ID cannot not be zero");
//            return false;
//        } else {
//            fpa00302.setError(null);
//        }

            if (fpa00401.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpa00401), Toast.LENGTH_SHORT).show();
                fpa00401.setError("This data is required");
                Log.d(TAG, "empty: fpa00401  ");
                return false;
            } else {
                fpa00401.setError(null);
            }

            if ((Integer.parseInt(fpa00401.getText().toString()) == 0)) {
                Toast.makeText(this, "ERROR: " + getString(R.string.fpa00401), Toast.LENGTH_LONG).show();
                fpa00401.setError("# cannnot be zero");
                Log.i(TAG, "fpa00401: # cannot not be zero");
                return false;
            } else {
                fpa00401.setError(null);
            }
        }

        return true;
    }

}
