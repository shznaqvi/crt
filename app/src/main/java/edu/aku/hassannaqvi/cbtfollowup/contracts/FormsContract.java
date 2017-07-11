package edu.aku.hassannaqvi.cbtfollowup.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsContract {

    private String projectName = "MaPPS Study";
    private String surveyType = "Form 02: Enrolment and Baseline Assessment";
    private String _ID;
    private String UID = "";
    private String formDate = ""; // Date
    private String user = ""; // user
    private String devicetagId = ""; // Device Tag Id
    private String clustercode = "0000"; // Area Code
    private String villageacode = ""; // Sub-Area Code
    private String household = ""; // Household number
    private String istatus = ""; // Interview Status
    private String sA = "";
    private String sB = "";
    private String sC = "";
    private String sD = "";
    private String sE = "";
    private String sF = "";
    private String sG = "";
    private String sH = "";
    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsTime = "";
    private String gpsAcc = "";
    private String deviceID = "";
    private String synced = "";
    private String synced_date = "";

    public FormsContract() {
    }

    public String getProjectName() {
        return projectName;
    }

    public String getSurveyType() {
        return surveyType;
    }

    public String getID() {
        return _ID;
    }

    public void setID(String _ID) {
        this._ID = _ID;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDevicetagId() {
        return devicetagId;
    }

    public void setDevicetagId(String devicetagId) {
        this.devicetagId = devicetagId;
    }

    public String getClustercode() {
        return clustercode;
    }

    public void setClustercode(String clustercode) {
        this.clustercode = clustercode;
    }

    public String getVillageacode() {
        return villageacode;
    }

    public void setVillageacode(String villageacode) {
        this.villageacode = villageacode;
    }

    public String getHousehold() {
        return household;
    }

    public void setHousehold(String household) {
        this.household = household;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
    }

    public String getsB() {
        return sB;
    }

    public void setsB(String sB) {
        this.sB = sB;
    }

    public String getsC() {
        return sC;
    }

    public void setsC(String sC) {
        this.sC = sC;
    }

    public String getsD() {
        return sD;
    }

    public void setsD(String sD) {
        this.sD = sD;
    }

    public String getsE() {
        return sE;
    }

    public void setsE(String sE) {
        this.sE = sE;
    }

    public String getsF() {
        return sF;
    }

    public void setsF(String sF) {
        this.sF = sF;
    }

    public String getsG() {
        return sG;
    }

    public void setsG(String sG) {
        this.sG = sG;
    }

    public String getsH() {
        return sH;
    }

    public void setsH(String sH) {
        this.sH = sH;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    public String getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(String gpsTime) {
        this.gpsTime = gpsTime;
    }

    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    public FormsContract Sync(JSONObject jsonObject) throws JSONException {
        this.projectName = jsonObject.getString(FormColumns.COLUMN_PROJECTNAME);
        this.surveyType = jsonObject.getString(FormColumns.COLUMN_SURVEYTYPE);
        this._ID = jsonObject.getString(FormColumns.COLUMN_ID);
        this.UID = jsonObject.getString(FormColumns.COLUMN_UID);
        this.formDate = jsonObject.getString(FormColumns.COLUMN_FORMDATE);
        this.user = jsonObject.getString(FormColumns.COLUMN_USER);
        this.devicetagId = jsonObject.getString(FormColumns.COLUMN_DEVICETAGID);
        this.clustercode = jsonObject.getString(FormColumns.COLUMN_CLUSTERCODE);
        this.villageacode = jsonObject.getString(FormColumns.COLUMN_VILLAGEACODE);
        this.household = jsonObject.getString(FormColumns.COLUMN_HOUSEHOLD);
        this.istatus = jsonObject.getString(FormColumns.COLUMN_ISTATUS);
        this.sA = jsonObject.getString(FormColumns.COLUMN_SA);
        this.sB = jsonObject.getString(FormColumns.COLUMN_SB);
        this.sC = jsonObject.getString(FormColumns.COLUMN_SC);
        this.sD = jsonObject.getString(FormColumns.COLUMN_SD);
        this.sE = jsonObject.getString(FormColumns.COLUMN_SE);
        this.sF = jsonObject.getString(FormColumns.COLUMN_SF);
        this.sG = jsonObject.getString(FormColumns.COLUMN_SG);
        this.sH = jsonObject.getString(FormColumns.COLUMN_SH);
        this.gpsLat = jsonObject.getString(FormColumns.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormColumns.COLUMN_GPSLNG);
        this.gpsTime = jsonObject.getString(FormColumns.COLUMN_GPSTIME);
        this.gpsAcc = jsonObject.getString(FormColumns.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(FormColumns.COLUMN_DEVICEID);
        this.synced = jsonObject.getString(FormColumns.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormColumns.COLUMN_SYNCED_DATE);

        return this;

    }

    public FormsContract Hydrate(Cursor cursor) {
        this.projectName = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_PROJECTNAME));
        this.surveyType = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_SURVEYTYPE));
        this._ID = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_ID));
        this.UID = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_UID));
        this.formDate = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_FORMDATE));
        this.user = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_USER));
        this.devicetagId = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_DEVICETAGID));
        this.clustercode = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_CLUSTERCODE));
        this.villageacode = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_VILLAGEACODE));
        this.household = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_HOUSEHOLD));
        this.istatus = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_ISTATUS));
        this.sA = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_SA));
        this.sB = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_SB));
        this.sC = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_SC));
        this.sD = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_SD));
        this.sE = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_SE));
        this.sF = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_SF));
        this.sG = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_SG));
        this.sH = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_SH));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_GPSLNG));
        this.gpsTime = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_GPSTIME));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_DEVICEID));
        this.synced = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_SYNCED_DATE));

        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormColumns.COLUMN_PROJECTNAME, this.projectName == null ? JSONObject.NULL : this.projectName);
        json.put(FormColumns.COLUMN_SURVEYTYPE, this.surveyType == null ? JSONObject.NULL : this.surveyType);
        json.put(FormColumns.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(FormColumns.COLUMN_UID, this.UID == null ? JSONObject.NULL : this.UID);
        json.put(FormColumns.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(FormColumns.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(FormColumns.COLUMN_DEVICETAGID, this.devicetagId == null ? JSONObject.NULL : this.devicetagId);
        json.put(FormColumns.COLUMN_CLUSTERCODE, this.clustercode == null ? JSONObject.NULL : this.clustercode);
        json.put(FormColumns.COLUMN_VILLAGEACODE, this.villageacode == null ? JSONObject.NULL : this.villageacode);
        json.put(FormColumns.COLUMN_HOUSEHOLD, this.household == null ? JSONObject.NULL : this.household);
        json.put(FormColumns.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(FormColumns.COLUMN_SA, this.sA == null ? JSONObject.NULL : this.sA);
        json.put(FormColumns.COLUMN_SB, this.sB == null ? JSONObject.NULL : this.sB);
        json.put(FormColumns.COLUMN_SC, this.sC == null ? JSONObject.NULL : this.sC);
        json.put(FormColumns.COLUMN_SD, this.sD == null ? JSONObject.NULL : this.sD);
        json.put(FormColumns.COLUMN_SE, this.sE == null ? JSONObject.NULL : this.sE);
        json.put(FormColumns.COLUMN_SF, this.sF == null ? JSONObject.NULL : this.sF);
        json.put(FormColumns.COLUMN_SG, this.sG == null ? JSONObject.NULL : this.sG);
        json.put(FormColumns.COLUMN_SH, this.sH == null ? JSONObject.NULL : this.sH);
        json.put(FormColumns.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(FormColumns.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(FormColumns.COLUMN_GPSTIME, this.gpsTime == null ? JSONObject.NULL : this.gpsTime);
        json.put(FormColumns.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(FormColumns.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(FormColumns.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(FormColumns.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);


        return json;
    }

    public static abstract class FormColumns implements BaseColumns {

        public static final String TABLE_NAME = "forms";
        public static final String SYNC_URL = "/forms";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";

        public static final String COLUMN_PROJECTNAME = "projectname";
        public static final String COLUMN_SURVEYTYPE = "surveytype";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_DEVICETAGID = "devicetagId";
        public static final String COLUMN_CLUSTERCODE = "clustercode";
        public static final String COLUMN_VILLAGEACODE = "villageacode";
        public static final String COLUMN_HOUSEHOLD = "household";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_SA = "sa";
        public static final String COLUMN_SB = "sb";
        public static final String COLUMN_SC = "sc";
        public static final String COLUMN_SD = "sd";
        public static final String COLUMN_SE = "se";
        public static final String COLUMN_SF = "sf";
        public static final String COLUMN_SG = "sg";
        public static final String COLUMN_SH = "sh";
        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSTIME = "gpstime";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";


    }
}
