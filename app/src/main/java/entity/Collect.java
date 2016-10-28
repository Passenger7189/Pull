package entity;

public class Collect {
	private Integer collect_id;
	private Integer collect_type;	// 收藏类型：1为商家，2为商品

	public Collect() {
	}

	public Collect(Integer collect_id, Integer collect_type) {
		this.collect_id = collect_id;
		this.collect_type = collect_type;
	}

	public Integer getCollect_type() {
		return collect_type;
	}

	public void setCollect_type(Integer collect_type) {
		this.collect_type = collect_type;
	}

	public Integer getCollect_id() {
		return collect_id;
	}

	public void setCollect_id(Integer collect_id) {
		this.collect_id = collect_id;
	}
}
