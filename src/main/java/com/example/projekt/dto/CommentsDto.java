package com.example.projekt.dto;

public class CommentsDto {

    private int id;

    private String comment;

    private String commentNumber;

    private Engineer author;

    public CommentsDto(int id, String comment, String commentNumber, Engineer author) {
        this.id = id;
        this.comment = comment;
        this.commentNumber = commentNumber;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Engineer getAuthor() {
        return author;
    }

    public void setAuthor(Engineer author) {
        this.author = author;
    }
}
