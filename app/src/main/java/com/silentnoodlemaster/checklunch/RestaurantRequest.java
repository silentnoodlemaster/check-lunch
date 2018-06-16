package com.silentnoodlemaster.checklunch;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestaurantRequest extends AsyncTask<String, Void, Restaurant> {
    private static final String TAG = "RestaurantRequest";

    private Restaurant getRestaurant(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            String ref_title = jsonObject.getJSONObject("meta").getString("ref_title");
            JSONArray JSONCourses = jsonObject.getJSONArray("courses");
            Course[] courses = new Course[JSONCourses.length()];
            for (int i = 0; i < JSONCourses.length(); i++) {
                JSONObject course = JSONCourses.getJSONObject(i);
                courses[i] = new Course(
                        course.getString("title_fi"),
                        course.getString("title_en"),
                        course.has("category")? course.getString("category"): "",
                        course.getString("price"),
                        course.has("properties")? course.getString("properties"): "",
                        course.getString("desc_fi"),
                        course.getString("desc_en"),
                        course.getString("desc_se")
                );
            }
            return new Restaurant(ref_title,courses);
        }

        catch (Exception e)
        {
            Log.e(TAG, e.getMessage());
        }


        return null;
    }
    @Override
    protected Restaurant doInBackground(String... strings) {
        StringBuilder jsonString = new StringBuilder();

        try
        {
            URL url = new URL(strings[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String nextLine;

            while((nextLine = in.readLine()) != null)
            {
                jsonString.append(nextLine);
            }

            return getRestaurant(jsonString.toString());
        }

        catch (Exception e)
        {
            Log.e(TAG, e.getMessage());
        }

        return null;

    }
}
