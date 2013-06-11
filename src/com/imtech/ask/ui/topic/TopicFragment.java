/*
 * @project : Ask
 * @author  : huqiming 
 * @date    : 2013-6-7
 */
package com.imtech.ask.ui.topic;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imtech.ask.R;
import com.imtech.ask.ui.BaseFragment;
import com.imtech.ask.util.StringUtils;
import com.imtech.ask.view.TitleIndicator;
import com.imtech.ask.view.TitleIndicator.IndicatorItem;
import com.imtech.ask.view.TitleIndicator.OnIndicatorListener;
import com.imtech.ask.view.pull2refresh.PullToRefreshListView;

/**
 * 问答社区
 */
public class TopicFragment extends BaseFragment implements OnIndicatorListener {
	private static final String TAG = "TopicFragment";
	private static final int INDICATOR_LAST_TOPICS = 0;
	private static final int INDICATOR_TOP_TOPICS = 1;
	private static final int INDICATOR_COMMON_TOPICS = 2;
	private TopicsAdapter mAdapter;
	private TitleIndicator mIndicator;
	private ArrayList<TopicModel> mLastTopics;
	private ArrayList<TopicModel> mTopTopics;
	private ArrayList<TopicModel> mCommonTopics;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = initView(inflater);
		initDatas();
		return view;
	}

	private View initView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.fragment_topic, null);
		PullToRefreshListView listView = (PullToRefreshListView) view.findViewById(R.id.listview);
		mAdapter = new TopicsAdapter(getActivity());
		listView.setAdapter(mAdapter);

		mIndicator = (TitleIndicator) view.findViewById(R.id.title_indicator);
		mIndicator.setIndicatorListener(this);
		mIndicator.addItem(R.string.latest_topics, INDICATOR_LAST_TOPICS);
		mIndicator.addItem(R.string.top_topics, INDICATOR_TOP_TOPICS);
		mIndicator.addItem(R.string.common_topics, INDICATOR_COMMON_TOPICS);
		mIndicator.setIndicator(0);
		return view;
	};

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
}