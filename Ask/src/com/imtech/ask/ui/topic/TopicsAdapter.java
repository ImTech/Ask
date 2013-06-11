package com.imtech.ask.ui.topic;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.imtech.ask.R;
import com.imtech.ask.core.TestConstant;
import com.imtech.ask.ui.ImageLoadAdapter;

public class TopicsAdapter extends ImageLoadAdapter {
	// private Context mContext;
	private LayoutInflater mInflater;
	private List<TopicModel> mDatas;

	public TopicsAdapter(Context context) {
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public void setDatas(List<TopicModel> datas) {
		mDatas = datas;
	}

	@Override
	public int getCount() {
		return mDatas != null ? mDatas.size() : 0;
	}

	@Override
	public TopicModel getItem(int position) {
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
			View view = mInflater.inflate(R.layout.list_item_topic, null);
			holder = new ViewHolder();
			holder.date = (TextView) view.findViewById(R.id.date);
			holder.title = (TextView) view.findViewById(R.id.title);
			holder.summary = (TextView) view.findViewById(R.id.summary);
			holder.thumb = (ImageView) view.findViewById(R.id.thumb);
			holder.msgs = (TextView) view.findViewById(R.id.msgs);
			view.setTag(holder);
			convertView = view;
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		TopicModel model = getItem(position);
		if (model != null) {
			holder.date.setText(model.date);
			holder.summary.setText(model.summary);
			holder.title.setText(model.title);
			holder.msgs.setText(String.valueOf(model.msgs));
		}
		
		displayImage(TestConstant.IMAGES[position], holder.thumb);
		return convertView;
	}

	class ViewHolder {
		TextView title;
		TextView summary;
		TextView date;
		TextView msgs;
		ImageView thumb;
	}
}
