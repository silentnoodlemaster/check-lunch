package com.silentnoodlemaster.checklunch;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAcqua(View v) {
        Intent intent = new Intent(this, ShowCourses.class);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd");
        Date date = new Date();
        intent.putExtra("url", "https://www.sodexo.fi/ruokalistat/output/daily_json/30/" + simpleDateFormat.format(date) + "/fi");
        intent.putExtra("restaurant", "sodexo");
        startActivity(intent);
    }
    public void onExplorer(View v) {
        Intent intent = new Intent(this, ShowCourses.class);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd");
        Date date = new Date();
        intent.putExtra("url", "https://www.sodexo.fi/ruokalistat/output/daily_json/31/" + simpleDateFormat.format(date) + "/fi");
        intent.putExtra("restaurant", "sodexo");
        startActivity(intent);
    }

    public void onArcada(View v) {
        Intent intent = new Intent(this, ShowCourses.class);
        intent.putExtra("url", "https://www.fazerfoodco.fi/modules/json/json/Index?costNumber=3003&language=en");
        intent.putExtra("restaurant", "amica");
        startActivity(intent);
    }

}
