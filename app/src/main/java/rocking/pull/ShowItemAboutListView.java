package rocking.pull;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Rocking on 2016/10/15.
 */
public class ShowItemAboutListView {

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        //  The ListView can display any data provided that it is wrapped in a ListAdapter.
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            Log.i("ShowItemAboutListView", "setListViewHeightBasedOnChildren: ListView 传进来时是空的内容");
        }

        int totalHeight = 0;
        // 得到ListView对象总共有多少个item项
        for (int i = 0; i < listAdapter.getCount(); i++) {
            // 得到每一个item作为一个View对象
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            // listItem.getMeasuredHeight() 得到当前item的高度
            // 所以追加是活动所有item的高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // 因为ListView对象是可以设置间隔条的高度的
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        ((ViewGroup.MarginLayoutParams) params).setMargins(0, 0, 0, 0);
        listView.setLayoutParams(params);

       /* 但是用该方法还是会有问题，因为我在ScrollView中放了个画廊和一个ListView，现在ListView会显示在顶部对齐
        * 也就是说本该在上面的Gallery被排在了外边，虽然下拉一点能看到，但是很明显会影响用户的体验,换成了ViewPager
        *
        * 其实真实原因是子控件抢了布局的焦点，重新设置回来即可
        */
    }

}
