/*
 * @project :Ask
 * @auther  :huqiming 
 * @date    :2013-6-11
 */
package com.imtech.ask.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.imtech.ask.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * 异步加载图片的Adapter
 */
public class ImageLoadAdapter extends BaseAdapter implements ImageLoadingListener {
	protected DisplayImageOptions mOptions;
	protected ImageLoader mImageLoader = ImageLoader.getInstance();

	public ImageLoadAdapter() {
		buildOptions();
	}

	protected void buildOptions() {
		mOptions = new DisplayImageOptions.Builder().showStubImage(R.drawable.ic_stub)
				.showImageForEmptyUri(R.drawable.ic_empty).showImageOnFail(R.drawable.ic_error).cacheInMemory()
				.cacheOnDisc().displayer(new RoundedBitmapDisplayer(20)).build();
	}

	public void displayImage(String uri, ImageView imageView) {
		mImageLoader.displayImage(uri, imageView, mOptions, this);
	}

	@Override
	public int getCount() {
		return 0;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return null;
	}

	@Override
	public void onLoadingStarted(String imageUri, View view) {
	}

	@Override
	public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
	}

	@Override
	public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
		if (view instanceof ImageView) {
			((ImageView) view).setImageBitmap(loadedImage);
		}
	}

	@Override
	public void onLoadingCancelled(String imageUri, View view) {
	}

}
