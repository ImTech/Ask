/*
 * @project : Ask
 * @author  : huqiming 
 * @date    : 2013-6-7
 */
package com.imtech.ask.ui.user;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.imtech.ask.R;
import com.imtech.ask.core.TestConstant;
import com.imtech.ask.ui.BaseFragment;
import com.imtech.ask.ui.ModuleConfig;
import com.imtech.ask.view.TopBar;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * 个人中心
 */
public class UserFragment extends BaseFragment {
	private static final String TAG = "UserFragment";

	@Override
	public View onCreateContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return initView(inflater);
	}
	
	@Override
	public String getModuleId() {
		return ModuleConfig.MODULE_USER_ID;
	}
	
	@Override
	public String getModuleName() {
		return "个人中心";
	}

	private View initView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.fragment_user, null);

		TextView inteText = (TextView) view.findViewById(R.id.integration);
		inteText.setText(formatStr(R.string.integration, 1212122));

		TextView gradeText = (TextView) view.findViewById(R.id.grade);
		gradeText.setText(formatStr(R.string.grade, 454545));

		TextView rankingText = (TextView) view.findViewById(R.id.ranking);
		rankingText.setText(formatStr(R.string.ranking, 789797));

		ImageView avatar = (ImageView) view.findViewById(R.id.avatar);

		loadAvatar(avatar);
		
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

	private void loadAvatar(ImageView view) {
		ImageLoader.getInstance().displayImage(TestConstant.IMAGES[25], view);
	}

	private CharSequence formatStr(int resId, int value) {
		String str = getString(resId);
		str = String.format(str, value);
		return Html.fromHtml(str);
	}
}
