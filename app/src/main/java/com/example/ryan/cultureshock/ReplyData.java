package com.example.ryan.cultureshock;

public class ReplyData {
    String replyId;
    String replyText;
    int priority;

    ReplyData(){
    }

    public ReplyData(String replyData, String commentText) {
        this.replyId = replyData;
        this.replyText = commentText;
        priority = 0;
    }

    public String getReplyId() {
        return replyId;
    }

    public String getReplyText() {
        return replyText;
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
