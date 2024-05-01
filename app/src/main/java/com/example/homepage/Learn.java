package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Learn extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        Button dataStructuresButton = findViewById(R.id.dataStructuresButton);
        Button computerNetworkingButton = findViewById(R.id.computerNetworkingButton);
        Button daaButton = findViewById(R.id.daaButton);

        dataStructuresButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start SubjectTopicsActivity with Data Structures and Algorithms and topic 0 (Graphs - BFS)
                Intent intent = new Intent(Learn.this, subject_subtopics.class);
                intent.putExtra("subject", "Data Structures and Algorithms");
                intent.putExtra("topicNumber", 1); // Change this number to select the desired topic
                startActivity(intent);
            }
        });


        computerNetworkingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start SubjectTopicsActivity with Operating Systems
                Intent intent = new Intent(Learn.this, subject_subtopics.class);
                intent.putExtra("subject", "Computer Networking");
                intent.putExtra("topicNumber", 2);
                startActivity(intent);
            }
        });

        daaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start SubjectTopicsActivity with Data Structures and Algorithms and topic 0 (Graphs - BFS)
                Intent intent = new Intent(Learn.this, subject_subtopics.class);
                intent.putExtra("subject", "Design and Analysis of Algorithms");
                intent.putExtra("topicNumber", 3); // Change this number to select the desired topic
                startActivity(intent);
            }
        });
        // Add more button click listeners for other subjects here
    }
}