package entity;

import java.util.Date;

public class BusinessComment {
    private Integer businesscomment_id;
    private String businesscomment_content;
    private double businesscomment_score;
    private Date businessComment_time;

    public BusinessComment() {
    }

    public BusinessComment(Integer businesscomment_id, String businesscomment_content, double businesscomment_score) {
        this.businesscomment_id = businesscomment_id;
        this.businesscomment_content = businesscomment_content;
        this.businesscomment_score = businesscomment_score;
    }

    public BusinessComment(Integer businesscomment_id, String businesscomment_content, double businesscomment_score, Date businessComment_time) {
        this.businesscomment_id = businesscomment_id;
        this.businesscomment_content = businesscomment_content;
        this.businesscomment_score = businesscomment_score;
        this.businessComment_time = businessComment_time;
    }

    public Date getBusinessComment_time() {
        return businessComment_time;
    }

    public void setBusinessComment_time(Date businessComment_time) {
        this.businessComment_time = businessComment_time;
    }

    public Integer getBusinesscomment_id() {
        return businesscomment_id;
    }

    public void setBusinesscomment_id(Integer businesscomment_id) {
        this.businesscomment_id = businesscomment_id;
    }

    public String getBusinesscomment_content() {
        return businesscomment_content;
    }

    public void setBusinesscomment_content(String businesscomment_content) {
        this.businesscomment_content = businesscomment_content;
    }

    public double getBusinesscomment_score() {
        return businesscomment_score;
    }

    public void setBusinesscomment_score(double businesscomment_score) {
        this.businesscomment_score = businesscomment_score;
    }
}
