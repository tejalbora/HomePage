package com.example.homepage;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class topic_view extends AppCompatActivity {
    private static final int REQUEST_PERMISSION_CODE = 123; // You can change the request code as needed.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_view);

        String topicName = getIntent().getStringExtra("subject");
        int topicNumber = getIntent().getIntExtra("topicNumber", 1);
//        WebView webView = findViewById(R.id.topicWebView);
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);  // Enable JavaScript for embedded YouTube videos

        assert topicName != null;
        if (topicName.equals("Data Structures and Algorithms")) {
            String[] topics = {
                    "bfs",
                    "dfs",
                    "avl"
            };
            String[] content = {
                    "\"Breadth-First Search (BFS) is a graph traversal algorithm that systematically explores vertices in layers. It begins at a source vertex, visiting all its neighbors before moving to the next layer.\n\nBFS is particularly useful for finding the shortest path in unweighted graphs, ensuring that shorter paths are discovered before longer ones. This property makes it valuable for applications like navigation and network analysis. BFS employs a queue data structure to maintain the order of exploration, ensuring a first-in-first-out order.\n\nIt's also essential for tasks like topological sorting and connected component analysis. Its simplicity and efficiency make BFS a versatile tool in graph theory and computer science.\n",
                    "\n" +
                            "Depth-first search (DFS) is an algorithm for traversing or searching tree or graph data structures. The algorithm starts at the root node (selecting some arbitrary node as the root node in the case of a graph) and explores as far as possible along each branch before backtracking. \n" +
                            "\n" +
                            "Extra memory, usually a stack, is needed to keep track of the nodes discovered so far along a specified branch which helps in backtracking of the graph.\n\nOne application of Depth-First Search (DFS) is in solving mazes or puzzles, where it can be used to find a path from the start to the goal by exploring all possible routes systematically. DFS is also employed in identifying and navigating hierarchical structures like directories in a file system.",
                    "In computer science, an AVL tree (named after inventors Adelson-Velsky and Landis) is a self-balancing binary search tree. In an AVL tree, the heights of the two child subtrees of any node differ by at most one; if at any time they differ by more than one, rebalancing is done to restore this property. \n\n" +
                            "Lookup, insertion, and deletion all take O(log n) time in both the average and worst cases, where n is the number of nodes in the tree prior to the operation. Insertions and deletions may require the tree to be rebalanced by one or more tree rotations."
            };
            String[] videoUrls = {
                    "https://youtu.be/HZ5YTanv5QE?si=JNPNFlfIYEIR4_Zx",
                    "https://youtu.be/Y40bRyPQQr0?si=l7kGQG5PXm75I_VN",
                    "https://youtu.be/jDM6_TnYIqE?si=xTcfVRk3Cbjzpzz1"
            };
            TextView title = findViewById(R.id.titleTextView);
            title.setText((topics[topicNumber - 1]).toUpperCase());
            String selectedVideoUrl = videoUrls[topicNumber - 1];
//            webView.setWebViewClient(new WebViewClient());
//            webView.loadUrl(selectedVideoUrl);
            TextView contentAboutTopic = findViewById(R.id.textView);
            contentAboutTopic.setText(content[topicNumber - 1]);

            Button downloadButton = findViewById(R.id.downloadButton);
            Button viewRefVid = findViewById(R.id.viewRefVid);

            String[] urls = {
                    "https://drive.google.com/uc?export=download&id=1CQZzTCdCBY0EqY-vGt5xSz8xp-jPQpC0",
                    "https://drive.google.com/uc?export=download&id=1GRt83W-SbYTHqM-6RgrqSU31IwNSumK3",
                    "https://drive.google.com/uc?export=download&id=1_TebdDvaksuqaGHLM1i-fv1RKxll5RZ5"
            };

            viewRefVid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(topic_view.this, ViewRefVid.class);
                    intent.putExtra("url", videoUrls[topicNumber - 1]); // Change this number to select the desired topic
                    startActivity(intent);
                }
            });
            downloadButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openPdfFromDrive(urls[topicNumber - 1]);
