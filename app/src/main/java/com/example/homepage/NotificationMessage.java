package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NotificationMessage extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_message);
        textView = findViewById(R.id.tv_message);
        Bundle bundle = getIntent().getExtras();                                                    //call the data which is passed by another intent
        textView.setText(bundle.getString("message"));
    }
}