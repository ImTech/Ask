/*
 * @project : Ask
 * @author  : huqiming 
 * @date    : 2013-6-9
 */
package com.imtech.ask.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * describe banner on home view
 */
public class Banner {
	
	private String title;
	private Drawable drawable;
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the drawable
	 */
	public Drawable getDrawable() {
		return drawable;
	}

	/**
	 * @param drawable the drawable to set
	 */
	public void setDrawable(Drawable drawable) {
		this.drawable = drawable;
	}

	public Banner(){}
	
	public Banner(String t, Drawable d){
		title = t;
		drawable = d;
	}
}
