package com.example.projekt.dto;

public class CommentsCommandDto {


    private String comment;

    private String commentNumber;

    private int userId;

    public CommentsCommandDto(String comment, String commentNumber, int userId) {
        this.comment = comment;
        this.commentNumber = commentNumber;
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(String commentNumber) {
        this.commentNumber = commentNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
