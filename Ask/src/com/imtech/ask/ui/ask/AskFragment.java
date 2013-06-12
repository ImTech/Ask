/**
 * douzifly @2013-6-12
 * github.com/douzifly
 * douzifly@gmail.com
 */
package com.imtech.ask.ui.ask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.imtech.ask.R;
import com.imtech.ask.ui.BaseFragment;
import com.imtech.ask.ui.ModuleConfig;
import com.imtech.ask.view.TopBar;

/**
 * @author douzifly
 *
 */
public class AskFragment extends BaseFragment{

    @Override
    public String getModuleId() {
        return ModuleConfig.MODULE_ASK_ID;
    }
    
    @Override
    public String getModuleName() {
        return "提问";
    }
    
    @Override
    public View onCreateContentView(LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ask, null);
        getTopBar().setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                if(v.getId() == TopBar.ID_LEFT_ICON){
                    showFragment(ModuleConfig.MODULE_HOME_ID);
                }
            }
        });
        return root;
    }
    
}
