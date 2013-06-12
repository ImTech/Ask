/**
 * douzifly @2013-6-7
 * github.com/douzifly
 * douzifly@gmail.com
 */
package com.imtech.ask.ui.home;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.imtech.ask.R;
import com.imtech.ask.ui.BaseFragment;
import com.imtech.ask.ui.IPageFramework;
import com.imtech.ask.ui.ModuleConfig;

/**
 * @author douzifly
 *
 */
public class HomeFragment extends BaseFragment implements OnClickListener{
    
    final static String TAG = "ASK_UI_HomeFragment";
    private View mBtnNews;
    private View mBtnAsk;
    
    @Override
    public View onCreateContentView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View root = inflater.inflate(R.layout.fragment_home, null);
        setupView(root);
        
        View title = inflater.inflate(R.layout.top_bar_home_title, null);
        getTopBar().setLeftView(title, null);
        return root;
    }
    
    private void setupView(View root){
    	FragmentManager fm = getFragmentManager();
    	FragmentTransaction tran = fm.beginTransaction();
    	tran.add(R.id.homeCoverContainer, new BannerFragment());
    	tran.commit();
    	
    	mBtnNews = root.findViewById(R.id.homeBtnNews);
    	mBtnAsk = root.findViewById(R.id.homeBtnTopic);
    	
    	mBtnAsk.setOnClickListener(this);
    	mBtnNews.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		IPageFramework pageFramework = getPageFramework();
		if(pageFramework == null){
			Log.d(TAG, "pageFramework is null");
			return;
		}
		switch (v.getId()) {
		case R.id.homeBtnNews:
			pageFramework.showFragment(ModuleConfig.MODULE_NEWS_ID);
			break;
		case R.id.homeBtnTopic:
			pageFramework.showFragment(ModuleConfig.MODULE_TOPIC_ID);
			break;

		default:
			break;
		}
	}
    
}
