package entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Timestamp;
import java.util.List;

public class User implements Parcelable {

    /*    private Integer user_id;
        private String user_name;
        private String user_passwd;
        private Date user_joindate;
        private String user_address;
        private String user_callnumber;
        private String user_sex;
        private String user_head_picture;
        private String user_login_name;*/
    private Integer user_id;// 用户ID
    private String user_name;// 用户昵称
    private String user_password;// 用户密码
    private Timestamp user_joindate;// 创建时间
    private String user_address;// 用户地址
    private String user_callnumber;// 联系电话
    private String user_sex;// 性别
    private String user_head_picture;// 头像
    private String user_login_name;// 登录名（手机号）
    private String user_token;// 身份令牌（好友聊天用）

    // 上述为用户的基本信息，但是很多张表中用户是作为外键的，所以会有很多的集合对象
    // 如商家评论、收藏、动态、动态评论、动态点赞、好友、订单

    private List<BusinessComment> businessComments;
    private List<Collect> collects;
    private List<Dynamic> dynamics;
    private List<Dynamiccomment> dynamiccomments;
    private List<Dynamiclike> dynamiclikes;
    private List<Friend> friends;
    private List<Order> orders;

    public User() {
    }

    public User(String user_password, String user_login_name) {
        this.user_password = user_password;
        this.user_login_name = user_login_name;
    }

    public User(Integer user_id, String user_name, String user_password,
                Timestamp user_joindate, String user_address,
                String user_callnumber, String user_sex, String user_head_picture,
                String user_login_name, List<BusinessComment> businessComments,
                List<Collect> collects, List<Dynamic> dynamics,
                List<Dynamiccomment> dynamiccomments,
                List<Dynamiclike> dynamiclikes, List<Friend> friends,
                List<Order> orders) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_joindate = user_joindate;
        this.user_address = user_address;
        this.user_callnumber = user_callnumber;
        this.user_sex = user_sex;
        this.user_head_picture = user_head_picture;
        this.user_login_name = user_login_name;
        this.businessComments = businessComments;
        this.collects = collects;
        this.dynamics = dynamics;
        this.dynamiccomments = dynamiccomments;
        this.dynamiclikes = dynamiclikes;
        this.friends = friends;
        this.orders = orders;
    }

    public User(int user_id, String user_name, String user_password,
                String user_address, String user_callnumber, String user_sex,
                String user_head_picture, String user_login_name) {
        // TODO Auto-generated constructor stub
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_address = user_address;
        this.user_callnumber = user_callnumber;
        this.user_sex = user_sex;
        this.user_head_picture = user_head_picture;
        this.user_login_name = user_login_name;
    }

    public User(int userId, String userName, String userAddress,
                String userSex, String userHeadPic, String userToken) {
        // TODO Auto-generated constructor stub
        this.user_id = userId;
        this.user_name = userName;
        this.user_address = userAddress;
        this.user_sex = userSex;
        this.user_head_picture = userHeadPic;
        this.user_token = userToken;
    }

    public User(int userId, String userName, String userPassword, Timestamp userJoinDate, String userAddress, String userCallnumber,
                String userSex, String userHeadpicture, String userLoginname, String userToken) {
        // TODO Auto-generated constructor stub
        this.user_id = userId;
        this.user_name = userName;
        this.user_password = userPassword;
        this.user_joindate = userJoinDate;
        this.user_address = userAddress;
        this.user_callnumber = userCallnumber;
        this.user_sex = userSex;
        this.user_head_picture = userHeadpicture;
        this.user_login_name = userLoginname;
        this.user_token = userToken;
    }

    public User(int userId, String userName, String userHead) {
        // TODO Auto-generated constructor stub
        this.user_id = userId;
        this.user_name = userName;
        this.user_head_picture = userHead;
    }

    public User(Parcel in) {
        user_name = in.readString();
        user_password = in.readString();
        user_address = in.readString();
        user_callnumber = in.readString();
        user_sex = in.readString();
        user_head_picture = in.readString();
        user_login_name = in.readString();
        user_token = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User(int i) {
        this.user_id = i;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Timestamp getUser_joindate() {
        return user_joindate;
    }

    public void setUser_joindate(Timestamp user_joindate) {
        this.user_joindate = user_joindate;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_callnumber() {
        return user_callnumber;
    }

    public void setUser_callnumber(String user_callnumber) {
        this.user_callnumber = user_callnumber;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_head_picture() {
        return user_head_picture;
    }

    public void setUser_head_picture(String user_head_picture) {
        this.user_head_picture = user_head_picture;
    }

    public String getUser_login_name() {
        return user_login_name;
    }

    public void setUser_login_name(String user_login_name) {
        this.user_login_name = user_login_name;
    }

    public List<BusinessComment> getBusinessComments() {
        return businessComments;
    }

    public void setBusinessComments(List<BusinessComment> businessComments) {
        this.businessComments = businessComments;
    }

    public List<Collect> getCollects() {
        return collects;
    }

    public void setCollects(List<Collect> collects) {
        this.collects = collects;
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

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user_name);
        dest.writeString(user_password);
        dest.writeString(user_address);
        dest.writeString(user_callnumber);
        dest.writeString(user_sex);
        dest.writeString(user_head_picture);
        dest.writeString(user_login_name);
        dest.writeString(user_token);
    }
}
