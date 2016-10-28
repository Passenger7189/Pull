package entity;

import java.sql.Timestamp;

public class Goods {
    private Integer goods_id;
    private String goods_name;// 其中包括了开始时间和结束时间
    private double goods_price;
    private Integer goods_repertory;    // 商品库存
    private String goods_refundcaption;    // 商品退款说明
    private String goods_describe;
    private String goods_imageUrl;
    private Timestamp startTime;
    private Timestamp endTime;


    // 商品表和教练表是分开的，商品中并没有教练，只是订单中可能会有
//	private Coach coach;
    // 发布商品的时候 需要发布教练 那么需要展示这个教练所有信息
    // 外键不是来做实体类的字段的
//	private Integer business_id;

    public Goods() {
    }

    public Goods(Integer goods_id, String goods_name, double goods_price,
                 Integer goods_repertory, String goods_refundcaption,
                 String goods_describe, String goods_imageUrl, Timestamp startTime,
                 Timestamp endTime) {
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_price = goods_price;
        this.goods_repertory = goods_repertory;
        this.goods_refundcaption = goods_refundcaption;
        this.goods_describe = goods_describe;
        this.goods_imageUrl = goods_imageUrl;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_refundcaption() {
        return goods_refundcaption;
    }

    public void setGoods_refundcaption(String goods_refundcaption) {
        this.goods_refundcaption = goods_refundcaption;
    }

    public String getGoods_describe() {
        return goods_describe;
    }

    public void setGoods_describe(String goods_describe) {
        this.goods_describe = goods_describe;
    }

    public Integer getGoods_repertory() {
        return goods_repertory;
    }

    public void setGoods_repertory(Integer goods_repertory) {
        this.goods_repertory = goods_repertory;
    }

    public String getGoods_imageUrl() {
        return goods_imageUrl;
    }

    public void setGoods_imageUrl(String goods_imageUrl) {
        this.goods_imageUrl = goods_imageUrl;
    }
}
