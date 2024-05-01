package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.os.CountDownTimer;

public class Question extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;
    String[] questions;
    String[] answers;
    String[] opt;
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        final TextView score = (TextView) findViewById(R.id.textView4);
        TextView textView = (TextView) findViewById(R.id.subanme);
        Intent intent = getIntent();
        String name = intent.getStringExtra("sub");
        textView.setText(name);

        if (name.equals("OOPS")) {
            questions = new String[]{
                    "Which method can be defined only once in a program?",
                    "Which of these is not a bitwise operator?",
                    "Which keyword is used by method to refer to the object that invoked it?",
                    "Which of these keywords is used to define interfaces in Java?",
                    "Which of these access specifiers can be used for an interface?",
                    "Which of the following is correct way of importing an entire package ‘pkg’?",
                    "What is the return type of Constructors?",
                    "Which of the following package stores all the standard java classes?",
                    "Which of these method of class String is used to compare two String objects for their equality?",
                    "An expression involving byte, int, & literal numbers is promoted to which of these?"};
            answers = new String[]{"main method", "<=", "this", "interface", "public", "import pkg.*", "None of the mentioned", "java", "equals()", "int"};
            opt = new String[]{
                    "finalize method", "main method", "static method", "private method",
                    "&", "&=", "|=", "<=",
                    "import", "this", "catch", "abstract",
                    "Interface", "interface", "intf", "Intf",
                    "public", "protected", "private", "All of the mentioned",
                    "Import pkg.", "import pkg.*", "Import pkg.*", "import pkg.",
                    "int", "float", "void", "None of the mentioned",
                    "lang", "java", "util", "java.packages",
                    "equals()", "Equals()", "isequal()", "Isequal()",
                    "int", "long", "byte", "float"};
        } else if (name.equals("CN")) {
            questions = new String[]{
                    "What is the main function of a router?",
                    "Which protocol is responsible for dynamically assigning IP addresses in a network?",
                    "Which of the following protocols is used for sending and receiving emails?",
                    "What type of address does ARP (Address Resolution Protocol) resolve to a physical address?",
                    "What process occurs at the Network layer (Layer 3) of the OSI model?",
                    "Which model is commonly used to understand and describe networking protocols and services?",
                    "What term refers to the data transfer capacity of a network?",
                    "Which network device is used to protect a network from unauthorized access while allowing legitimate traffic?",
                    "What is the smallest unit of data that can be transmitted over a network?",
                    "Which protocol is used for diagnosing network connectivity issues and network errors?"
            };
            answers = new String[]{"How does a hub operate?", "DHCP", "POP3/SMTP", "IP address", "Routing",
                    "TCP/IP Model", "Bandwidth", "Firewall", "Frame", "ICMP"
            };

            opt = new String[]{
                    "What is the main function of a router?",
                    "How does a hub operate?",
                    "Explain DNS resolution.",
                    "What is the purpose of a modem?",
                    "TCP/IP", "FTP", "DHCP", "IPX/SPX",
                    "HTTP/HTTPS", "UDP", "POP3/SMTP", "TCP/IP",
                    "MAC address", "IP address", "DNS name", "Subnet mask",
                    "Switching", "Routing", "Flooding", "Error checking",
                    "OSI Model", "TCP/IP Model", "FTP Model", "HTTP Model",
                    "Bandwidth", "Latency", "Protocol", "DNS",
                    "Firewall", "Hub", "Bridge", "Modem",
                    "Packet", "Segment", "Frame", "Byte",
                    "ICMP", "UDP", "IPX", "FTP"
            };
        } else {
            questions = new String[]{
                    "What is the primary goal of algorithm analysis?",
                    "Which notation represents the upper bound of an algorithm's time complexity?",
                    "What does 'NP' stand for in the context of algorithm complexity?",
                    "What is the primary advantage of dynamic programming in algorithm design?",
                    "Which sorting algorithm has a worst-case time complexity of O(n log n)?",
                    "What does 'DFS' stand for in graph traversal algorithms?",
                    "What is the time complexity of the quicksort algorithm in its average case?",
                    "In the context of data structures, what is a 'priority queue'?",
                    "What is the main purpose of the Bellman-Ford algorithm?",
                    "What is the concept of 'greedy algorithms' in algorithm design?"
            };
            opt = new String[]{
                    "To design algorithms", "To evaluate algorithm performance", "To develop software applications", "To study data structures",
                    "Big O notation", "Big Theta notation", "Big Omega notation", "Little o notation",
                    "Non-Polynomial", "Non-Predictable", "No Problem", "None of the above",
                    "Efficient memory usage", "Simplicity and ease of implementation", "Improved execution time", "Guaranteed optimality",
                    "Bubble Sort", "Quick Sort", "Insertion Sort", "Selection Sort",
                    "Depth-First Search", "Depth-First Sorting", "Data File Search", "Data Flow Sequence",
                    "O(n)", "O(n^2)", "O(n log n)", "O(log n)",
                    "A list of tasks to be executed", "A data structure for storing elements with associated priorities", "A scheduling algorithm for CPU management", "A data structure for hashing",
                    "Finding the shortest path in a weighted graph", "Sorting a list of elements", "Solving Sudoku puzzles", "Simulating a queue",
                    "A type of sorting algorithm", "A class of algorithms that make locally optimal choices", "An algorithm design technique based on recursion", "A data structure for tree traversal"
            };
            answers = new String[]{
                    "To evaluate algorithm performance", "Big O notation", "Non-Polynomial", "Improved execution time", "Quick Sort", "Depth-First Search", "O(n log n)",
                    "A data structure for storing elements with associated priorities", "Finding the shortest path in a weighted graph", "A class of algorithms that make locally optimal choices"
            };
        }

        submitbutton = (Button) findViewById(R.id.button3);
        quitbutton = (Button) findViewById(R.id.buttonquit);
        tv = (TextView) findViewById(R.id.tvque);

        radio_g = (RadioGroup) findViewById(R.id.answersgrp);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        final TextView timertextView = (TextView) findViewById(R.id.timertextView);

        timer = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                int secondsRemaining = (int) (millisUntilFinished / 1000);
                timertextView.setText("Time Left: " + secondsRemaining + "s");
            }

            public void onFinish() {
                submitbutton.performClick();
            }
        };
        timer.start();
        setQuestionAndOptions();

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (radio_g.getCheckedRadioButtonId() != -1) {
                    RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                    String ansText = uans.getText().toString();
                    if (ansText.equals(answers[flag])) {
                        correct++;
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    } else {
                        wrong++;
                        Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    }
                }
                flag++;
                if (score != null)
                    score.setText("" + correct);
                if (flag < questions.length) {
                    setQuestionAndOptions();
                    timer.cancel();
                    timer.start();
                } else {
                    marks = correct;
                    Intent in = new Intent(getApplicationContext(), Result.class);
                    startActivity(in);
                    finish();
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Result.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void setQuestionAndOptions() {
        tv.setText(questions[flag]);
        rb1.setText(opt[flag * 4]);
        rb2.setText(opt[flag * 4 + 1]);
        rb3.setText(opt[flag * 4 + 2]);
        rb4.setText(opt[flag * 4 + 3]);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }
}