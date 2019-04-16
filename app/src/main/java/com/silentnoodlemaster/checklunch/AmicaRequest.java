package com.silentnoodlemaster.checklunch;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AmicaRequest extends AsyncTask<String, Void, Amica> {
    private static final String TAG = "AmicaRequest";

    private Amica getRestaurant(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            String restaurantName = jsonObject.getString("RestaurantName");
            JSONArray JSONCourses = jsonObject.getJSONArray("MenusForDays").getJSONObject(0).getJSONArray("SetMenus");
            AmicaCourse[] courses = new AmicaCourse[JSONCourses.length()];
            for (int i = 0; i < JSONCourses.length(); i++) {
                JSONArray course = JSONCourses.getJSONObject(i).getJSONArray("Components");
                StringBuilder courseString = new StringBuilder();
                for (int j = 0; j < course.length(); j++) {
                    courseString.append(course.getString(j));
                    courseString.append("\n");
                }
                courses[i] = new AmicaCourse(courseString.toString().trim());
            }
            return new Amica(restaurantName, courses);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }


        return null;
    }

    @Override
    protected Amica doInBackground(String... strings) {
        StringBuilder jsonString = new StringBuilder();

        try {
            URL url = new URL(strings[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String nextLine;

            while ((nextLine = in.readLine()) != null) {
                jsonString.append(nextLine);
            }

            return getRestaurant(jsonString.toString());
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }

        return null;

    }
}
