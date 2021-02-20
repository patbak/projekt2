package com.example.projekt.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private int idComment;

    @Column(name = "comment_number")
    private String commentNumber;

    @Column(name = "comment")
    private String text;

    @ManyToOne
    @JoinColumn(name = "building_daily_reports_id_building_daily_report")
    private BuildingDailyReports buildingDailyReports;

    @ManyToOne
    @JoinColumn(name = "users_id_user")
    private User user;

    public Comment() {
    }

    public Comment(String commentNumber, String text, BuildingDailyReports buildingDailyReports, User user) {
        this.commentNumber = commentNumber;
        this.text = text;
        this.buildingDailyReports = buildingDailyReports;
        this.user = user;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public String getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(String commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BuildingDailyReports getBuildingDailyReports() {
        return buildingDailyReports;
    }

    public void setBuildingDailyReports(BuildingDailyReports buildingDailyReports) {
        this.buildingDailyReports = buildingDailyReports;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
