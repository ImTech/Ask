/**
 * Author:XiaoyuanLiu
 * Date: 2013-6-7
 * 深圳快播科技
 */
package com.imtech.ask.ui;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

/**
 * UI framework
 * @author XiaoyuanLiu
 *
 */
public class MainPageFramework implements IPageFramework{
	
	final static String TAG = "ASK_UI_MainPageFramework";
	
	private List<BaseFragment> mModules = new ArrayList<BaseFragment>();
	private BaseFragment mHomeFragment;
	
	private int mContainerId;
	private FragmentActivity mActiivty;
	private BaseFragment mCurrentFragment;
	
	public MainPageFramework(FragmentActivity activity){
		mActiivty = activity;
	}
	
	public void setHomeFragment(BaseFragment fragment){
		mHomeFragment = fragment;
		mHomeFragment.setPageFramework(this);
	}
	
	public void addModule(BaseFragment fragment){
		mModules.add(fragment);
		fragment.setPageFramework(this);
	}
	
	/**
	 * set the container to load fragments
	 * @param container
	 */
	public void setContainer(int containerId){
		mContainerId = containerId;
	}
	
	private void showFragment(BaseFragment next){
		
		FragmentManager fm = mActiivty.getSupportFragmentManager();
		FragmentTransaction tran = fm.beginTransaction();
		
		// prev leave
		if(mCurrentFragment != null){
			tran.hide(mCurrentFragment);
		}
		mCurrentFragment = next;
		
		if(next.isAdded()){
			Log.d(TAG, "isAdded fragemnt:" + next);
			tran.show(next);
			tran.commit();
		}else{
			tran.add(mContainerId, next);
			tran.commit();
		}
	}
	
	public void showFragment(int position){
		
		Log.d(TAG, "showFragment pos:" + position);
		if(position >= mModules.size()){
			throw new InvalidParameterException("position out of range, position:" + position 
					+ " size:" + mModules.size());
		}
		
		BaseFragment fragment = mModules.get(position);
		showFragment(fragment);
	}
	
	public void showHomeFragment(){
		Log.d(TAG, "showHomeFragment");
		if(mHomeFragment == null){
			throw new InvalidParameterException("home fragment is null");
		}
		showFragment(mHomeFragment);
	}
	
	public void showFragment(String tag){
		Log.d(TAG, "showFragment tag:" + tag);
		if(tag.equals(ModuleConfig.MODULE_HOME_ID)){
			showHomeFragment();
			return;
		}
		for(int i = 0, j = mModules.size(); i < j; i++){
			BaseFragment f = mModules.get(i);
			if(tag.equals(f.getModuleId())){
				showFragment(f);
				break;
			}
		}
	}
}
