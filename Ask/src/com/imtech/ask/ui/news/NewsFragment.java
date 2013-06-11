/*
 * @project : Ask
 * @author  : huqiming 
 * @date    : 2013-6-7
 */
package com.imtech.ask.ui.news;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imtech.ask.R;
import com.imtech.ask.ui.BaseFragment;
import com.imtech.ask.view.pull2refresh.PullToRefreshListView;

/**
 * 最新资讯
 */
public class NewsFragment extends BaseFragment {
	private static final String TAG = "NewsFragment";
	private NewsAdapter mAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = initView(inflater);
		initDatas();
		return view;
	}

	private View initView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.fragment_news, null);
		PullToRefreshListView listView = (PullToRefreshListView) view.findViewById(R.id.listview);
		mAdapter = new NewsAdapter(getActivity());
		listView.setAdapter(mAdapter);
		return view;
	};

	private void initDatas() {
		List<NewsModel> list = new ArrayList<NewsModel>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(new Date());
		for (int i = 0; i < 20; i++) {
			NewsModel item = new NewsModel();
			item.date = date;
			item.title = i + ".华盛顿里餐厅里的黑人姑娘被曝与前男友丑闻的事情";
			item.summary = i + ".华盛顿里餐厅里的黑人姑娘被曝与前男友丑闻的事情" +
					"华盛顿里餐厅里的黑人姑娘被曝与前男友丑闻的事情华盛顿里" +
					"餐厅里的黑人姑娘被曝与前男友丑闻的事情华盛顿里餐厅里的" +
					"黑人姑娘被曝与前男友丑闻的事情";
			list.add(item);
		}
		mAdapter.setDatas(list);
		mAdapter.notifyDataSetChanged();
	}
}
