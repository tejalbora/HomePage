package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    LinearLayout home, tasks, quiz, notes, learn;
    LinearLayout quiz_view, tasks_view, notes_view, learn_view, flashcards_view;
    ImageView menu;
    RecyclerView mRecyclerview, rvNotes;
    myAdapter adapter;
    Adapter adapter_notes;
    LinearLayoutManager linearLayoutManager;
    List<note> note;
    note_database db;
    Button cn_quiz, daa_quiz, oops_quiz, cn_learn, daa_learn, dsa_learn;
    FirebaseAuth auth;
    TextView textView;
    FirebaseUser user;
    TextView logout;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Model> dataholder = new ArrayList<Model>();

        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvNotes = findViewById(R.id.recyclerViewNotes);
        rvNotes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        drawerLayout = findViewById(R.id.drawer_layout);
        home = findViewById(R.id.home);
        tasks = findViewById(R.id.task);
        quiz = findViewById(R.id.quiz);
        menu = findViewById(R.id.menu);
        notes = findViewById(R.id.notes);
        learn = findViewById(R.id.learn);

        cn_quiz = findViewById(R.id.cn_quiz);
        daa_quiz = findViewById(R.id.daa_quiz);
        oops_quiz = findViewById(R.id.oops_quiz);

        quiz_view = findViewById(R.id.quiz_view);
        tasks_view = findViewById(R.id.tasks_view);
        notes_view = findViewById(R.id.notes_view);
        learn_view = findViewById(R.id.learn_view);
        flashcards_view = findViewById(R.id.flashcards);

        cn_learn = findViewById(R.id.cn_learn);
        dsa_learn = findViewById(R.id.dsa_learn);
        daa_learn = findViewById(R.id.daa_learn);

        auth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.logout);
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        } else {
            textView.setText(user.getEmail());
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("ALERT !!").setMessage("This Will Log You Out of the app. Do you want to continue?").setCancelable(true).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent(MainActivity.this, Login.class);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).setIcon(R.drawable.img_1).show();
            }
        });

        builder = new AlertDialog.Builder(this);
        cn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("ALERT !!").setMessage("This is a Timed Quiz, you will get 30sec for each Question. Do you want to start ?").setCancelable(true).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), Question.class);
                        intent.putExtra("sub", "CN");
                        startActivity(intent);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).setIcon(R.drawable.img_1).show();
            }
        });

        builder = new AlertDialog.Builder(this);
        oops_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("ALERT !!").setMessage("This is a Timed Quiz, you will get 30sec for each Question. Do you want to start ?").setCancelable(true).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), Question.class);
                        intent.putExtra("sub", "OOPS");
                        startActivity(intent);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).setIcon(R.drawable.img_1).show();
            }
        });

        builder = new AlertDialog.Builder(this);
        daa_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("ALERT !!").setMessage("This is a Timed Quiz, you will get 30sec for each Question. Do you want to start ?").setCancelable(true).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), Question.class);
                        intent.putExtra("sub", "DAA");
                        startActivity(intent);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).setIcon(R.drawable.img_1).show();
            }
        });

        db = new note_database(this);
        note = db.getNotes();

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(MainActivity.this, Tasks.class);
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(MainActivity.this, Quiz.class);
            }
        });

        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(MainActivity.this, Notes.class);
            }
        });

        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(MainActivity.this, Learn.class);
            }
        });

        tasks_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(MainActivity.this, Tasks.class);
            }
        });

        quiz_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(MainActivity.this, Quiz.class);
            }
        });

        notes_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(MainActivity.this, Notes.class);
            }
        });

        learn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(MainActivity.this, Learn.class);
            }
        });

        flashcards_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(MainActivity.this, Flashcard_Homepage.class);
            }
        });

        dsa_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start SubjectTopicsActivity with Data Structures and Algorithms and topic 0 (Graphs - BFS)
                Intent intent = new Intent(MainActivity.this, subject_subtopics.class);
                intent.putExtra("subject", "Data Structures and Algorithms");
                intent.putExtra("topicNumber", 1); // Change this number to select the desired topic
                startActivity(intent);
            }
        });

        cn_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start SubjectTopicsActivity with Operating Systems
                Intent intent = new Intent(MainActivity.this, subject_subtopics.class);
                intent.putExtra("subject", "Computer Networking");
                intent.putExtra("topicNumber", 2);
                startActivity(intent);
            }
        });

        daa_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start SubjectTopicsActivity with Data Structures and Algorithms and topic 0 (Graphs - BFS)
                Intent intent = new Intent(MainActivity.this, subject_subtopics.class);
                intent.putExtra("subject", "Design and Analysis of Algorithms");
                intent.putExtra("topicNumber", 3); // Change this number to select the desired topic
                startActivity(intent);
            }
        });

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        Cursor cursor = new dbManager(getApplicationContext()).readallreminders();                  //Cursor To Load data From the database
        while (cursor.moveToNext()) {
            Model model = new Model(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            dataholder.add(model);
        }

        adapter = new myAdapter(dataholder);
        mRecyclerview.setLayoutManager(linearLayoutManager);
        mRecyclerview.setAdapter(adapter);

        rvNotes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapter_notes = new Adapter(this, note);
        rvNotes.setAdapter(adapter_notes);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_menu, menu);
        return true;
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void redirectActivity(Activity activity, Class secondActivity) {
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        //activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }

}