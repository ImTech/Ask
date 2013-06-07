/**
 * douzifly @2013-6-7
 * github.com/douzifly
 * douzifly@gmail.com
 */
package com.imtech.ask.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author douzifly
 *
 */
public class BaseFragment extends Fragment{
	
	final static String TAG = "ASK_UI_BaseFragment";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d(TAG, "onCreateView " + this);
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onDestroyView() {
		Log.d(TAG, "onDestroyView " + this);
		super.onDestroyView();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate " + this);
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onDestroy() {
		Log.d(TAG, "onDestroy " + this);
		super.onDestroy();
	}
	
	@Override
	public void onDetach() {
		Log.d(TAG, "onDetach " + this);
		super.onDetach();
	}
	
	@Override
	public void onAttach(Activity activity) {
		Log.d(TAG, "onAttach " + this);
		super.onAttach(activity);
	}
}
