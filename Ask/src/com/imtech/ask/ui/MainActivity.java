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
import com.imtech.ask.ui.IPageFramework.OnFragmentChangedListener;
import com.imtech.ask.ui.ask.AskFragment;
import com.imtech.ask.ui.home.HomeFragment;
import com.imtech.ask.ui.message.MessageFragment;
import com.imtech.ask.ui.news.NewsFragment;
import com.imtech.ask.ui.topic.TopicFragment;
import com.imtech.ask.ui.user.UserFragment;

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
				mPageFramwork.showAskFragment();
			}
		});
		
		// init framwork
	    mPageFramwork = new MainPageFramework(this);
	    mPageFramwork.setOnFragmentChangedListener(new OnFragmentChangedListener() {
            
            @Override
            public void onFragmentChanged(BaseFragment newFragment) {
                int pos = DockFragment.POSITION_INVALID;
                String id = newFragment.getModuleId();
                if(id.equals(ModuleConfig.MODULE_NEWS_ID)){
                    pos = 0;
                }else  if(id.equals(ModuleConfig.MODULE_TOPIC_ID)){
                    pos = 1;
                }else  if(id.equals(ModuleConfig.MODULE_MSG_ID)){
                    pos = 2;
                }else  if(id.equals(ModuleConfig.MODULE_USER_ID)){
                    pos = 3;
                }
                
                mDockFragment.setSelected(pos);
                
            }
        });
	    
	    
	    mPageFramwork.setContainer(R.id.mainCenterContainer);
	    HomeFragment home = new HomeFragment();
	    mPageFramwork.setHomeFragment(home);
	    AskFragment ask = new AskFragment();
	    mPageFramwork.setAskFragment(ask);
	    mPageFramwork.showHomeFragment();
	    
	    NewsFragment news = new NewsFragment();
	    mPageFramwork.addModule(news);
	    
	    TopicFragment topic = new TopicFragment();
	    mPageFramwork.addModule(topic);
	    
	    MessageFragment msg = new MessageFragment();
	    mPageFramwork.addModule(msg);
	    
	    UserFragment user = new UserFragment();
	    mPageFramwork.addModule(user);
	    
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
