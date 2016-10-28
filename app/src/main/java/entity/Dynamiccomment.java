package entity;

import java.sql.Timestamp;

public class Dynamiccomment {
    private Integer dynamicCommentId;
    private String dynamicCommentContent;
    private Timestamp dynamicCommentTime;
    private boolean commentIsEnd; // isEnd 表示是不是 最后一级的评论
    private int fatherId; // fatherId 对应的都是isEnd为false的commentId

    private Dynamic dynamic;
    private User user;

    public Dynamiccomment() {
        super();
    }

    public Dynamiccomment(Integer dynamicCommentId,
                          String dynamicCommentContent, Timestamp dynamicCommentTime,
                          boolean commentIsEnd, int fatherId, Dynamic dynamic, User user) {
        super();
        this.dynamicCommentId = dynamicCommentId;
        this.dynamicCommentContent = dynamicCommentContent;
        this.dynamicCommentTime = dynamicCommentTime;
        this.commentIsEnd = commentIsEnd;
        this.fatherId = fatherId;
        this.dynamic = dynamic;
        this.user = user;
    }

    public Integer getDynamicCommentId() {
        return dynamicCommentId;
    }

    public void setDynamicCommentId(Integer dynamicCommentId) {
        this.dynamicCommentId = dynamicCommentId;
    }

    public String getDynamicCommentContent() {
        return dynamicCommentContent;
    }

    public void setDynamicCommentContent(String dynamicCommentContent) {
        this.dynamicCommentContent = dynamicCommentContent;
    }

    public Timestamp getDynamicCommentTime() {
        return dynamicCommentTime;
    }

    public void setDynamicCommentTime(Timestamp dynamicCommentTime) {
        this.dynamicCommentTime = dynamicCommentTime;
    }

    public boolean isCommentIsEnd() {
        return commentIsEnd;
    }

    public void setCommentIsEnd(boolean commentIsEnd) {
        this.commentIsEnd = commentIsEnd;
    }

    public int getFatherId() {
        return fatherId;
    }

    public void setFatherId(int fatherId) {
        this.fatherId = fatherId;
    }

    public Dynamic getDynamic() {
        return dynamic;
    }

    public void setDynamic(Dynamic dynamic) {
        this.dynamic = dynamic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
