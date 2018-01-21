package com.example.ryan.cultureshock;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Comments extends Fragment implements View.OnClickListener {

    EditText commentText;
    Button submitBtn;
    View v;
    ListView listViewComment;
    List<CommentData> commentDataList;

    DatabaseReference databaseComments;

    public Comments() {
        // Required empty public constructor
    }

    ImageView thumbsUp;
    ImageView thumbsDown;
    View commentList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_comments, container, false);
        commentList = inflater.inflate(R.layout.fragment_comments_display, container, false);
        databaseComments = FirebaseDatabase.getInstance().getReference("comments");

        commentText = (EditText) v.findViewById(R.id.commentText);
        submitBtn = (Button) v.findViewById(R.id.submitBtn);

        listViewComment = (ListView) v.findViewById(R.id.listViewComment);
        commentDataList = new ArrayList<>();

        submitBtn.setOnClickListener(this);

        listViewComment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            CommentData commentData;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                commentData = commentDataList.get(i);
                thumbsUp= (ImageView) commentList.findViewById(R.id.thumbsUp);
                thumbsDown = (ImageView) commentList.findViewById(R.id.thumbsDown);
                thumbsUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        commentData.incPriority();
                    }
                });
                thumbsDown.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        commentData.decPriority();
                    }
                });
            }
        });

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        databaseComments.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                commentDataList.clear();
                for(DataSnapshot commentSnapshot: dataSnapshot.getChildren()){
                    CommentData commentData = commentSnapshot.getValue(CommentData.class);
                    commentDataList.add(commentData);
                }
                CommentList adapter = new CommentList(getActivity(), commentDataList);
                listViewComment.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.submitBtn:
                addComment();
                break;
            default:
                break;

        }
    }
    private void addComment(){
        String comment = commentText.getText().toString().trim();
        if(!TextUtils.isEmpty(comment)){
            String id = databaseComments.push().getKey();
            CommentData commentData = new CommentData(id, comment);
            databaseComments.child(id).setValue(commentData);
            Toast.makeText(getActivity(), "Data submitted", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(getActivity(), "Please enter something", Toast.LENGTH_LONG).show();
        }
    }

}
