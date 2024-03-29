package com.example.adapter;

import com.example.fragment.AccessoriesFragment;
import com.example.fragment.GiftsFragment;
import com.example.fragment.TabletsFragment;
import com.example.fragment.PhonesFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Phones fragment activity
			return new PhonesFragment();
		case 1:
			// Tablets fragment activity
			return new TabletsFragment();
		case 2:
			// Accessories fragment activity
			return new AccessoriesFragment();
		case 3:
			// Gifts fragment activity
			return new GiftsFragment();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 4;
	}

}
