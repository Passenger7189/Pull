package entity;

import java.util.List;

public class Friend {
    private Integer friend_id;
    private Integer friend_userfriend_id;
    // friend_userfriend_id
    // 这个好友用户ID本身也是user_id 这个为了区分上面自身的user_id

    // 虽然说好友而是用户，但是这里还是加上好友动态吧
    private List<Dynamic> dynamics;
    private List<Dynamiccomment> dynamiccomments;
    private List<Dynamiclike> dynamiclikes;


    public Friend() {
    }

    public Friend(Integer friend_id, Integer friend_userfriend_id, List<Dynamic> dynamics, List<Dynamiccomment> dynamiccomments, List<Dynamiclike> dynamiclikes) {
        this.friend_id = friend_id;
        this.friend_userfriend_id = friend_userfriend_id;
        this.dynamics = dynamics;
        this.dynamiccomments = dynamiccomments;
        this.dynamiclikes = dynamiclikes;
    }

    public Integer getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(Integer friend_id) {
        this.friend_id = friend_id;
    }

    public Integer getFriend_userfriend_id() {
        return friend_userfriend_id;
    }

    public void setFriend_userfriend_id(Integer friend_userfriend_id) {
        this.friend_userfriend_id = friend_userfriend_id;
    }

    public List<Dynamic> getDynamics() {
        return dynamics;
    }

    public void setDynamics(List<Dynamic> dynamics) {
        this.dynamics = dynamics;
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
}
