package entity;

public class Dynamiclike {
    private Integer dynamiclike_id;
    // 点赞时间我去掉了，然后感觉点赞类没有存在的价值
    private User dynamiclike_user;
    private int dynamic_state;
    public Dynamiclike() {
    }

    public int getDynamic_state() {
        return dynamic_state;
    }

    public void setDynamic_state(int dynamic_state) {
        this.dynamic_state = dynamic_state;
    }

    public Dynamiclike(Integer dynamiclike_id, User dynamiclike_user, int dynamic_state) {
        this.dynamiclike_id = dynamiclike_id;
        this.dynamiclike_user=dynamiclike_user;
        this.dynamic_state=dynamic_state;

    }

    public User getDynamiclike_user(){
        return dynamiclike_user;
    }
    public Integer getDynamiclike_id() {
        return dynamiclike_id;
    }
    public void setDynamiclike_user(User dynamiclike_user){
        this.dynamiclike_user=dynamiclike_user;
    }
    public void setDynamiclike_id(Integer dynamiclike_id) {
        this.dynamiclike_id = dynamiclike_id;
    }
}
