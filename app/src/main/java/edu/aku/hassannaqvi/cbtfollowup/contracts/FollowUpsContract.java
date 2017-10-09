package edu.aku.hassannaqvi.cbtfollowup.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FollowUpsContract {

    private static final String TAG = "FollowUps_CONTRACT";
    Long _ID;
    String CHILDNAME;
    String CHILDID;
    String FOLLOWUPDT;
    String FOLLOWUPRND;
    String MOTHERNAME;


    public FollowUpsContract() {
        // Default Constructor
    }

    public FollowUpsContract(FollowUpsContract fpc) {
        this.CHILDID = fpc.getCHILDID();
        this.CHILDNAME = fpc.getCHILDNAME();
        this.MOTHERNAME = fpc.getMOTHERNAME();
        this.FOLLOWUPRND = fpc.getFOLLOWUPRND();
        this.FOLLOWUPDT = fpc.getFOLLOWUPDT();
    }

    public FollowUpsContract Sync(JSONObject jsonObject) throws JSONException {
        this.CHILDNAME = jsonObject.getString(singleFollowUps.COLUMN_CHILDNAME);
        this.MOTHERNAME = jsonObject.getString(singleFollowUps.COLUMN_MOTHERNAME);
        this.CHILDID = jsonObject.getString(singleFollowUps.COLUMN_CHILDID);
        this.FOLLOWUPDT = jsonObject.getString(singleFollowUps.COLUMN_FOLLOWUPDT);
        this.FOLLOWUPRND = jsonObject.getString(singleFollowUps.COLUMN_FOLLOWUPRND);

        return this;

    }

    public FollowUpsContract Hydrate(Cursor cursor) {
        this.CHILDNAME = cursor.getString(cursor.getColumnIndex(singleFollowUps.COLUMN_CHILDNAME));
        this.MOTHERNAME = cursor.getString(cursor.getColumnIndex(singleFollowUps.COLUMN_MOTHERNAME));
        this.CHILDID = cursor.getString(cursor.getColumnIndex(singleFollowUps.COLUMN_CHILDID));
        this.FOLLOWUPDT = cursor.getString(cursor.getColumnIndex(singleFollowUps.COLUMN_FOLLOWUPDT));
        this.FOLLOWUPRND = cursor.getString(cursor.getColumnIndex(singleFollowUps.COLUMN_FOLLOWUPRND));

        return this;
    }

    public Long get_ID() {
        return _ID;
    }

    public void set_ID(Long _ID) {
        this._ID = _ID;
    }

    public String getCHILDNAME() {
        return CHILDNAME;
    }

    public void setCHILDNAME(String CHILDNAME) {
        this.CHILDNAME = CHILDNAME;
    }

    public String getMOTHERNAME() {
        return MOTHERNAME;
    }

    public void setMOTHERNAME(String MOTHERNAME) {
        this.MOTHERNAME = MOTHERNAME;
    }

    public String getCHILDID() {
        return CHILDID;
    }

    public void setCHILDID(String CHILDID) {
        this.CHILDID = CHILDID;
    }

    public String getFOLLOWUPDT() {
        return FOLLOWUPDT;
    }

    public void setFOLLOWUPDT(String FOLLOWUPDT) {
        this.FOLLOWUPDT = FOLLOWUPDT;
    }

    public String getFOLLOWUPRND() {
        return FOLLOWUPRND;
    }

    public void setFOLLOWUPRND(String FOLLOWUPRND) {
        this.FOLLOWUPRND = FOLLOWUPRND;
    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(singleFollowUps._ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(singleFollowUps.COLUMN_CHILDNAME, this.CHILDNAME == null ? JSONObject.NULL : this.CHILDNAME);
        json.put(singleFollowUps.COLUMN_MOTHERNAME, this.MOTHERNAME == null ? JSONObject.NULL : this.MOTHERNAME);
        json.put(singleFollowUps.COLUMN_CHILDID, this.CHILDID == null ? JSONObject.NULL : this.CHILDID);
        json.put(singleFollowUps.COLUMN_FOLLOWUPDT, this.FOLLOWUPDT == null ? JSONObject.NULL : this.FOLLOWUPDT);
        json.put(singleFollowUps.COLUMN_FOLLOWUPRND, this.FOLLOWUPRND == null ? JSONObject.NULL : this.FOLLOWUPRND);
        return json;
    }


    public static abstract class singleFollowUps implements BaseColumns {

        public static final String TABLE_NAME = "followups";
        public static final String _ID = "_id";
        public static final String COLUMN_CHILDID = "childid";
        public static final String COLUMN_FOLLOWUPDT = "fupdt";
        public static final String COLUMN_FOLLOWUPRND = "fupround";
        public static final String COLUMN_CHILDNAME = "crb01";
        public static final String COLUMN_MOTHERNAME = "cra09";

        public static final String _URI = "/*getfollowups*/.php";
    }
}
