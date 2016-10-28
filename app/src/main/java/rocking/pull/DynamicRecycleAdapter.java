package rocking.pull;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.facebook.drawee.view.SimpleDraweeView;

import meetfit.MeetFitUrl;


/**
 * Created by rocking on 2016/10/22.
 * <p/>
 * 关于该Adapter是用来放图片的，所以它对应的是一个SimpleDrawView
 */

public class DynamicRecycleAdapter extends RecyclerView.Adapter<DynamicRecycleAdapter.ViewHolder> {

    private Context mContext;
    // 传入解析过来的动态图片地址 与 上下文
    private String[] dynamicImages = new String[]{};

    private View view;
    ViewHolder viewHolder;

    public DynamicRecycleAdapter(Context context, String[] images) {
        this.mContext = context;
        this.dynamicImages = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(R.layout.fragment_for_dynamic_picture_adapter, null);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String dynamicImageURL = MeetFitUrl.URL + dynamicImages[position];
        Log.i("DynamicRecycleAdapter", "onBindViewHolder: 46==================" + dynamicImageURL);
        holder.sdvDynamicImage.setImageURI(dynamicImageURL);
    }

    @Override
    public int getItemCount() {
        return dynamicImages.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView sdvDynamicImage;

        public ViewHolder(View itemView) {
            super(itemView);
            sdvDynamicImage = (SimpleDraweeView) view.findViewById(R.id.sdv_dynamicImage);

            // 设置图片的宽度。
            /**
             * 1. 如果图片超过三张，那么每张宽高为 三分之一 屏幕宽度
             * 2. 如果图片为两张，那么每张图片宽度为 二分之一 的屏幕宽度
             * 3. 如果图片为1张，设置宽度为 三分之二 屏幕宽度
             * 4. 没有图片，不显示该RecyclerView，所以不在这里判断设置
             */

            WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            int screenWidth = windowManager.getDefaultDisplay().getWidth();
            int screenHeight = windowManager.getDefaultDisplay().getHeight();

            if (dynamicImages.length > 2) {
                // 设置控件的最大和最小值都一样，是不是就直接是这个值了
                sdvDynamicImage.setMaxHeight((screenWidth / 3) - 15);
                sdvDynamicImage.setMinimumHeight((screenWidth / 3) - 15);
                // 设置宽度
                sdvDynamicImage.setMaxWidth((screenWidth / 3) - 15);
                sdvDynamicImage.setMinimumWidth((screenWidth / 3) - 15);
            } else if (dynamicImages.length == 2) {
                // 设置控件的最大和最小值都一样，是不是就直接是这个值了
                sdvDynamicImage.setMaxHeight(screenWidth / 3);
                sdvDynamicImage.setMinimumHeight(screenWidth / 3);
                // 设置宽度
                sdvDynamicImage.setMaxWidth((screenWidth / 2) - 10);
                sdvDynamicImage.setMinimumWidth((screenWidth / 2) - 10);
            } else if (dynamicImages.length == 1) {
                // 设置控件的最大和最小值都一样，是不是就直接是这个值了
//                sdvDynamicImage.setMaxHeight((screenWidth / 3) * 2);
//                sdvDynamicImage.setMinimumHeight((screenWidth / 3) * 2);
                // 设置宽度，高度继续WrapContent好了,最高 1/2 屏幕
                sdvDynamicImage.setMaxWidth((screenWidth / 3) * 2);
                sdvDynamicImage.setMinimumWidth((screenWidth / 3) * 2);
                sdvDynamicImage.setMaxHeight(screenHeight / 2);     // 没设置最低高度，然后就直接成了一条线
                sdvDynamicImage.setMinimumHeight((screenWidth / 2) - 10);
            }

        }
    }
}
