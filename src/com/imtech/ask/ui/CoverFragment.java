/**
 * douzifly @2013-6-7
 * github.com/douzifly
 * douzifly@gmail.com
 */
package com.imtech.ask.ui;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import com.imtech.ask.R;

/**
 * Fragment for display scrollable images
 * @author douzifly
 *
 */
public class CoverFragment extends Fragment{
    
    final static String TAG = "ASK_UI_CoverFragment";
    
    private List<Bitmap> mCoverBitmaps = new ArrayList<Bitmap>();
    
    private ViewPager mViewPager;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cover, null);
        setupView(v);
        return v;
    }
    
    private void setupView(View root){
        Log.d(TAG, "setupView");
        mViewPager = (ViewPager) root.findViewById(R.id.viewPager);
        mViewPager.setBackgroundColor(Color.MAGENTA);
        mViewPager.setAdapter(new PagerAdapter() {
            
            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return true;
            }
            
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                int color = Color.RED;
                if(position == 1){
                    color = Color.YELLOW;
                }else if(position == 2){
                    color = Color.CYAN;
                }
                
                View v = new View(getActivity());
                v.setBackgroundColor(color);
                v.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                container.addView(v);
                return v;
            }
            
            @Override
            public void destroyItem(ViewGroup container, int position,
                    Object object) {
                container.removeView((View)object);
            }
            
            
            @Override
            public int getCount() {
                Log.d(TAG, "getCount");
                return 3;
            }
            
        });
    }
    
    
    
}
