/*
 * @project : Ask
 * @author  : huqiming 
 * @date    : 2013-6-7
 */
package com.imtech.ask.ui.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imtech.ask.R;
import com.imtech.ask.ui.BaseFragment;

/**
 * 个人中心
 */
public class UserFragment extends BaseFragment {
	private static final String TAG = "UserFragment";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return initView(inflater);
	}

	private View initView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.fragment_user, null);
		return view;
	}
}
