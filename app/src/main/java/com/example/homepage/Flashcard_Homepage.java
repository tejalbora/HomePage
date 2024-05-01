package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Flashcard_Homepage extends AppCompatActivity {

    Button make, revise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_homepage);

        int ADD_CARD_REQUEST_CODE = 100;
        //make = findViewById(R.id.add_flashcards);
        revise = findViewById(R.id.view_flashcards);

//        make.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(Flashcard_Homepage.this, AddCard.class);
//                startActivityForResult(i, ADD_CARD_REQUEST_CODE);
//                overridePendingTransition(R.anim.right_in, R.anim.left_out);
//            }
//        });
        revise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Flashcard_Homepage.this, FlashcardActivity.class);
                startActivity(i);
            }
        });
    }
}