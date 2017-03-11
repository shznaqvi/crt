package edu.aku.hassannaqvi.crt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
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

public class SectionHActivity extends Activity {

    @BindView(R.id.activity_section_h)
    RelativeLayout activitySectionH;
    @BindView(R.id.scrollView01)
    ScrollView scrollView01;
    @BindView(R.id.app_header)
    TextView appHeader;
    @BindView(R.id.textView)
    TextView textView;
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
    @BindView(R.id.fph004fg99)
    RadioButton fph004fg99;
    @BindView(R.id.fph004h)
    RadioGroup fph004h;
    @BindView(R.id.fph004h01)
    RadioButton fph004h01;
    @BindView(R.id.fph004h02)
    RadioButton fph004h02;
    @BindView(R.id.fph004fh99)
    RadioButton fph004fh99;
    @BindView(R.id.fph004i)
    RadioGroup fph004i;
    @BindView(R.id.fph004i01)
    RadioButton fph004i01;
    @BindView(R.id.fph004i02)
    RadioButton fph004i02;
    @BindView(R.id.fph004fi99)
    RadioButton fph004fi99;
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
    @BindView(R.id.fph008x)
    EditText fph008x;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_h);
        ButterKnife.bind(this);

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
                Intent endSec = new Intent(this, SectionIActivity.class);
                startActivity(endSec);

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


        Toast.makeText(this, "validation succecful", Toast.LENGTH_SHORT).show();

    }

    public boolean validateForm() {

        return true;
    }


}
