package edu.aku.hassannaqvi.cbtfollowup.get;

/**
 * Created by ali.azaz on 7/14/2017.
 */

public class GetFollowUps {/*extends AsyncTask<String, String, String>{
    
    private final String TAG = "GetFollowUps()";
    HttpURLConnection urlConnection;
    private Context mContext;
    private ProgressDialog pd;

    public GetFollowUps(Context context) {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setTitle("Syncing FollowUps");
        pd.setMessage("Getting connected to server...");
        pd.show();

    }

    @Override
    protected String doInBackground(String... args) {

        StringBuilder result = new StringBuilder();

        URL url = null;
        try {
            url = new URL(AppMain._HOST_URL + FollowUpsContract.singleFollowUps._URI);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000  *//* milliseconds *//*);
            urlConnection.setConnectTimeout(15000  *//* milliseconds *//*);
            Log.d(TAG, "doInBackground: " + urlConnection.getResponseCode());
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = reader.readLine()) != null) {
                    Log.i(TAG, "FollowUps In: " + line);
                    result.append(line);
                }
            }
        } catch (java.net.SocketTimeoutException e) {
            return null;
        } catch (java.io.IOException e) {
            return null;
        } finally {
            urlConnection.disconnect();
        }


        return result.toString();
    }

    @Override
    protected void onPostExecute(String result) {

        //Do something with the JSON string

        if (result != null) {
            String json = result;
            //json = json.replaceAll("\\[", "").replaceAll("\\]","");

            if (json.length() > 0) {
                ArrayList<FollowUpsContract> FollowUpsArrayList;
                DatabaseHelper db = new DatabaseHelper(mContext);
                try {
                    FollowUpsArrayList = new ArrayList<FollowUpsContract>();
                    //JSONObject jsonObject = new JSONObject(json);
                    JSONArray jsonArray = new JSONArray(json);
                    //   db.syncFollowUps(jsonArray);
                    pd.setMessage("Received: " + jsonArray.length());
                    pd.show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //db.getAllFollowUps();
            } else {
                pd.setMessage("Received: " + json.length() + "");
                pd.show();
            }
        } else {
            pd.setTitle("Connection Error");
            pd.setMessage("Server not found!");
            pd.show();
        }
    }*/

}
