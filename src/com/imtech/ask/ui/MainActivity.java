package com.imtech.ask.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;

import com.imtech.ask.R;
import com.imtech.ask.ui.IDockFragment.DockListener;
import com.imtech.ask.ui.home.HomeFragment;
import com.imtech.ask.ui.news.NewsFragment;

public class MainActivity extends FragmentActivity{
    
	final static String TAG = "ASK_UI_MainActivity";

	private MainPageFramework mPageFramwork;
	private IDockFragment mDockFragment;
	private View mCenterContainer;
	private boolean mIsViewAjusted = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupView();
	}
	
	private void setupView(){
		
		FragmentManager fm = getSupportFragmentManager();
		mDockFragment = (IDockFragment) fm.findFragmentById(R.id.dockFragment);
		mDockFragment.setDockListener(new DockListener() {
			
			@Override
			public void onDockItemClicked(int position) {
				mPageFramwork.showFragment(position);
			}
			
			@Override
			public void onDockCenterItemClicked() {
				mPageFramwork.showHomeFragment();
			}
		});
		
		
		// init framwork
	    mPageFramwork = new MainPageFramework(this);
	    mPageFramwork.setContainer(R.id.mainCenterContainer);
	    HomeFragment home = new HomeFragment();
	    mPageFramwork.setHomeFragment(home);
	    mPageFramwork.showHomeFragment();
	    
	    NewsFragment news = new NewsFragment();
	    mPageFramwork.addModule(news);
	    
	    NewsFragment news1 = new NewsFragment();
	    mPageFramwork.addModule(news1);
	    
	    NewsFragment news2 = new NewsFragment();
	    mPageFramwork.addModule(news2);
	    
	    NewsFragment news3 = new NewsFragment();
	    mPageFramwork.addModule(news3);
	    
	    mCenterContainer = findViewById(R.id.mainCenterContainer);
	 
	    mCenterContainer.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			@Override
			public void onGlobalLayout() {
				Log.d(TAG, "onGlobalLayout");
				ajustView();
			}
		});
	}
	
	
	/**
	 * ajust height of center container view
	 */
	private void ajustView(){
		if(mIsViewAjusted) return;
		int marginBottom = mDockFragment.getBarHeight();
		if(marginBottom > 0){
			mIsViewAjusted = true;
		}
		Log.d(TAG, "adjustView marginBottom:" + marginBottom);
		RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams)mCenterContainer.getLayoutParams();
		lp.setMargins(0, 0, 0, marginBottom);
		mCenterContainer.requestLayout();
	}




}
