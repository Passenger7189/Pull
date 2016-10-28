package entity;

import java.sql.Timestamp;
import java.util.List;

public class Order {
	private Integer orderId;
	private Integer orderStateId;
	private Timestamp orderCreateTime;

	private String orderDescribe;// 用户给卖家的

	private double orderTotalPrice;

	private List<Refund> refunds;

	public Order() {
	}

	public Order(Integer orderId, Integer orderStateId,
			Timestamp orderCreateTime, String orderDescribe,
			double orderTotalPrice, List<Refund> refunds) {
		super();
		this.orderId = orderId;
		this.orderStateId = orderStateId;
		this.orderCreateTime = orderCreateTime;
		this.orderDescribe = orderDescribe;
		this.orderTotalPrice = orderTotalPrice;
		this.refunds = refunds;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderStateId() {
		return orderStateId;
	}

	public void setOrderStateId(Integer orderStateId) {
		this.orderStateId = orderStateId;
	}

	public Timestamp getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(Timestamp orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public String getOrderDescribe() {
		return orderDescribe;
	}

	public void setOrderDescribe(String orderDescribe) {
		this.orderDescribe = orderDescribe;
	}

	public double getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public List<Refund> getRefunds() {
		return refunds;
	}

	public void setRefunds(List<Refund> refunds) {
		this.refunds = refunds;
	}

}