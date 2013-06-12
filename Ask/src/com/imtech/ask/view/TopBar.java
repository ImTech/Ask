/*
 * @project : Ask
 * @author  : huqiming 
 * @date    : 2013-6-11
 */
package com.imtech.ask.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.imtech.ask.R;

/**
 * Application top bar
 */
public class TopBar extends FrameLayout implements OnClickListener{
	
	final static String TAG = "ASK_TopBar";

	RelativeLayout mContainer;
	FrameLayout mLeftContainer;
	FrameLayout mRightContainer;
	OnClickListener mClickListener;
	TextView mTitle;
	
	Button mRightButton;
	
	public static int ID_LEFT_ICON = 0x100;
	public static int ID_LEFT_BUTTON = 0x101;
	public static int ID_RIGHT_BUTTON = 0x102;
	
	public final static int DISPLAY_MODE_NONE = 0;
	public final static int DISPLAY_MODE_ICON = 1;
	public final static int DISPLAY_MODE_BUTTON = 2;
	
	/**
	 * @param context
	 * @param attrs
	 */
	public TopBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}
	
	private void initView(Context context){
		LayoutInflater lf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mContainer = (RelativeLayout) lf.inflate(R.layout.topbar, null);
		addView(mContainer, new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		mLeftContainer = (FrameLayout) mContainer.findViewById(R.id.topBarLeftContainer);
		mRightContainer = (FrameLayout) mContainer.findViewById(R.id.topBarRightContainer);
		mTitle = (TextView) mContainer.findViewById(R.id.topBarTitle);
	}
	
	public TopBar setTitle(String title){
		if(mTitle == null) return this;
		mTitle.setVisibility(View.VISIBLE);
		mTitle.setText(title);
		return this;
	}
	
	public TopBar setTitleVisibility(int visible){
		if(mTitle == null) return this;
		mTitle.setVisibility(visible);
		return this;
	}
	
	public TopBar setRightButtonText(CharSequence text){
		if(mRightButton == null) return this;
		mRightButton.setText(text);
		return this;
	}
	
	public TopBar setRightButtonText(int id){
		if(mRightButton == null) return this;
		mRightButton.setText(id);
		return this;
	}
	
	/**
	 * set display style of side icon
	 */
	public TopBar setDisplayMode(int left, int right){
		
		
		// left
		switch (left) {
		case DISPLAY_MODE_NONE:
			mLeftContainer.setVisibility(View.GONE);
			break;
		// not finished yet.
		case DISPLAY_MODE_ICON:
			mLeftContainer.setVisibility(View.VISIBLE);
			LayoutInflater li = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			li.inflate(R.layout.top_bar_left_icon, mLeftContainer);
			View v = mLeftContainer.findViewById(R.id.topbarLeftIcon);
			v.setId(ID_LEFT_ICON);
			v.setOnClickListener(this);
			break;
		default:
			break;
		}
		
		switch (right) {
		case DISPLAY_MODE_NONE:
			Log.d(TAG, "set right none");
			mRightContainer.setVisibility(View.GONE);
			break;
		case DISPLAY_MODE_BUTTON:
			mRightContainer.setVisibility(View.VISIBLE);
			LayoutInflater li = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			li.inflate(R.layout.top_bar_right_button, mRightContainer);
			mRightButton = (Button)mRightContainer.findViewById(R.id.topbarRightButton);
			mRightButton.setId(ID_RIGHT_BUTTON);
			mRightButton.setOnClickListener(this);
			break;
		default:
			break;
		}
		
		return this;
		
	}
	
	public TopBar setCustomeView(View v, FrameLayout.LayoutParams lp){
		if(lp == null){
			lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			lp.gravity = Gravity.CENTER_VERTICAL;
		}
		removeAllViews();
		addView(v, lp);
		return this;
	}

	public TopBar setLeftView(View v, FrameLayout.LayoutParams lp){
		if(lp == null){
			lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			lp.gravity = Gravity.CENTER_VERTICAL;
		}
		mLeftContainer.removeAllViews();
		mLeftContainer.addView(v, lp);
		return this;
	}
	
	public TopBar setRightView(View v, FrameLayout.LayoutParams lp){
		if(lp == null){
			lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			lp.gravity = Gravity.CENTER_VERTICAL;
		}
		mRightContainer.removeAllViews();
		mRightContainer.addView(v, lp);
		return this;
	}
	
	public void setOnClickListener(OnClickListener l){
		mClickListener = l;
	}

	@Override
	public void onClick(View v) {
		Log.d(TAG, "onClick v:" + v);
		if(mClickListener != null){
			mClickListener.onClick(v);
		}
	}
}
