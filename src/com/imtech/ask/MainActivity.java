package com.imtech.ask;

import com.imtech.ask.ui.home.HomeFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

public class MainActivity extends FragmentActivity{
    
    private ViewGroup mFragmentContainer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupView();
	}
	
	private void setupView(){
	    mFragmentContainer = (ViewGroup)findViewById(R.id.centerContainer);
	    
	    HomeFragment home = new HomeFragment();
	    FragmentManager fm = getSupportFragmentManager();
	    FragmentTransaction tran = fm.beginTransaction();
	    tran.add(R.id.centerContainer, home);
	    tran.commit();
	}

}
