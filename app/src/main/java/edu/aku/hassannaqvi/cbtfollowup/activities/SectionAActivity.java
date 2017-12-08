package edu.aku.hassannaqvi.cbtfollowup.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.cbtfollowup.R;
import edu.aku.hassannaqvi.cbtfollowup.contracts.FollowUpsDoneContract;
import edu.aku.hassannaqvi.cbtfollowup.contracts.FormsContract;
import edu.aku.hassannaqvi.cbtfollowup.core.AppMain;
import edu.aku.hassannaqvi.cbtfollowup.core.DatabaseHelper;
import io.blackbox_vision.datetimepickeredittext.view.DatePickerInputEditText;

public class SectionAActivity extends AppCompatActivity {

    private static final String TAG = SectionAActivity.class.getSimpleName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    @BindView(R.id.activity_section_a)
    ScrollView activitySectionA;

    @BindView(R.id.fpaHH)
    EditText fpaHH;
    @BindView(R.id.fpaResp)
    EditText fpaResp;
    @BindView(R.id.fpaAdd)
    EditText fpaAdd;
    @BindView(R.id.fpaDob)
    DatePickerInputEditText fpaDob;
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
    @BindView(R.id.fpa00401)
    Spinner fpa00401;
    // @BindView(R.id.fpa003)
    TextView fpa003;
    @BindView(R.id.fpa00501)
    EditText fpa00501;
    @BindView(R.id.fpa00502)
    EditText fpa00502;

    @BindView(R.id.foundFollowup)
    TextView foundFollowup;

    //    @BindView(R.id.fpa00301)
//    EditText fpa00301;
    @BindView(R.id.fpa00302)
    EditText fpa00302;
    /* @BindView(R.id.fpa00401)
     EditText fpa00401;*/
    @BindView(R.id.fldGrpbtn)
    LinearLayout fldGrpbtn;

    Calendar now = Calendar.getInstance();
    int year = now.get(Calendar.YEAR);
    int month = now.get(Calendar.MONTH);
    int day = now.get(Calendar.DATE);

    @BindView(R.id.membersExists)
    LinearLayout membersExists;

    Map<String, String> getAllfuprndMap;
    List<String> fuprnd;

    DatabaseHelper db;

    Boolean flag = false;
    String minDate24Months;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_a);
        ButterKnife.bind(this);

        try {
            String s1 = "2016-10-28";
            Date d = (new SimpleDateFormat("yyyy-MM-dd")).parse(s1);
            minDate24Months = (new SimpleDateFormat("dd/MM/yyyy")).format(d);

        } catch (Exception e) {
            e.printStackTrace();
        }


        Calendar c = Calendar.getInstance();
        c.set(2016, Calendar.OCTOBER, 28);



        String maxDate6Months = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() - ((AppMain.MILLISECONDS_IN_6_MONTHS) + (AppMain.MILLISECONDS_IN_DAY)));
        //String minDate24Months = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() - ((AppMain.MILLISECONDS_IN_24_MONTHS) + (AppMain.MILLISECONDS_IN_DAY)));

        fpaDob.setManager(getSupportFragmentManager());
        fpaDob.setMaxDate(maxDate6Months);
        fpaDob.setMinDate(minDate24Months);


        db = new DatabaseHelper(this);

        fpa002.setEnabled(false);
        //fpa00401.setEnabled(false);


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
            AppMain.followUpdoneList = db.getFollowUpdoneByChildID(fpa00302.getText().toString().toUpperCase());

            if (AppMain.followUpdoneList.size() != 0) {

                membersExists.setVisibility(View.VISIBLE);

                foundFollowup.setVisibility(View.GONE);

//                    fpa002.setText(AppMain.followUpdoneList.get(0).getCHILDNAME().toUpperCase());

                fuprnd = new ArrayList<>();

                fuprnd.add("....");
                for (FollowUpsDoneContract aNGO : AppMain.followUpdoneList) {
                    //              getAllfuprndMap.put(aNGO, aNGO.getSourceId());
                    fuprnd.add(aNGO.getFOLLOWUPRND());
                    fpa002.setText(aNGO.getCHILDNAME());
                    Collections.sort(fuprnd);
                }


                fpa00401.setAdapter(new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, fuprnd));

                flag = true;

                Toast.makeText(this, "Child Found", Toast.LENGTH_LONG).show();

            } else {

                foundFollowup.setText("No Child Found");

                foundFollowup.setVisibility(View.VISIBLE);

                Toast.makeText(this, "No Child Found", Toast.LENGTH_LONG).show();
            }
        } else {
            fpa00302.setError("This data is Required!");
        }
    }

   /* public Boolean getDays(String date) {
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
    }*/


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

        sA.put("fpa001", fpa00101.isChecked() ? "1" : fpa00102.isChecked() ? "2" : fpa00103.isChecked() ? "3"
                : fpa00104.isChecked() ? "4" : fpa00105.isChecked() ? "5" : "0");
        sA.put("fpa002", fpa002.getText().toString());
        sA.put("fpaHH", fpaHH.getText().toString());
        sA.put("fpaResp", fpaResp.getText().toString());
        sA.put("fpaAdd", fpaAdd.getText().toString());
        sA.put("fpaDob", fpaDob.getText().toString());

        sA.put("fpa00401", fpa00401.getSelectedItem().toString());

