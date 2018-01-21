package com.example.ryan.cultureshock;

public class CommentData {
    String commentId;
    String commentText;
    int priority;

    CommentData(){
    }

    public CommentData(String commentId, String commentText) {
        this.commentId = commentId;
        this.commentText = commentText;
        priority = 0;
    }

    public String getCommentId() {
        return commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public int getPriority() {
        return priority;
    }

    public void incPriority(){
        priority++;
    }
    public void decPriority(){
        priority--;
    }
}
