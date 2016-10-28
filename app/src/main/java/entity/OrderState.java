package entity;

import java.util.List;

public class OrderState {
	private Integer orderStateId;
	private String orderStateType;

	private List<Refund> refunds;

	public OrderState() {
	}

	public OrderState(Integer orderStateId, String orderStateType,
			List<Refund> refunds) {
		super();
		this.orderStateId = orderStateId;
		this.orderStateType = orderStateType;
		this.refunds = refunds;
	}

	public Integer getOrderStateId() {
		return orderStateId;
	}

	public void setOrderStateId(Integer orderStateId) {
		this.orderStateId = orderStateId;
	}

	public String getOrderStateType() {
		return orderStateType;
	}

	public void setOrderStateType(String orderStateType) {
		this.orderStateType = orderStateType;
	}

	public List<Refund> getRefunds() {
		return refunds;
	}

	public void setRefunds(List<Refund> refunds) {
		this.refunds = refunds;
	}

}
