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
import android.view.ViewGroup;

import com.imtech.ask.R;
import com.imtech.ask.ui.BaseFragment;

/**
 * @author douzifly
 *
 */
public class HomeFragment extends BaseFragment{
    
    final static String TAG = "ASK_UI_HomeFragment";
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        super.onCreateView(inflater, container, savedInstanceState);
        setupView();
        return inflater.inflate(R.layout.fragment_home, null);
    }
    
    private void setupView(){
    	FragmentManager fm = getFragmentManager();
    	FragmentTransaction tran = fm.beginTransaction();
    	tran.add(R.id.homeCoverContainer, new BannerFragment());
    	tran.commit();
    }
    
}
