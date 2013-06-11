package com.imtech.ask.ui.message;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.imtech.ask.R;
import com.imtech.ask.ui.message.MessageModel.Type;

public class MessageAdapter extends BaseAdapter {
	// private Context mContext;
	private LayoutInflater mInflater;
	private List<MessageModel> mDatas;

	public MessageAdapter(Context context) {
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public void setDatas(List<MessageModel> datas) {
		mDatas = datas;
	}

	@Override
	public int getCount() {
		return mDatas != null ? mDatas.size() : 0;
	}

	@Override
	public MessageModel getItem(int position) {
		return mDatas != null ? mDatas.get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			View view = mInflater.inflate(R.layout.list_item_msg, null);
			holder = new ViewHolder();
			holder.title = (TextView) view.findViewById(R.id.title);
			holder.summary = (TextView) view.findViewById(R.id.summary);
			holder.msgCounts = (TextView) view.findViewById(R.id.msg_counts);
			holder.icon = (ImageView) view.findViewById(R.id.icon);
			view.setTag(holder);
			convertView = view;
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		MessageModel model = getItem(position);
		if (model != null) {
			holder.summary.setText(model.summary);
			holder.title.setText(model.title);
			holder.icon.setImageResource(getIconRes(model.type));
			if (model.msgCounts > 0) {
				holder.msgCounts.setVisibility(View.VISIBLE);
				holder.msgCounts.setText(String.valueOf(model.msgCounts));
			} else {
				holder.msgCounts.setVisibility(View.GONE);
			}
		}

		return convertView;
	}

	private int getIconRes(Type type) {
		switch (type) {
		case TOPIC:
			return R.drawable.ic_topic;
		case REPLY:
			return R.drawable.ic_reply;
		case NEWS:
			return R.drawable.ic_news;
		default:
			return R.drawable.ic_topic;
		}
	}

	class ViewHolder {
		TextView title;
		TextView summary;
		TextView msgCounts;
		ImageView icon;
	}
}
