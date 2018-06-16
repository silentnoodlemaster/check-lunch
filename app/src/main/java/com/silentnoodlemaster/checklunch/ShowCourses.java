package com.silentnoodlemaster.checklunch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowCourses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_courses);
        String id = getIntent().getStringExtra("id");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/mm/dd");
        String url = "https://www.sodexo.fi/ruokalistat/output/daily_json/" + id + "/" + simpleDateFormat.format(date) + "/fi";
        try {
            Restaurant restaurant = new RestaurantRequest().execute(url).get();
            Course[] courses = restaurant.getCourses();
            TextView tv = findViewById(R.id.restaurantName);
            tv.setText(restaurant.getRef_title());
            ListView lv = findViewById(R.id.courses);
            ArrayAdapter<Course> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, courses);
            lv.setAdapter(adapter);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
