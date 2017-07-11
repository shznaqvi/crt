package edu.aku.hassannaqvi.cbtfollowup.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import edu.aku.hassannaqvi.cbtfollowup.contracts.ClustersContract;
import edu.aku.hassannaqvi.cbtfollowup.contracts.FormsContract;
import edu.aku.hassannaqvi.cbtfollowup.contracts.FormsContract.FormColumns;
import edu.aku.hassannaqvi.cbtfollowup.contracts.UsersContract;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    /**
     * CREATE STRINGS
     */
    public static final String SQL_CREATE_USERS = "CREATE TABLE " + UsersContract.singleUser.TABLE_NAME + "("
            + UsersContract.singleUser._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersContract.singleUser.ROW_USERNAME + " TEXT,"
            + UsersContract.singleUser.ROW_PASSWORD + " TEXT );";
    private static final String DATABASE_NAME = "mapps_f2.db";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormColumns.TABLE_NAME + "(" +
            FormColumns.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FormColumns.COLUMN_PROJECTNAME + " TEXT," +
            FormColumns.COLUMN_SURVEYTYPE + " TEXT," +
            FormColumns.COLUMN_UID + " TEXT," +
            FormColumns.COLUMN_FORMDATE + " TEXT," +
            FormColumns.COLUMN_USER + " TEXT," +
            FormColumns.COLUMN_DEVICETAGID + " TEXT," +
            FormColumns.COLUMN_CLUSTERCODE + " TEXT," +
            FormColumns.COLUMN_VILLAGEACODE + " TEXT," +
            FormColumns.COLUMN_HOUSEHOLD + " TEXT," +
            FormColumns.COLUMN_ISTATUS + " TEXT," +
            FormColumns.COLUMN_SA + " TEXT," +
            FormColumns.COLUMN_SB + " TEXT," +
            FormColumns.COLUMN_SC + " TEXT," +
            FormColumns.COLUMN_GPSLAT + " TEXT," +
            FormColumns.COLUMN_GPSLNG + " TEXT," +
            FormColumns.COLUMN_GPSTIME + " TEXT," +
            FormColumns.COLUMN_GPSACC + " TEXT," +
            FormColumns.COLUMN_DEVICEID + " TEXT," +
            FormColumns.COLUMN_SYNCED + " TEXT," +
            FormColumns.COLUMN_SYNCED_DATE + " TEXT"
            + " );";


    private static final String SQL_CREATE_CLUSTERS = "CREATE TABLE "
            + ClustersContract.singleCluster.TABLE_NAME + "(" +
            ClustersContract.singleCluster._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ClustersContract.singleCluster.COLUMN_CLUSTERNAME + " TEXT," +
            ClustersContract.singleCluster.COLUMN_CLUSTERCODE + " TEXT" +
            " );";
    /**
     * DELETE STRINGS
     */
    private static final String SQL_DELETE_USERS =
            "DROP TABLE IF EXISTS " + UsersContract.singleUser.TABLE_NAME;

    private static final String SQL_DELETE_CLUSTERS =
            "DROP TABLE IF EXISTS " + ClustersContract.singleCluster.TABLE_NAME;

    private static final String SQL_DELETE_FORMS =
            "DROP TABLE IF EXISTS " + FormsContract.FormColumns.TABLE_NAME;

    private final String TAG = "DatabaseHelper";
    public String spDateT = new SimpleDateFormat("dd-MM-yy").format(new Date().getTime());


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_CLUSTERS);
        db.execSQL(SQL_CREATE_FORMS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_USERS);
        db.execSQL(SQL_DELETE_CLUSTERS);
        db.execSQL(SQL_DELETE_FORMS);
    }

    public void syncUser(JSONArray userlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersContract.singleUser.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = userlist;
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                UsersContract user = new UsersContract();
                user.Sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(UsersContract.singleUser.ROW_USERNAME, user.getUserName());
                values.put(UsersContract.singleUser.ROW_PASSWORD, user.getPassword());
                db.insert(UsersContract.singleUser.TABLE_NAME, null, values);
            }


        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
        } finally {
            db.close();
        }
    }


    public void syncClusters(JSONArray Clusterslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ClustersContract.singleCluster.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = Clusterslist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                ClustersContract cc = new ClustersContract();
                cc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(ClustersContract.singleCluster.COLUMN_CLUSTERCODE, cc.getClusterCode());
                values.put(ClustersContract.singleCluster.COLUMN_CLUSTERNAME, cc.getClusterName());


                db.insert(ClustersContract.singleCluster.TABLE_NAME, null, values);
            }


        } catch (Exception e) {
        } finally {
            db.close();
        }
    }

    public ArrayList<UsersContract> getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<UsersContract> userList = null;
        try {
            userList = new ArrayList<UsersContract>();
            String QUERY = "SELECT * FROM " + UsersContract.singleUser.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    UsersContract user = new UsersContract();
                    user.setId(cursor.getInt(0));
                    user.setUserName(cursor.getString(1));
                    user.setPassword(cursor.getString(2));
                    userList.add(user);
                }
            }

        } catch (Exception e) {
        } finally {
            db.close();
        }
        return userList;
    }

    public boolean Login(String username, String password) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.rawQuery("SELECT * FROM " + UsersContract.singleUser.TABLE_NAME + " WHERE " + UsersContract.singleUser.ROW_USERNAME + "=? AND " + UsersContract.singleUser.ROW_PASSWORD + "=?", new String[]{username, password});

        if (mCursor != null) {
            if (mCursor.getCount() > 0) {
                return true;
            }
        }
        db.close();
        return false;
    }

    public Long addForm(FormsContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormColumns.COLUMN_PROJECTNAME, fc.getProjectName());
        values.put(FormColumns.COLUMN_SURVEYTYPE, fc.getSurveyType());
        //values.put(FormColumns.COLUMN_ID, fc.getID()); // WONT BE SET AT 'INSERT'
        values.put(FormColumns.COLUMN_UID, fc.getUID());
        values.put(FormColumns.COLUMN_FORMDATE, fc.getFormDate());
        values.put(FormColumns.COLUMN_USER, fc.getUser());
        values.put(FormColumns.COLUMN_DEVICETAGID, fc.getDevicetagId());
        values.put(FormColumns.COLUMN_CLUSTERCODE, fc.getClustercode());
        values.put(FormColumns.COLUMN_VILLAGEACODE, fc.getVillageacode());
        values.put(FormColumns.COLUMN_HOUSEHOLD, fc.getHousehold());
        values.put(FormColumns.COLUMN_ISTATUS, fc.getIstatus());
        values.put(FormColumns.COLUMN_SA, fc.getsA());
        values.put(FormColumns.COLUMN_GPSLAT, fc.getGpsLat());
        values.put(FormColumns.COLUMN_GPSLNG, fc.getGpsLng());
        values.put(FormColumns.COLUMN_GPSTIME, fc.getGpsTime());
        values.put(FormColumns.COLUMN_GPSACC, fc.getGpsAcc());
        values.put(FormColumns.COLUMN_DEVICEID, fc.getDeviceID());
        
        /* * * * * NO NEED TO USE THESE IN 'INSERT' * * * * */
        /*
        values.put(FormColumns.COLUMN_SYNCED, fc.getSynced());
        values.put(FormColumns.COLUMN_SYNCED_DATE, fc.getSynced_date());
        */


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormColumns.TABLE_NAME,
                FormColumns.COLUMN_NAME_NULLABLE,
                values);
        db.close();
        return newRowId;
    }

    public void updateSyncedForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormColumns.COLUMN_SYNCED, true);
        values.put(FormColumns.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormColumns._ID + " LIKE ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormColumns.TABLE_NAME,
                values,
                where,
                whereArgs);
        db.close();
    }

    public int updateFormID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormColumns.COLUMN_UID, AppMain.fc.getUID());

