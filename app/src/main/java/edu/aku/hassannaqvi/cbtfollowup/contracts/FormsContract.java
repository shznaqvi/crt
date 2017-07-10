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
    private Long _ID;
    private String UID = "";
    private String formDate = ""; // Date
    private String interviewer01 = ""; // Interviewer 01
    private String interviewer02 = ""; // Interviewer 02
    private String clustercode = "0000"; // Area Code
    private String villageacode = ""; // Sub-Area Code
    private String household = ""; // Household number
    private String istatus = ""; // Interview Status
    private String sA = "";
    private String sBA = "";
    private String sBB = "";
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

    public Long getID() {
        return _ID;
    }

    public void setID(Long _ID) {
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

    public String getInterviewer01() {
        return interviewer01;
    }

    public void setInterviewer01(String interviewer01) {
        this.interviewer01 = interviewer01;
    }

    public String getInterviewer02() {
        return interviewer02;
    }

    public void setInterviewer02(String interviewer02) {
        this.interviewer02 = interviewer02;
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

    public String getsBA() {
        return sBA;
    }

    public void setsBA(String sBA) {
        this.sBA = sBA;
    }

    public String getsBB() {
        return sBB;
    }

    public void setsBB(String sBB) {
        this.sBB = sBB;
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
        this._ID = jsonObject.getLong(FormColumns.COLUMN__ID);
        this.UID = jsonObject.getString(FormColumns.COLUMN_UID);
        this.formDate = jsonObject.getString(FormColumns.COLUMN_FORMDATE);
        this.interviewer01 = jsonObject.getString(FormColumns.COLUMN_INTERVIEWER01);
        this.interviewer02 = jsonObject.getString(FormColumns.COLUMN_INTERVIEWER02);
        this.clustercode = jsonObject.getString(FormColumns.COLUMN_CLUSTERCODE);
        this.villageacode = jsonObject.getString(FormColumns.COLUMN_VILLAGEACODE);
        this.household = jsonObject.getString(FormColumns.COLUMN_HOUSEHOLD);
        this.istatus = jsonObject.getString(FormColumns.COLUMN_ISTATUS);
        this.sA = jsonObject.getString(FormColumns.COLUMN_SA);
        this.sBA = jsonObject.getString(FormColumns.COLUMN_SBA);
        this.sBB = jsonObject.getString(FormColumns.COLUMN_SBB);
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
        this._ID = cursor.getLong(cursor.getColumnIndex(FormColumns.COLUMN__ID));
        this.UID = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_UID));
        this.formDate = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_FORMDATE));
        this.interviewer01 = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_INTERVIEWER01));
        this.interviewer02 = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_INTERVIEWER02));
        this.clustercode = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_CLUSTERCODE));
        this.villageacode = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_VILLAGEACODE));
        this.household = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_HOUSEHOLD));
        this.istatus = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_ISTATUS));
        this.sA = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_SA));
        this.sBA = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_SBA));
        this.sBB = cursor.getString(cursor.getColumnIndex(FormColumns.COLUMN_SBB));
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
        json.put(FormColumns.COLUMN__ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(FormColumns.COLUMN_UID, this.UID == null ? JSONObject.NULL : this.UID);
        json.put(FormColumns.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(FormColumns.COLUMN_INTERVIEWER01, this.interviewer01 == null ? JSONObject.NULL : this.interviewer01);
        json.put(FormColumns.COLUMN_INTERVIEWER02, this.interviewer02 == null ? JSONObject.NULL : this.interviewer02);
        json.put(FormColumns.COLUMN_CLUSTERCODE, this.clustercode == null ? JSONObject.NULL : this.clustercode);
        json.put(FormColumns.COLUMN_VILLAGEACODE, this.villageacode == null ? JSONObject.NULL : this.villageacode);
        json.put(FormColumns.COLUMN_HOUSEHOLD, this.household == null ? JSONObject.NULL : this.household);
        json.put(FormColumns.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(FormColumns.COLUMN_SA, this.sA == null ? JSONObject.NULL : this.sA);
        json.put(FormColumns.COLUMN_SBA, this.sBA == null ? JSONObject.NULL : this.sBA);
        json.put(FormColumns.COLUMN_SBB, this.sBB == null ? JSONObject.NULL : this.sBB);
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
        public static final String COLUMN__ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_INTERVIEWER01 = "interviewer01";
        public static final String COLUMN_INTERVIEWER02 = "interviewer02";
        public static final String COLUMN_CLUSTERCODE = "clustercode";
        public static final String COLUMN_VILLAGEACODE = "villageacode";
        public static final String COLUMN_HOUSEHOLD = "household";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_SA = "sa";
        public static final String COLUMN_SBA = "sba";
        public static final String COLUMN_SBB = "sbb";
        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSTIME = "gpstime";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";


    }
}
