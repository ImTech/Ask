/*
 * @project : Ask
 * @author  : huqiming 
 * @date    : 2013-6-9
 */
package com.imtech.ask.ui;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.imtech.ask.R;
import com.viewpagerindicator.IconPagerAdapter;

/**
 * @author douzifly
 * @date 20130609
 * supply data for banner
 */
public class BannerAdapter extends PagerAdapter implements IconPagerAdapter{
	
	private List<Banner> mBanners;
	
	public void setBanner(List<Banner> banners){
		mBanners = banners;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mBanners == null ? 0 : mBanners.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ImageView view = new ImageView(container.getContext());
		container.addView(view);
		Drawable bmp = mBanners.get(position).getDrawable();
		if(bmp != null){
			view.setImageDrawable(bmp);
		}
		return view;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View)object);
	}

	@Override
	public int getIconResId(int index) {
		return R.drawable.indicator_circle;
	}
	
}
