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
import android.view.View.OnClickListener;
import android.widget.ListView;

import com.imtech.ask.R;
import com.imtech.ask.ui.BaseFragment;
import com.imtech.ask.ui.ModuleConfig;
import com.imtech.ask.ui.message.MessageModel.Type;
import com.imtech.ask.view.TopBar;

/**
 * 查看消息
 */
public class MessageFragment extends BaseFragment {
	private static final String TAG = "TopicFragment";
	private MessageAdapter mAdapter;

	@Override
	public View onCreateContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = initView(inflater);
		initDatas();
		return view;
	}

	private View initView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.fragment_msg, null);
		ListView listview = (ListView) view.findViewById(R.id.listview);
		mAdapter = new MessageAdapter(getActivity());
		listview.setAdapter(mAdapter);
		
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
	}
	
	@Override
	public String getModuleId() {
		return ModuleConfig.MODULE_MSG_ID;
	}
	
	@Override
	public String getModuleName() {
		return "消息";
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
