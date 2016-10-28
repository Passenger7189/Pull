package rocking.pull;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.List;

import entity.Dynamic;
import meetfit.MeetFitUrl;

/**
 * Created by asus on 2016/10/25.
 */
public class SurroundDynamicAdapter extends BaseAdapter {
    private Context mContext;
    private List<Dynamic> dynamicList;

    public SurroundDynamicAdapter(Context context, List<Dynamic> dynamics) {
        this.mContext = context;
        this.dynamicList = dynamics;
    }

    @Override
    public int getCount() {
        if (dynamicList != null) {
            return dynamicList.size();
        } else {
            return 0;
        }
    }

    // 下拉刷新增加集合对象
    public void addFirst(List<Dynamic> dynamics) {
        dynamicList.addAll(0, dynamics);
    }

    public void addLast(List<Dynamic> dynamics) {
        dynamicList.addAll(dynamics);
    }

    @Override
    public Object getItem(int position) {
        return dynamicList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        //如果convertView==null;解析布局文件
        if (convertView == null) {
            // 解析定义的View
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_friend_round_dynamic, null);
            viewHolder = new ViewHolder();

            // 得到各个控件的对象
            SimpleDraweeView sdvDynamicUserHeadImage = (SimpleDraweeView) convertView.findViewById(R.id.sdv_dynamicUserHeadImage);
            TextView tvDynamicUserNickName = (TextView) convertView.findViewById(R.id.tv_dynamicUserNickName);
            TextView tvDynamicUserpublishTime = (TextView) convertView.findViewById(R.id.tv_dynamicUserpublishTime);
            ImageView ivMoreAboutDynamic = (ImageView) convertView.findViewById(R.id.iv_moreAboutDynamic);
            TextView tvDynamicContent = (TextView) convertView.findViewById(R.id.tv_dynamicContent);
            TextView tvDynamicTransmit = (TextView) convertView.findViewById(R.id.tv_dynamicTransmit);
            RecyclerView rvDynamicPicture = (RecyclerView) convertView.findViewById(R.id.rv_dynamicPicture);
            TextView tvUserPublishAddress = (TextView) convertView.findViewById(R.id.tv_userPublishAddress);
            ImageView ivDynamicThumbs = (ImageView) convertView.findViewById(R.id.iv_dynamicThumbs);
            ImageView ivDynamicComment = (ImageView) convertView.findViewById(R.id.iv_dynamicComment);
            ImageView ivDynamicTransmit = (ImageView) convertView.findViewById(R.id.iv_dynamicTransmit);
            ListView lvDynamicCommentContent = (ListView) convertView.findViewById(R.id.lv_dynamicCommentContent);

            // 将 View的控件对象保存到viewholder
            viewHolder.sdvDynamicUserHeadImage = sdvDynamicUserHeadImage;
            viewHolder.tvDynamicUserNickName = tvDynamicUserNickName;
            viewHolder.tvDynamicUserpublishTime = tvDynamicUserpublishTime;
            viewHolder.ivMoreAboutDynamic = ivMoreAboutDynamic;
            viewHolder.tvDynamicContent = tvDynamicContent;
            viewHolder.tvDynamicTransmit = tvDynamicTransmit;
            viewHolder.rvDynamicPicture = rvDynamicPicture;
            viewHolder.tvUserPublishAddress = tvUserPublishAddress;
            viewHolder.ivDynamicThumbs = ivDynamicThumbs;
            viewHolder.ivDynamicComment = ivDynamicComment;
            viewHolder.ivDynamicTransmit = ivDynamicTransmit;
            viewHolder.lvDynamicCommentContent = lvDynamicCommentContent;

            // 绑定ViewHolder对象
            convertView.setTag(viewHolder);

        } else {
            // 取出ViewHolder对象
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // 赋值
        String userHead = MeetFitUrl.URL + dynamicList.get(position).getUser().getUser_head_picture();   // 用户头像地址
        viewHolder.sdvDynamicUserHeadImage.setImageURI(userHead);
        Log.i("FriendDynamicFragment", "convert: 136---------" + userHead);
        String userNick = dynamicList.get(position).getUser().getUser_name();     // 用户昵称
        viewHolder.tvDynamicUserNickName.setText(userNick);
        Log.i("FriendDynamicFragment", "convert: 139----------" + userNick);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日 HH:mm:ss");
        String publishTime = simpleDateFormat.format(dynamicList.get(position).getDynamic_publish_time());     // 发布时间
        viewHolder.tvDynamicUserpublishTime.setText(publishTime);
        Log.i("FriendDynamicFragment", "convert: 143--------" + publishTime);
        if (dynamicList.get(position).getDynamicIsShowAddress()) {
            String publishAddress = dynamicList.get(position).getDynamic_address();        // 发布地址
            viewHolder.tvUserPublishAddress.setText(publishAddress);
            Log.i("FriendDynamicFragment", "convert: 147----" + dynamicList.get(position).getDynamicIsShowAddress() + "----" + publishAddress);
        } else {
            viewHolder.tvUserPublishAddress.setVisibility(View.GONE);
            Log.i("FriendDynamicFragment", "convert: 150-------" + dynamicList.get(position).getDynamicIsShowAddress());
        }
        String dynamicContent = dynamicList.get(position).getDynamic_text();      // 发布的内容
        viewHolder.tvDynamicContent.setText(dynamicContent);
        Log.i("FriendDynamicFragment", "convert: 154---------" + dynamicContent);

        if (dynamicList.get(position).getDynamicIsTransmit()) {   // 是转发的，那么内容和图片都是转发的，还要看看图片有没有
            String transmitContent = dynamicList.get(position).getTransmitContent();  // 转发的文本内容
            Log.i("FriendDynamicFragment", "convert: 157-----" + dynamicList.get(position).getDynamicIsTransmit() + "------" + transmitContent);
            viewHolder.tvDynamicTransmit.setText(transmitContent);
            if (dynamicList.get(position).getDynamic_picture() != null) {     // 有图片资源
                // 还要判断图片资源的数量,然后控制RecyclerView的LayoutManager
                String[] transmitPictures = StringToArrays.staMethod(dynamicList.get(position).getDynamic_picture(), "@#@");
                int transmitPictureLength = transmitPictures.length;
                Log.i("FriendDynamicFragment", "convert: 163----------" + dynamicList.get(position).getDynamic_picture() + "-------" + transmitPictureLength);
                /**
                 *  transmitPictureLength： 动态的图片数量；
                 *  数量 / 3 != 0 ；（就是说大于三张图片）那么屏幕上是三列
                 *  数量 / 3 = 0 ；图片少于三张，那么多少图片就多少列
                 */
                viewHolder.rvDynamicPicture.setAdapter(new DynamicRecycleAdapter(mContext, transmitPictures));
                if ((transmitPictureLength / 3) != 0) {
                    viewHolder.rvDynamicPicture.setLayoutManager(new GridLayoutManager(mContext, 3));
                } else if (transmitPictureLength % 3 == 1) {
                    viewHolder.rvDynamicPicture.setLayoutManager(new LinearLayoutManager(mContext));
                } else {
                    viewHolder.rvDynamicPicture.setLayoutManager(new GridLayoutManager(mContext, transmitPictureLength));
                }
            } else { //没有图片资源，隐藏该控件
                viewHolder.rvDynamicPicture.setVisibility(View.GONE);
                Log.i("FriendDynamicFragment", "convert: 177------------没有图片");
            }
        } else {     // 不是转发的，内容和图片是自己的，同样要分图片有没有
            // 显示转发文本的区域要隐藏
            viewHolder.tvDynamicTransmit.setVisibility(View.GONE);
            Log.i("FriendDynamicFragment", "convert: 182-----------没有转发内容");
            if (dynamicList.get(position).getDynamic_picture() != null) {     // 有图片资源
                // 还要判断图片资源的数量,然后控制RecyclerView的LayoutManager
                String[] dynamicPictures = StringToArrays.staMethod(dynamicList.get(position).getDynamic_picture(), "@#@");
                int dynamicPictureLength = dynamicPictures.length;
                Log.i("FriendDynamicFragment", "convert: 187--------" + dynamicList.get(position).getDynamic_picture() + "---------" + dynamicPictureLength);
                /**
                 *  transmitPictureLength： 动态的图片数量；
                 *  数量 / 3 != 0 ；（就是说大于三张图片）那么屏幕上是三列
                 *  数量 / 3 = 0 ；图片少于三张，那么多少图片就多少列
                 */
                viewHolder.rvDynamicPicture.setAdapter(new DynamicRecycleAdapter(mContext, dynamicPictures));
                if ((dynamicPictureLength / 3) != 0) {
                    viewHolder.rvDynamicPicture.setLayoutManager(new GridLayoutManager(mContext, 3));
                } else if (dynamicPictureLength % 3 == 1) {
                    viewHolder.rvDynamicPicture.setLayoutManager(new LinearLayoutManager(mContext));
                } else {
                    viewHolder.rvDynamicPicture.setLayoutManager(new GridLayoutManager(mContext, dynamicPictureLength));
                }
            } else { //没有图片资源，隐藏该控件
                viewHolder.rvDynamicPicture.setVisibility(View.GONE);
                Log.i("FriendDynamicFragment", "convert: 201---------没有图片");
            }
        }
        return convertView;
    }

    class ViewHolder {
        private SimpleDraweeView sdvDynamicUserHeadImage;
        private TextView tvDynamicUserNickName;
        private TextView tvDynamicUserpublishTime;
        private ImageView ivMoreAboutDynamic;
        private TextView tvDynamicContent;
        private TextView tvDynamicTransmit;
        private RecyclerView rvDynamicPicture;
        private TextView tvUserPublishAddress;
        private ImageView ivDynamicThumbs;
        private ImageView ivDynamicComment;
        private ImageView ivDynamicTransmit;
        private ListView lvDynamicCommentContent;
    }


}
