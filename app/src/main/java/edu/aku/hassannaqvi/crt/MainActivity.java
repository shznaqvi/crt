package edu.aku.hassannaqvi.crt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends Activity {

    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    @BindView(R.id.adminsec)
    LinearLayout adminsec;
    @BindView(R.id.recordSummary)
    TextView recordSummary;
    @BindView(R.id.areaCode)
    EditText areaCode;
    private String rSumText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // Reset working variables
        AppMain.child_name = "Test";


//        if (AppMain.admin) {
//            adminsec.setVisibility(View.VISIBLE);
//        } else {
//            adminsec.setVisibility(View.GONE);
//        }


//        DatabaseHelper db = new DatabaseHelper(this);
//        Collection<FormsContract> todaysForms = new ArrayList<>();
//
//        todaysForms = db.getTodayForms();
//
//        rSumText += "TODAY'S RECORDS SUMMARY\r\n";
//        rSumText += "=======================";
//        rSumText += "\r\n\r\n";
//        rSumText += "Total Forms Today: " + todaysForms.size();
//        rSumText += "\r\n";
//        rSumText += "    Forms List: \r\n";
//        String iStatus = "";
//        for (FormsContract fc : todaysForms) {
//
//            switch (fc.getIstatus()) {
//                case "1":
//                    iStatus = "Complete";
//                    break;
//                case "2":
//                    iStatus = "House Locked";
//                    break;
//                case "3":
//                    iStatus = "Refused";
//                    break;
//                case "4":
//                    iStatus = "Refused";
//                    break;
//            }
//
//            rSumText += fc.getSubareacode() + " " + fc.getHousehold() + " " + iStatus;
//            rSumText += "\r\n";
//
//        }
//
//        rSumText += "--------------------------------------------------\r\n";
//        if (AppMain.admin) {
//            adminsec.setVisibility(View.VISIBLE);
//            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
//            rSumText += "Last Update: " + syncPref.getString("LastUpdate", "Never Updated");
//            rSumText += "\r\n";
//            rSumText += "Last Synced(DB): " + syncPref.getString("LastSyncDB", "Never Synced");
//            rSumText += "\r\n";
//        }
//        recordSummary.setText(rSumText);


    }

    public void openForm(View v) {
        Intent oF = new Intent(MainActivity.this, SectionAActivity.class);
        startActivity(oF);
    }

    public void openMembers(View v) {
        //Intent iMem = new Intent(this, FamilyMembersActivity.class);
        //startActivity(iMem);
    }

    public void openA(View v) {
        Intent iA = new Intent(this, SectionAActivity.class);
        startActivity(iA);
    }


    public void openDB(View v) {
        Intent dbmanager = new Intent(getApplicationContext(), AndroidDatabaseManager.class);
        startActivity(dbmanager);
    }

    /*public void CheckCluster(View v) {
        Intent cluster_list = new Intent(getApplicationContext(), FormsList.class);
        cluster_list.putExtra("areaCode", areaCode.getText().toString());
        startActivity(cluster_list);

    }*/
    public void syncServer(View view) {

        String formsUrl = AppMain._HOST_URL + "virband/api/forms.php";
        String imsUrl = AppMain._HOST_URL + "virband/api/ims.php";

        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Toast.makeText(getApplicationContext(), "Syncing Forms", Toast.LENGTH_SHORT).show();
            new SyncForms(this).execute(formsUrl);

            /*Toast.makeText(getApplicationContext(), "Syncing IMs", Toast.LENGTH_SHORT).show();
            new SyncIMs(this).execute(imsUrl);*/

            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();

            editor.putString("LastUpSyncServer", dtToday);

            editor.apply();

        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }

    }

    public void syncDevice(View view) {

        //String usersUrl = AppMain._HOST_URL + "virband/api/users.php";
        //String randsUrl = AppMain._HOST_URL + "virband/api/random.php"; // url to sync randomise data
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            // Sync Randomization
            Toast.makeText(getApplicationContext(), "Syncing Eligibleomization", Toast.LENGTH_SHORT).show();
            new SyncEligibles(this).execute();


            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();

            editor.putString("LastDownSyncServer", dtToday);

            editor.apply();
        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }
    }
}