package com.example.ryan.cultureshock;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ryan on 1/21/2018.
 */

public class CommentList extends ArrayAdapter<CommentData> {
    private Activity context;
    private List<CommentData> commentList;
    public CommentList(Activity context, List<CommentData> commentList){
        super(context, R.layout.fragment_comments_display, commentList);
        this.context = context;
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.fragment_comments_display, null, true);
        TextView textViewComment = (TextView) listViewItem.findViewById(R.id.tvComment);
        TextView textViewPriority = (TextView) listViewItem.findViewById(R.id.tvPriority);

        CommentData commentData = commentList.get(position);

        textViewComment.setText(commentData.getCommentText());
//        textViewPriority.setText(Integer.toString(commentData.getPriority()));
        textViewPriority.setText(commentData.getCommentId());

        return listViewItem;
    }
}
