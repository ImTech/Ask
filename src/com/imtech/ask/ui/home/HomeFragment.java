/**
 * douzifly @2013-6-7
 * github.com/douzifly
 * douzifly@gmail.com
 */
package com.imtech.ask.ui.home;

import android.os.Bundle;
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
        return inflater.inflate(R.layout.home, null);
    }
    
}
