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
import android.view.ViewGroup;
import android.widget.ListView;

import com.imtech.ask.R;
import com.imtech.ask.ui.BaseFragment;
import com.imtech.ask.util.StringUtils;
import com.imtech.ask.view.pull2refresh.PullToRefreshBase;
import com.imtech.ask.view.pull2refresh.PullToRefreshBase.OnRefreshListener;
import com.imtech.ask.view.pull2refresh.PullToRefreshListView;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * 最新资讯
 */
public class NewsFragment extends BaseFragment implements OnRefreshListener<ListView> {
	private static final String TAG = "NewsFragment";
	private NewsAdapter mAdapter;
	private PullToRefreshListView mListView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
		return view;
	};

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
