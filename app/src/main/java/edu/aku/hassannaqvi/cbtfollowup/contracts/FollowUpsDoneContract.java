package edu.aku.hassannaqvi.cbtfollowup.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FollowUpsDoneContract {

    private static final String TAG = "FollowUpsDone_CONTRACT";
    Long _ID;
    String CHILDNAME;
    String CHILDID;
    String FOLLOWUPRND;
    private String _LUID = "";


    public FollowUpsDoneContract() {
        // Default Constructor
    }

    public FollowUpsDoneContract(FollowUpsDoneContract fpc) {
        this.CHILDID = fpc.getCHILDID();
        this.CHILDNAME = fpc.getCHILDNAME();
        this.FOLLOWUPRND = fpc.getFOLLOWUPRND();
        this._LUID = fpc.getFOLLOWUPRND();
    }

    public FollowUpsDoneContract Sync(JSONObject jsonObject) throws JSONException {

        this.CHILDNAME = jsonObject.getString(singleFollowUpsDone.COLUMN_CHILDNAME);
        this.CHILDID = jsonObject.getString(singleFollowUpsDone.COLUMN_CHILDID);
        this.FOLLOWUPRND = jsonObject.getString(singleFollowUpsDone.COLUMN_FOLLOWUPRND);
        this._LUID = jsonObject.getString(singleFollowUpsDone.COLUMN__LUID);

        return this;

    }

    public FollowUpsDoneContract Hydrate(Cursor cursor) {

        this.CHILDNAME = cursor.getString(cursor.getColumnIndex(singleFollowUpsDone.COLUMN_CHILDNAME));
        this.CHILDID = cursor.getString(cursor.getColumnIndex(singleFollowUpsDone.COLUMN_CHILDID));
        this.FOLLOWUPRND = cursor.getString(cursor.getColumnIndex(singleFollowUpsDone.COLUMN_FOLLOWUPRND));
        this._LUID = cursor.getString(cursor.getColumnIndex(singleFollowUpsDone.COLUMN__LUID));

        return this;
    }

    public Long get_ID() {
        return _ID;
    }

    public void set_ID(Long _ID) {
        this._ID = _ID;
    }

    public String get_LUID() {
        return _LUID;
    }

    public void set_LUID(String _LUID) {
        this._LUID = _LUID;
    }

    public String getCHILDNAME() {
        return CHILDNAME;
    }

    public void setCHILDNAME(String CHILDNAME) {
        this.CHILDNAME = CHILDNAME;
    }


    public String getCHILDID() {
        return CHILDID;
    }

    public void setCHILDID(String CHILDID) {
        this.CHILDID = CHILDID;
    }


    public String getFOLLOWUPRND() {
        return FOLLOWUPRND;
    }

    public void setFOLLOWUPRND(String FOLLOWUPRND) {
        this.FOLLOWUPRND = FOLLOWUPRND;
    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(singleFollowUpsDone._ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(singleFollowUpsDone.COLUMN_CHILDNAME, this.CHILDNAME == null ? JSONObject.NULL : this.CHILDNAME);
        json.put(singleFollowUpsDone.COLUMN_CHILDID, this.CHILDID == null ? JSONObject.NULL : this.CHILDID);
        json.put(singleFollowUpsDone.COLUMN_FOLLOWUPRND, this.FOLLOWUPRND == null ? JSONObject.NULL : this.FOLLOWUPRND);
        json.put(singleFollowUpsDone.COLUMN__LUID, this.FOLLOWUPRND == null ? JSONObject.NULL : this._LUID);
        return json;
    }


    public static abstract class singleFollowUpsDone implements BaseColumns {

        public static final String TABLE_NAME = "followupsdone";
        public static final String _ID = "_id";
        public static final String COLUMN_CHILDID = "fpa00302";
        public static final String COLUMN_FOLLOWUPRND = "fpa00401";
        public static final String COLUMN_CHILDNAME = "fpa002";
        public static final String COLUMN__LUID = "uid";
        public static final String _URI = "fupdone.php";
    }
}
