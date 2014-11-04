package com.rudolfmedia.danrudolf.omegacleaning;

/**
 * Created by danRudolf on 7/21/14.
 */

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Parcelable;

import java.util.Locale;

/**
 * A {@link android.support.v13.app.FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends android.support.v13.app.FragmentStatePagerAdapter {

	protected Context mContext;

	public SectionsPagerAdapter(Context context, FragmentManager fm) {
		super(fm);
		mContext = context;
	}

	@Override
	public Fragment getItem(int position) {
		Fragment tabFrag = new Fragment();
		// getItem is called to instantiate the fragment for the given page.
		// Return a PlaceholderFragment (defined as a static inner class below).

		switch (position){
			case 0:
				tabFrag = new PlaceHolder();
				break;
			case 1:
				tabFrag = new  ContactFragment();
				break;
			case 2:
				tabFrag = new QuoteFragment();
		}
		return tabFrag;
	}

	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		Locale l = Locale.getDefault();
		switch (position) {
			case 0:
				return mContext.getString(R.string.title_tab1).toUpperCase(l);
			case 1:
				return mContext.getString(R.string.title_tab2).toUpperCase(l);
			case 2:
				return mContext.getString(R.string.title_tab3).toUpperCase();

		}
		return null;
	}

	@Override
	public Parcelable saveState()
	{
		return null;
	}
}