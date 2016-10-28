package entity;

/**
 * Created by Rocking on 2016/9/24.
 */

import java.util.List;

public class Business {
    private Integer business_id;    //商家编号
    private String business_name;   //商家名称
    private String business_address;    //商家地址
    private String business_callnumber; //商家电话
    private double business_score;  //商家评分
    private String business_brief;  //商家简介
    private String business_picture;  // 商家图片地址


    private List<BusinessComment> businesscomments;     // 商家的评论集合
    private List<Coach> coachs; // 商家的教练
    private List<Goods> goodses;     // 商家的商品
    private List<Order> orders; //那个商家的订单
    private List<Collect> collects; // 商家可能被多个用户收藏

    public Business() {

    }

    public Business(Integer business_id, String business_name, String business_address, String business_callnumber, double business_score, String business_brief, String business_picture, List<BusinessComment> businesscomments, List<Coach> coachs, List<Goods> goodses, List<Order> orders, List<Collect> collects) {
        this.business_id = business_id;
        this.business_name = business_name;
        this.business_address = business_address;
        this.business_callnumber = business_callnumber;
        this.business_score = business_score;
        this.business_brief = business_brief;
        this.business_picture = business_picture;
        this.businesscomments = businesscomments;
        this.coachs = coachs;
        this.goodses = goodses;
        this.orders = orders;
        this.collects = collects;
    }

    public Business(Integer business_id, String business_name, String business_address, String business_callnumber,
                    double business_score, String business_brief, String business_picture) {
        this.business_id = business_id;
        this.business_name = business_name;
        this.business_address = business_address;
        this.business_callnumber = business_callnumber;
        this.business_score = business_score;
        this.business_brief = business_brief;
        this.business_picture = business_picture;
    }

    public Integer getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(Integer business_id) {
        this.business_id = business_id;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getBusiness_address() {
        return business_address;
    }

    public void setBusiness_address(String business_address) {
        this.business_address = business_address;
    }

    public String getBusiness_callnumber() {
        return business_callnumber;
    }

    public void setBusiness_callnumber(String business_callnumber) {
        this.business_callnumber = business_callnumber;
    }

    public double getBusiness_score() {
        return business_score;
    }

    public void setBusiness_score(double business_score) {
        this.business_score = business_score;
    }

    public String getBusiness_brief() {
        return business_brief;
    }

    public void setBusiness_brief(String business_brief) {
        this.business_brief = business_brief;
    }

    public String getBusiness_picture() {
        return business_picture;
    }

    public void setBusiness_picture(String business_picture) {
        this.business_picture = business_picture;
    }

    public List<BusinessComment> getBusinesscomments() {
        return businesscomments;
    }

    public void setBusinesscomments(List<BusinessComment> businesscomments) {
        this.businesscomments = businesscomments;
    }

    public List<Coach> getCoachs() {
        return coachs;
    }

    public void setCoachs(List<Coach> coachs) {
        this.coachs = coachs;
    }

    public List<Goods> getGoodses() {
        return goodses;
    }

    public void setGoodses(List<Goods> goodses) {
        this.goodses = goodses;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Collect> getCollects() {
        return collects;
    }

    public void setCollects(List<Collect> collects) {
        this.collects = collects;
    }
}