// Which row to update, based on the ID
        String selection = FormColumns.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.fc.getID())};

        int count = db.update(FormColumns.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }


    public int updateB() {
        SQLiteDatabase db = this.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FormColumns.COLUMN_SB, AppMain.fc.getsF());

        // Which row to update, based on the ID
        String selection = FormColumns.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.fc.getID())};

        int count = db.update(FormColumns.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateC() {
        SQLiteDatabase db = this.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FormColumns.COLUMN_SC, AppMain.fc.getsF());

        // Which row to update, based on the ID
        String selection = FormColumns.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.fc.getID())};

        int count = db.update(FormColumns.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateD() {
        SQLiteDatabase db = this.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FormColumns.COLUMN_SD, AppMain.fc.getsF());

        // Which row to update, based on the ID
        String selection = FormColumns.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.fc.getID())};

        int count = db.update(FormColumns.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateE() {
        SQLiteDatabase db = this.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FormColumns.COLUMN_SE, AppMain.fc.getsF());

        // Which row to update, based on the ID
        String selection = FormColumns.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.fc.getID())};

        int count = db.update(FormColumns.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateF() {
        SQLiteDatabase db = this.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FormColumns.COLUMN_SF, AppMain.fc.getsF());

        // Which row to update, based on the ID
        String selection = FormColumns.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.fc.getID())};

        int count = db.update(FormColumns.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateG() {
        SQLiteDatabase db = this.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FormColumns.COLUMN_SG, AppMain.fc.getsF());

        // Which row to update, based on the ID
        String selection = FormColumns.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.fc.getID())};

        int count = db.update(FormColumns.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateH() {
        SQLiteDatabase db = this.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FormColumns.COLUMN_SH, AppMain.fc.getsF());

        // Which row to update, based on the ID
        String selection = FormColumns.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.fc.getID())};

        int count = db.update(FormColumns.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }



    public Collection<ClustersContract> getAllClusters() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ClustersContract.singleCluster.COLUMN_CLUSTERCODE,
                ClustersContract.singleCluster.COLUMN_CLUSTERNAME,
                ClustersContract.singleCluster._ID,
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                ClustersContract.singleCluster._ID + " ASC";

        Collection<ClustersContract> allCC = new ArrayList<>();
        try {
            c = db.query(
                    ClustersContract.singleCluster.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ClustersContract cc = new ClustersContract();
                allCC.add(cc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allCC;
    }


    public Collection<FormsContract> getAllForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormColumns.COLUMN_PROJECTNAME,
                FormColumns.COLUMN_SURVEYTYPE,
                FormColumns.COLUMN_ID,
                FormColumns.COLUMN_UID,
                FormColumns.COLUMN_FORMDATE,
                FormColumns.COLUMN_USER,
                FormColumns.COLUMN_DEVICETAGID,
                FormColumns.COLUMN_CLUSTERCODE,
                FormColumns.COLUMN_VILLAGEACODE,
                FormColumns.COLUMN_HOUSEHOLD,
                FormColumns.COLUMN_ISTATUS,
                FormColumns.COLUMN_SA,
                FormColumns.COLUMN_SB,
                FormColumns.COLUMN_SC,
                FormColumns.COLUMN_GPSLAT,
                FormColumns.COLUMN_GPSLNG,
                FormColumns.COLUMN_GPSTIME,
                FormColumns.COLUMN_GPSACC,
                FormColumns.COLUMN_DEVICEID,
                FormColumns.COLUMN_SYNCED,
                FormColumns.COLUMN_SYNCED_DATE,
        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormColumns._ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormColumns.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public Collection<FormsContract> getTodayForms() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsContract.FormColumns._ID,
                FormColumns.COLUMN_CLUSTERCODE,
                FormColumns.COLUMN_VILLAGEACODE,
                FormColumns.COLUMN_HOUSEHOLD,
        };

        String whereClause = FormColumns.COLUMN_CLUSTERCODE + " LIKE ?";
        String[] whereArgs = {spDateT};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormColumns._ID + " ASC";

        Collection<FormsContract> formList = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormColumns.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                formList.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }


        // return contact list
        return formList;
    }

    // ANDROID DATABASE MANAGER
    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }
}