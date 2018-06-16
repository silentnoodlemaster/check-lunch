package com.silentnoodlemaster.checklunch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAcqua(View v) {
        Intent intent = new Intent(this, ShowCourses.class);
        intent.putExtra("id", "30");
        startActivity(intent);
    }
    public void onExplorer(View v) {
        Intent intent = new Intent(this, ShowCourses.class);
        intent.putExtra("id", "31");
        startActivity(intent);
    }
}
