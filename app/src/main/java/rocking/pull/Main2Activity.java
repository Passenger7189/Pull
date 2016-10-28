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
         * Mode.BOTH��ͬʱ֧����������
         * Mode.PULL_FROM_START��ֻ֧������Pulling Down
         * Mode.PULL_FROM_END��ֻ֧������Pulling Up
		 */
        /*
         * ���Mode���ó�Mode.BOTH����Ҫ����ˢ��ListenerΪOnRefreshListener2����ʵ��onPullDownToRefresh()��onPullUpToRefresh()����������
         * ���Mode���ó�Mode.PULL_FROM_START��Mode.PULL_FROM_END����Ҫ����ˢ��ListenerΪOnRefreshListener��ͬʱʵ��onRefresh()������
         * ��ȻҲ��������ΪOnRefreshListener2������Mode.PULL_FROM_START��ʱ��ֻ����onPullDownToRefresh()������
         * Mode.PULL_FROM��ʱ��ֻ����onPullUpToRefresh()����. 
		 */

		/*
         * setOnRefreshListener(OnRefreshListener listener):����ˢ�¼�������
		 * setOnLastItemVisibleListener(OnLastItemVisibleListener listener):�����Ƿ񵽵ײ���������
		 * setOnPullEventListener(OnPullEventListener listener);�����¼���������
		 * onRefreshComplete()������ˢ�����
		 */
        /*
         * pulltorefresh.setOnScrollListener()
		 */
        // SCROLL_STATE_TOUCH_SCROLL ���ڹ���
        // SCROLL_STATE_FLING ��ָ�����׵Ķ�������ָ�뿪��Ļǰ����������һ�£�    
        // SCROLL_STATE_IDLE ֹͣ����       
        /*
         * setOnLastItemVisibleListener
		 * ���û�������ʱ����  
		 */
        /*
         * setOnTouchListener�Ǽ�شӵ������ �������϶���꣩���ſ���꣨�����Ի�����ָ������������ �����Ļص�������onTouchEvent��MotionEvent event��,
		 * Ȼ��ͨ���ж�event.getAction()��MotionEvent.ACTION_UP����ACTION_DOWN����ACTION_MOVE�ֱ�����ͬ��Ϊ��
         * setOnClickListener�ļ��ʱ��ֻ��ص���ָACTION_DOWNʱ��������Ϊ
		 */
        pullToRefresh.setOnRefreshListener(new OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                // TODO Auto-generated method stub
                // ��ȡ������������������--------------------------------------------------------ûд
                List<Dynamic> dynamics = new ArrayList<Dynamic>();
                sdAdapter.addFirst(dynamics);
                new FinishRefresh().execute();
                getDynamicData();
                sdAdapter.notifyDataSetChanged();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                // TODO Auto-generated method stub
                // ��ȡ������������������--------------------------------------------------------ûд
                List<Dynamic> dynamics = new ArrayList<Dynamic>();
                sdAdapter.addLast(dynamics);
                new FinishRefresh().execute();
                sdAdapter.notifyDataSetChanged();
            }
        });
    }

    private void init() {
        ILoadingLayout startLabels = pullToRefresh.getLoadingLayoutProxy(true, false);
        startLabels.setPullLabel("����ˢ��...");// ������ʱ����ʾ����ʾ  
        startLabels.setRefreshingLabel("��������...");// ˢ��ʱ  
        startLabels.setReleaseLabel("�ſ�ˢ��...");// �����ﵽһ������ʱ����ʾ����ʾ  

        ILoadingLayout endLabels = pullToRefresh.getLoadingLayoutProxy(false, true);
        endLabels.setPullLabel("����ˢ��...");// ������ʱ����ʾ����ʾ  
        endLabels.setRefreshingLabel("��������...");// ˢ��ʱ  
        endLabels.setReleaseLabel("�ſ�ˢ��...");// �����ﵽһ������ʱ����ʾ����ʾ  

        // ��������ˢ���ı�
        pullToRefresh.getLoadingLayoutProxy(false, true).setPullLabel("����ˢ��...");
        pullToRefresh.getLoadingLayoutProxy(false, true).setReleaseLabel("�ſ�ˢ��...");
        pullToRefresh.getLoadingLayoutProxy(false, true).setRefreshingLabel("���ڼ���...");
        // ��������ˢ���ı�
        pullToRefresh.getLoadingLayoutProxy(true, false).setPullLabel("����ˢ��...");
        pullToRefresh.getLoadingLayoutProxy(true, false).setReleaseLabel("�ſ�ˢ��...");
        pullToRefresh.getLoadingLayoutProxy(true, false).setRefreshingLabel("���ڼ���...");
    }

    private void getDynamicData() {    // ��ʼ�����ȴ������ȡ����

        // ��ȡ�������ݹ���Dynamic��Ȼ����ڼ�����
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
                // ������صĶ�̬���ϲ�Ϊ�գ���ô�ͽ����ϸ�������
                if (dynamicList != null) {
                    sdAdapter = new SurroundDynamicAdapter(Main2Activity.this, dynamicList);
                    pullToRefresh.setAdapter(sdAdapter);

                    pullToRefresh.setMode(Mode.BOTH);
                    init();
                } else {
                    Log.i("FriendDynamicFragment", "onSuccess: 88------dynamics�յ�");
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
