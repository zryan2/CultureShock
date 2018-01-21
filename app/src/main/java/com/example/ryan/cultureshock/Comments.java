package com.example.ryan.cultureshock;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class Comments extends Fragment implements View.OnClickListener {

    EditText commentText;
    Button submitBtn;
    View v;
    DatabaseReference databaseComments;

    public Comments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_comments, container, false);
        databaseComments = FirebaseDatabase.getInstance().getReference("comments");

        commentText = (EditText) v.findViewById(R.id.commentText);
        submitBtn = (Button) v.findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(this);
//        submitBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
////                addComment();
//            }
//        });
        return v;
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.submitBtn :
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