//        sA.put("fpa00301", fpa00301.getText().toString());
        sA.put("fpa00302", fpa00302.getText().toString());
        sA.put("fpa00501", fpa00501.getText().toString());
        sA.put("fpa00502", fpa00502.getText().toString());

        AppMain.fc.setsA(String.valueOf(sA));

        AppMain.arm = fpa001.indexOfChild(findViewById(fpa001.getCheckedRadioButtonId())) + 1;

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

            if (fpa002.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpa002), Toast.LENGTH_SHORT).show();
                fpa002.setError("This data is required");
                Log.d(TAG, "empty: fpa002  ");
                return false;
            } else {
                fpa002.setError(null);
            }

            if (fpaHH.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpaHH), Toast.LENGTH_SHORT).show();
                fpaHH.setError("This data is required");
                Log.d(TAG, "empty: fpaHH  ");
                return false;
            } else {
                fpaHH.setError(null);
            }

            if (fpaResp.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpaResp), Toast.LENGTH_SHORT).show();
                fpaResp.setError("This data is required");
                Log.d(TAG, "empty: fpaResp");
                return false;
            } else {
                fpaResp.setError(null);
            }

            if (fpaAdd.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpaAdd), Toast.LENGTH_SHORT).show();
                fpaAdd.setError("This data is required");
                Log.d(TAG, "empty: fpaAdd");
                return false;
            } else {
                fpaAdd.setError(null);
            }

            if (fpaDob.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.fpaDob), Toast.LENGTH_SHORT).show();
                fpaDob.setError("This data is required");
                Log.d(TAG, "empty: Dob");
                return false;
            } else {
                fpaDob.setError(null);
            }

            if (fpa00401.getSelectedItemPosition() == 0) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.fpa004), Toast.LENGTH_SHORT).show();
                ((TextView) fpa00401.getSelectedView()).setText("This Data is Required");
                ((TextView) fpa00401.getSelectedView()).setTextColor(Color.RED);
                fpa00401.requestFocus();
                Log.i(TAG, "fpa00401: This Data is Required!");
                return false;
            } else {
                ((TextView) fpa00401.getSelectedView()).setError(null);
            }

            if (fpa00501.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.month), Toast.LENGTH_SHORT).show();
                fpa00501.setError("This data is Required!");
                Log.i(TAG, "fpa00501: This data is Required!");
                return false;
            } else {
                fpa00501.setError(null);

                if ((Integer.parseInt(fpa00501.getText().toString()) < 6) || (Integer.parseInt(fpa00501.getText().toString()) > 24)) {
                    Toast.makeText(this, "ERROR(Empty) " + getString(R.string.fpa005) + getString(R.string.month), Toast.LENGTH_SHORT).show();
                    fpa00501.setError("Range is 6-24 months");
                    Log.i(TAG, "fpb00501: Range is 6-24 months");
                    return false;
                } else {
                    fpa00501.setError(null);
                }

                if (fpa00502.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(Empty)" + getString(R.string.day), Toast.LENGTH_SHORT).show();
                    fpa00502.setError("This data is required");
                    Log.d(TAG, "empty: fpa00502");
                    return false;
                } else {
                    fpa00502.setError(null);
                }

                if ((Integer.parseInt(fpa00502.getText().toString()) < 0) || (Integer.parseInt(fpa00502.getText().toString()) > 29)) {
                    Toast.makeText(this, "ERROR(Empty)" + getString(R.string.fpa005) + getString(R.string.day), Toast.LENGTH_LONG).show();
                    fpa00502.setError("Range is 0 - 29 days");
                    Log.i(TAG, "fpb00502: Range is 0 - 29 days");
                    return false;
                } else {
                    fpa00502.setError(null);
                }
            }

            if (fpa001.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "" + getString(R.string.fpa001), Toast.LENGTH_SHORT).show();
                fpa00105.setError("This Data is required");
                Log.d(TAG, "not selected: fpa001 ");
                return false;
            } else {
                fpa00105.setError(null);
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

           /* if (fpa00401.getText().toString().isEmpty()) {
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
            }*/
        }

        return true;
    }


}