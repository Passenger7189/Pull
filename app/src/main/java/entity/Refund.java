package entity;

public class Refund {
    private Integer refund_id;
    private double refund_total_price;

    public Refund() {
    }

    public Refund(Integer refund_id, double refund_total_price) {
        this.refund_id = refund_id;
        this.refund_total_price = refund_total_price;
    }

    public Integer getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(Integer refund_id) {
        this.refund_id = refund_id;
    }

    public double getRefund_total_price() {
        return refund_total_price;
    }

    public void setRefund_total_price(double refund_total_price) {
        this.refund_total_price = refund_total_price;
    }
}
