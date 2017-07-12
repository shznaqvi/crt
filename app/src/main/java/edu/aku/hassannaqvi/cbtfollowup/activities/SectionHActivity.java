package edu.aku.hassannaqvi.cbtfollowup.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;
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
import edu.aku.hassannaqvi.cbtfollowup.core.DatabaseHelper;

import static android.content.ContentValues.TAG;

public class SectionHActivity extends Activity {

    @BindView(R.id.activity_section_h)
    ScrollView activitySectionH;
    @BindView(R.id.fph001)
    RadioGroup fph001;
    @BindView(R.id.fph00101)
    RadioButton fph00101;
    @BindView(R.id.fph00102)
    RadioButton fph00102;
    @BindView(R.id.fph00199)
    RadioButton fph00199;
    @BindView(R.id.fph001a)
    RadioGroup fph001a;
    @BindView(R.id.fph001a01)
    RadioButton fph001a01;
    @BindView(R.id.fph001a02)
    RadioButton fph001a02;
    @BindView(R.id.fph001a99)
    RadioButton fph001a99;
    @BindView(R.id.fph002)
    RadioGroup fph002;
    @BindView(R.id.fph00201)
    RadioButton fph00201;
    @BindView(R.id.fph00202)
    RadioButton fph00202;
    @BindView(R.id.fph00299)
    RadioButton fph00299;
    @BindView(R.id.fph003)
    RadioGroup fph003;
    @BindView(R.id.fph00301)
    RadioButton fph00301;
    @BindView(R.id.fph00302)
    RadioButton fph00302;
    @BindView(R.id.fph00399)
    RadioButton fph00399;
    @BindView(R.id.fph004a)
    RadioGroup fph004a;
    @BindView(R.id.fph004a01)
    RadioButton fph004a01;
    @BindView(R.id.fph004a02)
    RadioButton fph004a02;
    @BindView(R.id.fph004a99)
    RadioButton fph004a99;
    @BindView(R.id.fph004b)
    RadioGroup fph004b;
    @BindView(R.id.fph004b01)
    RadioButton fph004b01;
    @BindView(R.id.fph004b02)
    RadioButton fph004b02;
    @BindView(R.id.fph004b99)
    RadioButton fph004b99;
    @BindView(R.id.fph004bx)
    EditText fph004bx;
    @BindView(R.id.fph004c)
    RadioGroup fph004c;
    @BindView(R.id.fph004c01)
    RadioButton fph004c01;
    @BindView(R.id.fph004c02)
    RadioButton fph004c02;
    @BindView(R.id.fph004c99)
    RadioButton fph004c99;
    @BindView(R.id.fph004cx)
    EditText fph004cx;
    @BindView(R.id.fph004d)
    RadioGroup fph004d;
    @BindView(R.id.fph004d01)
    RadioButton fph004d01;
    @BindView(R.id.fph004d02)
    RadioButton fph004d02;
    @BindView(R.id.fph004d99)
    RadioButton fph004d99;
    @BindView(R.id.fph004e)
    RadioGroup fph004e;
    @BindView(R.id.fph004e01)
    RadioButton fph004e01;
    @BindView(R.id.fph004e02)
    RadioButton fph004e02;
    @BindView(R.id.fph004e99)
    RadioButton fph004e99;
    @BindView(R.id.fph004f)
    RadioGroup fph004f;
    @BindView(R.id.fph004f01)
    RadioButton fph004f01;
    @BindView(R.id.fph004f02)
    RadioButton fph004f02;
    @BindView(R.id.fph004f99)
    RadioButton fph004f99;
    @BindView(R.id.fph004fx)
    EditText fph004fx;
    @BindView(R.id.fph004g)
    RadioGroup fph004g;
    @BindView(R.id.fph004g01)
    RadioButton fph004g01;
    @BindView(R.id.fph004g02)
    RadioButton fph004g02;
    @BindView(R.id.fph004g99)
    RadioButton fph004g99;
    @BindView(R.id.fph004h)
    RadioGroup fph004h;
    @BindView(R.id.fph004h01)
    RadioButton fph004h01;
    @BindView(R.id.fph004h02)
    RadioButton fph004h02;
    @BindView(R.id.fph004h99)
    RadioButton fph004h99;
    @BindView(R.id.fph004i)
    RadioGroup fph004i;
    @BindView(R.id.fph004i01)
    RadioButton fph004i01;
    @BindView(R.id.fph004i02)
    RadioButton fph004i02;
    @BindView(R.id.fph004i99)
    RadioButton fph004i99;
    @BindView(R.id.fph006a)
    RadioGroup fph006a;
    @BindView(R.id.fph006a01)
    RadioButton fph006a01;
    @BindView(R.id.fph006a02)
    RadioButton fph006a02;
    @BindView(R.id.fph006a99)
    RadioButton fph006a99;
    @BindView(R.id.fph006b)
    RadioGroup fph006b;
    @BindView(R.id.fph006b01)
    RadioButton fph006b01;
    @BindView(R.id.fph006b02)
    RadioButton fph006b02;
    @BindView(R.id.fph006b99)
    RadioButton fph006b99;
    @BindView(R.id.fph006c)
    RadioGroup fph006c;
    @BindView(R.id.fph006c01)
    RadioButton fph006c01;
    @BindView(R.id.fph006c02)
    RadioButton fph006c02;
    @BindView(R.id.fph006c99)
    RadioButton fph006c99;
    @BindView(R.id.fph006d)
    RadioGroup fph006d;
    @BindView(R.id.fph006d01)
    RadioButton fph006d01;
    @BindView(R.id.fph006d02)
    RadioButton fph006d02;
    @BindView(R.id.fph006d99)
    RadioButton fph006d99;
    @BindView(R.id.fph006e)
    RadioGroup fph006e;
    @BindView(R.id.fph006e01)
    RadioButton fph006e01;
    @BindView(R.id.fph006e02)
    RadioButton fph006e02;
    @BindView(R.id.fph006e99)
    RadioButton fph006e99;
    @BindView(R.id.fph006f)
    RadioGroup fph006f;
    @BindView(R.id.fph006f01)
    RadioButton fph006f01;
    @BindView(R.id.fph006f02)
    RadioButton fph006f02;
    @BindView(R.id.fph006f99)
    RadioButton fph006f99;
    @BindView(R.id.fph006g)
    RadioGroup fph006g;
    @BindView(R.id.fph006g01)
    RadioButton fph006g01;
    @BindView(R.id.fph006g02)
    RadioButton fph006g02;
    @BindView(R.id.fph006g99)
    RadioButton fph006g99;
    @BindView(R.id.fph006h)
    RadioGroup fph006h;
    @BindView(R.id.fph006h01)
    RadioButton fph006h01;
    @BindView(R.id.fph006h02)
    RadioButton fph006h02;
    @BindView(R.id.fph006h99)
    RadioButton fph006h99;
    @BindView(R.id.fph006i)
    RadioGroup fph006i;
    @BindView(R.id.fph006i01)
    RadioButton fph006i01;
    @BindView(R.id.fph006i02)
    RadioButton fph006i02;
    @BindView(R.id.fph006i99)
    RadioButton fph006i99;
    @BindView(R.id.fph006j)
    RadioGroup fph006j;
    @BindView(R.id.fph006j01)
    RadioButton fph006j01;
    @BindView(R.id.fph006j02)
    RadioButton fph006j02;
    @BindView(R.id.fph006j99)
    RadioButton fph006j99;
    @BindView(R.id.fph006k)
    RadioGroup fph006k;
    @BindView(R.id.fph006k01)
    RadioButton fph006k01;
    @BindView(R.id.fph006k02)
    RadioButton fph006k02;
    @BindView(R.id.fph006k99)
    RadioButton fph006k99;
    @BindView(R.id.fph006l)
    RadioGroup fph006l;
    @BindView(R.id.fph006l01)
    RadioButton fph006l01;
    @BindView(R.id.fph006l02)
    RadioButton fph006l02;
    @BindView(R.id.fph006l99)
    RadioButton fph006l99;
    @BindView(R.id.fph006m)
    RadioGroup fph006m;
    @BindView(R.id.fph006m01)
    RadioButton fph006m01;
    @BindView(R.id.fph006m02)
    RadioButton fph006m02;
    @BindView(R.id.fph006m99)
    RadioButton fph006m99;
    @BindView(R.id.fph006n)
    RadioGroup fph006n;
    @BindView(R.id.fph006n01)
    RadioButton fph006n01;
    @BindView(R.id.fph006n02)
    RadioButton fph006n02;
    @BindView(R.id.fph006n99)
    RadioButton fph006n99;
    @BindView(R.id.fph006o)
    RadioGroup fph006o;
    @BindView(R.id.fph006o01)
    RadioButton fph006o01;
    @BindView(R.id.fph006o02)
    RadioButton fph006o02;
    @BindView(R.id.fph006o99)
    RadioButton fph006o99;
    @BindView(R.id.fph006p)
    RadioGroup fph006p;
    @BindView(R.id.fph006p01)
    RadioButton fph006p01;
    @BindView(R.id.fph006p02)
    RadioButton fph006p02;
    @BindView(R.id.fph006p99)
    RadioButton fph006p99;
    @BindView(R.id.fph006q)
    RadioGroup fph006q;
    @BindView(R.id.fph006q01)
    RadioButton fph006q01;
    @BindView(R.id.fph006q02)
    RadioButton fph006q02;
    @BindView(R.id.fph006q99)
    RadioButton fph006q99;
    @BindView(R.id.fph007)
    RadioGroup fph007;
    @BindView(R.id.fph00701)
    RadioButton fph00701;
    @BindView(R.id.fph00702)
    RadioButton fph00702;
    @BindView(R.id.fph00799)
    RadioButton fph00799;
    @BindView(R.id.fph008)
    RadioGroup fph008;
    @BindView(R.id.fph00899)
    RadioButton fph00899;
    @BindView(R.id.fph00801)
    RadioButton fph00801;
    @BindView(R.id.fph00801x)
    EditText fph00801x;
    @BindView(R.id.fph009)
    RadioGroup fph009;
    @BindView(R.id.fph00901)
    RadioButton fph00901;
    @BindView(R.id.fph00902)
    RadioButton fph00902;
    @BindView(R.id.fph00999)
    RadioButton fph00999;
    @BindView(R.id.fph010)
    RadioGroup fph010;
    @BindView(R.id.fph01001)
    RadioButton fph01001;
    @BindView(R.id.fph01002)
    RadioButton fph01002;
    @BindView(R.id.fph01099)
    RadioButton fph01099;
    @BindView(R.id.fph011)
    RadioGroup fph011;
    @BindView(R.id.fph01101)
    RadioButton fph01101;
    @BindView(R.id.fph01102)
    RadioButton fph01102;
    @BindView(R.id.fph01199)
    RadioButton fph01199;
    @BindView(R.id.fph012)
    RadioGroup fph012;
    @BindView(R.id.fph01201)
    RadioButton fph01201;
    @BindView(R.id.fph01202)
    RadioButton fph01202;
    @BindView(R.id.fph01299)
    RadioButton fph01299;
    @BindView(R.id.fph013)
    RadioGroup fph013;
    @BindView(R.id.fph01301)
    RadioButton fph01301;
    @BindView(R.id.fph01302)
    RadioButton fph01302;
    @BindView(R.id.fph01399)
    RadioButton fph01399;
    @BindView(R.id.fphGrp001a)
    LinearLayout fphGrp001a;
    @BindView(R.id.fphGrp007)
    LinearLayout fphGrp007;
    @BindView(R.id.fphGrp008)
    LinearLayout fphGrp008;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_h);
        ButterKnife.bind(this);

        // =================== Q4b times ====================

        fph004b01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fph004bx.setVisibility(View.VISIBLE);
                } else {
                    fph004bx.setVisibility(View.GONE);
                    fph004bx.setText(null);
                }
            }
        });

        // =================== Q4c times ====================

        fph004c01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fph004cx.setVisibility(View.VISIBLE);
                } else {
                    fph004cx.setVisibility(View.GONE);
                    fph004cx.setText(null);
                }
            }
        });

        // =================== Q4f times ====================

        fph004f01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fph004fx.setVisibility(View.VISIBLE);
                } else {
                    fph004fx.setVisibility(View.GONE);
                    fph004fx.setText(null);
                }
            }
        });

        // =================== Q8 times ====================
        fph00801.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fph00801x.setVisibility(View.VISIBLE);
                } else {
                    fph00801x.setVisibility(View.GONE);
                    fph00801x.setText(null);
                }
            }
        });

        // ====================== Q 1 Skip Pattern =========================
        fph001.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (fph00101.isChecked()) {
                    fphGrp001a.setVisibility(View.GONE);
                    fph001a.clearCheck();

                } else {
                    fphGrp001a.setVisibility(View.VISIBLE);
                }
            }
        });

        // ====================== Q 8 Skip Pattern =========================
        fph007.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (fph00701.isChecked()) {
                    fphGrp008.setVisibility(View.VISIBLE);

                } else {
                    fphGrp008.setVisibility(View.GONE);
                    fph008.clearCheck();
                    fph00801x.setText(null);
                }
            }
        });


    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        Toast.makeText(this, "complete Section", Toast.LENGTH_SHORT).show();
        Intent endSec = new Intent(this, EndingActivity.class);
        endSec.putExtra("complete", false);
        startActivity(endSec);
    }

    @OnClick(R.id.btnNext)
    void onBtnNextClick() {
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
                Intent endSec = new Intent(this, SectionIActivity.class);
                startActivity(endSec);

            } else {
                Toast.makeText(this, "Failed to update Database", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean updateDb() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateH();

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

        JSONObject js = new JSONObject();
        js.put("fph001", fph00101.isChecked() ? "1" : fph00102.isChecked() ? "2" : fph00199.isChecked() ? "99" : "0");
        js.put("fph001a", fph001a01.isChecked() ? "1" : fph001a02.isChecked() ? "2" : fph001a99.isChecked() ? "99" : "0");
        js.put("fph002", fph00201.isChecked() ? "1" : fph00202.isChecked() ? "2" : fph00299.isChecked() ? "99" : "0");
        js.put("fph003", fph00301.isChecked() ? "1" : fph00302.isChecked() ? "2" : fph00399.isChecked() ? "99" : "0");
        js.put("fph004a", fph004a01.isChecked() ? "1" : fph004a02.isChecked() ? "2" : fph004a99.isChecked() ? "99" : "0");
        js.put("fph004b", fph004b01.isChecked() ? "1" : fph004b02.isChecked() ? "2" : fph004b99.isChecked() ? "99" : "0");
        js.put("fph004bx", fph004bx.getText().toString());
        js.put("fph004c", fph004c01.isChecked() ? "1" : fph004c02.isChecked() ? "2" : fph004c99.isChecked() ? "99" : "0");
        js.put("fph004cx", fph004cx.getText().toString());
        js.put("fph004d", fph004d01.isChecked() ? "1" : fph004d02.isChecked() ? "2" : fph004d99.isChecked() ? "99" : "0");
        js.put("fph004e", fph004e01.isChecked() ? "1" : fph004e02.isChecked() ? "2" : fph004e99.isChecked() ? "99" : "0");
        js.put("fph004f", fph004f01.isChecked() ? "1" : fph004f02.isChecked() ? "2" : fph004f99.isChecked() ? "99" : "0");
        js.put("fph004fx", fph004fx.getText().toString());
        js.put("fph004g", fph004g01.isChecked() ? "1" : fph004g02.isChecked() ? "2" : fph004g99.isChecked() ? "99" : "0");
        js.put("fph004h", fph004h01.isChecked() ? "1" : fph004h02.isChecked() ? "2" : fph004h99.isChecked() ? "99" : "0");
        js.put("fph004i", fph004i01.isChecked() ? "1" : fph004i02.isChecked() ? "2" : fph004i99.isChecked() ? "99" : "0");
        js.put("fph006a", fph006a01.isChecked() ? "1" : fph006a02.isChecked() ? "2" : fph006a99.isChecked() ? "99" : "0");
        js.put("fph006b", fph006b01.isChecked() ? "1" : fph006b02.isChecked() ? "2" : fph006b99.isChecked() ? "99" : "0");
        js.put("fph006c", fph006c01.isChecked() ? "1" : fph006c02.isChecked() ? "2" : fph006c99.isChecked() ? "99" : "0");
        js.put("fph006d", fph006d01.isChecked() ? "1" : fph006d02.isChecked() ? "2" : fph006d99.isChecked() ? "99" : "0");
        js.put("fph006e", fph006e01.isChecked() ? "1" : fph006e02.isChecked() ? "2" : fph006e99.isChecked() ? "99" : "0");
        js.put("fph006f", fph006f01.isChecked() ? "1" : fph006f02.isChecked() ? "2" : fph006f99.isChecked() ? "99" : "0");
        js.put("fph006g", fph006g01.isChecked() ? "1" : fph006g02.isChecked() ? "2" : fph006g99.isChecked() ? "99" : "0");
        js.put("fph006h", fph006h01.isChecked() ? "1" : fph006h02.isChecked() ? "2" : fph006h99.isChecked() ? "99" : "0");
        js.put("fph006i", fph006i01.isChecked() ? "1" : fph006i02.isChecked() ? "2" : fph006i99.isChecked() ? "99" : "0");
        js.put("fph006j", fph006j01.isChecked() ? "1" : fph006j02.isChecked() ? "2" : fph006j99.isChecked() ? "99" : "0");
        js.put("fph006k", fph006k01.isChecked() ? "1" : fph006k02.isChecked() ? "2" : fph006k99.isChecked() ? "99" : "0");
        js.put("fph006l", fph006l01.isChecked() ? "1" : fph006l02.isChecked() ? "2" : fph006l99.isChecked() ? "99" : "0");
        js.put("fph006m", fph006m01.isChecked() ? "1" : fph006m02.isChecked() ? "2" : fph006m99.isChecked() ? "99" : "0");
        js.put("fph006n", fph006n01.isChecked() ? "1" : fph006n02.isChecked() ? "2" : fph006n99.isChecked() ? "99" : "0");
        js.put("fph006o", fph006o01.isChecked() ? "1" : fph006o02.isChecked() ? "2" : fph006o99.isChecked() ? "99" : "0");
        js.put("fph006p", fph006p01.isChecked() ? "1" : fph006p02.isChecked() ? "2" : fph006p99.isChecked() ? "99" : "0");
        js.put("fph006q", fph006q01.isChecked() ? "1" : fph006q02.isChecked() ? "2" : fph006q99.isChecked() ? "99" : "0");
        js.put("fph007", fph00701.isChecked() ? "1" : fph00702.isChecked() ? "2" : fph00799.isChecked() ? "99" : "0");
        js.put("fph008", fph00801.isChecked() ? "1" : fph00899.isChecked() ? "99" : "0");
        js.put("fph00801x", fph00801x.getText().toString());
        js.put("fph009", fph00901.isChecked() ? "1" : fph00902.isChecked() ? "2" : fph00999.isChecked() ? "99" : "0");
        js.put("fph010", fph01001.isChecked() ? "1" : fph01002.isChecked() ? "2" : fph01099.isChecked() ? "99" : "0");
        js.put("fph011", fph01101.isChecked() ? "1" : fph01102.isChecked() ? "2" : fph01199.isChecked() ? "99" : "0");
        js.put("fph012", fph01201.isChecked() ? "1" : fph01202.isChecked() ? "2" : fph01299.isChecked() ? "99" : "0");
        js.put("fph013", fph01301.isChecked() ? "1" : fph01302.isChecked() ? "2" : fph01399.isChecked() ? "99" : "0");


        Toast.makeText(this, "validation succecful", Toast.LENGTH_SHORT).show();

    }

    public boolean validateForm() {

        // ====================== Q 1 ===================
        if (fph001.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph001), Toast.LENGTH_SHORT).show();
            fph00199.setError("This Data is required");
            Log.d(TAG, "not selected: fph001 ");
            return false;
        } else {
            fph00199.setError(null);
        }

        if (fph00102.isChecked() || fph00199.isChecked()) {
            // ====================== Q 1.1 ===================
            if (fph001a.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "" + getString(R.string.fph001a), Toast.LENGTH_SHORT).show();
                fph001a99.setError("This Data is required");
                Log.d(TAG, "not selected: fph001a ");
                return false;
            } else {
                fph001a99.setError(null);
            }
        }
        // ====================== Q 2 ===================
        if (fph002.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph002), Toast.LENGTH_SHORT).show();
            fph00299.setError("This Data is required");
            Log.d(TAG, "not selected: fph002 ");
            return false;
        } else {
            fph00299.setError(null);
        }

        // ====================== Q 3 ===================
        if (fph003.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph003), Toast.LENGTH_SHORT).show();
            fph00399.setError("This Data is required");
            Log.d(TAG, "not selected: fph003 ");
            return false;
        } else {
            fph00399.setError(null);
        }


        // ====================== Q 4a ===================
        if (fph004a.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph004a), Toast.LENGTH_SHORT).show();
            fph004a99.setError("This Data is required");
            Log.d(TAG, "not selected: fph004a ");
            return false;
        } else {
            fph004a99.setError(null);
        }

        // ====================== Q 4b ===================
        if (fph004b.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph004b), Toast.LENGTH_SHORT).show();
            fph004b99.setError("This Data is required");
            Log.d(TAG, "not selected: fph004b ");
            return false;
        } else {
            fph004b99.setError(null);
        }
        if (fph004b01.isChecked()) {

            if (fph004b01.isChecked() && fph004bx.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.fph004b) + " - " + getString(R.string.fph00501), Toast.LENGTH_LONG).show();
                fph004bx.setError("This data is Required!");    // Set Error on last radio button
                Log.d(TAG, "fpg004c: This data is Required!");
                return false;
            } else {
                fph004bx.setError(null);
            }

            if ((Integer.parseInt(fph004bx.getText().toString().isEmpty() ? "0" : fph004bx.getText().toString()) < 1) || (Integer.parseInt(fph004bx.getText().toString()) > 20)) {
                Toast.makeText(this, "ERROR: " + getString(R.string.fph004b) + getString(R.string.fph00501), Toast.LENGTH_LONG).show();
                fph004bx.setError("Range is 1-20 times");
                Log.i(TAG, "fph004b: Range is 1-20 times");
                return false;
            } else {
                fph004bx.setError(null);
            }
        }
        // ====================== Q 4c ===================
        if (fph004c.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph004c), Toast.LENGTH_SHORT).show();
            fph004c99.setError("This Data is required");
            Log.d(TAG, "not selected: fph004c ");
            return false;
        } else {
            fph004c99.setError(null);
        }

        if (fph004c01.isChecked()) {
            if (fph004c01.isChecked() && fph004cx.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.fph004c) + " - " + getString(R.string.fph00501), Toast.LENGTH_LONG).show();
                fph004cx.setError("This data is Required!");    // Set Error on last radio button
                Log.d(TAG, "fph004c: This data is Required!");
                return false;
            } else {
                fph004cx.setError(null);
            }

            if ((Integer.parseInt(fph004cx.getText().toString().isEmpty() ? "0" : fph004cx.getText().toString()) < 1) || (Integer.parseInt(fph004cx.getText().toString()) > 20)) {
                Toast.makeText(this, "ERROR: " + getString(R.string.fph004c) + getString(R.string.fph00501), Toast.LENGTH_LONG).show();
                fph004cx.setError("Range is 1-20 times");
                Log.i(TAG, "fph004c: Range is 1-20 times");
                return false;
            } else {
                fph004bx.setError(null);
            }
        }
        // ====================== Q 4d ===================
        if (fph004d.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph004d), Toast.LENGTH_SHORT).show();
            fph004d99.setError("This Data is required");
            Log.d(TAG, "not selected: fph004d ");
            return false;
        } else {
            fph004d99.setError(null);
        }

        // ====================== Q 4e ===================
        if (fph004e.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph004e), Toast.LENGTH_SHORT).show();
            fph004e99.setError("This Data is required");
            Log.d(TAG, "not selected: fph004e ");
            return false;
        } else {
            fph004e99.setError(null);
        }

        // ====================== Q 4f ===================
        if (fph004f.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph004f), Toast.LENGTH_SHORT).show();
            fph004f99.setError("This Data is required");
            Log.d(TAG, "not selected: fph004f ");
            return false;
        } else {
            fph004f99.setError(null);
        }

        if (fph004f01.isChecked()) {
            if (fph004f01.isChecked() && fph004fx.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.fph004f) + " - " + getString(R.string.fph00501), Toast.LENGTH_LONG).show();
                fph004fx.setError("This data is Required!");    // Set Error on last radio button
                Log.d(TAG, "fph004f: This data is Required!");
                return false;
            } else {
                fph004fx.setError(null);
            }

            if ((Integer.parseInt(fph004fx.getText().toString().isEmpty() ? "0" : fph004fx.getText().toString()) < 1) || (Integer.parseInt(fph004fx.getText().toString()) > 20)) {
                Toast.makeText(this, "ERROR: " + getString(R.string.fph004f) + getString(R.string.fph00501), Toast.LENGTH_LONG).show();
                fph004fx.setError("Range is 1-20 times");
                Log.i(TAG, "fpe001f: Range is 1-20 times");
                return false;
            } else {
                fph004fx.setError(null);
            }
        }
        // ====================== Q 4g ===================
        if (fph004g.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph004g), Toast.LENGTH_SHORT).show();
            fph004g99.setError("This Data is required");
            Log.d(TAG, "not selected: fph004g ");
            return false;
        } else {
            fph004g99.setError(null);
        }

        // ====================== Q 4h ===================
        if (fph004h.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph004h), Toast.LENGTH_SHORT).show();
            fph004h99.setError("This Data is required");
            Log.d(TAG, "not selected: fph004h ");
            return false;
        } else {
            fph004h99.setError(null);
        }

        // ====================== Q 4i ===================
        if (fph004i.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph004i), Toast.LENGTH_SHORT).show();
            fph004i99.setError("This Data is required");
            Log.d(TAG, "not selected: fph004i ");
            return false;
        } else {
            fph004i99.setError(null);
        }

        // ====================== Q 6a ===================
        if (fph006a.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph006a), Toast.LENGTH_SHORT).show();
            fph006a99.setError("This Data is required");
            Log.d(TAG, "not selected: fph006a ");
            return false;
        } else {
            fph006a99.setError(null);
        }

        // ====================== Q 6b ===================
        if (fph006b.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph006b), Toast.LENGTH_SHORT).show();
            fph006b99.setError("This Data is required");
            Log.d(TAG, "not selected: fph006b ");
            return false;
        } else {
            fph006b99.setError(null);
        }

        // ====================== Q 6c ===================
        if (fph006c.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph006c), Toast.LENGTH_SHORT).show();
            fph006c99.setError("This Data is required");
            Log.d(TAG, "not selected: fph006c ");
            return false;
        } else {
            fph006c99.setError(null);
        }

        // ====================== Q 6d ===================
        if (fph006d.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph006d), Toast.LENGTH_SHORT).show();
            fph006d99.setError("This Data is required");
            Log.d(TAG, "not selected: fph006d ");
            return false;
        } else {
            fph006d99.setError(null);
        }

        // ====================== Q 6e ===================
        if (fph006e.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph006e), Toast.LENGTH_SHORT).show();
            fph006e99.setError("This Data is required");
            Log.d(TAG, "not selected: fph006e ");
            return false;
        } else {
            fph006e99.setError(null);
        }

        // ====================== Q 6f ===================
        if (fph006f.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph006f), Toast.LENGTH_SHORT).show();
            fph006f99.setError("This Data is required");
            Log.d(TAG, "not selected: fph006f ");
            return false;
        } else {
            fph006f99.setError(null);
        }

        // ====================== Q 6g ===================
        if (fph006g.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph006g), Toast.LENGTH_SHORT).show();
            fph006g99.setError("This Data is required");
            Log.d(TAG, "not selected: fph006g ");
            return false;
        } else {
            fph006g99.setError(null);
        }

        // ====================== Q 6h ===================
        if (fph006h.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph006h), Toast.LENGTH_SHORT).show();
            fph006h99.setError("This Data is required");
            Log.d(TAG, "not selected: fph006h ");
            return false;
        } else {
            fph006h99.setError(null);
        }

        // ====================== Q 6i ===================
        if (fph006i.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph006i), Toast.LENGTH_SHORT).show();
            fph006i99.setError("This Data is required");
            Log.d(TAG, "not selected: fph006i ");
            return false;
        } else {
            fph006i99.setError(null);
        }

        // ====================== Q 6j ===================
        if (fph006j.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph006j), Toast.LENGTH_SHORT).show();
            fph006j99.setError("This Data is required");
            Log.d(TAG, "not selected: fph006j ");
            return false;
        } else {
            fph006j99.setError(null);
        }

        // ====================== Q 6k ===================
        if (fph006k.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph006k), Toast.LENGTH_SHORT).show();
            fph006k99.setError("This Data is required");
            Log.d(TAG, "not selected: fph006k ");
            return false;
        } else {
            fph006k99.setError(null);
        }

        // ====================== Q 6l ===================
        if (fph006l.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph006l), Toast.LENGTH_SHORT).show();
            fph006l99.setError("This Data is required");
            Log.d(TAG, "not selected: fph006l ");
            return false;
        } else {
            fph006l99.setError(null);
        }

        // ====================== Q 6m ===================
        if (fph006m.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph006m), Toast.LENGTH_SHORT).show();
            fph006m99.setError("This Data is required");
            Log.d(TAG, "not selected: fph006m ");
            return false;
        } else {
            fph006m99.setError(null);
        }

        // ====================== Q 6n ===================
        if (fph006n.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph006n), Toast.LENGTH_SHORT).show();
            fph006n99.setError("This Data is required");
            Log.d(TAG, "not selected: fph006n ");
            return false;
        } else {
            fph006n99.setError(null);
        }

        // ====================== Q 6o ===================
        if (fph006o.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph006o), Toast.LENGTH_SHORT).show();
            fph006o99.setError("This Data is required");
            Log.d(TAG, "not selected: fph006o ");
            return false;
        } else {
            fph006o99.setError(null);
        }

        // ====================== Q 6p ===================
        if (fph006p.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph006p), Toast.LENGTH_SHORT).show();
            fph006p99.setError("This Data is required");
            Log.d(TAG, "not selected: fph006p ");
            return false;
        } else {
            fph006p99.setError(null);
        }

        // ====================== Q 6q ===================
        if (fph006q.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph006q), Toast.LENGTH_SHORT).show();
            fph006q99.setError("This Data is required");
            Log.d(TAG, "not selected: fph006q ");
            return false;
        } else {
            fph006q99.setError(null);
        }

        // ====================== Q 7 ===================
        if (fph007.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph007), Toast.LENGTH_SHORT).show();
            fph00799.setError("This Data is required");
            Log.d(TAG, "not selected: fph007 ");
            return false;
        } else {
            fph00799.setError(null);
        }

        if (fph00701.isChecked()) {

            // ====================== Q 8 ===================
            if (fph008.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "" + getString(R.string.fph008), Toast.LENGTH_SHORT).show();
                fph00899.setError("This Data is required");
                Log.d(TAG, "not selected: fph008 ");
                return false;
            } else {
                fph00899.setError(null);
            }

            if (fph00801.isChecked() && fph00801x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.fph008) + " - " + getString(R.string.fph00801), Toast.LENGTH_LONG).show();
                fph00801x.setError("This data is Required!");    // Set Error on last radio button
                Log.d(TAG, "fph008x: This data is Required!");
                return false;
            } else {
                fph00801x.setError(null);
            }


            if (fph00801.isChecked() && ((Integer.parseInt(fph00801x.getText().toString().isEmpty() ? "0" : fph00801x.getText().toString()) < 1) || (Integer.parseInt(fph00801x.getText().toString()) > 20))) {
                Toast.makeText(this, "ERROR: " + getString(R.string.fph008) + getString(R.string.fph00801), Toast.LENGTH_LONG).show();
                fph00801x.setError("Range is 1-20 times");
                Log.i(TAG, "fph008: Range is 1-20 times");
                return false;
            } else {
                fph00801x.setError(null);
            }
        }
        // ====================== Q 9 ===================
        if (fph009.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph009), Toast.LENGTH_SHORT).show();
            fph00999.setError("This Data is required");
            Log.d(TAG, "not selected: fph009 ");
            return false;
        } else {
            fph00999.setError(null);
        }

        // ====================== Q 10 ===================
        if (fph010.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph010), Toast.LENGTH_SHORT).show();
            fph01099.setError("This Data is required");
            Log.d(TAG, "not selected: fph010 ");
            return false;
        } else {
            fph01099.setError(null);
        }

        // ====================== Q 11 ===================
        if (fph011.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph011), Toast.LENGTH_SHORT).show();
            fph01199.setError("This Data is required");
            Log.d(TAG, "not selected: fph011 ");
            return false;
        } else {
            fph01199.setError(null);
        }

        // ====================== Q 12 ===================
        if (fph012.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph012), Toast.LENGTH_SHORT).show();
            fph01299.setError("This Data is required");
            Log.d(TAG, "not selected: fph012 ");
            return false;
        } else {
            fph01299.setError(null);
        }

        // ====================== Q 13 ===================
        if (fph013.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.fph013), Toast.LENGTH_SHORT).show();
            fph01399.setError("This Data is required");
            Log.d(TAG, "not selected: fph013 ");
            return false;
        } else {
            fph01399.setError(null);
        }




        return true;
    }


}
