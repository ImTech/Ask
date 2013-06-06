/**
 * douzifly @2013-6-7
 * github.com/douzifly
 * douzifly@gmail.com
 */
package com.imtech.ask.ui;

import java.util.ArrayList;
import java.util.List;

import com.imtech.ask.R;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment for display scrollable images
 * @author douzifly
 *
 */
public class CoverFragment extends Fragment{
    
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
        mViewPager = (ViewPager) root.findViewById(R.id.viewPager);
    }
    
    
    
}
