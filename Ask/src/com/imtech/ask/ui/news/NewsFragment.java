/*
 * @project : Ask
 * @author  : huqiming 
 * @date    : 2013-6-7
 */
package com.imtech.ask.ui.news;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;

import com.imtech.ask.R;
import com.imtech.ask.ui.BaseFragment;
import com.imtech.ask.ui.ModuleConfig;
import com.imtech.ask.util.StringUtils;
import com.imtech.ask.view.TopBar;
import com.imtech.ask.view.pull2refresh.PullToRefreshBase;
import com.imtech.ask.view.pull2refresh.PullToRefreshBase.OnRefreshListener;
import com.imtech.ask.view.pull2refresh.PullToRefreshListView;

/**
 * 最新资讯
 */
public class NewsFragment extends BaseFragment implements OnRefreshListener<ListView> {
	private static final String TAG = "NewsFragment";
	private NewsAdapter mAdapter;
	private PullToRefreshListView mListView;

	@Override
	public View onCreateContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = initView(inflater);
		initDatas();
		return view;
	}
	
	private View initView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.fragment_news, null);
		mListView = (PullToRefreshListView) view.findViewById(R.id.listview);
		mAdapter = new NewsAdapter(getActivity());
		mListView.setAdapter(mAdapter);
		mListView.setOnRefreshListener(this);
		
		getTopBar().setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(v.getId() == TopBar.ID_LEFT_ICON){
					showFragment(ModuleConfig.MODULE_HOME_ID);
				}
			}
		});
		
		getTopBar().setTitle(getModuleName());
		
		return view;
	};
	
	@Override
	public String getModuleId() {
		return ModuleConfig.MODULE_NEWS_ID;
	}
	
	@Override
	public String getModuleName() {
		return "最新资讯";
	}

	private void initDatas() {
		List<NewsModel> list = new ArrayList<NewsModel>();
		String date = StringUtils.formatDate();
		for (int i = 0; i < 20; i++) {
			NewsModel item = new NewsModel();
			item.date = date;
			item.title = i + ".华盛顿里餐厅里的黑人姑娘被曝与前男友丑闻的事情";
			item.summary = i + ".华盛顿里餐厅里的黑人姑娘被曝与前男友丑闻的事情" + "华盛顿里餐厅里的黑人姑娘被曝与前男友丑闻的事情华盛顿里"
					+ "餐厅里的黑人姑娘被曝与前男友丑闻的事情华盛顿里餐厅里的" + "黑人姑娘被曝与前男友丑闻的事情";
			list.add(item);
		}
		mAdapter.setDatas(list);
		mAdapter.notifyDataSetChanged();
	}

	@Override
	public void onRefresh(PullToRefreshBase<ListView> refreshView) {
		String label = getString(R.string.pull_to_refresh_refreshing_label);
		refreshView.getLoadingLayoutProxy().setRefreshingLabel(label);
		new RefereshTask().execute();
	}

	class RefereshTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			}
			return null;
		}

		protected void onPostExecute(Void result) {
			initDatas();
			mListView.onRefreshComplete();
		};

	}
}
