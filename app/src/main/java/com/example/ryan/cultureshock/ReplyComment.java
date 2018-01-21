package com.example.ryan.cultureshock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class ReplyComment extends AppCompatActivity {

    EditText replyText;
    Button submitBtn;
    ListView listViewReply;
    List<CommentData> commentDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_comment);

        replyText = (EditText) findViewById(R.id.replyText);
        submitBtn = (Button) findViewById(R.id.submitBtn);
        listViewReply = (ListView) findViewById(R.id.listViewComment);

//        Intent intent = getIntent();
//        String id = intent.get

    }
}
