package meetfit;

/**
 * Created by asus on 2016/10/1.
 */
public class MeetFitUrl {
    //  ip:     192.168.155.1    192.168.1.106    192.168.1.105       10.30.6.14
    public static final String URL = "http://192.168.191.1:8080/MeetFit";   //服务端项目名
    public static final String merchantUrl = URL + "/SelectBusinessInfo";   // 查询商家信息
    public static final String GoodsUrl = URL + "/SelectGoodsInfo"; // 查询商品信息
    public static final String MERCHANTDETAILURL = URL + "/QueryBusinessDetailServlet"; //查询商家详细信息
    public static final String CoachUrl = URL + "/QueryCoachInfoServlet";   // 查询教练信息
    public static final String payUrl = URL + "/QueryPayPageServlet";   // 付款页信息
    public static final String InsertOrderURL = URL + "/InsertOrderServlet";    // 插入订单以及更新订单
    public static final String FriendsDynamicURL = URL + "/QueryFriendDynamicServlet";   // 查询好友动态
    public static final String CommentURL = URL + "/QueryCommentServlet";       //
    public static final String TransmitDynamicURL = URL + "/TransmitDynamicServlet";        // 转发动态插入数据的
}

