package rocking.pull;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import entity.Dynamic;
import meetfit.MeetFitUrl;
import meetfit.MyApplication;

public class Main2Activity extends ActionBarActivity {

    private PullToRefreshListView pullToRefresh;
    private List<Dynamic> dynamicList = new ArrayList<>();
    SurroundDynamicAdapter sdAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        pullToRefresh = (PullToRefreshListView) findViewById(R.id.pullToRefresh);

        getDynamicData();

        /*
         * Mode.BOTH：同时支持上拉下拉
         * Mode.PULL_FROM_START：只支持下拉Pulling Down
         * Mode.PULL_FROM_END：只支持上拉Pulling Up
		 */
        /*
         * 如果Mode设置成Mode.BOTH，需要设置刷新Listener为OnRefreshListener2，并实现onPullDownToRefresh()、onPullUpToRefresh()两个方法。
         * 如果Mode设置成Mode.PULL_FROM_START或Mode.PULL_FROM_END，需要设置刷新Listener为OnRefreshListener，同时实现onRefresh()方法。
         * 当然也可以设置为OnRefreshListener2，但是Mode.PULL_FROM_START的时候只调用onPullDownToRefresh()方法，
         * Mode.PULL_FROM的时候只调用onPullUpToRefresh()方法. 
		 */

		/*
         * setOnRefreshListener(OnRefreshListener listener):设置刷新监听器；
		 * setOnLastItemVisibleListener(OnLastItemVisibleListener listener):设置是否到底部监听器；
		 * setOnPullEventListener(OnPullEventListener listener);设置事件监听器；
		 * onRefreshComplete()：设置刷新完成
		 */
        /*
         * pulltorefresh.setOnScrollListener()
		 */
        // SCROLL_STATE_TOUCH_SCROLL 正在滚动
        // SCROLL_STATE_FLING 手指做了抛的动作（手指离开屏幕前，用力滑了一下）    
        // SCROLL_STATE_IDLE 停止滚动       
        /*
         * setOnLastItemVisibleListener
		 * 当用户拉到底时调用  
		 */
        /*
         * setOnTouchListener是监控从点下鼠标 （可能拖动鼠标）到放开鼠标（鼠标可以换成手指）的整个过程 ，他的回调函数是onTouchEvent（MotionEvent event）,
		 * 然后通过判断event.getAction()是MotionEvent.ACTION_UP还是ACTION_DOWN还是ACTION_MOVE分别作不同行为。
         * setOnClickListener的监控时间只监控到手指ACTION_DOWN时发生的行为
		 */
        pullToRefresh.setOnRefreshListener(new OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                // TODO Auto-generated method stub
                // 获取网络请求，新增的数据--------------------------------------------------------没写
                List<Dynamic> dynamics = new ArrayList<Dynamic>();
                sdAdapter.addFirst(dynamics);
                new FinishRefresh().execute();
                getDynamicData();
                sdAdapter.notifyDataSetChanged();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                // TODO Auto-generated method stub
                // 获取网络请求，新增的数据--------------------------------------------------------没写
                List<Dynamic> dynamics = new ArrayList<Dynamic>();
                sdAdapter.addLast(dynamics);
                new FinishRefresh().execute();
                sdAdapter.notifyDataSetChanged();
            }
        });
    }

    private void init() {
        ILoadingLayout startLabels = pullToRefresh.getLoadingLayoutProxy(true, false);
        startLabels.setPullLabel("下拉刷新...");// 刚下拉时，显示的提示  
        startLabels.setRefreshingLabel("正在载入...");// 刷新时  
        startLabels.setReleaseLabel("放开刷新...");// 下来达到一定距离时，显示的提示  

        ILoadingLayout endLabels = pullToRefresh.getLoadingLayoutProxy(false, true);
        endLabels.setPullLabel("上拉刷新...");// 刚下拉时，显示的提示  
        endLabels.setRefreshingLabel("正在载入...");// 刷新时  
        endLabels.setReleaseLabel("放开刷新...");// 下来达到一定距离时，显示的提示  

        // 设置下拉刷新文本
        pullToRefresh.getLoadingLayoutProxy(false, true).setPullLabel("上拉刷新...");
        pullToRefresh.getLoadingLayoutProxy(false, true).setReleaseLabel("放开刷新...");
        pullToRefresh.getLoadingLayoutProxy(false, true).setRefreshingLabel("正在加载...");
        // 设置上拉刷新文本
        pullToRefresh.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新...");
        pullToRefresh.getLoadingLayoutProxy(true, false).setReleaseLabel("放开刷新...");
        pullToRefresh.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在加载...");
    }

    private void getDynamicData() {    // 初始化，先从网络获取数据

        // 获取网络数据关于Dynamic，然后加在集合中
//        Dynamic dynamic = ...
//        list.add(dynamic);

        String SuroundUrl = MeetFitUrl.FriendsDynamicURL;
        RequestParams requestParams = new RequestParams(SuroundUrl);
        requestParams.addQueryStringParameter("userId", String.valueOf(((MyApplication) getApplication()).getUser().getUser_id()));

        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                List<Dynamic> newDynamics;
                newDynamics = gson.fromJson(result, new TypeToken<List<Dynamic>>() {
                }.getType());

                dynamicList.clear();
                dynamicList.addAll(newDynamics);
                Log.i("FriendDynamicFragment", "onSuccess: 84-----+++++++++" + dynamicList.size());
                // 如果返回的动态集合不为空，那么就将集合给适配器
                if (dynamicList != null) {
                    sdAdapter = new SurroundDynamicAdapter(Main2Activity.this, dynamicList);
                    pullToRefresh.setAdapter(sdAdapter);

                    pullToRefresh.setMode(Mode.BOTH);
                    init();
                } else {
                    Log.i("FriendDynamicFragment", "onSuccess: 88------dynamics空的");
                }
            }

            @Override
            public void onError(Throwable throwable, boolean b) {

            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private class FinishRefresh extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
//        	adapter.notifyDataSetChanged();
            pullToRefresh.onRefreshComplete();
        }
    }

}
