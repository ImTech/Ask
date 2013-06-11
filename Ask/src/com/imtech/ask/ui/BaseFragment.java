/**
 * douzifly @2013-6-7
 * github.com/douzifly
 * douzifly@gmail.com
 */
package com.imtech.ask.ui;

import com.imtech.ask.R;
import com.imtech.ask.view.TopBar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * @author douzifly
 *
 */
public class BaseFragment extends Fragment{
	
	final static String TAG = "ASK_UI_BaseFragment";
	private IPageFramework mPageFramework;
	private TopBar mTopBar;
	private FrameLayout mContentContainer;
	
	public TopBar getTopBar(){
		return mTopBar;
	}
	
	public String getModuleId(){
		return "";
	}
	
	public void setPageFramework(IPageFramework f){
		mPageFramework = f;
	}
	
	public IPageFramework getPageFramework(){
		return mPageFramework;
	}
	
	public String getModuleName(){
		return "";
	}
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_base, null);
		mTopBar = (TopBar) root.findViewById(R.id.baseTopBar);
		mContentContainer = (FrameLayout) root.findViewById(R.id.baseContent);
		mTopBar.setDisplayMode(TopBar.DISPLAY_MODE_ICON, TopBar.DISPLAY_MODE_NONE);
		View content = onCreateContentView(inflater, container, savedInstanceState);
		if(content == null){
			throw new RuntimeException("onCreateContentView must return your custom view");
		}
		mContentContainer.addView(content, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 
				FrameLayout.LayoutParams.MATCH_PARENT));
		return root;
	}
	
	public View onCreateContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		return null;
	}
	
	@Override
	public void onDestroyView() {
//		Log.d(TAG, "onDestroyView " + this);
		super.onDestroyView();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
//		Log.d(TAG, "onCreate " + this);
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onDestroy() {
//		Log.d(TAG, "onDestroy " + this);
		super.onDestroy();
	}
	
	@Override
	public void onDetach() {
//		Log.d(TAG, "onDetach " + this);
		super.onDetach();
	}
	
	@Override
	public void onAttach(Activity activity) {
//		Log.d(TAG, "onAttach " + this);
		super.onAttach(activity);
	}
	
	public void showFragment(String id){
		if(mPageFramework == null){
			Log.e(TAG, "showFragment framework is null");
			return;
		}
		mPageFramework.showFragment(id);
	}
	
}
