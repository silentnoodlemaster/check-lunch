package com.silentnoodlemaster.checklunch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ShowCourses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_courses);
        String url = getIntent().getStringExtra("url");
        switch (getIntent().getStringExtra("restaurant")) {
            case "sodexo":
                try {
                    Sodexo sodexo = new SodexoRequest().execute(url).get();
                    SodexoCourse[] courses = sodexo.getCourses();
                    TextView tv = findViewById(R.id.restaurantName);
                    tv.setText(sodexo.getRef_title());
                    ListView lv = findViewById(R.id.courses);
                    ArrayAdapter<SodexoCourse> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, courses);
                    lv.setAdapter(adapter);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "amica":
                try {
                    Amica amica = new AmicaRequest().execute(url).get();
                    AmicaCourse[] courses = amica.getCourses();
                    TextView tv = findViewById(R.id.restaurantName);
                    tv.setText(amica.getRestaurantName());
                    ListView lv = findViewById(R.id.courses);
                    ArrayAdapter<AmicaCourse> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, courses);
                    lv.setAdapter(adapter);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
