/*
 * @project : Ask
 * @author  : huqiming 
 * @date    : 2013-6-7
 */
package com.imtech.ask.ui.message;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.imtech.ask.R;
import com.imtech.ask.ui.BaseFragment;
import com.imtech.ask.ui.message.MessageModel.Type;

/**
 * 查看消息
 */
public class MessageFragment extends BaseFragment {
	private static final String TAG = "TopicFragment";
	private MessageAdapter mAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = initView(inflater);
		initDatas();
		return view;
	}

	private View initView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.fragment_msg, null);
		ListView listview = (ListView) view.findViewById(R.id.listview);
		mAdapter = new MessageAdapter(getActivity());
		listview.setAdapter(mAdapter);
		return view;
	}

	private void initDatas() {
		ArrayList<MessageModel> list = new ArrayList<MessageModel>();

		MessageModel model = new MessageModel();
		model.title = "最新问题";
		model.summary = "求购500元左右的电脑哦，cpu四核，内存8G，硬盘1T";
		model.type = Type.TOPIC;
		model.msgCounts = 98;
		list.add(model);

		model = new MessageModel();
		model.title = "回答/评论";
		model.summary = "求购500元左右的电脑哦，cpu四核，内存8G，硬盘1T";
		model.type = Type.REPLY;
		model.msgCounts = 365;
		list.add(model);

		model = new MessageModel();
		model.title = "资讯";
		model.summary = "求购500元左右的电脑哦，cpu四核，内存8G，硬盘1T";
		model.type = Type.NEWS;
		model.msgCounts = 1002;
		list.add(model);

		mAdapter.setDatas(list);
		mAdapter.notifyDataSetChanged();
	}
}
