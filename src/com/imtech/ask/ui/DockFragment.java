/**
 * douzifly @2013-6-6
 * github.com/douzifly
 * douzifly@gmail.com
 */
package com.imtech.ask.ui;

import com.imtech.ask.R;
import com.imtech.ask.ui.IDockFragment.DockListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author douzifly
 *
 */
public class DockFragment extends Fragment implements IDockFragment{
    
    private DockListener mLisenter;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dock, null);
        return v;
    }

    @Override
    public void setDockListener(DockListener l) {
        mLisenter = l;
    }

    @Override
    public void setSelected(int position) {
    }
    
}
