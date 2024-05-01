package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteTask extends AppCompatActivity {
    ArrayList<Model> dataholder = new ArrayList<Model>();
    Button delete;
    EditText id;
    myAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_task);

        delete = findViewById(R.id.btnDelete);
        id = findViewById(R.id.editTitleDelete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = id.getText().toString().trim();                                 //access the time form the choose time button

                if (title.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter Task ID", Toast.LENGTH_SHORT).show();   //shows the toast if input field is empty
                } else {
                        processDelete(id.getText().toString());
                    }
            }
        });
    }

    private void processDelete(String id_delete) {
        String result = new dbManager(this).deleteReminder(id_delete);                                                                //calls the set alarm method to set alarm
        id.setText("");
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
        adapter.dataholder.remove(id.getText());
        adapter.dataholder.notify();
        finish();
    }
}