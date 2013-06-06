//package com.imtech.ask.ui.activity;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.imtech.ask.BaseFragment;
//import com.imtech.ask.R;
//import com.imtech.ask.ui.adapter.NewsAdapter;
//import com.imtech.ask.view.pull2refresh.PullToRefreshListView;
//
//public class NewsFragment extends BaseFragment {
//	private static final String TAG = "NewsFragment";
//	private NewsAdapter mAdapter;
//
//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container,
//			Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		return initView(inflater);
//	}
//
//	private View initView(LayoutInflater inflater) {
//		View view = inflater.inflate(R.layout.fragment_news, null);
////		PullToRefreshListView listView = (PullToRefreshListView) view
//				.findViewById(R.id.listview);
//		mAdapter = new NewsAdapter(getActivity());
//		listView.setAdapter(mAdapter);
//		return view;
//	};
//}
