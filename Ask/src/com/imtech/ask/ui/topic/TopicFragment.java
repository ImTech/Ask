/*
 * @project : Ask
 * @author  : huqiming 
 * @date    : 2013-6-7
 */
package com.imtech.ask.ui.topic;

import java.util.ArrayList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ListView;

import com.imtech.ask.R;
import com.imtech.ask.ui.BaseFragment;
import com.imtech.ask.ui.ModuleConfig;
import com.imtech.ask.util.StringUtils;
import com.imtech.ask.view.TitleIndicator;
import com.imtech.ask.view.TopBar;
import com.imtech.ask.view.TitleIndicator.IndicatorItem;
import com.imtech.ask.view.TitleIndicator.OnIndicatorListener;
import com.imtech.ask.view.pull2refresh.PullToRefreshBase;
import com.imtech.ask.view.pull2refresh.PullToRefreshBase.OnRefreshListener;
import com.imtech.ask.view.pull2refresh.PullToRefreshListView;

/**
 * 问答社区
 */
public class TopicFragment extends BaseFragment implements OnIndicatorListener, OnRefreshListener<ListView> {
	private static final String TAG = "TopicFragment";
	private static final int INDICATOR_LAST_TOPICS = 0;
	private static final int INDICATOR_TOP_TOPICS = 1;
	private static final int INDICATOR_COMMON_TOPICS = 2;
	private TopicsAdapter mAdapter;
	private PullToRefreshListView mListView;
	private TitleIndicator mIndicator;
	private ArrayList<TopicModel> mLastTopics;
	private ArrayList<TopicModel> mTopTopics;
	private ArrayList<TopicModel> mCommonTopics;

	@Override
	public View onCreateContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = initView(inflater);
		initDatas();
		return view;
	}

	private View initView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.fragment_topic, null);
		mListView = (PullToRefreshListView) view.findViewById(R.id.listview);
		mAdapter = new TopicsAdapter(getActivity());
		mListView.setAdapter(mAdapter);
		mListView.setOnRefreshListener(this);

		mIndicator = (TitleIndicator) view.findViewById(R.id.title_indicator);
		mIndicator.setIndicatorListener(this);
		mIndicator.addItem(R.string.latest_topics, INDICATOR_LAST_TOPICS);
		mIndicator.addItem(R.string.top_topics, INDICATOR_TOP_TOPICS);
		mIndicator.addItem(R.string.common_topics, INDICATOR_COMMON_TOPICS);
		mIndicator.setIndicator(0);
		
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
		return ModuleConfig.MODULE_ASK_ID;
	}
	
	@Override
	public String getModuleName() {
		return "问答社区";
	}

	private void initDatas() {
		String date = StringUtils.formatDate();

		mLastTopics = new ArrayList<TopicModel>();
		for (int i = 0; i < 20; i++) {
			TopicModel item = new TopicModel();
			item.msgs = i;
			item.date = date;
			item.title = "最新问题： " + i + ".华盛顿里餐厅里的黑人姑娘被曝与前男友丑闻的事情";
			item.summary = "最新问题： " + i + ".华盛顿里餐厅里的黑人姑娘被曝与前男友丑闻的事情" + "华盛顿里餐厅里的黑人姑娘被曝与前男友丑闻的事情华盛顿里"
					+ "餐厅里的黑人姑娘被曝与前男友丑闻的事情华盛顿里餐厅里的" + "黑人姑娘被曝与前男友丑闻的事情";
			mLastTopics.add(item);
		}

		mTopTopics = new ArrayList<TopicModel>();
		for (int i = 0; i < 20; i++) {
			TopicModel item = new TopicModel();
			item.msgs = i;
			item.date = date;
			item.title = "热门问题： " + i + ".华盛顿里餐厅里的黑人姑娘被曝与前男友丑闻的事情";
			item.summary = "热门问题： " + i + ".华盛顿里餐厅里的黑人姑娘被曝与前男友丑闻的事情" + "华盛顿里餐厅里的黑人姑娘被曝与前男友丑闻的事情华盛顿里"
					+ "餐厅里的黑人姑娘被曝与前男友丑闻的事情华盛顿里餐厅里的" + "黑人姑娘被曝与前男友丑闻的事情";
			mTopTopics.add(item);
		}

		mCommonTopics = new ArrayList<TopicModel>();
		for (int i = 0; i < 20; i++) {
			TopicModel item = new TopicModel();
			item.msgs = i;
			item.date = date;
			item.title = "常见问题： " + i + ".华盛顿里餐厅里的黑人姑娘被曝与前男友丑闻的事情";
			item.summary = "常见问题： " + i + ".华盛顿里餐厅里的黑人姑娘被曝与前男友丑闻的事情" + "华盛顿里餐厅里的黑人姑娘被曝与前男友丑闻的事情华盛顿里"
					+ "餐厅里的黑人姑娘被曝与前男友丑闻的事情华盛顿里餐厅里的" + "黑人姑娘被曝与前男友丑闻的事情";
			mCommonTopics.add(item);
		}

		mAdapter.setDatas(mLastTopics);
		mAdapter.notifyDataSetChanged();
	}

	@Override
	public void onIndicatorChanged(IndicatorItem selectItem) {
		ArrayList<TopicModel> list = null;
		switch (selectItem.id) {
		case INDICATOR_LAST_TOPICS:
			list = mLastTopics;
			break;
		case INDICATOR_TOP_TOPICS:
			list = mTopTopics;
			break;
		case INDICATOR_COMMON_TOPICS:
			list = mCommonTopics;
			break;
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
