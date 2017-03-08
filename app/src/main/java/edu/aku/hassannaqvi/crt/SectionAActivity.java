package edu.aku.hassannaqvi.crt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SectionAActivity extends Activity {

    @BindView(R.id.activity_section_a)
    RelativeLayout activitySectionA;
    @BindView(R.id.scrollView01)
    ScrollView scrollView01;
    @BindView(R.id.app_header)
    TextView appHeader;
    @BindView(R.id.mp02a001)
    EditText mp02a001;
    @BindView(R.id.mp02a002)
    EditText mp02a002;
    @BindView(R.id.mp02a003)
    EditText mp02a003;
    @BindView(R.id.mp02a007)
    EditText mp02a007;
    @BindView(R.id.mp02a008)
    EditText mp02a008;
    @BindView(R.id.mp02a013)
    RadioGroup mp02a013;
    @BindView(R.id.mp02a01301)
    RadioButton mp02a01301;
    @BindView(R.id.mp02a01302)
    RadioButton mp02a01302;

    @BindView(R.id.mp02aLHWs)
    Spinner mp02aLHWs;

    @BindView(R.id.fldGrpmp02a007)
    LinearLayout fldGrpmp02a007;

    @BindView(R.id.btn_Continue)
    Button btn_Continue;
    @BindView(R.id.btn_End)
    Button btn_End;

    @BindView(R.id.mp02_count)
    TextView mp02_count;

    List<String> LHWsName;
    DatabaseHelper db;
    HashMap<String, String> LHWs;
    Boolean flag = false;
    Boolean checked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_a);
        ButterKnife.bind(this);

        mp02a003.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                checked = false;

                if (!checked) {
                    fldGrpmp02a007.setVisibility(View.GONE);
                    btn_Continue.setVisibility(View.GONE);
                    mp02a007.setText(null);
                    mp02a008.setText(null);
                    mp02a013.clearCheck();
                    mp02a003.setError("Please check household number first");

                } else {
                    checked = true;
                    mp02a003.setError(null);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });


        db = new DatabaseHelper(this);

        LHWsName = new ArrayList<>();

        LHWs = new HashMap<>();

        Collection<LHWsContract> collectionLHWs = db.getLHWsByCluster(AppMain.curCluster);

        for (LHWsContract lhws : collectionLHWs) {
            LHWsName.add(lhws.getLhwName());
            LHWs.put(lhws.getLhwName(), lhws.getLhwId());
        }
        mp02aLHWs.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, LHWsName));

        mp02aLHWs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorPrimary));
                Log.d("Selected LHWs", LHWs.get(mp02aLHWs.getSelectedItem().toString()));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @OnClick(R.id.checkParticipants)
    void onCheckParticipantsClick() {

        checked = true;

        mp02_count.setVisibility(View.VISIBLE);

        if (!mp02a003.getText().toString().isEmpty()) {

            mp02a003.setError(null);

            Collection<EligiblesContract> Econtract = db.getEligiblesByHousehold(AppMain.curCluster, LHWs.get(mp02aLHWs.getSelectedItem().toString()), mp02a003.getText().toString());

            mp02_count.setText("Eligible Women found = " + Econtract.size());

            if (Econtract.size() != 0) {

                AppMain.Eparticipant = new ArrayList<>();

                for (EligiblesContract ec : Econtract) {
                    AppMain.Eparticipant.add(new EligibleParticipants(ec.getLUID(), ec.getWomen_name()));
                }

                Toast.makeText(this, "Participant Found", Toast.LENGTH_LONG).show();

                fldGrpmp02a007.setVisibility(View.VISIBLE);
                btn_Continue.setVisibility(View.VISIBLE);

                flag = true;

            } else {

                fldGrpmp02a007.setVisibility(View.GONE);
                btn_Continue.setVisibility(View.GONE);
                mp02a007.setText(null);
                mp02a008.setText(null);
                mp02a013.clearCheck();

                flag = false;

                Toast.makeText(this, "No Participant Found", Toast.LENGTH_LONG).show();
            }
        } else {
            mp02a003.setError("This data is Required!");
        }


    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();

        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

                Toast.makeText(this, "Starting Form Ending Section", Toast.LENGTH_SHORT).show();
                Intent endSec = new Intent(this, EndingActivity.class);
                endSec.putExtra("complete", false);
                startActivity(endSec);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @OnClick(R.id.btn_Continue)
    void onBtnContinueClick() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();

//        Intent secba = new Intent(this, ParticipantListActivity.class);
//        startActivity(secba);

        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Next Section", Toast.LENGTH_SHORT).show();

                finish();
                Intent secba = new Intent(this, SectionBAActivity.class);
                startActivity(secba);

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {
/*        MP02DBHelper db = new MP02DBHelper(this);

        int updcount = db.updateSA();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();*/
        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sa = new JSONObject();


        sa.put("mp02a001", mp02a001.getText().toString());
        sa.put("mp02a002", mp02a002.getText().toString());
        sa.put("mp02a007", mp02a007.getText().toString());
        sa.put("mp02a008", mp02a008.getText().toString());
        sa.put("mp02a13", mp02a01301.isChecked() ? "1" : mp02a01302.isChecked() ? "2" : "0");

        //MPApp.fc.setROW_Sa(String.valueOf(sa));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    public boolean ValidateForm() {

        //======================= Q 1 ===============

        if (mp02a001.getText().toString().isEmpty()) {
            Toast.makeText(this, "" + getString(R.string.mp02a001), Toast.LENGTH_SHORT).show();
            mp02a001.setError("This data is Required!");
            return false;
        } else {
            mp02a001.setError(null);
        }

        //======================= Q 2 ===============

        if (mp02a002.getText().toString().isEmpty()) {
            Toast.makeText(this, "" + getString(R.string.mp02a002), Toast.LENGTH_SHORT).show();
            mp02a002.setError("This data is Required!");
            return false;
        } else {
            mp02a002.setError(null);
        }

        //======================= Q 3 ===============

        if (mp02a003.getText().toString().isEmpty()) {
            Toast.makeText(this, "" + getString(R.string.mp02a003), Toast.LENGTH_SHORT).show();
            mp02a003.setError("This data is Required!");
            return false;
        } else {
            mp02a003.setError(null);
        }

        if (flag) {
            //======================= Q 7 ===============

            if (mp02a007.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.mp02a007), Toast.LENGTH_SHORT).show();
                mp02a007.setError("This data is Required!");
                return false;
            } else {
                mp02a007.setError(null);
            }

            //======================= Q 8 ===============

            if (mp02a008.getText().toString().isEmpty()) {
                Toast.makeText(this, "" + getString(R.string.mp02a008), Toast.LENGTH_SHORT).show();
                mp02a008.setError("This data is Required!");
                return false;
            } else {
                mp02a008.setError(null);
            }


            //======================= Q 13 ===============

            if (mp02a013.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "" + getString(R.string.mp02a013), Toast.LENGTH_SHORT).show();
                mp02a01302.setError("This data is Required!");
                return false;
            } else {
                mp02a01302.setError(null);
            }
        }

        return true;
    }


}