//                    downloadPdf();
//                    copyRawFileToLocalStorage();
//                    Intent intent = new Intent(ViewTopicVid.this, ViewPdf.class);
//
//                    intent.putExtra("tN", topics[topicNumber-1]); // Change this number to select the desired topic
//                    startActivity(intent);
//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[topicNumber-1]));
//                    if (intent.resolveActivity(getPackageManager()) != null) {
//                        startActivity(intent);
//                    }
                }
            });


        } else if (topicName.equals("Computer Networking")) {
            String[] topics = {
                    "OSI",
                    "TCP/IP",
                    "Routing Protocols"
            };
            String[] content = {
                    "The Open Systems Interconnection model (OSI model) is a conceptual model from the International Organization for Standardization (ISO) that \"provides a common basis for the coordination of standards development for the purpose of systems interconnection.\" \n\n" +
                            " In the OSI reference model, the communications between systems are split into seven different abstraction layers: Physical, Data Link, Network, Transport, Session, Presentation, and Application.",
                    "The Internet protocol suite, commonly known as TCP/IP, is a framework for organizing the set of communication protocols used in the Internet and similar computer networks according to functional criteria. \n\n" +
                            "The foundational protocols in the suite are the Transmission Control Protocol (TCP), the User Datagram Protocol (UDP), and the Internet Protocol (IP).",
                    "A routing protocol specifies how routers communicate with each other to distribute information that enables them to select paths between nodes on a computer network. \n\n" +
                            "Routers perform the traffic directing functions on the Internet; data packets are forwarded through the networks of the internet from router to router until they reach their destination computer."
            };
            String[] videoUrls = {
                    "https://youtu.be/qBXmbJZQ5rY?si=lf2pYjRQ6C0yb1Tq",
                    "https://youtu.be/PpsEaqJV_A0?si=F3Lq38TWhUMaNIZR",
                    "https://youtu.be/at0jBPXbFqE?si=1g-RB5iNzrgaPNzy"
            };
            TextView title = findViewById(R.id.titleTextView);
            title.setText(topics[topicNumber - 1]);
            String selectedVideoUrl = videoUrls[topicNumber - 1];
//            webView.setWebViewClient(new WebViewClient());
//            webView.loadUrl(selectedVideoUrl);
            TextView contentAboutTopic = findViewById(R.id.textView);
            contentAboutTopic.setText(content[topicNumber - 1]);

            Button downloadButton = findViewById(R.id.downloadButton);
            Button viewRefVid = findViewById(R.id.viewRefVid);
            String[] urls = {
                    "https://drive.google.com/uc?export=download&id=1zSJ5PElfTFBhsuoh0he1sLvdyt-IN4H6",
                    "https://drive.google.com/uc?export=download&id=17ZiUHjC2wdcDjz3xRxeoojiXtFGvMHw-",
                    "https://drive.google.com/uc?export=download&id=1OKCd1jZsntBEyH6ki_gFKJNbW9ctjkBi"
            };
            viewRefVid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(topic_view.this, ViewRefVid.class);
                    intent.putExtra("url", videoUrls[topicNumber - 1]); // Change this number to select the desired topic
                    startActivity(intent);
                }
            });
            downloadButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openPdfFromDrive(urls[topicNumber - 1]);
//                    downloadPdf();
//                    copyRawFileToLocalStorage();
//                    Intent intent = new Intent(ViewTopicVid.this, ViewPdf.class);
//
//                    intent.putExtra("tN", topics[topicNumber-1]); // Change this number to select the desired topic
//                    startActivity(intent);
//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[topicNumber-1]));
//                    if (intent.resolveActivity(getPackageManager()) != null) {
//                        startActivity(intent);
//                    }
                }
            });

        } else if (topicName.equals("Design and Analysis of Algorithms")) {
            String[] topics = {
                    "Backtracking",
                    "Multistage Graph",
                    "Knapsack"
            };
            String[] content = {
                    "Backtracking is a class of algorithms for finding solutions to some computational problems, notably constraint satisfaction problems, that incrementally builds candidates to the solutions, and abandons a candidate (\"backtracks\") as soon as it determines that the candidate cannot possibly be completed to a valid solution.",
                    "Multistage Graph theory is the study of graphs that have multiple levels or stages. The most common type of multistage graph is a tree, which consists of a root node (the starting point) and a series of child nodes (the branches).",
                    "The knapsack problem is the following problem in combinatorial optimization: Given a set of items, each with a weight and a value, determine which items to include in the collection so that the total weight is less than or equal to a given limit and the total value is as large as possible. \n\n" +
                            "It derives its name from the problem faced by someone who is constrained by a fixed-size knapsack and must fill it with the most valuable items. The problem often arises in resource allocation where the decision-makers have to choose from a set of non-divisible projects or tasks under a fixed budget or time constraint, respectively."
            };
            String[] videoUrls = {
                    "https://youtu.be/s7AvT7cGdSo?si=Hy63LEKluvuf1PD0",
                    "https://youtu.be/9iE9Mj4m8jk?si=4FlDWV4MVLfsNqBA",
                    "https://youtu.be/cJ21moQpofY?si=c-S0QphozLWR8ig7"
            };
            TextView title = findViewById(R.id.titleTextView);
            title.setText(topics[topicNumber - 1]);
            String selectedVideoUrl = videoUrls[topicNumber - 1];
//            webView.setWebViewClient(new WebViewClient());
//            webView.loadUrl(selectedVideoUrl);
            TextView contentAboutTopic = findViewById(R.id.textView);
            contentAboutTopic.setText(content[topicNumber - 1]);

            Button downloadButton = findViewById(R.id.downloadButton);
            Button viewRefVid = findViewById(R.id.viewRefVid);
            String[] urls = {
                    "https://drive.google.com/uc?export=download&id=1CVTrlPh-37tGDYJcUX47Mc1LCea00thF",
                    "https://drive.google.com/uc?export=download&id=1rA70yy_CaFfdnbFDT7g-2OARtccQa82A",
                    "https://drive.google.com/uc?export=download&id=1Wq4wxGszl_fucwUikrfXNieXHc4TDJaz"
            };

            viewRefVid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(topic_view.this, ViewRefVid.class);
                    intent.putExtra("url", videoUrls[topicNumber - 1]); // Change this number to select the desired topic
                    startActivity(intent);
                }
            });
            downloadButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openPdfFromDrive(urls[topicNumber - 1]);
//                    downloadPdf();
//                    copyRawFileToLocalStorage();
//                    Intent intent = new Intent(ViewTopicVid.this, ViewPdf.class);
//
//                    intent.putExtra("tN", topics[topicNumber-1]); // Change this number to select the desired topic
//                    startActivity(intent);
//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[topicNumber-1]));
//                    if (intent.resolveActivity(getPackageManager()) != null) {
//                        startActivity(intent);
//                    }
                }
            });

        }
    }

    private void openPdfFromDrive(String pdfDriveUrl) {
        try {
            Uri uri = Uri.parse(pdfDriveUrl);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // Handle the case where no PDF viewer app is installed
            // You can prompt the user to install one or provide an alternative action.
        }
    }
}