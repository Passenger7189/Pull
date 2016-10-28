package entity;

public class OrderDetail {

	private Integer orderDetId;
	private Business business;
	private Goods goods;
	private Coach coach;

	public OrderDetail() {
		super();
	}

	public OrderDetail(Integer orderDetId, Business business, Goods goods,
			Coach coach) {
		super();
		this.orderDetId = orderDetId;
		this.business = business;
		this.goods = goods;
		this.coach = coach;
	}

	public Integer getOrderDetId() {
		return orderDetId;
	}

	public void setOrderDetId(Integer orderDetId) {
		this.orderDetId = orderDetId;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

}
