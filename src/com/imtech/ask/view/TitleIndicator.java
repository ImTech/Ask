/*
 * @project : Ask
 * @author  : huqiming 
 * @date    : 2013-6-9
 */
package com.imtech.ask.view;

import java.util.ArrayList;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.imtech.ask.R;

/**
 * 标题指示器
 */
public class TitleIndicator extends LinearLayout implements OnClickListener {
	private static final String TAG = "TitleIndicator";
	private OnIndicatorListener mListener;
	private Drawable mNormalDrawable;
	private Drawable mSelectDrawable;
	private float mTextSize;
	private int mTextColor;
	private Context mContext;
	private IndicatorItem mCurrSelect;
	private ArrayList<IndicatorItem> mItems;

	public TitleIndicator(Context context) {
		this(context, null);
	}

	public TitleIndicator(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		if (attrs != null) {
			TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TitleIndicator);
			mTextColor = a.getColor(R.styleable.TitleIndicator_indicatorTextColor, 0xffffff);
//			mTextSize = a.getDimension(R.styleable.TitleIndicator_indicatorTextSize, 16);
			mTextSize = a.getDimensionPixelSize(R.styleable.TitleIndicator_indicatorTextSize, 2);
			mNormalDrawable = a.getDrawable(R.styleable.TitleIndicator_normalDrawable);
			mSelectDrawable = a.getDrawable(R.styleable.TitleIndicator_selectDrawable);
			a.recycle();
		}

		initView(context);
		mItems = new ArrayList<TitleIndicator.IndicatorItem>(5);
	}

	private void initView(Context context) {
		setOrientation(HORIZONTAL);
	}

	public void resetSelectItem() {
		if (mCurrSelect != null) {
			mCurrSelect.itemView.setBackgroundDrawable(mNormalDrawable);
			mCurrSelect = null;
		}
	}

	public void setIndicator(int pos) {
		resetSelectItem();
		IndicatorItem item = pos < mItems.size() ? mItems.get(pos) : null;
		if (item != null) {
			item.itemView.setBackgroundDrawable(mSelectDrawable);
			mCurrSelect = item;
		}
	}

	public void addItem(IndicatorItem item) {
		if (item != null) {
			View itemView = createItemView(item);
			LayoutParams params = createItemParams();
			addView(itemView, params);
			item.itemView = itemView;
			item.pos = mItems.size();
			mItems.add(item);
		}
	}

	private View createItemView(IndicatorItem item) {
		Button btn = new Button(mContext);
		btn.setText(item.text);
		btn.setPadding(0, 0, 0, 0);
		btn.setTextColor(mTextColor);
		btn.setTextSize(mTextSize);
		btn.setBackgroundDrawable(mNormalDrawable);
		btn.setTag(item);
		btn.setSingleLine(true);
		btn.setGravity(Gravity.CENTER);
		btn.setOnClickListener(this);
		return btn;
	}

	private LayoutParams createItemParams() {
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		params.weight = 1;
		params.gravity = Gravity.TOP;
		params.setMargins(4, 10, 4, 4);
		return params;
	}

	public void addItem(String text, int id) {
		IndicatorItem item = new IndicatorItem(text, id);
		addItem(item);
	}

	public void addItem(int textResId, int id) {
		String text = getResources().getString(textResId);
		addItem(text, id);
	}

	public void setIndicatorListener(OnIndicatorListener listener) {
		mListener = listener;
	}

	public static class IndicatorItem {
		public String text;
		public int id;
		private View itemView;
		private int pos;

		public IndicatorItem(String text, int id) {
			this.text = text;
			this.id = id;
		}
	}

	public interface OnIndicatorListener {
		void onIndicatorChanged(IndicatorItem selectItem);
	}

	@Override
	public void onClick(View v) {
		Object obj = v.getTag();
		if (mListener != null && obj != null && obj instanceof IndicatorItem) {
			IndicatorItem item = (IndicatorItem) obj;
			if (!item.equals(mCurrSelect)) {
				setIndicator(item.pos);
				mListener.onIndicatorChanged(item);
			}
		}
	}
}
