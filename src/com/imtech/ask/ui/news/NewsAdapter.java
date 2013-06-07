package com.imtech.ask.ui.news;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NewsAdapter extends BaseAdapter {
	private Context mContext;

	public NewsAdapter(Context context) {
		mContext = context;
	}

	@Override
	public int getCount() {
		return 20;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView view = new TextView(mContext);
		view.setText("suddenlydream  " + position);
		view.setTextColor(Color.BLACK);
		view.setPadding(20, 30, 20, 30);
		return view;
	}

}
