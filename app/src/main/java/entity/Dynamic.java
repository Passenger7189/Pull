package entity;

import java.sql.Timestamp;
import java.util.List;

public class Dynamic {

    private Integer dynamic_id;
    private String dynamic_text;
    private String dynamic_picture;
    private boolean dynamicIsTransmit; // 是否是转发的动态
    private String transmitContent;     // 转发的文本内容
    private int dynamicTansmitFather; // 转发的动态ID
    private Timestamp dynamic_publish_time;
    private String dynamic_address;
    private boolean dynamicIsShowAddress;

    private User user;
    private List<Dynamiccomment> dynamiccomments; // 一个动态对应多条评论
    private List<Dynamiclike> dynamiclikes;// 一个动态应该有个N个人点赞 所以用一个集合

    public Dynamic() {

    }

    public Dynamic(Integer dynamic_id, String dynamic_text, String dynamic_picture, boolean dynamicIsTransmit,
                   String transmitContent, int dynamicTansmitFather, Timestamp dynamic_publish_time, String dynamic_address, boolean dynamicIsShowAddress, User user, List<Dynamiccomment> dynamiccomments, List<Dynamiclike> dynamiclikes) {
        this.dynamic_id = dynamic_id;
        this.dynamic_text = dynamic_text;
        this.dynamic_picture = dynamic_picture;
        this.dynamicIsTransmit = dynamicIsTransmit;
        this.transmitContent = transmitContent;
        this.dynamicTansmitFather = dynamicTansmitFather;
        this.dynamic_publish_time = dynamic_publish_time;
        this.dynamic_address = dynamic_address;
        this.dynamicIsShowAddress = dynamicIsShowAddress;
        this.user = user;
        this.dynamiccomments = dynamiccomments;
        this.dynamiclikes = dynamiclikes;
    }

    //    dyncfabuEdT.getText().toString(), picture, false, null, null, new Timestamp(System.currentTimeMillis()),
//    address, isShowAddress, user.     发布动态要用到的构造方法
    public Dynamic(String dynamic_text, String dynamic_picture, boolean dynamicIsTransmit, Timestamp dynamic_publish_time,
                   String dynamic_address, boolean dynamicIsShowAddress, User user) {

        this.dynamic_text = dynamic_text;
        this.dynamic_picture = dynamic_picture;
        this.dynamicIsTransmit = dynamicIsTransmit;
        this.dynamic_publish_time = dynamic_publish_time;
        this.dynamic_address = dynamic_address;
        this.dynamicIsShowAddress = dynamicIsShowAddress;
        this.user = user;
    }

    public Integer getDynamic_id() {
        return dynamic_id;
    }

    public void setDynamic_id(Integer dynamic_id) {
        this.dynamic_id = dynamic_id;
    }

    public String getDynamic_text() {
        return dynamic_text;
    }

    public void setDynamic_text(String dynamic_text) {
        this.dynamic_text = dynamic_text;
    }

    public String getDynamic_picture() {
        return dynamic_picture;
    }

    public void setDynamic_picture(String dynamic_picture) {
        this.dynamic_picture = dynamic_picture;
    }

    public boolean getDynamicIsTransmit() {
        return dynamicIsTransmit;
    }

    public void setDynamicIsTransmit(boolean dynamicIsTransmit) {
        this.dynamicIsTransmit = dynamicIsTransmit;
    }

    public String getTransmitContent() {
        return transmitContent;
    }

    public void setTransmitContent(String transmitContent) {
        this.transmitContent = transmitContent;
    }

    public int getDynamicTansmitFather() {
        return dynamicTansmitFather;
    }

    public void setDynamicTansmitFather(int dynamicTansmitFather) {
        this.dynamicTansmitFather = dynamicTansmitFather;
    }

    public Timestamp getDynamic_publish_time() {
        return dynamic_publish_time;
    }

    public void setDynamic_publish_time(Timestamp dynamic_publish_time) {
        this.dynamic_publish_time = dynamic_publish_time;
    }

    public String getDynamic_address() {
        return dynamic_address;
    }

    public void setDynamic_address(String dynamic_address) {
        this.dynamic_address = dynamic_address;
    }

    public boolean getDynamicIsShowAddress() {
        return dynamicIsShowAddress;
    }

    public void setDynamicIsShowAddress(boolean dynamicIsShowAddress) {
        this.dynamicIsShowAddress = dynamicIsShowAddress;
    }

    public List<Dynamiccomment> getDynamiccomments() {
        return dynamiccomments;
    }

    public void setDynamiccomments(List<Dynamiccomment> dynamiccomments) {
        this.dynamiccomments = dynamiccomments;
    }

    public List<Dynamiclike> getDynamiclikes() {
        return dynamiclikes;
    }

    public void setDynamiclikes(List<Dynamiclike> dynamiclikes) {
        this.dynamiclikes = dynamiclikes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}