/**
 * douzifly @2013-6-7
 * github.com/douzifly
 * douzifly@gmail.com
 */
package com.imtech.ask.ui.home;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imtech.ask.R;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

/**
 * Fragment for display scrollable images
 * @author douzifly
 *
 */
public class BannerFragment extends Fragment{
    
    final static String TAG = "ASK_UI_CoverFragment";
    
    private ViewPager mViewPager;
    private PageIndicator mIndicator;
    private BannerAdapter mAdapter;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_banner, null);
        setupView(v);
        return v;
    }
    
    private void setupView(View root){
        Log.d(TAG, "setupView");
        mViewPager = (ViewPager) root.findViewById(R.id.viewPager);
        mIndicator = (PageIndicator) root.findViewById(R.id.coverPageIndicator);
        mAdapter = new BannerAdapter();
        mViewPager.setAdapter(mAdapter);
        
        List<Banner> banners = new ArrayList<Banner>();
        banners.add(new Banner("", getResources().getDrawable(R.drawable.bg_banner_demo)));
        banners.add(new Banner("", getResources().getDrawable(R.drawable.bg_banner_demo)));
        banners.add(new Banner("", getResources().getDrawable(R.drawable.bg_banner_demo)));
        mAdapter.setBanner(banners);
        mIndicator.setViewPager(mViewPager);
    }
    
    
    
}
